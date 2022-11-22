package vTigerPractice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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




public class CreateContactWithDDT {

	public static void main(String[] args) throws Throwable {
		//Step1:Read the required data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop =new Properties();
		prop.load(fis);
		 String BROWSER = prop.getProperty("browser");
		// System.out.println(BROWSER);
		 String URL= prop.getProperty("url");
		// System.out.println(URL);
		 String USERNAME=prop.getProperty("username");
		// System.out.println(USERNAME);
		 String PASSWORD=prop.getProperty("password");
		// System.out.println(PASSWORD);
		 
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestDataBook.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh =wb.getSheet("Contacts");
		Row rw= sh.getRow(1);
		 Cell ce= rw.getCell(2);
		 String LASTNAME =ce.getStringCellValue();
		 //  System.out.println(value);
		
		//Step:2 Launch the Browser --RUNTIME POLYMORPHISM
		   WebDriver driver=null;
		   if(BROWSER.equalsIgnoreCase("chrome"))
		   {
		 //  WebDriverManager.chromedriver().setup();
		   driver= new ChromeDriver();
		 //  System.out.println("#####"+BROWSER+"####");
		   }
		   
		   else if(BROWSER.equalsIgnoreCase("firefox"))
		   {
			  driver=new FirefoxDriver();
			  System.out.println("####"+BROWSER+"####");
		   }
		   
		   else {
			   System.out.println("Invalid Browser Name");
		   }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		//Step:3 Login to the Application
		   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		   driver.findElement(By.id("submitButton")).click();
	 //Step 4: Navigate to contacts link
		   driver.findElement(By.linkText("Contacts")).click();
		   
		//step5 check with mandatory fields
		    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		    driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		    
		//step 6 Save the last name
		    driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		    
	//step 7 logout by performing mouse hover actions
		    WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		    Actions act=new Actions(driver);
		    act.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
