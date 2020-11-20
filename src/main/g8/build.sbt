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

def createCommand(version : String, mainClass : String) : String = {
  val orgName = "$organization$"
  val projName = "$name;format="space,norm"$"
  val appName = mainClass.split('.').last
  val command = "cs bootstrap " + orgName + ":" + projName +"-deploy_2.13:" + version + " -r jitpack -M " + mainClass + " -o " + appName + " -f"
  command
}

val stage = taskKey[Unit]("creates an application for assembly and hcd component")

stage := {
  val mainClasses = (`$name;format="space,norm"$-deploy`/Compile/discoveredMainClasses).value
  val bootstrapCommands = mainClasses.map(createCommand(version.value, _))

  publishLocal.value
  bootstrapCommands.foreach(Process(_).run())
}


