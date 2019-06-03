package mmt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_chrome {
	
	public static WebDriver driver;
	@Test(priority=1)
	
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver","C:\\Users\\5558\\eclipse-workspace\\chromedriver.exe");
		
	 driver = new ChromeDriver();		
	}
	@Test(priority=2)
  public void login() throws InterruptedException
 
  {
	  driver.get("https://www.makemytrip.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	  WebElement login = driver.findElement(By.xpath("//p[contains(text(),'Login or Create Account')]"));
	  Thread.sleep(2500);
	  WebElement username = driver.findElement(By.id("username"));
	  username.sendKeys("Test");
	  login.click();
  }

}
