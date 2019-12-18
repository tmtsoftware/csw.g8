package $package$.$deploy_module;format="word"$

import csw.framework.deploy.containercmd.ContainerCmd
import csw.prefix.models.Subsystem

object $name;format="Camel"$ContainerCmdApp extends App {

   ContainerCmd.start("$name;format="normalize"$-container-cmd-app", Subsystem.withNameInsensitive("$subsystem$"),args)

}
