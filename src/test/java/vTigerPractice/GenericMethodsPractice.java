package vTigerPractice;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;

public class GenericMethodsPractice {
	public static void main(String[] args) throws Throwable {
	
		JavaLibrary jlib=new JavaLibrary();
		PropertyFileLibrary flib=new PropertyFileLibrary();
		ExcelFileLibrary elib=new ExcelFileLibrary();
		
		
		String date = jlib.getSystemDate();
		System.out.println(date);
		String date1 = jlib.getSystemdateInFormat();
		System.out.println(date1);
		
		
		String value = flib.readDataFromPropertyFile("browser");
		System.out.println(value);
		String USERNAME = flib.readDataFromPropertyFile("username");
		System.out.println(USERNAME);
		
		
	    String val=elib.readDataFromExcel("Organization", 1, 2);
		System.out.println(val);
		int rc = elib.getRowCount("Contacts");
		System.out.println(rc);
		
		elib.writeDataIntoExcel("Organization", 7, 8, "AJAY");
	}
	
	
	

	  
}