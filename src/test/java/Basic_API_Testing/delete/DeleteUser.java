package Basic_API_Testing.delete;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUser {

    @Test
    public void testDeleteUser() {

        // Save the response
        Response response =
                given()
                        .when()
                        .delete("https://reqres.in/api/users/2");

        // Access and print the response for further usage
        System.out.println("Response Body will not be available you will get status code: " + response.statusCode());
    }
}
