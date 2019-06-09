package utills;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data2 {
	WebDriver driver = null;
	
	public Object[][] testdata() throws IOException {
		
		String path=System.getProperty("user.dir");
		Excelutills data = new Excelutills(path+"/Excel/login.xlsx", "Sheet1");
		int	row=data.rows_count();
		int	col=data.col_count();
			
		
		Object[][] data2 = new Object[row-1][col];

		for(int i=1;i<row;i++)
			
		{
			for(int j=0;j<col;j++)
				
			{
				String values = Excelutills.getdata(i, j);
				System.out.print(values+"|");
				data2[i-1][j]=values;
			}
			System.out.println();
			
		}
		
		return data2;
		
		
	}
	@DataProvider(name="logindata")
	public Object[][] test() throws IOException
	
	{
	   Object[][] testdata= testdata();
	return testdata;      	
	}
@BeforeTest
public void setup()
{
     System.setProperty("webdriver.chrome.driver","C:\\Users\\5558\\eclipse-workspace\\chromedriver.exe");
	 driver = new ChromeDriver();
		
}
	
	@Test(dataProvider="logindata")
	public void login(String username1, String password1)
	
	{
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("(//li[contains(@class,'makeFlex hrtlCenter')])[5]"));
		login.click();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(username1);
	}
}
