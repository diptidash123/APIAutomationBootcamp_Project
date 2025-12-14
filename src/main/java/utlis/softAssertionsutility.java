package utlis;

import org.testng.asserts.SoftAssert;

public class softAssertionsutility 
{
  //This is a wrapper class over the soft assertion to reduce the no.of methods instead we will use only
  //those methods in our project whichever is required. assertAll/assertTrue/assertFalse/assetEquals/assertNotEquals
	private SoftAssert softAssert;
	
	public softAssertionsutility()
	{
		softAssert =new SoftAssert();
	}
    
	public void assertTrue(boolean conditon,String message)
	{
		try
		{
			softAssert.assertTrue(conditon,message);
		}
		catch(AssertionError e)
		{
			softAssert.fail(message);
		}
	}
	
	public void assertEquals(Object actual,Object expected,String message)
	{
		try
		{
			softAssert.assertEquals(actual, expected,message);
		}
		catch(AssertionError e)
		{
			softAssert.fail(message);
		}
	}
	
	public void assertNotEquals(Object actual,Object expected,String message)
	{
		try
		{
		 softAssert.assertNotEquals(actual,expected,message);	
		}
		catch(AssertionError e)
		{
			softAssert.fail(message);
		}
	}
	public void assertFalse(boolean conditon,String message)
	{
		try
		{
			softAssert.assertFalse(conditon,message);
		}
		catch(AssertionError e)
		{
			softAssert.fail(message);
		}
	}
	
	public void assertAll()
	{
		softAssert.assertAll();
	}
	
}