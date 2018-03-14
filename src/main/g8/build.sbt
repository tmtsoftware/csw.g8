
lazy val `$assembly_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name$Assembly
  )

lazy val `$hcd_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name$Hcd
  )

lazy val `$deploy_module$` = project
  .dependsOn(
    `$assembly_module$`,
    `$hcd_module$`
  )
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Dependencies.$name$Deploy
  )
