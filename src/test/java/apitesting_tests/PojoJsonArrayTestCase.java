package apitesting_tests;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.CityCall;
import pojo.PojoCall;
public class PojoJsonArrayTestCase 
{
	@Test(description = "POST REQUEST API Using Pojo(JSONARRAY)",groups = "Regressiontestsuite")
	public void postRequest_api_endpoint_PojoJsonArray()
	{
		List<String> variable=new ArrayList<>();
		variable.add("java");
		variable.add("python");
		variable.add("selenium");
		
		//CityCall class object create:01
		CityCall ccall1=new CityCall();
		ccall1.setName("bhubaneswar");
		ccall1.setTemperature("45");
		
		//CityCall class object create:02
		CityCall ccall2=new CityCall();
		ccall2.setName("berhampur");
		ccall2.setTemperature("50");
		
		//object to conversion simple Array list
		List<CityCall> calling=new ArrayList<>();
		calling.add(ccall1);
		calling.add(ccall2);
		
		PojoCall call=new PojoCall();
		call.setName("dipti ranjan dash");
		call.setJob("software engineer - chennai");
		call.setLanguages(variable);
		call.setCity(calling);
		
		Response response_container=given().baseUri("https://reqres.in")
		       .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		       .contentType(ContentType.JSON)
		       .body(call)
		       //\" in java means double quote \"name\" "name" : "Dipti"
		       .when().post("/api/users")
		       .then().statusCode(201).extract().response();
	    PojoCall requestBody=response_container.as(PojoCall.class);
	    System.out.println(requestBody.getName());
	    Assert.assertEquals(requestBody.getName(), "dipti ranjan dash");
	    Assert.assertEquals(requestBody.getJob(), "software engineer - chennai");
	    //Assert.assertEquals(requestBody.getLanguages(), "java");
	    //Assert.assertEquals(requestBody.getCity().);
		
		System.out.println(response_container.body().asString());
    }
	
	@Test(description = "PUT REQUEST API", groups = {"Regressiontestsuite","Smoketestsuite"}, enabled = false)
	public void putRequest_api_endpoint_Pojo()
	{
        PojoCall call1=new PojoCall();
        call1.setName("Automation testing");
        call1.setJob("API AUTOMATION TESTING");
		//https://reqres.in/api/users/2
	    Response response=given()
		.baseUri("https://reqres.in")
		.header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		.contentType(ContentType.JSON)
		.body(call1)
		.when().put("/api/users/2")
		.then().statusCode(200).extract().response();
	    PojoCall responsebody=response.as(PojoCall.class);
	    System.out.println(responsebody.getJob());
	    
	    Assert.assertEquals("Automation testing", "Automation testing");
	    System.out.println(response.body().asString());	
	}	
	
	@Test(description = "PATCH REQUEST API",groups = "Smoketestsuite", enabled = false)
	public void patchRequest_api_endpoint_Pojo()
	{
		PojoCall call2=new PojoCall();
		call2.setName("dipti");
		call2.setJob("zion resident");
		
		//https://reqres.in/api/users/2
	    Response response=given()
		.baseUri("https://reqres.in")
		.header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		.contentType(ContentType.JSON)
		.body(call2)
		.when().patch("/api/users/2")
		.then().statusCode(200).extract().response();
	    System.out.println(response.body().asString());	
	    //Assert.assertEquals("software engineer", "software engineer");
			
	}	
}