package com.pdl.utilities;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class QueryUtil {
	public static final Logger logger = LogManager.getLogger(QueryUtil.class);
	
	
	
	public static String from_CLIENT_PROGRAM_Table_Getting_client_program_bid(String CLIENT_PROGRAM_LEGACY_REF) {
		String 	CLIENT_PROGRAM_BID_String=null;
		List<Map<String, Object>> qRtMap_From_CLIENT_PROGRAM_Table_Getting_client_program_bid = DBUtil
				.getQueryResultMap("SELECT * FROM CLIENT_PROGRAM WHERE CLIENT_PROGRAM_LEGACY_REF='"
						+ CLIENT_PROGRAM_LEGACY_REF + "'");

		// invoiceNumberONPaymentAllocation
		// NDCRendomTest
		for (Map<String, Object> row : qRtMap_From_CLIENT_PROGRAM_Table_Getting_client_program_bid) {
			logger.info(" FROM CLIENT_PROGRAM Table: " + row + "\n");
			Object CLIENT_PROGRAM_BID_Object = row.get("CLIENT_PROGRAM_BID");
			CLIENT_PROGRAM_BID_String = "" + CLIENT_PROGRAM_BID_Object;
			logger.info("CLIENT_PROGRAM_BID_String is: " + CLIENT_PROGRAM_BID_String);
        
		}
		return CLIENT_PROGRAM_BID_String;
	}
	
	
	
	
	public static String Level1_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId(String CLIENT_PROGRAM_BID, String claimFileNameWithProgramCode ) {
		String CLAIM_LOAD_BATCH_OID= null;
		List<Map<String, Object>> from_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId = DBUtil
				.getQueryResultMap("Select * From CLAIM_LOAD_BATCH where client_program_bid = '"+CLIENT_PROGRAM_BID+"' and Claim_File_Name='"+claimFileNameWithProgramCode+"'order by 1 desc");
	
		//Select * From CLAIM_LOAD_BATCH where client_program_bid = '1608' and Claim_File_Name='LJE_LA_RBTEXT_20200217_MASKED_dt_upd.TXT'order by 1 desc;
         
		for (Map<String, Object> rowCLAIM_LOAD_BATCH : from_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId) {

			 logger.info("FROM CLAIM_LOAD_BATCH Table: " + rowCLAIM_LOAD_BATCH + "\n");

			// INVOICE_YRQTR
			Object CLAIM_LOAD_BATCH_OID_OBJ = rowCLAIM_LOAD_BATCH.get("CLAIM_LOAD_BATCH_OID");
		    CLAIM_LOAD_BATCH_OID = "" + CLAIM_LOAD_BATCH_OID_OBJ;
			 logger.info("CLAIM_LOAD_BATCH_OID from CLAIM_LOAD_BATCH Table  "+CLAIM_LOAD_BATCH_OID);
			
		}
		return CLAIM_LOAD_BATCH_OID;
	}
	public static String Level2_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId(String CLIENT_PROGRAM_BID, String Processing_YearQtr  ) {
		String CLAIM_LOAD_BATCH_OID= null;
		List<Map<String, Object>> from_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId = DBUtil
				.getQueryResultMap("Select * From CLAIM_LOAD_BATCH where client_program_bid = '"+CLIENT_PROGRAM_BID+"' and processing_YearQtr='"+Processing_YearQtr +"'order by 1 desc");
	
		//Select * From CLAIM_LOAD_BATCH where client_program_bid = '1608' and Claim_File_Name='LJE_LA_RBTEXT_20200217_MASKED_dt_upd.TXT'order by 1 desc;
         
		for (Map<String, Object> rowCLAIM_LOAD_BATCH : from_CLAIM_LOAD_BATCH_getting_Claim_Load_Batch_OId) {

			 logger.info("FROM CLAIM_LOAD_BATCH Table: " + rowCLAIM_LOAD_BATCH + "\n");

			// INVOICE_YRQTR
			Object CLAIM_LOAD_BATCH_OID_OBJ = rowCLAIM_LOAD_BATCH.get("CLAIM_LOAD_BATCH_OID");
		    CLAIM_LOAD_BATCH_OID = "" + CLAIM_LOAD_BATCH_OID_OBJ;
			 logger.info("CLAIM_LOAD_BATCH_OID from CLAIM_LOAD_BATCH Table  "+CLAIM_LOAD_BATCH_OID);
			
		}
		return CLAIM_LOAD_BATCH_OID;
	}
	
	
}
