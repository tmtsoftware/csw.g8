package $package$.$hcd_module;format="word"$

import akka.actor.typed.scaladsl.ActorContext
import csw.framework.models.CswContext
import csw.framework.scaladsl.{ComponentBehaviorFactory, ComponentHandlers}
import csw.command.messages.TopLevelActorMessage

class $name;format="Camel"$HcdBehaviorFactory extends ComponentBehaviorFactory {

  override def handlers(ctx: ActorContext[TopLevelActorMessage], cswCtx: CswContext): ComponentHandlers =
    new $name;format="Camel"$HcdHandlers(ctx, cswCtx)

}
