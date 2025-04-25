package $subsystem;format="lower"$.$assemblyComponentName;format="space,norm,word"$

import csw.location.api.models.Connection.PekkoConnection
import csw.prefix.models.Prefix
import csw.location.api.models.{ComponentId, ComponentType}
import csw.testkit.scaladsl.CSWService.{AlarmServer, EventServer}
import csw.testkit.scaladsl.ScalaTestFrameworkTestKit
import org.scalatest.funsuite.AnyFunSuiteLike

import scala.concurrent.Await
import scala.concurrent.duration._

class $assemblyComponentName;format="space,Camel"$Test extends ScalaTestFrameworkTestKit(AlarmServer, EventServer) with AnyFunSuiteLike {

  import frameworkTestKit._

  override def beforeAll(): Unit = {
    super.beforeAll()
    // uncomment if you want one Assembly run for all tests
    spawnStandalone(com.typesafe.config.ConfigFactory.load("$assemblyComponentName;format="space,Camel"$Standalone.conf"))
  }

  test("Assembly should be locatable using Location Service") {
    val connection = PekkoConnection(ComponentId(Prefix("$subsystem$.$assemblyComponentName;format="package"$"), ComponentType.Assembly))
    val pekkoLocation = Await.result(locationService.resolve(connection, 10.seconds), 10.seconds).get

    pekkoLocation.connection shouldBe connection
  }
}