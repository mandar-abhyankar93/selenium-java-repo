package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helper.SeleniumPageHelper;

public class CalculateStandardBills {

	static WebDriver driver;
	private static By username = By.name("USER");
	private static By password = By.name("CLIENT_PASSWORD");
	private static By system = By.name("DATABASE");
	private static By loginbutton = By.id("loginBtn");
	private static By searchappsbox = By.id("appFltrFld");
	private static By calcstndrdbills = By.xpath("//div[contains(text(),'Calculate Standard Bills (BLPGBILL)')]");
	private static By fyBox = By.xpath("//input[@id='FY_CD']");
	private static By pdBox = By.xpath("//input[@id='PD_NO']");
	private static By subpdBox = By.xpath("//input[@id='SUB_PD_NO']");
	private static By projIdBox = By.xpath("//input[@id='PROJ_ID_FR']");
	private static By actionButton = By.xpath("//span[@id='actBttnImg']");
	private static By processCmplMsg = By.xpath("//div[contains(text(),'Process complete.')]");
	private static By processCmplOkBtn = By.xpath("//input[@value='Ok'  and @id='progMtrBtn']");
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
		driver.findElement(searchappsbox).sendKeys("Calculate Standard Bills");

		SeleniumPageHelper.waitForElement(driver, calcstndrdbills, 20);
		driver.findElement(calcstndrdbills).click();

		SeleniumPageHelper.waitForElement(driver, fyBox, 20);
		Thread.sleep(2000);
		driver.findElement(fyBox).sendKeys("2019");

		SeleniumPageHelper.waitForElement(driver, pdBox, 20);
		Thread.sleep(1000);
		driver.findElement(pdBox).sendKeys("12");

		SeleniumPageHelper.waitForElement(driver, subpdBox, 20);
		Thread.sleep(1000);
		driver.findElement(subpdBox).sendKeys("2");

		for (String proj : projs) {

			SeleniumPageHelper.waitForElement(driver, projIdBox, 20);
			Thread.sleep(1000);
			driver.findElement(projIdBox).clear();
			driver.findElement(projIdBox).sendKeys(proj);
			Thread.sleep(1000);
			driver.findElement(projIdBox).sendKeys(Keys.TAB);

			SeleniumPageHelper.waitForElement(driver, actionButton, 20);
			Thread.sleep(3000);
			driver.findElement(actionButton).click();

			SeleniumPageHelper.waitForElement(driver, processCmplMsg, 100);

			SeleniumPageHelper.waitForElement(driver, processCmplOkBtn, 20);
			driver.findElement(processCmplOkBtn).click();
		}

		/*
		 * SeleniumPageHelper.waitForElement(driver, mainFormClose, 20); WebElement
		 * element =
		 * driver.findElement(By.xpath("//span[@title='Calculate Standard Bills']"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 * Thread.sleep(3000); driver.findElement(mainFormClose).click();
		 */

	}

	@AfterClass
	public void tearDown() {
		/*
		 * driver.close(); driver.quit();
		 */
	}
}