import sbt._

object Dependencies {

  val $assemblyComponentName;format="space,Camel"$ = Seq(
    CSW.`csw-framework`,
    CSW.`csw-testkit` % Test,
    Libs.`scalatest` % Test,
    Libs.`junit-4-13` % Test,
  )

  val $hcdComponentName;format="space,Camel"$ = Seq(
    CSW.`csw-framework`,
    CSW.`csw-testkit` % Test,
    Libs.`scalatest` % Test,
    Libs.`junit-4-13` % Test,
  )

  val $name;format="space,Camel"$Deploy = Seq(
    CSW.`csw-framework`,
    CSW.`csw-testkit` % Test
  )
}
