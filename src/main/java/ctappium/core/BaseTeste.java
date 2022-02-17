package ctappium.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import io.qameta.allure.Attachment;

public class BaseTeste {

	@Rule
	public TestName testName = new TestName();

	@AfterClass
	public static void finalizaClasse() throws MalformedURLException {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() throws IOException {
		gerarScreenShot();
		takeScreenshotToAttachOnAllureReport();
		DriverFactory.getDriver().resetApp();
	}

	public void gerarScreenShot() throws IOException {

		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshots/" + testName.getMethodName() + ".png"));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
	}

	@Attachment(value = "Test Screenshoot", type = "image/png")
	public static byte[] takeScreenshotToAttachOnAllureReport() throws WebDriverException, MalformedURLException {
		return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
}
