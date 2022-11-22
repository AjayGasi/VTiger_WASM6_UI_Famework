package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverCommonLibrary;

public class CreateNewOrgPage extends WebDriverCommonLibrary
{
	//Declaration
	
	@FindBy(name = "accountname") private WebElement OrgNameTextBox;
	@FindBy(name = "industry") private WebElement Industryname;
	@FindBy(name = "accounttype") private WebElement Organizationtype;
	@FindBy(xpath = "//input[@value='T']") private WebElement AssignedToGrpRadioBtn;
	@FindBy(name = "assigned_group_id") private WebElement GroupDropdownValue;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement SaveBtn;
	
	
	//initialization
	
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	// Utilization
	
	public WebElement getOrgName() {
		return OrgNameTextBox;
	}


	public WebElement getIndustryname() {
		return Industryname;
	}


	public WebElement getOrgtype() {
		return Organizationtype;
	}


	public WebElement getAssignedToGrpRadioBtn() {
		return AssignedToGrpRadioBtn;
	}


	public WebElement getGroupValue() {
		return GroupDropdownValue;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	
	//Business Library
	
	/**
	 * This method will create org name and click on save 
	 * @param ORGNAME
	 */
	public void createNewOrg(String ORGNAME)
	{
		OrgNameTextBox.sendKeys(ORGNAME);
		SaveBtn.click();
		
	}
	
	/**
	 * This method will create orgnaization with industry name
	 * @param ORGNAME
	 * @param indName
	 */
	public void createNewOrg(String ORGNAME,String indName)
	{
		OrgNameTextBox.sendKeys(ORGNAME);
		handleDropDown(Industryname, indName);
		SaveBtn.click();
	}
	
	/**
	 * This method will create organization with Industry name and organization type
	 * @param ORGNAME
	 * @param IndTypeValue
	 * @param OrgTypeText
	 */
	public void createNewOrg(String ORGNAME,String  IndTypeValue,String OrgTypeText)
	{
		OrgNameTextBox.sendKeys(ORGNAME);
		handleDropDown(Industryname, IndTypeValue);
		handleDropDown(OrgTypeText, Organizationtype);
		SaveBtn.click();
	}
	
	/**
	 * This method will create organization with handling dropdown of industry name ,orgnanization type 
	 * Assigned to group and also radio button
	 * @param ORGNAME
	 * @param AssignedValue
	 * @param IndustryText
	 * @param OrgTypeValue
	 */
	public void createNewOrg(String ORGNAME, String AssignedValue,String IndustryText, String  OrgTypeValue)
	{
		OrgNameTextBox.sendKeys(ORGNAME);
		
		handleDropDown(IndustryText, Industryname);

		handleDropDown(Organizationtype,OrgTypeValue);
		
		AssignedToGrpRadioBtn.click();
		
		handleDropDown(GroupDropdownValue, AssignedValue);;
		
		SaveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
