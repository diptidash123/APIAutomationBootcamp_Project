package apitesting_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import core.statusCode_validator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utlis.jsonreader;

public class Basicauthentication_api_DDT 
{

	@Test(description = "To handle basic authentication uri: https://postman-echo.com/basic-auth")
	   public void BasicAuthentication_api() throws IOException, ParseException
	   {

		   //The test script is to handle the basic authentication of a API End point
		   RestAssured.baseURI="https://postman-echo.com";
		   
		   //data driven testing instead of hard coded values
			String username=jsonreader.getTestData("username");
			String password=jsonreader.getTestData("password");
			System.out.println("The username key:" + username + " " + "The passowrd key:" + password);
		    Response response_store=given()
				   .auth()
				   .basic(username,password)//Instead of hard code values make it data driven testing
				   .when().get("/basic-auth");
		   
		   int Status_code=response_store.statusCode();
		   Assert.assertEquals(Status_code,statusCode_validator.success.code);
		   System.out.println(response_store.body().asString());   
	   }
}
