package apitesting_tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
//import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utlis.jsonreader;
import utlis.propertiesreader;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class combinedTestDDT_JsonPropertiesFile_api 
{
 @Test
 public void combinedTestDDT_JsonProperties_file_api() throws IOException, ParseException
 {
	 //simpler way to create a post request and capture the response status code with entire response body.
	 //convert the test script into data driven testing using json and properties file together (instead for hardcode)
	 
	 //step1 https://reqres.in/api/users
	 //RestAssured.baseURI="https://reqres.in";
	 
	 //step2 
	 
	 Map<String, String> payload = new HashMap<>();
	 payload.put("name", "dipti");
	 payload.put("job", "engineer");
	 
	 String server_address=propertiesreader.propertiefileReader("Common.properties","server");
	 String server_endpoint= jsonreader.getTestData("endpoint");
	 String common_uri= server_address + server_endpoint;
	 Response response=given()
			           .contentType(ContentType.JSON)
			           .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
			           .body(payload)
			           .when().post(common_uri)
			           .then().statusCode(201).extract().response();
	 
	assertThat(response.jsonPath().getString("name"), equalTo("dipti"));
	assertThat(response.jsonPath().getString("job"), equalTo("engineer"));
	//assertThat(statusCode_validator.created, 201);
	System.out.println(response.body().asString());
			           
 }
}