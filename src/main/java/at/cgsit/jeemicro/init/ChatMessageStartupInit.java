package at.cgsit.jeemicro.init;


import io.quarkus.runtime.StartupEvent;
import at.cgsit.jeemicro.entity.ChatMessageEntity;
import at.cgsit.jeemicro.repository.DemoServiceDb;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.annotation.Priority;
import java.time.LocalDateTime;
import java.util.Random;

@Singleton
public class ChatMessageStartupInit {

    @Inject
    EntityManager em;

    @Inject
    DemoServiceDb repository;

    @Transactional
    public void loadUsers(@Observes @Priority(2) StartupEvent evt) {

        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setChatMessage("echoIn" + new Random().nextLong());
        entity.setChatRoom("room1");
        entity.setUserName("username");
        entity.setCreationTime(LocalDateTime.now());

        repository.insertChatMessage(entity);

    }


}
