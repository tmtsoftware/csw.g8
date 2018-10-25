# $deploy_module$

This module contains apps and configuration files for host deployment using 
HostConfig (https://tmtsoftware.github.io/csw/apps/hostconfig.html) and 
ContainerCmd (https://tmtsoftware.github.io/csw/framework/deploying-components.html).

An important part of making this work is ensuring the host config app ($name;format="Camel"$HostConfigApp) is built
with all of the necessary dependencies of the components it may run.  This is done by adding settings to the
built.sbt file:

```
lazy val `$deploy_module$` = project
  .dependsOn(
    `$assembly_module$`,
    `$hcd_module$`
  )
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Deploy
  )
```

and in Libs.scala:

```

  val `csw-framework`  = "org.tmt" %% "csw-framework"  % Version

```

To start $name$ Assembly and HCD, follow below steps:

 - Run `sbt $deploy_module$/universal:packageBin`, this will create self contained zip in target/universal directory
 - Unzip generate zip and enter into bin directory
 - Run container cmd script or host config app script
 - Ex.  `./$name;format="word"$-host-config-app --local ../../../../$deploy_module$/src/main/resources/$name; format="Camel"$HostConfig.conf -s ./$name; format="word"$-container-cmd-app`

Note: the CSW Location Service cluster seed must be running, and appropriate environment variables set to run apps.
See https://tmtsoftware.github.io/csw/apps/cswclusterseed.html .