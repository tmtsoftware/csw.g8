package $organization$.$subsystem;format="lower"$.$hcdComponentName;format="space,norm,word"$;

import akka.actor.typed.javadsl.ActorContext;
import csw.framework.javadsl.JComponentBehaviorFactory;
import csw.framework.javadsl.JComponentHandlers;
import csw.framework.models.JCswContext;
import csw.command.client.messages.TopLevelActorMessage;

public class J$hcdComponentName;format="space,Camel"$BehaviorFactory extends JComponentBehaviorFactory {

    @Override
    public JComponentHandlers jHandlers(ActorContext<TopLevelActorMessage> ctx,JCswContext cswCtx) {
        return new J$hcdComponentName;format="space,Camel"$Handlers(ctx, cswCtx);
    }

}
