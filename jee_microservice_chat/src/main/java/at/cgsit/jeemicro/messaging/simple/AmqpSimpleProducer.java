package at.cgsit.jeemicro.messaging.simple;

import at.cgsit.jeemicro.messaging.ChannelNames;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import java.util.ArrayList;

@ApplicationScoped
public class AmqpSimpleProducer {

    @Inject
    Logger log;

    @Channel(ChannelNames.testchannel)
    Emitter<String> quoteRequestEmitter;

    //@Outgoing(ChannelNames.testchannel)
    public Message<JsonObject> produce(SimpleAmqpDTO simpleAmqpDTO) {
        log.info("produce: " + simpleAmqpDTO.toString());
        return Message.of(JsonObject.mapFrom(simpleAmqpDTO));
    }

}
