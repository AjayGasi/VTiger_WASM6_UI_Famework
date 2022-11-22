package vTigerPractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataWithExcelSheet {

	public static void main(String[] args) throws Throwable {
	
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataBook.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Contacts");
		Row rw=sh.getRow(4);
		Cell ce=rw.getCell(3);
		String value=ce.getStringCellValue();
		System.out.println(value);
		

}
}