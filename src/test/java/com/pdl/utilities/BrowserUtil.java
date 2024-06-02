package com.pdl.utilities;



	import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
	import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pdl.utilities.Driver;


public class BrowserUtil {
	
	public static String eachOption;
	public static final Logger logger = LogManager.getLogger(BrowserUtil.class);
	
	
/*	copied with same name in commons
 * public static int randInt(int min, int max) {

		Random rand= new Random();	   
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	
	public static String dropDownRendomOption(WebElement dropdown) {
		
		Select select = new Select(dropdown);
		
		List<WebElement> i =select.getOptions();
	 
	     int size= i.size();
	     
	    int rendomeOption= BrowserUtil.randInt(0, (size-1));
	    
	    	String eachOption= i.get(rendomeOption).getText().trim();
	    
	    	return eachOption;
	}
	

	
	public static int getDecimalRandomNumber(){
        // create instance of Random class
        Random rand = new Random();
        // Generate and return Random number with decimal
        return rand.nextInt();
    }
	
	public static void rendomFromDD(String webelement) {
		List<WebElement> options = Driver.getDriver().findElements(By.xpath(webelement));
		Random rand = new Random();
		int list= rand.nextInt(options.size());
		
		options.get(list).click();
	}
	
		
	
	
	
	
public static Select dropDownOption1(WebElement dropdown, String optionName) {

		Select select = new Select(dropdown);
		//List<WebElement> lis = Driver.getDriver().findElements(By.xpath(dropdown));
        
		select.selectByVisibleText(optionName);
	
		return select;
	}

// PResent in Common methods as "selectFromDropDownbyVisibleText"
	public static Select dropDownOption(WebElement dropdown, String optionName) {
		dropdown.click();
		CommonMethods.waitFor(1);
		Select select = new Select(dropdown);
 	 
		//List<WebElement> lis = Driver.getDriver().findElements(By.xpath(dropdown));
		//CommonMethods.waitFor(2);
		select.selectByVisibleText(optionName);
		//dropdown.click();
		return select;
	}
	
	
	

//  Present in CM= "selectFromDropDownbyValue"
	public static Select dropDownOption2(WebElement dropdown, String optionName) {
		dropdown.click();
		CommonMethods.waitFor(1);
		Select select = new Select(dropdown);
 	 
		//List<WebElement> lis = Driver.getDriver().findElements(By.xpath(dropdown));
		//CommonMethods.waitFor(2);
		//select.selectByVisibleText(optionName);
		select.deselectByValue(optionName.trim());
		//dropdown.click();
		return select;
	}
	
	
	
	
	
	
	//Common= dropDownElementsTotal
	
	public static int paginationSize(WebElement dropdown) {
		dropdown.click();
		Select dropDown = new Select(dropdown);
		List<WebElement> e = dropDown.getOptions();
		int itemCount = e.size();
		return itemCount;
	}
	
	//commons= selectFromdropDownByStateAbrivation
	
	public static Select dropDownOptionByStateAbrivation(WebElement dropdown, String optionName) {
		dropdown.click();

		Select dropDown = new Select(dropdown);
		List<WebElement> e = dropDown.getOptions();
		int itemCount = e.size();

		for (int l = 0; l < itemCount; l++) {
			logger.info(e.get(l).getText());
			if (e.get(l).getText().trim().contains(optionName)) {
				dropDown.selectByIndex(l);
				break;
			}
			continue;
		}

		return dropDown;
	}
	
	
	
	
	public static void checkBoxYesNO(WebElement checkBox, String fromExcel) {
		if(fromExcel.equalsIgnoreCase("Yes")&&checkBox.isSelected()) {
			logger.info("Check Box already selected for "+checkBox);
		}else if(fromExcel.equalsIgnoreCase("No")&& !checkBox.isSelected()) {
			logger.info("Check box is not selected and not will be selected becouse is No for "+checkBox);
		}else {
			checkBox.click();
		}
		
	}
	
	
//	available in java scrop utilities as "scrolltobottom"
public static void javascriptExecutor() {
	JavascriptExecutor jsc = (JavascriptExecutor)Driver.getDriver();
	jsc.executeScript("window.scrollTo(0,document.body.scrollHeight");
	//return jsc;
}






	 * switches to new window by the exact title
	 * commons= switchToWindowbyTitile
	
	public static void switchToWindow(String targetTitle) {
		String origin = Driver.getDriver().getWindowHandle();
		for (String handle : Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(handle);
			if (Driver.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		Driver.getDriver().switchTo().window(origin);
	}
	


   * commons = same name 
	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	 
		
	}
	
	*/

	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 * 
	 * @param list
	 * @return
	 
	
	
//	getElementText_P
	public static String getElementText(WebElement element) {
		//WebElement element=Driver.getDriver().findElement(locator);
		String text ="";
		if(!element.getText().isEmpty()) {
			text= element.getText();
			logger.info("text on element is "+text);
		     
		}
		return text;
		}
		
		
		
		
	
		
	//commons =getElementsTextByPassingElementList
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}
	
	
	
//	getElementsTextbyLocator
	public static List<String> getElementsText(By locator) {

		List<WebElement> elems = Driver.getDriver().findElements(locator);
		List<String> elemTexts = new ArrayList<>();
		

		for (WebElement el : elems) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}
	
	
	
	*/

	
	
	
	public static void waitForHalfSec(int sec) {
		try {
			
			Thread.sleep(sec/2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

/*	 -- added below method in commons with same name
 * 
	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	


	 
	//added in Commons as "waitForUrlContains"
	

	/*
	 * public static Boolean waitForUrlContains(String expectedSubstring, int
	 * timeToWaitInSeconds) { Duration timeToWaitInSec =
	 * Duration.ofSeconds(timeToWaitInSeconds); WebDriverWait wait = new
	 * WebDriverWait(Driver.getDriver(), timeToWaitInSec); return
	 * wait.until(ExpectedConditions.urlContains(expectedSubstring)); }
	 
	 
* commons = waitForElement
	public static WebElement waitForVisibility(WebElement element, int timeToWaitInSeconds) {
		Duration timeToWaitInSec= Duration.ofSeconds(timeToWaitInSeconds);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
     
	
	
	//waitForTitle
	 public static void waitForTitleToMatch(String expectedTitle, int timeToWaitInSeconds) {
	        Duration timeToWaitInSec = Duration.ofSeconds(timeToWaitInSeconds);
	        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
	        wait.until(ExpectedConditions.titleIs(expectedTitle));
	    }
	    
	   
	 
	public static WebElement waitForVisibility(By locator, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickablility(WebElement element, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	
	public static WebElement withForClickability(WebElement associateNewNotificationButton, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
	   	return wait.until(ExpectedConditions.elementToBeClickable(associateNewNotificationButton));
	   	
	}
	
	
	 
	    */	

	
//Has In common Method as "waitForPageLoad"
     
	
	
	/*	
	public static void waitForPageToLoad(int timeOutInSec) {
		Duration timeOutInSeconds = Duration.ofSeconds(timeOutInSec);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {		
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			logger.info("Waiting for page to load...");
				
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
			wait.until(expectation);
			logger.info("Page loaded successfully!");
			
			
		} catch (Throwable error) {
			
			logger.info("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
		}
	}
	
	

	public static boolean isPageLoaded(int timeOutInSec) {
		boolean isPageLoaded = false;

		Duration timeOutInSeconds = Duration.ofSeconds(timeOutInSec);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			if (!expectation.equals(true)) {

				logger.info("************************ Page is refreshing *********************************");

				Driver.getDriver().navigate().refresh();

				WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
				wait.until(expectation);

				if (expectation.equals(true)) {
					logger.info("Page is loaded Successfully");
				}
				isPageLoaded = true;

			}

			else if (!expectation.equals(false)) {
				logger.info("Page is Loaded ");
				isPageLoaded = true;

			}

			return isPageLoaded;

		}

		catch (Throwable error) {
			// logger.info(
			// "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds
			// + " seconds");
			return isPageLoaded;
		}
	}
	
	

	
	
	
	
	@SuppressWarnings("deprecation")
	public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
				//.withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS)
				.withTimeout(Duration.ofSeconds(timeinsec)).pollingEvery(Duration.ofSeconds(timeinsec))
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});
		return element;
	}
	
	
		
	
	
	
	
	
	public static String phoneNumberThreePart(String phoneNumber) {
		String phone=null;
		logger.info("fax number lenght "+phoneNumber.length());
		if(phoneNumber.length()!=0) {
		 phone=phoneNumber.substring(0,3)+Keys.TAB+phoneNumber.substring(4, 7)+Keys.TAB+phoneNumber.substring(8);
		}else {
			logger.info("There is no Number.");
		}
		return phone;
	}
	
	
	
	
	commons= same name
	
	public static void checkBox(WebElement webElement, String option) {
		switch(option) {
		case "yes":
			webElement.click();
			break;
		case "Yes":
			webElement.click();
			break;
		case "no":
			logger.info("There is no in excel sheet no Suppress Interest Calculation");
			
			  
		}
	}
	
	
	
	
	public static void sendKey(WebElement webElement, String excelData) {
		
	if(excelData.isEmpty()|| excelData.equalsIgnoreCase("n/a")||excelData.equalsIgnoreCase("no")) {
		webElement.click();
	}
	webElement.sendKeys(excelData);
		
	}
	
	
	
	
	
	public static String months(String optionName) {
		String month="";
	    
		switch(optionName) {
		case "Jan":
			month= "1";
			break;
			
		case "Feb":
			month= "2";
			break;
			
		case "Mar":
			month= "3";
			break;
		case "Apr":
			month= "4";
			break;
		case "May":
			month= "5";
			break;
			
		case "Jun":
			month="6";
			break;
			
		case "Jul":
			month ="7";
			break;
			
		case "Aug":
			month= "8";
			break;
			
		case "Sep":
			month = "9";
			break;
			
		case "Oct":
			month= "10";
			break;
			
		case "Nov":
			month = "11";
			break;
			
		case "Dec":
			month= "12";
			break;
		
	}return month;
		

//		select.selectByVisibleText(optionName);;
		//return select;
	}
	
	public static String date(String dateFromExcel) {
		if(dateFromExcel.substring(0, 1).equals("0")) {
		String date =months(dateFromExcel.substring(3, 6))+"/"+dateFromExcel.substring(1, 2)+"/"+dateFromExcel.substring(7);
		//When  reading from excel in format 01-Mar-2019 but application 3/1/2019
		return date;
		}else {
			String date =months(dateFromExcel.substring(3, 6))+"/"+dateFromExcel.substring(0, 2)+"/"+dateFromExcel.substring(7);
			return date;
		}
		
		}
		
		
		
	
  
public static Boolean isDisplayedBoolean(WebElement input) {
      try {
    	  
    	  input.isDisplayed();
          return true;
      } catch (org.openqa.selenium.NoSuchElementException e) {
          return false;
      }
  }





public static int numberOfTheRowsDynamicTable(String partOfTheXpath) {
List<WebElement> rows=Driver.getDriver().findElements(By.xpath(partOfTheXpath));
int rowNumber= rows.size();
return rowNumber;
}

 public static int rendomNumberWithin(int min, int max) { 
        // define the range 
      
        int range = max - min + 1; 
        int rand=0;
        // generate random numbers within 1 to 10 i=min-1,i<max,i++
        for (int i =min; i <=  max; i++) { 
             rand = (int)(Math.random() * range) + min; 
  
            // Output is different everytime this code is executed 
            //logger.info("FROM INSIDE FOREACH "+rand); 
            
            
        } 
       
        return rand;
    } 

	
	
	
 public static ArrayList<String> creatInputListRowTitles() {
	 ArrayList<String> listOfRowTitle= new ArrayList<>();
	 listOfRowTitle.add(inputConfigurationReader.getProperty("firstLine"));
	 listOfRowTitle.add(inputConfigurationReader.getProperty("secondLine"));
	 listOfRowTitle.add(inputConfigurationReader.getProperty("thirdLine"));
	 listOfRowTitle.add(inputConfigurationReader.getProperty("fourthLine"));
	 listOfRowTitle.add(inputConfigurationReader.getProperty("fifthLine"));
	 
logger.info("List Of Row Titles  "+listOfRowTitle);
return listOfRowTitle; 
 }
 

 
 
 
 public static  String Workflow_status_MfrRateStep1(String query) {

	  
	  String WORKFLOW_LATEST_STEP_STATUS=null;  
	  String WORKFLOW_STATUS_REF_NAME=null; 
	  String SCHEDULER_STATUS=null;
		
	  do {
			CommonMethods.waitFor(5);
		List<Map<String, Object>> queryResult_StatusCheck = DBUtil.getQueryResultMap(query);
		
		for (Map<String, Object> row : queryResult_StatusCheck) {
			logger.info("Results Status: "+row);
			
			//Completed
			
			Object WORKFLOW_LATEST_STEP_STATUS_OBJ = row.get("WORKFLOW_LATEST_STEP_STATUS");
			  WORKFLOW_LATEST_STEP_STATUS = "" + WORKFLOW_LATEST_STEP_STATUS_OBJ;
			logger.info("WORKFLOW_LATEST_STEP_STATUS step 1:  "+WORKFLOW_LATEST_STEP_STATUS);
			
			Object WORKFLOW_STATUS_REF_NAME_OBJ = row.get("WORKFLOW_STATUS_REF_NAME");
			  WORKFLOW_STATUS_REF_NAME = "" + WORKFLOW_STATUS_REF_NAME_OBJ;
			logger.info("WORKFLOW_STATUS_REF_NAME step 1:     "+WORKFLOW_STATUS_REF_NAME);
			
			Object SCHEDULER_STATUS_OBJ = row.get("SCHEDULER_STATUS");
			  SCHEDULER_STATUS = "" + SCHEDULER_STATUS_OBJ;
			logger.info("SCHEDULER_STATUS step 1:             "+SCHEDULER_STATUS);
			
			//WORKFLOW_TYPE
			Object WORKFLOW_TYPE_OBJ = row.get("WORKFLOW_TYPE");
			String WORKFLOW_TYPE = "" + WORKFLOW_TYPE_OBJ;
			logger.info("WORKFLOW_TYPE step 1:                "+WORKFLOW_TYPE);
			
			
		}
			      
			} while (!WORKFLOW_LATEST_STEP_STATUS.trim().equalsIgnoreCase("Completed")||!WORKFLOW_STATUS_REF_NAME.trim().equalsIgnoreCase("Pending Approval")||!SCHEDULER_STATUS.trim().equalsIgnoreCase("COMPLETED"));	
			
			String finalStatus= "WORKFLOW_LATEST_STEP_STATUS= "+WORKFLOW_LATEST_STEP_STATUS+" , "+"WORKFLOW_STATUS_REF_NAME= "+WORKFLOW_STATUS_REF_NAME+" , "+"SCHEDULER_STATUS= "+SCHEDULER_STATUS;
			
			return finalStatus;
  
 }
 
  public static String WORKFLOW_STATUS_AfterReject(String query) {
	  
	  String WORKFLOW_LATEST_STEP_STATUS=null;  
	  String WORKFLOW_STATUS_REF_NAME=null; 
	  String SCHEDULER_STATUS=null;
		
	  do {
		  CommonMethods.waitFor(5);
		List<Map<String, Object>> queryResult_StatusCheck = DBUtil.getQueryResultMap(query);
		
		for (Map<String, Object> row : queryResult_StatusCheck) {
			logger.info("Results Status: "+row);
			
			//Completed
			
			Object WORKFLOW_LATEST_STEP_STATUS_OBJ = row.get("WORKFLOW_LATEST_STEP_STATUS");
			  WORKFLOW_LATEST_STEP_STATUS = "" + WORKFLOW_LATEST_STEP_STATUS_OBJ;
			logger.info("WORKFLOW_LATEST_STEP_STATUS for INVOICE_GENERATION, Client or MFR step 2:  "+WORKFLOW_LATEST_STEP_STATUS);
			
			Object WORKFLOW_STATUS_REF_NAME_OBJ = row.get("WORKFLOW_STATUS_REF_NAME");
			  WORKFLOW_STATUS_REF_NAME = "" + WORKFLOW_STATUS_REF_NAME_OBJ;
			logger.info("WORKFLOW_STATUS_REF_NAME for INVOICE_GENERATION, Client or MFR step 2 :     "+WORKFLOW_STATUS_REF_NAME);
			
			Object SCHEDULER_STATUS_OBJ = row.get("SCHEDULER_STATUS");
			  SCHEDULER_STATUS = "" + SCHEDULER_STATUS_OBJ;
			logger.info("SCHEDULER_STATUS for INVOICE_GENERATION, Client or MFR step 2:             "+SCHEDULER_STATUS);
			
			//WORKFLOW_TYPE
			Object WORKFLOW_TYPE_OBJ = row.get("WORKFLOW_TYPE");
			String WORKFLOW_TYPE = "" + WORKFLOW_TYPE_OBJ;
			logger.info("WORKFLOW_TYPE for INVOICE_GENERATION, Client or MFR step 2:                "+WORKFLOW_TYPE);
			
			
		}
			      
			} while (!WORKFLOW_LATEST_STEP_STATUS.trim().equalsIgnoreCase("Completed")||!WORKFLOW_STATUS_REF_NAME.trim().equalsIgnoreCase("Rejected")||!SCHEDULER_STATUS.trim().equalsIgnoreCase("COMPLETED"));	
			
			String finalStatus= "WORKFLOW_LATEST_STEP_STATUS= "+WORKFLOW_LATEST_STEP_STATUS+" , "+"WORKFLOW_STATUS_REF_NAME= "+WORKFLOW_STATUS_REF_NAME+" , "+"SCHEDULER_STATUS= "+SCHEDULER_STATUS;
			
			return finalStatus;
  }
  
  public static List<Map<String, Object>> StandByVsDevAndQA(String env, String query)   {


		List<Map<String, Object>> queryResult_StatusCheckDev=null;
		List<Map<String, Object>> queryResult_StatusCheck_StandBY=null;
		if(env.equalsIgnoreCase("DEV")) {
			logger.info("Need to validate Standby if running in DEV env");
			logger.info("Query results in DAV: ");
//			try {
//				DBUtil.establishConnection();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				
//			}
			queryResult_StatusCheckDev=DBUtil.getQueryResultMap(query);
			 logger.info("Results: "+queryResult_StatusCheckDev);
	// Disconnect from DEV DB
			// DBUtil.closeConnection();
	// connect to StandBY DB		 
//			 DBUtil.establishConnection_StandBY();
//			 queryResult_StatusCheck_StandBY=DBUtil.getQueryResultMap(query);
//			if(queryResult_StatusCheckDev.equals(queryResult_StatusCheck_StandBY)) {
//				logger.info("Query results are matching between Dev and StandBy Database as expected.");
//				queryResult_StatusCheckDev=queryResult_StatusCheck_StandBY;
//			}else {
//				logger.info("Query results are NOT matching between Dev and StandBy Database as expected.");
//			}
			
		}else {
			logger.info("No Standby in QA env");
		}
	  
		
	return queryResult_StatusCheckDev;
	
	  
  }
  
   */
 
}


