package $package$.$hcd_module;format="word"$

import akka.typed.scaladsl.ActorContext
import csw.framework.scaladsl.{ComponentHandlers, CurrentStatePublisher}
import csw.messages.commands.{CommandResponse, ControlCommand}
import csw.messages.framework.ComponentInfo
import csw.messages.location.TrackingEvent
import csw.messages.scaladsl.TopLevelActorMessage
import csw.services.command.scaladsl.CommandResponseManager
import csw.services.location.scaladsl.LocationService
import csw.services.logging.scaladsl.LoggerFactory

class $name;format="Camel"$HcdHandlers(
    ctx: ActorContext[TopLevelActorMessage],
    componentInfo: ComponentInfo,
    commandResponseManager: CommandResponseManager,
    currentStatePublisher: CurrentStatePublisher,
    locationService: LocationService,
    loggerFactory: LoggerFactory
) extends ComponentHandlers(ctx, componentInfo, commandResponseManager, currentStatePublisher, locationService, loggerFactory) {

  implicit val ec: ExecutionContextExecutor = ctx.executionContext
  private val log = loggerFactory.getLogger

  override def initialize(): Future[Unit] = ???

  override def onLocationTrackingEvent(trackingEvent: TrackingEvent): Unit = ???

  override def validateCommand(controlCommand: ControlCommand): CommandResponse = ???

  override def onSubmit(controlCommand: ControlCommand): Unit = ???

  override def onOneway(controlCommand: ControlCommand): Unit = ???

  override def onShutdown(): Future[Unit] = ???

  override def onGoOffline(): Unit = ???

  override def onGoOnline(): Unit = ???

}