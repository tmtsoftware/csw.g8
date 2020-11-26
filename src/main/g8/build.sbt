import scala.sys.process.Process

lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `$assemblyComponentName;format="space,norm"$`,
  `$hcdComponentName;format="space,norm"$`,
  `$name;format="space,norm"$-deploy`
)

lazy val `$name;format="space,norm"$-root` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

// assembly module
lazy val `$assemblyComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$assemblyComponentName;format="space,Camel"$
  )

// hcd module
lazy val `$hcdComponentName;format="space,norm"$` = project
  .settings(
    libraryDependencies ++= Dependencies.$hcdComponentName;format="space,Camel"$
  )

// deploy module
lazy val `$name;format="space,norm"$-deploy` = project
  .dependsOn(
    `$assemblyComponentName;format="space,norm"$`,
    `$hcdComponentName;format="space,norm"$`
  )
  .enablePlugins(CswBuildInfo)
  .settings(
    libraryDependencies ++= Dependencies.$name;format="space,Camel"$Deploy
  )


//val stage = taskKey[Unit]("Creates an application for assembly and hcd component")
//
//stage := {
//
//  def createCommand(mainClass : String) : String = {
//    val orgName = "$organization$"
//    val projName = "$name;format="space,norm"$"
//    val appName = mainClass.split('.').last
//    val scalaVersion = Libs.ScalaVersion.substring(0, Libs.ScalaVersion.lastIndexOf('.'))
//    "cs bootstrap " + orgName + ":" + projName +"-deploy_" + scalaVersion + ":" + version.value + " -r jitpack -M " + mainClass + " -o " + appName + " -f"
//  }
//
//  val mainClasses = (`$name;format="space,norm"$-deploy`/Compile/discoveredMainClasses).value
//  val bootstrapCommands = mainClasses.map(createCommand)
//
//  publishLocal.value
//  bootstrapCommands.foreach(Process(_).run())

//}

