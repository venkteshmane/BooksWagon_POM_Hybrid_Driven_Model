package com.qa.booksWagon.testcases;

import java.io.IOException;

import org.testng.annotations.*;

import com.booksWagon.qa.base.TestBase;
import com.booksWagon.qa.pages.HomePage;
import com.booksWagon.qa.pages.LogOutPage;
import com.booksWagon.qa.pages.LoginPage;

public class LogOutPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	LogOutPage logoutpage;

	public LogOutPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void logOut() throws InterruptedException, IOException {
		logoutpage = new LogOutPage();
		logoutpage.logOut();
		
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
