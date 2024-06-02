package loggerPack;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestLogger {
	
	public static WebDriver driver;
	public static Logger log;
	
	
	
    public static void main(String[] args) {
    	
   log = LogManager.getLogger(TestLogger.class);
   
 //  WebDriverManager.chromedriver().setup();
   
   log.info("try log in");
   driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   driver.get("https://www.myntra.com");
   log.info("logged into myntra");
    	
    try {
    	boolean text=driver.findElement(By.xpath("//a[contains(text(),'Women')]")).isDisplayed();
	} 
    catch (Exception e) {
       log.info(e.getMessage());
        log.error("Exceptioin Occured",new Exception("element Not Found"));
	} 	
    
    finally {
	log.info("Browser Quitting");
}
    }

}
