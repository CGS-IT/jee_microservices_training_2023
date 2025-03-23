package at.cgsit.jeemicro.messaging.simple;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.scheduler.Scheduled;
import jakarta.inject.Inject;

@ApplicationScoped
public class SimpleScheduler {

    @Inject
    AmqpSimpleProducer simpleAmqpProducer;


    @Scheduled(every="10s")
    void increment() {
        SimpleAmqpDTO simpleAmqpDTO = new SimpleAmqpDTO();
        simpleAmqpDTO.setValueA("A");
        simpleAmqpDTO.setValueB("B");

        simpleAmqpProducer.produce(simpleAmqpDTO);

    }
}
