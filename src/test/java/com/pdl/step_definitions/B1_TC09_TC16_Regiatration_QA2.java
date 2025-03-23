package com.pdl.step_definitions;

import com.pdl.pages.B_HomePage_Quafox;
import com.pdl.pages.Homepage_Quafox;

import io.cucumber.java.en.*;

public class B1_TC09_TC16_Regiatration_QA2 {
	B_HomePage_Quafox homeP=new B_HomePage_Quafox();
	
	
	
	

	
	@Given("Navigate to the  managing My wish list URL")
	public void navigate_to_the_managing_my_wish_list_url() {
	    homeP.verify_user_is_On_Homepage();
	}
	@Then("Log in to the account")
	public void log_in_to_the_account() {
	 homeP.log_in_to_the_account();

	}
	@When("Click on {string}")
	public void click_on(String string) {
	   homeP.click_on(string);
	}
	@Then("Add items to the wishlist")
	public void add_items_to_the_wishlist() {
	  homeP.add_items_to_the_wishlist(); 
	}
	@Then("Remove items from the wishlist")
	public void remove_items_from_the_wishlist() {
	  homeP.remove_items_from_the_wishlist(); 
	}
	@Then("Verify item count updates")
	public void verify_item_count_updates() {
	    homeP.verify_item_count_updates();
	}



	
	
	
}















