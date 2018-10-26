package $package$.$hcd_module;format="word"$

import akka.actor.typed.scaladsl.ActorContext
import csw.framework.CurrentStatePublisher
import csw.framework.scaladsl.{ComponentBehaviorFactory, ComponentHandlers}
import csw.messages.TopLevelActorMessage
import csw.messages.framework.ComponentInfo
import csw.services.command.CommandResponseManager
import csw.services.event.api.scaladsl.EventService
import csw.services.alarm.api.scaladsl.AlarmService
import csw.services.location.scaladsl.LocationService
import csw.services.logging.scaladsl.LoggerFactory

class $name;format="Camel"$HcdBehaviorFactory extends ComponentBehaviorFactory {

  override def handlers(
      ctx: ActorContext[TopLevelActorMessage],
      componentInfo: ComponentInfo,
      commandResponseManager: CommandResponseManager,
      currentStatePublisher: CurrentStatePublisher,
      locationService: LocationService,
      eventService: EventService,
      alarmService: AlarmService,
      loggerFactory: LoggerFactory
  ): ComponentHandlers =
    new $name;format="Camel"$HcdHandlers(ctx, componentInfo, commandResponseManager, currentStatePublisher, locationService, eventService, alarmService, loggerFactory)

}
