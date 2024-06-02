package com.pdl.utilities;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Maps;

import org.apache.logging.log4j.LogManager;

public class SftAssert extends Assertion {

	private String tcName;
	private WebDriver driver;
	private final Map<AssertionError, IAssert> m_errors = Maps.newHashMap();
	private static Logger logger = LogManager.getLogger(SftAssert.class.getName());
	public int failureCount = 0;
	
	 
	private static SoftAssert softassert = null;

	/*
	 * Constructor: SoftAssert(String, WebDriver) Description: Used to get the
	 * current Test case name which we are using with screenshot, & WebDriver
	 * instance to capture screenshot on assert failure.
	 */

//	public SftAssert(WebDriver driver) 
////		this.tcName = tcName;
//		this.driver = driver;
////		this.failureCount = failureCount;
//	}
	
	
	

	private void handleAssertionFailure(String message) {
		failureCount++;
		logger.info("Assertion failed: " + message);
		// Implement screenshot capture logic here if needed
	}

	public void assertEquals(Object actual, Object expected, String message) {
		try {
			if (!actual.equals(expected)) {
				handleAssertionFailure(message);
			}
		} catch (AssertionError e) {
			handleAssertionFailure(message);
		}
	}

	public void softAssertTrue(boolean condition, String PassMessage, String FailMessage) { 
		   getSoftAssert(); 
		   if (condition) { 
//		      mReporter.addStepLog(PassMessage); 
		      logger.info(PassMessage); 
		      softassert.assertTrue(true, PassMessage); 
		   } else { 
//		      mReporter.addStepLog(FailMessage); 
		      logger.info(FailMessage); 
		      softassert.assertTrue(false, FailMessage); 
		   } 
		    
		  //softassert.assertAll(); 
		} 
	
	public int getFailureCount() {
        return failureCount;
    }
	
	public static SoftAssert getSoftAssert() { 
		   //return softassert == null ? softassert = new SoftAssert() : softassert; 
		   if(softassert == null) { 
		      return softassert = new SoftAssert(); 
		   }else { 
		      return softassert; 
		   } 
		} 

	
	public void AssertAll() { 
		   getSoftAssert(); 
		   softassert.assertAll(); 
		   //softassert = null; 
		} 

}
