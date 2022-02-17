package ctappium.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import ctappium.core.BaseTeste;
import ctappium.page.MenuPage;
import ctappium.page.SeuBarrigaNativoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Menu Seu Barriga Nativo CTAppium")
public class SeuBarrigaNativoTeste extends BaseTeste {
	private MenuPage menu = new MenuPage();
	private SeuBarrigaNativoPage page = new SeuBarrigaNativoPage();

	@Before
	public void menuSeuBarrigaNativo() throws MalformedURLException {
		menu.acessarSBNativo();
	}

	@Test
	@Description("Iteração Login CTAppium")
	public void loginAppReal() throws MalformedURLException {
		page.login();
	}

	@Test
	@Description("Iteração Inserir Conta CTAppium")
	public void inserirConta() throws MalformedURLException {
		page.btnEntrar();
		page.btnReset();
		page.cliqueAbaContas();
		assertTrue(page.getTextElement("CONTAS"), true);
		page.inputNovaConta("Nova Conta");
		page.btnSalvar();
	}

	@Test
	@Description("Iteração Excluir Conta CTAppium")
	public void excluirConta() throws MalformedURLException {
		page.btnEntrar();
		page.btnReset();
		page.cliqueAbaContas();
		assertTrue(page.getTextElement("Conta para alterar"), true);
		menu.longPress("Conta para alterar");
		page.btnExcluir();
	}

	@Test
	@Description("Iteração Campos Mandatórios Movimentação CTAppium")
	public void camposMandatoriosMov() throws MalformedURLException {
		page.btnEntrar();
		page.btnReset();
		page.cliqueAbaMov();
		page.btnSalvar();
		assertTrue(page.getTextElement("Descrição é um campo obrigatório"), true);
		page.inputDescricao("Nova Movimenta��o");
		page.btnSalvar();
		assertTrue(page.getTextElement("Interessado é um campo obrigatório"), true);
	}

	@Test
	@Description("Iteração Inserir Receita CTAppium")
	public void inserirReceita() throws MalformedURLException {
		page.btnEntrar();
		page.btnReset();
		page.cliqueAbaMov();
		assertTrue(page.getTextElement("Receita"), true);
		page.inputDescricao("Nova Movimentação");
		page.inputInteressado("Movimentação");
		page.inputValor("1500.00");
		page.selectOptionCombo("Conta para movimentacoes");
		page.btnSalvar();
		assertTrue(page.getTextElement("Movimentação cadastrada com sucesso"), true);
	}

	@Test
	@Description("Iteração Atualizar Resumo CTAppium")
	public void atualizarResumo() throws MalformedURLException {
		page.btnEntrar();
		page.btnReset();
		assertTrue(page.getTextElement("Dados resetados com sucesso!"), true);
		page.cliqueAbaResumo();
		page.btnRefresh();
		menu.waitElementByXpath("Movimentacao 3, calculo saldo");
		page.swipeElementLeft("Movimentacao 3, calculo saldo");
		page.cliqueBotaoDel();
		menu.presenceOfElement("Movimentação removida com sucesso!");
		page.cliqueAbaHome();
		menu.scroll(0.2, 0.9);
		menu.waitElementByXpath("Conta para saldo");
		menu.scroll(0.2, 0.9);
		assertEquals("-1000.00", page.obterSaldoConta("Conta para saldo"));
	}
}
