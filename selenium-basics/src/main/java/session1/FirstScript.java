package session1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//comment the above line and uncomment below line to use Firefox
//import import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript {

	public static void main(String[] args) {
		/*
		 * First we need to register the web driver we'll be using to run our browser.
		 * We set the property for the Chrome driver we're using to the actual executable we're using.
		 * "chromedriver" is the Mac web driver I'm using.  For windows, copy your 
		 * chromedriver.exe into the project folder and change the below to "chromedirver.exe"
		 */
		
		System.setProperty("webdriver.chrome.driver",  "chromedriver");
		
		/*
		 * Next, we need to create the core object we use for working with our browser, our WebDriver object.
		 * We'll see various uses for this as we go on.
		 */

		WebDriver driver = new ChromeDriver();
		
		/*
    	 * Here we're just declaring our starting point as a String.  This is just for code cleanliness.
    	 */
        String baseUrl = "http://www.cognizant.com";
		
        /*
         * .get() is our first WebDriver method.  It simply makes an HTML "get" request for a given page
         * get requests should retrieve data only.
         */
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        /*
         * As title is a common, page-level attribute, WebDriver provides us with a simple method for 
         * retrieving it.  We'll see how to find more arbitrary information as we go forward.
         */
        System.out.println(driver.getTitle());


        /*
         * Finally, by closing the driver (as we would any other resource), we close all browser
         * windows that the driver was responsible for opening.
         */
        driver.quit();

	}

}
