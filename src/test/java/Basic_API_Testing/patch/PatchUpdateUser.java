package Basic_API_Testing.patch;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PatchUpdateUser {

    @Test
    public void testPatchUserUpdate() {

        // Create the request body using a Map
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Kush");
        requestBody.put("job", "QA Automation Consultant");

        // Save the response
        Response response =
                given()
                        .contentType("application/json")  // Set content type to JSON
                        .body(requestBody)  // Set the request body
                        .when()
                        .patch("https://reqres.in/api/users/2");

        // Access and print the response for further usage
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }
}
