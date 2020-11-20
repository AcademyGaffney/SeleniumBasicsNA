package session3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/popup.php";
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		/*
		 * Selenium gives each window that opens its own handle.  These aren't meaningful
		 * but we use them to move to a window or identify which window we're on.
		 * Like elements, we can get one or all of them. Here we grab the handle for our
		 * main window. We'll need it shortly.
		 */
		
		String main = driver.getWindowHandle();

		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		/*
		 * Despite the browser opening a new tab/window and switching focus to it,
		 * our driver is still on the main window, so the following two lines
		 * won't work for what they're intended.
		 */
		//String popUp = driver.getWindowHandle();
		//WebElement emailField = driver.findElement(By.name("emailid"));
		
		/*
		 * Instead, we need to get all of the handles and determine which one
		 * is the new one. This is made slightly more annoying by the fact that
		 * the handles come in a set rather than a list, so we can't just grab the
		 * last one.
		 */
		
		Set<String> windows = driver.getWindowHandles();
		String popup = "";
		
		for(String w : windows) {
			if(!(main.equals(w)))
					popup = w;
		}
		
		//Here we're just telling the driver to switch to the window that's open.
		driver.switchTo().window(popup);
		driver.findElement(By.name("emailid")).sendKeys("me@example.com");
		
		//We can also use switchTo to change the visible/active window.

		Thread.sleep(1000);
		driver.switchTo().window(main);
		Thread.sleep(1000);
		driver.switchTo().window(popup);
		Thread.sleep(1000);
		driver.findElement(By.name("btnLogin")).click();
		
		driver.close(); //closes the current window
		Thread.sleep(2000);
		
		//We're now pointed to the orphan window, so we need to switch back
		driver.switchTo().window(main);

		driver.quit(); //closes the session.
	}

}
