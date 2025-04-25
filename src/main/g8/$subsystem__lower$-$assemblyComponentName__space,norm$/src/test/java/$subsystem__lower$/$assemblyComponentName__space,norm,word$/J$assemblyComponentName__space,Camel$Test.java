package $subsystem;format="lower"$.$assemblyComponentName;format="space,norm,word"$;

import csw.location.api.javadsl.ILocationService;
import csw.location.api.javadsl.JComponentType;
import csw.location.api.models.PekkoLocation;
import csw.location.api.models.ComponentId;
import csw.location.api.models.Connection;
import csw.prefix.models.Prefix;
import csw.testkit.javadsl.FrameworkTestKitJunitResource;
import csw.testkit.javadsl.JCSWService;
import org.testng.Assert;
import org.testng.BeforeClass;
import org.testng.ClassRule;
import org.testng.Test;
import org.scalatestplus.testng.TestNGSuite;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class J$assemblyComponentName;format="space,Camel"$Test extends TestNGSuite {

    @ClassRule
    public static final FrameworkTestKitJunitResource testKit =
        new FrameworkTestKitJunitResource(Arrays.asList(JCSWService.AlarmServer, JCSWService.EventServer));

    @BeforeClass
    public static void setup() {
        // uncomment if you want one Assembly run for all tests
        testKit.spawnStandalone(com.typesafe.config.ConfigFactory.load("J$assemblyComponentName;format="space,Camel"$Standalone.conf"));
    }

    @Test
    public void testAssemblyShouldBeLocatableUsingLocationService() throws ExecutionException, InterruptedException {
        Connection.PekkoConnection connection = new Connection.PekkoConnection(new ComponentId(Prefix.apply("$subsystem$.$assemblyComponentName;format="package"$"), JComponentType.Assembly));
        ILocationService locationService = testKit.jLocationService();
        PekkoLocation location = locationService.resolve(connection, Duration.ofSeconds(10)).get().get();

        Assert.assertEquals(location.connection(), connection);
    }
}