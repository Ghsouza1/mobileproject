package ctappium.page;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import ctappium.core.BasePage;

public class OpcaoEscondidaPage extends BasePage {

	public String getTextAlerta(String texto) throws MalformedURLException {
		return getText(By.xpath("//android.widget.TextView[@text='" + texto + "']"));
	}

	public void cliqueOK() throws MalformedURLException {
		clickByText("OK");
	}

}
