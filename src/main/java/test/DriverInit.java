package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver initDriver() {

		String HOME_USER = System.getProperty("user.home");

		System.setProperty("webdriver.chrome.driver", HOME_USER + "\\Downloads\\chromedriver.exe");
		return driver = new ChromeDriver();
	}
}
