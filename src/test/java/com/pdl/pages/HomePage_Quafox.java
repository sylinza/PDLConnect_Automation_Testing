package com.pdl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.Driver;

import junit.framework.Assert;

public class HomePage_Quafox extends CommonMethods{
	WebDriver driver = Driver.getDriver();
	
	public HomePage_Quafox() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	//elements 
		@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[1]")
		public WebElement link;
	
	
		@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[1]")
		public WebElement loginOption;
	
		@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/h2")  
		public WebElement newCustomerSection;
	
		@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/h2")
		public WebElement existingCustomerSection;
		
		
		@FindBy(xpath = "////*[@id=\"content\"]/div/div[1]/div/a")  
		public WebElement continueButton;
		
		@FindBy(xpath = "//*[@id=\"content\"]/h1")
		public WebElement registrationForm;
		
		@FindBy(xpath = "//*[@id=\"input-email\"]") 
		public WebElement email;
		
		
		@FindBy(xpath = "//*[@id=\"input-password")  
		public WebElement password;
		
	    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")  
	    public WebElement forgottenPasswordLink;
	
		
		
		
	public void verify_Your_Store_homepage_loads_successfully() {
	 String actualTitle = driver.getTitle();
	 String expectedTitle ="Account Login";
	 
	 Assert.assertEquals("verify your store home page loads successfully", expectedTitle,actualTitle);
	 
	}

	
	public void click_the_link_and_its_ccessible_and_clickable() {
	 
	    if (link.isDisplayed() && link.isEnabled()) {
	        link.click();
	    } else {
	        throw new RuntimeException("The link is not accessible or clickable");
	    }
	}
	

	
	public void click_on_the_login_option_from_the_homepage_or_header_menu() {
		
		loginOption.click();
	}

	
	public void verify_that_the_login_page_contains_separate_sections_for_new_customer_and_existing_customer() { 
	
	    if (newCustomerSection.isDisplayed()) {
	        throw new RuntimeException("New Customer section is not visible");
	    }
	   
	    if (existingCustomerSection.isDisplayed()) {
	        throw new RuntimeException("Existing Customer section is not visible");
	    }
	}

	
	
	public void click_the_continue_button_under_the_new_customer_section() {
	    continueButton.click();
	}

	
	
	public void verify_that_the_user_is_redirected_to_the_registration_form() {
	   
	    WebElement registrationForm = driver.findElement(By.xpath("//*[@id=\\\"content\\\"]/h1"));
	    if (registrationForm.isDisplayed()) {
	        throw new RuntimeException("Registration form is not visible");
	    }
	}

	
	
	public void confirm_that_the_registration_form_includes_fields_for_first_name_last_name_email_telephone_password_newsletter_subscription() {
	    // Verify each field is present (replace with appropriate locators)
		Assert.assertTrue(driver.findElement(By.id("input-firstname")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("input-lastname")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("input-email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("input-telephone")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("input-password")).isDisplayed());
	}  
	
	
	public void fill_out_the_form_with_valid_input_in_all_fields() { 
		
		 String actualTitle = driver.getTitle();
		 String expectedTitle ="valid_input ";
		 
		 Assert.assertEquals("fill_out_the_form_with_valid_input_in_all_fields", expectedTitle,actualTitle);
	      
	}
	
	
	public void agree_to_the_privacy_policy_by_checking_the_respective_box() { 
		String actualTitle = driver.getTitle();
		 String expectedTitle ="The checkbox is present and selectable";
		 
		 Assert.assertEquals("agree_to_the_privacy_policy_by_checking_the_respective_box", expectedTitle,actualTitle);
	   
	}

	
	
	public void click_the_continue_button_to_submit_the_form() {
		  WebElement continue_button = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
		  continue_button.click();
	}

	
	
	public void verify_that_the_account_is_successfully_created_and_the_user_is_redirected_to_the_appropriate_page() {  
	    
	}

	public void check_that_a_confirmation_email_is_sent_to_the_provided_email_address() { 
	    // Implementation here
	}
//Tc_32

	public void navigate_to_the_website(String url) {
	
	    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
  
	    driver.get(url);
	}
	
     public void confirm_the_returning_customer_section_is_present_on_the_login_page() {
   
    WebElement returningCustomerSection = driver.findElement(By.id("returning-customer-section"));
    assert(returningCustomerSection.isDisplayed());
}
     
    
     public void enter_a_valid_email_and_password_in_the_returning_customer_section() {
       
         WebElement emailField = driver.findElement(By.id("email"));
         WebElement passwordField = driver.findElement(By.id("password"));
         emailField.sendKeys("validemail@example.com");
         passwordField.sendKeys("validpassword");
     }
     
     
     public void click_the_login_button() {
       
         WebElement loginButton = driver.findElement(By.id("login-button"));
         loginButton.click();
     }
     
    
     public void verify_the_account_options_available() {
       
         WebElement accountOptions = driver.findElement(By.id("account-options")); 
         assert(accountOptions.isDisplayed());
     }
    
     public void verify_the_returning_customer_section_is_present_on_the_login_page() {
        
         WebElement returningCustomerSection = driver.findElement(By.id("returning-customer-section"));
         assert(returningCustomerSection.isDisplayed());
     }
     public void enter_an_invalid_email_or_incorrect_password() {
    	    
    	    WebElement emailField = driver.findElement(By.id("email"));
    	    WebElement passwordField = driver.findElement(By.id("password"));

    	    emailField.sendKeys("invalidemail@example.com");
    	    passwordField.sendKeys("incorrectpassword");
    	}
     public void click_the_login_button(String buttonId) {
    	  
    	    WebElement button = driver.findElement(By.id(buttonId));
    	    button.click();
    	}
     public void verify_the_error_message_appears_in_red_below_the_login_form() {
    	  
    	    WebElement errorMessage = driver.findElement(By.id("error-message"));

    	    assert(errorMessage.isDisplayed());
    	    assert(errorMessage.getCssValue("color").equals("red"));
     }
     public void confirm_the_email_and_password_fields_remain_populated() {
    	
    	    WebElement emailField = driver.findElement(By.id("email"));
    	    WebElement passwordField = driver.findElement(By.id("password"));

    	    assert(emailField.getAttribute("value").equals("invalidemail@example.com"));
    	    assert(passwordField.getAttribute("value").equals("incorrectpassword"));
    	}
     public void click_on_the_forgotten_password_link_under_the_returning_customer_section() {
    	   
    	    WebElement forgottenPasswordLink = driver.findElement(By.id("forgot-password-link"));
    	    forgottenPasswordLink.click();
    	}
     public void verify_the_password_reset_form_contains_an_email_input_field() {
    	   
    	    WebElement emailInputField = driver.findElement(By.id("email-reset-input"));
    	    assert(emailInputField.isDisplayed());
    	}
     
     public void enter_a_registered_email_address_in_the_password_reset_form() {
    	 
    	    WebElement emailInputField = driver.findElement(By.id("email-reset-input"));
    	    emailInputField.sendKeys("registeredemail@example.com");
    	}
     public void click_on_the_continue_button() {
    	   
    	    WebElement continueButton = driver.findElement(By.id("continue-button"));
    	    continueButton.click();
    	}
     public void check_the_registered_email_inbox() {
    	    
    	    System.out.println("Check the registered email inbox for the reset link.");
    	}
     
     
   
     public void ensure_the_reset_link_redirects_users_to_a_secure_password_reset_page() {
         // Assuming you have a way to get the reset link from the email
         String resetLink = "https://tutorialsninja.com/demo/index.php?route=account/forgotten"; 
         driver.get(resetLink);
         String currentUrl = driver.getCurrentUrl();
         Assert.assertTrue("The URL is not secure", currentUrl.startsWith("https://"));
         Assert.assertTrue("The URL does not contain reset-password", currentUrl.contains("reset-password"));
         
         
     }
     
     
     public void validate_the_ability_to_set_a_new_password_successfully() {
    	    
    	    WebElement newPasswordField = driver.findElement(By.id("new-password"));
    	    WebElement confirmPasswordField = driver.findElement(By.id("confirm-password"));
    	    WebElement submitButton = driver.findElement(By.id("submit-new-password"));

    	    newPasswordField.sendKeys("newpassword123");
    	    confirmPasswordField.sendKeys("newpassword123");
    	    submitButton.click();

    	    // Verify that the password reset was successful (this will depend on the specific application logic)
    	    WebElement successMessage = driver.findElement(By.id("reset-success-message"));
    	    assert(successMessage.isDisplayed());
    	}
  

 }
	
	

