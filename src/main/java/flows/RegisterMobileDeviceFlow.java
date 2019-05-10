package flows;

import org.openqa.selenium.WebDriver;

import pages.RegisterMobilePhone;

public class RegisterMobileDeviceFlow {

	
	public void bypassMobileDeviceRegistration(WebDriver wdriver) {
		
		RegisterMobilePhone reg = new RegisterMobilePhone(wdriver);
		reg.clickOnRemindMeLaterLink();
		
	}
}
