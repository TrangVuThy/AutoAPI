package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		ArrayList<String> arrays = getExelValue("Sheet1", "Item");
		for (String i : arrays) {
			System.out.println(i);

		}
	}

	public static ArrayList<String> getExelValue(String sheets, String rowStartName) throws IOException {
		ArrayList<String> array = new ArrayList<>();

		// Đưa đường dẫn file
		FileInputStream file;

		file = new FileInputStream("./src/test/java/data_test/Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// lấy ra số lượng sheet trong workbook
		int noOfSheet = workbook.getNumberOfSheets();
		for (int i = 0; i < noOfSheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheets)) {
				// Lấy toàn bộ giá trị trong sheet
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = null;

				while (rows.hasNext()) {
					firstRow = rows.next();
					Iterator<Cell> cells = firstRow.cellIterator();
					while (cells.hasNext()) {
						// nhảy vào cell
						Cell cellValue = cells.next();
						if (cellValue.getStringCellValue().equalsIgnoreCase(rowStartName)) {
							while (cells.hasNext()) {
								Cell cellValueData = cells.next();
								array.add(cellValueData.getStringCellValue());
							}

						}

					}
				}
			}

		}
		return array;
	}

}