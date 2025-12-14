package apitesting_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class TestNG_DataProvider_ParametersAnnotation 
{
    @DataProvider(name = "testdata")
    public Object[][] testdata()
    {
    	return new Object[][]
    			{
    		      {"4","software"},
    		      {"5","engineer"},
    		      {"5","chennai"}
    			};
    			
    }
    
    @Test(dataProvider = "testdata")    
    @Parameters({"id","name"})
    	public void endpoint_validation(String id,String name)
    	{
    	    given()
    	    .queryParam("id", id)
    	    .queryParam("name", name)
    	    .header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
    	    .when().get("https://reqres.in/api/users")
    	    .then().statusCode(200);
    	    //https://reqres.in/api/register/1&dipti
    	   //https://reqres.in/api/register/2&ranjan
    	    //approach1
    	    //approach2 testng.xml file parameters
    	}
    }