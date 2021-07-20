# Giter8 Template for TMT

This is a Giter8 template for a TMT component developer which creates a sample `sbt` project for CSW Components.
The created project contains three subprojects:

- An Assembly
- An HCD
- A Deploy module, containing code to run the components

## Getting Started

### Install Coursier
Install `coursier` using steps described [here](https://tmtsoftware.github.io/csw/apps/csinstallation.html) and add TMT channel.

### Install Giter8

`cs install giter8`

### Create new project using giter8 template

`g8 tmtsoftware/csw.g8`

This template will prompt for the following parameters. Press Enter to accept the default values, shown in brackets:

- `name [sample]`: The name of the project.
- `assemblyComponentName [sampleAssembly]` : The Component Name of the Assembly
- `hcdComponentName [sampleHcd]` : The Component Name of the HCD
- `subsystem [CSW]`: Specifies the subsystem name.

---
**NOTE**
Following section is intended only for testing purpose and can be skipped by the consumers of template.

#### Testing the template

For people interested in testing the template with the latest commit on the dev branch (active development branch), refer [TESTING.md](TESTING.md)
