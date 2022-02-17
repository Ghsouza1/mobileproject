package ctappium.page;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import ctappium.core.BasePage;

public class AlertasPage extends BasePage {

	public String getTextAlerta(String texto) throws MalformedURLException {
		return getText(By.xpath("//android.widget.TextView[@text='" + texto + "']"));
	}

	public void cliqueAlertaSimples() throws MalformedURLException {
		clickByText("ALERTA SIMPLES");
	}

	public void cliqueAlertaRestritivo() throws MalformedURLException {
		clickByText("ALERTA RESTRITIVO");
	}

	public void cliqueAlertaConfirm() throws MalformedURLException {
		clickByText("ALERTA CONFIRM");
	}

	public void cliqueOK() throws MalformedURLException {
		clickByText("OK");
	}

	public void cliqueSair() throws MalformedURLException {
		clickByText("SAIR");
	}

	public void cliqueConfirmar() throws MalformedURLException {
		clickByText("CONFIRMAR");
	}
}
