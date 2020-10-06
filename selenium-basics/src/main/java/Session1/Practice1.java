package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
	
	/*
	 * Navigate to the Cognizant home page.
	 * Click on the link to go to the careers page.
	 * Visually verify that the careers page comes up.
	 */

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cognizant.com");
		
		WebElement careers = driver.findElement(By.xpath("html/body/div[1]/div/div[5]/div[3]/div/div/ul/li[1]/a"));
		careers.click();

	}

}
