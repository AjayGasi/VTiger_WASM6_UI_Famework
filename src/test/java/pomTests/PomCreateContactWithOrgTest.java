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
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrgInfoPage;
import vTiger.ObjectRepository.OrgPage;

public class PomCreateContactWithOrgTest 
{
 // public static void main(String[] args) throws Throwable
	
	@Test

	public void pomCreateContactWithOrgTest() throws Throwable
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
			String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
			
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
			
			//login to the application
			 
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			//navigate to organization page
			
			HomePage hp=new HomePage(driver);
			hp.clickOrganizationsLink();
			
			// navigate to organization look up image
			
		   OrgPage op=new OrgPage(driver);
		   op.clickOrgLookUpImg();
		   
		  // create new organization and save
		   CreateNewOrgPage cop=new CreateNewOrgPage(driver);
		   cop.createNewOrg(ORGNAME);
		   
		  //Validate the organizations page
		   OrgInfoPage oip=new OrgInfoPage(driver);
		   String OrgHEADER=oip.getOrgHeader();
		   
		   if(OrgHEADER.contains(ORGNAME))
		   {
			   System.out.println(OrgHEADER);
			   System.out.println("Organization Created Successfully");
		   }
		   
		   else
		   {
			   System.out.println("Organization Creation Failed");
		   }
		   // navigate to contacts page
		   
		    hp.clickContactsLink();
		        
		//  click on contacts look up image
		    ContactsPage cp=new ContactsPage(driver);
		    cp.clickCreateContactLookUpImg();
		    
		//  Create new contact with organization
		    
		   CreateNewContactPage ccp=new CreateNewContactPage(driver);
		   ccp.createNewContact(LASTNAME, ORGNAME, driver);
		   
		  // Validate Contact Page
		   
		   ContactsInfoPage cip=new ContactsInfoPage(driver);
		  String contactHEADER = cip.getContactHeader();
		  
		  if(contactHEADER.contains(LASTNAME))
		  {
			  System.out.println(contactHEADER);
			   System.out.println("Contact Created With Organization Successfully");
		  }
		 
		  else
		  {
			  System.out.println("Contact creation with organization Failed");
		  }
		
		  
		  //SignOut of the app
		  hp.signOutOfApp(driver);
		  
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
  }
}
