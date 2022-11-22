package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverCommonLibrary;

public class CreateNewContactPage extends WebDriverCommonLibrary
{
	// Declaration
	
	@FindBy(name = "lastname") private WebElement LastnameTextBox;
	@FindBy(name = "leadsource") private WebElement LeadSourceDropdown;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement OrganizationImg;
	@FindBy(id = "search_txt") private WebElement SearchBoxText;
	@FindBy(name = "search") private WebElement SearchNowBtn;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement SaveBtn;
    
	// Initialization
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	// Utilization
	
	public WebElement getLastnameTextBox() {
		return LastnameTextBox;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}


	public WebElement getLeadSourceDropdown() {
		return LeadSourceDropdown;
	}
	
	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}


	public WebElement getSearchBoxText() {
		return SearchBoxText;
	}


	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}

	// Business Library

	/**
	 * This method will create new contact and click on save button
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		LastnameTextBox.sendKeys(lastname);
		SaveBtn.click();
	}
	
	/**
	 * This method will create new contact withlead source drop down
	 * @param lastname
	 * @param leadSourceValue
	 */
	public void createNewContact(String lastname, String leadSourceValue)
	{
		LastnameTextBox.sendKeys(lastname);
		handleDropDown(LeadSourceDropdown, leadSourceValue);
		SaveBtn.click();
	}
	
	/**
	 * This method will create contact with Organization
	 * @param lastname
	 * @param OrgName
	 * @param driver
	 */
	public void createNewContact(String lastname,String OrgName,WebDriver driver)
	{
		LastnameTextBox.sendKeys(lastname);
		OrganizationImg.click();
		switchToWindow(driver, "Accounts");
		SearchBoxText.sendKeys(OrgName);
		SearchNowBtn.click();
		//Dynamic Xpath -Because org name changes everytime 
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
	
	
	
}
