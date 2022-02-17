package ctappium.page;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import ctappium.core.BasePage;
import ctappium.core.DriverFactory;

public class CliquesPage extends BasePage {

	public String obterTextoCampo() throws MalformedURLException {
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
