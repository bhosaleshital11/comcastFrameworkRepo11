package com.ClientName.AppName.GenericUtility.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement addBtnEdt;
	public WebElement getaddBtnEdt()
	{
		return addBtnEdt;
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String pindustry) {
		orgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDD);
		sel.selectByValue(pindustry);
		saveBtn.click();
	}
}

