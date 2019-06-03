package mmt;

import java.beans.Visibility;
import utills.*;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class mmt_Home_page {
	public static WebDriver driver;
	@Test(priority=1)
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver","C:\\Users\\5558\\eclipse-workspace\\chromedriver.exe");
		
	 driver = new ChromeDriver();		
	}
	@Test(dependsOnMethods="setup")
	public void test() throws InterruptedException
	
	{
		//String projectpath=System.getProperty("user.dir");
	//	ATUTestRecorder record = new ATUTestRecorder(projectpath+"//Recording", "Accessdenied", false);
		
		driver.get("https://www.makemytrip.com");
		
	
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("(//li[contains(@class,'makeFlex hrtlCenter')])[5]"));
		login.click();
		WebElement username = driver.findElement(By.id("username"));
		//username.sendKeys(utills.Data.getdata(0, 0););
		
		
		
			
		
	}

	
	@Test(dependsOnMethods="test")
	public void close()
	{
		driver.close();
	}
}
		
	    
	  