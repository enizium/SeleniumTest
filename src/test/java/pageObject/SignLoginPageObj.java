package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignLoginPageObj {

	WebDriver driver = null;

	By signInLink = By.xpath("//a[@class='login']");
	By createEmail = By.id("email_create");
	By createAnAccount = By.id("SubmitCreate");

	By title = By.id("id_gender1"); //radio button
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By signupPassword = By.id("passwd");

	//dropdown
	By date = By.id("days");
	By month = By.id("months");
	By year = By.id("years");

	By address = By.name("address1");
	By city = By.id("city");
	By state = By.id("id_state"); //dropdown
	By zipCode = By.id("postcode");
	By country = By.id("id_country"); //dropdown

	By phone_mobile = By.name("phone_mobile");
	By registerBtn = By.id("submitAccount");

	//login form
	By email = By.id("email"); 
	By password = By.id("passwd"); 
	By signinBtn = By.id("SubmitLogin");


	public SignLoginPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void signInLinkLoc() {
		driver.findElement(signInLink).click();
	}

	public void createEmailLoc(String text) {
		driver.findElement(createEmail).sendKeys(text);
	}

	public void createAnAccountLoc() {
		driver.findElement(createAnAccount).click();
	}

	public void titleLoc() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(title).click();
	}

	public void firstNameLoc(String text) {
		driver.findElement(firstName).sendKeys(text);
	}

	public void lastNameLoc(String text) {
		driver.findElement(lastName).sendKeys(text);
	}

	public void signupPasswordLoc(String text) {
		driver.findElement(signupPassword).sendKeys(text);
	}

	public void dateLoc(int dateIndex) {
		Select dates = new Select(driver.findElement(date));
		dates.selectByIndex(dateIndex);
	}

	public void monthLoc(int monthIndex) {
		Select months = new Select(driver.findElement(month));
		months.selectByIndex(monthIndex);
	}

	public void yearLoc(String yearIndex) {
		Select years = new Select(driver.findElement(year));
		years.selectByValue(yearIndex);
	}

	public void addressLoc(String addresses) {
		driver.findElement(address).sendKeys(addresses);
	}

	public void cityLoc(String cityName) {
		driver.findElement(city).sendKeys(cityName);
	}

	public void stateLoc(int stateName) {
		Select states = new Select(driver.findElement(state));
		states.selectByIndex(stateName);
	}

	public void zipCodeLoc(String postalCode) {
		driver.findElement(zipCode).sendKeys(postalCode);
	}

	public void countryLoc(String countryName) {
		Select countires = new Select(driver.findElement(country));
		countires.selectByValue(countryName);
	}

	public void mobileNumberLoc(String mobNum) {
		driver.findElement(phone_mobile).sendKeys(mobNum);
	}

	public void registerBtnLoc() {
		driver.findElement(registerBtn).click();
	}

	public void emailAddressLoc(String emailaddress) {
		driver.findElement(email).sendKeys(emailaddress);
	}

	public void passwordLoc(String passwd) {
		driver.findElement(password).sendKeys(passwd);
	}	

	public void signinBtnClick() {
		driver.findElement(signinBtn).click();
	}

}
