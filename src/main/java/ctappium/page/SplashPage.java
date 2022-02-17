package ctappium.page;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ctappium.core.BasePage;
import ctappium.core.DriverFactory;

public class SplashPage extends BasePage {

	public boolean isTelaSplashVisible() throws MalformedURLException {
		return presenceOfElement("Splash!");
	}

	public void aguardarSplashSumir() throws MalformedURLException {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}
}
