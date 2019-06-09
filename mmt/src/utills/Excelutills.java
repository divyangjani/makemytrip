package utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutills {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	static String path=System.getProperty("user.dir");
public Excelutills(String wbook, String sheetname) throws IOException
{
	workbook=new XSSFWorkbook(wbook);
	sheet=workbook.getSheet(sheetname);
}
	

	public static String getdata(int row, int cell) throws IOException{
		
	  String cellvalue = sheet.getRow(row).getCell(cell).getStringCellValue();
	    // System.out.println("cell value is:"+cellvalue);
		return cellvalue;
		
	}
	public int rows_count() {
		int rows = sheet.getPhysicalNumberOfRows();
	
		return rows;
	}
	
	public int col_count(){
		
		int cellnum =sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("total number of cells are:"+cellnum);
		return cellnum;
		
	}

}
