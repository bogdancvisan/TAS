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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VCB\\Downloads\\chromedriver.exe");
		return driver = new ChromeDriver();
	}
}
