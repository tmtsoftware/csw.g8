
lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `$subsystem;format="lower"$-$assemblyComponentName;format="space,norm"$`,
  `$subsystem;format="lower"$-$hcdComponentName;format="space,norm"$`,
  `$subsystem;format="lower"$-$name;format="space,norm"$deploy`
)

lazy val `$name;format="space,norm"$-root` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

// assembly module
lazy val `$subsystem;format="lower"$-$assemblyComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$assemblyComponentName;format="space,Camel"$
  )

// hcd module
lazy val `$subsystem;format="lower"$-$hcdComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$hcdComponentName;format="space,Camel"$
  )

// deploy module
lazy val `$subsystem;format="lower"$-$name;format="space,norm"$deploy` = project
  .dependsOn(
    `$subsystem;format="lower"$-$assemblyComponentName;format="space,norm"$`,
    `$subsystem;format="lower"$-$hcdComponentName;format="space,norm"$`
  )
  .enablePlugins(CswBuildInfo)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="space,Camel"$Deploy
  )
