package vTigerPractice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrg {
	/**
	 * @param args
	 * @throws Throwable
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL= prop.getProperty("url");
		String USERNAME=prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");
		
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestDataBook.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Organization");
		Row rw=sh.getRow(4);
		Cell ce=rw.getCell(2);
		 String ORGNAME = ce.getStringCellValue();
		 
		 FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\TestDataBook.xlsx");
		  Workbook wb1=WorkbookFactory.create(fis2);
		  Sheet sh1=wb1.getSheet("Contacts");
		  Row rw1=sh1.getRow(1);
		  Cell ce1=rw1.getCell(2);
		 String LN = ce1.getStringCellValue();
		 
		 Random ran=new Random();
		 int num = ran.nextInt(500);
		 
		String ORG = ORGNAME+num;
		 
		 WebDriver driver=null;
		 if (BROWSER.equalsIgnoreCase("chrome"))
		 {
			driver=new ChromeDriver();
			
		}
		 
		 else if (BROWSER.equalsIgnoreCase("firefox"))
        {
		   driver=new FirefoxDriver();
		}
		 
		 else
		 {
			System.out.println("Invalid Browser Name");
		 }
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		// Login to the Application
		   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		   driver.findElement(By.id("submitButton")).click();
		   
	 // Navigate to Organizations	
		   driver.findElement(By.linkText("Organizations")).click();
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		   driver.findElement(By.name("accountname")).sendKeys(ORG);
		   Thread.sleep(3000);
		   
    // Navigate to Contacts
		   driver.findElement(By.linkText("Contacts")).click();
		   
			// check with mandatory fields
			    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			    driver.findElement(By.name("lastname")).sendKeys(LN);
		 
		   
		   //switch to new window
		   
		  String ParentWindowHandle = driver.getWindowHandle();
		  System.out.println("Parent window Handle"+ ParentWindowHandle);
		 String ParentTitle = driver.getTitle();
		 System.out.println(ParentTitle);
		   driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/img")).click();
           Set<String> windowhandles = driver.getWindowHandles();
           
           for (String windowHandle : windowhandles) 
           {
        	   System.out.println(windowHandle);
        	   if (!windowHandle.equals(ParentWindowHandle)) 
        	   {
        		   driver.switchTo().window(windowHandle);
        			 String ChildTitle = driver.getTitle();
               	    System.out.println(ChildTitle);
        		  driver.findElement(By.linkText("Wipro")).click();
        		
			}
        	
        	//  String ChildTitle = driver.getTitle();
        	//  System.out.println(ChildTitle);
			
		    }
           driver.switchTo().window(ParentWindowHandle);
           Thread.sleep(3000);
           driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			
        //Sign out
          WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
          Actions act=new Actions(driver);
          act.moveToElement(signout).perform();
          driver.findElement(By.linkText("Sign Out")).click();
          
           
		}
	}


