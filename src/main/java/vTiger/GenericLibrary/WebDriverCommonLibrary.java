package vTiger.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class will contain all the generic methods related to webdriver actions
 * @author Dell
 *
 */

 public class WebDriverCommonLibrary 
 {
	
	/**
	 * This method will close the browser
	 * @param driver
	 */
	 
	 public void closeBrowser(WebDriver driver)
	 {
		driver.close();
	 }
		
	 /**
	 * This method will maximize the window
	 * @param driver
	 */
	
	 public void maximizeWindow(WebDriver driver)
	 {
	 	driver.manage().window().maximize();
	 }
	
 	 /**
	 * This method will minimize the window
	 * @param driver
	 */

     public void minimizeWindow(WebDriver driver)
     {
    	driver.manage().window().minimize();
     }
    
    
	/**
	 * This method will wait for 20 seconds to load the page
	 * @param driver
    */
	
	 public void waitForPageLoad(WebDriver driver)
	 {
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 }

	
	 /**
	 * This method will wait for 10 seconds for the element to be clickable
	 * @param driver
	 * @param element
	 */
	
	 public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	 {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.visibilityOf(element));
	 }
	
	
	/**
	 * This method will wait for 10 seconds for the element to be clickable
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	
	/**
	 * This is custom wait which is used to wait for element and perform click action
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void waitAndClickOnElement(WebElement element) throws InterruptedException
	{
		int count=0;
		while (count<10)
		{
			 try 
			 {
				 element.click();
				 break;
				
			 }
			 catch (Exception e) 
			 {
				Thread.sleep(2000);
				count++;
			 }
			
		}
	}

	
     /**
     * this method will handle drop down through select class and select data by index
     * @param element
     * @param index
     */

     public void handleDropDown(WebElement element, int index)
     {
	  Select sel=new Select(element);
	  sel.selectByIndex(index);
     }
     
     
     /**
      * this method will handle drop down througgh select class and select data by value
      * @param element
      * @param value
      */
     public void handleDropDown(WebElement element ,String value)
     {
    	 Select sel=new Select(element);
    	 sel.selectByValue(value);
     }
     
     
     /**
      * This this method will handle drop down througgh select class and select data by text
      * @param text
      * @param element
      */
     public void handleDropDown(String text,WebElement element)
     {
    	 Select sel=new Select(element);
    	 sel.selectByVisibleText(text);
     }
     
     
     /**
      * This method will perform mouse hover by using Actions class
      * @param driver
      * @param element
      */
     public void mouseHoverOn(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).perform();
     }
     
     
     /**
      * This method will perform right click on a webpage by using Actions class
      * @param driver
      */
     public void rightClickOn(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick().perform();
     }
     
     
     /**
      * This method will perform right click on a particular web element by using Actions class
      * @param driver
      * @param element
      */
     public void rightClickon(WebDriver driver, WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick(element).perform();
     }
     
     
     /**
 	 * This method will perform double click on web page by using Actions class
 	 * @param driver
 	 */
 	public void doubleClickOn(WebDriver driver)
 	{
 		Actions act = new Actions(driver);
 		act.doubleClick().perform();
 	}
     
     
 	/**
 	 * This method will perform double click on a particular web element by using Actions class
 	 * @param driver
 	 * @param element
 	 */
     public void doubleClickOn(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.doubleClick(element).perform();
     }
     
     
     /**
      * This method will drag and drop from source element to destination element by using Actions class
      * @param driver
      * @param srcElement
      * @param destElement
      */
     public void dragAndDropOn(WebDriver driver,WebElement srcElement,WebElement destElement)
     {
    	 Actions act=new Actions(driver);
    	 act.dragAndDrop(srcElement, destElement).perform();
     }
     
     
     /**
      * This is method will mouse hover using offset value for x and y co-ordinates
      * @param driver
      * @param xOff
      * @param yOff
      */
     public void mouseHoverOn(WebDriver driver,int xOff,int yOff)
     {
    	 Actions act= new Actions(driver);
    	 act.moveByOffset(xOff, yOff).perform();
     }
     
     
     /**
      * This method will switch to frame based on index
      * @param driver
      * @param index
      */
     public void switchToFrame(WebDriver driver,int index)
     {
    	 driver.switchTo().frame(index);
     }
     
     
     /**
      * This method will switch to frame based on name or Id
      * @param driver
      * @param nameOrId
      */
     public void switchToFrame(WebDriver driver,String nameOrId)
     {
    	 driver.switchTo().frame(nameOrId);
     }
     
     
     /**
      * This method will switch to frame based on element
      * @param driver
      * @param element
      */
     public void switchToFrame(WebDriver driver,WebElement element)
     {
    	 driver.switchTo().frame(element);
     }
     
     
     /**
      * This method will switch from current frame to immediate parent frame
      * @param driver
      */
     public void switchToParentFrame(WebDriver driver)
     {
    	 driver.switchTo().parentFrame();
     }
     
     
     /**
      * This method will switch from current frame to default frame
      * @param driver
      */
     public void switchToDefaultFrame(WebDriver driver)
     {
    	 driver.switchTo().defaultContent();
     }
     
     
     /**
      * This method will click accept in alert popup
      * @param driver
      */
     public void acceptAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().accept();
     }
     
     
     /**
      * This method will click dismiss in alert popup
      * @param driver
      */
     public void dismissAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().dismiss();
     }
     
     
     /**
      * This method will return the text of alert popup to the caller
      * @param driver
      */
     public void getAlertText(WebDriver driver)
     {
    	 driver.switchTo().alert().getText();
     }
     
     
     /**
      * This method will write the  text to the alert popup that is given the user
      * @param driver
      * @param text
      */
     public void writeTextinAlertPopup(WebDriver driver,String text)
     {
    	 Alert a = driver.switchTo().alert();
    	 a.sendKeys(text); 
     }
     
     
     /**
      * This method will press the enter key
      * @throws AWTException
      */
     public void pressEnter() throws AWTException
     {
    	 Robot rob=new Robot();
    	 rob.keyPress(KeyEvent.VK_ENTER);
    	 rob.keyRelease(KeyEvent.VK_ENTER);
     }
   
     
     
     public void switchToWindow(WebDriver driver,String partialWindowTitle)
     {
    	 //Step:1 Get all the window Handles
    	 Set<String> windIDs = driver.getWindowHandles();
    	 
    	 //Step:2 Iterate through all the windowIDs ---Similar to for each loop
       	Iterator<String> it = windIDs.iterator();
     
       	//Step:3 Navigate to each window and check the title
       	while (it.hasNext())
       {
       	//Step:4 Capture the individual window  id    
       		String winID = it.next();
       		
       	//Step : 5  Switch to the window and capture the title
       		String currentTitle = driver.switchTo().window(winID).getTitle();
       		
       	//Step:6 Compare current title with partial title
       		if(currentTitle.contains(partialWindowTitle))
       		{
       			break;
       		}
       		
		}
       	
	}
     
     
    //Type :2 
     
  /*  public void switchToWindow( String partialWindowTitle ,WebDriver driver)
    {
    	Set<String> allWindowIds = driver.getWindowHandles();
    	for (String oneWindowID : allWindowIds) 
    	{
			String currentTitle = driver.switchTo().window(oneWindowID).getTitle();
			if (currentTitle.contains(partialWindowTitle)) 
			{
				break;
			}
		}
			
		}
    }
     
   */  
     
     
     /**
      * This method will take ScreenShots
      * @param driver
      * @param screenShotName
      * @return
      * @throws IOException
      */
     public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
     {
    	 TakesScreenshot ts=(TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	 File dest=new File(".\\ScreenShots\\"+screenShotName +".png");
    	 FileUtils.copyFile(src, dest);  // From Apache commons.io
       //  Files.copy(src, dst);         // From Google common io
    	 
    	 return dest.getAbsolutePath();  // Used For Extends Reports
     }
     
     
     /**
      * This method will scroll down for 500 units
      * @param driver
      */
     public void scrollDown(WebDriver driver)
     {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy0(,500)","");
     }
     
     
     /**
      * This method will scroll down until a specified element is found
      * @param driver
      * @param element
      */
     public void scrollAction(WebDriver driver, WebElement element)
     {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	// js.executeScript("arguments[0].scrollIntoView();", element);
    	 int y = element.getLocation().getY();
    	 js.executeScript("window.scrollBy(0, "+y+")", element);  
     }
   

}  