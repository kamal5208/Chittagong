package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleDeleteTest {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(SimpleDeleteTest.class);

    @Test
    public void deleteSingleUser() {
        LOGGER.info("-------API Test:Delete single user");
        //Specify the Rest URL or endpoint of the rest api
        RestAssured.baseURI = "https://reqres.in/api/users";

        //Get the RequestSpecification of the request that I want to send to the server
        RequestSpecification httpRequest = RestAssured.given();
        String id ="2";
        //Make a request to the server and this will return the response
        Response response = httpRequest.request(Method.DELETE,id);
        LOGGER.debug(response.getBody().asPrettyString());

        //Validating the response status code
        Assert.assertEquals(response.getStatusCode(), 204);


        LOGGER.info("------------End Test:Delete single user");
    }
}
