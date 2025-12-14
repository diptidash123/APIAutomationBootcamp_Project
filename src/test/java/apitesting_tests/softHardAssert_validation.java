package apitesting_tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import core.statusCode_validator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utlis.softAssertionsutility;

//import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class softHardAssert_validation 
{
	softAssertionsutility softassertions=new softAssertionsutility();
	
  @Test(description = "This test case is to validate hard assertions", enabled = false)
  public void hardAssertions_validation_testcase()
  {
	  //https://reqres.in/api/users/2
	  RestAssured.baseURI="https://reqres.in/";
	  Response response=given()
			            .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
			            .when().get("/api/users/2")
			            .then().statusCode(200).extract().response();
	  /*//Hard Assertion positive test case
	  Assert.assertEquals(response.getStatusCode(), 200);//failure
	  System.out.println("-----Execution is success----");
	  System.out.println("-----------------------------");
	  System.out.println(response.body().asString());*/
	  
	  //Hard Assertion negative test case
	  AssertJUnit.assertEquals(response.getStatusCode(), 204);//failure
	  System.out.println("-----Execution is success----");
	  System.out.println("-----------------------------");
	  System.out.println(response.body().asString());
  }
  
  @Test(description = "This test case is to validate soft assertions")
  public void softAssertions_validation_testcase()
  {
	  //https://reqres.in/api/users/2
	  RestAssured.baseURI="https://reqres.in/";
	  Response response=given()
			            .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
			            .when().get("/api/users/2")
			            .then().statusCode(200).extract().response();
	  //wrapper class calling for soft assertion validation
	  //softassertions.assertEquals(response.getStatusCode(), 200, "Status is not 200");
	  Assert.assertEquals(response.getStatusCode(), statusCode_validator.success.code, "Not found any status 209");
	  softassertions.assertAll();
	  //Soft Assertion positive test case
	  //SoftAssert softassertion=new SoftAssert();
	  //softassertion.assertEquals(response.getStatusCode(), 209);
	  System.out.println("-----Execution is success----");
	  System.out.println("-----------------------------");
	  System.out.println(response.body().asString());
	  //softassertion.assertAll();
}
}