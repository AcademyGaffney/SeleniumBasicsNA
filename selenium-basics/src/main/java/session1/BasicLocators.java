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
		
		/*
		 * As we can see in the test page's HTML, the text that results from the Check button being clicked
		 * doesn't have an ID or name (as is often the case with simple text).
		 * The xpath is the most general puropse way of finding an element on a web page. It consists of a 
		 * complete drill-down of HTML tags to the particular tag one is looking for.  So in this case, it's
		 * telling findElement to grab the third paragraph tag inside the form tag inside the second 
		 * div tag inside the body tag inside the html tag.
		 * Fortunately, you never have to do that by hand unless someone hands you a print out of HTML.
		 * For testing purposes, it *should* be part of the specification. It can also be found very easily in
		 * the browser's inspector, as we'll see.
		 */
		WebElement text = driver.findElement(By.xpath("/html/body/div[2]/form/p[3]"));
		System.out.println(text.getText());
		
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
		
		driver.quit();

	}

}
