package java_example;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SgridExample {
	private WebDriver driver;
	private String baseUrl, nodeUrl;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		baseUrl = "http://www.google.com";
		nodeUrl = "http://10.0.0.211:5555/";
		
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WIN8_1);
		
		driver = new RemoteWebDriver(new URL (nodeUrl), capability);
		}
	
		@AfterTest
		public void afterTest() {
			driver.quit();
		}
		
		@Test
		public void simpleTest() {
			driver.get(baseUrl);
			Assert.assertEquals("Google", driver.getTitle());
		}

}
