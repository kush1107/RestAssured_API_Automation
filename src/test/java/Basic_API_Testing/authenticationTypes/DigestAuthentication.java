package Basic_API_Testing.authenticationTypes;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestAuthentication {


    @Test
    public void test_Get_DigestAuthentication() {

        Response response =
                given()
                        .auth().digest("user", "pass")
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
