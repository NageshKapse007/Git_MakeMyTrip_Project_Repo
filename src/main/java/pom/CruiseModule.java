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

public class CruiseModule {
	@FindBy (xpath=("(//span[@data-cy='item-wrapper'])[10]"))
	private WebElement cruise;
	
	@FindBy(xpath=("//h1[@class='desc']"))
	private WebElement text;
	
	@FindBy(xpath=("//label[@for='destinationCity']"))
	private WebElement destinationCity;
	
	@FindBy(xpath=("(//input[@type='text'])[2]"))
	private WebElement monthSelect;
	
	@FindBy(xpath=("(//div[@class='dateDropdown']//label)[2]"))
	private WebElement dateDropdown;
	
	@FindBy(xpath=("(//button[@type='button'])[1]"))
	private WebElement applyBTN;
	
	@FindBy(xpath=("//button[text()='Search']"))
	private WebElement searchBTN;
	
	@FindBy(xpath=("(//filter-component[@id='sidebar']//filter-content-component)[1]"))
	private WebElement sidebar;
	
	@FindBy(xpath=("//cruise-item-component[@data-ody-id='cruise-item-component_0']"))
	private WebElement searchResult;
	
	private WebDriver driver ;
	private WebDriverWait wait;
//	private ReadConfigFile configFile ;
	
	public CruiseModule(WebDriver driver) throws IOException 
	{
		this.driver = driver;
	//	configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	}
	public void clickOnCruise()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cruise));
		cruise.click();
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
	    WebElement city = driver.findElement(By.xpath("(//div[@data-testid='citypicker_list']//li)[6]"));
	    city.click();
	}
	
	public void selectTravelMonth() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(monthSelect));
		monthSelect.click();
		Thread.sleep(1000);
		dateDropdown.click();
	}
	public void ClickOnApplyBTN()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(applyBTN));
		js.executeScript("arguments[0].scrollIntoView(false);", applyBTN);
		System.out.println(applyBTN.getText());
		applyBTN.click();
	}
	public void ClickOnSearchBTN() throws InterruptedException
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(searchBTN));
		System.out.println(searchBTN.getText());
		searchBTN.click();
	}
	public void getSlideBarText()
	{
		wait.until(ExpectedConditions.elementToBeClickable(sidebar));
		System.out.println(sidebar.getText());
	}
	public void CaptureSearchResult()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		System.out.println(searchResult.getText());
	}
	
}


