package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import flows.RegisterMobileDeviceFlow;
import flows.SFLoginFlow;
import helper.SeleniumPageHelper;

public class NewTest {

	static WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = SeleniumPageHelper.openBrowserWithURL("Chrome",
				"https://playful-moose-o204hi-dev-ed.my.salesforce.com/");

	}

	@Test
	public void test() {

		SFLoginFlow login = new SFLoginFlow();
		login.loginIntoSalesForce(driver);

		RegisterMobileDeviceFlow skipRegister = new RegisterMobileDeviceFlow();
		skipRegister.bypassMobileDeviceRegistration(driver);
	}

	@AfterClass
	public void tearDown() {
		/*
		driver.close();
		driver.quit();
		*/
	}
}