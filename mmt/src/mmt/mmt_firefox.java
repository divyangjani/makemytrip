package mmt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class mmt_firefox {
	public static WebDriver driver;
	@Test(priority=1)
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\5558\\eclipse-workspace\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test(dependsOnMethods="setup")
	public void test() throws InterruptedException
	{
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
		deals.click();
		
		System.out.println("Current url:"+driver.getCurrentUrl());
		System.out.println("Current page title:"+driver.getTitle());
		
		WebElement login = driver.findElement(By.xpath("//a[@class='ch__login cho_login']"));
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();	
	}
	
	@Test(dependsOnMethods="test")
	public void close()
	{
		driver.close();
	}
	
	

}


