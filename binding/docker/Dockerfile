# Prepare vendor on hosted platform
FROM --platform=$BUILDPLATFORM rust:buster as rust_vendor
WORKDIR /code
RUN cargo init
COPY src /code/src
COPY Cargo.* build.rs /code/
RUN mkdir -p /code/.cargo \
  && cargo vendor > /code/.cargo/config
# build
FROM rust:buster
RUN apt-get update && \
    apt-get install --assume-yes llvm-dev libclang-dev clang openjdk-11-jdk
# ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
COPY src /code/src
COPY Cargo.* build.rs /code/
COPY --from=rust_vendor /code/.cargo /code/.cargo
COPY --from=rust_vendor /code/vendor /code/vendor
WORKDIR code
RUN export JAVA_HOME="$(dirname $(dirname $(readlink -f $(which java))))" && \
    mkdir -p ../src/main/java/io/github/givimad/rustpotter-java && \
    rustup component add rustfmt && \
    cargo build --release --offline && \
    mkdir -p dist && \
    cp target/release/librustpotter_java.so dist/librustpotter_java_debian_$(arch).so && \
    rm -rf release

