package pomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverCommonLibrary;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrgInfoPage;
import vTiger.ObjectRepository.OrgPage;

public class PomCreateOrgWithIndustryAndTypeTest
{
   //   public static void main(String[] args) throws Throwable
	
	@Test
	
	public void  pomCreateOrgWithIndustryAndTypeTest() throws Throwable
      {
    	  //Create object of all libraries
  		
  		JavaLibrary jLib=new JavaLibrary();
  		ExcelFileLibrary eLib=new ExcelFileLibrary();
  		PropertyFileLibrary pLib=new PropertyFileLibrary();
  		WebDriverCommonLibrary wLib=new WebDriverCommonLibrary();
  		
  		//Read all the required data
  		
  		String BROWSER = pLib.readDataFromPropertyFile("browser");
  		String URL     = pLib.readDataFromPropertyFile("url"); 
  		String USERNAME= pLib.readDataFromPropertyFile("username");
  		String PASSWORD= pLib.readDataFromPropertyFile("password");  
  		String ORGNAME = eLib.readDataFromExcel("Organization", 4, 2)+ jLib.getRandomNumber();
  		
  		WebDriver driver=null;
  		
  		// Launch the browser
  		
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
  		  
  	   // Login to the applicatio
  		LoginPage lp=new LoginPage(driver);
  		lp.loginToApp(USERNAME, PASSWORD);
  		
  	   // Navigate to organizations link
  		HomePage hp=new HomePage(driver);
  		hp.clickOrganizationsLink();
  		
  		//click on organization look up img
  		
  		OrgPage op=new OrgPage(driver);
  		op.clickOrgLookUpImg();
  		
  		//create new organization with industry name and type
  		CreateNewOrgPage cop=new CreateNewOrgPage(driver);
  		cop.createNewOrg(ORGNAME, "Construction","Partner");
  		
  		//Validate the organization page
  		
  		OrgInfoPage oip=new OrgInfoPage(driver);
  		String OrgHEADER = oip.getOrgHeader();
  		
  		if(OrgHEADER.contains(ORGNAME))
  		{
  			System.out.println(OrgHEADER);
  			System.out.println("Organizatio created successfully with industry name and type");
  		}
  		
  		// Signout of the application
  		hp.signOutOfApp(driver);
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
      }
		
}
