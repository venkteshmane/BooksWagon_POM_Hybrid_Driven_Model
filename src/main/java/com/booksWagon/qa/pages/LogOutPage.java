package com.booksWagon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.booksWagon.qa.base.TestBase;

public class LogOutPage extends TestBase{
	@FindBy(xpath = "//span[@class='usernametext']")
	WebElement accountLabel;
	
	@FindBy(xpath = "//a[@id='ctl00_lnkbtnLogout']")
	WebElement logOutLable;
	
	public LogOutPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void logOut() {
		accountLabel.click();
		logOutLable.click();	
		
	}

}
