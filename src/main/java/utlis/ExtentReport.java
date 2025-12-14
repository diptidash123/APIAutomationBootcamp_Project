package utlis;

import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport 
{
	public static ExtentReports extentreport=null;
	public static ExtentTest extentlog;
	
	public static void initialize(String extentconfigxml)
	{
		if (extentreport == null) 
		{
            //Create Spark Reporter (HTML)
            ExtentSparkReporter spark =
                    new ExtentSparkReporter(extentconfigxml);

            //Load XML config (v5 way)
            try {
				spark.loadXMLConfig(
				        new File("src/test/resources/extent-config.xml")
				);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //Create ExtentReports and attach reporter
            extentreport = new ExtentReports();
            extentreport.attachReporter(spark);

            //System information
            extentreport.setSystemInfo(
                    "Hostname", System.getProperty("user.name"));
            extentreport.setSystemInfo(
                    "Environment", "QA");
            extentreport.setSystemInfo(
                    "Operating System", "MAC OS");
        }
	}
}