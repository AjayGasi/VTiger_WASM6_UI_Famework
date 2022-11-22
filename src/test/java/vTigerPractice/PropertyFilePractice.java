package vTigerPractice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws Throwable {
        FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
        prop.load(fis);
        String BROWSER= prop.getProperty("browser");
        System.out.println(BROWSER);
       String URL = prop.getProperty("url");
       System.out.println(URL);
	}
}
