package ctappium.page;

import ctappium.core.BasePage;
import static ctappium.core.DriverFactory.getDriver;
import java.net.MalformedURLException;
import java.util.Set;
import ctappium.data.DataFaker;
import org.openqa.selenium.By;
import com.github.javafaker.Faker;

public class WebViewPage extends BasePage {

	public void setContextWeb() throws MalformedURLException {
		Set<String> contextoHandles = getDriver().getContextHandles();

//		for (String contextName : contextoHandles) {
//			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
//		}
		getDriver().context((String) contextoHandles.toArray()[1]); // set context to WEBVIEW_1
	}

	public void sairContextWeb() throws MalformedURLException {
		Set<String> contextoHandles = getDriver().getContextHandles();
		getDriver().context((String) contextoHandles.toArray()[0]); // set context to NATIVE_APP
	}

	public void registerNewUser() throws MalformedURLException {

		sendKeys(By.id("nome"), DataFaker.firstName() + " " + DataFaker.lastName());
		sendKeys(By.id("email"), DataFaker.emailAddress());
		sendKeys(By.id("senha"), DataFaker.password());
		click(By.xpath("//*[@class='btn btn-primary']"));
	}

	public void login() throws MalformedURLException {

		String emailLogin = "ghsouza89+teste@gmail.com";
		String pswLogin = "Gust@v089";

		sendKeys(By.id("email"), emailLogin);
		sendKeys(By.id("senha"), pswLogin);
		click(By.xpath("//*[@class='btn btn-primary']"));
	}

}
