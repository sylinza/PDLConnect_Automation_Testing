package com.pdl.pages.ContractAdmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pdl.utilities.Driver;

public class Association_ContractPage {
	
	public Association_ContractPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="(//*[@id=\"navAdmin\"]//a)[7]")
	public WebElement associationTab;
	//*[@id="mainForm"]/div/div/fieldset/p/span
	@FindBy(xpath="//*[@id=\"mainForm\"]//span")
	public WebElement associateContractPageTitle;
	
	@FindBy(id="mainForm:productLine")
	public WebElement productLineDropDown;

	@FindBy(id="mainForm:srchRuleName")
	public WebElement manufacturerContract;
	
	@FindBy(id="mainForm:srchRuleDesc")
	public WebElement clientContract;
	
	@FindBy(id="mainForm:search")
	public WebElement search;
	
	@FindBy(id="mainForm:addAssociation")
	public WebElement addAssociationjButton;
	
	@FindBy(id="mainForm:associationTable")
	public WebElement associationTable;
	
	@FindBy(id="mainForm:association")
	public WebElement disAssociationButton;
	
	@FindBy(xpath="//*[@id=\"messages\"]/ul/li")
	public WebElement sysMsg;
	
	@FindBy(xpath="mainForm:associationPageScroller")
	public WebElement associationPageScroller;
	
	
	
	
	
	
	
	
	
	
	
}
