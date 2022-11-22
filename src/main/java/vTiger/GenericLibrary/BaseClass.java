package vTiger.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This is a generic class which consists of all basic configuration annotations
 * @author Ajay
 */
public class BaseClass
{
  public  PropertyFileLibrary pLib=new PropertyFileLibrary();
  public  JavaLibrary jLib=new JavaLibrary();
  public  ExcelFileLibrary eLib=new ExcelFileLibrary();
  public  WebDriverCommonLibrary wLib=new WebDriverCommonLibrary();
   
  public  WebDriver driver =null;
  public static WebDriver lDriver=null;   //driver to initailize in listener implementation library for screenshots
  
  @BeforeSuite (groups= {"smokeSuite","regressionSuite"})
  public void bsConfig()
  {
	  System.out.println("--- DataBase Connected Successfully ---");
  }
  
 //   @Parameters("browser")
 // @BeforeTest
   @BeforeClass (groups= {"smokeSuite","regressionSuite"})
  public void bcConfig(/*String BROWSER*/) throws Throwable
  {
	  String BROWSER = pLib.readDataFromPropertyFile("browser");
	 String URL     = pLib.readDataFromPropertyFile("url");
	 
	 if(BROWSER.equalsIgnoreCase("Chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 System.out.println("--- "+BROWSER+" Browser Launched Successfully ---"); 
	 }
	 else if (BROWSER.equalsIgnoreCase("Firefox"))
	 {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 System.out.println("--- "+BROWSER+" Browser Launched Successfully ---"); 
	 }
	 else
	 {
		 System.out.println("Invalid Browser Name");
	 }
	 
	 lDriver=driver;  // initializing the currnent driver to listener driver to navigate the driver 
	 wLib.maximizeWindow(driver);
	 wLib.waitForPageLoad(driver);
	 driver.get(URL);
  }
  
  @BeforeMethod (groups= {"smokeSuite","regressionSuite"})
  public void bmConfig() throws Throwable
  {
	 String USERNAME = pLib.readDataFromPropertyFile("username");
	 String PASSWORD = pLib.readDataFromPropertyFile("password");
	 
	 LoginPage lp=new LoginPage(driver);
	 lp.loginToApp(USERNAME, PASSWORD);
	 System.out.println("--- Login is Successfull -- ");
  }
  
  @AfterMethod (groups= {"smokeSuite","regressionSuite"})
  public void amConfig()
  {
	  HomePage hp = new HomePage(driver);
	  hp.signOutOfApp(driver);
	  System.out.println("--- Logout is Successfull ---");
  }
  
 //@AfterTest
  @AfterClass (groups= {"smokeSuite","regressionSuite"})
  public void acConfig()
  {
	  driver.quit();
	  System.out.println("--- Browser Closed Successfully ---");
  }
  
  @AfterSuite (groups= {"smokeSuite","regressionSuite"})
  public void asConfig()
  {
	  System.out.println("--- DataBase Disconnected Successfully ---");
  }
  
}
