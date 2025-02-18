package CreateOrganization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ClientName.newMavenProject.GenericUtility.ExcelUtility.ExcelUtility;

public class Practice 
{
@Test
public void readDaat() throws IOException, Throwable
{
	ExcelUtility eLib=new ExcelUtility();
	System.out.println(eLib.getDataFromExcel(1, 2));
}
}
