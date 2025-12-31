package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pojo.Base;

public class TC005VerifyHotelModule extends Base {
	
	@Test(groups = "Sanity")
	public void verifyHotelModule() throws InterruptedException
	{
		 testID = "MTHM001";
		System.out.println("Verify Hoteln Module");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnWindow();
		Thread.sleep(2000);
		hm.clickOnHotels();
		//Thread.sleep(1000);
		hm.clickOnRooms();
		Thread.sleep(1000);
		hm.selectCity();
		//Thread.sleep(1000);
		hm.selectCheckInDate();
		Thread.sleep(1000);
		hm.selectCheckOutDate();
		Thread.sleep(1000);
		hm.selectRooms();
		//Thread.sleep(1000);
		hm.ClickOnAdults();
		Thread.sleep(1000);
		hm.ClickOnChildrens();
		//Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scroll down 
		js.executeScript("window.scrollBy(0,100)");
		hm.ClickOnApplyBtn();
		Thread.sleep(1000);
		hm.ClickOnSearchBTN();
		Thread.sleep(1000);
		//hm.CaptureSearchResult();
		logger.info("***-----Verifed Hotel Module Test Case------***");

	}

}
