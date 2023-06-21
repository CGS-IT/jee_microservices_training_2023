package at.cgsit.jeemicro.resource.useothersrv;


import at.cgsit.jeemicro.restclient.manually.CreateInfoWithClientBuilder;
import at.cgsit.jeemicro.restclient.manually.CreateInfoWithClientBuilderAndDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.logging.Logger;

/**
 * rest enpoint using manually api clients to call other services (not using resteasy client)
 */

@Path("/callproxy_manually")
public class CallOthersWithManuallyImplementedClients {

    @Inject
    Logger LOG;

    @Inject
    CreateInfoWithClientBuilder cIProxy;

    @Inject
    CreateInfoWithClientBuilderAndDTO cIProxy2;


    @Operation( summary = "call other service",
            description = "with manual implementation" )
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String callProxy() {
        String number = cIProxy.createNumber();
        LOG.infov("callproxymannually number {0}", number);
        String number2 = cIProxy2.createNumber();
        LOG.infov("callproxymannually number version2 {0}", number);
        return number2;
    }

}
