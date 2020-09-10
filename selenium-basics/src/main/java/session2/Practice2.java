package session2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/test/radio.html";
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		List<WebElement> group = driver.findElements(By.name("webform"));

		group.get(2).click();
		group.get(2).sendKeys(Keys.ARROW_DOWN);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(" ");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(" ");
		
		for(WebElement e : group) {
			System.out.println(e.getAttribute("value") + ": " + (e.isSelected() ? "Checked" : "Unchecked"));
		}
		
		driver.quit();

	}

}
