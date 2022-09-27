package com.qa.booksWagon.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import com.booksWagon.qa.base.TestBase;
import com.booksWagon.qa.pages.LoginPage;
import com.booksWagon.qa.pages.WishListPage;

public class WishListPageTest extends TestBase{
	LoginPage loginPage;
	WishListPage wishlist;
	Logger log = Logger.getLogger(WishListPageTest.class);

	public WishListPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		wishlist = new WishListPage();
	}

	@Test(priority = 1)
	public void feature_authTest() throws InterruptedException {
		log.info("Feature Author Method Runing...");
		wishlist.feature_auth();
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title, "Buy Books Written By Stephen King at Bookswagon");
		System.out.println("title:"+title);
	}

	@Test(priority = 2)
	public void search_BookNameTest() throws InterruptedException {
		log.info("Search by book name Method Runing...");
		wishlist.search_BookName(prop.getProperty("StephenKingByBookname"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"shining - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 3)
	public void addWishlist_AuthorNameTest() throws InterruptedException {
		log.info("Search by Author name Method Runing...");
		wishlist.addWishlist_AuthorName(prop.getProperty("StephenKingByAuthor"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"stephen king - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 4)
	public void addWishlist_PublisherTest() throws InterruptedException {
		log.info("Search by Publisher Method Runing...");
		wishlist.addWishlist_Publisher(prop.getProperty("StephenKingByPublisher"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"hodder stoughton general division - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 5)
	public void wishlist_Test() throws InterruptedException {
		log.info("Wishlist Method Runing...");
		wishlist.wish_list();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");

	}


}
