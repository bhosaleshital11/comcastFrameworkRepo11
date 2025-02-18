package LearnListnerClass;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClassUtility;

public class InvoiceTestListner extends BaseClassUtility {
@Test(retryAnalyzer =com.ClientName.AppName.GenericUtility.ListenerUtility.RetryListnerImplementation.class )
public void createInvoiceTest() throws Throwable
{
	System.out.println("Execute createInvoiceTest ");
	Thread.sleep(Duration.ofSeconds(20));
	String actTitle = driver.getTitle();
	System.out.println(actTitle);
	//by Assert 
	Assert.assertEquals(actTitle, "Login");
	System.out.println("step 1");
	System.out.println("step 2");
	System.out.println("step 3");
	System.out.println("step 4");
}
@Test
public void createInvoicewithContactTest() {
	System.out.println("Execute createInvoicewithContactTest ");
	System.out.println("step 1");
	System.out.println("step 2");
	System.out.println("step 3");
	System.out.println("step 4");
}
}
