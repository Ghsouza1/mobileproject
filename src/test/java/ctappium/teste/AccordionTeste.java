package ctappium.teste;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.AccordionPage;
import ctappium.page.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Accordion CTAppium")
public class AccordionTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();

	@Before
	public void menuAccordion() throws MalformedURLException {
		menu.acessarAccordion();
	}

	@Test
	@Description("Iteração opção 1 CTAppium")
	public void iteracaoOpcao1() throws MalformedURLException {
		page.cliqueOpcao1();
		assertTrue(page.getTextOpcao("Esta é a descrição da opção 1"), true);
	}

	@Test
	@Description("Iteração opção 2 CTAppium")
	public void iteracaoOpcao2() throws MalformedURLException {
		page.cliqueOpcao2();
		assertTrue(page.getTextOpcao("Esta é a descrição da opção 2"), true);
	}

	@Test
	@Description("Iteração opção 3 CTAppium")
	public void iteracaoOpcao3() throws MalformedURLException {
		page.cliqueOpcao3();
		assertTrue(page.getTextOpcao("Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha"),
				true);
	}

}
