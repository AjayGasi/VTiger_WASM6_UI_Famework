package pomTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrgInfoPage;
import vTiger.ObjectRepository.OrgPage;

public class CreateContactWithOrgUsingBaseClass  extends BaseClass
{
  @Test (groups="regressionSuite")
  public void createContactWithOrgUsingBaseClassTest() throws Throwable
	{
	String ORGNAME = eLib.readDataFromExcel("Organization", 4, 2)+ jLib.getRandomNumber();
	String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
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
   Assert.fail();
   
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
 }
  
}

