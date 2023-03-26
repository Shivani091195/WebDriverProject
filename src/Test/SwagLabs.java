package Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("secret_sauce");
		
		WebElement btn_login = driver.findElement(By.xpath("//input[@id='login-button']"));
		btn_login.click();
		Thread.sleep(3000);
		
		WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		menu.click();
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		logout.click();
		
		driver.close();
		
		//New Chrome Window
		
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.saucedemo.com/");
		driver1.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		
		WebElement username1 = driver1.findElement(By.xpath("//input[@placeholder='Username']"));
		username1.sendKeys("problem_user");
		
		WebElement password1 = driver1.findElement(By.xpath("//input[@placeholder='Password']"));
		password1.sendKeys("secret_sauce");
		
		WebElement btn_login1 = driver1.findElement(By.xpath("//input[@id='login-button']"));
		btn_login1.click();
	}

}
