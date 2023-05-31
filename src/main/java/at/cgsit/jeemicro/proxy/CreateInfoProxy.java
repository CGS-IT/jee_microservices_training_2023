package at.cgsit.jeemicro.proxy;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/createinfo")
@Produces(MediaType.TEXT_PLAIN)
@RegisterRestClient()
public interface CreateInfoProxy {

    @GET
    String createNumber();

    @GET
    @Path("/ext")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "ciproxy_ext_counter", description = "How many primality checks have been performed.")
    @Timed(name = "ciproxy_ext_timer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    SimpleDTO createNumber2();

}
