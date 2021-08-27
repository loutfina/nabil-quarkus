package com.its4u.rest.client;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import javax.inject.Inject;

@QuarkusTest
public class MessageResourceTest {
    
    @Test
    public void testMessageByUserEndpoint() {
        given()
          .when().get("/messsage/user/nabil")
          .then()
             .statusCode(500);
    }


    

}