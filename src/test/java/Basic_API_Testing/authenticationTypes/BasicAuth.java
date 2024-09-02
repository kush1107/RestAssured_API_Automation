package Basic_API_Testing.authenticationTypes;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class BasicAuth {

    @Test
    public void test_Get_BasicAuth() {

        Response response =
                given()
                        .auth().preemptive().basic("user", "pass")
                .when()
                        .get("https://authenticationtest.com/HTTPAuth/")  // Replace with the actual endpoint
                .then()
                        .statusCode(200)
                        .extract()
                        .response();


        // Print the response
        System.out.println("Response Headers: " + response.headers().toString());
        System.out.println("Response Body: " + response.asPrettyString());
    }
}
