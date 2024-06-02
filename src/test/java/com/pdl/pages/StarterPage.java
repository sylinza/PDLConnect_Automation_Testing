package com.pdl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pdl.utilities.Driver;

public class StarterPage {
	
	public StarterPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id="okta-signin-username")
    public WebElement userName;
	
	
	
	
}
