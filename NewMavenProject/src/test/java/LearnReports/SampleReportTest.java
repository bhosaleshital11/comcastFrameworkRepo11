package LearnReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
@Test
public void createContactTest()
{
	ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
	spark.config().setDocumentTitle("CRM test suite Result");
	spark.config().setReportName("CRM report");
	spark.config().setTheme(Theme.DARK);
	
	ExtentReports report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS","Windows 11");
	report.setSystemInfo("BROWSER","Chrome");
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
	report.flush();
}

}


