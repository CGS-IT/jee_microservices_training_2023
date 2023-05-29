package at.cgsit.jeemicro.resource.cdi;


import at.cgsit.jeemicro.cdi.simple.SetterInjection;
import at.cgsit.jeemicro.cdi.simple.SimpleCDIBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/simplecdi")
public class CDISimpleResource {

    @Inject
    private SimpleCDIBean cdiBean;

    @Inject
    private SetterInjection setterInjection;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String requestScope() {
        String new_value = cdiBean.echo("new value");
        String setter_injection = setterInjection.echo("setter injection");
        return new_value + " " + setter_injection;
    }
}
