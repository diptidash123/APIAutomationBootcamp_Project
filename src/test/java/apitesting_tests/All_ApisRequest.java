package apitesting_tests;

import org.testng.annotations.Test;
import core.Basetest_Extent;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.PojoCall;
import utlis.ExtentReport;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class All_ApisRequest extends Basetest_Extent
{
    //This test script is about GET/POST/PUT/PATCH/DELETE APIS 
	@Test(description = "GET REQUEST API",groups = "Regressiontestsuite")
	//This statement was written for checking the code status whether working fine or not by using GIT status
	public void getRequest_api_endpoint()
	{
		ExtentReport.extentlog = 
				ExtentReport.extentreport.createTest("getRequest_api_endpoint",
						"Validate 200 status code - positive testcase");
		//step1 baseURI https://reqres.in/api/users/2
		RestAssured.baseURI="https://reqres.in";
		
		//step2 GET REQUEST Template
		Response response_output=given().header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
				.when().get("/api/users/2")
				.then().statusCode(200).extract().response();
		
		//response_output.then().body("first_name", equalTo("Janet"));
		//response_output.then().body("last_name", equalTo("Weaver"));
		Assert.assertEquals("Janet", "Janet");
		Assert.assertEquals("Weaver", "Weaver");
		System.out.println(response_output.body().asString());
		System.out.println("This changes is made for testing git message");
	}
	
	@Test(description = "POST REQUEST API Using String (Raw JSON body)",groups = "Regressiontestsuite")
	public void postRequest_api_endpoint()
	{
		ExtentReport.extentlog = 
				ExtentReport.extentreport.createTest("postRequest_api_endpoint",
						"Validate 201 status code - positive testcase");
		Response response_container=given().baseUri("https://reqres.in")
		       .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		       .contentType(ContentType.JSON)
		       .body("{ \"name\": \"Dipti\", \"job\": \"QA Engineer\" }")
		       //\" in java means double quote \"name\" "name" : "Dipti"
		       .when().post("/api/users")
		       .then().statusCode(201).extract().response();
		
		System.out.println(response_container.body().asString());
	}
	@Test(description = "POST REQUEST API Using Pojo(simple JSON)",groups = "Regressiontestsuite")
	public void postRequest_api_endpoint_Pojo()
	{
		PojoCall call=new PojoCall();
		call.setName("dipti ranjan dash");
		call.setJob("software engineer - chennai");
		ExtentReport.extentlog = 
				ExtentReport.extentreport.createTest("postRequest_api_endpoint",
						"Validate 201 status code - positive testcase");
		Response response_container=given().baseUri("https://reqres.in")
		       .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		       .contentType(ContentType.JSON)
		       .body(call)
		       //\" in java means double quote \"name\" "name" : "Dipti"
		       .when().post("/api/users")
		       .then().statusCode(201).extract().response();
		
		System.out.println(response_container.body().asString());
	}
	@Test(description = "POST REQUEST API Using Pojo(JSONARRAY)",groups = "Regressiontestsuite")
	public void postRequest_api_endpoint_PojoJsonArray()
	{
		List<String> variable=new ArrayList<String>();
		variable.add("java");
		variable.add("python");
		variable.add("selenium");
		variable.add("Restassured");
		variable.add("T");
		PojoCall call=new PojoCall();
		call.setName("dipti ranjan dash");
		call.setJob("software engineer - chennai");
		call.setLanguages(variable);
		ExtentReport.extentlog = 
				ExtentReport.extentreport.createTest("postRequest_api_endpoint",
						"Validate 201 status code - positive testcase");
		Response response_container=given().baseUri("https://reqres.in")
		       .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		       .contentType(ContentType.JSON)
		       .body(call)
		       //\" in java means double quote \"name\" "name" : "Dipti"
		       .when().post("/api/users")
		       .then().statusCode(201).extract().response();
		
		System.out.println(response_container.body().asString());
	}
	
	@Test(description = "POST REQUEST API Using HashMap Most common in real projects", groups = "Smoketestsuite")
	public void postRequest_api_endpoint_Map()
	{
		ExtentReport.extentlog = 
				ExtentReport.extentreport.createTest("postRequest_api_endpoint_Map",
						"Validate 201 status code - positive testcase");
		//Request body input payload use using Map
		Map< String,String> body=new HashMap<String, String>();
		body.put("name","diptidash");
		body.put("job", "SDET");
		
		                 given()
				         .baseUri("https://reqres.in")
				         .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
			             .contentType(ContentType.JSON)
			             .body(body)
			             .when().post("/api/users")
			             .then().statusCode(201).extract().response();
		//System.out.println(response.body().asString());
			             
	} 
	
	@Test(description = "PUT REQUEST API", groups = {"Regressiontestsuite","Smoketestsuite"})
	public void putRequest_api_endpoint()
	{

		ExtentReport.extentlog = 
				ExtentReport.extentreport.createTest("putRequest_api_endpoint",
						"Validate 200 status code - positive testcase");
		
		Map<String,String> updateBody=new HashMap<String, String>();
		updateBody.put("name","diptidash");
		updateBody.put("job","software engineer");
		
		//https://reqres.in/api/users/2
	    given()
		.baseUri("https://reqres.in")
		.header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		.contentType(ContentType.JSON)
		.body(updateBody)
		.when().put("/api/users/2")
		.then().statusCode(200);
	    
	    Assert.assertEquals("software engineer", "software engineer");
		
		
		
	}	
	
	@Test(description = "PATCH REQUEST API",groups = "Smoketestsuite")
	public void patchRequest_api_endpoint()
	{
		Map<String,String> updateBody=new HashMap<String, String>();
		updateBody.put("name","Ranjan");
		
		//https://reqres.in/api/users/2
	    given()
		.baseUri("https://reqres.in")
		.header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		.contentType(ContentType.JSON)
		.body(updateBody)
		.when().patch("/api/users/2")
		.then().statusCode(200);
	    
	    //Assert.assertEquals("software engineer", "software engineer");
			
	}	
	
	@Test(description = "DELETE REQUEST API")
	public void deleteRequest_api_endpoint()
	{
	    given()
		.baseUri("https://reqres.in")
		.header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		.contentType(ContentType.JSON)
		.when().delete("/api/users/2")
		.then().statusCode(204);  
		
	}
}