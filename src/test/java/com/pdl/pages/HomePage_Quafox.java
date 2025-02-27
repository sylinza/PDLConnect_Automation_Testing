package com.pdl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.Driver;

import junit.framework.Assert;

public class HomePage_Quafox extends CommonMethods{
	WebDriver driver = Driver.getDriver();
	
	public HomePage_Quafox() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	public void verify_Your_Store_homepage_loads_successfully() {
	 String actualTitle = driver.getTitle();
	 String expectedTitle ="Account Login";
	 
	 Assert.assertEquals("verify your store home page loads successfully", expectedTitle,actualTitle);
	 
	}
}
	
		
	

