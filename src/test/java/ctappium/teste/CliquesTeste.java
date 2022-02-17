package ctappium.teste;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.CliquesPage;
import ctappium.page.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import static org.junit.Assert.assertEquals;

@Feature("Menu Cliques CTAppium")
public class CliquesTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();

	@Before
	public void menuCliques() throws MalformedURLException {
		menu.acessarCliques();
	}

	@Test
	@Description("Iteração Clique Longo CTAppium")
	public void realizarCliqueLongo() throws MalformedURLException {
		menu.longPress("Clique Longo");
		assertEquals("Clique Longo", page.obterTextoCampo());
	}

	@Test
	@Description("Iteração Clique Duplo CTAppium")
	public void realizarCliqueDuplo() throws MalformedURLException {
		page.clickByText("Clique duplo");
		page.clickByText("Clique duplo");
		assertEquals("Duplo Clique", page.obterTextoCampo());
	}
}
