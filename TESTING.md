# Testing latest template

To test latest `csw.g8`:

1. Take latest pull of `csw` repository
2. In `csw` repository, run `sbt publishLocal`
3. Generate project using command `g8 tmtsoftware/csw.g8 --branch dev`
4. In the generated project, tests can be run using `sbt clean test`
