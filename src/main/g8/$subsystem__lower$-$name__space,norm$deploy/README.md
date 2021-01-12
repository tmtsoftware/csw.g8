# $name;format="space,norm"$-deploy

This module contains apps and configuration files for host deployment using 
HostConfig (https://tmtsoftware.github.io/csw/apps/hostconfig.html) and 
ContainerCmd (https://tmtsoftware.github.io/csw/framework/deploying-components.html).

An important part of making this work is ensuring the host config app ($name;format="space,Camel"$HostConfigApp) is built
with all of the necessary dependencies of the components it may run.  This is done by adding settings to the
built.sbt file:

```
lazy val `$subsystem;format="lower"$-$name;format="space,norm"$-deploy` = project
  .dependsOn(
    `$subsystem;format="lower"$-$assemblyComponentName;format="space,norm"$`,
    `$subsystem;format="lower"$-$hcdComponentName;format="space,norm"$``
  )
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="space,Camel"$Deploy
  )
```

and in Libs.scala:

```

  val `csw-framework`  = "com.github.tmtsoftware.csw" %% "csw-framework"  % Version

```

Note: the CSW Location Service must be running before starting the components.
See https://tmtsoftware.github.io/csw/apps/cswlocationserver.html .