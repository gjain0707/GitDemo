package jain2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriverPractice {

	public static void main(String[] args) throws IOException {
		//Fileinputstream will have access to read the file
		FileInputStream fis = new FileInputStream("C:\\Users\\GauravJain\\Desktop\\Udemy Trainings\\workspace\\DemoSheet.xlsx");
		
		//by passing fis as argument XSSFworkbook will know the file location.
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//getting number of sheets
		int sheets = workbook.getNumberOfSheets();
		
		
		for(int i=0; i<sheets;i++) {
			//name of the sheet which we need to access
			if( workbook.getSheetName(i).equalsIgnoreCase("testdata"));
			{
				//getting access to test data sheet
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//Iterating through row
			Iterator<Row> rows =	sheet.iterator();
				
			}
			
		}
		
		
	}

}
