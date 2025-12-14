package utlis;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer
{
	private int retrycount=0;
	private static final int maxretrycount=2;

	@Override
	public boolean retry(ITestResult result) 
	{
		if (retrycount<maxretrycount)
		{
			retrycount++;
			return true;
		}
		return false;
	}

}