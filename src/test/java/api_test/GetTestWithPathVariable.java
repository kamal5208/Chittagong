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

public class GetTestWithPathVariable {
    private static final Logger LOGGER= LogManager.getLogger(GetTestWithPathVariable.class);
    @Test
    public void getSingleUser(){
        LOGGER.info("-------API Test:Read(GET) Single User with Path variable");
        //Specify the Rest URL or endpoint of the rest api
        RestAssured.baseURI="https://reqres.in/api/users";

        //Get the RequestSpecification of the request that I want to send to the server
        RequestSpecification httpRequest= RestAssured.given();

        //Make a request to the server and this will return the response
        String id = "2";
        Response response = httpRequest.request(Method.GET,id);
        LOGGER.debug(response.getBody().asPrettyString());

        //Validating the response status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Get the json path object instance from the response
        JsonPath jsonPath= response.jsonPath();


        //to get 1st index: jsonPath.getString("data[0].email");

        //Validating the specified email exist in the response body
        String  expectedEmailId = "janet.weaver@reqres.in";
        String actualEmailId = jsonPath.getString("data.email");
        Assert.assertEquals(actualEmailId,expectedEmailId);



        LOGGER.info("------------End Test:Read(GET) Single User with Path Variable");


    }
    @Test
    public void attemptToGetUserWithInvalidId(){
        LOGGER.info("------------End Test:Attempt to retrieve User with Invalid Id");
        //Specify the Rest URL or endpoint of the rest api
        RestAssured.baseURI="https://reqres.in/api/users";

        //Get the RequestSpecification of the request that I want to send to the server
        RequestSpecification httpRequest= RestAssured.given();

        //Make a request to the server and this will return the response
        String invalidId = "23";
        Response response = httpRequest.request(Method.GET,invalidId);
        LOGGER.debug(response.getBody().asPrettyString());

        //Validating the response status code
        Assert.assertEquals(response.getStatusCode(), 404);

        //Validating the response has empty body
        JsonPath jsonPath= response.jsonPath();
        Assert.assertEquals(jsonPath.get().toString(),"{}");

        LOGGER.info("------------End Test:Attempt to retrieve User with Invalid Id");

    }
}
