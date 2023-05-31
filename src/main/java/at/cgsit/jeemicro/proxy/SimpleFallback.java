package at.cgsit.jeemicro.proxy;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import java.util.Random;

public class SimpleFallback implements FallbackHandler<SimpleDTO> {

    @Override
    public SimpleDTO handle(ExecutionContext context) {
        return getFallback();
    }

    SimpleDTO getFallback() {
        SimpleDTO dto = new SimpleDTO();
        Long l = new Random().nextLong();

        dto.setValueA("1");
        dto.setValueB("2");
        return dto;
    }

}
