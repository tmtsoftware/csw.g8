
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
    `$assembly_module$`,
    `$hcd_module$`
  )
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Deploy
  )
