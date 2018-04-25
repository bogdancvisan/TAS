package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DashboardPageObject;
import pages.LoginPageObject;

public class TestOutlook {
	ChromeDriver driver;
	LoginPageObject loginPageObject;
	DashboardPageObject dashboardPageObject;
	WebDriverWait wait;

	@BeforeTest
	public void beforeInit() {
		DriverInit driverInit = new DriverInit();
		driver = (ChromeDriver) driverInit.initDriver();
		wait = new WebDriverWait(driver, 10);

		loginPageObject = new LoginPageObject(driver, wait);
		dashboardPageObject = new DashboardPageObject(driver, wait);
	}

	@Test
	public void test1() {
		loginPageObject.loginToOutlook();

	}
	
	@Test
	public void test2( ) {
		dashboardPageObject.createNewMail();
	}
	
	@Test
	public void test3() {
		dashboardPageObject.verifySentMail();
	}
	

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
