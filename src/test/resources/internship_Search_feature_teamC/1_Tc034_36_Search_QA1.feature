
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

@Tc_35 @Validate_Searching_for_a_product_by_category 
Scenario: 35_Validate " Searching for a product by category "
Given Navigate to the website’s home page.
Then Locate the drop-down menu for product categories.
Then Confirm that the drop-down menu is visible and clickable
 And Click the drop-down menu and ensure that all available categories are displayed
Then Select a specific category
 And In addition to selecting the category, enter a keyword “laptop” in the search box.
And Click the search button
Then confirm that the search results display products that are both relevant to “laptop” and belong to the “Laptops & Notebooks category
Then Confirm that each result shows an image, name, and price


@Tc_36 @Validate_Sorting_the_search_results_by_name,price_or_rating"
Scenario: 36 Validate " Sorting the search results by name, price or rating"
Given Perform a search using either keyword or category search to generate a results page.
Then Locate the “Sort By” drop-down menu on the search results page.
And Verify that the “Sort By” menu is visible.
And Click the drop-down and check for available sorting options Name (A-Z)
And Click the drop-down and check for available sorting options Name (Z-A)
And Click the drop-down and check for available sorting options Price (Low-High)
And Click the drop-down and check for available sorting options Price (High-Low)
And Click the drop-down and check for available sorting options Rating (Highest)
Then Select a sorting option Price (Low-High) from the drop-down "Verify that the search results are updated accordingly.
And Ensure that during and after sorting, each product listing still displays an image, name, and price.

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
