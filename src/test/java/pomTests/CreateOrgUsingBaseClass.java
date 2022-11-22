package pomTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrgInfoPage;
import vTiger.ObjectRepository.OrgPage;

public class CreateOrgUsingBaseClass extends BaseClass
{
  @Test(groups="smokeSuite")
  public void createOrganizationBaseClass() throws Throwable
  {
		String ORGNAME = eLib.readDataFromExcel("Organization", 4, 2)+ jLib.getRandomNumber();
		
	//navigate to organization page
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationsLink();
		
		// navigate to organization look up image
		
	   OrgPage op=new OrgPage(driver);
	   op.clickOrgLookUpImg();
	   
	   // create new organization and save 
	   
	   CreateNewOrgPage cop=new CreateNewOrgPage(driver);
	   cop.createNewOrg(ORGNAME,"2", "Manufacturing", "Customer");
	Assert.fail();
	
	   //validate organization page
	   
	 OrgInfoPage ip=new OrgInfoPage(driver);
	String ORGHEADER = ip.getOrgHeader();
	
	if(ORGHEADER.contains(ORGNAME))
	{
		System.out.println("New Organization is created Successfully");
	}
		
	else 
	{
		System.out.println(" New Organization Creation failed");
		wLib.takeScreenShot(driver, "PomCreateOrganizationTest ");
	}
		
		
  }
}
