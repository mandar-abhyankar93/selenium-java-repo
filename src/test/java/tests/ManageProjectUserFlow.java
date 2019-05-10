package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helper.SeleniumPageHelper;

public class ManageProjectUserFlow {

	static WebDriver driver;
	private static By username = By.name("USER");
	private static By password = By.name("CLIENT_PASSWORD");
	private static By system = By.name("DATABASE");
	private static By loginbutton = By.id("loginBtn");
	private static By searchappsbox = By.id("appFltrFld");
	private static By mngprjusrflow = By.xpath("//div[contains(text(),'Manage Project User Flow (PJMBASIC)')]");
	private static By querybutton = By.xpath("//div[@id='qryBttn']");
	private static By projectinput = By.xpath("//input[@id='basicField0']");
	private static By levelinput = By.xpath("//input[@id='basicField3']");
	private static By findButton = By.xpath("//button[@id='submitQ']");
	private static By projectBillInfoLink = By.xpath("//span[contains(text(),'Proj Bill Info')]");
	private static By scheduleLink = By
			.xpath("//span[contains(text(),'Cash Basis')]/following-sibling::span[contains(text(),'Schedule')]");
	private static By formView = By.xpath("//div[@title='Switch to Form View (Ctrl+M)']");
	private static By amtToBill = By.xpath("//input[@id='BILL_SCHED_AMT']");
	private static By newRecordButton = By
			.xpath("//div[contains(text(),'Billings')]/..//div[@title='New Record (F2)']");
	private static By showCal = By.xpath("//span[contains(text(),'Date to Bill')]/..//span[@title='Show Calendar']");
	private static By todayButton = By.xpath("//button[@value='Today']");
	private static By accountID = By.id("ACCT_ID");
	private static By lineDesc = By.id("BILL_SCHED_LN_LBL");
	private static By saveButton = By.xpath("//span[@id='svBttnImg']");
	private static By messagePopUp = By.xpath("//div[contains(text(),'Message(s)')]");
	private static By mainFormClose = By.xpath("//input[@id='LOAD_DEFAULTS']/../../../..//div[@id='rsCls']");
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

		for (String proj : projs) {

			SeleniumPageHelper.waitForElement(driver, searchappsbox, 100);
			Thread.sleep(3000);
			driver.findElement(searchappsbox).clear();
			driver.findElement(searchappsbox).sendKeys("Manage Project User Flow");

			SeleniumPageHelper.waitForElement(driver, mngprjusrflow, 20);
			driver.findElement(mngprjusrflow).click();

			SeleniumPageHelper.waitForElement(driver, querybutton, 20);
			driver.findElement(querybutton).click();

			SeleniumPageHelper.waitForElement(driver, projectinput, 20);
			driver.findElement(projectinput).click();
			WebElement prjID = driver.findElement(projectinput);
			JavascriptExecutor runJS = ((JavascriptExecutor) driver);
			runJS.executeScript("arguments[0].value='" + proj + "';", prjID);

			SeleniumPageHelper.waitForElement(driver, levelinput, 20);
			driver.findElement(levelinput).sendKeys("3");

			SeleniumPageHelper.waitForElement(driver, findButton, 20);
			driver.findElement(findButton).click();

			SeleniumPageHelper.waitForElement(driver, projectBillInfoLink, 20);
			Thread.sleep(2000);
			driver.findElement(projectBillInfoLink).click();

			SeleniumPageHelper.waitForElement(driver, scheduleLink, 20);
			Thread.sleep(2000);
			driver.findElement(scheduleLink).click();

			SeleniumPageHelper.waitForElement(driver, formView, 20);
			Thread.sleep(1000);
			driver.findElement(formView).click();

			SeleniumPageHelper.waitForElement(driver, amtToBill, 20);
			boolean flag;
			try {
				driver.findElement(By.xpath("//div[contains(text(),'Billings')]/..//div[contains(text(),'Existing')]"));
				flag = false;
			} catch (Exception e) {
				flag = true;
			}
			Thread.sleep(1000);
			if (flag) {
				driver.findElement(amtToBill).sendKeys(SeleniumPageHelper.getRandomIntegerAsString(1, 999));
				SeleniumPageHelper.waitForElement(driver, showCal, 20);
				driver.findElement(showCal).click();
				Thread.sleep(1000);
				driver.findElement(todayButton).click();
				SeleniumPageHelper.waitForElement(driver, accountID, 20);
				driver.findElement(accountID).sendKeys("120-010-001");
				SeleniumPageHelper.waitForElement(driver, lineDesc, 20);
				driver.findElement(lineDesc).sendKeys("Desc");
			} else {
				SeleniumPageHelper.waitForElement(driver, newRecordButton, 20);
				driver.findElement(newRecordButton).click();
				SeleniumPageHelper.waitForElement(driver, amtToBill, 20);
				driver.findElement(amtToBill).sendKeys(SeleniumPageHelper.getRandomIntegerAsString(1, 999));
				SeleniumPageHelper.waitForElement(driver, showCal, 20);
				driver.findElement(showCal).click();
				Thread.sleep(1000);
				driver.findElement(todayButton).click();
				SeleniumPageHelper.waitForElement(driver, accountID, 20);
				driver.findElement(accountID).sendKeys("120-010-001");
				SeleniumPageHelper.waitForElement(driver, lineDesc, 20);
				driver.findElement(lineDesc).sendKeys("Desc");
			}
			Thread.sleep(5000);
			SeleniumPageHelper.waitForElement(driver, saveButton, 20);
			driver.findElement(saveButton).click();

			SeleniumPageHelper.waitForElement(driver, messagePopUp, 20);
			driver.findElement(By.xpath("//div[contains(text(),'Message(s)')]/preceding-sibling::div")).click();
			
			SeleniumPageHelper.waitForElement(driver, mainFormClose, 20);
			WebElement element = driver.findElement(By.xpath("//span[@title='Manage Project User Flow']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			WebElement formClose = driver.findElement(By.xpath("//div[contains(text(),'Identification') and @rstitle='1']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formClose);
			
			 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)");
			driver.findElement(mainFormClose).click();

		}

	}

	@AfterClass
	public void tearDown() {
		/*
		 * driver.close(); driver.quit();
		 */
	}
}