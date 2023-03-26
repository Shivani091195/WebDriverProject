package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MICROSECONDS);
		
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("shivani.shrivastava@blabla.com");
		
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("Testing@123");
		
		WebElement btn = driver.findElement(By.name("login"));
		btn.click();
		

	}

}
