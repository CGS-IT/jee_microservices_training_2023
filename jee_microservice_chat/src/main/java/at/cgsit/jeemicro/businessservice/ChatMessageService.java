package at.cgsit.jeemicro.businessservice;


import at.cgsit.jeemicro.entity.ChatMessageEntity;
import at.cgsit.jeemicro.repository.ChatMessageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.jboss.logging.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * this class represents a buisness service class for chat messages
 * so a service class for the business logic
 * it uses the Database Repository to store the data
 */
@ApplicationScoped
public class ChatMessageService {

    @Inject
    Logger log;

    @Inject
    ChatMessageRepository cmService;

    @Inject
    Validator validator;

    /**
     * this method returns all chat messages
     * @return
     */
    public ChatMessageEntity create(ChatMessageEntity createCM ) {

        // 3 Bean Validierungs Varianten sind nun verfügbar:
        //    1. AutomatischeValidierung des DTO via @Valid im Rest API
        //    2. Manuelle Validierung durch Aufruf im ChatMessageService hier
        //    3. Automatische Validierung des Entities bei der JPA/Hibernate Persistierung

        Set<ConstraintViolation<ChatMessageEntity>> violations = validator.validate(createCM);

        if ( !violations.isEmpty()) {
            StringBuffer error = new StringBuffer();
            for (ConstraintViolation<ChatMessageEntity> violation : violations) {
                log.error(violation.getMessage());
                error.append(violation.getMessage() + " : ");
            }
            throw new ConstraintViolationException(
                    new HashSet<ConstraintViolation<?>>(violations));

            // throw new MyBusinessException(error.toString());
        }

        return cmService.insertChatMessage(createCM);
    }

}
