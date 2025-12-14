package apitesting_tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

public class HeaderValidation_api 
{
  @Test(description = "To handle single header in the API header()" ,enabled = false)
  public void registerSuccessful_api_singleHeader()
  {
	  //step1 https://reqres.in/api/register
	  RestAssured.baseURI="https://reqres.in";
	  //step2 POST request API
	  Response response_out=given()
			  .header("Content-Type", "application/json")
			  .header("x-api-key", "reqres_fcc9716683f34df488a5273f619e3d01")
			  .body("{ \"email\": \"eve.holt@reqres.in\", "
			  		+ "\"password\": \"pistol\" }")
			  .when().post("/api/register")
			  .then().statusCode(200).extract().response();
	  System.out.println(response_out.body().asString());
	  System.out.println("----------scenario:01------------");
  }
  
  @Test(description = "To handle multiple headers in the API header" ,enabled = false)
  public void registerSuccessful_api_multipleHeader()
  {
	  //step1 https://reqres.in/api/users?page=2
	  RestAssured.baseURI="https://reqres.in";
	  //step2
	  Response response_output = 
			  given()
			  .queryParam("page" ,2)
			  .header("Content-type","application/json")
			  .header("x-api-key", "reqres_fcc9716683f34df488a5273f619e3d01")
			  .header("Authorization", "bearersfgert1235675jki")
			  .when().get("/api/users")
			  .then().statusCode(200).extract().response();
	  System.out.println(response_output.body().asString());
	  System.out.println("----------scenario:02------------");
  }
  
  @Test(description = "To handle multiple headers though MAP using rest assured")
  public void registerSuccessful_api_multipleHeaderwithMap()
  {
	  //step1 https://reqres.in/api/users?page=2
	  RestAssured.baseURI="https://reqres.in";
	  
	  //step2 map create and hold all the headers
	  Map<String,String> headers_sectionAPI =new HashMap<String, String>();
	  headers_sectionAPI.put("Content-type", "application/json");
	  headers_sectionAPI.put("x-api-key", "reqres_fcc9716683f34df488a5273f619e3d01");
	  headers_sectionAPI.put("Authorization", "bearersfgert1235675jki");
	  headers_sectionAPI.put("Connection","secured");
	  
	  //step3 BDD style request
	  Response response_outcontainer=
			  given().queryParam("page",2).headers(headers_sectionAPI)
			  .when().get("/api/users")
			  .then().statusCode(200).extract().response();
			  System.out.println(response_outcontainer.getStatusCode());
			  System.out.println(response_outcontainer.getHeaders());
			  System.out.println(response_outcontainer.getSessionId());
	  System.out.println(response_outcontainer.body().asString());
	  System.out.println("----------scenario:03------------");
	  
  }
}