package tests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.InitialPage;
import pages.LoginPage;
import pages.RegisterPage;

public class GeneralTest {

	private static WebDriver driver;
	private static InitialPage initialPage;
	private static LoginPage loginPage;
	private static RegisterPage registerPage;

	private static String email;
	private static String password;
	private static String name;
	private static String lastName;

	@BeforeAll
	public static void setUpDriver() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 							// Configurando o driver
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		initialPage = new InitialPage(driver);
		loginPage = new LoginPage(driver); 								// Inicializando as páginas
		registerPage = new RegisterPage(driver);
		
	}

	@Test
	public void generalTest() {

		Random randomNumGenerator = new Random();
		int randomNum = randomNumGenerator.nextInt(10000);				//Gerando número aleatório para criar um email novo
		email = "randomMail" + randomNum + "@yopmail.com";				//Concatenando número ao email
		password = "12345678@";
		name = "John";
		lastName = "Doe";
		
		
		
		driver.get("http://automationpractice.com/index.php");			//Driver acessa o site 
		initialPage.gotoLogin();										//Driver clica no botão de fazer login
		loginPage.register(email);										//Driver preenche o campo de email e clica em criar nova conta
		
		registerPage.registerAccount(password, name, lastName);			//Driver preenche o formulário com os dados e cria a conta
		initialPage.logout();											//Driver faz o logout
		initialPage.gotoLogin();										//Driver acessa a página de login
		loginPage.login(email, password);								//Driver acessa a conta recém criada
		
		System.out.println(email);
		System.out.println(password);									//Mostra no console a conta criada
											

	}

	@AfterAll
	public static void exitDriver() {
		driver.quit();													//Encerrando instância do driver
	}
}
