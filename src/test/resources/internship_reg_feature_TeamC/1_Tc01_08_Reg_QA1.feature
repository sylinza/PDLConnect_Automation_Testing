
@Regestration
Feature: Registration Mandatory Field01
  I want to use this template for my feature file

 @Tc_01 @Validate_User_accesses_the_registration_web_page
  Scenario: 01_Validate User accesses the registration web page
    Given Navigate to the registration page
    And Click on the link
    Then The link should redirect the user to the registration web page
    And All the mandatory fields should be indicated with the red asterisk sign
    And Click all the required fields to make sure its responsive 
    Then Click on email field and insert "teamaqC35@gmail.com"
    Then Click on password field and insert "teamC1234@"
    And A text should be displayed if the user has an existing account If you already have an account with us,please login at the login page and a link to the login page
    And Click on the attached link and it redirect them to the login page
   
   @Tc_02  @Validate_User_fills_out_mandatory_fields_incorrectly
  Scenario: 02_Validate User fills out mandatory fields incorrectly
    Given Navigate to the registration page using the provided URL
    And Verify the user link is accessible and clickable
    And the link it should redirect the user to the registration web page
    And All the mandatory fields should be indicated with the red asterisk sign
    Then Web page displaying  an error message when the user tries to input invalid credentials 
    And Inserting invalid inputs are not displaying error messages
    Then web pages are not indicating the mandatory fields with red asterisk sign
    And The error message displays for submitting an empty form
    And Invalid email format  dispalys an error message  
    And Missing password field dispalys an error message 
    And Error messages are displayed simultaneously for all invalid fields
    And Error message displays for password not meeting criteria
    And Error messages are actionable and clear
    Then User should receive an confirmation email after successful registration
 
 
  @Tc_03 @Validate_Userregisters_for_an_account
   Scenario: 03_Validate User registers for an account
   Given Navigate to the registration page URL
   Then all required fields are present (First Name, Last Name, Email, Phone, Password)
   And The "Create Account" button is visible and blue.
   And The "Create Account" button is positioned at the bottom right of the form
   And all frequired field labels are correct and clear
   And The form layout is responsive on different devices (mobile, tablet, desktop)
   Then click on email address and  insert 'teamaqC35@gmail.com'
   Then click on password and insert "teamC1234@"
   And Click the "Create Account" button
   Then After clicking on create account  button OTP is sent after form submission
   Then OTP is sent to the correct email/phone number
   And Receiiving correct OTP allows registration
   And Inserting incorrect OTP shows an error
   Then OTP expires after a set time
   Then click on resend OTP 
   And Verified users are redirected to the homepage after successful registration
   And Upon successful registration  welcome message appears with the user’s name
   And Upon successful registration the user can log in immediately after 
   And Upon unsuccessful registration the user not able access restricted pages without logging in
   
   @Tc_04 @Validate_View_static_top_menu 
  Scenario: 04_ Validate View static top menu 
  Given Navigate to the "Your Store" e-commerce website.
	And Click on link "https://tutorialsninja.com/" and its accessible and clickable. 
  When i clicking on the link it should redirect the user to the registration web page.
  Then The static top menu is visible and accessible in every page  “Your Store “ Website.  
  Then Locate and click on the ""Product Catalog"" option in the static top menu
  When Upon clicking the static top menu its responsive and usable on desktop and mobile devices.
  Then Confirm the "Product Catalog" page loads successfully.


  @Tc_05 @Validate_Access_product_catalog 
  Scenario: 05_Validate " Validate Access product catalog "
  Given Navigate to the "Your Store" e-commerce website.
  And The the “product catalog” option is visible and labeled correctly. 
  Then Click on the product catalog option in the static top menu.
  And Confirm the product catalog page loads successfully.

   @Tc_06 @Validate_Browse_through_product_catalog 
Scenario: 06_Validate " Validate Browse through product catalog "
Given Navigate to the "Your Store" e-commerce website.
And Click on the product catalog option in the static top menu to open the catalog.
And The product catalog displays all available products on the website.
And  Each product includes accurate details such as name, price, and description.
Then confirm the catalog is organized with appropriate categories
When Upon Clicking on a category "laptops" to confirm it displays only the relevant products
Then select WHERE price BETWEEN 500 AND 1000 to verify that the displayed products match the selected criteria.
And Click on the  search functionality to find a specific product and confirm the results are accurate
Then Access the product catalog on a desktop, mobile device and a tablet to ensure the catalog is responsive and usable across different screen sizes.
And Navigate back and forth between categories, filters, and search results to confirm smooth navigation without errors or glitches.
   
   @Tc_07 @Validate_Static_Header_Visibility  
Scenario: 07_Validate Static Header Visibility  
Given Navigate to registration static header "https://tutorialsninja.com/"  
And Scroll down the page to check if the static header remains visible at the top.
Then Ensure that the header is present on the homepage and other pages.
And Check that the header does not disappear when scrolling down the page.
Then Ensure that the header elements (logo, menu, etc.) are visible and correctly aligned 

 @Tc_08 @Validate_Switching_Currency
 Scenario: 08_Validate Switching Currency
 Given Navigate to the URL link.
Then Locate the currency selector dropdown in the header or relevant section.
And Click on the currency dropdown to view available options.
 And Select a different currency (e.g., EUR)
 Then Ensure product prices are updated to reflect the selected currency. 
And  Check if the page reloads or updates the content without errors after selecting the currency