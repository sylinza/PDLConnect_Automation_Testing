package com.pdl.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExcelStaticMethods {
	
	public static final Logger logger = LogManager.getLogger(ExcelStaticMethods.class);

	ExcelUtil testingDataPat= new ExcelUtil(ConfigurationReader.getProperty("testResultsPat"),"Results");
	public  boolean isCellEmpty(XSSFCell cell) {
	    if (cell == null) { // use row.getCell(x, Row.CREATE_NULL_AS_BLANK) to avoid null cells
	        return true;
	    }

	    if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
	        return true;
	    }

	    if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().trim().isEmpty()) {
	        return true;
	    }

	    return false;
	}


	public void selectByHeaderName(String value,String headerName, String headerNameUI,int rowNum,int cellIndex) {
		try {
		if(headerNameUI.equalsIgnoreCase(headerName)){
			logger.info(headerNameUI+" - is muching with "+ headerName);
			testingDataPat.setCellData(value, rowNum, cellIndex);
			rowNum++;
			//testingDataPat.createRowCell(0, CellIndex, "Goara");
			//break;
		}else {
			//continue;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		}
	
}

