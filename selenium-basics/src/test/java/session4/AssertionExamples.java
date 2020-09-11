package session4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AssertionExamples {
	
	private static WebDriver driver;
	private static String baseURL = "http://demo.guru99.com/test/login.html";
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
		driver.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get(baseURL);
		email = driver.findElement(By.id("email"));
		pword = driver.findElement(By.id("passwd"));
		submit = driver.findElement(By.id("SubmitLogin"));

	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void testEquals() {
		/*
		 * assertEquals() and assertNotEquals() compare parameters based on .equals()
		 * for object types.
		 */
		String expected = "Password";
		String found = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/form/div/div[2]/label")).getText();
		assertEquals(expected, found);
	}
	
	@Test
	void notSameTest() {
		/*
		 * assertSame() and assertNotSame() compare parameters based on == for all
		 * types, thus for objects checking whether they are the same object, not the
		 * same contents.
		 */
		String expected = "Password";
		String found = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/form/div/div[2]/label")).getText();
		/*
		 * Note that you can have multiple assertions in the same test case. JUnit works
		 * by failed assertions throwing an exception, however, so the execution of the
		 * test stops when the first assertion fails.
		 */
		assertSame(2, 2);
		assertNotSame(expected, found);
	}
	
	@Test
	void nullTest() {
		/*
		 * assertNull and assertNotNull test for whether an object exists or not.
		 */

		WebElement el = null;
		assertNull(el);
		el = driver.findElement(By.id("email"));
		assertNotNull(el);
	}
	
	@Test
	void trueTest() {
		/*
		 * assertTrue and assertFalse take boolean expressions and simply test their
		 * value. They're useful for more complex situations where other Assertions
		 * don't easily apply.
		 */
		String found = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/form/div/div[2]/label")).getText();
		assertTrue(found.contains("Pass"));

	}
	

	@Test
	void throwstest() {
		/*
		 * assertThrows checks that the action in question throws the 
		 * expected exception and fails if it does not
		 */
		
		assertThrows(NoSuchElementException.class, () -> {
			driver.findElement(By.id("username"));
		});
		
		//old-school alternative
		try {
			driver.findElement(By.id("username"));
			fail("banned ID used");
		}
		catch(NoSuchElementException e) {
			
		}
	}

}
