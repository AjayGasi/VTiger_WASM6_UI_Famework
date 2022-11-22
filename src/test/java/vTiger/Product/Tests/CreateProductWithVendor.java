package vTiger.Product.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverCommonLibrary;

public class CreateProductWithVendor
{
	public static void main(String[] args) throws Throwable
	{
    //	Step:1 create object of all the libraries 
		JavaLibrary jLib=new JavaLibrary();
		PropertyFileLibrary pLib=new PropertyFileLibrary();
		ExcelFileLibrary eLib=new ExcelFileLibrary();
		WebDriverCommonLibrary wLib=new WebDriverCommonLibrary();
		
	//  Step:2 Read all the data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL     = pLib.readDataFromPropertyFile("url");
		String USERNAME= pLib.readDataFromPropertyFile("username");
		String PASSWORD= pLib.readDataFromPropertyFile("password");
		
		String VendorName = eLib.readDataFromExcel("Vendors", 1, 2) + jLib.getRandomNumber();
		String ProductName= eLib.readDataFromExcel("Products", 1, 2) + jLib.getRandomNumber();
		
		
	//  step:3 Launch The Browser
		
		WebDriver driver=null;
		
		if (BROWSER.equalsIgnoreCase("chrome"))
          {
			driver=new ChromeDriver();
			System.out.println("Chrome Broswer is launched");
		  }
		 
		else if(BROWSER.equalsIgnoreCase("firefox"))
		  {
			driver=new FirefoxDriver();
			System.out.println("Firefox Browser is launched");
		  }
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		
	//  step:4 Log in to the Application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
   //	Step:5 Navigate to more link
		
		WebElement element = driver.findElement(By.linkText("More"));
		wLib.mouseHoverOn(driver, element);
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
   //  Step: 5 Click on vendors
		
		driver.findElement(By.linkText("Vendors")).click();
		
    // Step:6 Navigate to vendor look up image 
		
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		
  	// Step:7 Create New vendor and Save
		
		driver.findElement(By.name("vendorname")).sendKeys(VendorName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	// Step:8 Validate for vendors
		
		String VendorHEADER = driver.findElement(By.className("lvtHeaderText")).getText();
		System.out.println(VendorHEADER);
		
		if (VendorHEADER.contains(VendorName))
		{
			System.out.println("NEW VENDOR IS CREATED");
		}
		
		else 
		{
			
			System.out.println("VENDOR CREATION FAILED");
			wLib.takeScreenShot(driver, "CreateProductWithVendor");
			
		}
	
	// Step:9  Navigate to Products link
		
		driver.findElement(By.linkText("Products")).click();
		
   // Step 9 navigate to products look up page
		 
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
   // Step: 10 Create product with mandatory details
		
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		
   // Step:11 Select the vendor in vendor window
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

   //  switch to window
		
		wLib.switchToWindow(driver, "Vendors");
		WebElement ddAdd = driver.findElement(By.name("search_field"));
		wLib.handleDropDown(ddAdd, "vendorname");
		driver.findElement(By.id("search_txt")).sendKeys(VendorName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(VendorName)).click();
		
   //  Switch to parent window
		
		wLib.switchToWindow(driver, "Products");
		
   //  save the product created
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
   //  step: 12 Validate the products window	
		
		String ProductHEADER = driver.findElement(By.className("lvtHeaderText")).getText();
		System.out.println(ProductHEADER);
		
		if (ProductHEADER.contains(ProductName))
		{
			System.out.println("PRODUCT WITH VENDOR IS SUCCESSFULLY CREATED");
		}
		
		else
		{
			System.out.println("PRODUCT WITH VENDOR CREATION FAILED");
			wLib.takeScreenShot(driver, "CreateProductWithVendor");
			
		}
		
  //  step: 13 logout of the application	 
		WebElement adminIMG = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, adminIMG);
		driver.findElement(By.linkText("Sign Out")).click();
			
    }
	 

}
