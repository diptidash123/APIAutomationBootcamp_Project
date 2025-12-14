package apitesting_tests;

import org.testng.annotations.Test;
//import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SingleUser_api 
{
  
       @Test(description = "Second rest assured test script")
       public void Singleuser_api()
       {
    	   //baseURI - https://jsonplaceholder.typicode.com/posts/1
    	   RestAssured.baseURI="https://jsonplaceholder.typicode.com";
    	   
    	   //GET API calling
    	   //given/when/then and then validations
    	   given() //request specification
    	   .when().get("/posts/1") //response specification
    	   .then().assertThat() //validatable specification
    	   .statusCode(200)
    	   //response body is empty or not .body(not(isEmptyString()) is deprecated by rest assured.
    	   //validating all the response body fields
    	   .body("userId", equalTo(1))
    	   .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
    	   .body("id", equalTo(1))
    	   .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));

    	   
       }
   
}