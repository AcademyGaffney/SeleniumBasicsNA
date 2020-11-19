package session3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsIntro {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/test/login.html";
		driver.get(baseURL);
		driver.manage().window().maximize();

		
		WebElement username = driver.findElement(By.id("email"));
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(username)
				.click()
				.keyDown(Keys.SHIFT)
				.sendKeys("b")
				.keyUp(Keys.SHIFT)
				.sendKeys("runo")
				.sendKeys(Keys.chord(Keys.SHIFT, "M"))
				.sendKeys("ars")
				.sendKeys(Keys.TAB)
				.sendKeys("qwert1223")
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(" ")
				.build();
		
		seriesOfActions.perform();

	}

}
