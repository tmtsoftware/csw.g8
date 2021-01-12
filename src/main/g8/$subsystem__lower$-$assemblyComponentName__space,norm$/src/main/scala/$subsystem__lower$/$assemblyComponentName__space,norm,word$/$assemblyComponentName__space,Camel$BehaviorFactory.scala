package $subsystem;format="lower"$.$assemblyComponentName;format="space,norm,word"$
import akka.actor.typed.scaladsl.ActorContext
import csw.framework.models.CswContext
import csw.framework.scaladsl.{ComponentBehaviorFactory, ComponentHandlers}
import csw.command.client.messages.TopLevelActorMessage

class $assemblyComponentName;format="space,Camel"$BehaviorFactory extends ComponentBehaviorFactory {

  override def handlers(ctx: ActorContext[TopLevelActorMessage], cswCtx: CswContext): ComponentHandlers =
    new $assemblyComponentName;format="space,Camel"$Handlers(ctx, cswCtx)

}
