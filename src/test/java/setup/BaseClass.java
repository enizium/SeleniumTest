package setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseClass {

	public static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");
	static String browser = null;
	static Properties prop = new Properties();
	String url=null;
	String user;
	
	@BeforeSuite
	public void openBrowserAndUrl() throws InterruptedException {
		chooseBrowser();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public void chooseBrowser() throws InterruptedException {
		
		getProperties();
		Thread.sleep(5000);
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	public void getProperties() {
		try {
			InputStream input = new FileInputStream(projectPath + "/src/test/java/setup/config.properties");
			prop.load(input);
			browser=prop.getProperty("browser");
			url = prop.getProperty("url");	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}


	public void firefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
	}

	public void chromeBrowser() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
	}

	
}
