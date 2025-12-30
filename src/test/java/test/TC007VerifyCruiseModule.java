package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import pojo.Base;

public class TC007VerifyCruiseModule extends Base{

	
	@Test(groups = "Sanity")
	public void verifyCruseModel() throws InterruptedException
	{
		 testID = "MTCM001";
		System.out.println("Verify Cruise Module");
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnWindow();
		Thread.sleep(2000);
		cm.clickOnCruise();
		Thread.sleep(1000);
		cm.getText();
		Thread.sleep(1000);
		cm.selectDestinationCity();
		Thread.sleep(1000);
		cm.selectTravelMonth();
		Thread.sleep(1000);
		cm.ClickOnApplyBTN();
		Thread.sleep(1000);
		cm.ClickOnSearchBTN();
		Thread.sleep(1000);
		Set<String> window = driver.getWindowHandles();
        List<String> getID = new ArrayList(window);
		
		String parentID = getID.get(0);
		String childID =getID.get(1);
		
		for(String windowList :getID)
		{
			System.out.println(windowList);
		}
		
		driver.switchTo().window(childID);
		
		System.out.println(driver.getCurrentUrl());
	//	cm.getSlideBarText();
		Thread.sleep(1000);
		cm.CaptureSearchResult();
		logger.info("***-----Verifed Cruise Module Test Case------***");

	}
}
