package com.pdl.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pdl.pages.HomePage;
import com.pdl.pages.HomePageLogic;
import com.pdl.pages.SignInPage;
import com.pdl.pages.SignInPageLogic;
import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.DBUtil;
import com.pdl.utilities.Driver;
import com.pdl.utilities.ExcelUtil;
import com.pdl.utilities.PrintStreamUtil;
import com.google.common.base.CharMatcher;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

public class ViewManufacturerContacts extends CommonMethods {
	String Menu="//a[text()=' Menu ']";
	String SubMenu="//div[@class='mat-menu-content']/button[contains(text(),'%s')]";
	String ViewManufactureContacts="//button[text()='View Manufacturer Contacts']";
	String Manufaturer_DD="//div[@class='mat-form-field-infix']//*[contains(text(),'Manufacturer')]";
	String DateReceived="//div[@class='mat-form-field-infix']//*[contains(text(),'Date Received')]";
	String Name="//div[@class='mat-form-field-infix']//*[contains(text(),'Name')]";
	WebDriver driver;
	//CommonMethods CommonMethods= new CommonMethods(driver);

	public static Logger logger = LogManager.getLogger(ViewManufacturerContacts.class);     
public ViewManufacturerContacts()
{
	driver= Driver.getDriver();
}

@When("Navigate to Menu > Manufacturer Portal > View Manufacturer Contacts.$")
public void navigate_to_Menu_Manufacturer_Portal_View_Manufacturer_Contacts() throws Throwable {
	CommonMethods.waitFor(15);
	logger.info("Step: Navigate to Menu > Manufacturer Portal > View Manufacturer Contacts.");
	logger.info("logger started");
	CommonMethods.waitForElement(By.xpath(Menu)).click();
	logger.info("Clicked on Menu");
	CommonMethods.waitForElement(By.xpath(String.format(SubMenu, "Manufacturer Portal"))).click(); 
	logger.info("Clicked on  Manufacturer Portal");
	CommonMethods.waitForElement(By.xpath(String.format(SubMenu, "View Manufacturer Contacts"))).click(); 
	//CommonMethods.waitForVisibility(By.xpath(ViewManufactureContacts),Duration.ofSeconds(20));
	//Driver.getDriver().findElement(By.xpath(ViewManufactureContacts)).click();
	logger.info("Clicked on View Manufacturer Contacts");
	
//	assertEquals(expected, actual);
	
}

@When("^I Check the fields displayed in the view Manufacturer Contracts screen$")
public void i_Check_the_fields_displayed_in_the_view_Manufacturer_Contracts_screen() throws Throwable {
	waitForUrlContains("ViewManufactureContacts");
	
   logger.info("Step: I Check the fields displayed in the view Manufacturer Contracts screen");
   Assert.assertEquals(CommonMethods.waitForElement(By.xpath(Manufaturer_DD)).isDisplayed(),"Manufacturer dropdown not displayed");

   Assert.assertEquals(driver.findElement(By.xpath(DateReceived)).isDisplayed(),"Date Received dropdown not displayed");

   Assert.assertEquals(driver.findElement(By.xpath(Name)).isDisplayed(),"Name dropdown not displayed");
   
}

@When("^Select the Manufatcure dropdown value and perform a search$")
public void select_the_Manufatcure_dropdown_value_and_perform_a_search() throws Throwable {
  
}

@Then("^The results should be displayed as per the selected criteria\\.$")
public void the_results_should_be_displayed_as_per_the_selected_criteria() throws Throwable {
   
}

@Then("^Select the date received and perform the search\\.$")
public void select_the_date_received_and_perform_the_search() throws Throwable {
    
}

@Then("^Select the name and perform the search\\.$")
public void select_the_name_and_perform_the_search() throws Throwable {
   
}
}
