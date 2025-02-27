package com.pdl.step_definitions;


import com.pdl.pages.HomePage_Quafox;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class A1_Tc30_33_login_QA4 {
	
	HomePage_Quafox homeP= new HomePage_Quafox();
	

@Given("Navigate to the \"\"Your Store\"\" website")
public void navigate_to_the_your_store_website() {
  
	homeP.verify_Your_Store_homepage_loads_successfully();

	
}
@Given("Click the link and its ccessible and clickable")
public void click_the_link_and_its_ccessible_and_clickable() { 
}
@When("Click on the \"\"Login\"\" option from the homepage or header menu")
public void click_on_the_login_option_from_the_homepage_or_header_menu() {
}
@When("Verify that the login page contains separate sections for New Customer and Existing Customer")
public void verify_that_the_login_page_contains_separate_sections_for_new_customer_and_existing_customer() { 
}
@When("Click the \"\"Continue\"\" button under the New Customer section")
public void click_the_continue_button_under_the_new_customer_section() {   
}
@Then("Verify that the user is redirected to the registration form")
public void verify_that_the_user_is_redirected_to_the_registration_form() {
}
@Then("Confirm that the registration form includes fields for: First Name, Last Name, Email, Telephone, Password, Newsletter Subscription")
public void confirm_that_the_registration_form_includes_fields_for_first_name_last_name_email_telephone_password_newsletter_subscription() {
}
@Then("Fill out the form with valid input in all fields")
public void fill_out_the_form_with_valid_input_in_all_fields() { 
}
@Then("Agree to the privacy policy by checking the respective box")
public void agree_to_the_privacy_policy_by_checking_the_respective_box() { 
}
@Then("Click the \"\"Continue\"\" button to submit the form.")
public void click_the_continue_button_to_submit_the_form() { 
}
@Then("Verify that the account is successfully created and the user is redirected to the appropriate page.")
public void verify_that_the_account_is_successfully_created_and_the_user_is_redirected_to_the_appropriate_page() {  
}
@Then("Check that a confirmation email is sent to the provided email address")
public void check_that_a_confirmation_email_is_sent_to_the_provided_email_address() { 
}



@Given("Navigate to the {string} website")
public void navigate_to_the_website(String string) {   
}
@When("Confirm the \"\"Returning Customer\"\" section is present on the login page")
public void confirm_the_returning_customer_section_is_present_on_the_login_page() {  
}
@Then("Enter a valid email and password in the \"\"Returning Customer\"\" section")
public void enter_a_valid_email_and_password_in_the_returning_customer_section() {
}
@Then("Click the \"\"Login\"\" button")
public void click_the_login_button() {
}
@Then("Verify the account options available")
public void verify_the_account_options_available() {
   
}




@When("Verify the \"\"Returning Customer\"\" section is present on the login page")
public void verify_the_returning_customer_section_is_present_on_the_login_page() {
   
}
@Then("Enter an invalid email or incorrect password")
public void enter_an_invalid_email_or_incorrect_password() {
  
}
@Then("Click the {string} button")
public void click_the_button(String string) {
   
}
@Then("Verify the error message appears in red below the login form")
public void verify_the_error_message_appears_in_red_below_the_login_form() {
   
}
@Then("Confirm the email and password fields remain populated")
public void confirm_the_email_and_password_fields_remain_populated() {
  
}




@When("Click on the \"\"Forgotten Password\"\" link under the \"\"Returning Customer\"\" section")
public void click_on_the_forgotten_password_link_under_the_returning_customer_section() {
    
}
@Then("Verify the password reset form contains an email input field")
public void verify_the_password_reset_form_contains_an_email_input_field() {
    
}
@Then("Enter a registered email address in the password reset form")
public void enter_a_registered_email_address_in_the_password_reset_form() {
    
}


@Then("Click on the \"\"Continue\"\" button")
public void click_on_the_continue_button() {
    
}
@Then("Check the registered email inbox.")
public void check_the_registered_email_inbox() {
  
}
@Then("Ensure the reset link redirects users to a secure password reset page")
public void ensure_the_reset_link_redirects_users_to_a_secure_password_reset_page() {
   
}
@Then("Validate the ability to set a new password successfully")
public void validate_the_ability_to_set_a_new_password_successfully() {
  
}

    

}






