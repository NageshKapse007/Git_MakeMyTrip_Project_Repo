package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practce {

	
	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.veenaworld.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	
		WebElement iframe= driver.findElement(By.xpath("//iframe[@id='webpush-onsite']"));
	     driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		
		WebElement closeBTN= driver.findElement(By.xpath("(//div[@class='button-group-custom clearfix']//button)[1]"));
		//	driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		closeBTN.click();

		WebElement sideBTN= driver.findElement(By.xpath("//a[text()='Corporate Travel']"));
	//	  driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(sideBTN).perform();
		sideBTN.click();
		
		WebElement enqiry= driver.findElement(By.xpath("//button[contains(@class,'enquiryBtn btn-brand ')]"));
		//	driver.switchTo().frame(iframe);
				Thread.sleep(2000);
		//input[@type='text']
		
	}
}
