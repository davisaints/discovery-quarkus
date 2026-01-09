package org.discovery.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class StarWarsResourceTest {
    @Test
    void testPeopleEndpoint() {
        given()
                .when().get("starwars/people")
                .then()
                .statusCode(200);
    }
}