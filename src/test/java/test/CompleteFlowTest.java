package test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.AccountPageObj;
import pageObject.HomePageObj;
import pageObject.ProductPageObj;
import pageObject.ShoppingCartSummaryPageObj;
import pageObject.SignLoginPageObj;
import setup.BaseClass;
import setup.LoginExcelData;

public class CompleteFlowTest extends BaseClass {
	
	//public static WebDriver driver;

	 String projectPath = System.getProperty("user.dir");
	 SignLoginPageObj signloginObj1;
	
	 Hashtable <String, String> productDetail;
	 Hashtable <String, String> productDetails;
	
//	 @BeforeSuite
//		public void setupTest() {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get("http://automationpractice.com/");
//		}
//	 
	 
	 @DataProvider(name="testdata")
	 public  Object[][] getData() {
		 String excelPath = System.getProperty("user.dir")+"/resources/logindata.xlsx";
		 LoginExcelData loginExcelData= new LoginExcelData();
		 Object data[][] = loginExcelData.testData(excelPath, "Sheet1");
		 return data; 
	 } 
	 
	@Test(dataProvider = "testdata")
	public void completeTest(String username, String password) throws InterruptedException {
		SignLoginPageObj signloginObj = new SignLoginPageObj(driver);
		
		signloginObj.signInLinkLoc();
		signloginObj.emailAddressLoc(username);
		signloginObj.passwordLoc(password);
		signloginObj.signinBtnClick();
		
		AccountPageObj accountPageObj = new AccountPageObj(driver);
		accountPageObj.validateMyAccountPageTitle();
		accountPageObj.validateMyAccountWelcomeMsg();

		HomePageObj homePageObj = new HomePageObj(driver);
		homePageObj.searchBoxLoc("Dress");
		homePageObj.searchBtnClick();
		
		ProductPageObj productPageObj = new ProductPageObj(driver);
		productDetail = productPageObj.getProductDetail();
		System.out.println("product1:"+productDetail.get("productName"));
		productPageObj.clickOverview();
		
		try {
			productPageObj.validateProductDetailsInOverview(productDetail);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String quantity = "1";
		String size = "0";
		String color= "Blue";
		
		
		Hashtable<String, String> productOtherDetail = new Hashtable<String, String>();
		productOtherDetail.put("quantity", quantity);
		productOtherDetail.put("size", size);
		productOtherDetail.put("color", color);
		productOtherDetail.put("model", productPageObj.overviewModelNum());
			
		System.out.println("Test product1:"+productDetail.get("productName"));
		System.out.println("###############################s");
		System.out.println("product quantity :"+productOtherDetail);
		
		System.out.println("product quantity :"+productOtherDetail.get("quantity"));
		System.out.println("product size :"+productOtherDetail.get("size"));
		System.out.println("product color :"+productOtherDetail.get("color"));
		
		
		productPageObj.changeQuantity(quantity);
		productPageObj.changeSize(Integer.parseInt(size));
		productPageObj.overviewColor(color);
		
		productPageObj.overviewAddToCardBtnClick();
		
		productDetails = productPageObj.validateProductDetialsAddedToCart(productDetail, productOtherDetail);
		
		productPageObj.proceedToCheckoutBtnClick();
		
		ShoppingCartSummaryPageObj shoppingCartSummaryPageObj = new ShoppingCartSummaryPageObj(driver);
		
		shoppingCartSummaryPageObj.ValidateProductDetailsInShoppingCartSummary(productDetails);

	}

}
