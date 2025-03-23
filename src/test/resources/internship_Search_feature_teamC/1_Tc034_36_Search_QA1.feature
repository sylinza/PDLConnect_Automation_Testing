
@Search_fonctionality
Feature: Searching for a product by keyword
  I want to use this template for my feature file

  @Tc_34  @Validate_Searching_for_a_product_by_keyword 
  Scenario: 34_Validate " Searching for a product by keyword "
Given Navigate to the website’s home page.
Then Locate the search box
Then Enter a text string “laptop” in the search box
And Verify that the search box accepts the text input
Then Enter a text string with leading and trailing spaces
And Click the search button.
Then Confirm that clicking the search button initiates a search
When clicking on the search results page loads.
Then Confirm that the search results display relevant products "Laptop"
And Check that each product result includes an image, name, and price


  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
