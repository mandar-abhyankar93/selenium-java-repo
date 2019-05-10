package pages;

import org.openqa.selenium.WebDriver;

import actionmethods.PageActionMethods;
import pageobjects.SetupHomePage;

public class SetupHome extends PageActionMethods implements SetupHomePage{
	
	static WebDriver webDriver;

	public SetupHome(WebDriver driver) {

		webDriver = driver;

	}
	
	public void clickOnAppLauncher() {
		clickOnLink(webDriver, APPLAUNCHERDOTS);
	}
	
	public void searchForApp(String appName) {
		enterTextIntoField(webDriver, APPSEARCHBOX, appName);
	}
	
	public void clickAppLinkIn(String appName) {
		
	}
	
}
