package at.cgsit.jeemicro.proxy;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;

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
    @SimplyTimed(name = "ciproxy_ext_timer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    @Retry(delay = 3, delayUnit = ChronoUnit.SECONDS, maxRetries = 3)
    @Fallback(value = SimpleFallback.class)
    @Timeout(value = 200, unit = ChronoUnit.MILLIS)
    SimpleDTO createNumber2();

}
