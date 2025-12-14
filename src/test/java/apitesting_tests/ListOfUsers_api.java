package apitesting_tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ListOfUsers_api 
{
@Test(description = "This api is to validate the query parameter in rest assured")
public void listofusers_api_queryParameter()
{
	//In-case of query parameter never pass "?" inside this statement .get("/comments")
	//because already we are using query parameter: queryParam("postId", 1)
	//step1 baseURI: https://jsonplaceholder.typicode.com/comments?postId=1
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	//step2- GET request to validate the query parameter
	Response output_response=
			given().
			queryParam("postId", 1)
			.when().get("/comments")
			.then().statusCode(200).extract().response();
	System.out.println(output_response.body().asString());
	
}

@Test(description = "This api is to validate the path parameter in rest assured")
public void listofusers_api_pathParameter()
{
	//step1 https:https://reqres.in/api/users/5
	//real time use case https://reqres.in/api/users/{id}
	//https://reqres.in/api/users/5
	//https://reqres.in/api/users/6
	//https://reqres.in/api/users/5
	RestAssured.baseURI="https://reqres.in";
	//step2
	Response container=given()
	.pathParam("id",5).pathParam("code",1)
	.when().get("/api/users/")
	.then().statusCode(200).extract().response();
	System.out.println(container.body().asString());
}

@Test(description = "This api is to validate the form parameter in rest assured media type name= dipti&job=engineer")
public void listofusers_api_formParameter()
{
	//step1 baseURI: https://reqres.in/api/users
	RestAssured.baseURI="https://reqres.in/api";
	//step2- POST request to validate the form parameter
	Response response=
			given()
			.contentType(ContentType.URLENC)
			.formParam("name", "dipti")
			.formParam("job", "engineer")
			.when().post("/users")
			.then().statusCode(201).extract().response();
	
	
	response.then().body("name", equalTo("dipti"));
	response.then().body("job", equalTo("engineer"));
	System.out.println(response.body().asString());
}

}
