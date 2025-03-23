package at.cgsit.jeemicro.resource.chat;


import at.cgsit.jeemicro.dto.ChatMessageDTO;
import at.cgsit.jeemicro.entity.ChatMessageEntity;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * doku
 */
@Path("/chatMessageResource")
public class ChatMessageResource {

    @Inject
    Logger LOG;

    @GET
    @Path("/chatMessage")
    @Produces(MediaType.APPLICATION_JSON)
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
