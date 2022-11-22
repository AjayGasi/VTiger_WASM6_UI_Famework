package vTigerPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestPractice 
{
    @Test(dataProvider = "orgnames")
    public void createOrganization(String OrgName,String Industry)
    {
    	System.out.println(OrgName +"=" +Industry);
    }
    
    @DataProvider(name="orgnames")
    public Object organization()
    {
    	Object[][] data=new Object[4][2];
    	
    	data[0][0]="Qspiders";
    	data[0][1]="Testing";
    	
    	data[1][0]="Infosys";
    	data[1][1]="Ecommerce";
    	
    	data[2][0]="Wipro";
    	data[2][1]="Banking";
    	
    	data[3][0]="Tcs";
    	data[3][1]="HealthCare";
    	
    	return data;
    	
    }
}
