package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

//Rule :1 create a separate java class for every web opened

public class LoginPage
{
	//Step:2 Identify elements using @FindBy ,@FindBys and @FindAll
	
	@FindBy(name = "user_name" )
	private WebElement UNTB;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement PWTB;
	
	//@FindBys({@FindBy(name="user_password"),@FindBy(xpath = "//input[@type='password']")})
	//private WebElement PWTB;
	
    @FindBy(id ="submitButton")
    private WebElement loginBtn;
    
   // Rule:3 Create constructor to initialize these variables
    
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }


   // Rule:4 Create Getter methods to access these variables
    
	public WebElement getUNTB() {
		return UNTB;
	}

	public WebElement getPWTB() {
		return PWTB;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
    
	
 // Business Library (Generic method)
	
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	
	public void loginToApp(String username,String password)
	{
		UNTB.sendKeys(username);
		PWTB.sendKeys(password);
		loginBtn.click();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
