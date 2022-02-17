package ctappium.teste;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.net.MalformedURLException;
import ctappium.core.BaseTeste;
import ctappium.page.FormPage;
import ctappium.page.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Formulário CTAppium")
public class FormTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private FormPage page = new FormPage();

	@Before
	public void menuFormulario() throws MalformedURLException {
		menu.menuApp();
		menu.acessarFormulario();
	}

	@Test
	@Description("Iteração Preencher Campo Nome CTAppium")
	public void preencherTxt() throws MalformedURLException {
		page.sendKeysName("Editando Campo Texto");
		assertEquals("Editando Campo Texto", page.getTextName());
	}

	@Test
	@Description("Iteração Selecionar Combo CTAppium")
	public void selecionarCombo() throws MalformedURLException {
		page.selectOptionCombo("PS4");
		assertEquals("PS4", page.getOptionCombo());
	}

	@Test
	@Description("Iteração Switch CTAppium")
	public void iteracaoCheckeSwitch() throws MalformedURLException {
		assertFalse(page.isCheckBoxTrue());
		assertTrue(page.isSwitchTrue());

		page.clickCheckBox();
		page.clickSwitch();

		assertTrue(page.isCheckBoxTrue());
		assertFalse(page.isSwitchTrue());
	}

	@Test
	@Description("Iteração Preencher Formulário CTAppium")
	public void inputData() throws MalformedURLException {
		page.sendKeysName("Input Data Test");
		page.selectOptionCombo("PS4");
		page.clickDate("01/01/2000");
		page.setDate("15 February 2000");
		page.cliqueOK();
		page.clickHour("06:00");
		page.setHour("12", "30");
		page.cliqueOK();
		page.clickCheckBox();
		page.clickSwitch();
		page.clickSeekBar(0.80);
		page.clickBtnSalvar();
		assertEquals("Nome: Input Data Test", page.getTextInputName());
	}
}
