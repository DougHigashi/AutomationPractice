package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	@FindBy(id ="id_gender1")
	private WebElement genderBtn1;
	
	@FindBy(id ="id_gender2")
	private WebElement genderBtn2;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement lastName;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "days")
	private WebElement day;
	
	@FindBy(id = "months")
	private WebElement month;
	
	@FindBy(id = "years")
	private WebElement year;
	
	@FindBy(id = "firstname")
	private WebElement addressName;
	
	@FindBy(id = "lastname")
	private WebElement addressLastName;
	
	@FindBy(id = "address1")
	private WebElement address;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "id_state")
	private WebElement state;
	
	@FindBy(id = "postcode")
	private WebElement zip;
	
	@FindBy(id = "id_country")
	private WebElement country;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobilePhone;
	
	
	@FindBy(id = "submitAccount")
	private WebElement registerBtn;
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void registerAccount(String passwd, String name, String lName) {
		genderBtn1.click();
		firstName.sendKeys(name);
		lastName.sendKeys(lName);
		password.sendKeys(passwd);
		
		Select dayBox = new Select(day);
		dayBox.selectByValue("15");
		
		Select monthBox = new Select(month);
		monthBox.selectByValue("11");
		
		Select yearBox = new Select(year);
		yearBox.selectByValue("2000");
		
		addressName.sendKeys(name);
		addressLastName.sendKeys(lName);
		address.sendKeys("4028  Eagles Nest Drive");
		city.sendKeys("Sacramento");
		
		Select stateBox = new Select(state);
		stateBox.selectByValue("5");
		
		zip.sendKeys("95814");
		Select countryBox = new Select(country);
		countryBox.selectByValue("21");
		
		mobilePhone.sendKeys("916-523-5702");
		
		
		registerBtn.click();
		
		
	}
	
	
	
	
	
	
	
	

}
