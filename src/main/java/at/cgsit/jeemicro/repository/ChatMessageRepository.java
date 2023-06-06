package at.cgsit.jeemicro.repository;


import at.cgsit.jeemicro.entity.ChatMessageEntity;

import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ChatMessageRepository {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Transactional
    public void reAttach(ChatMessageEntity entity) {
        em.merge(entity);
    }

        
    public ChatMessageEntity readChatMessage(Long id) {
        // direkte Verwendung der find methode des Entity Managers für eine ID
        
        ChatMessageEntity chatMessageEntity = em.find(ChatMessageEntity.class, id);
        
        return chatMessageEntity;
    }

    public Long countChatMessags() {

        Query query = em.createQuery("select count(e) from ChatMessageEntity e");

        Long singleResult = (Long) query.getSingleResult();

        return singleResult;
    }

    public Long countChatMessagsForRoom(String roomName) {

        // like query
        Query query = em.createQuery("select count(e) from ChatMessageEntity e WHERE e.chatRoom like :chatRoomLike ");

        // :chatRoomLike wird durch den eigentlichen Wert ersetzt
        // z.b. "%room1%");
        query.setParameter("chatRoomLike", roomName);

        // equals
        // Query query2 = em.createQuery("select count(e) from ChatMessageEntity e WHERE e.chatRoom = :chatRoomLike ");
        // query2.setParameter("chatRoomLike", roomName);


        Long singleResult = (Long) query.getSingleResult();
        return singleResult;
    }


    @Transactional
    public List<ChatMessageEntity> findChatMessagesWithLikeNameAndOrdedByDate(String likeStatement) {

        // suche alle chat messages and order by date descending

        Query query = em.createQuery(
                "SELECT e from ChatMessageEntity e " +
                        "WHERE e.chatRoom like :chatMessageLike " +
                        "ORDER by e.creationTime DESC" );

        if( !StringUtil.isNullOrEmpty(likeStatement)) {
            query.setParameter("chatMessageLike", likeStatement);
        } else {
            query.setParameter("chatMessageLike", "%");
        }

        List resultList = query.getResultList();
        return resultList;
    }

    public List<ChatMessageEntity> findByNamedQuery(String likeStatement) {

        Query query = em.createNamedQuery("ChatMessageEntity.findByLikeRoomName");

        if( !StringUtil.isNullOrEmpty(likeStatement)) {
            query.setParameter("cmRoomName", likeStatement);
        } else {
            query.setParameter("cmRoomName", "%");
        }
        List resultList = query.getResultList();
        return resultList;
    }



    @Transactional
    public String createChatMessageDBAndReturnCount(String echoIn) {

        ChatMessageEntity entity = new ChatMessageEntity();
        entity.setChatMessage(echoIn);
        entity.setChatRoom("room1");
        entity.setUserName("username");
        entity.setCreationTime(LocalDateTime.now());

        em.persist(entity);

        String result = countChatMessags().toString();

        return "count is: " + result;
    }



    @Transactional(Transactional.TxType.REQUIRED)
    public void insertChatMessage(ChatMessageEntity newObject) {
        em.persist(newObject);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int deleteAllChatMessageEntity() {
        Query query = em.createQuery("DELETE FROM ChatMessageEntity");
        // returns the number of deleted entities
        int i = query.executeUpdate();
        return i;
    }

    public void insertChatMessageManualTX(ChatMessageEntity newObject) throws SystemException, NotSupportedException {
        utx.begin();
        try {
            em.persist(newObject);
            utx.commit();
        } catch (Exception e) {
            utx.rollback();
            throw new RuntimeException("tx erorr ",e);
        }
    }




    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteWithoutLoading(Long idToDelete) {

        Query query = em.createQuery("delete from ChatMessageEntity where id = :id");

        query.setParameter("id", idToDelete).executeUpdate();
    }

    /**
     * delete entity if object is already loaded
     * @param entity
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteByObject(ChatMessageEntity entity) {

        em.remove(entity);

    }


    @Transactional
    public List<ChatMessageEntity>
    findChatMessagesWithLikeNameAndOrdedByDateWithQueryBuilder(String likeStatement ) {

        // "SELECT e from ChatMessageEntity e WHERE e.chatRoom like :chatMessageLike ORDER by e.creationTime DESC"


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ChatMessageEntity> criteriaQuery = cb.createQuery(ChatMessageEntity.class);
        Root<ChatMessageEntity> from = criteriaQuery.from(ChatMessageEntity.class);

        criteriaQuery.select( from );

        Predicate like = cb.like(from.get("chatRoom"), likeStatement);
        criteriaQuery.where( like );

        Order orderByCT = cb.desc(from.get("creationTime"));
        criteriaQuery.orderBy(orderByCT );

        Query query = em.createQuery(criteriaQuery);
        List<ChatMessageEntity> resultList = query.getResultList();

        return resultList;
    }


    public Long countChatMessages() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<ChatMessageEntity> from = query.from(ChatMessageEntity.class);

        Expression<Long> count = cb.count(from);
        query.select( count );

        // cq.where(/*your stuff*/);

        TypedQuery<Long> query1 = em.createQuery(query);

        Long singleResult = query1.getSingleResult();

        return singleResult;
    }


}
