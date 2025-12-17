package apitesting_tests;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiChaining_Test 
{
   //API-1: Login & Extract Token
	public String LoginandExtractToken()
	{
		//https://fakestoreapi.com/auth/login
		RestAssured.baseURI="https://fakestoreapi.com";
		Response response=given()
				.contentType(ContentType.JSON)
				.body("{\"username\":\"mor_2314\",\"password\":\"83r5^_\"}")
				.when().post("/auth/login")
				.then().statusCode(201).extract().response();
		String authtoken=response.body().jsonPath().getString("token");
		System.out.println("The token is:" + " " + authtoken);
		System.out.println("API Chaining 1 is successful");
		return authtoken;
	}
	
	//API-2: Use Token in Next Request
	//Create Product (Token Required)
	@Test
	public void CreateProductWithToken()
	{
		String auth_token=LoginandExtractToken();
		//https://fakestoreapi.com/products
	   RestAssured.baseURI="https://fakestoreapi.com";
	   Response response_container=given()
       .contentType(ContentType.JSON)
       .body("{\"id\":21,\"title\":\"AutomationBook\",\"price\":999,\"description\":\"APIchainingexample\",\"image\":\"https://i.pravatar.cc\",\"category\":\"books\"}")
       .header("Authorization", "Bearer " + auth_token)
       .when().post("/products")
       .then().statusCode(201).extract().response();
	   System.err.println("The authentication is successful and the API chaining is working fine");
	   System.out.println("API Chaining 2 is successful");
       
	}
}