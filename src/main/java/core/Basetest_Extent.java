package core;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.Status;
import helper.BasetestHelper;
import utlis.ExtentReport;

public class Basetest_Extent 
{
	@BeforeSuite(alwaysRun = true)
    public void config() throws IOException 
	  {
        String subfolderpath = System.getProperty("user.dir")
                + "/reports_file/"
                + BasetestHelper.Timestamp();
        BasetestHelper.createfolder(subfolderpath);
        ExtentReport.initialize(
                subfolderpath + "/API_Automation.html");
       } 

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method) {
        ExtentReport.extentlog =
                ExtentReport.extentreport.createTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) 
        {
            ExtentReport.extentlog.log(
                    Status.PASS,
                    "Test Case : " + result.getName() + " is passed ");
        } 
        else if (result.getStatus() == ITestResult.FAILURE) 
        {
            ExtentReport.extentlog.log(
                    Status.FAIL,
                    "Test Case : " + result.getName() + " is failed ");
            ExtentReport.extentlog.log(
                    Status.FAIL,
                    "Test case is failed due to: " + result.getThrowable());
        } 
        else if (result.getStatus() == ITestResult.SKIP) 
        {
            ExtentReport.extentlog.log(
                    Status.SKIP,
                    "Test case is skipped " + result.getName());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void endReport() {
        if (ExtentReport.extentreport != null) {
            ExtentReport.extentreport.flush();
        }
    }
}