package com.pdl.utilities;

import org.openqa.selenium.WebElement;

public class sendKey {
	
 public static void SendKey(WebElement web, String fromExcel) {
	 if(!fromExcel.isEmpty()|| !fromExcel.equalsIgnoreCase("n/a")) {
		web.sendKeys(fromExcel);
		
	 }
		
	 }
	 
 }

