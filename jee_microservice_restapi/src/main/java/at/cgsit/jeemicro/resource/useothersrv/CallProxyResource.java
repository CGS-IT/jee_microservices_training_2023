package at.cgsit.jeemicro.resource.useothersrv;


import at.cgsit.jeemicro.restclient.proxy.CreateInfoProxy;
import at.cgsit.jeemicro.restclient.proxy.SimpleDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/callproxy")
public class CallProxyResource {

    @Inject
    Logger LOG;

    @Inject
    @RestClient
    CreateInfoProxy cIProxy;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String callProxy() {

        String number = cIProxy.createNumber();
        LOG.infov("callProxy number {0}", number);
        SimpleDTO dto = cIProxy.createNumber2();
        String infoStr = "callProxy number" + number + " dto: " + dto.toString();
        LOG.infov(infoStr);
        return infoStr;
    }


}
