package mmt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Paytm {
	
	@Test(description="without selection an place to verify is error msg is coming or not")
	public void recharge() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\5558\\eclipse-workspace\\geckodriver.exe");
         DesiredCapabilities cap =new DesiredCapabilities();
         cap.setCapability("marionette", false);
         WebDriver driver=new FirefoxDriver(cap);
	 
	 driver.get("https://www.makemytrip.com/");
	 driver.manage().window().maximize();
	WebElement More= driver.findElement(By.xpath(".//*[@id='mmt_header_navigation']/div/div[1]/ul/li/a[text()='more +']"));		
		Actions action = new Actions(driver);
		action.moveToElement(More).perform();
	    Thread.sleep(3000);
		WebElement deals=driver.findElement(By.xpath(".//*[@id='mmt_header_navigation']/div/div[1]/ul/li/div[@class='ch-more-plus']/div/ul/li/a[text()='Deals']"));
		deals.click();
		driver.findElement(By.xpath(".//*[@id='hp-widget__sTo']")).click();
		driver.findElement(By.xpath(".//*[@id='searchBtn']")).click();
		Thread.sleep(2000);
		Boolean errormsg=driver.findElement(By.xpath(".//*[@id='hp-widget__sFrom_invalid_error']/span[2]")).isDisplayed();
		if(errormsg.valueOf(errormsg).TRUE)
		{
			System.out.print("error msg is displayed");
		}
		driver.close();
		
		
		
		
	}

}
