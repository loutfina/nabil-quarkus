package com.its4u.rest.client;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MessageResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/messsage")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy Reactive"));
    }

}