package apitesting_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static org.testng.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Fetchheaders_response_api 
{
	@Test(description = "To validate all the headers from the response and specific value from the header")
	public void headersvalidate_response_api()
	{
		//step1 setup URI https://reqres.in/api/users?page=2
		RestAssured.baseURI="https://reqres.in";
		
		//step2 Map handle all the headers
		Map<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "bearer1234354");
		headers.put("x-api-key", "reqres_fcc9716683f34df488a5273f619e3d01");
		headers.put("Connection", "secured");
		
		//step3 BDD style 
		Response response_output=
		given().queryParam("page",2).headers(headers)
		.when().get("/api/users")
		.then().statusCode(200).extract().response();
		
		//step4 fetch headers from the server and validate a specific key as per the req.(Headers class)
		
		Headers Containers=response_output.getHeaders();
		for(Header Store:Containers)
		{
			if(Store.getName().contains("Server"))
			{
				System.out.println(Store.getName() + " : " + Store.getValue());
				Assert.assertEquals(Store.getValue(), "cloudflare");
				System.out.println("The execution is completed");
			}	
			if(Store.getName().contains("Access-Control-Allow-Methods"))
			{
				System.out.println(Store.getName() + " : " + Store.getValue());
				Assert.assertEquals(Store.getValue(), "GET, POST, PUT, DELETE, OPTIONS");
				System.out.println("The execution is completed");
			}	
					
		}
	}

}
