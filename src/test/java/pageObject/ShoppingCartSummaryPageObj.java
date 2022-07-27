package pageObject;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class ShoppingCartSummaryPageObj {

	WebDriver driver = null;

	By pageTitleInCart = By.id("cart_title");
	By productsNameInCart = By.xpath("//td[@class='cart_description']/p/a");
	By productModelInCart = By.xpath("(//td[@class='cart_description']/small)[1]");
	By productAttributeInCart = By.xpath("(//td[@class='cart_description']/small)[2]/a");
	By productUnitPriceInCart = By.xpath("(//span[@class='price']/span[1])[1]");
	By totalProductCostInCart = By.xpath("(//td[@class='cart_total']/span[@class='price'])[1]");
	By shippingChargeInCart = By.xpath("//td[@id='total_shipping']");
	By totalCostInCart = By.id("total_price");
	By proceedToCheckoutBtnInCart = By.xpath("//p[@class='cart_navigation clearfix']/a/span");


	public ShoppingCartSummaryPageObj(WebDriver driver) {
		this.driver = driver;
	}


	public void ValidateProductDetailsInShoppingCartSummary(Hashtable<String, String> productDetails) {

		Assertion softAssert = new SoftAssert(); 

		String pageTitle = driver.findElement(pageTitleInCart).getText();
		String productsName = driver.findElement(productsNameInCart).getText();
		String productModel = driver.findElement(productModelInCart).getText();
		String productAttribute = driver.findElement(productAttributeInCart).getText();
		String productUnitPrice = driver.findElement(productUnitPriceInCart).getText();
		String shippingCharge = driver.findElement(shippingChargeInCart).getText();
		String totalProductCost = driver.findElement(totalProductCostInCart).getText();

		String totalCost = driver.findElement(totalCostInCart).getText();



		System.out.println("IN CART:");
		System.out.println("pageTitle:"+ pageTitle);
		System.out.println("productModel:"+ productModel);
		System.out.println("productAttribute:"+ productAttribute);
		System.out.println("productUnitPrice:"+ productUnitPrice);
		System.out.println("shippingCharge:"+ shippingCharge);
		System.out.println("totalProductCost:"+ totalProductCost);
		System.out.println("totalCost:"+ totalCost);

		System.out.println("productDetails:"+ productDetails);



		softAssert.assertEquals(pageTitle, "SHOPPING-CART SUMMARY");
		Assert.assertEquals(productsName, productDetails.get("productName"));
		Assert.assertEquals(productModel, "SKU : "+ productDetails.get("model") );
		Assert.assertEquals(productAttribute, "Color : " + productDetails.get("color") + ", Size : "+ productDetails.get("size"));
		Assert.assertEquals(productUnitPrice, productDetails.get("unitPrice") );
		Assert.assertEquals(shippingCharge, productDetails.get("ShippingCharge"));
		Assert.assertEquals(totalProductCost, productDetails.get("TotalProductCost"));
		Assert.assertEquals(totalCost, productDetails.get("TotalCost"));

	}



}
