@Registration
Feature: Registration_test_cases
  I want to use this template for my feature file

  @TC-11 @Validate_Managing_My_Wishlist
    Scenario:11 Validate Managing My Wishlist
   Given Navigate to the  managing My wish list URL
   Then Log in to the account
   When  Click on "My Wishlist"
   Then Add items to the wishlist
   Then  Remove items from the wishlist
   Then  Verify item count updates
  
    
     
     
       @TC-12 @Validate_Accessing_My_Shopping_Cart
    Scenario:12 Validate Accessing My Shopping Cart
   Given Log in to the account
   Then Click on the "Shopping Cart" icon
   When Verify items are displayed in the cart 
   Then Ensure the cart icon reflects the correct item count
   Then  Check that the user can proceed to checkout from the cart page
      