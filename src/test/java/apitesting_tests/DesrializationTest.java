package apitesting_tests;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.PojoCall;

public class DesrializationTest 
{
	@Test(description = "PUT REQUEST API", groups = {"Regressiontestsuite","Smoketestsuite"})
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
	    System.out.println(responsebody.getName());
	    
	    Assert.assertEquals("API AUTOMATION TESTING", "API AUTOMATION TESTING");
	    Assert.assertEquals("Automation testing", "Automation testing");
	    System.out.println(response.body().asString());	
	}	
}
