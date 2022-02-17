package ctappium.teste;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Swipe CTAppium")
public class SwipeTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();

	@Before
	public void menuSwipe() throws MalformedURLException {
		menu.acessarSwipe();
	}

	@Test
	@Description("Iteração Swipe CTAppium")
	public void fazerSwipe() throws MalformedURLException {
		menu.waitElementByXpath("Mova a tela para");
		menu.swipeLeft();
		menu.waitElementByXpath("E veja se");
		menu.swipeLeft();
		menu.waitElementByXpath("Chegar até o fim!");
		menu.swipeRight();
		menu.waitElementByXpath("E veja se");
		menu.swipeRight();
	}
}
