package pojo;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CruiseModule;
import pom.FliteModule;
import pom.HeaderContainer;
import pom.HeaderPage;
import pom.HomesAndVillasModule;
import pom.HotelModule;
import pom.LoginPageCreation;
import pom.TrainModule;
import pom.TravelInsuranceModule;
import properties.ReadConfigFile;
import utilities.ScreenShot;

public class Base {
	public static String testID ;
	public WebDriver driver;
	public HeaderPage headerpage;
	public HeaderContainer container;
	public ReadConfigFile configFile;
	public LoginPageCreation login;
	public FliteModule flmodule;
	public HotelModule hm ;
	public TrainModule tl;
	public CruiseModule cm;
	public  TravelInsuranceModule tim;
	public HomesAndVillasModule hvm;
	public org.apache.logging.log4j.Logger logger ;
//	XLUtilityExcel utility ;
	public static ExtentTest test;
	public static ExtentHtmlReporter reporter;
	@BeforeClass(groups ={"Regression","Sanity","Master"})
	public void lounchBrowser() throws IOException, InterruptedException
	{
		logger=LogManager.getLogger(this .getClass());	
		System.out.println("Luanch Browser");
		

		configFile = new ReadConfigFile();
	//	utility = new XLUtilityExcel();
		
		logger.info("***-----Chrome browser and url launched ------***");
	}
	@BeforeMethod(groups ={"Regression","Sanity","Master"})
	public void createObject() throws IOException, InterruptedException
	{
		System.out.println("Creat POM Object");
		WebDriverManager.chromedriver().setup();
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		driver= new ChromeDriver();
           driver.get(configFile.getUrl()); 
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		login = new  LoginPageCreation(driver);
		 headerpage = new HeaderPage(driver);
		 container = new HeaderContainer(driver);
		 flmodule = new FliteModule(driver);
		 hm = new HotelModule(driver);
		 tl = new TrainModule(driver);
		 cm = new CruiseModule(driver);
		 tim =new TravelInsuranceModule(driver);
		 hvm = new HomesAndVillasModule(driver);
	     
		logger.info("***-----Created Pom Object ------***");
	}
	@AfterMethod(groups ={"Regression","Sanity","Master"})
	public void clearObject(ITestResult result) throws InterruptedException, IOException
	{
		System.out.println("-----Null POM Object------------");
		Thread.sleep(2000);
		if(ITestResult.FAILURE==result.getStatus())
        {
		ScreenShot.getScreenShot(driver, testID);
        }	
		driver.quit();
		headerpage =null;
		logger.info("***---- Null Pom Object ------***");

		
	}
	@AfterClass(groups ={"Regression","Sanity","Master"})
	public void closeBrowser()
	{
		System.out.println("Close Browser and Clear Unwanted objectes");
		driver =null;
		System.gc();
		logger.info("***-----Successfully Executed testScript  ------***");

   }
}
