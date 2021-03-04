# $name;format="space,norm"$-deploy

This module contains apps and configuration files for deployment using 
ContainerCmd (https://tmtsoftware.github.io/csw/framework/deploying-components.html).

An important part of making this work is ensuring the app is built with all of the necessary dependencies of the components it may run. 
This is done by adding settings to the built.sbt file:

```
lazy val `$subsystem;format="lower"$-$name;format="space,norm"$-deploy` = project
  .dependsOn(
    `$subsystem;format="lower"$-$assemblyComponentName;format="space,norm"$`,
    `$subsystem;format="lower"$-$hcdComponentName;format="space,norm"$``
  )
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
