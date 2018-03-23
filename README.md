## Giter8 Template for TMT

This is a Giter8 template for TMT component developer which creates a sample sbt project for component writer.
Created project contains three subprojects:
 - assembly
 - hcd
 - deploy

Use below command for creating new project:
`sbt new tmtsoftware/csw.g8`

This template will prompt for the following parameters. Press Enter if the default values suit you:

 - `name [galil]`: Becomes the name of the project.
 - `organization [org.tmt]`: Specifies the organization for this project.
 - `subsystem [NFIRAOS]`: Specifies the subsystem name.
 - `version [0.0.1]`: Specifies the component version for this project.
 - `package [org.tmt.nfiraos]`: Top level package which dynamically gets created based on provided organization and subsystem in all subprojects.
 - `deploy_module [galil-deploy]`: Subproject name which holds HostConfig and ContainerCmd applications.
 - `assembly_module [galil-assembly]`: Subproject name which holds Assembly.
 - `hcd_module [galil-hcd]`: Subproject name which holds HCD.
 - `scala_version [2.12.4]`: Specifies the Scala version for this project.
 - `csw_version [0.1.2+1482-61ea9b92]`: Specifies the Common Software (csw) version for this project.