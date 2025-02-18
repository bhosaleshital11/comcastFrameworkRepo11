package LearnReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportWithScreenshot {
	ExtentReports report;
	ExtentTest test;
	@BeforeSuite
	public void configBeforesuite()
	{	
	ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report2.html");
	spark.config().setDocumentTitle("CRM test suite Result");
	spark.config().setReportName("CRM report");
	spark.config().setTheme(Theme.DARK);
	report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS","Windows 11");
	report.setSystemInfo("BROWSER","Chrome");
	}
	@AfterSuite
	public void configAfterSuite()
	{
		report.flush();
	}
	@Test
	public void createContactTest() 
	{
		ExtentTest test = report.createTest("createContactTest");
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"login to appnavigate to contact");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"Contact is created");
	}
	else
		test.log(Status.FAIL,"Contact is not created");
	
}
	@Test
	public void createContactTest2() 
	{
	  test = report.createTest("createContactTest2");
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"login to appnavigate to contact");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDC"))
	{
		
		test.log(Status.PASS,"Contact is created");
	}
	else
		test.log(Status.FAIL,"Contact is not created");
	
}
	@Test
	public void createContactTest3() 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888");
		TakesScreenshot eDriver=(TakesScreenshot) driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest3");
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"login to appnavigate to contact");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"Contact is created");
	}
	else
		test.log(Status.FAIL,"Contact is not created");
	test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
	driver.close();
}
	
	}



