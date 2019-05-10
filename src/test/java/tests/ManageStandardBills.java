package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helper.SeleniumPageHelper;

public class ManageStandardBills {

	static WebDriver driver;
	private static By username = By.name("USER");
	private static By password = By.name("CLIENT_PASSWORD");
	private static By system = By.name("DATABASE");
	private static By loginbutton = By.id("loginBtn");
	private static By searchappsbox = By.id("appFltrFld");
	private static By managestandardbills = By.xpath("//div[contains(text(),'Manage Standard Bills (BLMGBILL)')]");
	private static By projectinput = By.xpath("//input[@id='basicField0']");
	private static By findButton = By.xpath("//button[@id='submitQ']");
	private static By selectProject = By.xpath("//input[@id='PROJ_ID-_0_E']/../preceding-sibling::div");
	private static By invoiceNumberText = By.xpath("//span[contains(text(),'Invoice Number')]");
	private static By actionMenuDropdown = By.xpath("//div[@title='Action Menu']");
	private static By calculateTaxButton = By.xpath("//span[contains(text(),'Calculate Tax')]");
	private static By sendForApprovalButton = By.xpath("//span[contains(text(),'Ready to send for Approval')]");
	private static By messagePopUp = By.xpath("//div[contains(text(),'Message(s)')]");
	private static By closeMessagePopUpButton = By.xpath("//div[contains(text(),'Message(s)')]/preceding-sibling::div");
	private static By mainFormClose = By.xpath("//div[@id='rsCls']");
	String temp;
	String[] projs = { "AIR00114.00.02", "1RC10000.00.01", "ARM12002.00.01" };

	@BeforeClass
	public void setUp() {

		driver = SeleniumPageHelper.openBrowserWithURL("Chrome", "https://qcpswift.deloitte.com/CPWeb/");

	}

	@Test
	public void test() throws InterruptedException {

		SeleniumPageHelper.waitForElement(driver, username, 20);
		driver.findElement(username).sendKeys("MABHYANKAR");

		SeleniumPageHelper.waitForElement(driver, password, 20);
		driver.findElement(password).sendKeys("nDLHOUu78@");

		SeleniumPageHelper.waitForElement(driver, system, 20);
		driver.findElement(system).sendKeys("SCPQ");

		SeleniumPageHelper.waitForElement(driver, loginbutton, 20);
		driver.findElement(loginbutton).click();

		SeleniumPageHelper.waitForElement(driver, searchappsbox, 100);
		Thread.sleep(3000);
		driver.findElement(searchappsbox).clear();
		driver.findElement(searchappsbox).sendKeys("Manage Standard Bills");

		SeleniumPageHelper.waitForElement(driver, managestandardbills, 20);
		driver.findElement(managestandardbills).click();
		
		SeleniumPageHelper.waitForElement(driver, projectinput, 20);
		driver.findElement(projectinput).click();
		WebElement prjID = driver.findElement(projectinput);
		JavascriptExecutor runJS = ((JavascriptExecutor) driver);
		runJS.executeScript("arguments[0].value='" + "AIR00114.00.02" + "';", prjID);
		
		Thread.sleep(2000);
		SeleniumPageHelper.waitForElement(driver, findButton, 20);
		driver.findElement(findButton).click();
		
		Thread.sleep(2000);
		SeleniumPageHelper.waitForElement(driver, selectProject, 20);
		Actions doubleClick = new Actions(driver);
		doubleClick.doubleClick(driver.findElement(selectProject)).perform();
		
		SeleniumPageHelper.waitForElement(driver, invoiceNumberText, 20);
		driver.findElement(invoiceNumberText).click();
		
		SeleniumPageHelper.waitForElement(driver, actionMenuDropdown, 20);
		driver.findElement(actionMenuDropdown).click();
		
		SeleniumPageHelper.waitForElement(driver, calculateTaxButton, 20);
		driver.findElement(calculateTaxButton).click();	
		
		SeleniumPageHelper.waitForElement(driver, messagePopUp, 20);
		driver.findElement(closeMessagePopUpButton).click();
				
		SeleniumPageHelper.waitForElement(driver, actionMenuDropdown, 20);
		driver.findElement(actionMenuDropdown).click();
		
		SeleniumPageHelper.waitForElement(driver, sendForApprovalButton, 20);
		driver.findElement(sendForApprovalButton).click();	
		
		SeleniumPageHelper.waitForElement(driver, messagePopUp, 20);
		driver.findElement(closeMessagePopUpButton).click();
		
		SeleniumPageHelper.waitForElement(driver, mainFormClose, 20);
		driver.findElement(mainFormClose).click();

	}

	@AfterClass
	public void tearDown() {
		/*
		 * driver.close(); driver.quit();
		 */
	}
}