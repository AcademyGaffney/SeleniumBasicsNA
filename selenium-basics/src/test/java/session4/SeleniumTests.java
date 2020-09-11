package session4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeleniumTests {
	private static WebDriver driver;
	private WebElement email;
	private WebElement pword;
	private WebElement submit;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get("http://demo.guru99.com/test/login.html");
		driver.manage().window().maximize();
		
		email = driver.findElement(By.id("email"));
		pword = driver.findElement(By.id("passwd"));
		submit = driver.findElement(By.id("SubmitLogin"));
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	@Test
	void test() {
		email.sendKeys("Goldfish41");
		pword.sendKeys("MyPasswordIsBad");
		submit.click();
		
		String expected = "Successfully Logged in...";
		String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
		
		assertEquals(expected, actual);

	}
	
	@Test
	void test2() {
		email.sendKeys("Goldfish41");
		pword.sendKeys("MyPasswordIsBad");
		submit.sendKeys(" ");
		
		String expected = "Successfully Logged in...";
		String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test3() {
		email.sendKeys("Goldfish41");
		pword.sendKeys("MyPasswordIsBad");
		pword.sendKeys(Keys.ENTER);
		
		String expected = "Successfully Logged in...";
		String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void test4() {
		email.sendKeys("Boxer29");
		email.sendKeys(Keys.TAB); // move to password
		driver.switchTo().activeElement().sendKeys("l33tpword");
		driver.switchTo().activeElement().sendKeys(Keys.TAB); // move to lost password
		driver.switchTo().activeElement().sendKeys(Keys.TAB); // move to submit button
		driver.switchTo().activeElement().sendKeys(" "); //tap space bar
		
		String expected = "Successfully Logged in...";
		String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
		
		assertEquals(expected, actual);
	}

}
