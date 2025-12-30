package pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainModule {
	@FindBy (xpath=("(//span[@data-cy='item-wrapper'])[5]"))
	private WebElement train;
	
	@FindBy(xpath=("//span[@data-cy='bookTrainTickets']"))
	private WebElement trainBooking;
	
	@FindBy(xpath=("//label[@for='fromCity']"))
	private WebElement fromCity;
	
	@FindBy(xpath=("//label[@for='toCity']"))
	private WebElement toCity;
	
	@FindBy(xpath=("//label[@for='travelDate']"))
	private WebElement travelDate;
	
	@FindBy(xpath=("(//div[@class='DayPicker-Day'])[25]"))
	private WebElement selectDate;
	
	@FindBy(xpath=("//label[@for='travelClass']"))
	private WebElement travelClass;
	
	@FindBy(xpath=("(//ul[@class='travelForPopup']//li)[3]"))
	private WebElement travelForPopup;
	
	@FindBy(xpath=("//a[@data-cy='submit']"))
	private WebElement searchBTN;
	
	
	@FindBy(xpath=("(//div[@data-testid='listing-card'])[1]"))
	private WebElement searchResult;
	
	private WebDriver driver ;
	private WebDriverWait wait;
//	private ReadConfigFile configFile ;
	
	public TrainModule(WebDriver driver) throws IOException 
	{
		this.driver = driver;
	//	configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	
	public void clickOnTrains()
	{
		wait.until(ExpectedConditions.elementToBeClickable(train));
		train.click();
	}
	public void clickOnTrainBooking()
	{
		wait.until(ExpectedConditions.elementToBeClickable(trainBooking));
		trainBooking.click();
	}

	public void selectFromCity()
	{
		wait.until(ExpectedConditions.elementToBeClickable(fromCity));
		fromCity.click();
		fromCity.sendKeys("Mumbai");
	}
	public void selectToCity()
	{
		wait.until(ExpectedConditions.elementToBeClickable(toCity));
		toCity.click();
		toCity.sendKeys("Kolkata");
	}
	public void selectTravelDateDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(travelDate));
		travelDate.click();
		selectDate.click();
	}
	
	public void selectClass()
	{
		wait.until(ExpectedConditions.elementToBeClickable(travelClass));
		travelClass.click();
		travelForPopup.click();
	}
	public void ClickOnSearchBTN()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(searchBTN));
		js.executeScript("arguments[0].scrollIntoView(false);", searchBTN);
		searchBTN.click();
	}
	public void CaptureSearchResult()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		System.out.println(searchResult.getText());
	}
}
