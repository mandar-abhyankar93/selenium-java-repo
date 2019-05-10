package flows;

import org.openqa.selenium.WebDriver;

import pages.SFLogin;

public class SFLoginFlow {
	
	public void loginIntoSalesForce(WebDriver wdriver) {
		SFLogin login = new SFLogin(wdriver);
		login.enterUsername();
		login.enterPassword();
		login.clickOnLogin();
		
	}

}
