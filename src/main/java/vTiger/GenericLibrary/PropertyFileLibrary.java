package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains generic methods related to property file
 * @author Ajay G
 *
 */
public class PropertyFileLibrary {
	/**
	 * This method will read the data from property file given by the user
	 * @param key
	 * @return
	 * @throws Throwable
	 */

    public String readDataFromPropertyFile(String key) throws Throwable
    {
    	FileInputStream fis=new FileInputStream(IAutoConstantsLibrary.PropPath);
    	Properties prop=new Properties();
    	prop.load(fis);
    	String value = prop.getProperty(key);
    	return value;
    }
}
