package com.pdl.utilities;

import java.io.FileInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EUtil {
	
	private XSSFSheet workSheet;
	private String sheetName;
    private XSSFWorkbook workBook;
    private String path;
    public static final Logger logger = LogManager.getLogger(EUtil.class);

	
	public  EUtil(String path) {

		this.path = path;

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the required test data sheet

			workBook = new XSSFWorkbook(ExcelFile);
			
			logger.info(workBook.getNumberOfSheets());
			
			workBook = new XSSFWorkbook(ExcelFile);
			
			for(int sht=1; sht<=workBook.getNumberOfSheets()-2; sht++) {
			
			 workSheet = workBook.getSheetAt(sht);
			 
			 logger.info("from outside "+workBook.getSheetName(sht));
			 
            
          break;
			
			}
			 
			
		
			
			
			
		} catch (IOException e) {

			throw new RuntimeException(e);

		}
		

	}
	public  String getCellData(int rowNum, int colNum) {

		XSSFCell cell;

		try {

       
			cell = workSheet.getRow(rowNum).getCell(colNum);

			String cellData = cell.toString();
			if(cellData.equalsIgnoreCase("n/a")|| cellData.isEmpty()){
				return "";
			}

			return cellData;

		} catch (Exception e) {

			e.printStackTrace();

			return "";

		}

	}
	public int columnCount() {

		return workSheet.getRow(0).getLastCellNum();

	}

	



}
	
	
	
	
	


