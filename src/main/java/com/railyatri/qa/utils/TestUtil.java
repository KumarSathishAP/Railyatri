package com.railyatri.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.railyatri.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+ "\\src\\main\\java\\com\\railyatri\\qa\\testdata\\TestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
		
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				Cell cell1 = sheet.getRow(i + 1).getCell(k);  
	            cell1.setCellType(Cell.CELL_TYPE_STRING);
	            String values= cell1.getStringCellValue();
				 		//String values = sheet.getRow(i + 1).getCell(k).getStringCellValue().toString();
						data[i][k] = values;
				
			}
		}
		return data;
	}
	
public static void takeScreenshotAt(String pageName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"+ pageName +System.currentTimeMillis() + ".png"));
		
		}

public static String  makeDirectory()
{
	  LocalDate localDate = LocalDate.now();
	File theDir = new File(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));

	// if the directory does not exist, create it
	if (!theDir.exists()) {
	    System.out.println("creating directory: " + theDir.getName());
	    boolean result = false;

	    try{
	        theDir.mkdir();
	        result = true;
	    } 
	    catch(SecurityException se){
	        //handle it
	    }        
	    if(result) {    
	        System.out.println("DIR created");  
	    }
	}
	return theDir.getName();
}
	

	

}
