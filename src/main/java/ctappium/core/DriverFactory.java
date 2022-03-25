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
			//createDriver();
			createDriverForBrowserstack();
		}
		return driver;
	}

	private static void createDriver() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AppTeste");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		dc.setCapability("noSign", "true");
		dc.setCapability("appPackage", "com.ctappium");
		dc.setCapability("appActivity", "com.ctappium.MainActivity");
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("allowTestPackages", true);
		dc.setCapability("autoAcceptAlerts", true);
		dc.setCapability("autoDismissAlerts", true);

		// Configure test script to use on browserstack
		dc.setCapability("browserstack.user", "gustavosouza_3ctPfh");
		dc.setCapability("browserstack.key", "RSxTDBhwjpoWag8DGKxp");
		dc.setCapability("app", "bs://6a842c5f6007433b51175deb5e3d0bf7b2822d53");

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

	private static void createDriverForBrowserstack() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "gustavosouza_3ctPfh");
		caps.setCapability("browserstack.key", "RSxTDBhwjpoWag8DGKxp");

		// Set URL of the application under test
		caps.setCapability("app", "bs://6a842c5f6007433b51175deb5e3d0bf7b2822d53");

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "browserstack-build-1");
		caps.setCapability("name", "first_test");


		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
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
