package apitesting_tests;

import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_parameterDataprovider 
{
  @DataProvider(name = "testdata")
  public Object[][] testdata()
  {
	  return new Object[][]
			  {
		       {"1","dipti"},
		       {"2","ranjan"},
		       {"3","dash"}
			  };
  }
  
  @Test(dataProvider = "testdata")
  @Parameters({"id","name"})
	  public void testendpoint(String id,String name)
	  {
		  given().queryParam("id", id)
		  .queryParam("name", name)
		  .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
		  .when().get("https://reqres.in/api/users")
		  .then().statusCode(200);
	  }
  
  
}