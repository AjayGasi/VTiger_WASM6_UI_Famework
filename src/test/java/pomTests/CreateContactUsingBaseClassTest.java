package pomTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;

@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactUsingBaseClassTest extends BaseClass
{
  @Test  (groups="smokeSuite")
  public void createContactBaseClass() throws Throwable
  {
	  String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
	  
		// Navigate to contacts link
		 
		HomePage hp=new HomePage(driver);
		hp.clickContactsLink();
	//	Assert.fail();
		
		// Navigate to contacts look up image
		
		ContactsPage cp= new ContactsPage(driver);
		cp.clickCreateContactLookUpImg();
	//	Assert.fail();
		
		// Create contact  with mandatory fields and save 
		
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
		//ccp.createNewContact(LASTNAME, "Conference");
	 
		// Validate the page 
		
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
		
  }
  
  @Test (groups="regressionSuite")
  public void createContactDemoTest()
  {
	//  Assert.fail();
	  System.out.println("Demo test successfull");
	
  }
  
  //Regional Regression Testing
  
  @Test
  public void createContactWithLeadSource()
  {
	//  Assert.fail();
	  System.out.println("Contact With Lead Source Created Successfully");
	 
  }
  
  @Test
  public void createContactWithLeadSourceAndOrg()
  {
	//  Assert.fail();
	  System.out.println("Contact With Lead Source And Org Created Successfully");
	 
  }

}
