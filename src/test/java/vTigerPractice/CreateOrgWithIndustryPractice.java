package vTigerPractice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryPractice {
	public static void main(String[] args) throws Throwable {
       
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
		 
		   
		   
  // select industry
		 WebElement DD = driver.findElement(By.name("industry"));
		 Select sel=new Select(DD);
		 sel.selectByValue("Healthcare");
		 DD.click();
 // save
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
