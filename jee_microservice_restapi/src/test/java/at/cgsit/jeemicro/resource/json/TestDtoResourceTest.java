package at.cgsit.jeemicro.resource.json;

import at.cgsit.jeemicro.ExampleResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(ExampleResource.class)
class TestDtoResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }
    
}