package at.cgsit.jeemicro.resource;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/helloMicroDemo")
public class DemoMicroResource {
    private static final Logger LOG = Logger.getLogger(DemoMicroResource.class);

    @ConfigProperty(name = "greeting.message", defaultValue = "default-value")
    String message;

    @GET
    @Path("/showMessage")
    @Produces(MediaType.TEXT_PLAIN)
    public String showMessage() {
        LOG.infov(  "INFO  :: showMessage {0}", message);

        try {
            return "Hello: " + message;
        } catch (RuntimeException ex ) {
            LOG.error("fehler beim message lesen ", ex);
        }
        return "";
    }


}
