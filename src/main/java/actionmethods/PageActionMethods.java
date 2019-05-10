package actionmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import filereaders.CSVFileReader;
import helper.SeleniumPageHelper;

public class PageActionMethods extends SeleniumPageHelper {
	
	String dataFilePath = "data/data.csv"; 
	
	public String getPageData(String scenarioName, String columnName) {
		
		CSVFileReader.readCSVFile(dataFilePath, scenarioName);
		return CSVFileReader.getValue(columnName);
		
	}
	

	public void enterTextIntoField(WebDriver driver, By element, String text) {

		waitForElement(driver, element, 10);
		driver.findElement(element).sendKeys(text);
	}

	public void clickOnButton(WebDriver driver, By element) {

		waitForElement(driver, element, 10);
		driver.findElement(element).click();

	}
	
	public void clickOnLink(WebDriver driver, By element) {

		waitForElement(driver, element, 10);
		driver.findElement(element).click();

	}

}
