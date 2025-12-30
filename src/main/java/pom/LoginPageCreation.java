package pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageCreation {
	@FindBy (xpath=("//p[@data-cy='LoginHeaderText']"))
	private WebElement login;
	
	@FindBy (xpath=("//li[@data-cy='personalLogin']"))
	private WebElement personalAccount;
	
	@FindBy (xpath=("//li[@data-acctype='myBiz']"))
	private WebElement myBizAcc;
	
	@FindBy (xpath=("//span[contains(@class,'flag-sprite appendLeft5 ')]"))
	private WebElement flag;
	
	@FindBy (xpath=("//input[@data-cy='userName']"))
	private WebElement mobilenumber;
	
	@FindBy (xpath=("//span[text()='Continue']"))
	private WebElement continueBTN;
	
	@FindBy (xpath=("//div[@data-type='icon']"))
	private WebElement gmailLogo;
	
	@FindBy (xpath=("//img[@alt='signInByMailButton']"))
	private WebElement emailLogo;
	
	private WebDriver driver ;
	private WebDriverWait wait;
//	private ReadConfigFile configFile ;
	
	public LoginPageCreation(WebDriver driver) throws IOException 
	{
		this.driver = driver;
	//	configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
	}
	
	public String clickOnLoginBTN()
	{
		wait.until(ExpectedConditions.visibilityOf(login));
		String text =login.getText();
		login.click();
		return text;
	}
	public String personalAccountGetText()
	{
		wait.until(ExpectedConditions.visibilityOf(personalAccount));
		String text =personalAccount.getText();
		personalAccount.click();
		return text;
	}
	
	public String myBizzGetText()
	{
		wait.until(ExpectedConditions.visibilityOf(myBizAcc));
		String text =myBizAcc.getText();
		//myBizAcc.click();
		return text;
	}
	
	public void flagDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(flag));
		boolean result = flag.isDisplayed();
		if(result == true)
		{
			System.out.println("Flag is displayed");
		}
		else
		{
			System.out.println("Flag is not Displayed");
		}
	}
	
	public void sendmobileNumber()
	{
		wait.until(ExpectedConditions.visibilityOf(mobilenumber));
		mobilenumber.sendKeys("9370109594");
	}
	public String clickOnContinue()
	{
		wait.until(ExpectedConditions.visibilityOf(continueBTN));
		String text =continueBTN.getText();
		//myBizAcc.click();
		return text;
	}
	
	public void gmailLogoDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(gmailLogo));
		boolean result = gmailLogo.isDisplayed();
		if(result == true)
		{
			System.out.println("Gmail Logo is displayed");
		}
		else
		{
			System.out.println("Gmail Logo is not Displayed");
		}
	}
	
	public void mailImageDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(emailLogo));
		boolean result = emailLogo.isDisplayed();
		if(result == true)
		{
			System.out.println("Email Logo is displayed");
		}
		else
		{
			System.out.println("Email Logo is not Displayed");
		}
	}
	
	public void clickOnMyBiz()
	{
		wait.until(ExpectedConditions.visibilityOf(myBizAcc));
		myBizAcc.click();
	}
}
