import sbt._

object Dependencies {

  val $assemblyComponentName;format="Camel"$ = Seq(
    CSW.`csw-framework`,
    CSW.`csw-testkit` % Test,
    Libs.`scalatest` % Test,
    Libs.`junit` % Test,
    Libs.`junit-interface` % Test
  )

  val $hcdComponentName;format="Camel"$ = Seq(
    CSW.`csw-framework`,
    CSW.`csw-testkit` % Test,
    Libs.`scalatest` % Test,
    Libs.`junit` % Test,
    Libs.`junit-interface` % Test
  )

  val $name;format="Camel"$Deploy = Seq(
    CSW.`csw-framework`,
    CSW.`csw-testkit` % Test
  )
}
