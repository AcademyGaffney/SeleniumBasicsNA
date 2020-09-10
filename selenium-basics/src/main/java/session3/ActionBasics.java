package session3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionBasics {

	public static void main(String[] args) {
		/*
		 * Using the mouse involves building Actions, which are multi-step processes
		 * that are defined and then executed as a block. All mouse actions need to 
		 * be in an action even if there is only one.  The other case we'll see here 
		 * is that of keyboard actions requiring the use of modifier keys (control, shift, etc).
		 */
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/test/login.html";
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		WebElement txtUsername = driver.findElement(By.id("email"));
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
		
		seriesOfActions.perform();
		
		


	}

}
