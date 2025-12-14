package apitesting_tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;

public class MutipleUsers_api 
{
   @Test(description = "This API will fetch all the user information data from the server")
   public void Mutipleusers_api()
   {
	   //Types of matchers for assertions: containsString/equalTo/is/hasItems/hasSize/
	   // Set base URI for the API https://jsonplaceholder.typicode.com/posts
	   RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	   
	   //Send a GET request and store the response in a variable
	   Response response_variable=given()
			             .when().get("/posts")
			             .then().extract().response();
	   
	   // Use HAMCREST to check that the response body contains specific items using matchers- hasItems()
       assertThat(response_variable.jsonPath().getList("title"),
    		   hasItems("voluptatum itaque dolores nisi et quasi"
    		   ,"quam voluptatibus rerum veritatis"));
       assertThat(response_variable.jsonPath().getList("body"),
    		   hasItems("animi esse sit aut sit nesciunt assumenda eum voluptas\nquia voluptatibus provident quia necessitatibus ea\nrerum repudiandae quia voluptatem delectus fugit aut id quia\nratione optio eos iusto veniam iure",
    		   "ut animi facere\ntotam iusto tempore\nmolestiae eum aut et dolorem aperiam\nquaerat recusandae totam odio"));
       
      // Use HAMCREST to check that the response body contains specific items using matchers- hasSize()
      assertThat(response_variable.jsonPath().getList(""), hasSize(100));
    
      //Use HAMCREST to check that the response body contains specific items using matchers- equalTo()
      //assertThat(response_variable.jsonPath().getList("title"), equalTo("asperiores ea ipsam voluptatibus modi minima quia sint"));
      //.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
   }

   
    @Test(description = "This API will fetch the five set of user information from the server")
    public void SingleuserPostid_api()
    {
    	//baseURI https://jsonplaceholder.typicode.com/comments?postId=1
    	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
    	//GET Request
    	Response response_container=given()
    			.when().get("/comments?postId=1")
    			.then().extract().response();
     //Use HAMCREST to check that the response body contains specific items using matchers- containsString()
     //assertThat(response_variable.jsonPath().getList("title"), containsString("eos dolorem iste accusantium"));
     List<String> allemails=Arrays.asList("Eliseo@gardner.biz","Jayne_Kuhic@sydney.com","Nikita@garfield.biz","Lew@alysha.tv","Hayden@althea.biz");
     assertThat(response_container.jsonPath().getList("email"),contains(allemails.toArray(new String[0])));
}
}