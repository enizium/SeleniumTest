package pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPageObj {

	WebDriver driver = null;

	public AccountPageObj(WebDriver driver) {
		this.driver = driver;
	}

	By myAccountPageTitle = By.xpath("//div[@id='center_column']/h1");
	By accountWelcomeMsg = By.className("info-account");

	public void validateMyAccountPageTitle() {
		String title = driver.findElement(myAccountPageTitle).getText();
		assertEquals(title, "MY ACCOUNT");
	}

	public void validateMyAccountWelcomeMsg() {
		String welcomeMsg = driver.findElement(accountWelcomeMsg).getText();
		assertEquals(welcomeMsg, "Welcome to your account. Here you can manage all of your personal information and orders.");
	}


}
