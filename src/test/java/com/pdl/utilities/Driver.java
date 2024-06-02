package com.pdl.utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {

	public Driver() {
	}

	private static WebDriver driver;
	public static final Logger logger=LogManager.getLogger(Driver.class); 



	public static WebDriver getDriver() {
		
		if (driver == null) {
			switch (ConfigurationReader.getProperty("browser")) {
			case "firefox":
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				//WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "ie":
				//WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "headless":
				//WebDriverManager.chromedriver().setup();
			    driver = new HtmlUnitDriver();
			  break;	    
			}
		}
	   driver.manage().deleteAllCookies();
		return driver;
	}
	


	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}
