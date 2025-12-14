package apitesting_tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import core.statusCode_validator;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authentication_apis 
{
   @Test(description = "To handle basic authentication uri: https://postman-echo.com/basic-auth")
   public void BasicAuthentication_api()
   {
	   //The test script is to handle the basic authentication of a API End point
	   RestAssured.baseURI="https://postman-echo.com";
	   Response response_store=given()
			   .auth()
			   .basic("postman","password")
			   .when().get("/basic-auth");
	   
	   int Status_code=response_store.statusCode();
	   Assert.assertEquals(Status_code,statusCode_validator.success.code);
	   System.out.println(response_store.body().asString());   
   }
   
   @Test(description = "To handle digest authentication uri: https://postman-echo.com/digest-auth")
   public void DigestAuthentication_api()
   {
	   //The test script is to handle the basic authentication of a API End point
	   RestAssured.baseURI="https://postman-echo.com";
	   Response response_store=given()
			   .auth()
			   .digest("postman","password")
			   .when().get("/digest-auth");
	   
	   int Status_code=response_store.statusCode();
	   Assert.assertEquals(Status_code, statusCode_validator.success.code);
	   System.out.println(response_store.body().asString());
			 
   }
}