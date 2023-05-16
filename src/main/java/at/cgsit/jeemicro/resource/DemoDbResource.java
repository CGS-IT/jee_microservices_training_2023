package at.cgsit.jeemicro.resource;

import at.cgsit.jeemicro.repository.DemoServiceDb;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/helloDemo")
public class DemoDbResource {

    @Inject
    Logger LOG;

    @Inject
    DemoServiceDb service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloSimple2() {
        return "Hello helloDemo TEST2";
    }

    /**
     * http://localhost:8080/helloDemo/echo/<inputString>
     * @param inputString
     * @return service processed input string
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/createCMWithName/{inputString}")
    public String createCMWithName(
            @PathParam("inputString") String inputString) {

        LOG.infov("log: {0}", inputString);
        return "Hello [" + service.createChatMessageDBAndReturnCount(inputString ) + "]";
    }


}
