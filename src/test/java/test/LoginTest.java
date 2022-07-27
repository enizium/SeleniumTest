package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.SignLoginPageObj;
import setup.LoginExcelData;

public class LoginTest {
	
	public static WebDriver driver;
	 String projectPath = System.getProperty("user.dir");
	 
	@BeforeSuite
	public void setupTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com");
	}

	 @DataProvider(name="testdata")
	 public  Object[][] getData() {
		 String excelPath = System.getProperty("user.dir")+"/resources/logindata.xlsx";
		 LoginExcelData loginExcelData= new LoginExcelData();
		 Object data[][] = loginExcelData.testData(excelPath, "Sheet1");
		 return data; 
	 }
	 
	@Test(dataProvider = "testdata")
	public static void login(String username, String password) throws Exception {

		SignLoginPageObj signloginObj = new SignLoginPageObj(driver);
		signloginObj.signInLinkLoc();
		signloginObj.emailAddressLoc(username);
		signloginObj.passwordLoc(password);
		signloginObj.signinBtnClick();
	}	

}
