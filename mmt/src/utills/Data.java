package utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	static String path=System.getProperty("user.dir");
public Data(String wbook, String sheetname) throws IOException
{
	workbook=new XSSFWorkbook(wbook);
	sheet=workbook.getSheet(sheetname);
}
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		
	}

	public static void getdata(int row, int cell) throws IOException{
		
		int rows = sheet.getPhysicalNumberOfRows();
		String cellvalue = sheet.getRow(row).getCell(cell).getStringCellValue();
	     System.out.println("cell value is:"+cellvalue);
		
	}

}
