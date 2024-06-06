package com.pdl.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;
import com.pdl.utilities.SftAssert;

	

	public class SignInPage extends CommonMethods {
		
		public static Logger logger = LogManager.getLogger(SignInPage.class);
	
		
		
		int x=10; // demo commit test
		
		
		public SignInPage() {
			PageFactory.initElements(Driver.getDriver(), this);
		}
		
		@FindBy(id="okta-signin-username")
		public WebElement username;
		
		@FindBy(id="input29")
		public WebElement usernameNIPAA;
		
		@FindBy(xpath="//*[@value=\"Verify\"]")
		public WebElement VerifyNIPAA;
	
		
		@FindBy(id="idp-discovery-username")
		public WebElement idpDiscoveryUsername;
		//*[@id="form19"]//div[2]/span
		//*[@id=\"idp-discovery-username\"]
	   //*[@id="idp-discovery-username"]
		
	//	@FindBy(id="//*[@id=\"form19\"]/div[1]/div[2]//div[2]/span")
	//	public WebElement idpDiscoveryUsername;
		
		
		
		@FindBy(id="idp-discovery-submit")
		public WebElement idpDiscoverySubmit;
		
		
		
		@FindBy(id="okta-signin-password")
		public WebElement password;
	
		@FindBy(id="okta-signin-submit")
		public WebElement signInTab;
		
		
		public void singIn() {
			username.clear();
			username.sendKeys(ConfigurationReader.getProperty("userId"));
			password.clear();
			password.sendKeys(ConfigurationReader.getProperty("password"));
			signInTab.click();
		}
		
		
		
		
		
}
