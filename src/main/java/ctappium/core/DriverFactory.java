package ctappium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private static void createDriver() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AppTeste");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		dc.setCapability("appPackage", "com.ctappium");
		dc.setCapability("appActivity", "com.ctappium.MainActivity");
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("allowTestPackages", true);
		dc.setCapability("autoAcceptAlerts", true);
		dc.setCapability("autoDismissAlerts", true);
		dc.setCapability("chromedriverExecutable",
				"C:\\Users\\ghsou\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
		dc.setCapability("chromedriverExecutableDir",
				"C:\\Users\\ghsou\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
		dc.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\ghsou\\OneDrive\\Área de Trabalho\\mobileproject\\src\\main\\resources\\CTAppium_2_0.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
