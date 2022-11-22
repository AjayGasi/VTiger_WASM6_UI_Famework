package vTiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverCommonLibrary;

public class CreateContactWithOrganization 
  { 
	//public static WebDriver driver;
	
	public static void main(String[] args) throws Throwable
	{
		
	  //Step:1 Create Object of all the Libraries
		
		JavaLibrary jLib=new JavaLibrary();
		PropertyFileLibrary pLib= new PropertyFileLibrary();
		ExcelFileLibrary eLib=new ExcelFileLibrary();
		WebDriverCommonLibrary wLib=new WebDriverCommonLibrary();
		
	// Step:2 Read all the required data
		
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		
		String ORGNAME = eLib.readDataFromExcel("Organization", 7, 2)+jLib.getRandomNumber();
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
	
		
	//Step:3 Launch the browser
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
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
	
	// Step:4 Log Into the Application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//Step:5 Navigate to Organizations Link
		
		driver.findElement(By.linkText("Organizations")).click();
		
	//Step:6 Navigate to organizations look up image
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
	//Step:7 Create New Organization and Save	
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
    //Step:8 Validate for Organization
		
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		
		if (orgHeader.contains(ORGNAME))
		{
		System.out.println("Organization is created");	
		}
		
		else
		{
			System.out.println("Organization Creation Failed");
			wLib.takeScreenShot(driver, "CreateContactWithOrganization");
		}
		
	//Step:9 Navigate to Contacts 
		driver.findElement(By.linkText("Contacts")).click();
		
	//Step:10 Navigate to Contact look up image	
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
	//Step: 11 Create Contact with Mandatory Details
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
	//Step:12 Select the organization in org window
		
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
		wLib.switchToWindow(driver,"Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		wLib.switchToWindow(driver, "Contacts");
		
	//Step:13 save the Contact created
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	//Step:14 Validate the Contact window
		
	    String contactHeader = driver.findElement(By.className("dvHeaderText")).getText();
	    System.out.println(contactHeader);
	    if (contactHeader.contains(LASTNAME))
	    {
			System.out.println("PASS");
		}
	    
	    else
	    {
	    	System.out.println("FAIL");
	    }
		
	//Step:15 Log Out of the Application
	    
	   WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	   wLib.mouseHoverOn(driver, adminImg);
	   driver.findElement(By.linkText("Sign Out")).click();
				
	}

}
