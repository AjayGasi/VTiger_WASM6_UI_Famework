package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage
{
	// Declaration
	
	@FindBy(className = "dvHeaderText") private WebElement contactHeaderText;
	
	// Initialization
	
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Utilization
	
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}

	
	// Business Library
	
	/**
	 * This method will get the header text and return it to the caller
	 * @return
	 */
	public String getContactHeader()
	{
		return contactHeaderText.getText();
	}
	
}
