lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `$assembly_module$`,
  `$hcd_module$`,
  `$deploy_module$`
)

lazy val `$name;format="space,norm"$` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

lazy val `$assembly_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$assemblyComponentName;format="Camel"$
  )

lazy val `$hcd_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$hcdComponentName;format="Camel"$
  )

lazy val `$deploy_module$` = project
  .dependsOn(
    `$assembly_module;format="normalize"$`,
    `$hcd_module;format="normalize"$`
  )
  .enablePlugins(JavaAppPackaging, CswBuildInfo)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Deploy,
    // This is the placeholder for setting JVM options via sbt native packager.
    // You can add more JVM options below.
//    javaOptions in Universal ++= Seq(
//      // -J params will be added as jvm parameters
//      "-J-Xmx8GB",
//      "J-XX:+UseG1GC", // G1GC is default in jdk9 and above
//      "J-XX:MaxGCPauseMillis=30" // Sets a target for the maximum GC pause time. This is a soft goal, and the JVM will make its best effort to achieve it
//    )
  )
