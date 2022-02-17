package ctappium.teste;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import ctappium.core.BaseTeste;
import ctappium.page.AbasPage;
import ctappium.page.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Abas CTAppium")
public class AbasTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();

	@Before
	public void menuAbas() throws MalformedURLException {
		menu.menuApp();
		menu.acessarAbas();
	}

	@Test
	@Description("Iteração aba 1 CTAppium")
	public void iteracaoAba1() throws MalformedURLException {
		page.cliqueAba1();
		assertTrue(page.getTextAba("Este é o conteúdo da Aba 1"), true);
	}

	@Test
	@Description("Iteração aba 2 CTAppium")
	public void iteracaoAba2() throws MalformedURLException {
		page.cliqueAba2();
		assertTrue(page.getTextAba("Este é o conteúdo da Aba 2"), true);
	}

}
