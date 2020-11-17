package session1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		
		String baseURL = "http://demo.guru99.com/test/ajax.html";
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		/*
		 * Locating a single element
		 * WebDriver.findElement() returns a single element based on some identifying property.
		 * It scans from the top of the HTML, and so it returns the first match if there are multiple matches.
		 * If there are no matches, it throws a NoSuchElementException.
		 * 
		 * "By" is the class containing the methods corresponding to the several properties that
		 * can be found by. In this file, we'll look at "id", "name", and "xpath". id and name 
		 * are HTML properties that are optional on many different tags. They are used when referring to 
		 * particular elements in JavaScript or server code. It's also very handy for testing if tags have
		 * unique ids or names.
		 * 
		 * WebElement is a general-purpose class representing an element on a web page.  It contains a 
		 * number of methods allowing us to interact with and check the status of said element.
		 * 
		 * Here we're finding the "yes" radio button by ID, selecting it, then finding and clicking the "Check"
		 * button.
		 */
		WebElement yesButton = driver.findElement(By.id("yes"));
		yesButton.click();
		
		driver.findElement(By.id("buttoncheck")).click();

		WebElement text = driver.findElement(By.className("radiobutton"));
		System.out.println(text.getText().contains("Yes"));
		System.out.println(text.getText());
		
		
		driver.findElement(By.xpath("/html/body/div[2]/form/p[2]/input[1]")).click();
		System.out.println(yesButton.isSelected());
		
		/*
		 * Locating multiple elements
		 * WebDriver.findElements() is the method we use to find all of the elements on a page matching a particular
		 * property. It returns a list of WebElements, which is empty if none are found.
		 * 
		 * We can then access individual WebElements or iterate through them and work with them just as if we found
		 * them individually with findElement.
		 */
	
		List<WebElement> elements = driver.findElements(By.name("name"));

		for(WebElement el : elements) {
			el.click();
			driver.findElement(By.id("buttoncheck")).click();
			System.out.println(driver.findElement(By.xpath("/html/body/div[2]/form/p[3]")).getText());
		}


	}

}
