package at.cgsit.jeemicro.resource.json;


import at.cgsit.jeemicro.resource.json.dto.TestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * TestDtoResource
 * <p>
 *     Test resource for json dto and restfull api. <br/>
 *     CRUD operations for json dto with restfull api http methods.
 */
@Path("/testdto")
public class TestDtoResource {

    @Inject
    Logger log;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TestDTO readObjectById(@PathParam("id") String id){
        log.infov("input {} , objectOutput {0}",  id, "");

        TestDTO dto = new TestDTO();
        dto.setName("name");
        dto.setVorname("voranme");

        return dto;
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TestDTO> listAllObects(){
        log.infov("objectOutput {0}", "");

        TestDTO dto = new TestDTO();
        dto.setId( 1L);
        dto.setName("name");
        dto.setVorname("voranme");

        TestDTO dto2 = new TestDTO();
        dto.setId(2L);
        dto.setName("name2");
        dto.setVorname("voranme2");

        List result = new ArrayList();
        result.add(dto);
        result.add(dto2);

        return result;
    }


    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TestDTO updateTestMessage(
            @PathParam("id") String id,
            TestDTO input) {
        log.infov("updateTestMessage got object with {id} :object {0}", id, input.toString());

        return input;
    }

    @POST
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public TestDTO createTestMessagePost(TestDTO input) {
        log.infov("createTestMessagePost : {0}", input.toString());

        return input;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteTestDto(@PathParam("id") String id) {
        log.infov("got object with {id}", id);

        return "object deleted";
    }


}
