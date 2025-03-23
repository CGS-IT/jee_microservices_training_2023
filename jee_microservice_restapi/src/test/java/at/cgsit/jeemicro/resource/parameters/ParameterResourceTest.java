package at.cgsit.jeemicro.resource.parameters;

import at.cgsit.jeemicro.resource.metrics.MetricsResouce;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(ParameterResource.class)
class ParameterResourceTest {

    @Test
    void basePath() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }

    @Test
    void inputParameter() {
        given()
                .when()
                .get("/inputParameter/input")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));

    }

    @Test
    void queryParameter() {
    }

    @Test
    void checkBrowser() {
    }

    @Test
    void login() {
    }

    @Test
    void getRequestHeaders() {
    }
}