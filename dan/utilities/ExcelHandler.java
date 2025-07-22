package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {

	public static int lastrow(String path, String sheet ) 
	{
		try
		{
		File f= new File(path);
		FileInputStream f1=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sh=wb.getSheet(sheet);
		
		int n=sh.getLastRowNum();
		 return n;
		
	}
		catch(Exception e)
		{
			return 0;
		}



public static String details(String path, String sheet, int i, int m )
{
	try {
		File f= new File(path);
		FileInputStream f1=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sh=wb.getSheet(sheet);
		XSSFCell cell=sh.getRow(i).getCell(m);
		
		if(cell.getCellType()==CellType.STRING)
		{
		return sh.getRow(i).getCell(m).getStringCellValue();	
		}
		
		else
		{
			return sh.getRow(i).getCell(m).getRawValue();
		}
	}
	catch(Exception e)
	{
		return " ";
		}
}
}