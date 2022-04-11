package jain2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfiledata {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\GauravJain\\Desktop\\Udemy Trainings\\workspace\\DemoSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("testdata"))
	
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				
				Iterator<Cell> ce = firstrow.cellIterator();
				
				int k=0;
				int column=0;
				while(ce.hasNext()) {
					
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
					}
					k++;
					
					while(rows.hasNext()) {
						
						Row r =	rows.next();
						
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase("signIn")) {
							
							Iterator<Cell> cv = r.cellIterator();
							
							while(cv.hasNext()) {
								
							Cell c=  cv.next();
							
							if (c.getCellType() == CellType.STRING) {
							System.out.println(c.getStringCellValue());
							}
							}
						}
						
					}
					
				}
				
			}

			
		}

	
		
		
		
	}

}
