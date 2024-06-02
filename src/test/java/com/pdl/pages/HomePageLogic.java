package com.pdl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePageLogic {
	
	
public Select dropDownOption(WebElement dropdown, String optionName) {
		
		Select select = new Select(dropdown);

		select.selectByVisibleText(optionName);;
		return select;
	}

}
