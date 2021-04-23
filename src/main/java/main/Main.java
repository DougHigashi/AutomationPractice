package main;

import java.util.List;
import java.util.stream.Collectors;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class Main {

	public static void main(String[] args) {

		WebDriver driver = new OperaDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://amazon.com");
		
		WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
		 String searchPhrase = "iphone";
		searchInput.sendKeys(searchPhrase);
		searchInput.sendKeys(Keys.ENTER);
		
		
		List<String> actualItems = driver.findElements(By.cssSelector("[data-component-type='s-search-result'] h2 .a-link-normal"))
				.stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());
        List<String> expectedItems = actualItems.stream()
                .filter(item -> item.contains(searchPhrase))
                .collect(Collectors.toList());
		//Assertions.assertEquals(expectedItems, actualItems);

        driver.quit();
	}

}
