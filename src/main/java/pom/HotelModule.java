package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelModule {
	@FindBy (xpath=("//li[@data-cy='menu_Hotels']"))
	private WebElement hotel;
	
	@FindBy(xpath=("(//span[@class='grpBkngOpt__item--text'])[1]"))
	private WebElement room;
	
	@FindBy(xpath=("//input[@id='city']"))
	private WebElement toCity;
	
	@FindBy(xpath=("//label[@for='checkin']"))
	private WebElement checkin;
	
	@FindBy(xpath=("(//div[@class='DayPicker-Day'])[10]"))
	private WebElement checkINDate;
	
	@FindBy(xpath=("(//div[@class='DayPicker-Day'])[30]"))
	private WebElement checkOutDate;
	
	@FindBy(xpath=("(//button[@type='button'])[2]"))
	private WebElement rooms;
	
	@FindBy(xpath=("(//button[@type='button'])[4]"))
	private WebElement adults;
	
	
	@FindBy(xpath=("(//button[@type='button'])[6]"))
	private WebElement childrens;
	
	@FindBy(xpath=("(//button[@type='button'])[7]"))
	private WebElement applyBTN;
	
	@FindBy(xpath=("//button[@id='hsw_search_button']"))
	private WebElement searchBTN;
	
	@FindBy(xpath=("(//div[@class='flexOne makeFlex'])[1]"))
	private WebElement searchResult;
	
	
	@FindBy(xpath=("//div[@data-cy='GuestSelect$$_324']"))
	private WebElement dropDown;
	
	@FindBy(xpath=("(//li[@data-cy='GuestSelect$$_323'])[4]"))
	private WebElement age;
	
	
	private WebDriver driver;
	private WebDriverWait wait;

	public HotelModule(WebDriver driver)
	{
		this.driver = driver;
		//	configFile = new ReadConfigFile();
			PageFactory.initElements(driver, this);
			
			wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
	}
	
	public void clickOnHotels()
	{
		wait.until(ExpectedConditions.elementToBeClickable(hotel));
		hotel.click();
	}
	public void clickOnRooms()
	{
		wait.until(ExpectedConditions.elementToBeClickable(room));
		room.click();
	}

	public void selectCity()
	{
		wait.until(ExpectedConditions.elementToBeClickable(toCity));
		toCity.click();
		toCity.sendKeys("Mumbai");
	}
	public void selectCheckInDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(checkin));
		checkin.click();
		checkINDate.click();
	}
	
	public void selectCheckOutDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(checkOutDate));
		checkOutDate.click();
	}
	
	public void selectRooms()
	{
		wait.until(ExpectedConditions.elementToBeClickable(rooms));
		rooms.click();
	}
	public void ClickOnAdults()
	{
		wait.until(ExpectedConditions.elementToBeClickable(adults));
		adults.click();
	}
	public void ClickOnChildrens()
	{
		wait.until(ExpectedConditions.elementToBeClickable(childrens));
		childrens.click();
		dropDown.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(age));
		js.executeScript("arguments[0].scrollIntoView(true);", age);
		age.click();
	
	}
	public void ClickOnApplyBtn()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//wait.until(ExpectedConditions.elementToBeClickable(applyBTN));
		js.executeScript("window.scrollBy(0,100)");
		js.executeScript("arguments[0].style.display='block';", applyBTN);
		applyBTN.click();
	}
	public void ClickOnSearchBTN()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//wait.until(ExpectedConditions.elementToBeClickable(searchBTN));
		js.executeScript("window.scrollBy(0,-100)");
	js.executeScript("arguments[0].style.display='block';", searchBTN);
   
		searchBTN.click();
	}
	public void CaptureSearchResult()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		System.out.println(searchResult.getText());
	}
}
