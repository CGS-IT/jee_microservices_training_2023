package at.cgsit.jeemicro.repository;

import at.cgsit.jeemicro.entity.ChatMessageEntity;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ChatMessageRepositoryTest {

    @Inject
    Logger log;

    @Inject
    ChatMessageRepository cmRepository;

    @Test
    void readChatMessage() {
        ChatMessageEntity cmEntity = cmRepository.readChatMessage(1L);
        assertNotNull(cmEntity);
        log.info("cmresult" + cmEntity.toString());
    }
}