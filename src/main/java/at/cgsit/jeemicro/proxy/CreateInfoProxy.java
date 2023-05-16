package at.cgsit.jeemicro.proxy;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/createinfo")
@Produces(MediaType.TEXT_PLAIN)
@RegisterRestClient
public interface CreateInfoProxy {

    @GET
    String createNumber();

}
