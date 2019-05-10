package pages;

import org.openqa.selenium.WebDriver;

import actionmethods.PageActionMethods;
import pageobjects.RegisterMobilePhonePage;

public class RegisterMobilePhone extends PageActionMethods implements RegisterMobilePhonePage {

	static WebDriver webDriver;

	public RegisterMobilePhone(WebDriver driver) {

		webDriver = driver;

	}

	public void clickOnRemindMeLaterLink() {
		clickOnLink(webDriver, REMINDMELATERLINK);
	}

}
