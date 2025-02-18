package com.ClientName.AppName.GenericUtility.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ClientName.AppName.GenericUtility.FiLeUtility.FileUtility;

public class LoginPage {
	WebDriver driver=null;
	//Constructor of LoginPage
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindAll({@FindBy(name="user_name"),@FindBy(xpath="//input[@type='text']") })
private WebElement username;

@FindBy(name="user_password")
private WebElement password;

@FindBy(id="submitButton")
private WebElement loginBtn;

public WebElement getUserNameEdt() {
	return username;
}
public WebElement getPasswordEdt() {
	return password;
}
public WebElement getLoinEdt() {
	return loginBtn;
}

public void getLogin() throws Throwable
{
	FileUtility fu=new FileUtility();
	String uname = fu.getDataFromProperties("username");
	String pword = fu.getDataFromProperties("password");
	username.sendKeys(uname);
	password.sendKeys(pword);
	loginBtn.click();
}
}