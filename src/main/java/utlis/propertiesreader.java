package utlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.Test;

public class propertiesreader 

{
  @Test
  public static String propertiefileReader(String filepath,String key)
  {
	String value=null;
	try(InputStream input=new FileInputStream(filepath))
	{
		//object creation for property class
		Properties prop=new Properties();
		//load a properties file
		prop.load(input);
		//get property will fetch the value according to the key
		value=prop.getProperty(key);
	}
	catch (IOException ex) 
	{
		// TODO: handle exception
		ex.printStackTrace();
	}
	  return value;
  }
  
 
}