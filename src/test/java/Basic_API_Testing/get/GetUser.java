package Basic_API_Testing.get;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetUser {

    @Test
    public void testGetUser() {

        // Save the response
        Response response =
                given()
                        .when()
                        .get("https://reqres.in/api/users/2");

        // Access and print the response for further usage
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }
}
