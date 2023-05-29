package at.cgsit.jeemicro.cdi.beans3;


import at.cgsit.jeemicro.cdi.beans3.qualify.QualifyA;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.io.Serializable;

@QualifyA
@ApplicationScoped
public class QBeanImplA implements QBean, Serializable {
    @Inject
    Logger log;

    @Override
    public String echo(String input) {
        log.info("QBeanImplA called");
        return input;
    }

}
