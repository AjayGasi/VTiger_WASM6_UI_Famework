package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage
{
   //Declaration
	
	@FindBy(className = "dvHeaderText") private WebElement OrgHeaderText;
	
	//Initialization
	
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}

	//Business Library
	
	/**
	 * This method will get header text and return it to the caller
	 * @return
	 */
	public String getOrgHeader()
	{
		return OrgHeaderText.getText();
	}
	
}


