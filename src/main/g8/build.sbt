
lazy val `$assembly_module;format="normalize"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Assembly
  )

lazy val `$hcd_module;format="normalize"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Hcd
  )

lazy val `$deploy_module;format="normalize"$` = project
  .dependsOn(
    `$assembly_module$`,
    `$hcd_module$`
  )
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="Camel"$Deploy
  )
