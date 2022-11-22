package vTigerPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

/**
 * @author Dell
 */
public class CreateMultipleOrgWithIndustryTest
{

	//Step 1 :Create object of all libraries
	
	ExcelFileLibrary eLib=new ExcelFileLibrary();
	PropertyFileLibrary pLib=new PropertyFileLibrary();
	JavaLibrary jLib=new JavaLibrary();
	WebDriverCommonLibrary wLib=new WebDriverCommonLibrary();
	
	@Test(dataProvider = "MultipleData")
	public void createMultipleOrgTest(String OrgName, String IndType ) throws Throwable 
	{
		
		String Org = OrgName+jLib.getRandomNumber();
		
		//Step 2: Read all the required data
		
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL=pLib.readDataFromPropertyFile("url");
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD=pLib.readDataFromPropertyFile("password");
		
		WebDriver driver=null;
		
		//Step : 3  : Launch the browser
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step 4: Login to Application
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step : 5: Navigate to organizations page
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationsLink();
		
		//Step 6: navigate to organization look up image
		
		OrgPage op=new OrgPage(driver);
		op.clickOrgLookUpImg();
		
		//Step 7: create new organization and save
		
		CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
		cnop.createNewOrg(Org, IndType);
		
		//Step 8:  validate org page
		
		OrgInfoPage oip=new OrgInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		
		if(OrgHeader.contains(Org))
		{
			System.out.println(OrgHeader);
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step 9: Logout Of App
		
		hp.signOutOfApp(driver);	
	}
			
			  
	@DataProvider(name="MultipleData")
	
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		
		Object[][] data=eLib.readMultipleData("MultipleOrgData");
		
		return data;
	}
	
	
	
}
