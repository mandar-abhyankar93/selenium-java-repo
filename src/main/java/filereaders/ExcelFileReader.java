package filereaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	static Workbook excelWorkBook = null;
	static Sheet excelSheet = null;
	static int rowCount;
	static DataFormatter df;
	static HashMap<String,String> dataMap = new HashMap<String,String>();
	static String[] colNames;
	static String[] colValues;

	public static void readExcel(String filePathWithFileName, String sheetName) throws IOException {

		df = new DataFormatter();
		File exFile = new File(filePathWithFileName);
		FileInputStream fis = new FileInputStream(exFile);
		String fileExtn = filePathWithFileName.substring(filePathWithFileName.indexOf("."));
		if(fileExtn.equals(".xlsx")) {
			excelWorkBook = new XSSFWorkbook(fis);
		}
		else {
			excelWorkBook = new HSSFWorkbook(fis);
		}
		
		excelSheet = excelWorkBook.getSheet(sheetName);
		rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();
		for(int r=0;r<=rowCount;r++) {
			if(r==0) {		
				Row cNames = excelSheet.getRow(r);
				int cCounter = 0;
				colNames = new String[cNames.getLastCellNum()-2];
				for(int c=2;c<cNames.getLastCellNum();c++) {
					Cell cell;
					cell = cNames.getCell(c);
					colNames[cCounter] = df.formatCellValue(cell);
					cCounter = cCounter + 1;
				}
				
			}
			else {
				Row dataRow = excelSheet.getRow(r);
				int dCounter = 0;
				colValues = new String[dataRow.getLastCellNum()-2];
				if(dataRow.getCell(1).getStringCellValue().equals("Y")) {
					
					for(int c=2;c<dataRow.getLastCellNum();c++) {
						Cell cell;
						cell = dataRow.getCell(c);
						colValues[dCounter] = df.formatCellValue(cell);
						dCounter = dCounter + 1;
					}
					
				}
			}
		}
		
		for(int x = 0;x<colNames.length;x++) {
			dataMap.put(colNames[0], colValues[0]);
		}
		
	}
	
	public static String getValue(String key) {
		return dataMap.get(key);
	}
	
	public static void main(String[] args) throws IOException {
		
		ExcelFileReader.readExcel("C:\\Users\\mabhyankar\\Desktop\\Testexcel.xlsx", "Sheet1");
		System.out.println(ExcelFileReader.getValue("Name"));
	}

}
