// Automatically generated by flapigen
package io.github.givimad.rustpotter_java;


public final class RustpotterJavaBuilder {

    public RustpotterJavaBuilder() {
        mNativeObj = init();
    }
    private static native long init();
    /**
     * Configures the detector threshold,
     * is the min score (in range 0. to 1.) that some of
     * the wakeword templates should obtain to trigger a detection.
     * 
     * Defaults to 0.5, wakeword defined value takes prevalence if present.
     */
    public final void setThreshold(float value) {
        do_setThreshold(mNativeObj, value);
    }
    private static native void do_setThreshold(long self, float value);
    /**
     * Configures the detector threshold,
     * is the min score (in range 0. to 1.) that
     * the averaged wakeword template should obtain to allow
     * to continue with the detection. This way it can prevent to
     * run the comparison of the current frame against each of the wakeword templates.
     * If set to 0. this functionality is disabled.
     * 
     * Defaults to half of the configured threshold, wakeword defined value takes prevalence if present.
     */
    public final void setAveragedThreshold(float value) {
        do_setAveragedThreshold(mNativeObj, value);
    }
    private static native void do_setAveragedThreshold(long self, float value);
    /**
     * Configures the detector expected bit per sample for the audio chunks to process.
     * 
     * Defaults to 16; Allowed values: 8, 16, 24, 32
     */
    public final void setBitsPerSample(int value) {
        do_setBitsPerSample(mNativeObj, value);
    }
    private static native void do_setBitsPerSample(long self, int value);
    /**
     * Configures the detector expected sample rate for the audio chunks to process.
     * 
     * Defaults to 16000
     */
    public final void setSampleRate(long value) {
        do_setSampleRate(mNativeObj, value);
    }
    private static native void do_setSampleRate(long self, long value);
    /**
     * Configures the detector expected sample format for the audio chunks to process.
     * 
     * Defaults to int
     */
    public final void setSampleFormat(SampleFormat value) {
        int a0 = value.getValue();
        do_setSampleFormat(mNativeObj, a0);

        JNIReachabilityFence.reachabilityFence1(value);
    }
    private static native void do_setSampleFormat(long self, int value);
    /**
     * Configures the detector expected number of channels for the audio chunks to process.
     * Rustpotter will only use data for first channel.
     * 
     * Defaults to 1
     */
    public final void setChannels(int value) {
        do_setChannels(mNativeObj, value);
    }
    private static native void do_setChannels(long self, int value);
    /**
     * Configures the band-size for the comparator used to match the samples.
     * 
     * Defaults to 6
     */
    public final void setComparatorBandSize(long value) {
        do_setComparatorBandSize(mNativeObj, value);
    }
    private static native void do_setComparatorBandSize(long self, long value);
    /**
     * Configures the reference for the comparator used to match the samples.
     * 
     * Defaults to 0.22
     */
    public final void setComparatorRef(float value) {
        do_setComparatorRef(mNativeObj, value);
    }
    private static native void do_setComparatorRef(long self, float value);
    /**
     * Configures consecutive number of samples containing only silence for
     * skip the comparison against the wakewords to avoid useless cpu consumption.
     * 
     * Defaults to 3, 0 for disabled.
     */
    public final void setMaxSilenceFrames(int value) {
        do_setMaxSilenceFrames(mNativeObj, value);
    }
    private static native void do_setMaxSilenceFrames(long self, int value);
    /**
     * Enables eager mode.
     * Terminate the detection as son as one result is above the score,
     * instead of wait to see if the next frame has a higher score.
     * 
     * Recommended for real usage.
     * 
     * Defaults to false.
     */
    public final void setEagerMode(boolean value) {
        do_setEagerMode(mNativeObj, value);
    }
    private static native void do_setEagerMode(long self, boolean value);
    /**
     * Unless enabled the comparison against multiple wakewords run
     * in separate threads.
     * 
     * Defaults to false.
     * 
     * Only applies when more than a wakeword is loaded.
     */
    public final void setSingleThread(boolean value) {
        do_setSingleThread(mNativeObj, value);
    }
    private static native void do_setSingleThread(long self, boolean value);
    /**
     * Seconds to disable the vad detector after voice is detected.
     * 
     * Defaults to 3.
     * 
     * Only applies if vad is enabled.
     */
    public final void setVADDelay(int value) {
        do_setVADDelay(mNativeObj, value);
    }
    private static native void do_setVADDelay(long self, int value);
    /**
     * Voice/silence ratio in the last second to consider voice detected.
     * 
     * Defaults to 0.5.
     * 
     * Only applies if vad is enabled.
     */
    public final void setVADSensitivity(float value) {
        do_setVADSensitivity(mNativeObj, value);
    }
    private static native void do_setVADSensitivity(long self, float value);
    /**
     * Use a vad detector to reduce computation on absence of voice sound.
     * 
     * Unless specified the vad detector is disabled.
     */
    public final void setVADMode(VadMode value) {
        int a0 = value.getValue();
        do_setVADMode(mNativeObj, a0);

        JNIReachabilityFence.reachabilityFence1(value);
    }
    private static native void do_setVADMode(long self, int value);
    /**
     * construct the wakeword detector
     */
    public final RustpotterJava build() {
        long ret = do_build(mNativeObj);
        RustpotterJava convRet = new RustpotterJava(InternalPointerMarker.RAW_PTR, ret);

        return convRet;
    }
    private static native long do_build(long self);

    public synchronized void delete() {
        if (mNativeObj != 0) {
            do_delete(mNativeObj);
            mNativeObj = 0;
       }
    }
    @Override
    protected void finalize() throws Throwable {
        try {
            delete();
        }
        finally {
             super.finalize();
        }
    }
    private static native void do_delete(long me);
    /*package*/ RustpotterJavaBuilder(InternalPointerMarker marker, long ptr) {
        assert marker == InternalPointerMarker.RAW_PTR;
        this.mNativeObj = ptr;
    }
    /*package*/ long mNativeObj;
}