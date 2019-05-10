package helper;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPageHelper {

	private static final String chromeExecutablePath = "C:\\www\\chromedriver\\chromedriver.exe";
	// private final String ieExecutablePath = "";
	static WebDriver wDriver;
	static ChromeOptions cOptions = new ChromeOptions();

	public static WebDriver openBrowserWithURL(String browserName, String url) {

		switch (browserName) {

		case "Chrome":
			cOptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", chromeExecutablePath);
			wDriver = new ChromeDriver(cOptions);
			wDriver.get(url);
			wDriver.manage().window().maximize();
			return wDriver;
		case "IE":
			// IE
		case "ie":
			// ie
		default:
			System.setProperty("webdriver.chrome.driver", chromeExecutablePath);
			wDriver = new ChromeDriver();
			wDriver.get(url);
			wDriver.manage().window().maximize();
			return wDriver;

		}
	}

	public static void waitForElement(WebDriver driver, By element, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static String getRandomIntegerAsString(int min, int max) {
		Random random = new Random();
		int temp = random.ints(min, (max + 1)).findFirst().getAsInt();
		return ""+temp;
	}

}
