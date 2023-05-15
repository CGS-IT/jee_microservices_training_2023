package at.cgsit.jeemicro.repository;


import at.cgsit.jeemicro.entity.ChatMessageEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@ApplicationScoped
public class DemoServiceDb {

    @Inject
    EntityManager em;

    @Transactional
    public String createChatMessageDBAndReturnCount(String echoIn) {

        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setChatMessage(echoIn);
        entity.setChatRoom("room1");
        entity.setUserName("username");
        entity.setCreationTime(LocalDateTime.now());

        em.persist(entity);

        Query query = em.createQuery("select count(e) from ChatMessageEntity e");
        Long singleResult = (Long) query.getSingleResult();
        return "count is: " + singleResult.toString();
    }


    @Transactional(Transactional.TxType.REQUIRED)
    public void insertChatMessage(ChatMessageEntity newObject) {
        em.persist(newObject);
    }


}
