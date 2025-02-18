package com.ClientName.newMavenProject.GenericUtility.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Workbook wb=null;
public String getDataFromExcel(int row,int cell) throws Throwable, IOException {
	FileInputStream fis=new FileInputStream("./TestData/ExcelData1.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("org1");
	return sh.getRow(row).getCell(cell).getStringCellValue();
}

	
	public void setDataBackToExcel(int rowIndex, int cellIndex) throws IOException
	{
		FileInputStream fis=new FileInputStream("/MavenProjectForTestNG/TestData/TestScriptData.xlsx");
		Cell cell = wb.getSheet("Org").getRow(rowIndex).createCell(cellIndex);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("pass");
		
		FileOutputStream fos=new FileOutputStream("/MavenProjectForTestNG/TestData/TestScriptData.xlsx");
		wb.write(fos);
		
	}
	
	//lastrowno
	//last row no
}




