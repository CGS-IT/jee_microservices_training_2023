package at.cgsit.jeemicro.repository;

import at.cgsit.jeemicro.entity.ChatMessageEntity;
import io.quarkus.arc.ArcUndeclaredThrowableException;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.RollbackException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        assertEquals(11L, result.size());
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

    void testQueryLanguageOne() {
        List<ChatMessageEntity> result = cmRepository.findChatMessagesWithLikeNameAndOrdedByDateWithQueryBuilder("room%");
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

    @Test
    void testDeleteWithoutLoading() {
        cmRepository.deleteWithoutLoading( 1L);
        ChatMessageEntity cmResult = cmRepository.readChatMessage(1L);
        assertNull(cmResult);
    }


    @Test
    void testInsertChatMessage() {

        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setChatMessage("echoIn" + new Random().nextLong());
        entity.setChatRoom("room ");
        entity.setUserName("username");

        entity.setCreationTime(LocalDateTime.now());

        cmRepository.insertChatMessage(entity);

        assertNotNull(entity);

        entity.setUserName("afterInsert");
    }


    @Test
    void testInsertChatMessage2() {
        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setChatMessage("echoIn" + new Random().nextLong());
        entity.setChatRoom(" df ");
        entity.setUserName("Thris");
        entity.setCreationTime(LocalDateTime.now());

        cmRepository.insertChatMessage(entity);

        assertNotNull(entity);
    }

    @Test
    void testInsertChatMessageFailWithUserName() {
        ArcUndeclaredThrowableException
                thrown = Assertions.assertThrows(ArcUndeclaredThrowableException.class, () -> {

        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setChatMessage("echoIn" + new Random().nextLong());
        entity.setChatRoom(" df ");
        entity.setUserName("Chris");
        entity.setCreationTime(LocalDateTime.now());

        cmRepository.insertChatMessage(entity);

        });
        Assertions.assertNotNull(thrown);

        ConstraintViolationException cv = (ConstraintViolationException) thrown.getCause().getCause();
        Assertions.assertEquals(1L, cv.getConstraintViolations().size());

        Optional<ConstraintViolation<?>> first = cv.getConstraintViolations().stream().findFirst();
        first.ifPresentOrElse(
                (c) -> {
                    assertEquals("chatMessageAllowed", c.getPropertyPath().toString());
                    assertEquals("this chat message is not allowed. because of user name", c.getMessage());
                },
                () -> {
                    fail("No ConstraintViolation found");
                }
        );


    }





}