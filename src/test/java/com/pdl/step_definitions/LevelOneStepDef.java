package com.pdl.step_definitions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.junit.Assert;

import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.DBUtil;
import com.pdl.utilities.ExcelStaticMethods;
import com.pdl.utilities.ExcelUtil;
import com.pdl.utilities.ExcelUtilSheets;
import com.pdl.utilities.QueryUtil;
import com.pdl.utilities.TimeUtil;
import com.pdl.utilities.inputConfigurationReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;

public class LevelOneStepDef {
	
	public static final Logger logger = LogManager.getLogger(LevelOneStepDef.class);

	int CellIndex, recordCountSelected,rowCountVoidMatch,original_Claim_Table_Size;

	Cell cell = null;
	List<String> list;
	String CLAIM_STATUS_CODE, CLIENT_PROGRAM_BID_String, flagSelected, CLAIM_LOAD_BATCH_OID, tableName, data_OF_SERVICE,
			data_OF_SERVICE_Formated, Actual_ICN_From_CDMT,claimFileNameWithProgramCode,DATE_OF_SERVICE_Prep;
	// ExcelStaticMethods excelStaticMethods = new ExcelStaticMethods();

	ExcelUtil testResultsPat; 
	
	List<Map<String, Object>> Original_Claim_Table;
	ArrayList<String> eachNameOfColumn_List = new ArrayList<>();
	ArrayList<String> CLAIM_STATUS_CODE_List = new ArrayList<>();
	ArrayList<String> ICN_List = new ArrayList<>();
	ArrayList<String> NDC_List = new ArrayList<>();
	ArrayList<String> PROVIDER_ID_List = new ArrayList<>();
	ArrayList<String> RECIPIENT_ID_List = new ArrayList<>();
	ArrayList<String> INVOICE_YRQTR_List = new ArrayList<>();
	ArrayList<String> PREP_CLAIM_DETAIL_OID_List = new ArrayList<>();
	ArrayList<String> CLAIM_LOAD_BATCH_OID_Prep_List = new ArrayList<>();
	ArrayList<String> CLIENT_PROGRAM_REF_NAME_From_PLDT_List = new ArrayList<>();
	ArrayList<String> CLIENT_PROGRAM_REF_NAME_From_CDMT_List = new ArrayList<>();
	ArrayList<String> Expected_CLIENT_PROGRAM_REF_NAME_From_CDMT_List = new ArrayList<>();

	ArrayList<String> Actual_ICN_From_PLDT_List = new ArrayList<>();
	ArrayList<String> Actual_ICN_From_CDMT_List = new ArrayList<>();
	ArrayList<String> Expected_ICN_From_CDMT_List = new ArrayList<>();
	ArrayList<String> CLAIM_DETAIL_OID_List = new ArrayList<>();
	ArrayList<String> UNITS_REIMBURSED_prep_List= new ArrayList<>();
	ArrayList<String> DATE_OF_SERVICE_prep_List= new ArrayList<>();
	ArrayList<String> CLAIM_LINE_NO_prep_List= new ArrayList<>();
	ArrayList<String> CLAIM_STATUS_CODE_prep_List= new ArrayList<>();
	List<Map<String, Object>> gettingInputDataForSelectedRecords;
	ArrayList<String> Actual_CLIENT_PROGRAM_REF_NAM_From_CDMT_From_CDMT_List = new ArrayList<>();

	
	
	@Given("^user getting data base Clien Progam Legacy Ref \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" for (\\d+) records$")
	public void user_getting_data_base_Clien_Progam_Legacy_Ref_and_for_records(String CLIENT_PROGRAM_LEGACY_REF, String claimFileName, String flag, String Processing_YearQtr, int recordCount) throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		logger.info("claimFileName.substring(0, 2)  " + claimFileName.substring(0, 2));
		recordCountSelected = recordCount;
		//condion 
		
		flagSelected = flag;
		

		try {
			testResultsPat.cleaningDataFromSheet();
		} catch (Exception e1) {
			

		}

//setting Column Titles form inputConfiguration file
		try {
			testResultsPat.settingColumnTitlesForLevel();
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}

		
//Setting Row Titles
		testResultsPat.settingRowTitles(recordCount);

// ADDING DATA TO
		int rowCount = testResultsPat.rowCount();

		logger.info("Not empty row number!!!!!!!! " + rowCount);





		claimFileNameWithProgramCode = CLIENT_PROGRAM_LEGACY_REF + "_" + claimFileName;
		
//entering running time to spreadsheet for each recourd
		testResultsPat.setUpDataAllRows(testResultsPat.settingColumnTitles(), "Time", TimeUtil.getCurrentTime());
		
		testResultsPat.setUpDataAllRows(testResultsPat.settingColumnTitles(), "Claim File Name", claimFileNameWithProgramCode);
     
		
		
        CLIENT_PROGRAM_BID_String = QueryUtil
				.from_CLIENT_PROGRAM_Table_Getting_client_program_bid(CLIENT_PROGRAM_LEGACY_REF);

        //for Level 1 
        logger.info("======================== "+inputConfigurationReader.getProperty("Level").toString().trim()+" ========================");
		
        if (inputConfigurationReader.getProperty("Level").equals("Level 1")) {
			
			tableName = "Prep_Claim_Detail";
			
			logger.info("****************claim File Name With Program Code "+claimFileNameWithProgramCode);
            CLAIM_LOAD_BATCH_OID = QueryUtil.Level1_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId(
			CLIENT_PROGRAM_BID_String, claimFileNameWithProgramCode);
} else {
	tableName = "Claim_Detail";
			//level 2
			CLAIM_LOAD_BATCH_OID = QueryUtil.Level2_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId(
			CLIENT_PROGRAM_BID_String, Processing_YearQtr);
}
		
        
        
        logger.info("\n" + "=============" + flag.replace("_FLAG", "") + "===================" + "\n");
 
			logger.info("CLIENT_PROGRAM_BID as   input: "+CLIENT_PROGRAM_BID_String);
			logger.info("flag as                 input: "+flag);
			logger.info("CLAIM_LOAD_BATCH_OID as input: "+CLAIM_LOAD_BATCH_OID);
			logger.info("recordCount as          input: "+recordCount);
			
//			if(flagSelected.contains("DUPLICATE")) {
//				 gettingInputDataForSelectedRecords = DBUtil
//						.getQueryResultMap("select * from "+tableName+" CDM where client_program_bid = '"
//								+ CLIENT_PROGRAM_BID_String + "'  and CDM." + flag + " = 'Y'and CLAIM_STATUS_CODE='O' and CLAIM_LOAD_BATCH_OID='"
//								+ CLAIM_LOAD_BATCH_OID + "'and rownum<=" + recordCount);
//			
//			}else {
//			
//			
//			 gettingInputDataForSelectedRecords = DBUtil
//					.getQueryResultMap("select * from "+tableName+" CDM where client_program_bid = '"
//							+ CLIENT_PROGRAM_BID_String + "'  and CDM." + flag + " = 'Y'and CLAIM_STATUS_CODE='V' and CLAIM_LOAD_BATCH_OID='"
//							+ CLAIM_LOAD_BATCH_OID + "'and rownum<=" + recordCount);
//		
//			}
			
			gettingInputDataForSelectedRecords = DBUtil
					.getQueryResultMap("select * from "+tableName+" CDM where client_program_bid = '"
							+ CLIENT_PROGRAM_BID_String + "'  and CDM." + flag + " = 'Y' and CLAIM_LOAD_BATCH_OID='"
							+ CLAIM_LOAD_BATCH_OID + "'and rownum<=" + recordCount);
		
	
			int records = 0;
			for (Map<String, Object> row : gettingInputDataForSelectedRecords) {
				records++;

				int TableResponseSize = gettingInputDataForSelectedRecords.size();
				if(recordCountSelected>TableResponseSize) {
					recordCountSelected=TableResponseSize;
				}
				logger.info("Prep size " + TableResponseSize);
				logger.info("FROM "+tableName+" Table: " + row + "\n");
				logger.info("Recourds prep;   " + records);

				// INVOICE_YRQTR
				Object INVOICE_YRQTR_obj = row.get("INVOICE_YRQTR");
				String INVOICE_YRQTR = "" + INVOICE_YRQTR_obj;
				logger.info("INVOICE_YRQTR " + INVOICE_YRQTR);
				INVOICE_YRQTR_List.add(INVOICE_YRQTR);

				// ICN
				Object ICN_obj = row.get("ICN");
				String ICN = "" + ICN_obj;
				logger.info("ICN " + ICN);
				ICN_List.add(ICN);

				// NDC
				Object CLAIM_STATUS_CODE_obj = row.get("CLAIM_STATUS_CODE");
				CLAIM_STATUS_CODE = "" + CLAIM_STATUS_CODE_obj;
				logger.info("CLAIM_STATUS_CODE " + CLAIM_STATUS_CODE);
				CLAIM_STATUS_CODE_List.add(CLAIM_STATUS_CODE);
				// NDC_List.add(NDC);

				Object NDC_obj = row.get("NDC");
				String NDC = "" + NDC_obj;
				logger.info("NDC " + NDC);
				NDC_List.add(NDC);

				// PROVIDER_ID
				Object PROVIDER_ID_obj = row.get("PROVIDER_ID");
				String PROVIDER_ID = "" + PROVIDER_ID_obj;
				// logger.info("NDC "+NDC);
				PROVIDER_ID_List.add(PROVIDER_ID);

				// RECIPIENT_ID
				Object RECIPIENT_ID_obj = row.get("RECIPIENT_ID");
				String RECIPIENT_ID = "" + RECIPIENT_ID_obj;
				// logger.info("NDC "+NDC);
				RECIPIENT_ID_List.add(RECIPIENT_ID);
				//
				// PREP_CLAIM_DETAIL_OID
				Object PREP_CLAIM_DETAIL_OID_obj = row.get("PREP_CLAIM_DETAIL_OID");
				String PREP_CLAIM_DETAIL_OID = "" + PREP_CLAIM_DETAIL_OID_obj;
				// logger.info("PREP_CLAIM_DETAIL_OID: from prep_claim_detail table
				// "+PREP_CLAIM_DETAIL_OID);
				// ICN_List.add(PREP_CLAIM_DETAIL_OID);
				PREP_CLAIM_DETAIL_OID_List.add(PREP_CLAIM_DETAIL_OID);

				// CLAIM_LOAD_BATCH_OID
				Object CLAIM_LOAD_BATCH_OID_obj = row.get("CLAIM_LOAD_BATCH_OID");
				String CLAIM_LOAD_BATCH_OIDPrep = "" + CLAIM_LOAD_BATCH_OID_obj;
				logger.info("CLAIM_LOAD_BATCH_OID " + CLAIM_LOAD_BATCH_OIDPrep);
				// NDC_List.add(NDC);
				CLAIM_LOAD_BATCH_OID_Prep_List.add(CLAIM_LOAD_BATCH_OIDPrep);
				
				
				//UNITS_REIMBURSED
				Object UNITS_REIMBURSED_obj = row.get("UNITS_REIMBURSED");
				String UNITS_REIMBURSED_Prep = "" + UNITS_REIMBURSED_obj;
				logger.info("CLAIM_LOAD_BATCH_OID " + UNITS_REIMBURSED_Prep);
			
				UNITS_REIMBURSED_prep_List.add(UNITS_REIMBURSED_Prep);
				
				//DATE_OF_SERVICE
				Object DATE_OF_SERVICE_obj = row.get("DATE_OF_SERVICE");
				String DATE_OF_SERVICE_Prep1 = "" + DATE_OF_SERVICE_obj;
				 DATE_OF_SERVICE_Prep=DATE_OF_SERVICE_Prep1.substring(0, 10);
				logger.info("CLAIM_LOAD_BATCH_OID " + DATE_OF_SERVICE_Prep);
			DATE_OF_SERVICE_prep_List.add(DATE_OF_SERVICE_Prep);
			
			//CLAIM_LINE_NO
			Object CLAIM_LINE_NO_obj = row.get("CLAIM_LINE_NO");
			String CLAIM_LINE_NO_Prep = "" + CLAIM_LINE_NO_obj;
			
			logger.info("CLAIM_LINE_NO " + CLAIM_LINE_NO_Prep);
			CLAIM_LINE_NO_prep_List.add(CLAIM_LINE_NO_Prep);
			
			//CLAIM_STATUS_CODE
			Object CLAIM_STATUS_CODE_Prep_obj = row.get("CLAIM_STATUS_CODE");
			String CLAIM_STATUS_CODE_Prep = "" + CLAIM_STATUS_CODE_Prep_obj;
			logger.info("CLAIM_STATUS_CODE " + CLAIM_STATUS_CODE_Prep);
			CLAIM_STATUS_CODE_prep_List.add(CLAIM_STATUS_CODE_Prep);
			
			
			List<Map<String, Object>> prep_claim_detail_Table = DBUtil
					.getQueryResultMap("Select * from  "+tableName+" CDM where client_program_bid = '"
							+ CLIENT_PROGRAM_BID_String + "' and ndc = '" + NDC + "' and provider_id = '"
							+ PROVIDER_ID + "' and CDM.RECIPIENT_ID = '" + RECIPIENT_ID + "'and icn ='" + ICN
							+ "'and CLAIM_LOAD_BATCH_OID='" + CLAIM_LOAD_BATCH_OID + "'and CLAIM_STATUS_CODE='"
							+ CLAIM_STATUS_CODE + "'and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD')");
                    
			         testResultsPat.setUPdataValueBycolumnTitleAsKey(prep_claim_detail_Table,
					"Data from "+tableName+" Table", records);

			
			
			
			
			
			List<Map<String, Object>> claim_detail_migrated_Table = DBUtil.getQueryResultMap("Select * from claim_detail_migrated CDM where client_program_bid = '" + CLIENT_PROGRAM_BID_String+ "' and CDM.ndc = '" + NDC + "'and CDM.CLAIM_STATUS_CODE='"+CLAIM_STATUS_CODE_Prep+"' and CDM.provider_id = '" + PROVIDER_ID + "' and CDM.RECIPIENT_ID = '"+ RECIPIENT_ID + "'and CDM.CLAIM_LINE_NO='"+CLAIM_LINE_NO_Prep+"'and CDM.UNITS_REIMBURSED='"+UNITS_REIMBURSED_Prep+"'and CDM.icn ='" + ICN + "'");
				 
				logger.info("++++++++++++++++++++++++++++ )))))))) Void Match Flag  ");
				
				//List<Map<String, Object>> claim_detail_migrated_Table = DBUtil.getQueryResultMap("Select * from claim_detail_migrated CDM where client_program_bid = '" +  CLIENT_PROGRAM_BID_String +"' and ndc = '" + NDC +"' and provider_id = '" + PROVIDER_ID +"' and CDM.RECIPIENT_ID = '" + RECIPIENT_ID + "'and icn ='" + ICN+ "'and CLAIM_LOAD_BATCH_OID='" + CLAIM_LOAD_BATCH_OID +"'and CLAIM_STATUS_CODE='" +  CLAIM_STATUS_CODE + "'");
				
				rowCountVoidMatch=claim_detail_migrated_Table.size();
				
				 logger.info("++++++++++++++++++++++++++++ rowCountFromMigratedTable  "+rowCountVoidMatch);
				
				
				 
				 if(rowCountVoidMatch==0) {
					 
					 if( flag.contains("VOID_MATCH") ){
						
						 //	 select * from claim_detail  pcd
//						 where client_program_bid = 35
//						 and ndc = '00002751017'
//						 and provider_id = '1285613612'
//						 and CLAIM_STATUS_CODE = 'O'
//						 and pcd.RECIPIENT_ID = '2224399595'
//						 and DATE_OF_SERVICE = to_date('2019-08-14', 'YYYY-MM-DD') ;	
//******************************************************************************************************************************************************************						 
						 if(claimFileName.substring(0,claimFileName.indexOf("_") ).equals("KY")) { 
							 Original_Claim_Table =	 DBUtil.getQueryResultMap("select * from "+tableName+"  pcd  where client_program_bid = "+CLIENT_PROGRAM_BID_String+" and ndc = '"+NDC+"'and provider_id = '"+PROVIDER_ID+"'and CLAIM_STATUS_CODE = 'O'and pcd.RECIPIENT_ID = '"+RECIPIENT_ID+"'and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD') ");
						 }	 
						 else if(claimFileName.substring(0,claimFileName.indexOf("_") ).equals("NC")) {
							 Original_Claim_Table =	 DBUtil.getQueryResultMap("select pcd.VOID_MATCH_FLAG,pcd.* from "+tableName+ " pcd where client_program_bid='"+CLIENT_PROGRAM_BID_String+"'and ndc = '"+NDC+"'and provider_id = '"+PROVIDER_ID+"'and CLAIM_STATUS_CODE = 'O' and ICN='"+ICN+"'  and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD')");
							 		 
//							
//********************************************************************************************************************************************						 
						 }else {
							// Original_Claim_Table =	 DBUtil.getQueryResultMap("select * from "+tableName+"  pcd  where client_program_bid = "+CLIENT_PROGRAM_BID_String+" and ndc = '"+NDC+"'and provider_id = '"+PROVIDER_ID+"'and CLAIM_STATUS_CODE = 'O'and pcd.RECIPIENT_ID = '"+RECIPIENT_ID+"'and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD') ");
						 Original_Claim_Table =	 DBUtil.getQueryResultMap("select * from (select pcd.VOID_MATCH_FLAG,pcd.* from "+tableName+ " pcd where client_program_bid='"+CLIENT_PROGRAM_BID_String+"'and ndc = '"+NDC+"'and provider_id = '"+PROVIDER_ID+"'and CLAIM_STATUS_CODE = 'O' and ICN='"+ICN+"'  and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD')order by 1 desc ) where ROWNUM <= 1");
						 
						 } 
						
						 original_Claim_Table_Size= Original_Claim_Table.size();
						
					        
//					        if(original_Claim_Table_Size==0) {
//						 Original_Claim_Table = DBUtil.getQueryResultMap("Select * from "+tableName+"  CDM where client_program_bid = '" +  CLIENT_PROGRAM_BID_String +"' and CLAIM_STATUS_CODE='V'and ndc = '" + NDC +"'and ICN= '"+ICN+"'  and provider_id = '" + PROVIDER_ID +"' and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD')"); 
//					
////				 }
					 }
					 else {
		//Duplication:				 
//						 Select *
//						 from 
//						   ( Select * from prep_claim_detail
//						 where client_program_bid = '164'
//						 and CLAIM_STATUS_CODE='V'
//						 and ndc = '00270131525'
//						 and CLAIM_LINE_NO='12'
//						 --and claim_load_batch_oid= '21987'
//						 and provider_id = '1265539498'
//						 --and ICN='7820384112114'
//						 and DATE_OF_SERVICE = to_date('2019-05-26', 'YYYY-MM-DD')
//						 --and rownum<=1
//						 order by 1 desc ) 
//						   where ROWNUM <= 1;

						// Original_Claim_Table = DBUtil.getQueryResultMap(" Select *( Select * from "+tableName+"  CDM where client_program_bid = '" +  CLIENT_PROGRAM_BID_String +"' and CLAIM_STATUS_CODE='"+CLAIM_STATUS_CODE+"'and ndc = '" + NDC +"'and CLAIM_LINE_NO='"+CLAIM_LINE_NO_Prep+"'and provider_id = '" + PROVIDER_ID +"' and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD') order by 1 desc) where ROWNUM <= 1");		 
						
						 
						 Original_Claim_Table =DBUtil.getQueryResultMap("select * from ( Select * from "+tableName+" where client_program_bid = '"+CLIENT_PROGRAM_BID_String+"' and CLAIM_STATUS_CODE='"+CLAIM_STATUS_CODE+"' and ndc = '"+NDC+"' and CLAIM_LINE_NO='"+CLAIM_LINE_NO_Prep+"' and provider_id = '"+PROVIDER_ID+"' and DATE_OF_SERVICE = to_date('"+DATE_OF_SERVICE_Prep+"', 'YYYY-MM-DD') order by 1 desc ) where ROWNUM <= 1");

					 
					 }
					
					testResultsPat.setUPdataValueBycolumnTitleAsKey(Original_Claim_Table, ("Original Data from "+tableName+" Table"), records);
				
				 }else {
				//and CDM.DATE_OF_SERVICE='"+DATE_OF_SERVICE_Prep+"'
				//and CDM.INVOICE_YRQTR='" + INVOICE_YRQTR + "'
				testResultsPat.setUPdataValueBycolumnTitleAsKey(claim_detail_migrated_Table,
						"Data from Claim_Detail_Migrated Table", records);
			
				
				}
				
			
				
	 		

			}
			
			
		
		
		logger.info("\n" + "=============Input Data================" + "\n");
		
		
		logger.info("claim File Name(input)        from "+tableName+"_Table:    " + claimFileNameWithProgramCode);
		logger.info("CLAIM_LOAD_BATCH_OID(input)   from "+tableName+"_Table:    " + CLAIM_LOAD_BATCH_OID);
		logger.info("CLIENT_PROGRAM_BID(input)     from "+tableName+"_Table:    " + CLIENT_PROGRAM_BID_String);
		logger.info("ICN(input)                    from "+tableName+"_Table:    " + ICN_List);
		logger.info("NDC(input)                    from "+tableName+"_Table:    " + NDC_List);
		logger.info("PROVIDER_ID(input)            from "+tableName+"_Table:    " + PROVIDER_ID_List);
		logger.info("RECIPIENT_ID(input)           from "+tableName+"_Table:    " + RECIPIENT_ID_List);
		logger.info("PREP_CLAIM_DETAIL_OID(input)  from "+tableName+"_Table:    " + PREP_CLAIM_DETAIL_OID_List);
		logger.info("INVOICE_YRQTR(input)          from "+tableName+"_Table:    " + INVOICE_YRQTR_List);
		logger.info("CLAIM_LOAD_BATCH_OID(input)   from "+tableName+"_Table     " + CLAIM_LOAD_BATCH_OID_Prep_List);
		logger.info("CLAIM_STATUS_CODE_List(input) from "+tableName+"_Table     " + CLAIM_STATUS_CODE_List);
		logger.info("UNITS_REIMBURSED_List(input)  from "+tableName+"_Table     " + UNITS_REIMBURSED_prep_List);
		logger.info("DATE_OF_SERVIC_List(input)    from "+tableName+"_Table     " + DATE_OF_SERVICE_prep_List);
		logger.info("CLAIM_LINE_NO_List(input)     from "+tableName+"_Table     " + CLAIM_LINE_NO_prep_List);
		//logger.info("CLAIM_STATUS_CODe_List(input) from Prep_Claim_Detail_Table     " + CLAIM_STATUS_CODE_prep_List);

		
		

	   
	}
	
	
	
	
	@Then("^user validating data from excel sheet \"([^\"]*)\" or \"([^\"]*)\" for \"([^\"]*)\", \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void user_validating_data_from_excel_sheet_or_for_and(String arg1, String arg2, String Flag, String CLIENT_PROGRAM_LEGACY_REF, String claim_File_Name ) throws Throwable {

		logger.info("======================validation====================================================" );
		logger.info("Records Count:    " + recordCountSelected);
		logger.info("Reading data  "+testResultsPat.getCellData(1, 0));;
		
		ArrayList<String> passFailList = new ArrayList<>();

		passFailList.add(inputConfigurationReader.getProperty("Column_6"));
		passFailList.add(inputConfigurationReader.getProperty("Column_7"));
		passFailList.add(inputConfigurationReader.getProperty("Column_8"));
		passFailList.add(inputConfigurationReader.getProperty("Column_8a"));
		passFailList.add(inputConfigurationReader.getProperty("Column_8d"));//DATE_OF_SERVICE
		//passFailList.add(inputConfigurationReader.getProperty("Column_9"));
		passFailList.add(inputConfigurationReader.getProperty("Column_9a"));
		passFailList.add(inputConfigurationReader.getProperty("Column_14"));
		//passFailList.add(inputConfigurationReader.getProperty("Column_15"));
		//passFailList.add(inputConfigurationReader.getProperty("Column_18"));  //EXCLUSION_FLAG
		//passFailList.add(inputConfigurationReader.getProperty("Column_11a"));//CLAIM_LINE_NO
		
		
	
		if(Flag.contains("DUPLICATE")) {
			
			
//			 if(CLAIM_STATUS_CODE.equals("V")) {
//				 passFailList.add("CLAIM_LOAD_BATCH_OID");
//					passFailList.add("CLAIM_LINE_NO");
//			 }
			passFailList.add("ICN");
			passFailList.add("CLAIM_STATUS_CODE");
			passFailList.add("UNITS_REIMBURSED");
			passFailList.add("CLAIM_LINE_NO");
		
			
			
			
			if(rowCountVoidMatch==0) {
				testResultsPat.passFail(passFailList, "Data from "+tableName+" Table",
						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//				testResultsPat.passFailBySelectedColumn("ICN", flagSelected, "Data from "+tableName+" Table",
//						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
				testResultsPat.passFailBySelectedColumn("DUPLICATE_FLAG", flagSelected, "Data from "+tableName+" Table",
						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
				testResultsPat.passFailBySelectedColumn("VOID_MATCH_FLAG", flagSelected, "Data from "+tableName+" Table",
						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
			
				testResultsPat.passFailBySelectedColumn("CLAIM_LOAD_BATCH_OID", flagSelected,
						"Original Data from "+tableName+" Table", "Data from "+tableName+" Table", "Pass/Fail",
				recordCountSelected);

				
				//				testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_STATUS_CODE", flagSelected, "Data from "+tableName+" Table",
//						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//				testResultsPat.passFailBySelectedColumnBYFlag("UNITS_REIMBURSED", flagSelected, "Data from "+tableName+" Table",
//						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//				testResultsPat.passFailBySelectedColumnBYFlag("ICN", flagSelected, "Data from "+tableName+" Table",
//						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//			
			}else {
			testResultsPat.passFail(passFailList, "Data from "+tableName+" Table",
					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
			testResultsPat.passFailBySelectedColumn("DUPLICATE_FLAG", flagSelected, "Data from "+tableName+" Table",
					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
			testResultsPat.passFailBySelectedColumn("VOID_MATCH_FLAG", flagSelected, "Data from "+tableName+" Table",
					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
//			testResultsPat.passFailBySelectedColumn("CLAIM_LOAD_BATCH_OID", flagSelected,
//					"Data from Claim_Detail_Migrated Table", "Data from "+tableName+" Table", "Pass/Fail",
//					recordCountSelected);
//			
			testResultsPat.passFailBySelectedColumn("CLIENT_PROGRAM_REF_NAME", flagSelected,
					"Data from Claim_Detail_Migrated Table", "Data from "+tableName+" Table", "Pass/Fail",
					recordCountSelected);

		
			testResultsPat.passFailBySelectedColumn("EXCLUSION_FLAG", flagSelected, "Data from "+tableName+" Table",
					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
			testResultsPat.passFailBySelectedColumn("INVOICE_YRQTR", flagSelected, "Data from "+tableName+" Table",
					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
			
			
//			testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_STATUS_CODE", flagSelected, "Data from "+tableName+" Table",
//					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
//			testResultsPat.passFailBySelectedColumnBYFlag("UNITS_REIMBURSED", flagSelected, "Data from "+tableName+" Table",
//					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
//			testResultsPat.passFailBySelectedColumnBYFlag("ICN", flagSelected, "Data from "+tableName+" Table",
//					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
//		
			
			
			//			testResultsPat.passFailBySelectedColumn("UNITS_REIMBURSED", flagSelected, "Data from Prep_Claim_Detail Table",
//					"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
			}
	//******************************************************************************************		
			if(claim_File_Name.substring(0,claim_File_Name.indexOf("_") ).equals("NC")) {
				passFailList.add("NDC");
				passFailList.add("RECIPIENT_ID");
				passFailList.add("UNITS_REIMBURSED");
				passFailList.add("DATE_OF_SERVICE");
				passFailList.add("CLAIM_STATUS_CODE");
				passFailList.add("CLAIM_LINE_NO");
				passFailList.add("ICN");
				if(rowCountVoidMatch==0) {

				testResultsPat.passFail(passFailList, "Data from "+tableName+" Table",
						"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
			}else {
				testResultsPat.passFail(passFailList, "Data from "+tableName+" Table",
						"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
			}
				
			}
	//*****************************************************************************************		 
		}
		else if(Flag.contains("VOID_MATCH")) {
			
			
//			if(original_Claim_Table_Size!=0) {
//				passFailList.add("CLAIM_STATUS_CODE");
//			}
//			
			// check if it is good for all
			
//for all 
		
				//no historical data
//				if(rowCountVoidMatch==0) {
//					testResultsPat.passFailBySelectedColumn("ICN", flagSelected, "Data from "+tableName+" Table",
//							"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//					testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_LINE_NO", flagSelected, "Data from "+tableName+" Table",
//							"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//					testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_STATUS_CODE", flagSelected, "Data from "+tableName+" Table",
//							"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//					testResultsPat.passFailBySelectedColumnBYFlag("UNITS_REIMBURSED", flagSelected, "Data from "+tableName+" Table",
//							"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
//				
//				}else {
//					// historical data 
//					testResultsPat.passFailBySelectedColumn("ICN", flagSelected, "Data from "+tableName+" Table",
//							"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);	
//					testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_LINE_NO", flagSelected, "Data from "+tableName+" Table",
//							"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
//					testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_STATUS_CODE", flagSelected, "Data from "+tableName+" Table",
//							"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
//					testResultsPat.passFailBySelectedColumnBYFlag("UNITS_REIMBURSED", flagSelected, "Data from "+tableName+" Table",
//							"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
//				
//				}
			
				
			
			
if(rowCountVoidMatch==0) {
	
	
	testResultsPat.passFail(passFailList, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	testResultsPat.passFailBySelectedColumn("DUPLICATE_FLAG", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	testResultsPat.passFailBySelectedColumn("VOID_MATCH_FLAG", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	testResultsPat.passFailBySelectedColumn("CLAIM_LOAD_BATCH_OID", flagSelected,"Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail",recordCountSelected);
	testResultsPat.passFailBySelectedColumn("CLIENT_PROGRAM_REF_NAME", flagSelected,"Data from "+tableName+" Table", 
			"Original Data from "+tableName+" Table", "Pass/Fail",recordCountSelected);

	
	testResultsPat.passFailBySelectedColumn("EXCLUSION_FLAG", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	testResultsPat.passFailBySelectedColumn("INVOICE_YRQTR", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);

	testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_STATUS_CODE", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);

	//diff when original data prep table
	testResultsPat.passFailBySelectedColumnBYFlag("UNITS_REIMBURSED", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	testResultsPat.passFailBySelectedColumn("ICN", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	testResultsPat.passFailBySelectedColumn("CLAIM_LINE_NO", flagSelected, "Data from "+tableName+" Table",
			"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	

}else {
		testResultsPat.passFail(passFailList, "Data from Prep_Claim_Detail Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		testResultsPat.passFailBySelectedColumn("DUPLICATE_FLAG", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		testResultsPat.passFailBySelectedColumn("VOID_MATCH_FLAG", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		testResultsPat.passFailBySelectedColumn("CLAIM_LOAD_BATCH_OID", flagSelected,
				"Data from Claim_Detail_Migrated Table", "Data from "+tableName+" Table", "Pass/Fail",
				recordCountSelected);
		
		testResultsPat.passFailBySelectedColumn("CLIENT_PROGRAM_REF_NAME", flagSelected,
				"Data from Claim_Detail_Migrated Table", "Data from "+tableName+" Table", "Pass/Fail",
				recordCountSelected);

		
		testResultsPat.passFailBySelectedColumn("EXCLUSION_FLAG", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		
		testResultsPat.passFailBySelectedColumn("INVOICE_YRQTR", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		
		testResultsPat.passFailBySelectedColumn("CLAIM_LINE_NO", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		

		testResultsPat.passFailBySelectedColumnBYFlag("CLAIM_STATUS_CODE", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);

		testResultsPat.passFailBySelectedColumnBYFlag("UNITS_REIMBURSED", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		
		testResultsPat.passFailBySelectedColumn("ICN", flagSelected, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
		
			
}
//*****************************************************************************************
if(claim_File_Name.substring(0,claim_File_Name.indexOf("_") ).equals("NC")) {
	passFailList.add("ICN");
	passFailList.add("CLAIM_LINE_NO");
	passFailList.add("NDC");
	passFailList.add("DATE_OF_SERVICE");
	passFailList.add("INVOICE_YRQTR");
	

	if(rowCountVoidMatch==0) {

		testResultsPat.passFail(passFailList, "Data from "+tableName+" Table",
				"Original Data from "+tableName+" Table", "Pass/Fail", recordCountSelected);
	}else {
		testResultsPat.passFail(passFailList, "Data from "+tableName+" Table",
				"Data from Claim_Detail_Migrated Table", "Pass/Fail", recordCountSelected);
	}
	
}

//***********************************************************************************************
}
logger.info("\n" + "=============Input Data================" + "\n");
		
		
		
		logger.info("claim File Name(input)            " + claimFileNameWithProgramCode);
		logger.info("CLAIM_LOAD_BATCH_OID(input)       " + CLAIM_LOAD_BATCH_OID);
		logger.info("CLIENT_PROGRAM_BID(input)         " + CLIENT_PROGRAM_BID_String);
		logger.info("ICN(input)                        " + ICN_List);
		logger.info("NDC(input)                        " + NDC_List);
		logger.info("PROVIDER_ID(input)                " + PROVIDER_ID_List);
		logger.info("RECIPIENT_ID(input)               " + RECIPIENT_ID_List);
		logger.info("PREP_CLAIM_DETAIL_OID(input)      " + PREP_CLAIM_DETAIL_OID_List);
		logger.info("INVOICE_YRQTR(input)              " + INVOICE_YRQTR_List);
		logger.info("CLAIM_LOAD_BATCH_OID(input)       " + CLAIM_LOAD_BATCH_OID_Prep_List);
		logger.info("CLAIM_STATUS_CODE_List(input)     " + CLAIM_STATUS_CODE_List);
		logger.info("UNITS_REIMBURSED_List(input)      " + UNITS_REIMBURSED_prep_List);
		logger.info("DATE_OF_SERVIC_List(input)        " + DATE_OF_SERVICE_prep_List);
		logger.info("CLAIM_LINE_NO_List(input)         " + CLAIM_LINE_NO_prep_List);
		//logger.info("CLAIM_STATUS_CODe_List(input) from Prep_Claim_Detail_Table     " + CLAIM_STATUS_CODE_prep_List);

	}
	
	@Given("^user selecting right report sheet base \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_selecting_right_report_sheet_base_and(String flag, String CLIENT_PROGRAM_LEGACY_REF) throws Throwable {
		if(inputConfigurationReader.getProperty("Level").equals("Level 1") ) {
			  if(flag.contains("DUPLICATE")) {
				  testResultsPat = new ExcelUtil(ConfigurationReader.getProperty("testResultsPat"), "Results_Level1_DUPLICATE");
			  }else if(flag.contains("VOID_MATCH")) {
				  testResultsPat = new ExcelUtil(ConfigurationReader.getProperty("testResultsPat"), "Results_Level1_VOID_MATCH");
				  
			  }
			 //  testResultsPat = new ExcelUtil(ConfigurationReader.getProperty("testResultsPat"), "Results_Level1_DUPLICATE");
			  
		  }else if(inputConfigurationReader.getProperty("Level").equals("Level 2")) {
			 // Results_Level2_DUPLICATE
			  if(flag.contains("DUPLICATE")) {
				  testResultsPat = new ExcelUtil(ConfigurationReader.getProperty("testResultsPat"), "Results_Level2_DUPLICATE");
			  }else if(flag.contains("VOID_MATCH")) {
				  testResultsPat = new ExcelUtil(ConfigurationReader.getProperty("testResultsPat"), "Results_Level2_VOID_MATCH");
				  
			  }
		  }
			 
		
		try {
				  testResultsPat.cleaningDataFromSheet();
				} catch (Exception e1) {
					// TODO Auto-generated catch block

				}

		    
	}
	
	@Then("^user color Row Title base on results of every single column$")
	public void user_color_Row_Title_base_on_results_of_every_single_column() throws Throwable {
	int rowCount=	testResultsPat.rowCount();
	int count=0;
	for(int i=0;i<=rowCount-1;i++) {
		
		if(testResultsPat.getCellData(i, 0).trim().contains("Pass/Fail")) {
			
//			int indeX=testResultsPat.findIndexFromExcel(testResultsPat.getCellData(i, 0).trim());
		int columnCount=	testResultsPat.columnCount();
		logger.info("Columns Count "+columnCount);
			for(int j=0;j<=columnCount-1;j++) {
				logger.info("row: "+i+" column: "+j);
				
				try {
					if(testResultsPat.getCellData(i, j).trim().equalsIgnoreCase("Fail")){
                count++;
                }
                
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
				
				
			}
			if(count==0) {
				logger.info("count Green: "+count);
				
				
				logger.info("Row title in Green: "+testResultsPat.getCellData(i, 0));
				testResultsPat.getCellData(i, 0);
				testResultsPat.cellGreenColorStyle(i, 0);
				
						}else {
							logger.info("count Red: "+count);
						//	testResultsPat.setCellData("Goara", indeX, 0);
							//testResultsPat.cell_WHITE_ColorStyle(i, 0);
							testResultsPat.cellRedColorStyle(i, 0);
						}
		}
	}
	}
}
