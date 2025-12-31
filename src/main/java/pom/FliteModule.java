package pom;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FliteModule {
	@FindBy (xpath=("//ul[contains(@class,'fswTabs latoRegular')]//li"))
	private List<WebElement> ways;
	
	@FindBy(xpath=("//input[@id='fromCity']"))
	private WebElement fromCity;
	
	@FindBy(xpath=("//input[@id='toCity']"))
	private WebElement toCity;
	
	@FindBy(xpath=("//label[@for='departure']"))
	private WebElement departure;
	
	@FindBy(xpath=("(//div[@class='dateInnerCell'])[10]//p[text()='10']"))
	private WebElement DayPicker;
	
	@FindBy(xpath=("//label[@for='return']"))
	private WebElement returnTicket;
	
	@FindBy(xpath=("(//div[@class='dateInnerCell'])[40]"))
	private WebElement DayPickerReturn;
	
	@FindBy(xpath=("//label[@for='travellers']"))
	private WebElement travellers;
	
	@FindBy(xpath=("(//ul[contains(@class,'guestCounter font12 dark')])[1]//li"))
	private List<WebElement> adults;
	
	@FindBy(xpath=("(//ul[contains(@class,'guestCounter font12 dark')])[2]//li"))
	private List<WebElement> children;
	
	@FindBy(xpath=("(//ul[contains(@class,'guestCounter font12 dark')])[3]//li"))
	private List<WebElement> infants;
	
	@FindBy(xpath=("//ul[contains(@class,'guestCounter class')]//li"))
	private List<WebElement> travelClass;
	
	@FindBy(xpath=("(//button[@type='button'])[1]"))
	private WebElement applyBtn;
	
	@FindBy(xpath=("//div[@class='fareOptionsWrap']//div[@class='fareCardItem' ]"))
	private List<WebElement> specialFare;
	
	@FindBy(xpath=("//p[@data-cy='submit']//a"))
	private WebElement searchBtn;
	
	@FindBy(xpath="(//div[@class='tp-dt-header-icon'])[2]")
	private WebElement closeInfoPopup;
	
	private WebDriver driver ;
	private WebDriverWait wait;
//	private ReadConfigFile configFile ;
	
	public FliteModule(WebDriver driver) throws IOException 
	{
		this.driver = driver;
	//	configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	
	
	public void clickOnFliteTrip() throws InterruptedException
	
	{
		WebElement Filtelogo = driver.findElement(By.xpath("(//span[@data-cy='item-wrapper'])[1]"));
		Thread.sleep(1000);
		Filtelogo.click();
		
		Thread.sleep(2000);
		for( int i=1;i<=1;i++)
		{
			WebElement tripWays = driver.findElement(By.xpath("(//ul[contains(@class,'fswTabs latoRegular')]//li)["+ i + "]"));
			wait.until(ExpectedConditions.visibilityOf(tripWays));
			Thread.sleep(1000);
			System.out.println(tripWays.getText());
			tripWays.click();
		}
	}
	public void clickOnFromCity()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", fromCity);
		wait.until(ExpectedConditions.elementToBeClickable(fromCity));
		fromCity.click();
		js.executeScript("window.scrollBy(0,-1000)");
		fromCity.sendKeys("Mumbai, India");
		fromCity.sendKeys(Keys.ARROW_DOWN);
		fromCity.sendKeys(Keys.ENTER);
		js.executeScript("window.scrollBy(0,-1000)");
	}
	
	public void clickOnToCity()
	{
		wait.until(ExpectedConditions.visibilityOf(toCity));
		toCity.click();
		toCity.sendKeys("Bengaluru , India");
		toCity.sendKeys(Keys.ARROW_DOWN);
		toCity.sendKeys(Keys.ENTER);
	}
	
	public void clickOnDeparture()
	{
		wait.until(ExpectedConditions.visibilityOf(departure));
		departure.click();
	}
	public void selectDepartureDate()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", DayPicker);
		//wait.until(ExpectedConditions.visibilityOf(DayPicker));
		DayPicker.click();
	}
	public void clickOnReturn()
	{
		wait.until(ExpectedConditions.visibilityOf(returnTicket));
		returnTicket.click();
	}
	
	public void clickOnReturnTicket()
	{
		wait.until(ExpectedConditions.visibilityOf(DayPickerReturn));
		DayPickerReturn.click();
	}
	
	public void clickOnTraveller()
	{
		wait.until(ExpectedConditions.visibilityOf(travellers));
		travellers.click();
	}
	
	public void clickOnAdults()
	{
		for(WebElement adultsList:adults)
		{
			wait.until(ExpectedConditions.visibilityOf(adultsList));
			System.out.print(adultsList.getText() + " , ");
			adultsList.click();
		}
	}
	
	public void clickOnChildrens()
	{
		for(WebElement childrenList:children)
		{
			wait.until(ExpectedConditions.visibilityOf(childrenList));
			System.out.print(childrenList.getText() + " , ");
			childrenList.click();
		}
	}
	public void clickOnInfants()
	{
		for(WebElement infantsList:infants)
		{
			wait.until(ExpectedConditions.visibilityOf(infantsList));
			System.out.println(" ");
			System.out.println(infantsList.getText());
			infantsList.click();
		}
	}
	
	public void clickOnTravelClassList()
	{
		for(WebElement travelClassList:travelClass)
		{
			wait.until(ExpectedConditions.visibilityOf(travelClassList));
			System.out.println(travelClassList.getText());
			travelClassList.click();
		}
	}
	public void clickOnApplyBTN() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(applyBtn));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(false);", applyBtn);
		applyBtn.click();
	}
	public void clickOnSpecialFareList()
	{
		for(WebElement specialFareList:specialFare)
		{
			
			wait.until(ExpectedConditions.visibilityOf(specialFareList));
			System.out.println(specialFareList.getText());
			//specialFareList.click();
		
		}
	}
	public void clickOnSearchBTN() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(false);", searchBtn);
		searchBtn.click();
	}
	public void closeInfoPopUp()
	{
		wait.until(ExpectedConditions.visibilityOf(closeInfoPopup));
		closeInfoPopup.click();
	}
}
