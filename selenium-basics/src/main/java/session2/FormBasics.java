package session2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormBasics {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseURL = "http://demo.guru99.com/test/login.html";
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement pword = driver.findElement(By.id("passwd"));
		WebElement submit = driver.findElement(By.id("SubmitLogin"));
		
		//sendKeys can be used for entering text or for any arbitrary keys to be sent to an element
		
		email.sendKeys("Goldfish41");
		Thread.sleep(500);
		pword.sendKeys("MyPasswordIsBad");
		Thread.sleep(1000);
		
		//There are multiple options for submitting a form with a standard submit behavior.
		
		//Click the submit button
		//submit.click();
		
		//use the form submit method on any form element
		//email.submit();
		//pword.submit()
		//submit.submit();
		
		//Hit "enter" on either field or the submit button
		//email.sendKeys(Keys.ENTER);
		pword.sendKeys(Keys.ENTER);
		//submit.sendKeys(Keys.ENTER);
		
		//Hit "\n" (new line) on either field or the submit button
		//email.sendKeys("\n");
		//pword.sendKeys("\n");
		//submit.sendKeys("\n");

		//tap spacebar on submit button
		//submit.sendKeys(" ");
		
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		email = driver.findElement(By.id("email"));
		email.clear();
		email.click();
		
		driver.switchTo().activeElement().sendKeys("Boxer34");
		Thread.sleep(500);
		driver.switchTo().activeElement().sendKeys("\t");
		driver.switchTo().activeElement().sendKeys("BetterP@ssW0rd");
		Thread.sleep(500);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Thread.sleep(500);
		driver.switchTo().activeElement().sendKeys("\t");
		Thread.sleep(500);
		driver.switchTo().activeElement().sendKeys(" ");
		
		if(driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText().contains("Successfully Logged")) {
			System.out.println("Login Successful");
		}
		else {
			System.out.println("Login Failed");
		}
		
		

	}

}
