package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pojo.Base;

public class TC004VerifyFliteModule extends Base {

	@Test(groups = "Regression")
	public void verifyFliteModule() throws InterruptedException
	{
		testID = "MTFM001";
		System.out.println("Verify Flite Module ");
		
		
		headerpage.clickOnClosePopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnCloseSmallPopUpWindow();
		Thread.sleep(1000);
		headerpage.clickOnWindow();
		Thread.sleep(2000);
		flmodule.clickOnFliteTrip();
		Thread.sleep(1000);
		flmodule.clickOnFromCity();
		Thread.sleep(1000);
		flmodule.clickOnToCity();
		Thread.sleep(1000);
		//flmodule.clickOnDeparture();
		//Thread.sleep(1000);
		//flmodule.selectDepartureDate();
		Thread.sleep(1000);
		System.out.println("----------------");
		flmodule.closeInfoPopUp();
		Thread.sleep(2000);
		//flmodule.clickOnReturn();
		Thread.sleep(1000);
		//flmodule.clickOnReturnTicket();
		
		flmodule.clickOnTraveller();
		Thread.sleep(1000);
		flmodule.clickOnAdults();
		Thread.sleep(1000);
		flmodule.clickOnChildrens();
		Thread.sleep(1000);
		flmodule.clickOnInfants();
		Thread.sleep(1000);
		flmodule.clickOnTravelClassList();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scroll down 
		js.executeScript("window.scrollBy(0,200)");
		flmodule.clickOnApplyBTN();
		Thread.sleep(1000);
		try
		{
			flmodule.clickOnSpecialFareList();
		}
		catch(Exception e)
		{
			WebElement popup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
		    Thread.sleep(2000);
		    popup.click();
		    Thread.sleep(2000);
		    flmodule.clickOnSpecialFareList();
		}
		
		Thread.sleep(1000);
	    
		Thread.sleep(1000);
		flmodule.clickOnSearchBTN();
		logger.info("***-----Verifed Flite Module Test Case------***");
	}
}
