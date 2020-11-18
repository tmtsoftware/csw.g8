package org.tmt.$subsystem;format="lower"$.$name;format="space,norm,word"$deploy;

import csw.framework.deploy.hostconfig.HostConfig
import csw.prefix.models.Subsystem

object $name;format="space,Camel"$HostConfigApp extends App {

   HostConfig.start("$name;format="normalize"$-host-config-app",Subsystem.withNameInsensitive("$subsystem$"), args)

}