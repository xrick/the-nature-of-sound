(ns the-nature-of-sound.core
  (:require [clojure.java.io :as io]
            [dynne.sampled-sound :as ssample])
  (:import [xtract]
           [xtractJNI]
           [xtract_mel_filter]
           [xtract_features_]
           [xtract_window_types_]
           [xtract_spectrum_]
           [xtract_subband_scales_]
           [xtract_return_codes_]
           [xtractConstants]

          [javax.sound.sampled AudioSystem]))

(defonce xtract-spectrum         (.swigValue (xtract_features_/XTRACT_SPECTRUM)))
(defonce xtract-windowed         (.swigValue (xtract_features_/XTRACT_WINDOWED)))
(defonce xtract-bark-coefficents (.swigValue (xtract_features_/XTRACT_BARK_COEFFICIENTS)))

(defonce xtract-bark-bands         (xtractConstants/XTRACT_BARK_BANDS))
(defonce xtract-hann               (.swigValue (xtract_window_types_/XTRACT_HANN)))
(defonce xtract-equal-gain         (.swigValue (xtract_mfcc_types_/XTRACT_EQUAL_GAIN)))
(defonce xtract-spectrum-magnitude (.swigValue (xtract_spectrum_/XTRACT_MAGNITUDE_SPECTRUM)))
(defonce xtract-linear-subbands    (.swigValue (xtract_subband_scales_/XTRACT_LINEAR_SUBBANDS)))

(defonce xtract-success           (.swigValue (xtract_return_codes_/XTRACT_SUCCESS)))
(defonce xtract-malloc-fail       (.swigValue (xtract_return_codes_/XTRACT_MALLOC_FAILED)))
(defonce xtract-bad-argv          (.swigValue (xtract_return_codes_/XTRACT_BAD_ARGV)))
(defonce xtract-bad-vec-size      (.swigValue (xtract_return_codes_/XTRACT_BAD_VECTOR_SIZE)))
(defonce xtract-bad-state         (.swigValue (xtract_return_codes_/XTRACT_BAD_STATE)))
(defonce xtract-denormal-found    (.swigValue (xtract_return_codes_/XTRACT_DENORMAL_FOUND)))
(defonce xtract-no-result         (.swigValue (xtract_return_codes_/XTRACT_NO_RESULT)))
(defonce xtract-feature-not-found (.swigValue (xtract_return_codes_/XTRACT_FEATURE_NOT_IMPLEMENTED)))
(defonce xtract-argument-error    (.swigValue (xtract_return_codes_/XTRACT_ARGUMENT_ERROR)))

(def MFCC_FREQ_BANDS    13)
(def MFCC_FREQ_MIN      20)
(def MFCC_FREQ_MAX      20000)
(def NUM_HARMONICS      10)
(def MFCC_FREQ_BANDS    13)
(def DEFAULT_BLOCK_SIZE 512)

(defn- double->clojure [vs len]
  (map-indexed
   (fn [idx v] (xtract/double_array_getitem vs idx))
   (range 0 len)))

(defn- clojure->c-double [vs]
  (let [len (count vs)
        xtract-vs (xtract/new_double-array len)]
    (doall
     (map-indexed
      (fn [idx v] (xtract/double_array_setitem xtract-vs idx v))
      vs))
    xtract-vs))

(defn- c-double [len]
  (let [xtract-vs (xtract/new_double-array len)]
    (doall
     (map-indexed
      (fn [idx f] (xtract/double_array_setitem xtract-vs idx (double 0.0)))
      (range 0 len)))
    xtract-vs))

(defn- xtract-args [& args] (xtract/doublea_to_voidp (clojure->c-double args)))

(defn with-result
  ([xtract-fn] (with-result (double-array [0]) xtract-fn))
  ([r xtract-fn]
   (xtract-fn r)
   (first (vec r))
   ))

(defn mean [vs]
  (let [result (double-array 1)
        len (count vs)
        xtract-vs (xtract/new_double-array len)]
    (doall
     (map-indexed
      (fn [idx f] (xtract/double_array_setitem xtract-vs idx (double f)))
      vs))
    (xtract/xtract_mean xtract-vs len nil result)
    (xtract/delete_double_array xtract-vs)
    (double (first result))))

(defn variance [vs argv]
  (let [result (double-array 1)
        len (count vs)
        xtract-vs (clojure->c-double vs)]
    (xtract/xtract_variance xtract-vs len (xtract/doublea_to_voidp argv) result)
    (xtract/delete_double_array xtract-vs)
    (double (first result))))

(defn spectrum [vs sample-rate]
  (let [len (count vs)
        argv (clojure->c-double [(double sample-rate)])
        xtract-vs (clojure->c-double vs)
        result (clojure->c-double (double-array len))]

    (when (= 0 (mod len 2)) ;;FFT only works when divisible by 2
      (xtract/xtract_init_fft len xtract-spectrum)
      (xtract/xtract_spectrum xtract-vs len (xtract/doublea_to_voidp argv) result)
      (xtract/delete_double_array xtract-vs)

      (let [r (double->clojure result len)]
        (xtract/delete_double_array result)
        r))))

(defn features-from-subframes [vs window-size window-type]
  (let [len (count vs)
        xtract-vs (clojure->c-double vs)
        window (xtract/xtract_init_window window-size window-type)
        result (clojure->c-double (double-array len))]

    (xtract/xtract_features_from_subframes xtract-vs
                                           len
                                           xtract-windowed
                                           (xtract/doublea_to_voidp window)
                                           result)
    (let [r (double->clojure result len)]
      (xtract/delete_double_array xtract-vs)
      (xtract/delete_double_array result)
      (xtract/xtract_free_window window)
      r)))

(defn sample-rate [sample-path]
  (let [file                 (io/file sample-path)
        base-file-format     (-> file  AudioSystem/getAudioFileFormat .getFormat)
        file-sample-rate     (.getSampleRate base-file-format)]
    file-sample-rate))

(defn extract-spectral-inharmonicity
  [peaks-data block-size f0]
  (if (> f0 0.0)
    (with-result
      (fn [r] (xtract/xtract_spectral_inharmonicity peaks-data block-size (xtract-args f0) r)))
    0.0))

(defn extract-fundemental-frequency [wav-data block-size sample-rate]
  (let [r (double-array 1)]
    (xtract/xtract_wavelet_f0 wav-data block-size (xtract-args sample-rate) r)

;;    (when (> (first r) 0.0) (println :---------------------> (first r)))
    (first r)
    )
)

(defn extract-spectrum
  "Extract frequency domain spectrum from time domain signal"
  ([windowed-data block-size sample-ratio spectrum-type]
   (extract-spectrum windowed-data block-size sample-ratio spectrum-type 0.0 0.0))
  ([windowed-data block-size sample-ratio spectrum-type db-component normalised]

   (let [spectrum (c-double block-size)]
     (xtract/xtract_spectrum windowed-data
                             block-size (xtract-args sample-ratio
                                                     spectrum-type
                                                     db-component
                                                     normalised)
                             spectrum)
     spectrum)))

(defn extract-fft-spectrum [wave-data block-size sample-rate full-window]
  (let [windowed (c-double block-size)]
    (xtract/xtract_windowed wave-data block-size (xtract/doublea_to_voidp full-window) windowed)
    (xtract/xtract_init_fft block-size xtract-spectrum)
    (let [spectrum (extract-spectrum windowed block-size (/ sample-rate block-size) xtract-spectrum-magnitude)]
      (xtract/xtract_free_fft)
      (xtract/delete_double_array windowed)
      spectrum)))

(defn extract-peaks
  "Extract the amplitude and frequency of spectral peaks from a magnitude spectrum"
  [coefficients block-size sample-ratio peak-threshold]
  (let [peaks (c-double block-size)]
    (xtract/xtract_peak_spectrum coefficients
                                 (/ block-size 2)
                                 (xtract-args sample-ratio peak-threshold)
                                 peaks)
    peaks))

(defn extract-rms-amp
  "Extract the RMS amplitude of an input vector"
  [wav-data block-size sample-ratio]
  (let [rms (double-array 1)]
    (xtract/xtract_rms_amplitude wav-data block-size (xtract-args sample-ratio) rms)
    rms))

(defn raise-errors [result]
    (cond
      (= result xtract-success)        true
      (= result xtract-bad-argv)       (throw (Exception. "Bad argv error"))
      (= result xtract-argument-error) (throw (Exception. "Bad arguments error"))
      true (throw (Exception. "Unknown result type"))))

(defn frequency->cents [f0]
  (if (= 0.0 f0)
    0.0
    (let [cents (double-array 1)]
      (let [r (xtract/xtract_midicent nil 0 (xtract-args f0) cents)]
        (raise-errors r)
        (first cents)))))


(defn frame-stats
  ([sample-path] (frame-stats sample-path DEFAULT_BLOCK_SIZE))
  ([sample-path block-size]

   (let [SAMPLE_RATE (sample-rate sample-path)
         half-block-size (/ block-size 2)
         SAMPLE_RATE_RATIO (/ SAMPLE_RATE block-size)

         s           (ssample/read-sound sample-path)
         data-chunks (ssample/chunks s SAMPLE_RATE)
         ;;TODO: Merging channels?
         ;;with sliding window, overlap
         data (partition block-size half-block-size (mapcat (fn [bit] bit) (flatten (flatten data-chunks))))         ;;seperate
         ;;data (partition block-size (mapcat (fn [bit] bit) (flatten (flatten data-chunks))))
         mel-filters  (xtract/create_filterbank  MFCC_FREQ_BANDS block-size)

         ;;bark-band-limits (xtract/new_int_array 0)
         ;;  _ (xtract/int_array_setitem bark-band-limits 0 0)
         ]

     (xtract/xtract_init_mfcc half-block-size
                              (/ SAMPLE_RATE 2)
                              xtract-equal-gain
                              MFCC_FREQ_MIN
                              MFCC_FREQ_MAX
                              MFCC_FREQ_BANDS
                              (xtract_mel_filter/.getFilters mel-filters))


     ;;public static int xtract_init_bark(int N, double sr, SWIGTYPE_p_int band_limits) {
     ;;(xtract/xtract_init_bark block-size SAMPLERATE bark-band-limits)
     ;;(println (xtract/int_array_getitem bark-band-limits 0))

     (let [full-window (xtract/xtract_init_window block-size xtract-hann)
           half-window (xtract/xtract_init_window half-block-size xtract-hann)]

       (xtract/xtract_init_wavelet_f0_state)

       (let [stats
             (map-indexed
              (fn [idx v]


;;                (println v)
                (let [wav-data (clojure->c-double v)
                      f0       (extract-fundemental-frequency wav-data block-size SAMPLE_RATE)
                      cents    (frequency->cents f0)
                      midi     (if (> f0 0.0)
                                 (Integer/parseInt (format "%.0f" (/ cents 100)))
                                 0)

                      spectrum               (extract-fft-spectrum wav-data block-size SAMPLE_RATE full-window)
                      peaks                  (extract-peaks spectrum block-size SAMPLE_RATE_RATIO 10.0)
                      spectral-inharmonicity (extract-spectral-inharmonicity peaks block-size f0)

                      rms                    (extract-rms-amp wav-data block-size SAMPLE_RATE_RATIO)

                      spectral-irregularity (double-array [0])
                      spectral-centroid     (double-array [0])
                      spectral-variance     (double-array [0])

                      ;;TODO
                      noiseness             (double-array [0])
                      loudness              (double-array [0])
                      tonality              (double-array [0])]



                  (xtract/xtract_spectral_centroid spectrum block-size (xtract-args 0.0) spectral-centroid)
                  (xtract/xtract_irregularity_j    spectrum half-block-size nil spectral-irregularity)

                  (let [spectral-skewness      (double-array [0])
                        spectral-std-deviation (double-array [0])
                        spectral-mean          (double-array [0])
                        spectral-kurtosis      (double-array [0])]

                    (xtract/xtract_spectral_mean spectrum block-size nil spectral-mean)
                    (xtract/xtract_variance spectrum block-size (xtract-args (first spectral-mean)) spectral-variance)
                    (xtract/xtract_spectral_standard_deviation spectrum block-size (xtract-args (first spectral-variance)) spectral-std-deviation)

                    (let [argv (xtract-args (first spectral-mean) (first spectral-std-deviation))]
                      (xtract/xtract_spectral_skewness spectrum block-size argv spectral-skewness)
                      (xtract/xtract_spectral_kurtosis spectrum block-size argv spectral-kurtosis))

                    ;;(xtract/xtract_noisiness     wav-data block-size (xtract-args NUM_HARMONICS ) noiseness)

                    (let [_ 10
                          ;;bark-cofficents (clojure->c-double (range 0 xtract-bark-bands))
                          ]

                      ;;(xtract/xtract_bark_coefficients spectrum half-block-size (xtract-args ) bark-cofficents)
                      ;;(xtract/xtract_loudness      wav-data block-size (apply xtract-args argv) loudness)
                      )

                    ;;TODO
                    ;;(xtract/xtract_tonality      wav-data block-size (xtract-args ) tonality)

                    ;;TODO: More memory, probably slower... Re-using variables faster but sad
                    (xtract/delete_double_array wav-data)
                    (xtract/delete_double_array spectrum)
                    (xtract/delete_double_array peaks)

                    {
                     (format "%.6f" (/  (* idx half-block-size) SAMPLE_RATE))

                     {:spectral-inharmonicity spectral-inharmonicity
                      :spectral-irregularity  (first spectral-irregularity)
                      :spectral-centroid      (first spectral-centroid)
                      :spectral-skewness      (first spectral-skewness)
                      :spectral-kurtosis      (first spectral-kurtosis)
                      :rms-amplitude          (first rms)

                      :todo {:noisiness (first noiseness)
                             :loudness (first loudness)
                             :tonality (first tonality)}
                      :midi midi
                      :f0 f0}
                     }
                    )))
              data)]

         (xtract/xtract_free_window full-window)
         (xtract/xtract_free_window half-window)
         (xtract/destroy_filterbank mel-filters)

         (vec (flatten stats))
         )))))


(defn global-stats-reduce [fields]
  (fn [acc frame]
    (let [frame-stats (first (vals frame))]
      (reduce
       (fn [local-acc field]
         (let [v (get frame-stats field)
               v (if (and (= (type v) Double) (.isNaN v))
                   0.0
                   v)]

           (assoc local-acc field
                  (+ (get local-acc field 0.0)
                     v))))
       acc
       fields))))

(defn global-stats [frame-stats]
  (let [n (count frame-stats)
        fields (-> frame-stats first vals first (dissoc :todo) keys)
        totals (reduce (global-stats-reduce fields) {} frame-stats)

        f0-frames (remove (fn [frame] (let [stats (first (vals frame))]
                                        (= (:f0 stats) 0.0)
                                       )) frame-stats)
        n-f0s (count f0-frames)
        f0-totals (reduce (global-stats-reduce fields) {} f0-frames)]

    (-> {}
        (assoc :rms-amplitude-mean          (/ (:rms-amplitude totals) n))
        (assoc :spectral-centroid-mean      (/ (:spectral-centroid totals) n))
        (assoc :spectral-irregularity-mean  (/ (:spectral-irregularity totals) n))
        (assoc :spectral-kurtosis-mean      (/ (:spectral-kurtosis totals) n))

        ;;Only over non 0 frequencies
        (assoc :spectral-inharmonicity-mean (/ (:spectral-inharmonicity f0-totals) n-f0s))
        (assoc :midi-mean (/ (:midi f0-totals) n-f0s))
        (assoc :f0-mean   (/ (:f0 f0-totals) n-f0s))
        )))

(comment
  (dotimes [i 1]
    (let [frame-stats (frame-stats "test/fixtures/test.wav")]
      (doseq [frame frame-stats] (println frame))
      (println :global (global-stats frame-stats))
      ))

  (let [m (mean [1 2 4 8 10 12 14 16])
        v (variance [1 2 4 8 10 12 14 16] (clojure->c-double [m]))
        spec (spectrum [1 2 4 8 10 12 14 16] (/ 44100.0 8))
        sub (features-from-subframes [1 2 4 8 10 12 14 16]
                                     (/ 8 2)
                                     xtract-hann)]

    (println (str "Mean:" m))
    (println (str "Var:" v))
    (println (str "Spectrum: " (pr-str spec)))
    (println (str "Features from subframes (window 4, hann): " (pr-str sub)))
    )
  )
