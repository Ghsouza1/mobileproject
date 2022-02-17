package ctappium.teste;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.MenuPage;
import ctappium.page.SwipeListPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Swipe List CTAppium")
public class SwipeListTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Before
	public void menuSwipeList() throws MalformedURLException {
		menu.acessarSwipeList();
	}

	@Test
	@Description("Iteração Swipe List CTAppium")
	public void fazerSwipeOpcao1() throws MalformedURLException {
		menu.presenceOfElement("Opção 1");
		page.swipeElementLeft("Opção 1");
		page.cliqueBotaoMais();
		menu.waitElementByXpath("Opção 1 (+)");
		menu.waitElementByXpath("Opção 1 (+)");
		page.swipeElementRight("Opção 5 (-)");
		menu.waitElementByXpath("Opção 5");
		menu.waitElementByXpath("Opção 5");
	}
}
