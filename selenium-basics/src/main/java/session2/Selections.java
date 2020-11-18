package session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selections {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseURL = "http://demo.guru99.com/test/newtours/register.php";

		driver.get(baseURL);
		driver.manage().window().maximize();
		
		Select country = new Select(driver.findElement(By.name("country")));
		
		country.selectByIndex(4);
		
		WebElement selected = country.getFirstSelectedOption();
		
		System.out.println(selected.getText());
	}

}
