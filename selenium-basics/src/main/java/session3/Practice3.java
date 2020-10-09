package session3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Practice3 {

	/*
	 * Perform the login/password/submit operations on 
	 * http://demo.guru99.com/test/login.html
	 * using a single action
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/test/login.html";

		driver.get(baseURL);
		driver.manage().window().maximize();  
		WebElement email = driver.findElement(By.id("email"));
		
		Actions builder = new Actions(driver);
		Action login = builder
			.moveToElement(email)
			.click()
			.sendKeys("MyName")
			.sendKeys(Keys.TAB)
			.sendKeys("passowrd")
			.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			.sendKeys(" ")
			.build();
		login.perform();
	}

}
