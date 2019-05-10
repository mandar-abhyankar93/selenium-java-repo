package tests;

import org.testng.annotations.Test;

import filereaders.CSVFileReader;

public class TestCSVReader {
	
	@Test
	public void testMethod(){
		String filePath = "C:\\Users\\mabhyankar\\Desktop\\File1.csv";
		
		CSVFileReader re = new CSVFileReader(filePath, "Sc1");
		System.out.println(re.getValue("Name"));
		CSVFileReader re1 = new CSVFileReader(filePath, "Sc2");
		System.out.println(re1.getValue("Name"));
	}

}
