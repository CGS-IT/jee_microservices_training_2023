package at.cgsit.jeemicro.resource.parameters;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.jboss.logging.Logger;

import java.util.Map;

@Path("/parameter")
public class ParameterResource {

    @Inject
    Logger log;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String basePath(){
        log.infov("basePath");
        return "basePath";
    }

    @GET
    @Path("/inputParameter/{inputString}")
    @Produces(MediaType.TEXT_PLAIN)
    public String inputParameter(
            @PathParam("inputString") String inputString){
        log.infov("log: {0}", inputString);

        StringBuilder sbStr = new StringBuilder();
        sbStr.append(inputString).reverse();
        return sbStr.toString() + "{}";
    }

    // http://localhost:8080/parameter/queryParameter?qp=inputText&qp2=text2
    @GET
    @Path("/queryParameter")
    @Produces(MediaType.TEXT_PLAIN)
    public String queryParameter(
            @QueryParam("qp") String qp,
            @DefaultValue("1") @QueryParam("qp2") Long qP2
            ){
        log.infov("log QueryParam: {0}", qp);
        return "query params ["+ qp + "] und [" + qP2 + "]";
    }

    @GET
    @Path("header")
    public String checkBrowser(@HeaderParam("User-Agent") String whichBrowser) {
        return "Browser is "+whichBrowser;
    }

    // Reading REST Parameters Programmatically
    // z.b. http://localhost:8080/json/context?username=chris
    @GET
    @Path("context")
    public Response login(@Context UriInfo info) {
        String id = info.getQueryParameters().getFirst("username");
        return Response
                .status(200)
                .entity("login called with id: " + id)
                .build();
    }

    @GET
    @Path("httpheaders")
    public String getRequestHeaders(@Context HttpHeaders hh) {

        StringBuffer sb = new StringBuffer();

        MultivaluedMap<String, String> headerParameters = hh.getRequestHeaders();
        for (String key : headerParameters.keySet()) {
            sb.append(key + ": " + headerParameters.get(key));
            sb.append(" ");
        }

        Map<String, Cookie> params = hh.getCookies();
        for (String key : params.keySet()) {
            sb.append(key + ": " + params.get(key));
        }
        return sb.toString();
    }


}
