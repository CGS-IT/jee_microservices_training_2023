package at.cgsit.jeemicro.mockito;

import at.cgsit.jeemicro.businessservice.ChatMessageService;
import at.cgsit.jeemicro.entity.ChatMessageEntity;
import at.cgsit.jeemicro.repository.ChatMessageRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.opentest4j.AssertionFailedError;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ChatMessageServicesWithMockDBTest {

    @InjectMock
    ChatMessageRepository chatMsgDbMock;

    @Inject
    ChatMessageService toTest;

    private ChatMessageEntity chatMessage;

    private ChatMessageEntity chatMessageInput;

    /**
     * return a dummy chat message
     * @return
     */
    private ChatMessageEntity returnDummyChatMessage() {
        return chatMessage;
    }


    @BeforeEach
    void setUp() {

        ChatMessageEntity entityInput = new ChatMessageEntity();
        entityInput.setChatMessage("mocktest");
        entityInput.setChatRoom("mocktest");
        entityInput.setUserName( "mocktest");
        chatMessageInput = entityInput;

        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setId(1000L);
        entity.setChatMessage("returned_mocktest");
        entity.setChatRoom("mocktest");
        entity.setUserName( "mocktest");
        entity.setCreationTime(LocalDateTime.now());
        chatMessage = entity;

    }
    @Test
    public void testMockitoDummyReturnwithToReturn() {

        // define what should be returned as mock return object for the method call
        Mockito.when(chatMsgDbMock.insertChatMessage(chatMessageInput)).thenReturn(chatMessage);

        // call tested service but data access will be replaced with mocked one
        ChatMessageEntity created = toTest.create(chatMessageInput);

        assertEquals("returned_mocktest", created.getChatMessage());
        assertEquals(1000L, created.getId());
        assertNotNull(created.getCreationTime());
    }

    @Test
    public void testMockWithException() {
        RuntimeException my_exc = new RuntimeException("my_exc");
        // define mock but throw exception instead of returning a value
        Mockito.when(chatMsgDbMock.insertChatMessage(chatMessageInput)).thenThrow(my_exc);

        // call tested service but data access will be replaced with mocked one and as a result an exception is thrown
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            toTest.create(chatMessageInput);
            }, "Runtime exception was expected");

        assertEquals(my_exc, exception.getCause());
    }

    @Test
    public void testMockWithAnswer() {

        Mockito.when(chatMsgDbMock.insertChatMessage(chatMessageInput))
                .thenAnswer( I -> returnDummyChatMessage());

        // call tested service but data access will be replaced with mocked one
        ChatMessageEntity created = toTest.create(chatMessageInput);

        assertEquals("returned_mocktest", created.getChatMessage());
        assertEquals(1000L, created.getId());
        assertNotNull(created.getCreationTime());
    }

}
