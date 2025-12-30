package pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomesAndVillasModule {
	@FindBy (xpath=("(//span[@data-cy='item-wrapper'])[3]"))
	private WebElement homeandVillas;

	@FindBy(xpath=("//h1[@class='homestayHeaderH1']"))
	private WebElement text;
	
	@FindBy(xpath=("//input[@id='city']"))
	private WebElement destinationCity;
	
	@FindBy(xpath=("(//input[@type='text'])[2]"))
	private WebElement citySelect;
	
	@FindBy(xpath=("(//button[@type='button'])[5]"))
	private WebElement applyBTN;

	@FindBy(xpath=("(//div[@class='DayPicker-Day'])[5]"))
	private WebElement CheckInDate;
	
	@FindBy(xpath=("(//div[@class='DayPicker-Day'])[7]"))
	private WebElement checkOutDate;
	
	@FindBy(xpath=("(//button[@type='button'])[2]"))
	private WebElement adult;
	
	@FindBy(xpath=("(//button[@type='button'])[4]"))
	private WebElement children;
	
	@FindBy(xpath=("//div[@data-testid='gstSlct']"))
	private WebElement chlidAGEDD;

	@FindBy(xpath=("//button[@id='hsw_search_button']"))
	private WebElement searchBTN;
	
	@FindBy(xpath=("(//div[contains(@class,'hotelListingCard')])[1]"))
	private WebElement searchResult;
	

	private WebDriver driver ;
	private WebDriverWait wait;
//	private ReadConfigFile configFile ;
	
	public HomesAndVillasModule(WebDriver driver) throws IOException 
	{
		this.driver = driver;
	//	configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	public void clickOnHomesAndVillas()
	{
		wait.until(ExpectedConditions.elementToBeClickable(homeandVillas));
		homeandVillas.click();
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
		wait.until(ExpectedConditions.elementToBeClickable(citySelect));
		citySelect.click();
		citySelect.sendKeys("Dubai");
		citySelect.sendKeys(Keys.ARROW_DOWN);
		citySelect.sendKeys(Keys.ENTER);

	}
	public void clickONCheckInDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(CheckInDate));
		CheckInDate.click();
	}
	public void clickONCheckOutDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(checkOutDate));
		checkOutDate.click();
	}
	public void selectAdultAndChildren()
	{
		wait.until(ExpectedConditions.elementToBeClickable(adult));
		adult.click();
		wait.until(ExpectedConditions.elementToBeClickable(children));
		children.click();
	}
	public void selectChildDropDownAndclick() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(chlidAGEDD));
		chlidAGEDD.click();
		Thread.sleep(2000);
		WebElement dd = driver.findElement(By.xpath("(//li[@data-cy='GuestSelect$$_323'])[3]"));
		dd.click();
	}
	public void ClickOnApplyBTN()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(applyBTN));
		js.executeScript("arguments[0].scrollIntoView(false);", applyBTN);
		System.out.println(applyBTN.getText());
		applyBTN.click();
	}
	public void clickOnSearchBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchBTN));
		searchBTN.click();
	}
	public void CaptureSearchResult()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		System.out.println(searchResult.getText());
	}
}
