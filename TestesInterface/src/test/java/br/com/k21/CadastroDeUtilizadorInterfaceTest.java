package br.com.k21;

import java.util.Random;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.Fluent;
import org.fluentlenium.core.action.FillConstructor;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CadastroDeUtilizadorInterfaceTest extends FluentTest {
	
	@Override
	public WebDriver getDefaultDriver() {
		return new ChromeDriver();
	}
	
	@Test
	public void cadastra_novo_utilizador() {
		
		String email ="wawawiwa@mailinator.com";
		
		abrirPaginaCadastro();
		preencherNome("FCP");			
		fill("#Email").with(email);
		fill("#password_password").with("1234.abc");
		fill("#zipCode").with("1000-123");
		fill("#telephoneNumber").with("987654321");
		
		executeScript("$('#acceptTermsAndConditions').click();");
		
		executeScript("$('#btnRegisterSimple').click();");
		
		await().atMost(5000).until(".email").areDisplayed();
		
		Assert.assertEquals(email, findFirst(".email").getText());
		
	}

	private void preencherNome(String nome) {
		fill("#DisplayName").with(nome);
	}

	private void abrirPaginaCadastro() {
		goTo("https://www.continente.pt/pt-pt/public/registration/Pages/registeruser.aspx");
	}
	
	@Test
	public void tentar_cadastro_sem_aceitar_condicoes() {
		
		String email ="wawawiwa@mailinator.com";
		String msg ="Aceite os termos!";
		
		abrirPaginaCadastro();
		preencherNome("FCP");			
		fill("#Email").with(email);
		fill("#password_password").with("1234.abc");
		fill("#zipCode").with("1000-123");
		fill("#telephoneNumber").with("987654321");
		
		
		executeScript("$('#btnRegisterSimple').click();");
		
		
		Assert.assertEquals(msg, findFirst(".message").getText());
		
	}
	
}
