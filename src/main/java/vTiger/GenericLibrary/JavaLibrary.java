package vTiger.GenericLibrary;

import java.util.Date;
import java.util.Random;

//single line comment
/* multiple line comment */
/** 
 * This Class will contain all generic methods related to java
 * @author AJAY G
 *
 */

public class JavaLibrary {
/**
 * This class will generate random number for every execution
 * @return
 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int value = ran.nextInt(500);
		return value;
	}
	/**
	 * This method will generate the system date
	 * @return 
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	public String getSystemdateInFormat()
	{
		Date d=new Date();
	      String[] dArray =d.toString().split(" ");
	      String month = dArray[1];
	      String date = dArray[2];
	      String year = dArray[5];
	      String time = dArray[3].replace(":", "-");
	    String dateInFormat = date+"-"+month+"-"+year+"-"+time;
	    return dateInFormat ;
	}
}
