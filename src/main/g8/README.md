# $name$

This project implements an HCD (Hardware Control Daemon) and an Assembly using
TMT Common Software ([CSW](https://github.com/tmtsoftware/csw)) APIs.

## Subprojects

* $assemblyComponentName;format="space,norm"$ - an assembly that talks to the $name$ HCD
* $hcdComponentName;format="space,norm"$` - an HCD that talks to the $name$ hardware
* $deploy_module$ - for starting/deploying HCDs and assemblies

## Upgrading CSW Version

`project/build.properties` file contains `csw.version` property which indicates CSW version number.
Updating `csw.version` property will make sure that CSW services as well as library dependency for HCD and Assembly modules are using same CSW version.

## Build Instructions

The build is based on sbt and depends on libraries generated from the
[csw](https://github.com/tmtsoftware/csw) project.

See [here](https://www.scala-sbt.org/1.0/docs/Setup.html) for instructions on installing sbt.

## Prerequisites for running Components

The CSW services need to be running before starting the components.
This is done by starting the `csw-services.sh` script which is present inside `scripts` directory.
Follow below instructions to run CSW services:

* Run `./scripts/csw-services.sh start -a` command to start all the CSW services i.e. Location, Config, Event, Alarm and Database Service
* Run `./csw_services.sh start --help` to get more information.

Note:
`csw-services.sh` script reads `csw.version` property from `project/build.properties` file and uses that version for starting CSW services.

## Building the HCD and Assembly Applications

* Run `sbt $deploy_module$/universal:packageBin`, this will create self-contained zip in `$deploy_module$/target/universal` directory
* Unzip the generated zip and cd into the bin directory

Note: An alternative method is to run `sbt stage`, which installs the applications locally in `$deploy_module$/target/universal/stage/bin`.

## Running the HCD and Assembly

Run the container cmd script with arguments. For example:

* Run the HCD in a standalone mode with a local config file (The standalone config format is different than the container format):

```
./target/universal/stage/bin/$name;format="word"$-container-cmd-app --standalone --local ./src/main/resources/SampleHcdStandalone.conf
```

* Start the HCD and assembly in a container using the Java implementations:

```
./target/universal/stage/bin/$name;format="word"$-container-cmd-app --local ./src/main/resources/JSampleContainer.conf
```

* Or the Scala versions:

```
./target/universal/stage/bin/$name;format="word"$-container-cmd-app --local ./src/main/resources/SampleContainer.conf
```
