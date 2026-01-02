package pom;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsuranceModule {
	@FindBy (xpath=("(//span[@data-cy='item-wrapper'])[12]"))
	private WebElement travelInsurance;
	
	@FindBy(xpath=("//div[@data-test-id='CommonLandingDT-FormHeader']"))
	private WebElement text;
	
	@FindBy(xpath=("(//div[@data-test-id='CommonLandingDT-FormSection'])[1]"))
	private WebElement destinationCity;
	
	@FindBy(xpath=("(//div[@data-test-id='SelectCountryModalV2-ScrollableContent']//p)[2]"))
	private WebElement countrySelect;
	
	@FindBy(xpath=("(//button[@data-test-id='LandingButton-LandingButtonStyle'])[1]"))
	private WebElement applyBTN;
	
	@FindBy(xpath=("(//div[@data-test-id='CommonLandingDT-FormSection'])[2]"))
	private WebElement startDate;
	@FindBy(xpath=("(//button[@name='day'])[50]"))
	private WebElement selectDate;
	
	
	@FindBy(xpath=("(//div[@data-test-id='CommonLandingDT-FormSection'])[3]"))
	private WebElement endDate;
	
	@FindBy(xpath=("(//button[@name='day'])[55]"))
	private WebElement selectEndDate;
	
	@FindBy(xpath=("(//div[@data-test-id='CommonLandingDT-FormSection'])[4]"))
	private WebElement travellers;
	
	@FindBy(xpath=("(//div[@data-selected='false'])[2]"))
	private WebElement noOFTraveller;

	@FindBy(xpath=("//button[@font-size='24px']"))
	private WebElement exploreBTN;
	
	@FindBy(xpath=("(//div[contains(@data-test-id,'CommonLandingDT-')])[25]//span"))
	private List<WebElement> planType;
	
	@FindBy(xpath=("//h2[@data-test-id='H2Tag-H2TagStyle']"))
	private WebElement planTypeText;
	
	@FindBy(xpath=("(//div[contains(@data-test-id,'InsurancePlans-')]//div[contains(@data-test-id,'InsurancePlansComp-InsurancePlanSection')])[1]"))
	private WebElement searchResult;
	
	private WebDriver driver ;
	private WebDriverWait wait;
//	private ReadConfigFile configFile ;
	
	public TravelInsuranceModule(WebDriver driver) throws IOException 
	{
		this.driver = driver;
	//	configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	public void clickOnTravellInsurance()
	{
		wait.until(ExpectedConditions.elementToBeClickable(travelInsurance));
		travelInsurance.click();
	}
	public void getText()
	{
		wait.until(ExpectedConditions.elementToBeClickable(text));
		System.out.println(text.getText());
	}
	public void selectDestinationCity() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(destinationCity));
		destinationCity.click();
	   // WebElement city = driver.findElement(By.xpath("(//div[@data-testid='citypicker_list']//li)[6]"));
	    countrySelect.click();
	}
	public void ClickOnApplyBTN()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//wait.until(ExpectedConditions.elementToBeClickable(applyBTN));
		js.executeScript("arguments[0].style.display='block';", applyBTN);
		System.out.println(applyBTN.getText());
		applyBTN.click();
	}
	
	public void clickONStartDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(startDate));
		startDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectDate));
		selectDate.click();
	}
	public void clickONEndDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectEndDate));
		selectEndDate.click();
	}
	public void clickONTraveller()
	{
		wait.until(ExpectedConditions.elementToBeClickable(travellers));
		travellers.click();
		noOFTraveller.click();
	}
	
	public void mouseHoverOnPlanType()
	{
		for(WebElement plan:planType)
		{
			System.out.println(plan.getText());
		}
	}
	public void clickOnExploreBtn()
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.display='block';", exploreBTN);
		wait.until(ExpectedConditions.elementToBeClickable(exploreBTN));
		exploreBTN.click();
	}
	public void recommendedGetText()
	{
		wait.until(ExpectedConditions.visibilityOf(planTypeText));
		System.out.println(planTypeText.getText());
	}
	public void CaptureSearchResult()
	{
		wait.until(ExpectedConditions.visibilityOf(searchResult));
		System.out.println(searchResult.getText());
	}
}
