
lazy val `$assembly_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name$Assembly
  )

lazy val `$hcd_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name$Hcd
  )

lazy val `$deploy_module$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name$Deploy
  )
  .dependsOn(
    `$assembly_module$`,
    `$hcd_module$`
  )
