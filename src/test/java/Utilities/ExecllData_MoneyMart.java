package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ExecllData_MoneyMart extends AbstractClass {

	WebDriver driver;
	
	public ExecllData_MoneyMart(WebDriver driver) {
		super(driver);

	
	}

	// Step 1: Get the file location
	// Step 2: Read the sheets.
	// Step 3: Get the no of sheets in work book and search for required sheet
	// Step 4 : Once got required sheet then Read header row and search for required header column for test case.
	// Step 5 : Once got the required column then search for required row and then
	// get the data from that row.

	// Note : sheet is collection of Rows
	// Rows: Rows is collection of cells.
	
	
	@Test
	public void getExcellData() throws IOException 
	{
		String TestCaseSheet = properties("TC02");
		
		ArrayList<String>  array = new ArrayList<String>();
		
		FileInputStream excellFile = new FileInputStream("C:\\Users\\1003413\\eclipse-workspace\\MoneyMartProject_TestNG\\ExcelData\\TestCases.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(excellFile);
		
	 	int noOfSheets = workBook.getNumberOfSheets(); 
	 	System.out.println(noOfSheets);
	 	
	 	
		
	 	for(int i = 0 ; i < noOfSheets ; i++ )
	 	{
	 		if (workBook.getSheetName(i).equalsIgnoreCase(TestCaseSheet)) 
	 		{
	 			
				
			}
	 		
	 		
	 	}
	 	
	}
}
