package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObj {

	WebDriver driver = null;

	By searchBox = By.id("search_query_top");
	By searchBtn = By.name("submit_search");
	By firstProduct = By.xpath("(//div[@id='center_column']/ul/li)[1]");
	By productName = By.xpath("(//div[@id='center_column']/ul/li)[1]//a[@class='product-name']");
	By productCost = By.xpath("(//div[@id='center_column']/ul/li)[1]//div[@class='right-block']//span[@class='price product-price']");


	public HomePageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void searchBoxLoc(String text) {
		driver.findElement(searchBox).sendKeys(text);
	}

	public void searchBtnClick() {
		driver.findElement(searchBtn).click();
	}
}
