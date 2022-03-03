package ctappium.page;

import static org.junit.Assert.assertArrayEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import ctappium.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarFormulario() throws MalformedURLException {
		clickByText("Formulário");
	}

	public void acessarSplash() throws MalformedURLException {
		clickByText("Splash");
	}

	public void acessarAlertas() throws MalformedURLException {
		clickByText("Alertas");
	}

	public void acessarAbas() throws MalformedURLException {
		clickByText("Abas");
	}

	public void acessarAccordion() throws MalformedURLException {
		clickByText("Accordion");
	}

	public void acessarCliques() throws MalformedURLException {
		clickByText("Cliques");
	}

	public void acessarSwipe() throws MalformedURLException {
		clickByText("Swipe");
	}

	public void acessarSwipeList() throws MalformedURLException {
		scrollUp();
		clickByText("Swipe List");
	}

	public void acessarDragAndDrop() throws MalformedURLException {
		scrollUp();
		clickByText("Drag and drop");
	}

	public void acessarSBHibrido() throws MalformedURLException {
		clickByText("SeuBarriga Híbrido");
	}

	public void acessarSBNativo() throws MalformedURLException {
		clickByText("SeuBarriga Nativo");
	}

	public void acessarOpcaoEscondida() throws MalformedURLException {
		clickByText("Opção bem escondida");
	}

	public void menuApp() throws MalformedURLException {
		String[] menu = new String[] { "About...", "Formulário", "SeuBarriga Nativo", "SeuBarriga Híbrido", "Alertas",
				"Splash", "Abas", "Accordion", "Cliques", "Swipe", "Swipe List", "Drag and drop" };

		assertArrayEquals(menu, getList(By.className("android.widget.TextView")));
	}
}
