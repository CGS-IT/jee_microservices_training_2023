package at.cgsit.jeemicro.resource.configproperty;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ConfigurationPropertyResourceTest {

    @ConfigProperty(name = "greeting.message", defaultValue = "default-value")
    String message;

    @Test
    void showMessageSuccess() {
        given()
                .when()
                .get("/configProperty")
                //.get()
                .then()
                .statusCode(200)
                .body(is(notNullValue()),
                        startsWith("Hello:"),
                        equalTo("Hello: " + message));
    }

    @Test
    void showMessageNotFound404() {
        given()
                .when()
                .get("/configProperty/showXXXXXX")
                .then()
                .statusCode(404);
    }


}