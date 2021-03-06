// Automatically generated by flapigen
package io.github.givimad.rustpotter_java;

/**
 * Represents a successful wakeword detection.
 */
public final class RustpotterDetection {

    private RustpotterDetection() {}
    /**
     * Get detected wakeword name
     */
    public final String getName() {
        String ret = do_getName(mNativeObj);

        return ret;
    }
    private static native String do_getName(long self);
    /**
     * Get detected wakeword score
     */
    public final float getScore() {
        float ret = do_getScore(mNativeObj);

        return ret;
    }
    private static native float do_getScore(long self);

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
    /*package*/ RustpotterDetection(InternalPointerMarker marker, long ptr) {
        assert marker == InternalPointerMarker.RAW_PTR;
        this.mNativeObj = ptr;
    }
    /*package*/ long mNativeObj;
}