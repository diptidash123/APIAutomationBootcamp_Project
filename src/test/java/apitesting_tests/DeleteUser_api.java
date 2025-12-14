package apitesting_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
//import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class DeleteUser_api 
{
  @Test()
  public void deleteUser_api()
  {
	  //RestAssured.baseURI="https://reqres.in";
	  //To check the endpoint whether its holds information or not if yes after deleting capture the response and stored
	  //inside the container to Validate statuscode as 204
	  Response respone=given()
			  .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
			  .delete("https://reqres.in/api/users/2");
	  Assert.assertEquals(respone.getStatusCode(),204);
			  
  }
}
