package CreateOrganization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ClientName.AppName.GenericUtility.ObjectRepository.CreatingNewOrganizationPage;
import com.ClientName.ApplicationName.ObjectRepository.HomePage;
import com.ClientName.newMavenProject.GenericUtility.ExcelUtility.ExcelUtility;

import BaseClassUtility.BaseClassUtility;
import JavaUtility.JavaUtility;

public class CreatingNewOrganizationTest extends BaseClassUtility{
	JavaUtility j=new JavaUtility();
@Test
public void createOrgTest() throws Throwable, Throwable
{
	ExcelUtility eLib=new ExcelUtility();
//step1: read testScript data from excel
String Orgname=eLib.getDataFromExcel(1, 2)+jLib.getRandomNumber();

//step2: Navigate to Organization Module
	HomePage hpage=new HomePage(driver);
	hpage.getOrgLink().click();
	
//	Step 3: click on create Organization Button
	CreatingNewOrganizationPage Opage= new CreatingNewOrganizationPage(driver);
	Opage.getaddBtnEdt();
	
// step4: enter all the details & create new Organization
	
	Opage.createOrg(Orgname);
	//e.getDataFromExcel(null, 01, 02);
	//String cell =eUti.getDataFromExcel(1, 2)+j.getRandomNumber();
	
}
}
