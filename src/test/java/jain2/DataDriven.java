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

public class DataDriven {

	public ArrayList<String> getData(String TestCaseName) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		// XSSFWorkbook

		FileInputStream fls = new FileInputStream(
				"C:\\Users\\GauravJain\\Desktop\\Udemy Trainings\\workspace\\DemoSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fls);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

				while (rows.hasNext()) {
					Row firstrow = rows.next();

					Iterator<Cell> ce = firstrow.cellIterator();
					int k = 0;
					int column = 0;
					while (ce.hasNext()) {
						Cell Value = ce.next();

						if (Value.getStringCellValue().equalsIgnoreCase("TestCases")) {
							column = k;

						}
						k++;

						while (rows.hasNext()) {
							Row r = rows.next();
							if (r.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName)) {

								Iterator<Cell> cv = r.cellIterator();

								while (cv.hasNext()) {
									Cell c = cv.next();

									if (c.getCellType() == CellType.STRING) {
										a.add(c.getStringCellValue());
									}
									
									else {
										
										a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
										
									}
								}

							}

						}

					}

				}

			}

		}
		return a;

	}

}
