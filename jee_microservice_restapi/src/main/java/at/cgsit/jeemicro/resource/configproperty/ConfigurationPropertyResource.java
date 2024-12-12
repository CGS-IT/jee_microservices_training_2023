/*
 * This work © 2023 by CGS-IT Solutions GmbH is licensed under Attribution-NonCommercial 4.0 International
 */

package at.cgsit.jeemicro.resource.configproperty;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/configProperty")
public class ConfigurationPropertyResource {
    private static final Logger LOG = Logger.getLogger(ConfigurationPropertyResource.class);

    @ConfigProperty(name = "greeting.message", defaultValue = "default-value")
    String message;

    /**
     * if no path is given, the base path for this resource will be used, which is the @Path("/configProperty")
     * @return hello string appended with the message from the config property
     */
    @GET
    // @Path("/")
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

    @GET
    @Path("/fromProvider")
    @Produces(MediaType.TEXT_PLAIN)
    public String showMessageFromConfigurationProperty() {
        LOG.infov(  "INFO  :: showMessage {0}", message);

        String databaseName = ConfigProvider.getConfig().getValue("greeting.message", String.class);
        Optional<String> maybeDatabaseName = ConfigProvider.getConfig().getOptionalValue("greeting.message", String.class);

        try {
            return "Hello: config read via Config Provider " + maybeDatabaseName;
        } catch (RuntimeException ex ) {
            LOG.error("fehler beim message lesen ", ex);
        }
        return "";
    }
    
}
