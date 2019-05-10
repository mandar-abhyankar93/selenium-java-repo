package filereaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSVFileReader {

	private static Map<String, Integer> headerMap = new HashMap<String, Integer>();
	private static String[] dataArray;
	private static String tempLineString;
	private static String[] tempArray = null;;
	static Scanner sc;

	public static void readCSVFile(String csvFilePath, String scenarioName) {
		try {
			sc = new Scanner(new File(csvFilePath));
			while (sc.hasNextLine()) {
				tempLineString = sc.nextLine();
				tempArray = tempLineString.split(",");
				if (tempArray[0].equals("#ScenarioName")) {
					for (int i = 1; i < tempArray.length; i++) {
						headerMap.put(tempArray[i], i);
					}

				} else {
					if(tempArray[0].equals(scenarioName)) {
					dataArray = tempLineString.split(",");
					break;
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
		}
	}

	public static String getValue(String columnName) {
		return dataArray[headerMap.get(columnName)];
	}

	public CSVFileReader(String filePath, String scenario) {

		CSVFileReader.readCSVFile(filePath, scenario);
	}

}
