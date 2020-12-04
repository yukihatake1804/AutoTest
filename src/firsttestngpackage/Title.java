package firsttestngpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Title {
	public String baseUrl = "https://hoctructuyen.vanlanguni.edu.vn/";
    public WebDriver driver ; 
    
    @Test
    public void title_hoctructuyen() {
  	  System.out.println("launching chrome browser"); 
  		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String expectedTitle = "Học trực tuyến - Đại học Văn Lang";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
