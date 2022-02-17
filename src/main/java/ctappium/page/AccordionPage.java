package ctappium.page;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import ctappium.core.BasePage;

public class AccordionPage extends BasePage {

	public void cliqueOpcao1() throws MalformedURLException {
		clickByText("Opção 1");
	}

	public void cliqueOpcao2() throws MalformedURLException {
		clickByText("Opção 2");
	}

	public void cliqueOpcao3() throws MalformedURLException {
		clickByText("Opção 3");
	}

	public boolean isTextoVisible(String texto) throws MalformedURLException {
		return presenceOfElement(texto);
	}

	public String getTextOpcao(String texto) throws MalformedURLException {
		return getText(By.xpath("//android.widget.TextView[@text='" + texto + "']"));
	}
}
