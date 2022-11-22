package pomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverCommonLibrary;
import vTiger.ObjectRepository.LoginPage;

public class LoginTest
{
 //public static void main(String[] args) throws Throwable 
	
	@Test
	
	public void loginTest() throws Throwable
 {
	 
	WebDriverCommonLibrary wLib=new WebDriverCommonLibrary();
	PropertyFileLibrary pLib=new PropertyFileLibrary();
	
	String URL = pLib.readDataFromPropertyFile("url");
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");

	WebDriver driver=new ChromeDriver();
	LoginPage lp=new LoginPage(driver);
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
lp.loginToApp(USERNAME, PASSWORD);
 }
}
