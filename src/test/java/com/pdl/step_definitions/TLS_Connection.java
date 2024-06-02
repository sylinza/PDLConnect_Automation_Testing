package com.pdl.step_definitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pdl.utilities.DBUtil;
import io.cucumber.java.en.Then;


//import cucumber.api.java.en.Then;

public class TLS_Connection {
	
	public static final Logger logger = LogManager.getLogger(TLS_Connection.class);

	@Then("^user connecting to DB$")
	public void user_connecting_to_DB() throws Throwable {
		//DBUtil.closeConnection();
		
		//DBUtil.establishConnectionTLS();
		    
		List<Map<String, Object>> queryResultMap = DBUtil.getQueryResultMap("Select * from client_Program where client_Program_abrv_code='MNP' order by 1 desc");
		   // Client_Program_Name    
		 
		    for (Map<String, Object> row : queryResultMap) {
				logger.info(row);
		  
		   
		    } 
		    
	
		    
	}
	
}
