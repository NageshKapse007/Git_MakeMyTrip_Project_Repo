package pom;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderContainer {

	private WebDriver driver;
	private WebDriverWait wait;

	public HeaderContainer(WebDriver driver) {
		this.driver = driver;
		// configFile = new ReadConfigFile();
		PageFactory.initElements(driver, this);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public List<WebElement> MouseHoverOnDiffLogos()

	{
		List<WebElement> logo = driver.findElements(By.xpath("//span[@data-cy='item-wrapper']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(logo));
		return logo;
	}

	public void clickOnDiffLogos() throws InterruptedException, IOException

	{
		
			try 
			{
				
				for (int i = 1; i <= 12; i++)
				{
					System.out.println("--TRY---");
				WebElement logo = driver.findElement(By.xpath("(//span[@data-cy='item-wrapper'])[" + i + "]"));
				wait.until(ExpectedConditions.elementToBeClickable(logo));
				System.out.println(logo.getText());
				Thread.sleep(1000);
				logo.click();
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				System.out.println("---------------------------------------------------------------");
				
			  } 
		}
			catch (Exception e) 
			
			{
		
					for(int j=9;j<=12;j++)
					{
						System.out.println("----***Catch***--");
						Thread.sleep(1000);
						WebElement logo2 = driver.findElement(By.xpath("(//span[@data-cy='item-wrapper'])[" + j + "]"));
						wait.until(ExpectedConditions.elementToBeClickable(logo2));
						System.out.println(logo2.getText());
						logo2.click();
					WebElement loginPopup = driver.findElement(By.xpath("//li[@data-cy='account']"));
					wait.until(ExpectedConditions.elementToBeClickable(loginPopup));
					loginPopup.click();
						System.out.println(driver.getCurrentUrl());
						System.out.println(driver.getTitle());
						System.out.println("---------------------------------------------------------------");
					}
			
			}
			
		}
	

	public void clickOnRemainingDiffLogos() throws InterruptedException

	{
		for (int i = 9; i <= 12; i++) 
		   {
			WebElement logo = driver.findElement(By.xpath("(//span[@data-cy='item-wrapper'])[" + i + "]"));
			wait.until(ExpectedConditions.elementToBeClickable(logo));

			System.out.println(logo.getText());
			try {
				Thread.sleep(2000);
				logo.click();
				Thread.sleep(2000);
				
			} catch (Exception e) {
				WebElement loginPopup = driver.findElement(By.xpath("//li[@data-cy='account']"));
				wait.until(ExpectedConditions.elementToBeClickable(loginPopup));
				loginPopup.click();
				//e.printStackTrace();
			} finally {
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				System.out.println("---------------------------------------------------------------244324");
			}
		}
	}
}
