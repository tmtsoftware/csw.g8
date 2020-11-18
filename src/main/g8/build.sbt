lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `$assemblyComponentName;format="space,norm"$`,
  `$hcdComponentName;format="space,norm"$`,
  `$name;format="space,norm"$-deploy`
)

lazy val `$name;format="space,norm"$-project` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

lazy val `$assemblyComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$assemblyComponentName;format="space,Camel"$
  )

lazy val `$hcdComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$hcdComponentName;format="space,Camel"$
  )

lazy val `$name;format="space,norm"$-deploy` = project
  .dependsOn(
    `$assemblyComponentName;format="space,norm"$`,
    `$hcdComponentName;format="space,norm"$`
  )
  .enablePlugins(JavaAppPackaging, CswBuildInfo)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="space,Camel"$Deploy,
    // This is the placeholder for setting JVM options via sbt native packager.
    // You can add more JVM options below.
//    javaOptions in Universal ++= Seq(
//      // -J params will be added as jvm parameters
//      "-J-Xmx8GB",
//      "J-XX:+UseG1GC", // G1GC is default in jdk9 and above
//      "J-XX:MaxGCPauseMillis=30" // Sets a target for the maximum GC pause time. This is a soft goal, and the JVM will make its best effort to achieve it
//    )
  )
