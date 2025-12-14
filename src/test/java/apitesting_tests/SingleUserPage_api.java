package apitesting_tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SingleUserPage_api 
{
 @Test(description = "The requirement is to validate all the fields for a single user that belongs to url=https://reqres.in/api/users?page=2")
 public void SingleUser_page_api()
 {
	 //setup baseURI of the API End point
	 RestAssured.baseURI="https://reqres.in/api";
	 
	 //GET Request operations
	 Response response=given()
	 .when().get("/users?page=2")
	 .then().extract().response();
	 //validation of all individual fields in the response!
	 response.then().body("data[0].id", is(7));
	 response.then().body("data[0].email", equalTo("michael.lawson@reqres.in"));
	 response.then().body("data[0].first_name", is("Michael"));
	 response.then().body("data[0].last_name", is("Lawson"));
	 response.then().body("data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"));
	 
	 response.then().body("data[1].id", is(8));
	 response.then().body("data[1].email", equalTo("lindsay.ferguson@reqres.in"));
	 response.then().body("data[1].first_name", is("Lindsay"));
	 response.then().body("data[1].last_name", is("Ferguson"));
	 response.then().body("data[1].avatar", equalTo("https://reqres.in/img/faces/8-image.jpg"));
	 
 }
}