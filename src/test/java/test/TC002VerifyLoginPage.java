package test;

import org.testng.annotations.Test;

import pojo.Base;
import pom.LoginPageCreation;

public class TC002VerifyLoginPage extends Base {

	@Test(groups = "Sanity")
	public void verifyLoginPage() throws InterruptedException
	{
		testID = "MTLP001";
		try {
			
		
		System.out.println("Verify Login Page");
		Thread.sleep(1000);
		login.clickOnLoginBTN();
			}
		catch(Exception e)
		{
			System.out.println("Verify Login Page");
			Thread.sleep(1000);
			headerpage.clickOnClosePopUpWindow();
			headerpage.clickOnCloseSmallPopUpWindow();
			headerpage.clickOnWindow();
			Thread.sleep(1000);
			login.clickOnLoginBTN()  ;
			
		}
		
		finally
		{
			Thread.sleep(1000);
			String text=login.personalAccountGetText();
			System.out.println(text);
			login.flagDisplayed();
			login.sendmobileNumber();
			String text2 =login.clickOnContinue();
			System.out.println(text2);
			login.gmailLogoDisplay();
			login.mailImageDisplay();
			String myBizzText =login.myBizzGetText();
			System.out.println(myBizzText);
			Thread.sleep(1000);
			login.clickOnMyBiz();

		}
		logger.info("***-----Verifed Login Page Test Case------***");

	}
	
}
