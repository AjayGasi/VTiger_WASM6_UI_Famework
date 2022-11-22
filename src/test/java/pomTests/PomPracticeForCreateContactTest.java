package pomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverCommonLibrary;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class PomPracticeForCreateContactTest 
{
  //	public static void main(String[] args) throws Throwable 
	
	@Test
	
	public void pomPracticeForCreateContactTest() throws Throwable
	{
		
    //Step:1 Create object of all the libraries
	
	PropertyFileLibrary pLib = new PropertyFileLibrary();
	ExcelFileLibrary    eLib = new ExcelFileLibrary();
	JavaLibrary         jLib = new JavaLibrary();
	WebDriverCommonLibrary wLib = new WebDriverCommonLibrary();
	
   	//Step:2 Read all the required data
	 
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL     = pLib.readDataFromPropertyFile("url"); 
	String USERNAME= pLib.readDataFromPropertyFile("username");
	String PASSWORD= pLib.readDataFromPropertyFile("password");   
	
	String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
	
	WebDriver driver=null;
	
	//Step:3 Launch the browser
	
	if (BROWSER.equalsIgnoreCase("chrome"))
	{ 
		
	    driver=new ChromeDriver();
	    System.out.println("Chrome Browser is Launched");
	
	}
    
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		
		driver=new FirefoxDriver();
		System.out.println("Firefox Browser is Launched");
		
	}
     
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	//Step:4 Login to the application

	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	//Step:5 Navigate to contacts link
	
	HomePage hp=new HomePage(driver);
	hp.clickContactsLink();
	
	//Step:6 Navigate to contacts look up image
	
	ContactsPage cp= new ContactsPage(driver);
	cp.clickCreateContactLookUpImg();
	
	//Step:7 Create contact  with mandatory fields and save 
	
	CreateNewContactPage ccp=new CreateNewContactPage(driver);
	ccp.createNewContact(LASTNAME);
	//ccp.createNewContact(LASTNAME, "Conference");
 
	//Step:8 Validate the page 
	
	ContactsInfoPage cip=new ContactsInfoPage(driver);
	String contactHeader = cip.getContactHeader();
	
	if(contactHeader.contains(LASTNAME))
	{
		System.out.println("New Contact is created Successfully");
	}
	
	else
	{
		System.out.println(" New Contact Creation failed");
		wLib.takeScreenShot(driver, "PomPracticeForCreateContactTest");
	}
	
	//Step:9 LogOut of the application
	
    hp.signOutOfApp(driver);
	}
	
}
