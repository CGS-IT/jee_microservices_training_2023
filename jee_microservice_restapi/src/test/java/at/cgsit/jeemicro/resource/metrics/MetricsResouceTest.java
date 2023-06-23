package at.cgsit.jeemicro.resource.metrics;

import at.cgsit.jeemicro.ExampleResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(MetricsResouce.class)
class MetricsResouceTest {

    @Test
    public void testMetricsCallByList() {
        given()
                .when()
                .get("/chatMessage")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }

    @Test
    public void testMetricsCallByID() {
        given()
                .when()
                .get("/chatMessage/1")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }


}