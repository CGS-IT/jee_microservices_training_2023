package at.cgsit.jeemicro.resource.json;


import at.cgsit.jeemicro.resource.configproperty.ConfigurationPropertyResource;
import at.cgsit.jeemicro.resource.json.dto.TestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Test DTO Resource is an example for a REST Resource with JSON DTOs result
 * and it provides Http methods for CRUD operations in a restful way.
 */
@Path("/testdto")
public class TestDtoResource {
    private static final Logger LOG = Logger.getLogger(TestDtoResource.class);

    @Operation( summary = "read a Test DTO Object by ID",
            description = "read a Test DTO Object by ID and return it",
            operationId = "readTestDtoById")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TestDTO readObjectById(
            @Parameter(name = "input", description = "The TestDTO Input object to store", required = true, allowEmptyValue = false)
            @PathParam("id") String id
    ){
        LOG.infov("input {} , objectOutput {0}",  id, "");

        TestDTO dto = new TestDTO();
        dto.setName("name");
        dto.setVorname("voranme");

        return dto;
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TestDTO> listAllObects(){
        LOG.infov("objectOutput {0}", "");

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
        LOG.infov("updateTestMessage got object with {id} :object {0}", id, input.toString());

        return input;
    }

    @POST
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public TestDTO createTestMessagePost(TestDTO input) {
        LOG.infov("createTestMessagePost : {0}", input.toString());

        return input;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteTestDto(@PathParam("id") String id) {
        LOG.infov("got object with {id}", id);

        return "object deleted";
    }


}
