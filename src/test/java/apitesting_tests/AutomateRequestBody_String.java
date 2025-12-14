package apitesting_tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class AutomateRequestBody_String 
{
    //automate request body using string approach for POST/PUT/PATCH methods.
	//convert the JSON data into String
    private	String Apikey_value="reqres_fcc9716683f34df488a5273f619e3d01";
    
	@Test()
	public void automate_post_requestbody()
	{
		//step1
		RestAssured.baseURI="https://reqres.in/";
		//step2
		Response response= given()
        .contentType(ContentType.JSON)
		.header("x-api-key",Apikey_value)
		.body("{\"name\":\"Engineer\",\"job\":\"Software\"}")
		.when().post("api/users")
		.then().statusCode(201).extract().response();
		//step3
		System.out.println(response.body().asString());
		System.out.println("post request is validated successfully");
	}
	
	@Test()
	public void automate_put_requestbody()
	{
		//step1
		RestAssured.baseURI="https://reqres.in/";
		//step2
		Response response= given()
        .contentType(ContentType.JSON)
		.header("x-api-key",Apikey_value)
		.body("{\"name\":\"Engineer\",\"job\":\"SDET\"}")
		.when().put("api/users/2")
		.then().statusCode(200).extract().response();
		//step3
		System.out.println(response.body().asString());
		System.out.println("put request is validated successfully");
	}
	@Test()
	public void automate_patch_requestbody()
	{
		//step1
		RestAssured.baseURI="https://reqres.in/";
		//step2
		Response response= given()
        .contentType(ContentType.JSON)
		.header("x-api-key",Apikey_value)
		.body("{\"name\":\"Dipti\",\"job\":\"SDET\"}")
		.when().patch("api/users/2")
		.then().statusCode(200).extract().response();
		//step3
		System.out.println(response.body().asString());
		System.out.println("patch request is validated successfully");
	}
}