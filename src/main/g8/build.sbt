import scala.sys.process.Process

lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `$assemblyComponentName;format="space,norm"$`,
  `$hcdComponentName;format="space,norm"$`,
  `$name;format="space,norm"$-deploy`
)
// deploy module
lazy val `$name;format="space,norm"$-project` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

// assembly module
lazy val `$assemblyComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$assemblyComponentName;format="space,Camel"$
  )

// hcsd module
lazy val `$hcdComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$hcdComponentName;format="space,Camel"$
  )

lazy val `$name;format="space,norm"$-deploy` = project
  .dependsOn(
    `$assemblyComponentName;format="space,norm"$`,
    `$hcdComponentName;format="space,norm"$`
  )
  .enablePlugins(CswBuildInfo)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="space,Camel"$Deploy
  )


val orgName = settingKey[String]("name of the organization")
val deploymentProject = settingKey[String]("name of the deployment module")
val subsystem = settingKey[String]("name of the subsystem")
val containerApp = settingKey[String]("name of the container App")
val hostApp = settingKey[String]("name of the host App")
val containerCommand = settingKey[String]("command to create container command app")
val hostCommand = settingKey[String]("command to create host config app")

val stage = taskKey[Unit]("creates an application for assembly and hcd component")

orgName := "$organization$"
deploymentProject := "$name;format="space,norm"$"
subsystem := "$subsystem;format="lower"$"
containerApp := orgName.value + "." + subsystem.value + "." + deploymentProject.value + "deploy.$name;format="space,Camel"$ContainerCmdApp"
hostApp := orgName.value + "." + subsystem.value + "." + deploymentProject.value + "deploy.$name;format="space,Camel"$HostConfigApp"
containerCommand := "cs bootstrap " + orgName.value + ":" + deploymentProject.value +"-deploy_2.13:" + version.value + " -r jitpack -M " + containerApp.value + " -o " + deploymentProject.value + "-container-cmd-app -f"
hostCommand := "cs bootstrap " + orgName.value + ":" + deploymentProject.value +"-deploy_2.13:" + version.value + " -r jitpack -M " + hostApp.value + " -o " + deploymentProject.value + "-host-config-app -f"

stage := {
  publishLocal.value
  Process(containerCommand.value).run()
  Process(hostCommand.value).run()
}
