package vTigerPractice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest
{
 @Test
 public void readData()
 {
	String BROWSER= System.getProperty("browser");
	String USERNAME=System.getProperty("username");
	System.out.println(BROWSER);
	System.out.println(USERNAME);
 }
}
