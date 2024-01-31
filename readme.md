
# Dependancies

You'll need

- https://github.com/casey/just
- [scala js cli 1.15.0.1](https://github.com/VirtusLab/scala-js-cli/releases/tag/v1.15.0.1)
    - In this directory
    - chmod +x scala-js-cli

# Justfile

I needed a way to manage heterogenous scala-cli scripts and settled on just.

`just --list` to see the available commands.

`just` is the demo...

## Goals

Demonstrate that it is possible to dramatically simplify parts of the scala js toolchain. In the first instance targting facade construction and testing.

Scala-cli only. No vite, no sbt.

In browser tests driven purely by the JVM API of [playwright](https://playwright.dev/java/), mean the facade is really tested in the browser.

## Structure

- /facade is the scalajs project that one would seek to publish. In this case, it contains a very simple facade for @stdlib/linspace.

- /testDir contains a traditional scala-cli (JVM) project which is nothing more than a test harness for the facade.

Nits

- Two seperate scala-cli projects, is _slightly_ more complex than I wanted.

- Need to land https://github.com/VirtusLab/scala-cli/issues/2698 as the scalaJsCli just task is currently rather complex! Much better managed in scala-cli.
