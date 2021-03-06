// Automatically generated by flapigen
package io.github.givimad.rustpotter_java;

/**
 * This class manages the wakeword generation and the spotting functionality.
 */
public final class RustpotterJava {

    private RustpotterJava() {}
    /**
     * Process i32 audio chunks.
     * 
     * Asserts that the audio chunk length should match the return
     * of the getSamplesPerFrame method.
     * 
     * Assumes sample rate match the configured for the detector.
     * 
     * Asserts that detector bits_per_sample is one of: 8, 16, 24, 32.
     * 
     * Asserts that detector sample_format is 'int'.
     * 
     * It's an alias for the processInt method.
     */
    public final java.util.Optional<RustpotterDetection> process(int [] buffer) {
        long ret = do_process(mNativeObj, buffer);
        java.util.Optional<RustpotterDetection> convRet;
        if (ret != 0) {
            convRet = java.util.Optional.of(new RustpotterDetection(InternalPointerMarker.RAW_PTR, ret));
        } else {
            convRet = java.util.Optional.empty();
        }

        return convRet;
    }
    private static native long do_process(long self, int [] buffer);
    /**
     * Process i32 audio chunks.
     * 
     * Asserts that the audio chunk length should match the return
     * of the getSamplesPerFrame method.
     * 
     * Assumes sample rate match the configured for the detector.
     * 
     * Asserts that detector bits_per_sample is one of: 8, 16, 24, 32.
     * 
     * Asserts that detector sample_format is 'int'.
     */
    public final java.util.Optional<RustpotterDetection> processInt(int [] buffer) {
        long ret = do_processInt(mNativeObj, buffer);
        java.util.Optional<RustpotterDetection> convRet;
        if (ret != 0) {
            convRet = java.util.Optional.of(new RustpotterDetection(InternalPointerMarker.RAW_PTR, ret));
        } else {
            convRet = java.util.Optional.empty();
        }

        return convRet;
    }
    private static native long do_processInt(long self, int [] buffer);
    /**
     * Process i16 audio chunks.
     * 
     * Asserts that the audio chunk length should match the return
     * of the getSamplesPerFrame method.
     * 
     * Assumes sample rate match the configured for the detector.
     * 
     * Asserts that detector bits_per_sample is one of: 8, 16.
     * 
     * Asserts that detector sample_format is 'int'.
     */
    public final java.util.Optional<RustpotterDetection> processSort(short [] buffer) {
        long ret = do_processSort(mNativeObj, buffer);
        java.util.Optional<RustpotterDetection> convRet;
        if (ret != 0) {
            convRet = java.util.Optional.of(new RustpotterDetection(InternalPointerMarker.RAW_PTR, ret));
        } else {
            convRet = java.util.Optional.empty();
        }

        return convRet;
    }
    private static native long do_processSort(long self, short [] buffer);
    /**
     * Process i8 audio chunks.
     * 
     * Asserts that the audio chunk length should match the return
     * of the getSamplesPerFrame method.
     * 
     * Assumes sample rate match the configured for the detector.
     * 
     * Asserts that detector bits_per_sample is 8.
     * 
     * Asserts that detector sample_format is 'int'.
     */
    public final java.util.Optional<RustpotterDetection> processByte(byte [] buffer) {
        long ret = do_processByte(mNativeObj, buffer);
        java.util.Optional<RustpotterDetection> convRet;
        if (ret != 0) {
            convRet = java.util.Optional.of(new RustpotterDetection(InternalPointerMarker.RAW_PTR, ret));
        } else {
            convRet = java.util.Optional.empty();
        }

        return convRet;
    }
    private static native long do_processByte(long self, byte [] buffer);
    /**
     * Process f32 audio chunks.
     * 
     * Asserts that the audio chunk length should match the return
     * of the getSamplesPerFrame method.
     * 
     * Assumes sample rate match the configured for the detector.
     * 
     * Asserts that detector bits_per_sample is 32.
     * 
     * Asserts that detector sample_format is 'float'.
     */
    public final java.util.Optional<RustpotterDetection> processFloat(float [] buffer) {
        long ret = do_processFloat(mNativeObj, buffer);
        java.util.Optional<RustpotterDetection> convRet;
        if (ret != 0) {
            convRet = java.util.Optional.of(new RustpotterDetection(InternalPointerMarker.RAW_PTR, ret));
        } else {
            convRet = java.util.Optional.empty();
        }

        return convRet;
    }
    private static native long do_processFloat(long self, float [] buffer);
    /**
     * Process audio chunks in bytes.
     * 
     * Asserts that the audio chunk length should match the return
     * of the getBytesPerFrame method.
     * 
     * Assumes sample rate match the configured for the detector.
     * 
     * Assumes buffer endianness matches the configured for the detector.
     */
    public final java.util.Optional<RustpotterDetection> processBuffer(byte [] buffer) {
        long ret = do_processBuffer(mNativeObj, buffer);
        java.util.Optional<RustpotterDetection> convRet;
        if (ret != 0) {
            convRet = java.util.Optional.of(new RustpotterDetection(InternalPointerMarker.RAW_PTR, ret));
        } else {
            convRet = java.util.Optional.empty();
        }

        return convRet;
    }
    private static native long do_processBuffer(long self, byte [] buffer);
    /**
     * Loads a wakeword from its model path.
     */
    public final String addWakewordModelFile(String path) throws Exception {
        String ret = do_addWakewordModelFile(mNativeObj, path);

        return ret;
    }
    private static native String do_addWakewordModelFile(long self, String path) throws Exception;
    /**
     * Loads a wakeword from its model bytes.
     */
    public final String addWakewordModelBytes(byte [] bytes) throws Exception {
        String ret = do_addWakewordModelBytes(mNativeObj, bytes);

        return ret;
    }
    private static native String do_addWakewordModelBytes(long self, byte [] bytes) throws Exception;
    /**
     * Returns the desired chunk size.
     */
    public final long getSamplesPerFrame() {
        long ret = do_getSamplesPerFrame(mNativeObj);

        return ret;
    }
    private static native long do_getSamplesPerFrame(long self);
    /**
     * Returns size in bytes for the desired chunk.
     */
    public final long getBytesPerFrame() {
        long ret = do_getBytesPerFrame(mNativeObj);

        return ret;
    }
    private static native long do_getBytesPerFrame(long self);
    /**
     * Removes a wakeword by name.
     */
    public final void removeWakeword(String name) {
        do_removeWakeword(mNativeObj, name);
    }
    private static native void do_removeWakeword(long self, String name);
    /**
     * Sets detector threshold.
     */
    public final void setThreshold(float threshold) {
        do_setThreshold(mNativeObj, threshold);
    }
    private static native void do_setThreshold(long self, float threshold);
    /**
     * Sets detector averaged threshold.
     */
    public final void setAveragedThreshold(float averaged_threshold) {
        do_setAveragedThreshold(mNativeObj, averaged_threshold);
    }
    private static native void do_setAveragedThreshold(long self, float averaged_threshold);
    /**
     * Sets wakeword threshold.
     */
    public final void setWakewordThreshold(String name, float threshold) {
        do_setWakewordThreshold(mNativeObj, name, threshold);
    }
    private static native void do_setWakewordThreshold(long self, String name, float threshold);
    /**
     * Sets wakeword averaged threshold.
     */
    public final void setWakewordAveragedThreshold(String name, float averaged_threshold) {
        do_setWakewordAveragedThreshold(mNativeObj, name, averaged_threshold);
    }
    private static native void do_setWakewordAveragedThreshold(long self, String name, float averaged_threshold);

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
    /*package*/ RustpotterJava(InternalPointerMarker marker, long ptr) {
        assert marker == InternalPointerMarker.RAW_PTR;
        this.mNativeObj = ptr;
    }
    /*package*/ long mNativeObj;

        public static void loadLibrary() throws java.io.IOException {
            String bundleLibraryPath = null;
            String osName = System.getProperty("os.name").toLowerCase();
            String osArch = System.getProperty("os.arch").toLowerCase();
            if (osName.contains("win")) {
                if(osArch.contains("amd64") || osArch.contains("x86_64")) {
                    bundleLibraryPath = "/librustpotter_java_win_x86_64.dll";
                }
            } else if (osName.contains("nix") || osName.contains("nux")
                    || osName.contains("aix")) {
                if(osArch.contains("amd64") || osArch.contains("x86_64")) {
                    bundleLibraryPath = "/librustpotter_java_debian_x86_64.so";
                } else if(osArch.contains("aarch64") || osArch.contains("arm64")) {
                    bundleLibraryPath = "/librustpotter_java_debian_aarch64.so";
                } else if(osArch.contains("armv7") || osArch.contains("arm")) {
                    bundleLibraryPath = "/librustpotter_java_debian_armv7l.so";
                }
            } else if (osName.contains("mac") || osName.contains("darwin")) {
                if(osArch.contains("amd64") || osArch.contains("x86_64")) {
                    bundleLibraryPath = "/librustpotter_java_macos_x86_64.dylib";
                } else if(osArch.contains("aarch64") || osArch.contains("arm64")) {
                    bundleLibraryPath = "/librustpotter_java_macos_aarch64.dylib";
                }
            }
            if (bundleLibraryPath == null) {
                throw new java.io.IOException("Rustpotter: Unsupported platform.");
            }
            NativeUtils.loadLibraryFromJar(bundleLibraryPath);
        }
    }