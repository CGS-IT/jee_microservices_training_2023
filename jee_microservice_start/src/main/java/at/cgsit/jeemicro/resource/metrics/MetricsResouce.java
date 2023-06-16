package at.cgsit.jeemicro.resource.metrics;


import at.cgsit.jeemicro.dto.ChatMessageDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * doku
 */
@Path("/metricsResource")
public class MetricsResouce {

    @Inject
    Logger LOG;

    @GET
    @Path("/chatMessage")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "chatMessageFindAllCount", description = "How many primality checks have been performed.")
    @Timed(name = "chatMessageFindAllTimer", description = "A measure of how long it takes to perform the primality test.", unit = MetricUnits.MILLISECONDS)
    public List<ChatMessageDTO> chatMessageFindAll() {
        LOG.info("info  chatMessage ");
        List<ChatMessageDTO> result = new ArrayList<>();
        return result;
    }
    // z.b. http://localhost:8080/chatMessageResource/chatMessage/75
    @Operation( summary = "read a chat message",
            description = "read message with id " )
    @GET
    @Path("/chatMessage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ChatMessageDTO readChatMessage(
            @Parameter(description = "id of the chat message")
            @PathParam("id") Long id) {

        return new ChatMessageDTO();
    }
}
