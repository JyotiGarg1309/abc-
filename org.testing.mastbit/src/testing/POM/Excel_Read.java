package testing.POM;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel_Read {
	

	
	public static String output(int a,int b) throws  IOException, BiffException{
		File f =new File("C:\\Users\\Tamanna Sharma\\Desktop\\mastbit.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sheet = wb.getSheet("Sheet1");
		 
		Cell cell= sheet.getCell(a, b);
		String str=cell.getContents();
		
		return str;
	
	}

}
