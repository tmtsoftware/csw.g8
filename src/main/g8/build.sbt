
lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `$assembly_module$`,
  `$hcd_module$`,
  `$deploy_module$`
)

lazy val `$name;format="space,norm"` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

lazy val `$assembly_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Assembly
  )

lazy val `$hcd_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Hcd
  )

lazy val `$deploy_module$` = project
  .dependsOn(
    `$assembly_module;format="normalize"$`,
    `$hcd_module;format="normalize"$`
  )
  .enablePlugins(JavaAppPackaging, CswBuildInfo)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Deploy
  )
