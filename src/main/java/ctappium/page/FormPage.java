package ctappium.page;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import ctappium.core.BasePage;
import ctappium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormPage extends BasePage {

	public void sendKeysName(String name) throws MalformedURLException {
		sendKeys(MobileBy.AccessibilityId("nome"), name);
	}

	public void clickDate(String element) throws MalformedURLException {
		clickByText(element);
	}

	public void setDate(String element) throws MalformedURLException {
		clickByTextAccessibilityId(element);
	}

	public void clickHour(String element) throws MalformedURLException {
		clickByText(element);
	}

	public void setHour(String min, String seg) throws MalformedURLException {
		timePicker(min, seg);
	}

	public void cliqueOK() throws MalformedURLException {
		clickByText("OK");
	}

	public void selectOptionCombo(String option) throws MalformedURLException {
		selectCombo(MobileBy.AccessibilityId("console"), option);
	}

	public void clickCheckBox() throws MalformedURLException {
		click(By.className("android.widget.CheckBox"));
	}

	public void clickSwitch() throws MalformedURLException {
		click(MobileBy.AccessibilityId("switch"));
	}

	public String getTextName() throws MalformedURLException {
		return getText(MobileBy.AccessibilityId("nome"));
	}

	public String getOptionCombo() throws MalformedURLException {
		return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public String getTextInputName() throws MalformedURLException {
		return getText(By.xpath("//android.widget.TextView[@text='Nome: Input Data Test']"));
	}

	public boolean isCheckBoxTrue() throws MalformedURLException {
		return isCheckTrue(By.className("android.widget.CheckBox"));
	}

	public boolean isSwitchTrue() throws MalformedURLException {
		return isCheckTrue(MobileBy.AccessibilityId("switch"));
	}

	public void clickSeekBar(double posicao) throws MalformedURLException {
		MobileElement seek_bar = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));

		int delta = 50;

		int xInicial = seek_bar.getLocation().x + delta;

		int x = (int) (xInicial + (seek_bar.getSize().width - 2 * delta) * posicao);

		int y = (seek_bar.getLocation().y) + (seek_bar.getSize().height / 2);

		tap(x, y);
	}

	public void clickBtnSalvar() throws MalformedURLException {
		clickByText("SALVAR");
	}
}
