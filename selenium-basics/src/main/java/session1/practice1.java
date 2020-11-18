package session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice1 {

	public static void main(String [] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cognizant.com");
		driver.manage().window().maximize();
		
		WebElement careers = driver.findElement(By.xpath("//*[@id=\"bodyId\"]/div[1]/div/div[5]/div[3]/div/div/ul/li[1]/a"));
		careers.click();
	}
}
