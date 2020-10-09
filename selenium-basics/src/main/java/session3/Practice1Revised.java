package session3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Practice1Revised {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://www.cognizant.com");
		Thread.sleep(750);
		WebElement careers = null;
		try { 
			driver.findElement(By.xpath("//*[@id=\"bodyId\"]/div[1]/div/div[5]/div[4]/div/div/div[3]/div/div/div")).click();
			careers = driver.findElement(By.xpath("//*[@id=\"offCanvasLeft\"]/div/ul/li[4]/div[1]/div/a"));
		}
		catch(ElementNotInteractableException e) {
			careers = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/div/div/ul/li[1]/a"));
		}
		careers.click();
		 
		

	}

}
