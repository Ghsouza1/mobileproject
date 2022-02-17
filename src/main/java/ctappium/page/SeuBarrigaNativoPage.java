package ctappium.page;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import ctappium.core.BasePage;
import ctappium.core.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class SeuBarrigaNativoPage extends BasePage {

	public void login() throws MalformedURLException {

		String emailLogin = "ghsouza@gmail.com";
		String pswLogin = "Gust@v089";

		sendKeys(By.xpath("//*[@text='Nome']"), emailLogin);
		sendKeys(By.xpath("//*[@text='Senha']"), pswLogin);
		clickByText("ENTRAR");
	}

	public void btnEntrar() throws MalformedURLException {
		clickByText("ENTRAR");
	}

	public void btnReset() throws MalformedURLException {
		clickByText("RESET");
	}

	public void btnRefresh() throws MalformedURLException {
		clickByText("ATUALIZAR");
	}

	public void cliqueAbaContas() throws MalformedURLException {
		clickByText("CONTAS");
	}

	public void cliqueAbaMov() throws MalformedURLException {
		clickByText("MOV...");
	}

	public void cliqueAbaResumo() throws MalformedURLException {
		clickByText("RESUMO");
	}

	public void cliqueAbaHome() throws MalformedURLException {
		clickByText("HOME");
	}

	public void btnExcluir() throws MalformedURLException {
		clickByText("EXCLUIR");
	}

	public void btnSalvar() throws MalformedURLException {
		clickByText("SALVAR");
	}

	public void inputNovaConta(String name) throws MalformedURLException {
		sendKeys(By.xpath("//android.widget.EditText[@text='Conta']"), name);
	}

	public void inputDescricao(String name) throws MalformedURLException {
		sendKeys(By.xpath("//android.widget.EditText[@text='Descrição']"), name);
	}

	public void inputInteressado(String name) throws MalformedURLException {
		sendKeys(By.xpath("//android.widget.EditText[@text='Interessado']"), name);
	}

	public void inputValor(String name) throws MalformedURLException {
		sendKeys(By.xpath("//android.widget.EditText[@text='Valor']"), name);
	}

	public void selectOptionCombo(String option) throws MalformedURLException {
		selectCombo(By.xpath("//*[@text='Selecione uma conta...']"), option);
	}

	public void swipeElementLeft(String opcao) throws MalformedURLException {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
	}

	public void swipeElementRight(String opcao) throws MalformedURLException {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
	}

	public void cliqueBotaoDel() throws MalformedURLException {
		new TouchAction(DriverFactory.getDriver())
				.tap(ElementOption.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Del']/.."))))
				.perform();
	}

	public String obterSaldoConta(String conta) throws MalformedURLException {
		return getText(By.xpath("//*[@text='" + conta + "']/following-sibling::android.widget.TextView"));
	}

	public String getTextElement(String texto) throws MalformedURLException {
		return getText(By.xpath("//android.widget.TextView[@text='" + texto + "']"));
	}
}
