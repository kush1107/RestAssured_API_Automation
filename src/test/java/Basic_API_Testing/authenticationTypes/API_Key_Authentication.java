package Basic_API_Testing.authenticationTypes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class API_Key_Authentication {

    // API key
    public String apiKey = "d68a51c8a14592f44f830b22f204f11d";  // Replace with your actual API key

    @BeforeTest
    public void setup() {

        // Base URI of the OpenWeatherMap API
        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";
    }

    @Test(priority = 1)
    public void test_Get_ApiKey_Authentication_query1() {

        // API key and city name
        String apiKey = "d68a51c8a14592f44f830b22f204f11d";  // Replace with your actual API key


        // Provide the API Key in the header
        Response response =
                given()
                    .queryParam("lat", 44.34)  // Add lat,lon,appid as a query parameter
                    .queryParam("lon", 10.99)
                    .queryParam("appid",apiKey)// Add the API key as a query parameter.when()
                .when()
                     .get("/weather");  // Replace with the actual endpoint


        // Print the response
        System.out.println("Response Headers: "+response.headers().toString());
        System.out.println("Response Body: "+response.asPrettyString());


    }


    @Test(priority = 2)
    public void test_Get_ApiKey_Authentication_query2() {

        // Provide the API Key in the header
        Response response =
                given()
                    .queryParam("id", 2172797)  // Add id,appid as a query parameter
                    .queryParam("appid",apiKey)// Add the API key as a query parameter.when()
                .when()
                    .get("/weather")  // Replace with the actual endpoint
                .then()
                        .statusCode(200)
                        .extract()
                        .response();


        // Print the response
        System.out.println("Response Headers: "+response.headers().toString());
        System.out.println("Response Body: "+response.asPrettyString());


    }
}
