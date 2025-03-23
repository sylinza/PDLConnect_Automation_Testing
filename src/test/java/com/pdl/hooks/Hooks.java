package com.pdl.hooks;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;




//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;

public class Hooks extends CommonMethods {

	String fileName;
	String scenarioName;
	PrintStream console;
	PrintStream o;
	String currentStepName;

	// String scenarioName= scenario.getName().trim();
	// String failName=scenarioName.substring(0, scenarioName.indexOf("-"));
	//
    WebDriver driver=Driver.getDriver();
	BrowserUtil browserUti = new BrowserUtil();
	public static final Logger logger = LogManager.getLogger(Hooks.class);


	@Before
	public void setUp() {
		if (ConfigurationReader.getProperty("browser").equals("headless")) {
			// Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		} 
		
		else {

			logger.info("Running Hooks before every scenario");
			Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Driver.getDriver().manage().window().maximize();
			
			String URL=ConfigurationReader.getProperty("url");
			Driver.getDriver().get(URL);
			
//			mReporter.addStepLog("Url Launched from @beforeHooks -"+URL);
			logger.info("*URL Lunched from hooks : "+ ConfigurationReader.getProperty("url"));			
			
//			waitForPageToLoadfor(20);
			waitForPageToLoad();
			waitForAJAXToLoad();
			
		}
	}
	
	

	@Before
	public void scenarioName(Scenario scenario) {
		logger.info("================================================================");
		scenarioName = scenario.getName().trim();
		logger.info("Scenario Title: " + scenario.getName());
		logger.info("=================================================================");
//		return scenarioName;
	}
	   

	
	


	@After
	public void before(Scenario scenario) {

		logger.info("------------------------------------------------------------------------------------------------------");
		logger.info(scenario.getName() + " Status - " + scenario.getStatus());
		logger.info("------------------------------------------------------------------------------------------------------");
		
		softAssert.AssertAll();
	}
	
	
	

	
	
	@AfterStep
	public static void takeScreenshot(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
		// adding the screenshot to the report
		scenario.attach(screenshot, "image/png", "image");

//	---	for failure only:  disable upper one and enable bellow one

		/*
		 * if (scenario.isFailed()) { // Capture screenshot only if the scenario fails
		 * final byte[] screenshot = ((TakesScreenshot)
		 * Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
		 * scenario.attach(screenshot, "image/png", "Screenshot"); }
		 */

	}

	@After
	public void tearDown(Scenario scenario) {
		// taking a screenshot if the scenario fails
		if (ConfigurationReader.getProperty("browser").equals("headless")) {

		} else {

			Driver.getDriver().manage().deleteAllCookies();

			logger.info("CLosing the Driver");
		//	Driver.closeDriver();

			logger.info("Driver Closed");

			/*
			 * if (scenario.isFailed()) { final byte[] screenshot = ((TakesScreenshot)
			 * Driver.getDriver()).getScreenshotAs(OutputType.BYTES); // adding the
			 * screenshot to the report scenario.attach(screenshot, "image/png",
			 * "FailedSS");
			 * 
			 * // scenario.embed(screenshot, "image/png");
			 * 
			 * }
			 */
		}
	}
	
	/*
	 * Disabled by Shams --- Database Connections.
	  
	  
	 * @Before public void establishConnection() { try { //System.out.
	 * println("Running Hooks and establishing Connection before every scenario");
	 * DBUtil.establishConnection(); } catch (SQLException e) {
	 * 
	 * } }
	 * 
	 * 
	 * @After public void closeConnection() { System.out.
	 * println("Running Hooks and closing Connection after every scenario");
	 * DBUtil.closeConnection();
	 * 
	 * }
	 */
	
	int x=10; //just for testing

}
