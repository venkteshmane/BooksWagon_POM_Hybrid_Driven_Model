package com.booksWagon.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.booksWagon.qa.base.TestBase;

public class AddAddressPage extends TestBase{
	@FindBy(linkText = "My Addresses")
	WebElement my_address;

	@FindBy(xpath = "//input[@value='Add a New Address']")
	WebElement add_New_address;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_txtRecipientName']")
	WebElement res_name;

	@FindBy(xpath = "//textarea[@id='ctl00_phBody_ShippingAddress_txtAddress']")
	WebElement st_address;

	@FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlCountry']")
	WebElement country;

	@FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlState']")
	WebElement state;

	@FindBy(xpath = "//select[@id='ctl00_phBody_ShippingAddress_ddlCities']")
	WebElement city;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_txtPincode']")
	WebElement pin_code;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_txtMobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_imgSubmit']")
	WebElement save;

	public AddAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddAddressPageTitle(){
		return driver.getTitle();
	}

	public void add_Address(String RecipientName, String StreetAddress, String Country, String State, String City, String Zip_Code, String Mob_No)
			throws AWTException {		
		my_address.click();
		add_New_address.click();
		res_name.sendKeys(RecipientName);
		st_address.sendKeys(StreetAddress);
		Select cun = new Select(country);
		cun.selectByVisibleText(Country);
		
		Robot robot = new Robot();
		robot.mouseWheel(1);
		Select sta = new Select(state);
		sta.selectByVisibleText(State);
		Select cty = new Select(city);
		cty.selectByVisibleText(City);
		pin_code.sendKeys(Zip_Code);
		mobile.sendKeys(Mob_No);
		save.click();
	}
		
//		public void FillAddressDetails() throws InterruptedException {
//		res_name.sendKeys(prop.getProperty("Recipient Name"));
//		st_address.sendKeys(prop.getProperty("Street Address"));
//		country.sendKeys(prop.getProperty("Country"));
//		state.sendKeys(prop.getProperty("State"));
//		city.sendKeys(prop.getProperty("City"));
//		mobile.sendKeys(prop.getProperty("State"));
//		
//		pin_code.sendKeys(prop.getProperty("Pin/Zip Code"));
//		mobile.sendKeys(prop.getProperty("Mobile"));
//		save.click();
//	}


}
