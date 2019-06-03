package mmt;

import java.beans.Visibility;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class mmt_chrome {
	public static WebDriver driver;
	@Test(priority=1)
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver","C:\\Users\\5558\\eclipse-workspace\\chromedriver.exe");
		
	 driver = new ChromeDriver();		
	}
	@Test(dependsOnMethods="setup")
	public void test() throws InterruptedException, ATUTestRecorderException
	
	{
		String projectpath=System.getProperty("user.dir");
	//	ATUTestRecorder record = new ATUTestRecorder(projectpath+"//Recording", "Accessdenied", false);
		
		driver.get("https://www.makemytrip.com");
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	    
	    WebElement more =driver.findElement(By.xpath("//span[@class='darkGreyText']"));
	    
		Actions action = new Actions(driver);
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(more));
		action.moveToElement(more).build().perform();
		
		WebElement deals = driver.findElement(By.xpath("(//a[text()='Deals'])"));
		wait.until(ExpectedConditions.visibilityOf(deals));
		
		String parent = driver.getWindowHandle();
		deals.click();
		Thread.sleep(3000);
		 Set<String> windows = driver.getWindowHandles();
		 System.out.println("total windows are: "+windows.size());
		 System.out.println(windows);
		 for(String windows1:windows)
			 
		 {
			 if(!windows1.equalsIgnoreCase(parent))
			 {
				 driver.switchTo().window(windows1);
				System.out.println("Switched to child window");
				 System.out.println("Current url:"+driver.getCurrentUrl());
					System.out.println("Current page title:"+driver.getTitle());
					
					
					WebElement login = driver.findElement(By.xpath("//a[@class='ch__login cho_login']"));
				wait.until(ExpectedConditions.visibilityOf(login));
					login.click();
									 
			 }
		 }
		
	
		
	}
	
@Test(dependsOnMethods="test")
public void close()
{
driver.close();	
}
	

}
