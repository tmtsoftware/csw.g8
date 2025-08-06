package $subsystem;format="lower"$.$name;format="space,norm,word"$deploy

import csw.framework.deploy.containercmd.ContainerCmd
import csw.prefix.models.Subsystem

object $name;format="space,Camel"$ContainerCmdApp {

    def main(args: Array[String]): Unit = {
        ContainerCmd.start("$name;format="normalize"$_container_cmd_app", Subsystem.withNameInsensitive("$subsystem$"),args)
    }
}
