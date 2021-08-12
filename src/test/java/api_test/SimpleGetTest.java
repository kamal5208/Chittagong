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


public class SimpleGetTest {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(SimpleGetTest.class);
    @Test
    public void getAllUsers(){
        LOGGER.info("-------API Test:Read(GET) ALL Users");
        //Specify the Rest URL or endpoint of the rest api
        RestAssured.baseURI="https://reqres.in/api/users";

        //Get the RequestSpecification of the request that I want to send to the server
        RequestSpecification httpRequest= RestAssured.given();

       //Make a request to the server and this will return the response
        Response response = httpRequest.request(Method.GET);
        LOGGER.debug(response.getBody().asPrettyString());

        //Validating the response status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Get the json path object instance from the response
        JsonPath jsonPath= response.jsonPath();
        List<String> list = jsonPath.get("data.email");

       //to get 1st index: jsonPath.getString("data[0].email");

        //Validating the specified email exist in the response body
       String emailId = "george.bluth@reqres.in";
        boolean emailExist = list.contains(emailId);
        Assert.assertTrue(emailExist,emailId + "  does not exits");

        System.out.println(list);
        LOGGER.info("------------End Test:Read(GET) All Users");

    }

}
