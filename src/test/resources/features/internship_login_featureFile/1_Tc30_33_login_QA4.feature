
@login
Feature: login_test_cases
  I want to use this template for my feature file

  @Tc_30 @Validate_Successful_Registration
  Scenario:30_ validate successful registration
    Given Navigate to the ""Your Store"" website
    And Click the link and its ccessible and clickable
    When Click on the ""Login"" option from the homepage or header menu
    And Verify that the login page contains separate sections for New Customer and Existing Customer
    And Click the ""Continue"" button under the New Customer section
    Then  Verify that the user is redirected to the registration form
    And  Confirm that the registration form includes fields for: First Name, Last Name, Email, Telephone, Password, Newsletter Subscription
    And  Fill out the form with valid input in all fields
    Then  Agree to the privacy policy by checking the respective box  
    And  Click the ""Continue"" button to submit the form.
    And  Verify that the account is successfully created and the user is redirected to the appropriate page.
    Then Check that a confirmation email is sent to the provided email address
    
  @Tc_31 @Validate_successful_Login
  Scenario Outline:31_ Validate successful Login
    Given Navigate to the ""Your Store"" website
    When Click on the ""Login"" option from the homepage or header menu
    And Confirm the ""Returning Customer"" section is present on the login page
    Then Enter a valid email and password in the ""Returning Customer"" section
    And Click the ""Login"" button
    Then Verify the account options available
    
   @Tc_32 @Validate_Unsuccessful_Login
   Scenario Outline:32_ Validate unsuccessful Login 
     Given Navigate to the ""Your Store"" website
     When Click on the ""Login"" option from the homepage or header menu      
     And  Verify the ""Returning Customer"" section is present on the login page      
     Then Enter an invalid email or incorrect password
     And Click the "Login" button
     Then Verify the error message appears in red below the login form      
     And Confirm the email and password fields remain populated      


    @Tc_33 @Validate_Requesting_a_password_reset_link_for_returning_customer 
    Scenario Outline:33_Validate Requesting a password reset link for returning customer
      Given Navigate to the ""Your Store"" website
      When Click on the ""Login"" option from the homepage or header menu
      And Click on the ""Forgotten Password"" link under the ""Returning Customer"" section
      Then Verify the password reset form contains an email input field
      And Enter a registered email address in the password reset form
      Then Click on the ""Continue"" button
      And Check the registered email inbox.	
      Then Ensure the reset link redirects users to a secure password reset page
      And Validate the ability to set a new password successfully