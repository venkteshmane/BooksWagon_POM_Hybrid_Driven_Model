package com.qa.booksWagon.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.booksWagon.qa.base.TestBase;
import com.booksWagon.qa.pages.HomePage;
import com.booksWagon.qa.pages.LoginPage;
import com.booksWagon.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);


	TestUtil utility;
	public String SheetName = "Sheet2";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
		System.out.println("title:"+title);
	}
	
	
	@Test(priority = 2)
	public void loginPageurUrlTest() {
		String url = loginPage.validateLoginPageurUrl();
		Assert.assertEquals(url, "https://www.bookswagon.com/login");
		System.out.println("title:"+url);
	}
	
	
	@Test(priority = 3)
	public void ImageTest() {
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	
	@Test(priority = 4)
	public void loginTest() {
		log.info("LoginTest Method Runing...");
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("login successful with username and Password");
	}
	
	@DataProvider 
	public Object[][] getLoginTestData() throws InvalidFormatException {
		Object data[][] = utility.getTestData(SheetName);
		return data;
	}
	
	@Test(dataProvider = "getLoginTestData", priority = 5)
	public void MultipleUserLoginTest(String username, String password) {
		log.info("Multiple user login Method Runing...");
		loginPage.multipleUserLogin(username, password);
		
	
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");
	}


}