package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DashboardPageObject;
import pages.LoginPageObject;

/*
 * "Implement an automated test that performs the following actions on www.hotmail.com that performs the following actions:
- Login with a valid user
- Compose a new e-mail (fill all the required fields)
- Send the e-mail
- Verify that the email has been sent (is displayed in the ""Sent"" section)
(Precondition: one valid account already created)"
 * 
 * */

public class Main {

	public static void main(String[] args) {

		DriverInit driverInit = new DriverInit();
		ChromeDriver driver = (ChromeDriver) driverInit.initDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		LoginPageObject loginPageObject = new LoginPageObject(driver, wait);

		loginPageObject.loginToOutlook();		

		driver.close();
		driver.quit();
	}
}
