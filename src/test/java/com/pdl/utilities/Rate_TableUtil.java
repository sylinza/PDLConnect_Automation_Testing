package com.pdl.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rate_TableUtil {
	
	public static final Logger logger = LogManager.getLogger(Rate_TableUtil.class);
	
	
	public  static String expectedRateTableNameForSelectedProductLine(String ProductLine ){
		//from 19-Jan-2022 to 01/19/2022
	 
	 String tableName=null;
		 
		logger.info(ProductLine);
		
		switch (ProductLine) {
	
		 case "ADAP Supplemental":   
			 tableName="CLIENT_RATE";
			 break;
		
		 case "Medicaid Fee for Service":   
			 tableName="CMS_RATE";
			 break;
		
		 case "Medicaid MCO":   
			 tableName="CMS_RATE";
			 break;
		
		 case "NMPI":   
			 tableName="CLIENT_RATE";
			 break;
		
		 case "State-specific":   
			 tableName="CLIENT_RATE";
			 break;
		 
		
		 case "Diabetic Supply":   
			 tableName="CLIENT_RATE";
			 break;
		
		 case "SPAP":   
			 tableName="CLIENT_RATE";
			 break;
		
		 case "TitleV":   
			 tableName="CLIENT_RATE";
			 break;
		 
		 case "PACE_ADAP":   
			 tableName="CLIENT_RATE";
			 break;
		 
		 case "PACE_ADAP Supplemental":   
			 tableName="CLIENT_RATE";
			 break;
		
		 case "PACE_GENERAL":   
			 tableName="CLIENT_RATE";
			 break;

}
		 	 
	
	return tableName;
	}
	
	public  static String expectedRateTableNameForADAPonly(String ProgramAbrvCode ){
		//from 19-Jan-2022 to 01/19/2022
	 
	 String tableName=null;
		 
		logger.info(ProgramAbrvCode);
		
		switch (ProgramAbrvCode) {
	
		 case "NVACMS":   
			 tableName="CMS_RATE";
			 break;
		 case "CAADAP":   
			 tableName="CLIENT_RATE";
			 break;
		 case "CTACMS":   
			 tableName="CLIENT_RATE";
			 break;
		
}
		 	 
	
	return tableName;
	}

	
	

}
