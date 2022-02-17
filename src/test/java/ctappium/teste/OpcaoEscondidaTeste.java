package ctappium.teste;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.MenuPage;
import ctappium.page.OpcaoEscondidaPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Opção Escondida CTAppium")
public class OpcaoEscondidaTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private OpcaoEscondidaPage page = new OpcaoEscondidaPage();

	@Before
	public void validarMenuApp() throws MalformedURLException {
		menu.menuApp();
	}

	@Test
	@Description("Iteração Opção Escondida CTAppium")
	public void deveEncontrarOpcaoEscondida() throws MalformedURLException {
		menu.scrollDown();
		menu.acessarOpcaoEscondida();
		assertTrue(page.getTextAlerta("Sucesso"), true);
		assertTrue(page.getTextAlerta("Você achou essa opção"), true);
		page.cliqueOK();
	}
}
