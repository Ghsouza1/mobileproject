package ctappium.teste;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.MenuPage;
import ctappium.page.SplashPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import static org.junit.Assert.assertTrue;

@Feature("Menu Splash CTAppium")
public class SplashTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();

	@Before
	public void menuSplash() throws MalformedURLException {
		menu.acessarSplash();
	}

	@Test
	@Description("Iteração Splash CTAppium")
	public void deveAguardarSplashSumir() throws MalformedURLException {
		page.isTelaSplashVisible();

		page.aguardarSplashSumir();

		assertTrue(menu.presenceOfElement("About..."));
	}

}
