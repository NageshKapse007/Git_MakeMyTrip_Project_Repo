package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pojo.Base;
import pom.HeaderContainer;

public class TC003VerifyHeaderContainer extends Base{
	
	
   @Test(priority =1 , groups = "Sanity" )
   public void verifyHeaderContainer() throws InterruptedException
   
   {
	   testID = "MTHC001";
	   Thread.sleep(1000);
	   headerpage.clickOnClosePopUpWindow();
		headerpage.clickOnCloseSmallPopUpWindow();
		//headerpage.clickOnWindow();
		
	   
	  List<WebElement> logos = container.MouseHoverOnDiffLogos();
	  System.out.println(logos.size());
	  
	  for(WebElement listlogos :logos)
	  {
		 System.out.println(listlogos.getText()); 
		 //listlogos.click();
		 Actions act = new Actions(driver);
		
		 act.moveToElement(listlogos).build().perform();
		// Thread.sleep(2000);
		 System.out.println(driver.getCurrentUrl());
		 System.out.println(driver.getTitle());
		 System.out.println("---------------------------------------------------------------");
	  }
		logger.info("***-----Verifed HeaderContaine Test Case------***");

   }
   @Test(priority =2 ,enabled =false )
   public void clickaOnDiffLogos() throws InterruptedException, IOException
   {
	   testID = "MTHC002";
	   System.out.println("Verify all Different types of logos");
	   Thread.sleep(2000);
	   headerpage.clickOnClosePopUpWindow();
	   headerpage.clickOnCloseSmallPopUpWindow();
	   container.clickOnDiffLogos();
	 //  container.clickOnRemainingDiffLogos();
		logger.info("***-----Verifed Different types of logos Test Case------***");

   }
   @Test(priority=3,groups = "Sanity")
   public void clickONRemainigLogos() throws InterruptedException
   {
	   testID = "MTHC003";
	   System.out.println("Verify all Rmaining  Different types of logose");
	   Thread.sleep(1000);
	   headerpage.clickOnClosePopUpWindow();
	   headerpage.clickOnCloseSmallPopUpWindow();
	 
	   container.clickOnRemainingDiffLogos();
		logger.info("***-----Verifed Rmaining Different types of logos Test Case------***");

   }
}
