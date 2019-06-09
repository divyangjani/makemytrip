package mmt;

import java.beans.Visibility;
import java.io.IOException;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class mmt_Home_page {
	
	
	 WebDriver driver;
	@BeforeTest
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver","C:\\Users\\5558\\eclipse-workspace\\chromedriver.exe");
		
	 driver = new ChromeDriver();		
	}
	
	
	 public Object[][] testdata() throws IOException{
		 
		String path=System.getProperty("user.dir");
		Excelutills utills = new Excelutills(path+"/Excel/login.xlsx", "Sheet1");

		
		int row = utills.rows_count();
		int col = utills.col_count();
		Object[][] data = new Object[row-1][col];
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				String celldata = null;
				System.out.print(utills.getdata(i, j)+"|");
				data[i-1][j]=celldata;
				
			}
			System.out.println();
		}
		 
		return data;
		 
	 }
	@DataProvider(name="login")
	public Object[][] logindata() throws IOException
	{
	Object[][] data=testdata();
	return data;
	}
	
	@Test(dataProvider="login")
	
	public void test(String username1, String password1)
	
	{
		//String projectpath=System.getProperty("user.dir");
	//	ATUTestRecorder record = new ATUTestRecorder(projectpath+"//Recording", "Accessdenied", false);
		
		driver.get("https://www.makemytrip.com");
		
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("(//li[contains(@class,'makeFlex hrtlCenter')])[5]"));
		login.click();
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys(username1);
		password.sendKeys(password1);
		
		
		
	}

	@AfterTest
	public void close()
	{
		driver.close();
	}
}
		
	    
	  