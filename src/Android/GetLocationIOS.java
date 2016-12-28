package Android;
import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class GetLocationIOS {
	private AppiumDriver driver;
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "/Applications/STA/SeeTest-Trunk/bin/ipas/EriBankO.ipa");
		capabilities.setCapability("platformName", "IOS");
		capabilities.setCapability("udid", "80b6fb8ae5b8e447e31cd14b18abac267a591cee");
		capabilities.setCapability("deviceName", "Ipad");
		capabilities.setCapability("bundleId", "com.experitest.ExperiBankO");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("automationName","XCUITest");
//      capabilities.setCapability("keychainPath", "/Users/erez.akri/Library/Keychains/MyKeychain.keychain");
//      capabilities.setCapability("xcodeOrgId", "97625XTAHB");
//      capabilities.setCapability("xcodeOrgId", "97625XTAHB");
//      capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//      capabilities.setCapability("keychainPassword", "123456");
      capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
      		+ "/WebDriverAgent/Config.xcconfig");
      capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole");
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities)capabilities);
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void test() throws Exception{
		System.out.println(driver.getPageSource());
		List<WebElement> elemList = driver.findElements(By.className("XCUIElementTypeTextField"));
		for(WebElement elem: elemList){
			System.out.println(elem);
			System.out.println(elem.getText());
			Thread.sleep(5000);
			System.out.println(elem.getLocation());
			System.out.println(elem.getSize());
		}
	}

}