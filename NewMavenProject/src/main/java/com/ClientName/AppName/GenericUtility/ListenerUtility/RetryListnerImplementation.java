package com.ClientName.AppName.GenericUtility.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListnerImplementation implements IRetryAnalyzer {
int count=0;
int countLimit=5;
public boolean retry(ITestResult result)
{
	if(count <countLimit)
	{
		count++;
		return true;
	}
	return false;
}

}
