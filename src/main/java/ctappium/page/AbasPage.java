package ctappium.page;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import ctappium.core.BasePage;

public class AbasPage extends BasePage {
	public void cliqueAba1() throws MalformedURLException {
		clickByText("ABA 1");
	}

	public void cliqueAba2() throws MalformedURLException {
		clickByText("ABA 2");
	}

	public String getTextAba(String texto) throws MalformedURLException {
		return getText(By.xpath("//android.widget.TextView[@text='" + texto + "']"));
	}
}
