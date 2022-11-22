package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage 
{

	// Declaration
	@FindAll({@FindBy(xpath = "//img[@alt='Create Organization...']"),
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")})
	  private WebElement CreateOrgLookUpImg;
	
	//Initialization
	
	public OrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	public WebElement getOrgLookUpImg() 
	{
		return CreateOrgLookUpImg;
	}
	
		
	//Business Library
	
	/**
	 * This method will click on Organization Look up Image
	 */
	public void clickOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
}
