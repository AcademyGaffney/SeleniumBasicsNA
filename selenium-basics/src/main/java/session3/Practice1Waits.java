package session3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1Waits {

	/*
	 * Navigate to the Cognizant home page. Click on the link to go to the careers
	 * page. Visually verify that the careers page comes up. Using waits and
	 * exception handling to ensure it works on either responsive arrangement of the
	 * page
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cognizant.com");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		WebElement careers = null;

		try {
			driver.findElement(By.xpath("//*[@id=\"bodyId\"]/div[1]/div/div[5]/div[4]/div/div/div[3]/div/div/div")).click();
			careers = driver.findElement(By.xpath("//*[@id=\"offCanvasLeft\"]/div/ul/li[4]/div[1]/div/a"));
		} catch (ElementNotInteractableException e) {
			careers = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/div/div/ul/li[1]/a"));
		}

		careers.click();

	}

}
