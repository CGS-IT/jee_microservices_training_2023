package at.cgsit.jeemicro.cdi.events;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SpecialService {

    @Inject
    Event<SpecialEvent> event;

    public void doSomething() {
        event.fire(new SpecialEvent("Special Event"));
    }
}
