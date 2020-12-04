package firsttestngpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoursesSelect {
	public WebDriver driver;
	public String baseUrl = "https://hoctructuyen.vanlanguni.edu.vn/";

	@Test
	public void CoursesSelect_hoctructuyen() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		WebElement loginpage = driver.findElement(By.xpath("//*[@class='logininfo']//*[text()='Log in']"));
		loginpage.click();
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("loginbtn"));
		username.sendKeys("hieu.187pm13916");
		Thread.sleep(500);
		password.sendKeys("VLU187pm13916");
		Thread.sleep(500);
		login.click();
		WebElement mycourses = driver.findElement(By.xpath("//*[@title='My Courses']"));
		Actions builder = new Actions(driver);
		Action movetoMycourses = builder.moveToElement(mycourses).build();
		movetoMycourses.perform();
		/*
		 * WebElement AV4 = driver.findElement(By.xpath("//*[@title='DTA0040-T0048NN-GD2-HK2-1920']"));
		 * Action movetoAV4 = builder.moveToElement(AV4).build(); movetoAV4.perform();
		 * AV4.click();
		 */
		List<WebElement> childElements = driver.findElement(By.xpath("//a[@title='My Courses']//following-sibling::div/ul"))
				.findElements(By.tagName("li"));
		for (WebElement element: childElements) {
			if (element.getText().contains("Anh văn 4 - GD2-04; GD2-05")) {
				element.click();
				break;
			}
			Thread.sleep(2000);
			String expectedUrl = "https://hoctructuyen.vanlanguni.edu.vn/course/view.php?id=3057";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);
		}			
		driver.close();
	}
}
