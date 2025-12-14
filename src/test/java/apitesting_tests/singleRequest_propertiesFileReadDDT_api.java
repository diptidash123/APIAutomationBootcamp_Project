package apitesting_tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;
import io.restassured.response.Response;
import utlis.propertiesreader;

public class singleRequest_propertiesFileReadDDT_api 
{
   @Test(description = "Validating the data driven testing through properties file instead of hardcode")
   public void propertiesFilereader_api()
   {
	   //step1 URI: https://reqres.in/api/users/2
	   //RestAssured.baseURI="https://reqres.in";
	   String server_details=propertiesreader.propertiefileReader("Common.properties", "server");
	   
	   //step2
	   Response response=given().header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
			             .when().get(server_details)
			             .then().statusCode(200).extract().response();
	   System.out.println(response.body().asString());
   }
}
