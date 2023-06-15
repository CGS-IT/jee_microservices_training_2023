package at.cgsit.jeemicro.restclient.manually;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.Random.class) // random order of tests
@Disabled // only if external service is running
class CreateInfoWithClientBuilderAndDTOTest {

    @Inject
    CreateInfoWithClientBuilderAndDTO createInfoWithClientBuilderAndDTO;

    @Test
    public void testCreateNumber() {
        String result = createInfoWithClientBuilderAndDTO.createNumber();
        assertNotNull(result);
    }

}