package com.booksWagon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.booksWagon.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory - Object Repository:
	@FindBy(id="ctl00_phBody_SignIn_txtEmail")	
	WebElement username;
	
	@FindBy(id="ctl00_phBody_SignIn_txtPassword")
	WebElement password;
	
	@FindBy(id="ctl00_phBody_SignIn_btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="(//img[@class='w-100'])[39]")
	WebElement image;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public String validateLoginPageurUrl(){
		return driver.getCurrentUrl();
	}
	
	public boolean validateImage() {
		return image.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {	
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	public void multipleUserLogin(String un,String pwd) {	
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}
	
	

}
