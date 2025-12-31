package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pojo.Base;
import pom.HeaderPage;

import properties.ReadConfigFile;

public class TC001VerifyHeaderPage extends Base{

	@Test(priority=1 ,groups ="Regression")
	public void verifyLogoIspresent() throws InterruptedException
	{
		testID = "MTHP001";
		try
		{
		System.out.println("Verify Logo is present");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		
		headerpage.verifyLogoIsDisplay();

		}
		catch(Exception e)
		{
			System.out.println("Verify Logo is present");
			
			Thread.sleep(1000);
			headerpage.clickOnWindow();
			//Thread.sleep(2000);
			headerpage.verifyLogoIsDisplay();
		}
		logger.info("***-----Successfully  Verified Logo is present ------***");

	}
	@Test(priority=2,groups ="Regression")
	public void verifyListYourPriority() throws InterruptedException
	{
		testID = "MTHP002";
		try
		{
		System.out.println("Verify List Your Priority");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		Thread.sleep(1000);
		String text =headerpage.clickOnListProperty();
		System.out.println(text);
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		}
		catch(Exception e)
		{
			System.out.println("Verify List Your Priority");
			
			Thread.sleep(1000);
			headerpage.clickOnWindow();
			String text =headerpage.clickOnListProperty();
			System.out.println(text);
			String title = driver.getTitle();
			System.out.println(title);
			String url = driver.getCurrentUrl();
			System.out.println(url);
		}
		logger.info("***-----Verifed List Your Priority Test Case------***");

	}
	
	@Test(priority=3,groups ="Regression")
	public void verifyMyBiz() throws InterruptedException
	{
		testID = "MTHP003";
		try 
		{
		System.out.println("Verify Introducing my biz");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		Thread.sleep(1000);
		String text =headerpage.clickOnMyBiz();
		System.out.println(text);
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		}
		catch(Exception e)
		{
			Thread.sleep(1000);
			headerpage.clickOnWindow();
			Thread.sleep(1000);
			String text =headerpage.clickOnMyBiz();
			System.out.println(text);
			String title = driver.getTitle();
			System.out.println(title);
			String url = driver.getCurrentUrl();
			System.out.println(url);
		}
		logger.info("***-----Verifed Introducing my biz Test Case------***");

	}
	
	@Test(priority=4,groups ="Regression")
	public void verifyMyTrips() throws InterruptedException
	{
		testID = "MTHP004";
		try
		{
		System.out.println("Verify My Trips");
		headerpage.clickOnClosePopUpWindow();
		//Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		//Thread.sleep(1000);
		String text =headerpage.clickOnMyTrips();
		System.out.println(text);
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		}
		catch(Exception e)
		{
			Thread.sleep(1000);
			headerpage.clickOnWindow();
			//Thread.sleep(1000);
			String text =headerpage.clickOnMyTrips();
			System.out.println(text);
			String title = driver.getTitle();
			System.out.println(title);
			String url = driver.getCurrentUrl();
			System.out.println(url);
		}
		logger.info("***-----Verifed  My Trips Test Case------***");

	}
	
	@Test(priority=5,groups ="Regression")
	public void verifyFlagIsPresent() throws InterruptedException
	{
		testID = "MTHP005";
		try
		{
		System.out.println("Verify Flag is present ");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		//Thread.sleep(1000);
	     headerpage.clickOnFlag();
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		}
		catch(Exception e)
		{
			Thread.sleep(1000);
			headerpage.clickOnWindow();
			//Thread.sleep(1000);
		     headerpage.clickOnFlag();
			String title = driver.getTitle();
			System.out.println(title);
			String url = driver.getCurrentUrl();
			System.out.println(url);
		}
		logger.info("***-----Verifed Flag is present Test Case------***");

	}
	@Test(priority=6,groups ="Regression")
	public void verifyLanguage() throws InterruptedException
	{
		testID = "MTHP006";
		try
		{
		System.out.println("Verify Language");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		//Thread.sleep(1000);
		String text =headerpage.clickOnMyLanguage();
		System.out.println(text);
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		}
		catch(Exception e)
		{
			Thread.sleep(1000);
			headerpage.clickOnWindow();
			//Thread.sleep(1000);
			String text =headerpage.clickOnMyLanguage();
			System.out.println(text);
			String title = driver.getTitle();
			System.out.println(title);
			String url = driver.getCurrentUrl();
			System.out.println(url);
		}
		logger.info("***-----Verifed  Language Test Case------***");

	}
	
}
