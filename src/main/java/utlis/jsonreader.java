package utlis;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonreader 
{
	//step:02 calling method
	public static String getTestData(String key) throws IOException, ParseException 
	{
        String testdata;
        return testdata = (String) getJsonData().get(key);//input is the key
       
    }
	
	//step:03 main  method
	public static JSONObject getJsonData() throws IOException, ParseException  
	{
	       
        //pass the path of the testdata.json file
        File filename = new File("src/test/resources/testdata/testdata_1.json");
        
        //convert json file into string
        String json = FileUtils.readFileToString(filename, "UTF-8");
        
        //parse the string into object
        Object obj = new JSONParser().parse(json);
        
        //give jsonobject so that I can return it to the function everytime it get called
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }
}
