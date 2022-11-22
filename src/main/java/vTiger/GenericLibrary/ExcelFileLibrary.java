package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class contains generic methods that read and write data into the Excel
 * @author Ajay G
 *
 */

public class ExcelFileLibrary {
	/**
	 * This method will read data from excel for sheet name, row num and cell num given by the user
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis =new FileInputStream(IAutoConstantsLibrary.ExcelPath);
    	Workbook wb=WorkbookFactory.create(fis);
    	Sheet sh=wb.getSheet(sheetName);
    	Row rw=sh.getRow(rowNum);
    	Cell ce=rw.getCell(cellNum);
    	String value = ce.getStringCellValue();
    	wb.close();
    	return value;
		
	}
	
	/**
	 * This method will provide last row number utilized in a given sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis1=new FileInputStream(IAutoConstantsLibrary.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	/**
	 * This method will write data into the excel sheet for user specified sheet ,row num and cell num
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	
	public void writeDataIntoExcel(String sheetName,int rowNum,int cellNum, String value) throws Throwable
	{
		FileInputStream fis =new FileInputStream(IAutoConstantsLibrary.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNum);
		 Cell cell=rw.createCell(cellNum);
		  cell.setCellValue(value);
		
		  FileOutputStream fos=new FileOutputStream(IAutoConstantsLibrary.ExcelPath);
		  wb.write(fos);
		  wb.close();
		  System.out.println("Data Written Successfully");	
	}
	
   
	/**
	 * This method will multiple data from excel sheet
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IAutoConstantsLibrary.ExcelPath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
