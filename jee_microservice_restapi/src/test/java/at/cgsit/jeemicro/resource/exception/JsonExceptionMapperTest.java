package at.cgsit.jeemicro.resource.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonExceptionMapperTest {

    @Test
    public void testJsonExceptionMapper() {

        JsonExceptionMapper mapper = new JsonExceptionMapper();
        Response test = mapper.toResponse(new InvalidFormatException(null, "test", null, null));

        assertEquals(422, test.getStatus());

    }

}