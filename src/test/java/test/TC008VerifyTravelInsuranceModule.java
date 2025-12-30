package test;

import org.testng.annotations.Test;

import pojo.Base;

public class TC008VerifyTravelInsuranceModule extends Base {

	@Test(groups = "Sanity")
	public void verifyTravelInsuranceModule() throws InterruptedException {
		 testID = "MTTIM001";
	System.out.println("Verify Travel Insurance Module");
	headerpage.clickOnClosePopUpWindow();
	Thread.sleep(1000);
	headerpage.clickOnCloseSmallPopUpWindow();
	Thread.sleep(1000);
	headerpage.clickOnWindow();
	Thread.sleep(2000);
	tim.clickOnTravellInsurance();
	Thread.sleep(1000);
	tim.getText();
	Thread.sleep(1000);
	tim.selectDestinationCity();
	Thread.sleep(1000);
	tim.ClickOnApplyBTN();
	Thread.sleep(1000);
	tim.clickONStartDate();
	Thread.sleep(1000);
	tim.clickONEndDate();
	Thread.sleep(1000);
	tim.clickONTraveller();
	Thread.sleep(1000);
	tim.mouseHoverOnPlanType();
	Thread.sleep(1000);
	tim.clickOnExploreBtn();
	Thread.sleep(1000);
	tim.recommendedGetText();
	Thread.sleep(1000);
	tim.CaptureSearchResult();
	
	logger.info("***-----Verifed Travel Insurance Module Test Case------***");

	}
}
