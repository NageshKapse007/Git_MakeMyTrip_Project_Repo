package test;

import org.testng.annotations.Test;

import pojo.Base;

public class TC006VerifyTrainModule extends Base {

	@Test(groups = "Regression")
	public void verifyTrainModule() throws InterruptedException
	{
		 testID = "MTTM001";
		System.out.println("Verify train module");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnWindow();
		Thread.sleep(2000);
		tl.clickOnTrains();
		Thread.sleep(1000);
		tl.clickOnTrainBooking();
		Thread.sleep(1000);
		tl.selectFromCity();
		//Thread.sleep(1000);
		tl.selectToCity();
		Thread.sleep(1000);
		tl.selectTravelDateDate();
		//Thread.sleep(1000);
		tl.selectClass();
		//Thread.sleep(1000);
		tl.ClickOnSearchBTN();
		Thread.sleep(1000);
		tl.CaptureSearchResult();
		logger.info("***-----Verifed Train Module Test Case------***");

	}
}
