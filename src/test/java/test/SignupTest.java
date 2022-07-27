package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import helper.RandomAlphaNum;
import pageObject.AccountPageObj;
import pageObject.SignLoginPageObj;

public class SignupTest {
	public static WebDriver driver;
	 String projectPath = System.getProperty("user.dir");
	 SignLoginPageObj signloginObj1;
	
	@BeforeSuite
	public void setupTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com");
	}

	@Test
	public void signupTest() throws InterruptedException {
		SignLoginPageObj signloginObj = new SignLoginPageObj(driver);
		RandomAlphaNum randomNumber= new  RandomAlphaNum();
		System.out.println(randomNumber.randomNumber());
		
		signloginObj.signInLinkLoc();
		signloginObj.createEmailLoc("ab1249c3"+randomNumber.randomNumber() +"@gmail.com");
		signloginObj.createAnAccountLoc();
		Thread.sleep(10000);
		signloginObj.titleLoc();
		signloginObj.firstNameLoc("Jhon");
		signloginObj.lastNameLoc("Matthew");
		signloginObj.signupPasswordLoc("abc123");
		signloginObj.dateLoc(15);
		signloginObj.monthLoc(4);
		signloginObj.yearLoc("2000");
		signloginObj.addressLoc("139 Avenue Road");
		signloginObj.cityLoc("Foster city");
		signloginObj.stateLoc(4);
		signloginObj.zipCodeLoc("15244");
		signloginObj.mobileNumberLoc("8884918"+randomNumber.randomNumber());
		signloginObj.registerBtnLoc();
		
		AccountPageObj accountPageObj = new AccountPageObj(driver);
		accountPageObj.validateMyAccountPageTitle();
		accountPageObj.validateMyAccountWelcomeMsg();
	}
	


	@AfterSuite
	public void teatDown() {
		driver.close();
		driver.quit();
	}
}
