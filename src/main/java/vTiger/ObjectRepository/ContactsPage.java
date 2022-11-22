package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
   
	// Declaration
   
	//@FindBy(xpath = "//img[@alt='Create Contact...']") private WebElement CreateContactLookUpImg;
	
      @FindAll({@FindBy(xpath = "//img[@alt='Create Contact...']"),@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")})
      private WebElement CreateContactLookUpImg;
	//Initialization
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Utilization
	
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	
	
	// Business Library
	
	/**
	 * This method will click on create contact look up image
	 */
	public void clickCreateContactLookUpImg()
	{
		CreateContactLookUpImg.click();
	}
	
}
