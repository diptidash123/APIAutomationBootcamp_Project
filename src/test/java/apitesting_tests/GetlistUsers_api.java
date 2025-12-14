package apitesting_tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetlistUsers_api 
{
	@Test(description = "First rest assured api test script")
	public void GetListOfUser_api()
	{
		//rest assured API automation testing test structure template format given/when/then
		//given()- pre-requisite(headers/authorization/body/parameters)
		//when()- HTTP method/API End point
		//then()- response body assertion validation
		given().
		when().get("https://reqres.in/api/users?page=2").
		then().assertThat()
		.statusCode(200);
		
		
	}

}