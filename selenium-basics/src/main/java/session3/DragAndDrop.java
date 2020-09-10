package session3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://jqueryui.com/droppable";

		driver.get(baseURL);
		driver.manage().window().maximize();
		
		WebElement frame=driver.findElement(By.xpath(".//*[@id='content']/iframe"));
		driver.switchTo().frame(frame);
		WebElement source =driver.findElement(By.xpath(".//*[@id='draggable']/p"));
		WebElement destination =driver.findElement(By.xpath(".//*[@id='droppable']"));
		Thread.sleep(1500);
		Actions drop =new Actions(driver);
		drop.dragAndDrop(source,destination).build().perform();

	}

}
