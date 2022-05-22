# Rustpotter Java

<div align="center">
    <img src="./logo.png?raw=true" width="400px"</img> 
</div>

## Description

Java wrapper for [Rustpotter](https://github.com/GiviMAD/rustpotter) (a free and open source wake word spotter forged in rust).

## Installation

This package is available on the [Maven Central Repository](https://search.maven.org/artifact/io.github.givimad/rustpotter-java).

The distributed package support the following platforms:
    * debian (arm, arm64, x86_64)
    * macOS (arm64, x86_64)
    * windows (x86_64)

## Examples

### Initialize the Detector:

```java
var rustpotterBuilder = new RustpotterJavaBuilder();
rustpotterBuilder.setThreshold(config.threshold);
rustpotterBuilder.setAveragedThreshold(config.averagedThreshold);
rustpotterBuilder.setComparatorRef(config.comparatorRef);
rustpotterBuilder.setComparatorBandSize(config.comparatorBandSize);
rustpotterBuilder.setVADSensitivity(config.vadSensitivity);
rustpotterBuilder.setVADDelay(config.vadDelay);
rustpotterBuilder.setVADMode(config.vadMode);
rustpotterBuilder.setEagerMode(config.eagerMode);
rustpotterBuilder.setBitsPerSample(bitDepth);
rustpotterBuilder.setSampleRate(frequency);
rustpotterBuilder.setChannels(channels);
var rustpotter = rustpotterBuilder.build();
rustpotterBuilder.delete();
// Add wakeword model
rustpotter.addWakewordModelFile(modelPath.toString());
```

### Detect Wakewords:

```java
private void processAudioStream(RustpotterJava rustpotter, Consumer<String> listener, InputStream audioStream, AtomicBoolean aborted) {
        int numBytesRead;
        var frameSize = (int) rustpotter.getFrameSize();
        var bufferSize = frameSize * 2;
        ByteBuffer captureBuffer = ByteBuffer.allocate(bufferSize);
        captureBuffer.order(ByteOrder.LITTLE_ENDIAN);
        short[] audioBuffer = new short[frameSize];
        while (!aborted.get()) {
            try {
                // read a buffer of audio
                numBytesRead = audioStream.read(captureBuffer.array(), 0, captureBuffer.capacity());
                if (aborted.get()) {
                    break;
                }
                if (numBytesRead != bufferSize) {
                    // do not pass incomplete buffers
                    Thread.sleep(100);
                    continue;
                }
                captureBuffer.asShortBuffer().get(audioBuffer);
                var result = rustpotter.processSort(audioBuffer);
                if (result.isPresent()) {
                    var detection = result.get();
                    var word = detection.getName();
                    logger.debug("keyword '{}' detected with score {}!", detection.getName(), detection.getScore());
                    detection.delete();
                    listener.accept(word);
                }
            } catch (IOException | InterruptedException e) {
                String errorMessage = e.getMessage();
                throw e; // another consumer for the errors makes more sense as this function is intended to run on a separate thread.
            }
        }
        rustpotter.delete();
        logger.debug("rustpotter stopped");
    }
```