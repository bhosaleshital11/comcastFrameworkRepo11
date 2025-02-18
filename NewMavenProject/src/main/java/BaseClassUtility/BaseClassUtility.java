package BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ClientName.AppName.GenericUtility.FiLeUtility.FileUtility;
import com.ClientName.AppName.GenericUtility.ObjectRepository.LoginPage;
import com.ClientName.AppName.GenericUtility.dataBaseUtility.DatabaseUtility;
import com.ClientName.AppicationName.WebDriverUtility.WebDriverUtility;
import com.ClientName.ApplicationName.ObjectRepository.HomePage;

import GenericUtility.ExcelUtility;
import JavaUtility.JavaUtility;

public class BaseClassUtility extends WebDriverUtility 
{
public ExcelUtility eLib=new ExcelUtility();
public	DatabaseUtility dbLib=new DatabaseUtility();
public	FileUtility fLib=new FileUtility();
public JavaUtility jLib=new JavaUtility();	
public	WebDriver driver = null;
public static WebDriver sdriver = null;

@BeforeSuite(alwaysRun =true)
public void beforeSuite() throws Throwable
{
	System.out.println("=====Connect to Database====");
	dbLib.getConnetiToDatabase();
}
@BeforeClass(alwaysRun =true)
public void beforeClass() throws Throwable
{
	System.out.println("===============Launch the browser======");
	String BROWSER = fLib.getDataFromProperties("browser");
	
	if(BROWSER.equals("Chrome")) {
		driver = new ChromeDriver();
	}
	else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	else if(BROWSER.equals("opera")) {
		driver = new EdgeDriver();
	}
	else {
		driver = new InternetExplorerDriver();
	}
	sdriver=driver;
	String url = fLib.getDataFromProperties("url");
	driver.get(url);
    }
      @BeforeMethod(alwaysRun =true)
     public void beforeMethod() throws Throwable
    {

	LoginPage lp=new LoginPage(driver);
	lp.getLogin();
	System.out.println("====Login to Page======");
}
@AfterMethod(alwaysRun =true)
public void aftermethod()
{
	System.out.println("==logout to Page==");
	HomePage hp=new HomePage(driver);
	hp.logout();
}
@AfterClass(alwaysRun = true)
public void afterClass()
{
	driver.quit();
	
	System.out.println("====Close the BROwser======");
}

@AfterSuite(alwaysRun =true)
public void afterSuite()
{
	dbLib.closeDatabaseConnection();
	System.out.println("===close db connection====");
}
}
