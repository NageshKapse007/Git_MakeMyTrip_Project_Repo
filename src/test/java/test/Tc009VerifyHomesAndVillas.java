package test;

import org.testng.annotations.Test;

import pojo.Base;

public class Tc009VerifyHomesAndVillas extends Base{

	@Test(groups = "Regression")
	public void verifyHomesAndVillasModule() throws InterruptedException
	{	
		 testID = "MTHVM001";
	System.out.println("Verify Travel HomesAndVillas Module");
	headerpage.clickOnClosePopUpWindow();
	Thread.sleep(1000);
	headerpage.clickOnCloseSmallPopUpWindow();
	Thread.sleep(1000);
	headerpage.clickOnWindow();
	Thread.sleep(2000);
	hvm.clickOnHomesAndVillas();
	Thread.sleep(1000);
	hvm.getText();
	hvm.selectDestinationCity();
	hvm.clickONCheckInDate();
	hvm.clickONCheckOutDate();	
	hvm.selectAdultAndChildren();
	hvm.selectChildDropDownAndclick();
	hvm.ClickOnApplyBTN();
	hvm.clickOnSearchBtn();
	//hvm.CaptureSearchResult();
	logger.info("***-----Verifed Home And Villas Module Test Case------***");

	}
}
