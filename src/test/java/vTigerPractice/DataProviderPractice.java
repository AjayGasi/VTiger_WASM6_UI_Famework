package vTigerPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
   @Test (dataProvider = "Mobiles",enabled=false)
   
   public void addToCartTest(String name,String model,int price,int quantity)
   {
	   System.out.println("Phone name :" +name+" Model :"+model+" Price : "+price+" Quantity :"+quantity );
   }
   
  @Test (dataProvider = "Phones")
   
   public void addToCartTest(String name,String model,int price,int quantity,String source)
   {
	   System.out.println("Phone:" +name+" Model :"+model+" Price : "+price+" Quantity :"+quantity +" Source :"+ source);
   }
   
   @DataProvider(name= "Mobiles")
   public Object getData()
   {

	   Object [][] data=new Object[3][4];
	   
	   data[0][0]="Samsung";
	   data[0][1]="A80";  
	   data[0][2]=28000;
	   data[0][3]=5;
		   
	   data[1][0]="Apple";
	   data[1][1]="14Pro";  
	   data[1][2]=128000;
	   data[1][3]=10;
	  
	   
	   data[2][0]="Vivo";
	   data[2][1]="V21Pro";  
	   data[2][2]=25000;
	   data[2][3]=15;
	
	   
	   return data;   
   }
   
   
   @DataProvider(name= "Phones")
   public Object getData1()
   {
	   Object [][] data=new Object[3][5];
	   
	   data[0][0]="Samsung";
	   data[0][1]="A80";  
	   data[0][2]=28000;
	   data[0][3]=5;
	   data[0][4]="flipkart";
	   
	   data[1][0]="Apple";
	   data[1][1]="14Pro";  
	   data[1][2]=128000;
	   data[1][3]=10;
	   data[1][4]="Amazon";
	   
	   data[2][0]="Vivo";
	   data[2][1]="V21Pro";  
	   data[2][2]=25000;
	   data[2][3]=15;
	   data[2][4]="Myntra";
	   
	   return data;   
   }
}
