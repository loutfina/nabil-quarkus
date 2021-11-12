package com.its4u.rest.client;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.h2.H2DatabaseTestResource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import javax.inject.Inject;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class MessageResourceTest {
    
    @Test
    public void testMessageByUserEndpoint() {
        given()
          .when().get("/messsage/user/nabil")
          .then()
             .statusCode(500);
    }


    

}