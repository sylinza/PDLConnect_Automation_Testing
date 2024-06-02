package com.pdl.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pdl.utilities.MonthsUtil;

import io.cucumber.java.en.Given;

//import cucumber.api.java.en.Given;

public class testingTempStepDef {
	
	
	public static final Logger logger = LogManager.getLogger(testingTempStepDef.class);
	
	
	
	@Given("^Just testing step$")
	public void just_testing_step() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	String todayDayWithInputFormat= MonthsUtil.convertTodayDate();
	logger.info("Formatted Current Date: "+todayDayWithInputFormat);
	}


}
