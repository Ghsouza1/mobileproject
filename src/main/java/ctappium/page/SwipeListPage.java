package ctappium.page;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import ctappium.core.BasePage;
import ctappium.core.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeListPage extends BasePage {

	public void swipeElementLeft(String opcao) throws MalformedURLException {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
	}

	public void swipeElementRight(String opcao) throws MalformedURLException {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
	}

	public void cliqueBotaoMais() throws MalformedURLException {
		new TouchAction(DriverFactory.getDriver())
				.tap(ElementOption.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."))))
				.perform();
	}
}
