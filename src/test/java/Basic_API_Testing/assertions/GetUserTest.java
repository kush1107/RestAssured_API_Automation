package Basic_API_Testing.assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetUserTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";  // Set the base URI
    }

    @Test
    public void testGetUser() {

        // Save the response
        Response response =
                given()
                        .when()
                        .get("/api/users/2");

        // Access and print the response for further usage
        System.out.println("Response Body: " + response.getBody().asPrettyString());

        // Assert status code, content type, and body field
        response.then()
                .assertThat()
                .statusCode(200)  // Check status code = 200
                .time(lessThanOrEqualTo(5000L)) // Check response time is less or equal to 5 seconds
                .contentType(ContentType.JSON)  // Ensure the response is JSON
                .body("data.id", equalTo(2)) // Validate that "id" field is equal to 2
                .body("data.first_name", equalTo("Janet")); // Validate that "first_name" field is equal to Janet

    }
}
