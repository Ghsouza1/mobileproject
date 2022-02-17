package ctappium.core;

import static ctappium.core.DriverFactory.getDriver;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void sendKeys(By by, String texto) throws MalformedURLException {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String getText(By by) throws MalformedURLException {
		return getDriver().findElement(by).getText();
	}

	public void selectCombo(By by, String valor) throws MalformedURLException {
		getDriver().findElement(by).click();
		clickByText(valor);
	}

	public void click(By by) throws MalformedURLException {
		getDriver().findElement(by).click();
	}

	public void clickByTextAccessibilityId(String texto) throws MalformedURLException {
		click(MobileBy.AccessibilityId(texto));
	}

	public void timePicker(String min, String seg) throws MalformedURLException {
		boolean result = presenceOfElement(By.className("android.widget.TimePicker"));
		if (result == true) {
			clickByTextAccessibilityId(min);
			clickByTextAccessibilityId(seg);
		}
	}

	public void clickByAccessibilityId(String by) throws MalformedURLException {
		getDriver().findElement(MobileBy.AccessibilityId(by)).click();
	}

	public void clickByText(String texto) throws MalformedURLException {
		click(By.xpath("//*[@text='" + texto + "']"));
	}

	public void tap(int x, int y) throws MalformedURLException {
		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());

		touchAction.tap(PointOption.point(x, y)).perform();
	}

	public boolean isCheckTrue(By by) throws MalformedURLException {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public boolean presenceOfElements(String texto) throws MalformedURLException {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean presenceOfElement(String texto) throws MalformedURLException {
		MobileElement result = getDriver().findElement(By.xpath("//*[@text='" + texto + "']"));
		return result.equals(texto);
	}

	public boolean presenceOfElement(By by) throws MalformedURLException {
		boolean result = getDriver().findElement(by) != null;
		return result;
	}

	public void scrollUp() throws MalformedURLException {
		scroll(0.1, 0.9);
	}

	public void scrollDown() throws MalformedURLException {
		scroll(0.9, 0.1);
	}

	public void scroll(double inicio, double fim) throws MalformedURLException {
		Dimension size = getDriver().manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());

		touchAction.press(PointOption.point(x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(x, end_y)).release().perform();
	}

	public void swipe(double inicio, double fim) throws MalformedURLException {
		Dimension size = getDriver().manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());

		touchAction.press(PointOption.point(start_x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(end_x, y)).release().perform();

	}

	public void swipeElement(MobileElement element, double inicio, double fim) throws MalformedURLException {
		int y = element.getLocation().y + (element.getSize().height / 2);

		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);

		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());

		touchAction.press(PointOption.point(start_x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(end_x, y)).release().perform();

	}

	public void swipeRight() throws MalformedURLException {
		swipe(0.1, 0.9);
	}

	public void swipeLeft() throws MalformedURLException {
		swipe(0.9, 0.1);
	}

	public void waitElementByXpath(String texto) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='" + texto + "']")));
	}

	public void waitElementById(String texto) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='" + texto + "']")));
	}

	public void longPress(String texto) throws MalformedURLException {

		new TouchAction(DriverFactory.getDriver()).longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption
						.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + texto + "']"))))
				.withDuration(Duration.ofMillis(3000))).release().perform();
	}

	public void dragAndDrop(String origem, String destino) throws MalformedURLException {
		MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
		MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));

		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());

		touchAction.longPress(ElementOption.element(inicio)).moveTo(ElementOption.element(fim)).release().perform();
	}

	public String[] getList(By by) throws MalformedURLException {
		List<MobileElement> elements = DriverFactory.getDriver().findElements(by);
		String[] retorno = new String[elements.size()];

		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
		}
		return retorno;
	}
}
