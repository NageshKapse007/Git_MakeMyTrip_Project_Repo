package pom;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HeaderPage {
	
	@FindBy (xpath=("//img[@alt='Make My Trip']"))
	private WebElement logo;
	
	@FindBy(xpath=("//li[@data-testid='listYourProperty']"))
	private WebElement listProperty;
	
	@FindBy(xpath="//li[@data-cy='myBiz']")
	private WebElement myBiz;
	
	@FindBy (xpath="//li[@data-cy='myTrips']")
	private WebElement myTrips;
	
	@FindBy (xpath="(//span[@countrycode='IN'])[1]")
	private WebElement flag;
	
	@FindBy (xpath="//span[text()='English']")
	private WebElement language;  
	
	@FindBy (xpath="//span[@data-cy='closeModal']")
	private WebElement popup; 
	
	@FindBy (xpath="(//div[@class='tp-dt-header-icon'])[2]")
	private WebElement smallpopup; 
	
	@FindBy (xpath="//div[@id='root']")
	private WebElement window; 
	
	private WebDriver driver ;
	private WebDriverWait wait;
//	private ReadConfigFile configFile ;
	
	public HeaderPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
	//	configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	
	public void verifyLogoIsDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(logo));
	
		boolean result = logo.isDisplayed();
		if(result == true)
		{
			System.out.println("Logo is displayed");
		}
		else
		{
			System.out.println("Logo is not displayed");
		}
		logo.click();
	
		
	}
	public String clickOnListProperty()
	{
		wait.until(ExpectedConditions.visibilityOf(listProperty));
		String text =listProperty.getText();
		listProperty.click();
		return text;
	}
	
	public String clickOnMyBiz()
	{
		wait.until(ExpectedConditions.visibilityOf(myBiz));
		String text =myBiz.getText();
		myBiz.click();
		
		return text;
	}
	public String clickOnMyTrips()
	{
		wait.until(ExpectedConditions.visibilityOf(myTrips));
		String text =myTrips.getText();
		myTrips.click();
	
		return text;
	}
	public void clickOnFlag()
	{
		wait.until(ExpectedConditions.visibilityOf(flag));
		//String text =flag.getText();
		flag.click();
	
		
	}
	public String clickOnMyLanguage()
	{
		wait.until(ExpectedConditions.visibilityOf(language));
		String text =language.getText();
		language.click();
		
		return text;
	}
	public void clickOnClosePopUpWindow()
	{
	//	wait.until(ExpectedConditions.visibilityOf(popup));
		wait.until(ExpectedConditions.elementToBeClickable(popup));
		//String text =flag.getText();
		popup.click();
	}
	
	public void clickOnCloseSmallPopUpWindow()
	{
		wait.until(ExpectedConditions.visibilityOf(smallpopup));
		//String text =flag.getText();
		smallpopup.click();
	}
	public void clickOnWindow()
	{
		wait.until(ExpectedConditions.visibilityOf(window));
		//String text =flag.getText();
		window.click();
	}
}
