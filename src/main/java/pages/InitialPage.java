package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPage {
	
	@FindBy(className = "logout")
	private WebElement logoutBtn;
	@FindBy(className = "header_user_info")
	private WebElement profileBtn;
	
	@FindBy(className = "login")
	private WebElement loginBtn;
	
	public InitialPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void gotoLogin() {
		loginBtn.click();
	}
	public void logout() {
		logoutBtn.click();
	}
	

}
