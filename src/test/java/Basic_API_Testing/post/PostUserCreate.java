package Basic_API_Testing.post;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostUserCreate {

    @Test
    public void testPostUserCreate() {

        // Create the request body using a Map
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "John");
        requestBody.put("job", "Developer");

        // Save the response
        Response response =
                given()
                        .contentType("application/json")  // Set content type to JSON
                        .body(requestBody)  // Set the request body
                        .when()
                        .post("https://reqres.in/api/users");

        // Access and print the response for further usage
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }
}
