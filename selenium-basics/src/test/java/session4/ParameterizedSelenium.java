package session4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ParameterizedSelenium {
	private static WebDriver driver;
	private static String baseURL = "http://demo.guru99.com/insurance/v1/header.php";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get(baseURL);
		WebElement requestTab = driver.findElement(By.id("newquote"));
		requestTab.click();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@ParameterizedTest
	@CsvSource({"30000, 20000, 280" , "20000, 10000, 300"})// second premium should be 140
	void testMileageValue(String miles, String value, String premium) throws InterruptedException {
		WebElement milField = driver.findElement(By.id("quotation_vehicle_attributes_mileage"));
		WebElement valField = driver.findElement(By.id("quotation_vehicle_attributes_value"));
		WebElement calcButton = driver.findElement(By.xpath("//*[@id=\"new_quotation\"]/div[8]/input[1]"));
		
		milField.sendKeys(miles);
		valField.sendKeys(value);
		calcButton.click();
		//Thread.sleep(5000);
		WebElement quote = driver.findElement(By.id("calculatedpremium"));
		String quoteText = quote.getText();
		int poundSign = quoteText.indexOf('\u00A3');
		String cost = quoteText.substring(poundSign + 1);
		
		assertEquals(premium, cost.trim());
	}


}
