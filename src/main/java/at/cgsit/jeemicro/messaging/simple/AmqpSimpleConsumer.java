package at.cgsit.jeemicro.messaging.simple;

import at.cgsit.jeemicro.messaging.ChannelNames;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.Queue;

import static at.cgsit.jeemicro.messaging.ChannelNames.*;

@ApplicationScoped
public class AmqpSimpleConsumer {

    @Inject
    Logger log;

    ArrayList<SimpleAmqpDTO> messages = new ArrayList<>();

    // @Incoming(ChannelNames.testchannel)
    public void consume (JsonObject p) {
        SimpleAmqpDTO simpleAmqpDTO = p.mapTo(SimpleAmqpDTO.class);
        log.info("consume: " + simpleAmqpDTO.toString());
        messages.add(simpleAmqpDTO);
    }

}
