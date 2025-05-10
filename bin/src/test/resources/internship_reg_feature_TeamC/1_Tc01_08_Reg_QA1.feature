
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