package com.pdl.utilities;

import java.awt.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * This is a utility for reading from writing to excel files.
 * it ONLY works with xlsx files.
 */

public class ExcelUtil {
	
	public static final Logger logger = LogManager.getLogger(ExcelUtil.class);

	XSSFCell cell;

	// XSSFRow row;

  XSSFSheet workSheet;

  XSSFWorkbook workBook;
	XSSFRow row1 = null;
	XSSFRow row2 = null;

  String path;
	XSSFRow row = null;

	FileInputStream ExcelFile;

	public ExcelUtil(String path, String sheetName) {

		this.path = path;

		try {

			// Open the Excel file

			ExcelFile = new FileInputStream(path);

			// Access the required test data sheet

			workBook = new XSSFWorkbook(ExcelFile);

			workSheet = workBook.getSheet(sheetName.trim());
			 

		} catch (IOException e) {

			throw new RuntimeException(e);

		}

	}

	public void copyFileUsingApache(File from, File to) throws IOException {
		FileUtils.copyFile(from, to);
//	File originalWb = new File("orginalWb.xlsx"); 
//	File clonedWb = new File("clonedWb.xlsx");
//	Files.copy(from.toPath(), to.toPath());

	}

	public String getCellData(int rowNum, int colNum) {
		String cellData = null;
		XSSFCell cell;

		try {

			cell = workSheet.getRow(rowNum).getCell(colNum);

			try {
				cellData = cell.toString().trim();
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}
			try {
				if (cellData.equalsIgnoreCase("n/a") || cellData.isEmpty()) {
					return "";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}

			return cellData;

		} catch (Exception e) {

			return "";

		}

	}

	public int getNumberOfSheets() {
		int sheetCount = workBook.getNumberOfSheets();
		return sheetCount;
	}

	public List<String> sheetName() {
		List<String> sheetNames = new ArrayList<String>();
		for (int i = 0; i < this.getNumberOfSheets(); i++) {
			sheetNames.add(workBook.getSheetName(i));

		}
		return sheetNames;
	}

	public XSSFSheet createNewSheet(String sheetNameNew) {

		XSSFSheet createdNewSheetName = workBook.createSheet(sheetNameNew);

		try {
			FileOutputStream fileOut = new FileOutputStream(path);

			workBook.write(fileOut);

			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

		return createdNewSheetName;
	}

	public void
			// XSSFSheet
			getSheet(String SheetName) {
		XSSFSheet linkedSheet = workBook.getSheet("Sheet name");
		// return linkedSheet;
	}

	public XSSFCell getCell(int rowNum, int colNum) {
		XSSFCell cell;
		cell = workSheet.getRow(rowNum).getCell(colNum);
		return cell;
	}

	public String getCellData1(int rowNum, int colNum) {

		XSSFCell cell;

		try {

			cell = workSheet.getRow(rowNum).getCell(colNum);

			String cellData = cell.toString();

			return cellData;

		} catch (Exception e) {

		

			return "";

		}

	}

	public void cellGreenColorStyle(int rowNum, int colNum) {
		cell = workSheet.getRow(rowNum).getCell(colNum);
		CellStyle style = workBook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setBottomBorderColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		cell.setCellStyle(style);
	}

	public void cellRedColorStyle(int rowNum, int colNum) {
		cell = workSheet.getRow(rowNum).getCell(colNum);
		CellStyle style = workBook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED1.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		cell.setCellStyle(style);
	}

	public void cell_GREY_25ColorStyle(int rowNum, int colNum) {
		cell = workSheet.getRow(rowNum).getCell(colNum);
		CellStyle style = workBook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());

		// style.setFillBackgroundColor(IndexedColors.LIME.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);

	}

	public void cell_YELLOW_ColorStyle(int rowNum, int colNum) {
		cell = workSheet.getRow(rowNum).getCell(colNum);
		CellStyle style = workBook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.YELLOW1.getIndex());

		// style.setFillBackgroundColor(IndexedColors.LIME.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);

	}

	public void cell_WHITE_ColorStyle(int rowNum, int colNum) {
		cell = workSheet.getRow(rowNum).getCell(colNum);
		CellStyle style = workBook.createCellStyle();

		style.setFillBackgroundColor(new HSSFColor.WHITE().getIndex());
		cell.setCellStyle(style);
	}

	public String[][] getDataArray() {

		String[][] data = new String[rowCount()][columnCount()];

		for (int i = 0; i < rowCount(); i++) {

			for (int j = 0; j < columnCount(); j++) {

				String value = getCellData(i, j);

				data[i][j] = value;

			}

		}

		return data;

	}

	public int getCellIndex(String headerName) {
		int patchColumn = -1;
		Row row = workSheet.getRow(0);
		for (int cn = 0; cn < row.getLastCellNum(); cn++) {
			Cell c = row.getCell(cn);
			if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
				// Can't be this cell - it's empty
				continue;
			}
			if (c.getCellType() == Cell.CELL_TYPE_STRING) {
				String text = c.getStringCellValue().trim();
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

	public void createRowCell(int rowNumber, int columnIndex, Object obj) {
		row = workSheet.createRow(rowNumber);
		Cell cell = row.createCell(columnIndex);
		if (obj instanceof String)
			cell.setCellValue((String) obj);
		else if (obj instanceof Integer)
			cell.setCellValue((Integer) obj);
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
	public void setcolumnTitle() {
		row=workSheet.createRow(0);
	}
	
	public void createRowSetCellData(String value, int rowNumber,  int colNum) { 
	row=  workSheet.createRow(rowNumber);
	
		this.setCellData(value, rowNumber, colNum);	
	}
	
	public void createRow( int rowNum ) {
		row=  workSheet.createRow(rowNum); 
		
	}
	
		
	public XSSFRow createRowRetrunRow( int rowNum ) {
		row=  workSheet.createRow(rowNum); 
		return row;
	}
	public void createCellValue(String cellValue, int rowNum, int columnIndex, String sheetName ) {

	   workBook.getSheet(sheetName).getRow(rowNum).createCell(columnIndex).setCellValue(cellValue);
//		XSSFRow rowNumber=this.createRowRetrunRow(rowNum);
//		 cell =rowNumber.createCell(columnIndex);
//		 cell.setCellValue(cellValue);
//		  
	}

	public void setCellData(String value, int rowNum, int colNum) {

		try {
			
			
			row = workSheet.getRow(rowNum);
		 

			cell = row.getCell(colNum);

			if (cell == null) {

				cell = row.createCell(colNum);

				//cell.setCellValue("");
				cell.setCellValue(value);

			} else {
			//	cell.setCellValue("");
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

		String cellsData = null;

		try {

			row = workSheet.getRow(rowNum);

			Iterator<Cell> cellItr = row.iterator();

			while (cellItr.hasNext()) {
				cellsData = cellItr.next().toString();
				System.out.print(cellItr.next().toString() + ", ");
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void setCellData(String value, String columnName, int row) {

		int column = getColumnsNames().indexOf(columnName);

		setCellData(value, row, column);

	}

	public void setCellDataNextRow() {
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "Batch Number", "receipt Number From UI", "Receipt Number From DB" });

	}

	public int columnCount() {
		int columnCount = 0;
		try {
			columnCount = workSheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

		return columnCount;

	}

	public int rowCount() {

		int rowCount = 0;
		try {
			rowCount = workSheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

		return rowCount;

	}

	public int rowCountEmptyBaseFirstColumn() {
		int rowCount = workSheet.getPhysicalNumberOfRows();

		int rowCountNotEmpty = 0;
		for (int j = 0; j <= rowCount - 1; j++) {
			try {
				if (!this.getCellData(j, 0).isEmpty()) {
					rowCountNotEmpty++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}

		}
		return rowCountNotEmpty;
	}

	public int rowCountBetween(int rowEnd, int rowFirst) {
		row1 = workSheet.getRow(rowEnd);
		row2 = workSheet.getRow(rowFirst);
		int row1Index = row1.getRowNum();
		int row2Index = row2.getRowNum();
		int rowNumber = (row1Index - row2Index) + 1;

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

	public int findRow(String cellContent) {

		int rowNum = 0;
		for (Row row : workSheet) {
			for (Cell cell : row) {
				if (cell.getRichStringCellValue().getString().equals(cellContent)) {
					logger.info("cell value " + cell.getRichStringCellValue().getString());
					rowNum = row.getRowNum();
					return rowNum;

				}

			}
		}
		return rowNum;
	}

	public int findIndexFromExcel(String cellValue) {
		int rowCount = rowCount();
		int columnCount = columnCount();
		int i;
		for (i = 0; i <= rowCount - 1; i++) {

			for (int j = 0; j <= columnCount - 1; j++) {

				try {
					if (getCellData(i, j).isEmpty() || getCellData(i, j).equals(null)) {

						// continue;

					} else {

						// CommonMethods.waitFor(1);
						// logger.info("Date for row " + (i+1) +" Column "+(j+1)+ " is " +
						// dataFromAllCells);
						// CommonMethods.waitFor(1);
						try {
							if (getCellData(i, j).toString().trim().equals(cellValue)) {
								logger.info(cellValue + " index is " + i);

								return i;
							} else {

							}
							break;
						} catch (Exception e) {
							// TODO Auto-generated catch block

						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.print("NullPointerException Caught");

				}
			}
		}

		return i;
	}

	public String rowValuesByTabs(String tabNameStart, String tabNameEnd, String UIDescription) {
		String dataFromAllCells = null;
		String valueToPostUI = null;
		int indexStart = findIndexFromExcel(tabNameStart);
		logger.info("Start index " + indexStart);
		int endingIndex = findIndexFromExcel(tabNameEnd);
		logger.info("End Index is: " + endingIndex);
		int columnCount = columnCount();
		for (int i = indexStart + 1; i <= endingIndex - 1; i++) {
			for (int j = 0; j <= columnCount - 1; j++) {
				try {
					if (getCellData(i, j).isEmpty() || getCellData(i, j).equals(null)) {

						// continue;
						// return dataFromAllCells;
					} else {
						dataFromAllCells = getCellData(i, j).toString().trim();
						// CommonMethods.waitFor(1);
//						System.out
//								.println("Date for row " + (i + 1) + " Column " + (j + 1) + " is " + dataFromAllCells);
						// CommonMethods.waitFor(1);
						if (dataFromAllCells.equals(UIDescription.trim())) {
							valueToPostUI = getCellData(i, (j + 1)).toString();

						}
					}

				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.print("NullPointerException Caught");

				}
			}

		}

		return valueToPostUI;
	}

	public String rowValuesByTabsAndColums(String tabNameStart, String tabNameEnd, String UIDescription,
			int columnNum1) {
		String dataFromAllCells = null;
		String valueToPostUI = null;
		int indexStart = findIndexFromExcel(tabNameStart);
		 logger.info("Start index " + indexStart);
		int endingIndex = findIndexFromExcel(tabNameEnd);
		 logger.info("End Index is: " + endingIndex);
		int columnCount = columnCount();
		for (int i = indexStart + 1; i <= endingIndex - 1; i++) {
			for (int j = 0; j <= columnCount - 1; j++) {
				try {
					if (getCellData(i, j).trim().isEmpty() || getCellData(i, j).trim().equals(null)) {

						continue;
						// return dataFromAllCells;
					} else {
						try {
							dataFromAllCells = getCellData(i, j).trim();
						} catch (Exception e) {
							// TODO Auto-generated catch block

						}
						// CommonMethods.waitFor(1);
//							System.out
//									.println("Date for row " + (i + 1) + " Column " + (j + 1) + " is " + dataFromAllCells);
						// CommonMethods.waitFor(1);
						if (dataFromAllCells.trim().equals(UIDescription.trim())) {
							try {
								logger.info("UIDescription.trim()      " + UIDescription.trim());
								logger.info("dataFromAllCells.trim()   " + dataFromAllCells.trim());
								logger.info(
										"second column             " + getCellData(i, (j + columnNum1)).toString().trim());

								if (getCellData(i, (j + columnNum1)).isEmpty()) {
									  
									logger.info("Is empty:  "+getCellData(i, (j + columnNum1)));
									continue;
								} else {
									valueToPostUI = getCellData(i, (j + columnNum1)).trim();
									logger.info("2 valueToPostUI      "+valueToPostUI);
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block

							}

						}
					}

				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.print("NullPointerException Caught");

				}
			}

		}
		logger.info("3 valueToPostUI      "+valueToPostUI);
		return valueToPostUI;

	}

	public ArrayList<String> getListOfColumnsTitles() {

		List<String> list;
		ArrayList<String> eachColumnTitle_List = new ArrayList<>();

		list = this.getColumnsNames();

		int columnCount = 0;
		for (String eachNameOfcolumn : list) {
			// logger.info((columnCount+1)+" - "+eachNameOfcolumn);
			eachColumnTitle_List.add(eachNameOfcolumn);
			columnCount++;

		}
		// logger.info("List 1 "+eachColumnTitle_List);
		return eachColumnTitle_List;
	}
//clening data from sheet exept Row and Column Titles

	public String cleaningDataFromSheet() {

		String settingData = "";

//		 int indexEachTitle=this.getCellIndex(eachColumnTitle) ;
//		 logger.info("Each Column Title(Util): "+eachColumnTitle);

		for (int i = 0; i <= this.rowCount() - 1; i++) {
			for (int j = 0; j <= this.columnCount() - 1; j++) {

				try {
					if (!this.getCellData(i, j).isEmpty()) {
						try {
							this.setCellData(settingData, i, j);
							// this.cell_WHITE_ColorStyle(i, j);
						} catch (Exception e) {
							// TODO Auto-generated catch block

						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}

			}

		}
		return settingData;
	}

	public ArrayList<String> rowTitleFromConfigurationPoroperty() {
		ArrayList<String> rowFromConfigProp = new ArrayList<>();
		if (inputConfigurationReader.getProperty("Level").toString().trim().equals("Level 1")) {
			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_1"));
			// rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_2"));
			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_3"));
			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_3a"));
			// rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_4"));
			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_5"));

		} else {

			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_2a"));
			// rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_1"));
			// rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_2"));
			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_3"));
			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_3b"));
			// rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_4"));
			rowFromConfigProp.add(inputConfigurationReader.getProperty("Row_Line_5"));

		}
		return rowFromConfigProp;
	}

	public ArrayList<String> settingColumnTitles() {
		ArrayList<String> columnsFromConfigProp = new ArrayList<>();

		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_1")); // Description
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_2")); // Time
		columnsFromConfigProp.add("Record Row Number");
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_3")); // CLAIM_LOAD_BATCH_OID
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_4")); // CLIENT_PROGRAM_REF_NAME
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_5")); // ICN
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_6")); // CLIENT_PROGRAM_BID
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_7")); // NDC
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_8")); // PROVIDER_ID
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_8a")); // RECIPIENT_ID
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_8d")); // DATE_OF_SERVICE

		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_9")); // INVOICE_YRQTR
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_9a")); // RX_NUMBER
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_10"));
		// //PREP_CLAIM_DETAIL_OID
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_11")); // UNITS_REIMBURSED
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_11a")); // CLAIM_LINE_NO
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_12"));
		// //PAID_AMOUNT
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_13"));
		// //BILLED_AMOUNT
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_14"));
		// //PROCEDURE_CODE
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_15"));
		// //SOURCE_CODE
		// flag releted
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_8b")); // CLAIM_STATUS_CODE
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_16")); // DUPLICATE_FLAG
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_17")); // VOID_MATCH_FLAG
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_18")); // EXCLUSION_FLAG
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_19"));
		// // TPL_AMOUNT
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_20"));
		// //INVOICE_NUMBER
		columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_21")); // Claim File Name
		// columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_22"));
		// //CLAIM_DETAIL_OID

//	  if(inputConfigurationReader.getProperty("Level").toString().trim().equals("Level 1")) {
//		  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_12"));  
//	  }else {
//		  //Level 2
//		  columnsFromConfigProp.add(inputConfigurationReader.getProperty("Column_13"));
//	  }
//	 logger.info("^^^^columns From Config Prop"+columnsFromConfigProp);
		return columnsFromConfigProp;
	}

	public void settingColumnTitlesForLevel() {
		for (int c = 0; c <= settingColumnTitles().size() - 1; c++) {
			String valueOfEachIndex = settingColumnTitles().get(c).toString().trim();
			try {
				setCellData(valueOfEachIndex, 0, c);
				this.cell_YELLOW_ColorStyle(0, c);
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}
		}
	}

	public void settingRowTitles(int recordCount) {
		int rowNum = 1;
		for (int r = 1; r <= recordCount; r++) {
			String recordValue = inputConfigurationReader.getProperty("Level") + "_ Record " + r;
			// logger.info("record Value "+recordValue);

			try {
				this.setCellData(recordValue, rowNum, 0);
				this.cell_GREY_25ColorStyle(rowNum, 0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}

			// logger.info("Row Number is 1: "+rowNum);
			rowNum = rowNum + 1;
			// logger.info("Row Number is 2: "+rowNum);
			// r2

			String valueOfEachIndex = null;
			for (int row = 0; row <= rowTitleFromConfigurationPoroperty().size() - 1; row++) {

				try {
					valueOfEachIndex = rowTitleFromConfigurationPoroperty().get(row).toString().trim();
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}

				String eachInputRowTitleValue = valueOfEachIndex + "/" + r;

				try {
					setCellData(eachInputRowTitleValue, rowNum, 0);
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}
				// logger.info("for Row: "+rowNum+" Value - "+eachInputRowTitleValue);
				// logger.info("Row Number is 3: "+rowNum);
				rowNum++;
			}
			// logger.info("Row Number is 4: "+rowNum);
		}
	}

	public void settingTimeOnChoosenColumn(String ColumnNameaAsTime) {
		TimeUtil.getCurrentTime();

		int rowCount = this.rowCountEmptyBaseFirstColumn();

		logger.info("Row Count Util " + rowCount);

		for (String eachColumnTitle : this.getListOfColumnsTitles()) {

			try {
				if (eachColumnTitle.trim().equals(ColumnNameaAsTime)) {
					int indexOfColumn = this.getCellIndex(eachColumnTitle);

					logger.info("Selected " + TimeUtil.getCurrentTime());

					// logger.info("+++++++++++++++++Row Count "+rowCount);

					for (int i = 1; i <= rowCount - 1; i++) {

						
						try {
							if (this.getCellData(i, 0).trim().equals("Record")
									|| this.getCellData(i, 0).trim().equals("Post/Fail")) {
								// logger.info("Post/Fail, no time.");

							} else {
								// logger.info("Row Title is: "+testResultsPat.getCell(i, 0).toString());
								// logger.info("Row Title is: "+testResultsPat.getCell(i, 0).toString());
								this.setCellData(TimeUtil.getCurrentTime(), i, indexOfColumn);

							}
						} catch (Exception e) {
							// TODO Auto-generated catch block

						}
						// if(!testResultsPat.getCell(i, 0).toString().equals("null")) {
						// Row Title
						String rowName = null;
						try {
							rowName = this.getCell(i, 0).toString().trim();
						} catch (Exception e) {
							// TODO Auto-generated catch block

						}

					}
				}
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block

			}

		}
	}

	public void SetTestingData(String valueTestingData, String rowNameSelected, String columnNameSelecting,
			int recordCount) {

		// ADDING DATA TO

		for (String eachColumnTitle : settingColumnTitles()) {
			try {
				if (eachColumnTitle.trim().equals(columnNameSelecting.trim())) {
					int indexOfColumn = getCellIndex(eachColumnTitle.trim());

					for (int i = 1; i <= rowCount() - 1; i++) {
						

						try {
							if (getCellData(i, 0).equals("")) {
								break;
							} else {
								String selectedRowName = rowNameSelected + "/" + recordCount;

								if (getCellData(i, 0).trim().equals(selectedRowName.trim())) {
									// logger.info("selected Row Name "+columnNameSelecting+"
									// "+selectedRowName);

									// logger.info("Row Title is: "+testResultsPat.getCell(i, 0).toString());
									// logger.info("Row Title is: "+testResultsPat.getCell(i, 0).toString());
									setCellData(valueTestingData, i, indexOfColumn);
									break;
								}
							}

						} catch (Exception e) {
							// TODO Auto-generated catch block

						}

						// Row Title
						String rowName = getCell(i, 0).toString().trim();

						// logger.info("Row Names " + rowName + " for index number " + (i + 1));
					}

				}

			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
			}
		}

	}

	public int getRowTotal() {
		int rowTotal = workSheet.getLastRowNum();

		if ((rowTotal > 0) || (workSheet.getPhysicalNumberOfRows() > 0)) {
			rowTotal++;
		}
		return rowTotal;
	}

	public List<String> getRowTitlesList() {
		int rowTotalNumber = getRowTotal();
		List<String> rowTitleNames = null;
		for (int i = 1; i <= rowTotalNumber - 1; i++) {
			String eachRowTitleName = getCellData(i, 0);
			rowTitleNames.add(eachRowTitleName);
		}
		return rowTitleNames;
	}

	public static void cleanUpSheet(int row, int column, ExcelUtil cashPostingTestResultsPath  ) {
		for(int r=0; r<=row-1; r++) {
			 for(int c=0;c<=column;c++) {
				 cashPostingTestResultsPath.setCellData("", r, c); 
			 }
		}
	}
	
	
	public String getQuaryResponsValueByColumnTitleAsKey(Map<String, Object> queryResponsRow, String eachColumnTitle) {
		String value = null;
		// logger.info("1--------------------------------"+queryResponsRow);
		int columnSize = settingColumnTitles().size();

		value = "" + queryResponsRow.get(eachColumnTitle);
		// logger.info("Value from dynamic Method "+value);

		return value;
	}

	public void setUPdataValueBycolumnTitleAsKey(List<Map<String, Object>> queryResponsListOfTheMaps,
			String rowNameSelected, int prepListRowNumber) {

		for (Map<String, Object> eachRowQuery : queryResponsListOfTheMaps) {// 1
			int columnSize = settingColumnTitles().size();

			for (int i = 2; i <= columnSize - 1; i++) {// 2

				String eachColumnTitle = getCellData(0, i);

				// logger.info("Each Column Title form Dynamic "+eachColumnTitle);
				int indexOfColumn = getCellIndex(eachColumnTitle.trim());
				// logger.info("Each Column Title index Dynamic "+indexOfColumn);

				String value = "" + eachRowQuery.get(eachColumnTitle);
				// logger.info("Value from dynamic Method "+value);

				for (int j = 1; j <= rowCount() - 1; j++) {

					try {
						if (getCellData(j, 0).isEmpty()) {
							break;
						} else {

							String selectedRowName = rowNameSelected + "/" + prepListRowNumber;
							// logger.info("### Selected Row Name "+selectedRowName);
							if (getCellData(j, 0).trim().equals(selectedRowName.trim())) {
//								logger.info(
//										"A^^^^^^^selected Row Name   " + eachColumnTitle + "  " + selectedRowName);

								this.setCellData("", j, indexOfColumn);
								this.setCellData(value, j, indexOfColumn);
								break;
							}

						}

					} catch (Exception e) {
						// TODO Auto-generated catch block

					}

					// Row Title
					String rowName = getCell(j, 0).toString().trim();

					// logger.info("Row Names " + rowName + " for index number " + (j + 1));

				}
				// continue;

			}

		}

	}

	public void setUpDataSelectedRows(ArrayList<String> eachNameOfColumn_List, String rowTitle, String valueKey,
			String value) {

		for (String eachColumnTitle : eachNameOfColumn_List) {
			if (eachColumnTitle.trim().equals(valueKey)) {
				int indexOfColumn = this.getCellIndex(eachColumnTitle);
				for (int i = 1; i <= this.rowCount() - 1; i++) {

					try {
						if (this.getCellData(i, 0).isEmpty()) {

						} else {

							try {
								if (this.getCellData(i, 0).trim().contains(rowTitle.trim())) {

									try {
										this.setCellData(value, i, indexOfColumn);
									} catch (Exception e) {
										// TODO Auto-generated catch block

									}

								}
							} catch (Exception e) {
								// TODO Auto-generated catch block

							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block

					}
				}
			}
		}
	}

	public void setUpDataAllRows(ArrayList<String> eachNameOfColumn_List, String valueKey, String value) {

		for (String eachColumnTitle : eachNameOfColumn_List) {
			if (eachColumnTitle.trim().equals(valueKey)) {
				int indexOfColumn = this.getCellIndex(eachColumnTitle);
				for (int i = 1; i <= this.rowCount() - 1; i++) {

					try {
						if (this.getCellData(i, 0).isEmpty()) {

						} else {

							try {
								if (this.getCellData(i, 0).trim().contains("Record")
										|| this.getCellData(i, 0).trim().contains("Post/Fail")) {

								} else {

									try {
										this.setCellData(value, i, indexOfColumn);
									} catch (Exception e) {
										// TODO Auto-generated catch block

									}

								}
							} catch (Exception e) {
								// TODO Auto-generated catch block

							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block

					}
				}
			}
		}
	}

	public void passFail(ArrayList<String> seclectedColums, String rowTitleName1, String rowTitleName2,
			String rowTitleNamePassFail, int recourds) {
		int index1, index2, indexPassFail, ColumnIndexNumber = 0;
		for (int i = 1; i <= recourds; i++) {
			// getting rowTitle name
			String rowTitle1 = rowTitleName1 + "/" + i;
			String rowTitle2 = rowTitleName2 + "/" + i;
			String rowTitlePassFail = rowTitleNamePassFail + "/" + i;
			// Getting Row indexs
			index1 = this.findIndexFromExcel(rowTitle1);
			index2 = this.findIndexFromExcel(rowTitle2);
			indexPassFail = this.findIndexFromExcel(rowTitlePassFail);

			for (String eachPassFail : seclectedColums) {

				ColumnIndexNumber = this.getCellIndex(eachPassFail.trim());

				try {
					if (this.getCellData(index1, ColumnIndexNumber).trim()
							.equals(this.getCellData(index2, ColumnIndexNumber).trim())) {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
						this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);

					} else {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
						this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}

			}
		}
	}

	public void passFailBySelectedColumn(String columnName, String flag, String rowTitleName1, String rowTitleName2,
			String rowTitleNamePassFail, int recourds) {
		int index1, index2, indexPassFail, ColumnIndexNumber = 0;
		for (int i = 1; i <= recourds; i++) {

			String rowTitle1 = rowTitleName1 + "/" + i;
			String rowTitle2 = rowTitleName2 + "/" + i;

			String rowTitlePassFail = rowTitleNamePassFail + "/" + i;
			index1 = this.findIndexFromExcel(rowTitle1);
			index2 = this.findIndexFromExcel(rowTitle2);
			indexPassFail = this.findIndexFromExcel(rowTitlePassFail);
//	 		logger.info("index    :  "+index1+       " this Row:  "+rowTitle1);
//	 		logger.info("index    :  "+index2+       " this Row:  "+rowTitle2);
//	 		logger.info("index p/f:  "+indexPassFail+" this Row:  "+rowTitlePassFail);
//			

			ColumnIndexNumber = this.getCellIndex(columnName.trim());

			if (flag.contains("DUPLICATE") && columnName.contains("DUPLICATE")) {

				try {
					if (this.getCellData(index1, ColumnIndexNumber).trim().equals("Y")) {
						this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
						this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
					} else {
						this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
						this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}

			} else if (flag.contains("VOID_MATCH") && columnName.contains("VOID_MATCH")) {

				try {
					if (this.getCellData(index1, ColumnIndexNumber).trim().equals("Y")) {
						this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
						this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
					} else {
						this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
						this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}

			}

			else if (columnName.contains("EXCLUSION_FLAG")) {
				this.setCellData("n/a", indexPassFail, ColumnIndexNumber);
				this.cell_WHITE_ColorStyle(indexPassFail, ColumnIndexNumber);
			} else if (columnName.contains("INVOICE_YRQTR")) {
				this.setCellData("n/a", indexPassFail, ColumnIndexNumber);
				this.cell_WHITE_ColorStyle(indexPassFail, ColumnIndexNumber);
			}

			else if (flag.contains("DUPLICATE") && columnName.contains("ICN")) {
				if (this.getCellData(index1, ColumnIndexNumber).trim()
						.equals(this.getCellData(index2, ColumnIndexNumber).trim())) {
					this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
					this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
				} else {
					this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
					this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
				}
			}

			else {

				this.setCellData("", indexPassFail, ColumnIndexNumber);
				this.setCellData("n/a", indexPassFail, ColumnIndexNumber);
				this.cell_WHITE_ColorStyle(indexPassFail, ColumnIndexNumber);

			}

		}
	}

	public void passFailBySelectedColumnBYFlag(String columnName, String flag, String rowTitleName1,
			String rowTitleName2, String rowTitleNamePassFail, int recourds) {
		int index1, index2, indexPassFail, ColumnIndexNumber, columnIndexNumberForVOID_MATCH_FLAG = 0;

		String VOID_MATCH_FLAG = "VOID_MATCH_FLAG", valueFromVOID_MATCH_FLAG = null;
		String dataFrom2 = null;
		String dataFrom1 = null;
		for (int i = 1; i <= recourds; i++) {

			String rowTitle1 = rowTitleName1 + "/" + i;
			String rowTitle2 = rowTitleName2 + "/" + i;
			String rowTitlePassFail = rowTitleNamePassFail + "/" + i;
			index1 = this.findIndexFromExcel(rowTitle1);
			index2 = this.findIndexFromExcel(rowTitle2);
			indexPassFail = this.findIndexFromExcel(rowTitlePassFail);

			try {
				columnIndexNumberForVOID_MATCH_FLAG = this.getCellIndex(VOID_MATCH_FLAG);
			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}

			try {
				valueFromVOID_MATCH_FLAG = this.getCellData(index1, columnIndexNumberForVOID_MATCH_FLAG).toString()
						.trim();
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}
			ColumnIndexNumber = this.getCellIndex(columnName.trim());
//		 		logger.info("columnName                      "+columnName);
//		 		logger.info("Index of Column Name  "+ColumnIndexNumber);

			if (flag.contains("DUPLICATE") && columnName.contains("DUPLICATE")) {
				if (this.getCellData(index1, ColumnIndexNumber).trim().equals("Y")) {
					this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
					this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
				} else {
					this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
					this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
				}
			} else if (flag.contains("VOID_MATCH") && columnName.contains("VOID_MATCH")) {
				if (this.getCellData(index1, ColumnIndexNumber).trim().equals("Y")) {
					this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
					this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
				} else {
					this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
					this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
				}

			} else if (flag.contains("DUPLICATE") && columnName.contains("CLAIM_STATUS_CODE")) {

				if (this.getCellData(index1, ColumnIndexNumber).trim().equals("O")
						&& this.getCellData(index2, ColumnIndexNumber).trim().equals("O")
						|| (this.getCellData(index1, ColumnIndexNumber).trim().equalsIgnoreCase("V")
								&& this.getCellData(index2, ColumnIndexNumber).trim().equals("V"))) {
					this.setCellData("", indexPassFail, ColumnIndexNumber);
					this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
					this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
				} else {
					this.setCellData("", indexPassFail, ColumnIndexNumber);
					this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
					this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
				}
			} else if (flag.contains("DUPLICATE") && columnName.contains("ICN")) {
				try {
					if (valueFromVOID_MATCH_FLAG.equalsIgnoreCase("Y")) {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("n/a", indexPassFail, ColumnIndexNumber);
						this.cell_WHITE_ColorStyle(indexPassFail, ColumnIndexNumber);
					}

					else if (this.getCellData(index1, ColumnIndexNumber).trim()
							.equals(this.getCellData(index2, ColumnIndexNumber).trim())) {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
						this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
					} else {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
						this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}
			}

			// CLAIM_LINE_NO
			else if (flag.contains("VOID_MATCH") && columnName.contains("CLAIM_LINE_NO")) {

				this.setCellData("", indexPassFail, ColumnIndexNumber);
				this.setCellData("n/a", indexPassFail, ColumnIndexNumber);
				this.cell_WHITE_ColorStyle(indexPassFail, ColumnIndexNumber);

			}

			
			else if (flag.contains("VOID_MATCH") && columnName.contains("CLAIM_STATUS_CODE")) {
				if (this.getCellData(index1, ColumnIndexNumber).trim().equalsIgnoreCase("V")
						&& this.getCellData(index2, ColumnIndexNumber).trim().equalsIgnoreCase("O")
						|| this.getCellData(index1, ColumnIndexNumber).trim().equalsIgnoreCase("V")
								&& this.getCellData(index2, ColumnIndexNumber).trim().equalsIgnoreCase("V")) {
					// this.setCellData("", indexPassFail, ColumnIndexNumber);
					this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
					this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
				} else {
					// this.setCellData("", indexPassFail, ColumnIndexNumber);
					this.setCellData("Fail", indexPassFail, ColumnIndexNumber);
					this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
				}
//		 		  this.setCellData("", indexPassFail, ColumnIndexNumber);
//					this.setCellData("n/a", indexPassFail, ColumnIndexNumber);
//					
			}
			

		
			else if (flag.contains("DUPLICATE") && (columnName.contains("CLAIM_LOAD_BATCH_OID"))) {
				if (valueFromVOID_MATCH_FLAG.equalsIgnoreCase("Y")) {
					this.setCellData("", indexPassFail, ColumnIndexNumber);
					this.setCellData("n/a", indexPassFail, ColumnIndexNumber);

				} else {
					this.setCellData("", indexPassFail, ColumnIndexNumber);
					this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
				}
			}

			// UNITS_REIMBURSED
			else if (flag.contains("VOID_MATCH") && columnName.contains("UNITS_REIMBURSED")) {

				this.setCellData("", indexPassFail, ColumnIndexNumber);
				this.setCellData("n/a", indexPassFail, ColumnIndexNumber);
				this.cell_WHITE_ColorStyle(indexPassFail, ColumnIndexNumber);
			}

			else if (flag.contains("DUPLICATE") && columnName.contains("UNITS_REIMBURSED")) {

				dataFrom2 = this.getCellData(index2, ColumnIndexNumber).toString().trim();
				dataFrom1 = this.getCellData(index1, ColumnIndexNumber).toString().trim();
				logger.info("dataFrom2  " + dataFrom2);
				logger.info("dataFrom2  " + dataFrom2);

				try {
					if (dataFrom2.equals(dataFrom1)
					// && valueFromVOID_MATCH_FLAG.equalsIgnoreCase("null")
					) {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
						this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
					} else if (dataFrom2.equals(dataFrom1.substring(1))
							&& valueFromVOID_MATCH_FLAG.equalsIgnoreCase("Y")) {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("Pass", indexPassFail, ColumnIndexNumber);
						this.cellGreenColorStyle(indexPassFail, ColumnIndexNumber);
					}

					else {
						this.setCellData("", indexPassFail, ColumnIndexNumber);
						this.setCellData("Fail", indexPassFail, ColumnIndexNumber);

						// this.cellRedColorStyle(indexPassFail,ColumnIndexNumber);
						this.cellRedColorStyle(indexPassFail, ColumnIndexNumber);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}
			}

		}
	}
	public String getCellValueByColumnRowIndex(int rowNumber, String ColumnTitle) {
		
		int c=	this.getCellIndex(ColumnTitle);
		
		String cellValue= this.getCellData(rowNumber, c).trim();
		
			return cellValue;
		}
	 
	 
	public int getRowCount() {
		int rowCount=0;
		int count =0;
		
		try {
		
			rowCount= workSheet.getLastRowNum();
			
		
			for(int i=0;i<=rowCount-1;i++) {
				try {
					if(!this.getCellData(i, 0).isEmpty()) {
						count++;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return count;
	}
	public int rowNumberByValue(String rowTitleSelected) {
		int i=0;
		int count=1;
		int rowCountTestingSheet=this.rowCount();
	     //String titleSelecting= userRole+partOfRowTitle;
		for(i=1; i<=rowCountTestingSheet-1; i++) {
			String rowTitle= this.getCellData(i, 0);
			if(rowTitle.equals(rowTitleSelected)) {
				
				break;
			}else {
				count++;
			}
		}
	
		if(count==rowCountTestingSheet) {
			i=-1;
		}
		return i;
	}
	
}
