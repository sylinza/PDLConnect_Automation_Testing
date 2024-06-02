package com.pdl.step_definitions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;

public class New_TLS_Driver_DB_Connection {
	
	public static final Logger logger = LogManager.getLogger(New_TLS_Driver_DB_Connection.class);
	
	
	
	
	@Given("^user connecting to DB using new driver for TNS$")
	public void user_connecting_to_DB_using_new_driver_for_TNS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
// tell the driver where to look for the TNSNAMES.ORA file
		System.setProperty(
		          "oracle.net.tns_admin",
		          "C:\\app\\client\\petrosjanatwifordg\\product\\19.0.0\\client_1\\network\\admin");
// ORCL is net service name from the TNSNAMES.ORA file
		String dbURL = "jdbc:oracle:thin:@//orclrbtctst:1521/orclrbtctst.mbh.mhs.magellanhealth.com";
		// jdbc:oracle:thin:@//orclrbtctst:1521/orclrbtctst.mbh.mhs.magellanhealth.com

		
// load the driver
	//	Class.forName("oracle.jdbc.OracleDriver");
		
		Connection conn = null;
		Statement stmt = null;
		
		
		conn = DriverManager.getConnection(dbURL,
				ConfigurationReader.getProperty("oracleUserId"),

				ConfigurationReader.getProperty("oraclePassword"));

         stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select Client_Program_Name from client_Program where client_Program_abrv_code='MNP' order by 1 desc");

         logger.info(rs);

		
	    //throw new PendingException();
	}

}
