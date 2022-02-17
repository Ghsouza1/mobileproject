package ctappium.teste;

import java.net.MalformedURLException;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ctappium.core.BaseTeste;
import ctappium.page.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Drag And Drop CTAppium")
public class DragAndDropTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private String[] estadoInicial = new String[] { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "qualquer local desejado.", };

	@Before
	public void menuDragAndDrop() throws MalformedURLException {
		menu.menuApp();
		menu.acessarDragAndDrop();
	}

	@Test
	@Description("Iteração Drag And Drop CTAppium")
	public void deveEfetuarDradgAndDrop() throws MalformedURLException {
		menu.waitElementByXpath("Drag em Drop!");
		assertArrayEquals(estadoInicial, menu.getList(By.className("android.widget.TextView")));
		menu.dragAndDrop("qualquer local desejado.", "Esta");
	}
}
