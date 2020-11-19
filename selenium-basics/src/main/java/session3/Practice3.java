package session3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice3 {
	
	public static void main(String [] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
	
		String baseURL = "http://demo.guru99.com/test/radio.html";
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		WebElement o2 = driver.findElement(By.id("vfb-7-2"));
		
		Actions builder = new Actions(driver);
		builder
			.moveToElement(o2)
			.click()
			.sendKeys("\t")
			.sendKeys("\t")
			.sendKeys(" ")
			.sendKeys("\t")
			.sendKeys(" ")
			.build()
			.perform();
			
	}
	
}
