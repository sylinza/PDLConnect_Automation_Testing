package com.pdl.step_definitions;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pdl.pages.HomePage;
import com.pdl.pages.HomePageLogic;
import com.pdl.pages.SignInPage;
import com.pdl.pages.SignInPageLogic;
import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.DBUtil;
import com.pdl.utilities.Driver;
import com.pdl.utilities.ExcelUtil;
import com.pdl.utilities.PrintStreamUtil;

import com.google.common.base.CharMatcher;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

public class LoginStepDef extends CommonMethods  {
	
	WebDriver driver=Driver.getDriver();
	public static final Logger logger = LogManager.getLogger(LoginStepDef.class);


	
	BufferedImage image;
	String clientName = "";
	String clientState = "";
	String successTest = "";
    String businessLineFromConfig, muduleListFromConfig, productLineFromConfig, clientContractFromConfig, programFromConfig;
    String fromYearQtrFromConfig, toYearQtrFromConfig,operatorNameFromConfig, betweenFirstValueFromConfig, betweenSectondValueFromConfig;
    SignInPage signInPage = new SignInPage();
	HomePage homePage = new HomePage();
	HomePageLogic homePageLogic = new HomePageLogic();
	SignInPageLogic signInPageLogic = new SignInPageLogic();

	//ExcelUtil excelUtil = new ExcelUtil(ConfigurationReader.getProperty("pat"), "Client Set Up");

	@Given("user is on home page")
	public void user_is_on_home_page() {
       
		homePage.verifyLandingOnHomepage();
	
;

		String urlFromConfigFile = ConfigurationReader.getProperty("url");

		logger.info("url From ConfigFile:  " + urlFromConfigFile);

		if (urlFromConfigFile.contains("primetherapeutics")) {

		} else {

			signInPageLogic.singIn();

		}
	}
	
	
	
	@When("^user login$")
	public void user_login() throws Throwable {
		String homePage=Driver.getDriver().findElement(By.xpath("//*[@id=\"masthead\"]//div[2]/p/a[1]")).getText().trim();
		logger.info("Page title after login: "+homePage);   
	}
	

	@When("user login with valid credits userName passWord")
	public void user_login_with_valid_credits_userName_passWord() {
//*		
		//signInPageLogic.singIn();
		logger.info("Page title: "+Driver.getDriver().getTitle());
	}
	
	@When("^user enter credentials on requested fields$")
	public void user_enter_credentials_on_requested_fields() throws Throwable {
		//signInPageLogic.singIn();
	}
	
	@When("^TEMP user login with valid credits userName passWord$")
	public void temp_user_login_with_valid_credits_userName_passWord() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitForPageToLoadfor(20);
	    Driver.getDriver().findElement(By.xpath("//*[@id=\"idp-discovery-username\"]")).click();
	    Driver.getDriver().findElement(By.xpath("//*[@id=\"idp-discovery-username\"]")).sendKeys(ConfigurationReader.getProperty("userId"));
	    //"petrosjanatwifordg@magellanhealth.com"
	  //*[@id="idp-discovery-submit"]
	    Driver.getDriver().findElement(By.xpath("//*[@id=\"idp-discovery-submit\"]")).click();
	    waitForPageToLoadfor(20);
		Driver.getDriver().findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		waitForPageToLoadfor(20);
	   Driver.getDriver().findElement(By.xpath("//*[@id=\"input71\"]")).sendKeys(ConfigurationReader.getProperty("password"));
	   Driver.getDriver().findElement(By.xpath("//*[@id=\"form65\"]/div[2]/input")).click();
	}
	
	
	@Given("^user is on \"([^\"]*)\" home page$")
	public void user_is_on_home_page(String homePageTitle) throws Throwable {
		waitForPageToLoadfor(50);
		
		logger.info("Page Title is " + Driver.getDriver().getTitle());
		// Assert.assertEquals(Driver.getDriver().getTitle().trim(), homePageTitle);
		

	}
	@When("^user login with \"([^\"]*)\" valid credentials to Mrx Rebate application$")
	public void user_login_with_valid_credentials_to_Mrx_Rebate_application(String userRole) throws Throwable {

		switch (userRole) {
		case "Business Analyst":

			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("BusAnyst"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("BusAnyst"));
			}

			signInPage.password.sendKeys(ConfigurationReader.getProperty("BusAnystPassWord"));

			break;
		case "Contract Analyst":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("ContAnyst"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("ContAnyst"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("ContAnystPassWord"));
			break;
		case "Data Entry Specialist":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("DataSplist"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("DataSplist"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("DataSplistPassWord"));
			break;

		case "Operations Admin":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("OpsAdmin"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("OpsAdmin"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("OpsAdminPassWord"));
			break;

		case "Rebate Analyst":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("RebAnyst"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("RebAnyst"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("RebAnystPassWord"));
			break;

		case "Rebate Pharmacist":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("RebPhar"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("RebPhar"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("RebPharPassWord"));
			break;

		case "Rebate Analyst - External":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("RebAnystExt"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("RebAnystExt"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("RebAnystExtPassWord"));
			break;

		case "Pharmacy Analyst - External":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("PharAnystExt"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("PharAnystExt"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("PharAnystExtPassWord"));
			break;

		case "Business Analyst - External":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("BusAnystExt"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("BusAnystExt"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("BusAnystExtPassWord"));
			break;

		case "Contracting - External":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("ContractingExt"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("ContractingExt"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("ContractingExtPassWord"));
			break;

		case "Medical Supply - External":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("MedSuppyExt"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("MedSuppyExt"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("MedSuppyExtPassWord"));
			break;

		case "Manufacturer- External-User1":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("Mfr1"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("Mfr1"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("Mfr1PassWord"));
			break;

		case "Manufacturer- External-User2":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("Mfr2"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("Mfr2"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("Mfr2PassWord"));
			break;

		case "Manufacturer- External-User3":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("Mfr3"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("Mfr3"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("Mfr3PassWord"));
			break;
//	            default: 
//	                     break;
		case "Manufacturer-UAC-User1":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("mrxmfruacone"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("mrxmfruacone"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("mrxmfruaconePassWord"));
			break;
//	            default: 
//	                     break;
		case "Manufacturer-UAC-User2":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("mfruactwo"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("mfruactwo"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("mfruactwoPassWord"));
			break;
			
		case "Manufacturer-UAC-User3":
			try {
				signInPage.idpDiscoveryUsername.sendKeys(ConfigurationReader.getProperty("mfruacthree"));
				Driver.getDriver().findElement(By.id("idp-discovery-submit")).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				signInPage.username.sendKeys(ConfigurationReader.getProperty("mfruacthree"));
			}
			signInPage.password.sendKeys(ConfigurationReader.getProperty("mfruacthreePassWord"));
			break;

		}
		
		
		hover(signInPage.signInTab);
		logger.info("User Role: " + userRole);
		signInPage.signInTab.click();
       //waitForPageToLoadfor(20);
		CommonMethods.waitFor(10);
		
		Driver.getDriver().navigate().refresh();
		// waitForPageToLoadfor(20);
		CommonMethods.waitFor(10);

	}



	@Then("user should land on my user page")
	public void user_should_land_on_my_user_page() throws InterruptedException {
      
		logger.info("Step: user should land on my user page");
		
		
		
		homePage.verifyLandingOnHomepage();

	
	   
	}
	@When("^user Select option from \"([^\"]*)\" dropdawn$")
	public void user_Select_option_from_dropdawn(String businessLineDD) throws Throwable {
//*		

		logger.info("=======TESTING INPUT DATA=======");
	
		logger.info("Business Line: "+businessLineDD);
		waitForPageToLoad();
		// Using examples
		fluentWait(homePage.businessLine, 10);
		homePage.businessLine.click();
		waitForPageToLoadfor(10);
		homePageLogic.dropDownOption(homePage.businessLine, businessLineDD);
		CommonMethods.waitFor(2);
	}
	
	@When("^user Select Configuration option from BusinessLine dropdawn$")
	public void user_Select_Configuration_option_from_BusinessLine_dropdawn() throws Throwable {
		logger.info("=======TESTING INPUT DATA=======");

		businessLineFromConfig=ConfigurationReader.getProperty("BusinessLine");
		logger.info("Business Line: "+businessLineFromConfig);
		
		fluentWait(homePage.businessLine, 10);
		homePage.businessLine.click();
		waitForPageToLoadfor(10);
		homePageLogic.dropDownOption(homePage.businessLine, businessLineFromConfig.trim());
		CommonMethods.waitFor(5);
		
	}

	
	@When("^user select option from \"([^\"]*)\" dropdawn$")
	public void user_select_option_from_dropdawn(String arg1) throws Throwable {
//*		
		logger.info("Module List: "+arg1);
		waitForPageToLoadfor(6);
		// CommonMethods.waitFor(3);
		homePageLogic.dropDownOption(homePage.moduleList, arg1);
	}
	
	@When("^user select Configuration option from Module List dropdawn$")
	public void user_select_Configuration_option_from_Module_List_dropdawn() throws Throwable {
		waitForPageToLoadfor(3);
		//muduleListFromConfig, productLineFromConfig, clientContractFromConfig
		muduleListFromConfig= ConfigurationReader.getProperty("MuduleList");
		logger.info("Module List: "+muduleListFromConfig);
		waitForPageToLoadfor(6);
		homePageLogic.dropDownOption(homePage.moduleList, muduleListFromConfig);
		CommonMethods.waitFor(1);
	}

	@When("^user select \"([^\"]*)\" option form Mudule List dropdawn$")
	public void user_select_option_form_Mudule_List_dropdawn(String muduleListDD) throws Throwable {
		waitForPageToLoadfor(3);

		homePageLogic.dropDownOption(homePage.moduleList, muduleListDD);
	}
	@When("click go")
	public void click_go() {

	//*
			//waitForPageToLoadfor(10);
			waitForPageToLoadfor(1);
			homePage.goTab.click();
		}
	
	@Then("^user reading page info$")
	public void user_reading_page_info() throws Throwable {
	    
String pageName= Driver.getDriver().findElement(By.xpath("//*[@id=\"masthead\"]/div/div[2]/p/a[1]")).getText().trim();
		String dayTime= Driver.getDriver().findElement(By.xpath("//*[@id=\"masthead\"]/div/div[2]/p")).getText().trim();
		String userName=Driver.getDriver().findElement(By.xpath("//*[@id=\"masthead\"]/div/div[2]/p/strong")).getText().trim();
        String logOut= Driver.getDriver().findElement(By.xpath("//*[@id=\"logoutBtn\"]")).getText().trim();
		logger.info("pageName                "+pageName);
		logger.info("displayDayDateTime      "+dayTime);
        logger.info("userName                "+userName);
        logger.info("logOut                  "+logOut);
	}
	@Given("^geting last number from the string$")
	public void geting_last_number_from_the_string() throws Throwable {
	String workflowQuery="Select * from workflow where workflow_name like '%SCP%' and WORKFLOW_TYPE in ('INVOICE_GENERATION') and WORKFLOW_INVOICE_YEARQTR=20223 order by 1 desc"	;
		String eachChar= null;
		String digets=null;
		String programAbvCode=null;
		 int index=0;
		//String name ="nguyenj415914SCP";
		String name ="labrown15696VASCPL";
		String abvCodeFromConfigFile="SCP";
		for( int i=0; i<=name.length()-1;i++) {
			  eachChar=""+name.charAt(i);
		boolean uperVSLower =eachChar.toUpperCase().equals(eachChar.toLowerCase());
		String uperVSLowerString=""+uperVSLower;
		 
		if(uperVSLowerString.equals("true")) {
			
			logger.info("index: "+i);
			index=i;
		}
		}
		 
		programAbvCode=name.substring(index+1, name.length());
	//	String theDigits = CharMatcher.inRange('0', '9').retainFrom("nguyenj415914SCP"); 
		logger.info("programAbvCode from workflow_name: "+programAbvCode);
	
	}
	@Given("^user switching between multiple DB$")
	public void user_switching_between_multiple_DB() throws Throwable {
	 String query="Select * from workflow order by 1 desc FETCH FIRST ROWS ONLY ";
	 
	 List<Map<String, Object>> queryResultsMap=  DBUtil.getQueryResultMap(query);
	 
	 logger.info(queryResultsMap);

	 DBUtil.closeConnection();
	 
	 logger.info("DB disconnected");
 
	 
	 DBUtil.establishConnection_DEV1();
	 
	 queryResultsMap=  DBUtil.getQueryResultMap(query);
	 
	 logger.info(queryResultsMap);
	}

}
