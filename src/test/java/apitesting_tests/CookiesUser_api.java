package apitesting_tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
//import static org.hamcrest.Matchers.*;
//import static org.hamcrest.MatcherAssert.assertThat;

public class CookiesUser_api 
{
  @Test(description = "To handle cookies set and fetch cookies from the endpoint", enabled = false)
  public void fetchCookies_api()
  {
	  //step1 baseURI https://reqres.in/api/users/2
	  RestAssured.baseURI="https://reqres.in";
	  
	  //step2
	  Cookie Cookies=new Cookie.Builder("Cookie_key1", "Cookie_value1").build();
	  
	  //step3 GET cookies from the response body
	  Response response_store=given().cookie(Cookies)
	  .when().get("/api/users/2")
	  .then().statusCode(200).extract().response();
	  
	  Map<String, String> container_cookies=response_store.getCookies();
	  Cookies cookie=response_store.getDetailedCookies();
	  cookie.getValue("Cookie_key1");
	  System.out.println(container_cookies);
	  //assertThat(cookie, hasKey("Cookie_key1"));
	  //assertThat(cookie, hasValue("Cookie_value1"));
	  //System.out.println(container_cookies);
  }
  
  @Test()
  public void getsingleCookie_api()
  {
	  //cookie class- cookie() method to set/get/validate the cookies
	  RestAssured.baseURI="https://reqres.in";
	  
	  //How to SET (send) a cookie in Rest Assured
	  Response response=given()
			  .cookie("cookie_name1","cookie_value1")
			  .when().get("/api/users/2")
			  .then().statusCode(200).extract().response();
	  
	  System.out.println(response);
	  
	  //How to SET cookie using Cookie object
	  Cookie cookie=new Cookie.Builder("usersession","pass12345").build();
	  Response response1=given()
			  .cookie(cookie)
			  .when().get("/api/users/2")
			  .then().statusCode(200).extract().response();
	  //How to GET a cookie from response (Most Important)
	  String getcookie_value=response1.getCookie("usersession");
	  System.out.println(getcookie_value);
	  
	  //How to GET all cookies
	  Map<String,String> cookies_fetch=response1.getCookies();
	  System.out.println(cookies_fetch);
	  //assertThat(response1.getCookie("usersession"));
	  
  }
}
