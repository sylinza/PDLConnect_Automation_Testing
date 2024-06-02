package com.pdl.utilities;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExcelUtilSheets {
	
	public static final Logger logger = LogManager.getLogger(ExcelUtilSheets.class);
	private XSSFSheet workSheet;
	private String sheetName;

	private XSSFWorkbook workBook;

	private String path;

	XSSFRow row1 = null;
	XSSFRow row2 = null;
	XSSFCell cell;
	
	XSSFRow row=null;

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public  ExcelUtilSheets(String path) {

		this.path = path;

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the required test data sheet

			workBook = new XSSFWorkbook(ExcelFile);
			logger.info(workBook.getNumberOfSheets());
			int i =1;
			while(i<=workBook.getNumberOfSheets()-1) {
				
			
				
             sheetName = workBook.getSheetName(i);
             
             workSheet=workBook.getSheet(sheetName);
             logger.info("from inside "+workBook.getSheetName(i));
           
            
          break;
			
			}
			 
			
			 i++;
			
			logger.info("from outside "+workBook.getSheetName(i));
		//	}
			
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
	public XSSFCell getCell(int rowNum, int colNum) {
		XSSFCell cell;
		 cell = workSheet.getRow(rowNum).getCell(colNum);
		return cell;
	}

	public  String getCellData1(int rowNum, int colNum) {

		XSSFCell cell;

		try {

       
			cell = workSheet.getRow(rowNum).getCell(colNum);

			String cellData = cell.toString();
			

			return cellData;

		} catch (Exception e) {

			e.printStackTrace();

			return "";

		}

	}
	public String[][] getDataArray() {



		String[][] data = new String[rowCount()][columnCount()];



		for (int i = 0; i <rowCount(); i++) {

			for (int j = 0; j < columnCount(); j++) {

				String value = getCellData(i, j);

				data[i][j] = value;

			}

		}

		return data;



	}
	public  int getCellIndex(String headerName) {
		int patchColumn = -1;
		Row row= workSheet.getRow(0);
		for (int cn=0; cn<row.getLastCellNum(); cn++) {
			Cell c = row.getCell(cn);
		   if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
		       // Can't be this cell - it's empty
		       continue;
		   }
		   if (c.getCellType() == Cell.CELL_TYPE_STRING) {
		      String text = c.getStringCellValue();
		      if (headerName.equals(text)) {
		         patchColumn = cn;
		         break;
		      }
		   }
		}
		try {
			if (patchColumn == -1) {
			   throw new Exception("None of the cells in the first row were Patch");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	return patchColumn;
	}

public void createRowCell(int rowNumber, int columnIndex, Object obj){
  row = workSheet.createRow(rowNumber);
 Cell cell = row.createCell(columnIndex); 
  if (obj instanceof String) 
      cell.setCellValue((String)obj); 
  else if (obj instanceof Integer) 
      cell.setCellValue((Integer)obj); 
}

	public List<Map<String, String>> getDataList() {

		// get all columns

		List<String> columns = getColumnsNames();

		// this will be returned

		List<Map<String, String>> data = new ArrayList<>();

		

		for (int i = 1; i < rowCount(); i++) {

			// get each row

			Row row = workSheet.getRow(i);

			// create map of the row using the column and value

			// column map key, cell value --> map bvalue

			Map<String, String> rowMap = new HashMap<String, String>();

			for (Cell cell : row) {

				int columnIndex = cell.getColumnIndex();

				rowMap.put(columns.get(columnIndex), cell.toString());

			}



			data.add(rowMap);

		}



		return data;

	}



	public List<String> getColumnsNames() {

		List<String> columns = new ArrayList<>();



		for (Cell cell : workSheet.getRow(0)) {

			columns.add(cell.toString());

		}

		return columns;

	}



	public void setCellData(String value, int rowNum, int colNum) {

		



		try {

			row = workSheet.getRow(rowNum);

			cell = row.getCell(colNum);



			if (cell == null) {

				cell = row.createCell(colNum);

				cell.setCellValue(value);

			} else {

				cell.setCellValue(value);

			}

			FileOutputStream fileOut = new FileOutputStream(path);

			workBook.write(fileOut);



			fileOut.close();

		} catch (Exception e) {

			

		}

	}

public void getRowData(int rowNum) {
XSSFCell cell;

XSSFRow row;

String cellsData=null;

try {

	row = workSheet.getRow(rowNum);

Iterator<Cell> cellItr = row.iterator();

while(cellItr.hasNext()){
	cellsData=cellItr.next().toString();
	  System.out.print(cellItr.next().toString()+", ");
}
}catch (Exception e) {

	e.printStackTrace();

}

}

	public void setCellData(String value, String columnName, int row) {

		int column = getColumnsNames().indexOf(columnName);

		setCellData(value, row, column);

	}
	
	
	public void setCellDataNextRow() {
	    Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
	    data.put("1", new Object[]{ "Batch Number", "receipt Number From UI", "Receipt Number From DB" }); 
	
	}
	



	public int columnCount() {

		return workSheet.getRow(0).getLastCellNum();

	}



	public int rowCount() {

		
		
		
		return workSheet.getPhysicalNumberOfRows();
		
	}
	public int rowCountEmptyBaseFirstColumn() {
		int rowCount=workSheet.getPhysicalNumberOfRows();
		
		 int rowCountNotEmpty=0;
			for(int j=0;j<=rowCount-1;j++) {
				if(!this.getCellData(j, 0).isEmpty()) {
					rowCountNotEmpty++;
				}
				
			}
	return rowCountNotEmpty;
	}
	public int rowCountBetween(int rowEnd, int rowFirst) {
	row1 = workSheet.getRow(rowEnd);
	row2= workSheet.getRow(rowFirst);
	int row1Index=row1.getRowNum();
	int row2Index= row2.getRowNum();
	int rowNumber= (row1Index-row2Index)+1;
	 
//	int colCount = row.getLastCellNum();
//	logger.info("Column Count :- " + colCount);
//	
//	int rowCount = mySheet.getLastRowNum() + 1;
//	logger.info("Row Count :- " + rowCount);
       return rowNumber;
	}
	
	public int columCountByRowNumber(int rowNumber) {
		return workSheet.getRow(rowNumber).getLastCellNum();
	}

	public  int findRow(String cellContent) {

		int rowNum = 0;
		for (Row row : workSheet) {
			for (Cell cell : row) {
				if (cell.getRichStringCellValue().getString().equals(cellContent)) {
       logger.info("cell value "+cell.getRichStringCellValue().getString());
					rowNum = row.getRowNum();
					return rowNum;

				}

			}
		}
		return rowNum;
	}

	
	
	public int findIndexFromExcel(String cellValue) {
		int rowCount=rowCount();
		int columnCount=columnCount();
		int i;
       for ( i = 0; i <= rowCount - 1; i++) {
			
			for (int j = 0; j <= columnCount - 1; j++) {
			
				try {
					if(getCellData(i, j).isEmpty()||getCellData(i, j).equals(null)) {
						
						//continue;
					
					}else {
					String dataFromAllCells = getCellData(i, j).toString().trim();
					//CommonMethods.waitFor(1);
					//logger.info("Date for row " + (i+1) +" Column "+(j+1)+ " is " + dataFromAllCells);
					//CommonMethods.waitFor(1);
					if(getCellData(i, j).toString().equals(cellValue)) {
				     logger.info(cellValue+" index is "+i);
					return i;
					}
					}
					
				
					
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.print("NullPointerException Caught"); 
					
				}
			}
			}

		return i;	
	}
	public String rowValuesByTabs(String tabNameStart,String tabNameEnd, String UIDescription) {
		String dataFromAllCells=null;
		String valueToPostUI=null;
		int indexStart = findIndexFromExcel(tabNameStart);
		logger.info("Start index " + indexStart);
		int endingIndex = findIndexFromExcel(tabNameEnd);
		logger.info("End Index is: " + endingIndex);
		int columnCount = columnCount();
		for (int i = indexStart+1; i <= endingIndex-1; i++) {
			for (int j = 0; j <= columnCount - 1; j++) {
				try {
					if (getCellData(i, j).isEmpty() || getCellData(i, j).equals(null)) {

						// continue;
						//return	dataFromAllCells;
					} else {
						 dataFromAllCells = getCellData(i, j).toString().trim();
						// CommonMethods.waitFor(1);
//						System.out
//								.println("Date for row " + (i + 1) + " Column " + (j + 1) + " is " + dataFromAllCells);
						// CommonMethods.waitFor(1);
                      if(dataFromAllCells.equals(UIDescription.trim())) {
                    	  valueToPostUI=getCellData(i,(j+1)).toString();
                    	  
                      }
					}

				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.print("NullPointerException Caught");
					
				}
			}
			
			}
	
		return	valueToPostUI;
		}

	public String rowValuesByTabsAndColums(String tabNameStart,String tabNameEnd, String UIDescription, int columnNum1) {
		String dataFromAllCells=null;
		String valueToPostUI=null;
		int indexStart = findIndexFromExcel(tabNameStart);
		//logger.info("Start index " + indexStart);
		int endingIndex = findIndexFromExcel(tabNameEnd);
		//logger.info("End Index is: " + endingIndex);
		int columnCount = columnCount();
		for (int i = indexStart+1; i <= endingIndex-1; i++) {
			for (int j = 0; j <= columnCount - 1; j++) {
				try {
					if (getCellData(i, j).isEmpty() || getCellData(i, j).equals(null)) {

						 continue;
						//return	dataFromAllCells;
					} else {
						 dataFromAllCells = getCellData(i, j).toString().trim();
							// CommonMethods.waitFor(1);
//							System.out
//									.println("Date for row " + (i + 1) + " Column " + (j + 1) + " is " + dataFromAllCells);
							// CommonMethods.waitFor(1);
                          if(dataFromAllCells.equals(UIDescription)) {
                        	  if(getCellData(i,(j+columnNum1)).isEmpty()) {
                        		  continue;
                        	  }else {
                        	  valueToPostUI=getCellData(i,(j+columnNum1)).toString();
                        	  } 
                        	  
                          }
						}

					} catch (NullPointerException e) {
						// TODO Auto-generated catch block
						System.out.print("NullPointerException Caught");
						
					}
				}
				
				}
		
			return	valueToPostUI;
						
					
					}

				
	public ArrayList<String> getListOfColumnsTitles() {
		
		List<String> list;
	ArrayList<String> eachColumnTitle_List = new ArrayList<>();
	
			 list=  this.getColumnsNames();
		
		 int columnCount=0;
		 for(String eachNameOfcolumn:list) {
			 //logger.info((columnCount+1)+" - "+eachNameOfcolumn);
			 eachColumnTitle_List.add(eachNameOfcolumn);
	       columnCount++;
	       
	}
		// logger.info("List 1 "+eachColumnTitle_List);
	return eachColumnTitle_List;
		}
//clening data from sheet exept Row and Column Titles
 
	
	public String cleaningDataFromSheet() {
	 
		String settingData="";
	  
//		 int indexEachTitle=this.getCellIndex(eachColumnTitle) ;
//		 logger.info("Each Column Title(Util): "+eachColumnTitle);
		
		 for(int i=0; i<=this.rowCount()-1; i++) {
			 for(int j=0;j<=this.columnCount()-1;j++) {	
			
				
					try {
						if(!this.getCellData(i, j).isEmpty()) {
						this.setCellData(settingData, i, j);
						}
					} catch (NullPointerException e) {
						// TODO Auto-generated catch block
					
					}
				
			 }
		 
  }
	  return settingData;
}
  public ArrayList<String> rowTitleFromConfigurationPoroperty(){
	  ArrayList<String> rowFromConfigProp=new ArrayList<>();
	 
	  rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_1"));
	  rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_2"));
	  rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_3"));
	  rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_4"));
	  rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_5"));
	 
	 
	  return rowFromConfigProp;
  }
  public  ArrayList<String> settingColumnTitles() {
	  ArrayList<String> columnsFromConfigProp=new ArrayList<>();
	  
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_1"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_2"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_3"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_4"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_5"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_6"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_7"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_8"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_9"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_10"));
	  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_11"));
	 
	  if(inputConfigurationReader.getProperty("Level").toString().trim().equals("Level 1")) {
		  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_12"));  
	  }else {
		  //Level 2
		  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_13"));
	  }
	 
	 return columnsFromConfigProp;
  }
  
  public void settingColumnTitlesForLevel() {
	  for(int c=0; c<=settingColumnTitles().size()-1;c++) {
		  String valueOfEachIndex=settingColumnTitles().get(c).toString().trim();
		  setCellData(valueOfEachIndex, 0, c);
	  }
  }
  public void settingRowTitles(int recordCount) {
	  int rowNum=1;
	  for(int r=1; r<=recordCount;r++) {
		  String recordValue="Record "+r; 
		  logger.info("record Value              "+recordValue);
	  
	  this.setCellData(recordValue, rowNum, 0); 
	 
	  logger.info("Row Number is 1:  "+rowNum);
	  rowNum=rowNum+1;
	  logger.info("Row Number is 2:  "+rowNum);
	 //r2
//	  for(String eachInputRowTitle: this.rowTitleFromConfigurationPoroperty()) {
//		 
//	 
//
//				 this.setCellData(eachInputRowTitleValue, rowNum, 0);
//				
//				 rowNum=rowNum+1;
//			//r3,4,5,6
//				//logger.info("Row Title is: "+testResultsPat.getCell(i, 0).toString());
//			
//	  }  
	
	  for(int row=0; row<=rowTitleFromConfigurationPoroperty().size()-1;row++) {
		 
		  String valueOfEachIndex=rowTitleFromConfigurationPoroperty().get(row).toString().trim();
		  
		  String eachInputRowTitleValue=valueOfEachIndex+"/"+r;
		  setCellData("", rowNum, 0);
		  setCellData(eachInputRowTitleValue, rowNum, 0);
		  logger.info("for Row: "+rowNum+" Value -   "+eachInputRowTitleValue);
		  logger.info("Row Number is 3:  "+rowNum);
		  rowNum++;
	  }
	  logger.info("Row Number is 4:  "+rowNum);
	 }
	 }
  public void settingTimeOnChoosenColumn(String ColumnNameaAsTime) {
	 TimeUtil.getCurrentTime();

	int rowCount=this.rowCountEmptyBaseFirstColumn();
	
	logger.info("Row Count Util "+rowCount);
	
	for(String eachColumnTitle: this.getListOfColumnsTitles()) {
		
		
		
		try {
				if(eachColumnTitle.trim().equals(ColumnNameaAsTime)) {
					int indexOfColumn= this.getCellIndex(eachColumnTitle);
					
				     logger.info("Selected "+TimeUtil.getCurrentTime());
			
			
					logger.info("+++++++++++++++++Row Count "+rowCount);
					
		for(int i=1; i<=rowCount-1; i++) {
			
						
						if(this.getCellData(i, 0).trim().equals("Record")||this.getCellData(i, 0).trim().equals("Post/Fail")) {
							//logger.info("Post/Fail, no time.");
							
						}else {
							//logger.info("Row Title is: "+testResultsPat.getCell(i, 0).toString());
							//logger.info("Row Title is: "+testResultsPat.getCell(i, 0).toString());
							this.setCellData(TimeUtil.getCurrentTime(), i, indexOfColumn);
						
                          
						
						}
							//if(!testResultsPat.getCell(i, 0).toString().equals("null")) {
					//Row Title
								String rowName=	this.getCell(i, 0).toString().trim();
								
									logger.info("Row Names "+rowName+" for index number "+(i+1));
							
							
							//}
						
					}
				 }
			} catch (NullPointerException  e) {
				// TODO Auto-generated catch block
			
			}
		
	}
  }
}	
