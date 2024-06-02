package com.pdl.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;

//import cucumber.api.java.en.Given;

public class abc_SetpD {
	
	public static final Logger logger = LogManager.getLogger(abc_SetpD.class);
	
	
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
		 logger.info("************************-----------------------abc tag---------------------------******************************"); 
	}

	@Given("^some other precondition$")
	public void some_other_precondition() throws Throwable {
	  
		 logger.info("************************-----------------------ABC tag---------------------------******************************"); 
	}

	@Given("^I want to write a step with precondition (\\d+)$")
	public void i_want_to_write_a_step_with_precondition(int arg1) throws Throwable {
		 logger.info("************************-----------------------DEF tag---------------------------******************************"); 
	 
	}

	@Given("^some other precondition (\\d+)$")
	public void some_other_precondition(int arg1) throws Throwable {
		 logger.info("************************-----------------------DEF tag---------------------------******************************"); 
	    
	}

	
	
	
}
