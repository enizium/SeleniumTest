package pageObject;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ProductPageObj {

	WebDriver driver;

	By overview = By.className("quick-view");
	By selectFirstProduct = By.xpath("(//div[@id='center_column']/ul/li)[1]");
	By productsName = By.xpath("(//div[@id='center_column']/ul/li)[1]//a[@class='product-name']");
	By productCost = By.xpath("(//div[@id='center_column']/ul/li)[1]//div[@class='right-block']//span[@class='price product-price']");
	By productOldPrice = By.xpath("(//div[@id='center_column']/ul/li)[1]//div[@class='right-block']//span[@class='old-price product-price']");
	By productDis = By.xpath("(//div[@id='center_column']/ul/li)[1]//div[@class='right-block']//span[@class='price-percent-reduction']");

	//overview
	By overviewProdName = By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/h1[@itemprop='name']");
	By overviewModel = By.xpath("//span[@itemprop='sku']");
	By overviewDisplayPrice = By.id("our_price_display");
	By overviewDis = By.id("reduction_percent_display");
	By overviewOldprice = By.id("old_price_display");
	By overviewQuantity = By.id("quantity_wanted");
	By overviewSize = By.id("group_1"); //select
	By overviewAddToCardBtn = By.xpath("//button[@name='Submit']");
	By iframeTab = By.xpath("//iframe[@class='fancybox-iframe']");

	By layerCart = By.xpath("//div[@style='top: 377px; display: block;']");

	By body = By.id("page");

	By successfullyAddToCartMsg = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2");
	By successfullyAddToCartProductName = By.id("layer_cart_product_title");
	By successfullyAddToCartAttribute = By.id("layer_cart_product_attributes");
	By successfullyAddToCartQuantity = By.id("layer_cart_product_quantity");
	By successfullyAddToCartProductPrice = By.id("layer_cart_product_price");
	By successfullyAddToCartShippingCharge = By.xpath("//span[@class='ajax_cart_shipping_cost']");
	By successfullyAddToCartTotalPrice =  By.xpath("//span[@class='ajax_block_cart_total']");

	By proceedToCheckoutBtn = By.xpath("//a[@class='btn btn-default button button-medium']");



	public ProductPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFirstProductLoc() {
		driver.findElement(selectFirstProduct).click();
	}

	public void overviewAddToCardBtnClick() {
		//		WebElement frameElement=driver.findElement(iframeTab);
		//        driver.switchTo().frame(frameElement);
		driver.findElement(overviewAddToCardBtn).click();
		driver.switchTo().defaultContent();

	}

	public Hashtable<String, String> getProductDetail() {
		Hashtable<String, String> productDetails = new Hashtable<String, String>();
		String productName = driver.findElement(productsName).getText();
		String productPrice = driver.findElement(productCost).getText();
		String productActualPrice = driver.findElement(productOldPrice).getText();
		String productDiscount = driver.findElement(productDis).getText();

		productDetails.put("productName", productName);
		productDetails.put("productPrice", productPrice);
		productDetails.put("productActualPrice", productActualPrice);
		productDetails.put("productDiscount", productDiscount);


		//console
		System.out.println("product1:"+ productDetails.get("productName"));
		System.out.println("productPrice:"+ productDetails.get("productPrice"));
		System.out.println("productActualPrice:"+ productDetails.get("productActualPrice"));
		System.out.println("productDiscount:"+ productDetails.get("productDiscount"));

		return productDetails;
	}

	public void clickOverview() {
		WebElement ele = driver.findElement(selectFirstProduct); 

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println("product1654:");
		Actions actions = new Actions(driver);

		actions.moveToElement(ele).build().perform();
		driver.findElement(overview).click();
	}

	public void validateProductDetailsInOverview (Hashtable <String, String> productDetail) throws InterruptedException {

		Thread.sleep(2000);
		WebElement frameElement=driver.findElement(iframeTab);
		driver.switchTo().frame(frameElement);

		//console
		System.out.println("product1:"+ productDetail.get("productName"));
		System.out.println("productPrice:"+ productDetail.get("productPrice"));
		System.out.println("productActualPrice:"+ productDetail.get("productActualPrice"));
		System.out.println("productDiscount:"+ productDetail.get("productDiscount"));


		String actualProductName = driver.findElement(overviewProdName).getText();
		String actualSellingPrice = driver.findElement(overviewDisplayPrice).getText();
		String actualDiscount = driver.findElement(overviewDis).getText();
		String actualOldPrice =driver.findElement(overviewOldprice).getText();

		//console

		System.out.println("product1:"+actualProductName);
		System.out.println("productPrice:"+ actualSellingPrice);
		System.out.println("productActualPrice:"+ actualOldPrice);
		System.out.println("productDiscount:"+ actualDiscount);


		assertEquals(actualProductName, productDetail.get("productName"));
		assertEquals(actualSellingPrice, productDetail.get("productPrice"));
		assertEquals(actualDiscount, productDetail.get("productDiscount"));
		assertEquals(actualOldPrice, productDetail.get("productActualPrice"));
		System.out.println("productActualPrice:1!!!!"+productDetail.get("actualOldPrice"));
	}

	public void changeQuantity(String quantity) {
		driver.findElement(overviewQuantity).clear();
		driver.findElement(overviewQuantity).sendKeys(quantity);
	}

	public void changeSize(int size) {
		Select sizes = new Select(driver.findElement(overviewSize));
		sizes.selectByIndex(size);
	}

	public void overviewColor(String color) {
		driver.findElement(By.xpath("//a[@title='"+color+"']")).click();
	}

	public String overviewModelNum() {
		return driver.findElement(overviewModel).getText();
	}

	public void proceedToCheckoutBtnClick() {
		driver.findElement(proceedToCheckoutBtn).click();
	}


	public Hashtable<String,String> validateProductDetialsAddedToCart(Hashtable<String, String> productDetail, Hashtable<String, String> productOtherDetail) throws InterruptedException {

		driver.switchTo().defaultContent();

		int x = 100 ; 
		int y = 700 ; 
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(x,y); 

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		} catch (AWTException e) {
			e.printStackTrace();
		}

		Hashtable<String, String> productSize = new Hashtable<String, String>();
		productSize.put("0", "S");
		productSize.put("1", "M");
		productSize.put("2", "L");

		Thread.sleep(5000);
		String succesMsg = driver.findElement(successfullyAddToCartMsg).getText();
		System.out.println("product succesMsf  :"+succesMsg);

		String  nameOfProductInCart = driver.findElement(successfullyAddToCartProductName).getText();
		System.out.println(" NameOfProductInCart  :"+nameOfProductInCart);

		String  attributeOfProductInCart = driver.findElement(successfullyAddToCartAttribute).getText();
		System.out.println(" successfullyAddToCartAttribute  :"+attributeOfProductInCart);

		String  quantityOfProductInCart = driver.findElement(successfullyAddToCartQuantity).getText();
		System.out.println(" successfully quantityOfProductInCart  :"+quantityOfProductInCart);

		String  priceOfProductInCart = driver.findElement(successfullyAddToCartProductPrice).getText();
		System.out.println(" successfully priceOfProductInCart  :"+priceOfProductInCart);

		String  shippingChargeOfProductInCart = driver.findElement(successfullyAddToCartShippingCharge).getText();
		System.out.println(" successfully shippingChargeOfProductInCart  :"+shippingChargeOfProductInCart);

		String  totalPriceOfProductInCart = driver.findElement(successfullyAddToCartTotalPrice).getText();
		System.out.println(" successfully totalPriceOfProductInCart  :"+totalPriceOfProductInCart);


		Assert.assertEquals(succesMsg, "Product successfully added to your shopping cart");
		Assert.assertEquals(nameOfProductInCart, productDetail.get("productName"));


		String attribute = productOtherDetail.get("color")+", "+ productSize.get(productOtherDetail.get("size"));

		System.out.println("  attribute  :"+attribute); 

		Assert.assertEquals(attributeOfProductInCart, attribute);
		Assert.assertEquals(quantityOfProductInCart, productOtherDetail.get("quantity"));

		Hashtable<String, String> productDetails = new Hashtable<String, String>();
		productDetails.put("productName", productDetail.get("productName"));
		productDetails.put("unitPrice", productDetail.get("productPrice") );
		productDetails.put("size",  productSize.get(productOtherDetail.get("size")));
		productDetails.put("color", productOtherDetail.get("color"));
		productDetails.put("model", productOtherDetail.get("model"));
		productDetails.put("ShippingCharge", shippingChargeOfProductInCart );
		productDetails.put("TotalProductCost", priceOfProductInCart );
		productDetails.put("TotalCost", totalPriceOfProductInCart );

		System.out.println("  productDetails  :"+productDetails);  

		return productDetails;
	}





}
