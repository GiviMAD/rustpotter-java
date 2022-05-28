package io.github.givimad.rustpotter_java;

import org.junit.Test;
import static org.junit.Assert.*;

public class RustpotterJavaTest {
    @Test public void getFrameSizeFromRust() throws java.io.IOException {
        RustpotterJava.loadLibrary();
        RustpotterJava rustpotter = new RustpotterJavaBuilder().build();
        var frameSize = rustpotter.getFrameSize();
        assertEquals("get frame size from rustpotter", 480, frameSize);
    }
}
