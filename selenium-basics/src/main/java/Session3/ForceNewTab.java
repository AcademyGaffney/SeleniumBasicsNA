package Session3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ForceNewTab {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/test/login.html";

		driver.get(baseURL);
		driver.manage().window().maximize();
		String main = driver.getWindowHandle();
		Thread.sleep(2000);
		WebElement insurance = driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div/ul/li[2]/a"));
		// Actions action = new Actions(driver);
		// action.contextClick(insurance).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		insurance.sendKeys(Keys.chord(Keys.COMMAND, Keys.RETURN));

		Set<String> windows = driver.getWindowHandles();

		String popup = "";

		for (String w : windows) {
			if (!(main.equals(w)))
				popup = w;
		}
		// Here we're just telling the driver to switch to the window that's open.
		driver.switchTo().window(popup);
		driver.findElement(By.name("submit")).click();

		// This, of course, has to be Keys.CONTROL on a PC. Keys.SHIFT gives a new
		// window on either platform.

	}

}
