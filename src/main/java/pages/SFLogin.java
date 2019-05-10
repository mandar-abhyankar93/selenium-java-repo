package pages;

import org.openqa.selenium.WebDriver;

import actionmethods.PageActionMethods;
import pageobjects.SFLoginPage;

public class SFLogin extends PageActionMethods implements SFLoginPage {

	static WebDriver webDriver;

	public SFLogin(WebDriver driver) {

		webDriver = driver;
		
	}

	public void enterUsername() {

		enterTextIntoField(webDriver, USERNAMEFIELD, getPageData("SFLogin", "username"));

	}

	public void enterPassword() {

		enterTextIntoField(webDriver, PASSWORDFIELD, getPageData("SFLogin", "password"));

	}

	public void clickOnLogin() {
		clickOnButton(webDriver, LOGINBUTTON);
	}

}
