package com.qa.booksWagon.testcases;

import java.awt.AWTException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import com.booksWagon.qa.base.TestBase;
import com.booksWagon.qa.pages.AddAddressPage;
import com.booksWagon.qa.pages.LoginPage;
import com.booksWagon.qa.util.TestUtil;

public class AddAddressTest extends TestBase{
	LoginPage loginPage;
	AddAddressPage add_address;
	TestUtil utility;
//	Logger log = Logger.getLogger(Add_Address_Test.class);
	public String SheetName = "Sheet1";

	public AddAddressTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		add_address = new AddAddressPage();

	}
	
	@Test(priority = 1)
	public void AddAddressPaheTitleTest() {
		String title = add_address.validateAddAddressPageTitle();
		Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
		System.out.println("title:"+title);
	}
	
	
	@DataProvider
	public Object[][] getLoginTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData", priority =2)
	public void add_Address_Test(String RecipientName, String StreetAddress, String Country, String State, String City, String Zip_Code, String Mob_No)
			throws AWTException {
		//log.info("Add new address Method Runing...");
		add_address.add_Address(RecipientName, StreetAddress, Country, State, City, Zip_Code, Mob_No);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");

	}


}
