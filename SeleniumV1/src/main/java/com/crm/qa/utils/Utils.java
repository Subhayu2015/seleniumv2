package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;



	public static Map<String, String> getTestData(String filename2, String sheetname2, String classname) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> map = new HashMap<String, String>();
		FileInputStream ExcelFile = new FileInputStream(filename2);

		   // Access the required test data sheet

		   ExcelWBook = new XSSFWorkbook(ExcelFile);

		   ExcelWSheet = ExcelWBook.getSheet(sheetname2);
		   int startRow = 1;

		   int startCol = 1;

		   int ci,cj;
		   int totalRows = ExcelWSheet.getLastRowNum();
		   int totalCols = 2;


		   for (int i=startRow;i<=totalRows;i++) {           	   

			  if(null!=classname && classname.equalsIgnoreCase(ExcelWSheet.getRow(i).getCell(0).getStringCellValue())){
				   for (int j=startCol;j<=totalCols;j++){
	
					   map.put(ExcelWSheet.getRow(0).getCell(j).getStringCellValue(), ExcelWSheet.getRow(i).getCell(j).getStringCellValue());
	
					}
			  }
	}
		  
		return map;
	}
}
