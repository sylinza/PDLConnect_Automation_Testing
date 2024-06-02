package com.pdl.utilities;

import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.DayOfWeek;

import java.time.Duration;

import java.time.LocalDate;

import java.time.Month;

import java.time.YearMonth;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Date;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import java.util.Set;

import java.util.TimeZone;

import java.util.concurrent.TimeUnit;

import java.util.stream.IntStream;

import org.apache.commons.io.FileDeleteStrategy;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;

public class CommonMethods extends Driver {

	public static WebDriver driver = Driver.getDriver();

	public static final int ELEMENT_WAIT_TIMEOUT_SECONDS = 40;

	public static final int ELEMENT_POLLING_TIME_MILIS = 50;

	public static final int PAGE_LOAD_TIMEOUT_SECONDS = 40;

	public static final int JQUERY_LOAD_TIMEOUT_SECONDS = 30;

	public static final int SESSION_TIMEOUT_MINUTES = 16;

    JavascriptExecutor js= (JavascriptExecutor)driver;;

	WebDriverWait wait = null;

	public static Logger logger = LogManager.getLogger(CommonMethods.class);

	public SftAssert softAssert = new SftAssert();

	/* Mobile COE - Code Added */

	/* Constructor modified with WebDriver instance argument */

//	public CommonMethods(WebDriver driver) { 
//
//		this.driver = driver; 
//
//		PageFactory.initElements(driver, this); 
//
//	} 

	// Wait for page to load

	public void waitForPageToLoad() {

		logger.info("Wait for Web Page to load completely");

		wait = new WebDriverWait(this.driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT_SECONDS));

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver arg0) {

				boolean isLoaded = false;

				JavascriptExecutor js = (JavascriptExecutor) arg0;

				if (js.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")) {

					isLoaded = true;

					logger.info("Web Page loaded successfully.");

				}

				return isLoaded;

			}

		};

		wait.until(function);

	}
	
	
	public void waitForPageToLoadfor(int sec) {

		logger.info("Wait for Web Page to load completely");

		wait = new WebDriverWait(this.driver, Duration.ofSeconds(sec*1000));

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver arg0) {

				boolean isLoaded = false;

				JavascriptExecutor js = (JavascriptExecutor) arg0;

				if (js.executeScript("return document.readyState").toString().equalsIgnoreCase("complete")) {

					isLoaded = true;

					logger.info("Web Page loaded successfully.");

				}

				return isLoaded;

			}

		};

		wait.until(function);

	}
	
	//wait for specific second : 
	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Wait for Javascript or JQuery to load

	public boolean waitForAJAXToLoad() {

		logger.info("Wait for AJAX to load completely");

		wait = new WebDriverWait(driver, Duration.ofSeconds(JQUERY_LOAD_TIMEOUT_SECONDS));

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override

			public Boolean apply(WebDriver driver) {

				try {

					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);

				} catch (Exception e) {

					return true;

				}

			}

		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override

			public Boolean apply(WebDriver driver) {

				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()

						.equals("complete");

			}

		};

		boolean isWaitComplete = wait.until(jQueryLoad) && wait.until(jsLoad);

		if (isWaitComplete) {

			logger.info("AJAX component of the page loaded successfully.");

			return true;

		} else {

			logger.info("AJAX component of the page are not loaded.");

			return false;

		}

	}

	// wait for element implementation using fluent wait

	public WebElement waitForElement(WebElement locator) {

		logger.info("Checking visibility of the Element on browser screen");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(ELEMENT_WAIT_TIMEOUT_SECONDS))

				.pollingEvery(Duration.ofMillis(ELEMENT_POLLING_TIME_MILIS))

				.ignoring(Exception.class);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("busy-div")));

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver arg0) {
				// test

				WebElement elem = null;

				if (locator.isDisplayed() && locator.isEnabled()) {

					elem = locator;
					
					drawborder(locator);

					logger.info("Wait for the element is completed, Element is visible on the screen");

				}

				return elem;

			}

		};

		WebElement e = wait.until(function);

		return e;

	}

	// wait for element implementation using fluent wait

	public static WebElement waitForElement(By locator) {

		logger.info("Checking visibility of the Element on browser screen");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(ELEMENT_WAIT_TIMEOUT_SECONDS))

				.pollingEvery(Duration.ofMillis(ELEMENT_POLLING_TIME_MILIS))

				.ignoring(Exception.class);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("busy-div")));

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver arg0) {

				logger.info("Checking for the Element!!");

				WebElement elem = arg0.findElement(locator);

				if (elem != null && elem.isDisplayed()) {

					logger.info("Element found successfully!");

				}

				return elem;

			}

		};

		WebElement e = wait.until(function);

		return e;

	}
	
// browserUtils	
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

	// Wait for the Title of a webpage

	public boolean waitForTitle(String pageTitle) {

		logger.info("Wait for Page title to load");

		wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT_SECONDS));

		return wait.until(ExpectedConditions.titleIs(pageTitle));

	}
	
	
	
//	from browserUtils
	public static WebElement waitForClickablility(WebElement element, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for an Alert to appear

	public Alert waitForAlert() {

		logger.info("Wait for An alert to appear");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(ELEMENT_WAIT_TIMEOUT_SECONDS))

				.pollingEvery(Duration.ofMillis(ELEMENT_POLLING_TIME_MILIS))

				.ignoring(NoAlertPresentException.class);

		Function<WebDriver, Alert> function = new Function<WebDriver, Alert>() {

			public Alert apply(WebDriver arg0) {

				logger.info("Waiting for the alert");

				Alert alert = driver.switchTo().alert();

				return alert;

			}

		};

		return wait.until(function);

	}
	
	//wait for URL
	public static Boolean waitForUrlContains(String expectedSubstring) {
		
		logger.info("waiting for URL to Contain: " + expectedSubstring);
		
        Duration timeToWaitInSec = Duration.ofSeconds(PAGE_LOAD_TIMEOUT_SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.urlContains(expectedSubstring));
    }

	// Switch to Other Window:

	public void switchToAnotherWindow(String CurrentWin) {

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> windows = driver.getWindowHandles();

		for (String s : windows) {

			if (!s.equalsIgnoreCase(CurrentWin)) {

				driver.switchTo().window(s);

				break;

			}

		}

	}

	// Get text of an Element

	public String getElementText(WebElement element) {

		return element.getAttribute("textContent").trim();

	}

	// Get attribute value of an Element

	public String getAttributeValue(WebElement element, String attributeName) {

		if ("text".equalsIgnoreCase(attributeName)) {

			return getElementText(element);

		} else {

			return element.getAttribute(attributeName);

		}

	}

	public void scrollToElement(WebElement element) {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");

	}

	// Compare two lists

	public boolean listCompare(List<String> expectedList, List<String> inputList) {

		boolean status = false;

		try {

			if (inputList != null && expectedList != null && (inputList.size() == expectedList.size())) {

				for (String opt : inputList) {

					if (expectedList.contains(opt.trim())) {

						status = true;

					} else {

						status = false;

					}

				}

			}

		} catch (Exception e) {

			status = false;

		}

		return status;

	}

	// Check file is downloaded in the given path

	public boolean isFileDownloaded(String filePath, String fileName) throws InterruptedException {

		boolean isFilePresent = false;

		try {

			File dir = new File(filePath);

			Thread.sleep(15000);

			File[] dir_contents = dir.listFiles();

			for (int i = 0; i < dir_contents.length; i++) {

				if (dir_contents[i].getName().contains(fileName))

					isFilePresent = true;

			}

		} catch (Exception e) {

			isFilePresent = false;

		}

		return isFilePresent;

	}

	public boolean isFileUpload(String filePath, String fileName) throws InterruptedException {

		boolean isFilePresent = false;

		try {

			File dir = new File(filePath);

			Thread.sleep(8000);

			File[] dir_contents = dir.listFiles();

			for (int i = 0; i < dir_contents.length; i++) {

				if (dir_contents[i].getName().contains(fileName))

					isFilePresent = true;

			}

		} catch (Exception e) {

			isFilePresent = false;

		}

		return isFilePresent;

	}
	
	
	
	public static void switchToWindowbyTitile(String targetTitle) {
		String origin = Driver.getDriver().getWindowHandle();
		for (String handle : Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(handle);
			if (Driver.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		Driver.getDriver().switchTo().window(origin);
	}


	public String getChildWindowTitle() {

		String title = "";

		String mainWindow = driver.getWindowHandle();

		Set<String> set = driver.getWindowHandles();

		Iterator<String> itr = set.iterator();

		if (itr.hasNext()) {

			while (itr.hasNext()) {

				String childWindow = itr.next();

				if (!mainWindow.equals(childWindow)) {

					driver.switchTo().window(childWindow);

					waitForPageToLoad();

					waitForAJAXToLoad();

					title = driver.switchTo().window(childWindow).getTitle();

					driver.close();

				}

			}

			driver.switchTo().window(mainWindow);

		} else {

			logger.info("No Child window Opened");

			title = driver.getTitle();

		}

		logger.info("title of window " + title);

		return title;

	}

	public int getOpenWindowsCount() {

		try {

			Thread.sleep(4000);

		} catch (Exception e) {

		}

		// Get all open windows

		Set<String> windowHandles = driver.getWindowHandles();

		// Return the count of open windows

		return windowHandles.size();

	}
	
	
	
	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	 
		
	}

	public void selectFromDropdownByIndex(WebElement el, List<WebElement> optionList, int index) throws Exception {

		try {

			el.click();

			// List<WebElement>

			// optionList=driver.findElements(By.xpath("//div[contains(@class,'ui-selectmenu-open')]//a"));

			Thread.sleep(5000);

			for (int i = 0; i < optionList.size(); i++) {

				if (i == index) {

					waitForElement(optionList.get(i)).click();

					break;

				}

			}

		} catch (Exception e) {

			throw new Exception("Failed to click on option at index " + index);

		}

	}
	
	public static Select selectFromDropDownbyVisibleText(WebElement dropdown, String optionName) {
		dropdown.click();
		waitFor(1);
		Select select = new Select(dropdown);
 	 
		//List<WebElement> lis = Driver.getDriver().findElements(By.xpath(dropdown));
		//CommonMethods.waitFor(2);
		select.selectByVisibleText(optionName);
		//dropdown.click();
		return select;
	}
	
	
	public static Select selectFromDropDownbyValue(WebElement dropdown, String optionName) {
		dropdown.click();
		waitFor(1);
		Select select = new Select(dropdown);
 	 
		//List<WebElement> lis = Driver.getDriver().findElements(By.xpath(dropdown));
		//CommonMethods.waitFor(2);
		//select.selectByVisibleText(optionName);
		select.deselectByValue(optionName.trim());
		//dropdown.click();
		return select;
	}
	
	
//	   From Browser Utils
       public static String selectFromropDownRendomOption(WebElement dropdown) {
    	   
		Select select = new Select(dropdown);
		List<WebElement> i =select.getOptions();	
	     int size= i.size();	     
	    int rendomeOption= randInt(0, (size-1));	    
	    	String eachOption= i.get(rendomeOption).getText().trim();	    
	    	return eachOption;
	}
       
       
   	public static int dropDownElementsInTotal(WebElement dropdown) {
		dropdown.click();
		Select dropDown = new Select(dropdown);
		List<WebElement> e = dropDown.getOptions();
		int itemCount = e.size();
		return itemCount;
	}
	
//	   From Browser Utils
	public static Select selectFromdropDownByStateAbrivation(WebElement dropdown, String optionName) {
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
	
	
	
//	   From Browser Utils
	public static void checkBoxYesNO(WebElement checkBox, String fromExcel) {
		if(fromExcel.equalsIgnoreCase("Yes")&&checkBox.isSelected()) {
			logger.info("Check Box already selected for "+checkBox);
		}else if(fromExcel.equalsIgnoreCase("No")&& !checkBox.isSelected()) {
			logger.info("Check box is not selected and not will be selected becouse is No for "+checkBox);
		}else {
			checkBox.click();
		}
		
	}
	
	
	
//	   From Browser Utils
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

	/**
	 * 
	 * Scroll screen to a particular element
	 * 
	 * 
	 * 
	 * @param element
	 * 
	 */

	public void scrollScreen(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block: \"center\", inline: \"center\"});", element);

	}

	public boolean isElementDisplayed(WebElement locator) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		// .implicitlyWait(0, TimeUnit.SECONDS);

		logger.info("Checking visibility of the Element on browser screen");

		try {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))

					.pollingEvery(Duration.ofMillis(ELEMENT_POLLING_TIME_MILIS))

					.ignoring(Exception.class);

			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

				public Boolean apply(WebDriver arg0) {

					Boolean isPresent = false;

					if (locator.isDisplayed()) {

						isPresent = true;

						logger.info("Wait for the element is completed, Element is visible on the screen");

					}

					return isPresent;

				}

			};

			boolean e = wait.until(function);

			return e;

		} catch (Exception e) {

			return false;

		}

	}
	
	

	public boolean isElementPresent(WebElement locator) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		logger.info("Checking Presence of the Element on browser screen");

		try {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))

					.pollingEvery(Duration.ofMillis(ELEMENT_POLLING_TIME_MILIS))

					.ignoring(Exception.class);

			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

				public Boolean apply(WebDriver arg0) {

					Boolean isPresent = false;

					if (locator.isDisplayed()) {

						isPresent = true;

						logger.info("Wait for the element is completed, Element is visible on the screen");

					}

					return isPresent;

				}

			};

			boolean e = wait.until(function);

			return e;

		} catch (Exception e) {

			return false;

		}

	}
	
//	   From Browser Utils
	public static Boolean isDisplayedBoolean(WebElement input) {
	      try {
	    	  
	    	  input.isDisplayed();
	          return true;
	      } catch (org.openqa.selenium.NoSuchElementException e) {
	          return false;
	      }
	  }
// **********************  Random Number Methods *******************************
	public static int randInt(int min, int max) {

		Random rand= new Random();	   
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	
	public String getRandomNumber() {

		Random r = new Random();

		int num = Math.abs(r.nextInt()) / 10000;

		;

		return Integer.toString(num);

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

	
	



//********************** End Of - Random Number Methods *******************************
	
	
	
//	   From Browser Utils: 
	public static ArrayList<String> removeDuplicates(ArrayList<String> manufacturerCodeList2) {
		Set<String> set = new LinkedHashSet<>();
		 set.addAll(manufacturerCodeList2);
		 manufacturerCodeList2.clear();
		 manufacturerCodeList2.addAll(set); 
		// logger.info("manufacturerCodeList2");
		 return manufacturerCodeList2; 
	}
	
	
	public static int numberOfTheRowsDynamicTable(String partOfTheXpath) {
		List<WebElement> rows=Driver.getDriver().findElements(By.xpath(partOfTheXpath));
		int rowNumber= rows.size();
		return rowNumber;
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

    
	
	
	
	

	public String GetFuture_EST_Date(int days) {

		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();

		sd.setTimeZone(TimeZone.getTimeZone("EST"));

		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		cal.add(Calendar.DATE, days);

		return sd.format(cal.getTime());

	}

//Shams Addition	 

	public String yesterdaysDate() { // Get the current date

		Date currentDate = new Date();

		// Subtract 2 days from the current date

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(currentDate);

		calendar.add(Calendar.DATE, -2);

		Date modifiedDate = calendar.getTime();

		// Define the desired date format

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		// Convert the modified date to the desired format

		String formattedDate = dateFormat.format(modifiedDate);

		// Print the formatted date

		logger.info("Current date minus 2 days in mm/dd/yyyy format: " + formattedDate);

		return formattedDate;

	}

	public void clearDownloadFolder() throws IOException {

		String projectPath = System.getProperty("user.dir");

		String downloadFoderPath = "runtime" + File.separator + "downloads";

		File downloadFolder = new File(projectPath + File.separator + downloadFoderPath);

		if (downloadFolder.exists()) {

			if (downloadFolder.listFiles().length > 0) {

				for (File file : downloadFolder.listFiles()) {

					FileDeleteStrategy.FORCE.delete(file);

				}

			}

		} else {

			downloadFolder.mkdir();

		}

	}

	public int getFileCountInDownloadFolder() {

		String projectPath = System.getProperty("user.dir");

		String downloadFoderPath = "runtime" + File.separator + "downloads";

		File downloadFolder = new File(projectPath + File.separator + downloadFoderPath);

		File[] dir_contents = downloadFolder.listFiles();

		return dir_contents.length;

	}

	/**
	 * 
	 * Get weekend dates of a given month & year
	 * 
	 * 
	 * 
	 * @param month - month of a Year
	 * 
	 * @param year  - Year
	 * 
	 * @return
	 * 
	 */
	public String leftPadStringWithLeadingZeroes(Integer n, String str)

	{

		// n -> Size of the string to be generated

		// str -> String to be padded with Zeros

		String format = "%0" + n + "d";

		String str1 = String.valueOf(String.format(format, Integer.parseInt(str)));

		return str1; // return String

	}

	public String getCurrentDate(String dateFormate) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormate);

		Date d = new Date();

		return dateFormat.format(d).toString();

	}

	public String getDateInFormat(String input, String inputDF, String outputDF) {

		String finalInput = input;

		if (inputDF.length() - input.length() > 0) {

			finalInput = leftPadStringWithLeadingZeroes(inputDF.length(), input);

		}

		DateFormat fmt1 = new SimpleDateFormat(inputDF);

		Date date = null;

		try {

			date = fmt1.parse(finalInput);

		} catch (ParseException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		DateFormat fmt2 = new SimpleDateFormat(outputDF);

		String reqFmtDate = fmt2.format(date);

		return reqFmtDate;

	}
	
//	   From Browser Utils
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
	
	
	
	

	public String getCurrentWindowHandle() {

		return driver.getWindowHandle();

	}

	public String getChildWindowUrl() {

		String mainWindow = driver.getWindowHandle();

		String url1 = "";

		Set<String> set = driver.getWindowHandles();

		Iterator<String> itr = set.iterator();

		if (itr.hasNext()) {

			while (itr.hasNext()) {

				String childWindow = itr.next();

				if (!mainWindow.equals(childWindow)) {

					driver.switchTo().window(childWindow);

					waitForPageToLoad();

					waitForAJAXToLoad();

					url1 = driver.getCurrentUrl();

					driver.close();

				}

			}

			driver.switchTo().window(mainWindow);

		}

		return url1;

	}

	public String getWeekeendDates(int month, int year) {

		int y = year;

		Month m = Month.of(month);

		List<Integer> weekendDate = new ArrayList<Integer>();

		IntStream.rangeClosed(1, YearMonth.of(y, m).lengthOfMonth()).mapToObj((day) -> LocalDate.of(y, m, day))

				.filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)

				.forEach(date -> weekendDate.add(date.getDayOfMonth()));
		String date = month + "/" + weekendDate.get(2) + "/" + year;

		return getDateInFormat(date, "M/d/yyyy", "MM/dd/yyyy");

	}
	
	
	/* ------------------------------ Java Script Utilities -----------------------------------------     */


	public static void jsclick(WebDriver driver,WebElement element) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click()", element);
	}
	
     public static void SelectDateByJS(WebDriver driver,WebElement element,String Datevalue) {		
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].setAttribute('value','"+Datevalue+"')", element);
		
	}
     
     public static void scrollIntoView(WebDriver driver,WebElement element) {		
 		JavascriptExecutor js = (JavascriptExecutor)driver;		
 		js.executeScript("arguments[0].scrollIntoView(true);", element);
 		
 	}
     
     
     public static void scrollbottom(WebDriver driver) {		
  		JavascriptExecutor js = (JavascriptExecutor)driver;		
  		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
  		
  	}
     
     public static void changecolour(String color,WebElement element,WebDriver driver) {
    	 
    		JavascriptExecutor js = (JavascriptExecutor)driver;	
    		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
    		try {
    			Thread.sleep(200);
    		}
    		catch (Exception e) {
				e.printStackTrace();
			} }
     
        public static void flash(WebElement element,WebDriver driver) {
        	
        	String bgcolor= element.getCssValue("backgroundColor");
        	System.out.println(bgcolor);
        	
        	for(int i=0;i<20;i++) {
        		changecolour("#0000FF", element, driver);
        		changecolour(bgcolor, element, driver);
        	}}
        
        
        public void drawborder(WebElement element) {
//        	JavascriptExecutor js = (JavascriptExecutor)driver;	
    		js.executeScript("arguments[0].style.border='3px solid green'", element);
    		
    	
    		try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
        }
        
        public static void generateAlert(WebDriver driver,String message) {
        	JavascriptExecutor js= (JavascriptExecutor)driver;
        	js.executeScript("alert('"+message+"')");
        	
        	
        }
        
        
        public void click_BD(WebElement element) {
        	
        	drawborder(element);
        	element.click();
        	
        }
        
//        ********************** from prime browser Utils *******************
        
    	public static String getElementText_P(WebElement element) {
    		//WebElement element=Driver.getDriver().findElement(locator);
    		String text ="";
    		if(!element.getText().isEmpty()) {
    			text= element.getText();
    			logger.info("text on element is "+text);
    		     
    		}
    		return text;
    		}
    	
    	
    	public static List<String> getElementsTextByPassingElementList(List<WebElement> list) {
    		List<String> elemTexts = new ArrayList<>();
    		for (WebElement el : list) {
    			if (!el.getText().isEmpty()) {
    				elemTexts.add(el.getText());
    			}
    		}
    		return elemTexts;
    	}
    	
    	
    	public static List<String> getElementsTextbyLocator(By locator) {

    		List<WebElement> elems = Driver.getDriver().findElements(locator);
    		List<String> elemTexts = new ArrayList<>();
    		

    		for (WebElement el : elems) {
    			if (!el.getText().isEmpty()) {
    				elemTexts.add(el.getText());
    			}
    		}
    		return elemTexts;
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
    		

//    		select.selectByVisibleText(optionName);;
    		//return select;
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
//    				try {
//    					DBUtil.establishConnection();
//    				} catch (SQLException e) {
//    					// TODO Auto-generated catch block
//    					
//    				}
    				queryResult_StatusCheckDev=DBUtil.getQueryResultMap(query);
    				 logger.info("Results: "+queryResult_StatusCheckDev);
    		// Disconnect from DEV DB
    				// DBUtil.closeConnection();
    		// connect to StandBY DB		 
//    				 DBUtil.establishConnection_StandBY();
//    				 queryResult_StatusCheck_StandBY=DBUtil.getQueryResultMap(query);
//    				if(queryResult_StatusCheckDev.equals(queryResult_StatusCheck_StandBY)) {
//    					logger.info("Query results are matching between Dev and StandBy Database as expected.");
//    					queryResult_StatusCheckDev=queryResult_StatusCheck_StandBY;
//    				}else {
//    					logger.info("Query results are NOT matching between Dev and StandBy Database as expected.");
//    				}
    				
    			}else {
    				logger.info("No Standby in QA env");
    			}
    		  
    			
    		return queryResult_StatusCheckDev;
    		
    		  
    	  }
    	
    	
    	
    	
    	
    	
    	
    		
	


}
