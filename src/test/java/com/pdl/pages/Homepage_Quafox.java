package com.pdl.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.Driver;

public class Homepage_Quafox extends CommonMethods {
	WebDriver driver = Driver.getDriver();

	public Homepage_Quafox() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	

	public WebElement home;

	public void user_is_in_homePage() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Register Account";
		assertEquals(actualTitle, expectedTitle, "Register Account ");

	}
//Tc01
	// Verify that mandatory fields have the red asterisk sign
	public void all_madatory_field_indicated_withRed() {
		List<WebElement> mandatoryFields = driver.findElements(By.xpath("//label[contains(text(), '*')]"));
		for (WebElement field : mandatoryFields) {
			assertTrue(field.isDisplayed());
		}

	}
	// Click all the required fields and verify they are responsive
	public void click_on_madatory_field_indicated_withRed() {
		List<WebElement> requiredFields = driver.findElements(By.xpath("//label[contains(text(), '*')]"));
		for (WebElement field : requiredFields) {
			assertTrue(field.isDisplayed());

		}
	}
		public void click_on_email_field(String email) {
		    // Click on the email field and insert the provided email
		    WebElement emailField = driver.findElement(By.id("input-email")); // Replace with actual ID
		    emailField.click();
		    emailField.sendKeys("teamaqC35@gmail.com");
	}
		public void click_on_password_field(String password) {
		    // Click on the password field and insert the provided password
		    WebElement passwordField = driver.findElement(By.id("input-password")); // Replace with actual ID
		    passwordField.click();
		    passwordField.sendKeys("teamC1234@");
		}

public void existing_account_message() {
		// Verify the existence of the text and link for existing account users
	    WebElement existingAccountText = driver.findElement(By.xpath("//*[@id=\"content\"]/p")); // Replace with actual ID
	    assertTrue(existingAccountText.isDisplayed());
	    WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"content\"]/p/a")); // Replace with actual ID
	    assertTrue(loginLink.isDisplayed());
}
public void click_on_the_attached_link_and_it_redirect_to_the_login_page() {
    // Click on the login link and verify redirection to the login page
    WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"content\"]/p/a"));; // Replace with actual ID
    loginLink.click();
    String currentUrl = driver.getCurrentUrl();
    assertEquals("https://tutorialsninja.com/demo/index.php?route=account/login", currentUrl); // Replace with actual URL
}
//TC02
public void error_message_whith_input_invalid_credentials() {
    // Implement logic to check for error message on invalid credentials
    WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")); // Replace with actual ID
    assertTrue(errorMessage.isDisplayed());
    assertEquals("Warning: You must agree to the Privacy Policy!", errorMessage.getText());
}


public void the_error_message_for_submitting_an_empty_form() {
    // Implement logic to check error message for empty form submission
    WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")); // Replace with actual ID
    assertTrue(errorMessage.isDisplayed());
    assertEquals("Warning: You must agree to the Privacy Policy!", errorMessage.getText());
}


public void invalid_email_format_displays_an_error_message() {
    // Implement logic to check error message for invalid email format
    WebElement emailField = driver.findElement(By.id("input-email")); // Replace with actual ID
    emailField.sendKeys("invalidemail");
    WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")); // Replace with actual ID
    assertTrue(errorMessage.isDisplayed());
    assertEquals("E-Mail Address does not appear to be valid!", errorMessage.getText());
}


public void missing_password_field_displays_an_error_message() {
    // Implement logic to check error message for missing password
    WebElement passwordField = driver.findElement(By.id("input-password")); // Replace with actual ID
    passwordField.clear();
    WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")); // Replace with actual ID
    assertTrue(errorMessage.isDisplayed());
    assertEquals("Password must be between 4 and 20 characters!", errorMessage.getText());
}
            //Tc03

public void allrequired_fields_are_present_first_name_last_name_email_phone_password() {
Assert.assertTrue(driver.findElement(By.id("input-firstname")).isDisplayed());
Assert.assertTrue(driver.findElement(By.id("input-lastname")).isDisplayed());
Assert.assertTrue(driver.findElement(By.id("input-email")).isDisplayed());
Assert.assertTrue(driver.findElement(By.id("input-telephone")).isDisplayed());
Assert.assertTrue(driver.findElement(By.id("input-password")).isDisplayed());
}
public void the_button_is_visible_and_blue(String CreateAccount) {
    WebElement button = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
    Assert.assertTrue(button.isDisplayed());
    Assert.assertEquals("blue", button.getCssValue("color"));
}
public void button_positioned_at_the_bottom_right_of_the_form(String CreateAccount ) {
    WebElement button = driver.findElement(By.xpath("//*[@id=\\\"content\\\"]/form/div/div/input[2]"));
    Assert.assertTrue(button.isDisplayed());
}
public void tc3_click_on_email_field(String email) {
    // Click on the email field and insert the provided email
    WebElement emailField = driver.findElement(By.id("input-email")); // Replace with actual ID
    emailField.click();
    emailField.sendKeys("teamaqC35@gmail.com");
}
public void tc3_click_on_password_field(String password) {
    // Click on the password field and insert the provided password
    WebElement passwordField = driver.findElement(By.id("input-password")); // Replace with actual ID
    passwordField.click();
    passwordField.sendKeys("teamC1234@");
}
public void click_the_button(String CreateAccount) {
    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
}
public void the_static_top_menu_is_visible_and_accessible_in_every_page_your_store_website() {
    WebElement topMenu = driver.findElement(By.xpath("//*[@id=\"top\"]")); // Replace with the actual ID of the top menu
    Assert.assertTrue(topMenu.isDisplayed() && topMenu.isEnabled());
}
public void locate_and_click_on_the_product_catalog_option_in_the_static_top_menu() {
    WebElement productCatalog = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]")); // Replace with actual text
    Assert.assertTrue(productCatalog.isDisplayed() && productCatalog.isEnabled());
    productCatalog.click();
}
//TC05
public void confirm_the_product_catalog_loads_successfully() {
    String expectedTitle = "Product Catalog - Your Store"; // Replace with the expected page title
    String actualTitle = driver.getTitle();
    Assert.assertEquals("Product Catalog page did not load successfully", expectedTitle, actualTitle);
}

}
