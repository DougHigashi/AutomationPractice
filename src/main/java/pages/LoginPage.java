package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "email_create")
	private WebElement registerField;
	@FindBy(id = "SubmitCreate")
	private WebElement registerBtn;
	
	
	@FindBy(id = "email")
	private WebElement loginEmailField;
	@FindBy(id = "passwd")
	private WebElement loginPasswordField;
	@FindBy(id = "SubmitLogin")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void register(String email) {
		registerField.sendKeys(email);
		registerBtn.click();
	}
	
	public void login(String email, String passwd) {
		loginEmailField.sendKeys(email);
		loginPasswordField.sendKeys(passwd);
		loginBtn.click();
	}
	

}
