package vTigerPractice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngPractice 
{
	@Test                              //(invocationCount = 3  ,priority = 1)    //executes the lowest value first
	public void createCustomer()
	{
		//Assert.fail();
		System.out.println("Customer Created");
	}

	@Test (dependsOnMethods = "createCustomer")               // (priority=2)        //default value=0 
	public void modifyCustomer()
	{
		Assert.fail();
		System.out.println("Customer Modified");
	}
	
	@Test   (dependsOnMethods = {"createCustomer","modifyCustomer"})           //(priority=3)      // highest value last
	public void deleteCustomer() 
	{
		System.out.println("Customer Deleted");
	}
}
