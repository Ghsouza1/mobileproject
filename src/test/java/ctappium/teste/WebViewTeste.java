package ctappium.teste;

import java.net.MalformedURLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.MenuPage;
import ctappium.page.WebViewPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Web View CTAppium")
public class WebViewTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();

	@Before
	public void menuWebView() throws MalformedURLException {
		menu.acessarSBHibrido();
	}

	@Test
	@Description("Iteração Criar Novo User CTAppium")
	public void newUser() throws MalformedURLException {
		menu.clickByText("Novo usuário?");
		page.setContextWeb();
		page.registerNewUser();
	}

	@Test
	@Description("Iteração Login User CTAppium")
	public void loginUser() throws MalformedURLException {
		page.setContextWeb();
		page.login();

	}

	@After
	public void sairWebView() throws MalformedURLException {
		page.sairContextWeb();
	}
}
