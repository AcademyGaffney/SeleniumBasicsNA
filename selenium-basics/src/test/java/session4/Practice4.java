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

class Practice4 {
	
	static WebDriver driver;
	WebElement email;
	WebElement pword;
	WebElement submit;

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
		String baseURL = "http://demo.guru99.com/test/login.html";

		driver.get(baseURL);
		driver.manage().window().maximize();
		
		email = driver.findElement(By.id("email"));
		pword = driver.findElement(By.id("passwd"));
		submit = driver.findElement(By.id("SubmitLogin"));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSimpleSuccess() {
		email.sendKeys("Goldfish41");
		pword.sendKeys("MyPasswordIsBad");
		submit.submit();
		
		WebElement result = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
		
		assertTrue(result.getText().contains("Successfully Logged"), "Login Failed");
	}

}
