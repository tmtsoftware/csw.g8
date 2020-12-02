package $subsystem;format="lower"$.$name;format="space,norm,word"$deploy

import csw.framework.deploy.containercmd.ContainerCmd
import csw.prefix.models.Subsystem

object $name;format="space,Camel"$ContainerCmdApp extends App {

   ContainerCmd.start("$name;format="normalize"$_container_cmd_app", Subsystem.withNameInsensitive("$subsystem$"),args)

}
