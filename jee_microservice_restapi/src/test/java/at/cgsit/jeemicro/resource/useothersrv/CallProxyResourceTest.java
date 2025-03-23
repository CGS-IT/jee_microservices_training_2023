package at.cgsit.jeemicro.resource.useothersrv;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(CallProxyResource.class)
@Disabled // only if external service is running .. use mock or alternative bean to test this
class CallProxyResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when()
                // .get("/callproxy_manually") // can be ommitet because of @TestHTTPEndpoint
                .get()
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
        //.body(is("Hello RESTEasy"));
    }
}