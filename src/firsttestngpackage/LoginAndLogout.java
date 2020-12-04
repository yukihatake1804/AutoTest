package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginAndLogout {
	public WebDriver driver ; 
	public String baseUrl = "https://hoctructuyen.vanlanguni.edu.vn/";
	
		@Test
		public void login() throws InterruptedException {
	  		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	  		driver = new ChromeDriver();
	  		driver.manage().window().maximize();
	  		driver.get(baseUrl);
	  		WebElement loginpage = driver.findElement(By.xpath("//*[@class='logininfo']//*[text()='Log in']"));
	  		loginpage.click();
	  		WebElement username = driver.findElement(By.id("username"));
	  		WebElement password = driver.findElement(By.id("password"));
	  		WebElement login = driver.findElement(By.id("loginbtn"));
	  		username.sendKeys("hieu.187pm13916");
	  		password.sendKeys("VLU187pm13916");
	  		login.click();
	  		String expectedText1 = "Bạn đang đăng nhập với tên 187PM13916 - Thai Minh Hieu - K24T-PM1 (Thoát ra)";
	  		String actualText1 = driver.findElement(By.xpath("//div[@class=\"uk-navbar-flip\"]//div[@class=\"logininfo\"]")).getText();
	  		Assert.assertEquals(actualText1,expectedText1);
	    }
		
		@AfterTest
		public void logout() throws InterruptedException {
			WebElement logout = driver.findElement(By.xpath("//div[@class=\"uk-navbar-flip\"]//*[text()=\"Thoát ra\"]"));
			logout.click();
			String expectedText2 = "You are not logged in. (Log in)";
	  		String actualText2 = driver.findElement(By.xpath("//div[@class=\"uk-navbar-flip\"]//div[@class=\"logininfo\"]")).getText();
	  		Assert.assertEquals(actualText2, expectedText2);
			driver.close();
		}
}
