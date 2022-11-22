package vTiger.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide Implementation to all the abstract method in ItestListener
 * @author Ajay G
 *
 */
public class ListenerImplementationLibrary implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) //Run for every @Test Start
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log("Test Execution Started For :"+MethodName,true);
		test=report.createTest(MethodName); //test script  execution started in report
		test.log(Status.INFO, "Test Execution Started");
	}

	public void onTestSuccess(ITestResult result)   // when test is passed
	{
		String MethodName=result.getMethod().getMethodName();
		//System.out.println("Test is Successfull for :"+MethodName);
		test.log(Status.PASS, MethodName+" Is Passed");
	}

	public void onTestFailure(ITestResult result)   // when test is failed
	{
		WebDriverCommonLibrary wLib=new WebDriverCommonLibrary();
		JavaLibrary jLib=new JavaLibrary();
		
		String MethodName=result.getMethod().getMethodName()+jLib.getSystemdateInFormat();
		//System.out.println("Test is Failed for :"+MethodName);
		test.log(Status.FAIL, MethodName+" Is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
	
			try {
				String path = wLib.takeScreenShot(BaseClass.lDriver, MethodName);
				test.addScreenCaptureFromPath(path);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result)    // when test is skipped
	{
		String MethodName=result.getMethod().getMethodName();
	  //ystem.out.println("Test is Skipped for :"+MethodName);
		
		test.log(Status.SKIP, MethodName+" Is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
    }

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
	 Reporter.log("Execution of Suite Started", true);
	
	 //Execution starts from here, hence configure the extent report here  (Format: Report-11-11-2022-11-00.html)
	  ExtentSparkReporter htmlReport =new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaLibrary().getSystemdateInFormat()+".html");
	  htmlReport.config().setDocumentTitle("Execution  Reports For Vtiger");
	  htmlReport.config().setTheme(Theme.DARK);
	  htmlReport.config().setReportName("vTiger Executioin Reports");
	  
	 // Attach the Reports to ExtentReports
	  report=new ExtentReports();
	  report.attachReporter(htmlReport);
	  report.setSystemInfo("Base Browser", "Chrome");
	  report.setSystemInfo("Base Environment", "Testing");
	  report.setSystemInfo("Base URL", "http://localhost:8888");
	  report.setSystemInfo("Base Platform", "Windows");
	  report.setSystemInfo("Reporter Name", "Ajay");
	}

	public void onFinish(ITestContext context) 
	{
		Reporter.log("Execution of Suite Finished",true);
		
		//Flush the Report  :Here the Execution is Finished
		report.flush();
	}

	
}
