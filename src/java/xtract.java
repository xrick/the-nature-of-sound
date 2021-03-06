/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class xtract implements xtractConstants {
  public static SWIGTYPE_p_double new_double_array(int nelements) {
    long cPtr = xtractJNI.new_double_array(nelements);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public static void delete_double_array(SWIGTYPE_p_double ary) {
    xtractJNI.delete_double_array(SWIGTYPE_p_double.getCPtr(ary));
  }

  public static double double_array_getitem(SWIGTYPE_p_double ary, int index) {
    return xtractJNI.double_array_getitem(SWIGTYPE_p_double.getCPtr(ary), index);
  }

  public static void double_array_setitem(SWIGTYPE_p_double ary, int index, double value) {
    xtractJNI.double_array_setitem(SWIGTYPE_p_double.getCPtr(ary), index, value);
  }

  public static SWIGTYPE_p_void doublea_to_voidp(SWIGTYPE_p_double f) {
    long cPtr = xtractJNI.doublea_to_voidp(SWIGTYPE_p_double.getCPtr(f));
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public static xtract_function_descriptor_t get_descriptor(xtract_function_descriptor_t fd, int i) {
    long cPtr = xtractJNI.get_descriptor(xtract_function_descriptor_t.getCPtr(fd), fd, i);
    return (cPtr == 0) ? null : new xtract_function_descriptor_t(cPtr, false);
  }

  public static xtract_mel_filter create_filterbank(int n_filters, int blocksize) {
    long cPtr = xtractJNI.create_filterbank(n_filters, blocksize);
    return (cPtr == 0) ? null : new xtract_mel_filter(cPtr, false);
  }

  public static void destroy_filterbank(xtract_mel_filter filterbank) {
    xtractJNI.destroy_filterbank(xtract_mel_filter.getCPtr(filterbank), filterbank);
  }

  public static int xtract_mean(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_mean(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_variance(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_variance(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_standard_deviation(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_standard_deviation(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_average_deviation(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_average_deviation(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_skewness(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_skewness(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_kurtosis(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_kurtosis(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_mean(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_mean(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_variance(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_variance(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_standard_deviation(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_standard_deviation(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_skewness(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_skewness(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_kurtosis(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_kurtosis(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_centroid(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_centroid(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_irregularity_k(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_irregularity_k(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_irregularity_j(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_irregularity_j(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_tristimulus_1(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_tristimulus_1(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_tristimulus_2(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_tristimulus_2(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_tristimulus_3(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_tristimulus_3(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_smoothness(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_smoothness(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spread(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spread(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_zcr(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_zcr(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_rolloff(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_rolloff(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_loudness(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_loudness(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_flatness(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_flatness(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_flatness_db(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_flatness_db(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_tonality(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_tonality(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_noisiness(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_noisiness(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_rms_amplitude(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_rms_amplitude(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_inharmonicity(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_inharmonicity(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_crest(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_crest(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_power(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_power(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_odd_even_ratio(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_odd_even_ratio(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_sharpness(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_sharpness(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_spectral_slope(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_spectral_slope(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_lowest_value(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_lowest_value(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_highest_value(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_highest_value(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_sum(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_sum(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_hps(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_hps(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_f0(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_f0(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_failsafe_f0(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_failsafe_f0(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_wavelet_f0(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_wavelet_f0(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_midicent(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_midicent(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_nonzero_count(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_nonzero_count(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_peak(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_peak(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_flux(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_flux(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_lnorm(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, double[] result) {
    return xtractJNI.xtract_lnorm(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), result);
  }

  public static int xtract_difference_vector(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_difference_vector(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_spectrum(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_spectrum(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_autocorrelation_fft(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_autocorrelation_fft(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_mfcc(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_mfcc(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_dct(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_dct(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_autocorrelation(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_autocorrelation(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_amdf(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_amdf(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_asdf(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_asdf(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_bark_coefficients(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_bark_coefficients(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_peak_spectrum(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_peak_spectrum(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_harmonic_spectrum(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_harmonic_spectrum(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_lpc(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_lpc(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_lpcc(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_lpcc(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_subbands(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_subbands(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_windowed(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_windowed(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_features_from_subframes(SWIGTYPE_p_double data, int N, int feature, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_features_from_subframes(SWIGTYPE_p_double.getCPtr(data), N, feature, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_is_denormal(double d) {
    return xtractJNI.xtract_is_denormal(d);
  }

  public static boolean xtract_is_poweroftwo(long x) {
    return xtractJNI.xtract_is_poweroftwo(x);
  }

  public static int xtract_smoothed(SWIGTYPE_p_double data, int N, SWIGTYPE_p_void argv, SWIGTYPE_p_double result) {
    return xtractJNI.xtract_smoothed(SWIGTYPE_p_double.getCPtr(data), N, SWIGTYPE_p_void.getCPtr(argv), SWIGTYPE_p_double.getCPtr(result));
  }

  public static int xtract_init_wavelet_f0_state() {
    return xtractJNI.xtract_init_wavelet_f0_state();
  }

  public static int xtract_init_mfcc(int N, double nyquist, int style, double freq_min, double freq_max, int freq_bands, SWIGTYPE_p_p_double fft_tables) {
    return xtractJNI.xtract_init_mfcc(N, nyquist, style, freq_min, freq_max, freq_bands, SWIGTYPE_p_p_double.getCPtr(fft_tables));
  }

  public static int xtract_init_bark(int N, double sr, SWIGTYPE_p_int band_limits) {
    return xtractJNI.xtract_init_bark(N, sr, SWIGTYPE_p_int.getCPtr(band_limits));
  }

  public static int xtract_init_fft(int N, int feature_name) {
    return xtractJNI.xtract_init_fft(N, feature_name);
  }

  public static void xtract_free_fft() {
    xtractJNI.xtract_free_fft();
  }

  public static SWIGTYPE_p_double xtract_init_window(int N, int type) {
    long cPtr = xtractJNI.xtract_init_window(N, type);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public static void xtract_free_window(SWIGTYPE_p_double window) {
    xtractJNI.xtract_free_window(SWIGTYPE_p_double.getCPtr(window));
  }

  public static xtract_function_descriptor_t xtract_make_descriptors() {
    long cPtr = xtractJNI.xtract_make_descriptors();
    return (cPtr == 0) ? null : new xtract_function_descriptor_t(cPtr, false);
  }

  public static int xtract_free_descriptors(xtract_function_descriptor_t fd) {
    return xtractJNI.xtract_free_descriptors(xtract_function_descriptor_t.getCPtr(fd), fd);
  }

}
