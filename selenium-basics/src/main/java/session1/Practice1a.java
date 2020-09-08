package session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1a {
	
	/*
	 * Navigate to the Cognizant home page.
	 * Click on the link to go to the careers page.
	 * Visually verify that the careers page comes up.
	 */

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cognizant.com");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"bodyId\"]/div[1]/div/div[5]/div[4]/div/div/div[3]/div")).click();
		Thread.sleep(2000);
		WebElement careers = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/ul/li[4]/div[1]/div/a"));
		
		careers.click();
	}
}
