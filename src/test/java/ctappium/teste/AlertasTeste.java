package ctappium.teste;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.AlertasPage;
import ctappium.page.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Alertas CTAppium")
public class AlertasTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private AlertasPage page = new AlertasPage();

	@Before
	public void menuAlertas() throws MalformedURLException {
		menu.acessarAlertas();
	}

	@Test
	@Description("Iteração Alerta Simples CTAppium")
	public void alertaSimples() throws MalformedURLException {
		page.cliqueAlertaSimples();
		assertTrue(page.getTextAlerta("Pode clicar no OK ou fora da caixa para sair"), true);
		page.cliqueOK();
	}

	@Test
	@Description("Iteração Alerta Restritivo CTAppium")
	public void alertaRestritivo() throws MalformedURLException {
		page.cliqueAlertaRestritivo();
		assertTrue(page.getTextAlerta("Não pode clicar fora, apenas no SAIR"), true);
		page.cliqueSair();
	}

	@Test
	@Description("Iteração Alerta Confirma CTAppium")
	public void alertaConfirma() throws MalformedURLException {
		page.cliqueAlertaConfirm();
		assertTrue(page.getTextAlerta("Confirma a operação?"), true);
		page.cliqueConfirmar();
		page.cliqueSair();
	}

}
