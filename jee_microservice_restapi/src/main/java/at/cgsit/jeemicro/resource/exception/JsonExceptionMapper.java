package at.cgsit.jeemicro.resource.exception;

import at.cgsit.jeemicro.resource.configproperty.ConfigurationPropertyResource;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class JsonExceptionMapper implements ExceptionMapper<InvalidFormatException> {
    private static final Logger LOG = Logger.getLogger(JsonExceptionMapper.class);

    @Override
    public Response toResponse(InvalidFormatException ex) {

        LOG.errorv("jackson json format exception {0}", ex.getMessage(),ex);

        return Response.status(422)
                .build();
    }
}