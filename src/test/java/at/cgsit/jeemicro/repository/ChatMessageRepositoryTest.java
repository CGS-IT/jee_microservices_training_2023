package at.cgsit.jeemicro.repository;

import at.cgsit.jeemicro.entity.ChatMessageEntity;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @Test
    void testCountMessages() {
        Long aLong = cmRepository.countChatMessags();
        assertNotNull(aLong);
        log.info("cmresult" + aLong.toString());
    }

    @Test
    void testCountMessagesForRoom() {
        Long aLong = cmRepository.countChatMessagsForRoom("room 1");
        assertNotNull(aLong);
        assertEquals(1L, aLong);
        log.info("cmresult" + aLong.toString());
    }

    @Test
    void testCountMessagesForRoomAll() {
        Long aLong = cmRepository.countChatMessagsForRoom("room%");
        assertNotNull(aLong);
        assertEquals(10L, aLong);
        log.info("cmresult" + aLong.toString());
    }

    @Test
    void testCountMessagesForRoomAlListResult() {
        List<ChatMessageEntity> result = cmRepository.findChatMessagesWithLikeNameAndOrdedByDate("room%");
        assertNotNull(result);
        assertEquals(10L, result.size());
        log.info("cmresult " + result.size() );
    }

    @Test
    @Order(1)
    void testFindByNamedQuery() {
        List<ChatMessageEntity> result = cmRepository.findByNamedQuery("room%");
        assertNotNull(result);
        assertEquals(10L, result.size());
        log.info("cmresult " + result.size() );
    }


    @Test
    @Order(2)
    void testFindChatMessagesperLike() {
        List<ChatMessageEntity> echoIn = cmRepository.findChatMessagesWithLikeNameAndOrdedByDate("echoIn");
        assertNotNull(echoIn);
    }



}