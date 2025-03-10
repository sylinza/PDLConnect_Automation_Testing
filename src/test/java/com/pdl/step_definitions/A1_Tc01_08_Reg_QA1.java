package com.pdl.step_definitions;

import com.pdl.pages.Homepage_Quafox;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class A1_Tc01_08_Reg_QA1 {

	Homepage_Quafox homeP = new Homepage_Quafox();

	// Tc_01
	@Given("Navigate to the registration page")
	public void navigate_to_the_registration_page() {
		homeP.user_is_in_homePage();

	}

	@Given("Click on the link")
	public void click_on_the_link() {

	}

	@Then("The link should redirect the user to the registration web page")
	public void the_link_should_redirect_the_user_to_the_registration_web_page() {

	}

	@Then("All the mandatory fields should be indicated with the red asterisk sign")
	public void all_the_mandatory_fields_should_be_indicated_with_the_red_asterisk_sign() {
		homeP.all_madatory_field_indicated_withRed();
	}

	@Then("Click all the required fields to make sure its responsive")
	public void click_all_the_required_fields_to_make_sure_its_responsive() {
		homeP.click_on_madatory_field_indicated_withRed();
	}

	@Then("Click on email field and insert {string}")
	public void click_on_email_field_and_insert(String email) {
		homeP.click_on_email_field("teamaqC35@gmail.com");
	}

	@Then("Click on password field and insert {string}")
	public void click_on_password_field_and_insert(String password) {
		homeP.click_on_password_field("teamC1234@");
	}

	@Then("A text should be displayed if the user has an existing account If you already have an account with us,please login at the login page and a link to the login page")
	public void a_text_should_be_displayed_if_the_user_has_an_existing_account_if_you_already_have_an_account_with_us_please_login_at_the_login_page_and_a_link_to_the_login_page() {
		homeP.existing_account_message();
	}

	@Then("Click on the attached link and it redirect them to the login page")
	public void click_on_the_attached_link_and_it_redirect_them_to_the_login_page() {
		homeP.click_on_the_attached_link_and_it_redirect_to_the_login_page();
	}

//Tc_02
	@Given("Navigate to the registration page using the provided URL")
	public void navigate_to_the_registration_page_using_the_provided_url() {

	}

	@Given("Verify the user link is accessible and clickable")
	public void verify_the_user_link_is_accessible_and_clickable() {

	}

	@When("Clicking on the link it should redirect the user to the registration web page.")
	public void clicking_on_the_link_it_should_redirect_the_user_to_the_registration_web_page() {

	}

	@When("All the mandatory fields should be indicated with the red asterisk sign.")
	public void all_the_mandatory_fields_should_be_indicated_with_the_red_asterisk_sign1() {

	}

	@When("Web page displaying  an error message when the user tries to input invalid credentials.")
	public void web_page_displaying_an_error_message_when_the_user_tries_to_input_invalid_credentials() {
		homeP.error_message_whith_input_invalid_credentials();
	}

	@When("Inserting invalid inputs are not displaying error messages.")
	public void inserting_invalid_inputs_are_not_displaying_error_messages() {

	}

	@Then("web pages are not indicating the mandatory fields with red asterisk sign")
	public void web_pages_are_not_indicating_the_mandatory_fields_with_red_asterisk_sign() {

	}

	@Then("The error message displays for submitting an empty form")
	public void the_error_message_displays_for_submitting_an_empty_form() {
		homeP.the_error_message_for_submitting_an_empty_form();
	}

	@Then("Invalid email format  dispalys an error message")
	public void invalid_email_format_dispalys_an_error_message() {
		homeP.invalid_email_format_displays_an_error_message();
	}

	@Then("Missing password field dispalys an error message")
	public void missing_password_field_dispalys_an_error_message() {

	}

	@Then("Error messages are displayed simultaneously for all invalid fields")
	public void error_messages_are_displayed_simultaneously_for_all_invalid_fields() {

	}

	@Then("Error message displays for password not meeting criteria")
	public void error_message_displays_for_password_not_meeting_criteria() {
		homeP.missing_password_field_displays_an_error_message();
	}

	@Then("Error messages are actionable and clear")
	public void error_messages_are_actionable_and_clear() {

	}

	@Then("User should receive an confirmation email after successful registration")
	public void user_should_receive_an_confirmation_email_after_successful_registration() {

	}

	@Given("the link it should redirect the user to the registration web page")
	public void the_link_it_should_redirect_the_user_to_the_registration_web_page() {

	}

	@Then("Web page displaying  an error message when the user tries to input invalid credentials")
	public void web_page_displaying_an_error_message_when_the_user_tries_to_input_invalid_credentials1() {

	}

	@Then("Inserting invalid inputs are not displaying error messages")
	public void inserting_invalid_inputs_are_not_displaying_error_messages1() {

	}

//TC_03
	@Given("Navigate to the registration page URL")
	public void navigate_to_the_registration_page_url() {

	}

	@Then("all required fields are present \\(First Name, Last Name, Email, Phone,   Password)")
	public void all_required_fields_are_present_first_name_last_name_email_phone_password() {
		homeP.allrequired_fields_are_present_first_name_last_name_email_phone_password();
	}

	@Then("The {string} button is visible and blue.")
	public void the_button_is_visible_and_blue(String CreateAccount) {
		homeP.the_button_is_visible_and_blue(CreateAccount);
	}

	@Then("The {string} button is positioned at the bottom right of the form")
	public void the_button_is_positioned_at_the_bottom_right_of_the_form(String CreateAccount) {
		homeP.button_positioned_at_the_bottom_right_of_the_form(CreateAccount);
	}

	@Then("all frequired field labels are correct and clear")
	public void all_frequired_field_labels_are_correct_and_clear() {

	}

	@Then("The form layout is responsive on different devices \\(mobile, tablet, desktop)")
	public void the_form_layout_is_responsive_on_different_devices_mobile_tablet_desktop() {

	}

	@Then("click on email address and  insert {string}")
	public void click_on_email_address_and_insert(String email) {
		homeP.tc3_click_on_email_field("teamaqC35@gmail.com");
	}

	@Then("click on password and insert {string}")
	public void click_on_password_and_insert(String password) {
		homeP.tc3_click_on_password_field("teamC1234@");
	}

	@Then("Click the {string} button")
	public void click_the_button(String CreateAccount) {
		homeP.click_the_button(CreateAccount);
	}

	@Then("After clicking on create account  button OTP is sent after form submission")
	public void after_clicking_on_create_account_button_otp_is_sent_after_form_submission() {

	}

	@Then("OTP is sent to the correct email\\/phone number")
	public void otp_is_sent_to_the_correct_email_phone_number() {

	}

	@Then("Receiiving correct OTP allows registration")
	public void receiiving_correct_otp_allows_registration() {

	}

	@Then("Inserting incorrect OTP shows an error")
	public void inserting_incorrect_otp_shows_an_error() {

	}

	@Then("OTP expires after a set time")
	public void otp_expires_after_a_set_time() {

	}

	@Then("click on resend OTP")
	public void click_on_resend_otp() {

	}

	@Then("Verified users are redirected to the homepage after successful registration")
	public void verified_users_are_redirected_to_the_homepage_after_successful_registration() {

	}

	@Then("Upon successful registration  welcome message appears with the user’s name")
	public void upon_successful_registration_welcome_message_appears_with_the_user_s_name() {

	}

	@Then("Upon successful registration the user can log in immediately after")
	public void upon_successful_registration_the_user_can_log_in_immediately_after() {

	}

	@Then("Upon unsuccessful registration the user not able access restricted pages without logging in")
	public void upon_unsuccessful_registration_the_user_not_able_access_restricted_pages_without_logging_in() {

	}

	// TC04
	@Given("Navigate to the {string} e-commerce website.")
	public void navigate_to_the_e_commerce_website(String string) {

	}

	@Given("Click on link {string} and its accessible and clickable.")
	public void click_on_link_and_its_accessible_and_clickable(String string) {

	}

	@When("i clicking on the link it should redirect the user to the registration web page.")
	public void i_clicking_on_the_link_it_should_redirect_the_user_to_the_registration_web_page() {

	}

	@Then("The static top menu is visible and accessible in every page  “Your Store “ Website.")
	public void the_static_top_menu_is_visible_and_accessible_in_every_page_your_store_website() {
		homeP.the_static_top_menu_is_visible_and_accessible_in_every_page_your_store_website();
	}

	@Then("Locate and click on the \"\"Product Catalog\"\" option in the static top menu")
	public void locate_and_click_on_the_product_catalog_option_in_the_static_top_menu() {
		homeP.locate_and_click_on_the_product_catalog_option_in_the_static_top_menu();
	}

	@When("Upon clicking the static top menu its responsive and usable on desktop and mobile devices.")
	public void upon_clicking_the_static_top_menu_its_responsive_and_usable_on_desktop_and_mobile_devices() {

	}

	@Then("Confirm the {string} page loads successfully.")
	public void confirm_the_page_loads_successfully(String string) {

	}

//TC05
	@Given("The the “product catalog” option is visible and labeled correctly.")
	public void the_the_product_catalog_option_is_visible_and_labeled_correctly() {

	}

	@Then("Click on the product catalog option in the static top menu.")
	public void click_on_the_product_catalog_option_in_the_static_top_menu() {

	}

	@Then("Confirm the product catalog page loads successfully.")
	public void confirm_the_product_catalog_page_loads_successfully() {
		homeP.confirm_the_product_catalog_loads_successfully();

	}

	// TC06
	@Given("Click on the product catalog option in the static top menu to open the catalog.")
	public void click_on_the_product_catalog_option_in_the_static_top_menu_to_open_the_catalog() {

	}

	@Given("The product catalog displays all available products on the website.")
	public void the_product_catalog_displays_all_available_products_on_the_website() {
	}

	@Given("Each product includes accurate details such as name, price, and description.")
	public void each_product_includes_accurate_details_such_as_name_price_and_description() {

	}

	@Then("confirm the catalog is organized with appropriate categories")
	public void confirm_the_catalog_is_organized_with_appropriate_categories() {

	}

	@When("Upon Clicking on a category {string} to confirm it displays only the relevant products")
	public void upon_clicking_on_a_category_to_confirm_it_displays_only_the_relevant_products(String string) {

	}

	@Then("select WHERE price BETWEEN {int} AND {int} to verify that the displayed products match the selected criteria.")
	public void select_where_price_between_and_to_verify_that_the_displayed_products_match_the_selected_criteria(
			Integer int1, Integer int2) {

	}

	@Then("Click on the  search functionality to find a specific product and confirm the results are accurate")
	public void click_on_the_search_functionality_to_find_a_specific_product_and_confirm_the_results_are_accurate() {

	}

	@Then("Access the product catalog on a desktop, mobile device and a tablet to ensure the catalog is responsive and usable across different screen sizes.")
	public void access_the_product_catalog_on_a_desktop_mobile_device_and_a_tablet_to_ensure_the_catalog_is_responsive_and_usable_across_different_screen_sizes() {

	}

	@Then("Navigate back and forth between categories, filters, and search results to confirm smooth navigation without errors or glitches.")
	public void navigate_back_and_forth_between_categories_filters_and_search_results_to_confirm_smooth_navigation_without_errors_or_glitches() {

	}
	// TC07

	@Given("Navigate to registration static header {string}")
	public void navigate_to_registration_static_header(String string) {

	}

	@Given("Scroll down the page to check if the static header remains visible at the top.")
	public void scroll_down_the_page_to_check_if_the_static_header_remains_visible_at_the_top() {

	}

	@Then("Ensure that the header is present on the homepage and other pages.")
	public void ensure_that_the_header_is_present_on_the_homepage_and_other_pages() {

	}

	@Then("Check that the header does not disappear when scrolling down the page.")
	public void check_that_the_header_does_not_disappear_when_scrolling_down_the_page() {

	}
	//08
	@Given("Navigate to the URL link.")
	public void navigate_to_the_url_link() {
	   
	}
	@Then("Locate the currency selector dropdown in the header or relevant section.")
	public void locate_the_currency_selector_dropdown_in_the_header_or_relevant_section() {
	    
	}
	@Then("Click on the currency dropdown to view available options.")
	public void click_on_the_currency_dropdown_to_view_available_options() {
	    
	}
	@Then("Select a different currency \\(e.g., EUR)")
	public void select_a_different_currency_e_g_eur() {
	    
	}
	@Then("Ensure product prices are updated to reflect the selected currency.")
	public void ensure_product_prices_are_updated_to_reflect_the_selected_currency() {
	   
	}
	@Then("Check if the page reloads or updates the content without errors after selecting the currency")
	public void check_if_the_page_reloads_or_updates_the_content_without_errors_after_selecting_the_currency() {
	
	}



}