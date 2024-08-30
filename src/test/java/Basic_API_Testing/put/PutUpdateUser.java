package Basic_API_Testing.put;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PutUpdateUser {

    @Test
    public void testPutUserUpdate() {

        // Create the request body using a Map
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Kush");
        requestBody.put("job", "QA");

        // Save the response
        Response response =
                given()
                        .contentType("application/json")  // Set content type to JSON
                        .body(requestBody)  // Set the request body
                        .when()
                        .put("https://reqres.in/api/users/2");

        // Access and print the response for further usage
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }
}
