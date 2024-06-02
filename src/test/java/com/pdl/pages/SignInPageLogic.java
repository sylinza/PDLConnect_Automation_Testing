package com.pdl.pages;

import org.openqa.selenium.By;

import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;

public class SignInPageLogic extends CommonMethods {
	
	SignInPage signInPage = new SignInPage();
	
	public void singIn() {
//		signInPage.username.clear();
//		signInPage.username.sendKeys(ConfigurationReader.getProperty("userId"));
//		signInPage.password.clear();
//		signInPage.password.sendKeys(ConfigurationReader.getProperty("password"));
////		logger.info("Login with User Name:  "+ConfigurationReader.getProperty("userId"));
////		logger.info("            Password:  "+ConfigurationReader.getProperty("password"));
//		hover(signInPage.signInTab);
//		signInPage.signInTab.click();
		if(ConfigurationReader.getProperty("UATLogin").equalsIgnoreCase("yes")) {
            waitFor(20);
            
			hover(signInPage.idpDiscoveryUsername);
			signInPage.idpDiscoveryUsername.click();
			signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("userId"));
			
			signInPage.idpDiscoverySubmit.click();
			waitForPageToLoadfor(ELEMENT_WAIT_TIMEOUT_SECONDS);
		 
			//Driver.getDriver().findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
			//*[@id="idp-discovery-submit"]
 
		 
			signInPage.usernameNIPAA.sendKeys(ConfigurationReader.getProperty("password"));
		//Driver.getDriver().findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(ConfigurationReader.getProperty("password"));
			//signInPage.password.sendKeys(ConfigurationReader.getProperty("password"));
	 //verify
			signInPage.VerifyNIPAA.click();
		//Driver.getDriver().findElement(By.xpath("//*[@value=\"Verify\"]")).click();
			
		}else {
		signInPage.idpDiscoveryUsername.clear();
		signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("userId"));
		//signInPage.idpDiscoverySubmit.click();
		waitForPageToLoadfor(10);
		signInPage.password.sendKeys(ConfigurationReader.getProperty("password"));
		
		hover(signInPage.signInTab);
	signInPage.signInTab.click();
	}

	}
}
