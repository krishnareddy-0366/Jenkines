package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Com.BaseClass.Library;

public class excelutility {
	
	private static Logger logger;
	static {
		logger=Logger.getLogger(excelutility.class);
		PropertyConfigurator.configure("src\\test\\resources\\TestData\\Flipkart_TestData.xlsx");
	}
	
	public String excelread(String sheet, int RowNumber, int cellNumber) throws IOException {
		File path= new File("src/test/resources/TestData/Flipkart_TestData.xlsx");
		
		FileInputStream read= new FileInputStream(path);
		 XSSFWorkbook book = new XSSFWorkbook(read);
		 Sheet sh = book.getSheet(sheet);
		 Row row = sh.getRow(RowNumber);
		 Cell c = row.getCell(cellNumber);
		 logger.info("*********Read excel sheet**************");
		 String value =  c.getStringCellValue();
		 book.close();
		 read.close();
		 return value;
	}
	
	public void excelwrite(String sheet, int RowNumber, int cellNumber, String text) throws IOException {
		File path1= new File("src/test/resources/TestData/Flipkart_TestData.xlsx");
		FileInputStream read= new FileInputStream(path1);
		 XSSFWorkbook book = new XSSFWorkbook(read);
		 Sheet sh = book.getSheet(sheet);
		 Row row = sh.getRow(RowNumber);
		 Cell c = row.createCell(cellNumber);
		 c.setCellValue(text);
		 read.close();
		 FileOutputStream write = new FileOutputStream(path1);
		 book.write(write);
		 write.close();
		 book.close();
		 logger.info("*********Write in excel sheet**************");
		 
	}

}
