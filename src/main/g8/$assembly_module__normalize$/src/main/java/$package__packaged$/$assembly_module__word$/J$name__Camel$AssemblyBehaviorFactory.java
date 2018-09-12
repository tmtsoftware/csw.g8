package $package$.$assembly_module;format="word"$;

import akka.actor.typed.javadsl.ActorContext;
import csw.framework.javadsl.JComponentBehaviorFactory;
import csw.framework.javadsl.JComponentHandlers;
import csw.framework.models.JCswContext;
import csw.messages.TopLevelActorMessage;

public class J$name;format="Camel"$AssemblyBehaviorFactory extends JComponentBehaviorFactory {

    @Override
    public JComponentHandlers jHandlers(
        ActorContext<TopLevelActorMessage> ctx,
        JCswContext cswCtx
    ) {
        return new J$name;format="Camel"$AssemblyHandlers(ctx, cswCtx);
    }

}
