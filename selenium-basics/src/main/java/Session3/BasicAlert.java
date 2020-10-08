package Session3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAlert {

	public static void main(String[] args)  throws NoAlertPresentException,InterruptedException  {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();          		
        driver.get("http://demo.guru99.com/test/delete_customer.php");	
        driver.manage().window().maximize();
        
        driver.findElement(By.name("cusid")).sendKeys("53920");	
        Thread.sleep(1000); 
        driver.findElement(By.name("submit")).click();	
        
        Alert alert = driver.switchTo().alert();

        String alertMessage= alert.getText();		
		
    	
        System.out.println(alertMessage);	
        Thread.sleep(3000);
        
        // Accepting alert		
        alert.accept();	
        
        Thread.sleep(1000);
        alert = driver.switchTo().alert();
        
        alert.accept();
   
        //Canceling alert
        //alert.dismiss();
	}

}
