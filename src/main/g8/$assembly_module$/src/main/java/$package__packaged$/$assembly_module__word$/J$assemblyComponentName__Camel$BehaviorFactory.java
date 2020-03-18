package $package$.$assembly_module;format="word"$;

import akka.actor.typed.javadsl.ActorContext;
import csw.framework.javadsl.JComponentBehaviorFactory;
import csw.framework.javadsl.JComponentHandlers;
import csw.framework.models.JCswContext;
import csw.command.client.messages.TopLevelActorMessage;

public class J$assemblyComponentName;format="Camel"$BehaviorFactory extends JComponentBehaviorFactory {

    @Override
    public JComponentHandlers jHandlers(ActorContext<TopLevelActorMessage> ctx,JCswContext cswCtx) {
        return new J$assemblyComponentName;format="Camel"$Handlers(ctx, cswCtx);
    }

}
