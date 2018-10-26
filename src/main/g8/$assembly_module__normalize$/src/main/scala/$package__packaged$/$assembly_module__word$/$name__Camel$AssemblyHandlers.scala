
package $package$.$assembly_module;format="word"$

import akka.actor.typed.scaladsl.ActorContext
import csw.framework.models.CswContext
import csw.framework.scaladsl.ComponentHandlers
import csw.command.client.messages.TopLevelActorMessage
import csw.params.commands.{CommandResponse, ControlCommand}
import csw.location.api.models.TrackingEvent

import scala.concurrent.{ExecutionContextExecutor, Future}

/**
 * Domain specific logic should be written in below handlers.
 * This handlers gets invoked when component receives messages/commands from other component/entity.
 * For example, if one component sends Submit(Setup(args)) command to $name;format="Camel"$Hcd,
 * This will be first validated in the supervisor and then forwarded to Component TLA which first invokes validateCommand hook
 * and if validation is successful, then onSubmit hook gets invoked.
 * You can find more information on this here : https://tmtsoftware.github.io/csw/commons/framework.html
 */
class $name;format="Camel"$AssemblyHandlers(ctx: ActorContext[TopLevelActorMessage], cswCtx: CswContext) extends ComponentHandlers(ctx,cswCtx) {

  implicit val ec: ExecutionContextExecutor = ctx.executionContext
  private val log = cswCtx.loggerFactory.getLogger

  override def initialize(): Future[Unit] = {
    Future.unit
  }

  override def onLocationTrackingEvent(trackingEvent: TrackingEvent): Unit = {
  }

  override def validateCommand(controlCommand: ControlCommand): CommandResponse = CommandResponse.Completed(controlCommand.runId)

  override def onSubmit(controlCommand: ControlCommand): Unit = {
  }

  override def onOneway(controlCommand: ControlCommand): Unit = {
  }

  override def onShutdown(): Future[Unit] = {
    Future.unit
  }

  override def onGoOffline(): Unit = {
  }

  override def onGoOnline(): Unit = {
  }

}