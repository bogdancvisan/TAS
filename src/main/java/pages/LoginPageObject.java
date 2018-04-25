package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.DashboardElements;
import elements.LoginPageElements;

public class LoginPageObject {
	ChromeDriver driver;
	WebDriverWait wait;

	public LoginPageObject(ChromeDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void loginToOutlook() {
		driver.manage().window().maximize();
		driver.get(LoginPageElements.getUrl());
		waitAndClickElement(By.xpath(LoginPageElements.getLoginbutton()));
		waitAndFillInput(By.id(LoginPageElements.getUserinputfieldid()), LoginPageElements.getMail());
		waitAndClickElement(By.id(LoginPageElements.getNextbuttonid()));
		waitAndFillInput(By.id(LoginPageElements.getPassinputfield()), LoginPageElements.getPass());
		waitAndClickElement(By.id(LoginPageElements.getNextbuttonid()));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void waitAndClickElement(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
	}

	public void waitAndFillInput(By by, String content) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(content);
	}

}
