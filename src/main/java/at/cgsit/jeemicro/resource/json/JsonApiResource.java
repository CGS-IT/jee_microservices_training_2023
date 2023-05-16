package at.cgsit.jeemicro.resource.json;


import at.cgsit.jeemicro.resource.json.dto.TestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@Path("/json")
public class JsonApiResource {

    @Inject
    Logger log;

    @GET
    @Path("/objectOutput")
    @Produces(MediaType.APPLICATION_JSON)
    public TestDTO objectOutput(){
        log.infov("objectOutput {0}", "");

        TestDTO dto = new TestDTO();
        dto.setName("name");
        dto.setVorname("voranme");

        return dto;
    }

    @PUT
    @Path("createTestMessage")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TestDTO updateTestMessage(TestDTO input) {
        log.infov("got object : {0}", input.toString());

        return input;
    }

    @POST
    @Path("createTestMessage")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public TestDTO createTestMessagePost(TestDTO input) {
        log.infov("sendChatMessagePost got object : {0}", input.toString());

        return input;
    }


    @GET
    @Path("/objectListOutput")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TestDTO> objectListOutput(){
        log.infov("objectOutput {0}", "");

        TestDTO dto = new TestDTO();
        dto.setName("name");
        dto.setVorname("voranme");

        TestDTO dto2 = new TestDTO();
        dto.setName("name2");
        dto.setVorname("voranme2");

        List result = new ArrayList();
        result.add(dto);
        result.add(dto2);

        return result;
    }

}
