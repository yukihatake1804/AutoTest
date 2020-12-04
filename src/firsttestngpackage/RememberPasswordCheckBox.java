package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class RememberPasswordCheckBox {
	public String baseUrl = "https://hoctructuyen.vanlanguni.edu.vn/";
    public WebDriver driver ; 
    
    @Test
    public void RememberPassCheckBox() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32\\\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get(baseUrl);
    	WebElement loginpage = driver.findElement(By.xpath("//*[@class='logininfo']//*[text()='Log in']"));
  		loginpage.click();
  		Thread.sleep(2000);
  		WebElement rememberopt = driver.findElement(By.xpath("//*[@class='rememberpass']//*[@type='checkbox']"));
  		rememberopt.click();
  		if(rememberopt.isSelected()) {
  			System.out.println("Checkbox is Togged On");
  		}
  		else {
  			System.out.println("Checkbox is Togged Off");
  		}
  		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  		Thread.sleep(2000);
  		rememberopt.click();
  		Thread.sleep(2000);
  		if(!rememberopt.isSelected()) {
  			System.out.println("Checkbox is Togged Off !!");
  		}
  		driver.close();
    }
}
