package com.qa.booksWagon.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import com.booksWagon.qa.base.TestBase;
import com.booksWagon.qa.pages.HomePage;
import com.booksWagon.qa.pages.LoginPage;
import com.booksWagon.qa.pages.SearchBookPage;

public class SearchBookPageTest extends TestBase {
	SearchBookPage searchBook;
	HomePage homePage;
	LoginPage loginPage;
	Logger log = Logger.getLogger(SearchBookPageTest.class);
	
	public SearchBookPageTest () {
		super();
	}

	@BeforeMethod()
	public void setUp() throws IOException, InterruptedException {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchBook = new SearchBookPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifySearchPageTest() throws Exception{
		searchBook.clickSearchButton("Yayati");
		searchBook.clickOnBookNow();
		log.info("Verify Successfully Search Feature");
	}
	
	@Test(priority = 2)
	public void validateSearchPageTitle() {
		String title = searchBook.validateSearchPageTitle();
		Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
		System.out.println("title:"+title);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

		
	}


}
