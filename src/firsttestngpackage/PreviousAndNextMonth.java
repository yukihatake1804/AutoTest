package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class PreviousAndNextMonth {
	WebDriver driver;
	public String baseUrl = "https://hoctructuyen.vanlanguni.edu.vn/";
	
	@Test
	public void Previousmonth() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get(baseUrl);
		Thread.sleep(1000);
		/*WebElement login  = driver.findElement(By.linkText("Log in"));
		login.click();
		WebElement user = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.id("loginbtn"));
		user.sendKeys("quang.187pm20551");
		password.sendKeys("VLU187pm20551");
		btnLogin.click();*/
		WebElement Previousmonth = driver.findElement(By.xpath("//*[@title='Previous month']"));
		Previousmonth.click();
		String expected1 = "October 2020";
	    String actual1 = driver.findElement(By.xpath("//*[@title=\"This month\"]")).getText();
	    Assert.assertEquals(actual1, expected1);
		
	 }
	
	@AfterTest
	 public void Nextmonth() throws InterruptedException{
		WebElement Nextmonth = driver.findElement(By.xpath("//*[@title='Next month']"));
		Nextmonth.click();
		String expected2 = "November 2020";
	    String actual2 = driver.findElement(By.xpath("//*[@title=\"This month\"]")).getText();
	    Assert.assertEquals(actual2, expected2);
	    driver.close();
	}
}
