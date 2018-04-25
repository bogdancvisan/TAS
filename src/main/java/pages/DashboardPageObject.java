package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.DashboardElements;
import elements.LoginPageElements;

public class DashboardPageObject {

	ChromeDriver driver;
	WebDriverWait wait;

	public DashboardPageObject(ChromeDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void createNewMail() {
		waitAndClickElement(By.id(DashboardElements.getNewmessageclass()));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardElements.getMailbody())));
		waitAndFillInput(By.cssSelector(DashboardElements.getToinputfieldclass()),
				LoginPageElements.getMail() + "\t\t\t\t");
		waitAndFillInput(By.id(DashboardElements.getSubjectinputfieldid()),
				DashboardElements.getSubjectinputfieldid() + "\ttestmail\t");
		waitAndClickElement(By.xpath(DashboardElements.getSendbuttonclass()));
		
	}

	public void verifySentMail() {
		waitAndClickElement(By.xpath(DashboardElements.getSentmenuclass()));
		
//		waitAndClickElement(By.className(DashboardElements.getOutlooklogoclass()));
		
		waitAndClickElement(By.xpath(DashboardElements.getSentmenuclass()));

		By by1 = By.xpath(DashboardElements.getSentmaillistxpath()),
				by2 = By.xpath(DashboardElements.getSentmaillistxpath2()),
				by3 = By.xpath(DashboardElements.getSentmaillistxpath3()),
				by4 = By.xpath(DashboardElements.getSentmailtimexpath());

		wait.until(ExpectedConditions.visibilityOfElementLocated(by1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by4));

		WebElement element1 = driver.findElement(by1), element2 = driver.findElement(by2),
				element3 = driver.findElement(by3), element4 = driver.findElement(by4);

		wait.until(ExpectedConditions.visibilityOf(element1));
		wait.until(ExpectedConditions.visibilityOf(element2));
		wait.until(ExpectedConditions.visibilityOf(element3));
		wait.until(ExpectedConditions.visibilityOf(element4));

		System.out.println(element1.getText());
		System.out.println(element2.getText());
		System.out.println(element3.getText());
		System.out.println(element4.getText());

		Date date = new Date();
		date.getTime();

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

		String currentTime = dateFormat.format(date);

		if (element1.getText().equals(LoginPageElements.getMail())) {
			if (element2.getText().equals(DashboardElements.getSubjectinputfieldid())) {
				if (element3.getText().equals("testmail")) {
					if (!element4.getText().equals(currentTime)) {
						System.out.println(
								"Sent time different! actual: " + element4.getText() + " expected: " + currentTime);
					}
					System.out.println("Mail was found in Sent List!");
				}
			}
		}

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
