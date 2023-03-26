package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsSignup {

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
		
		WebElement username1 = driver.findElement(By.xpath("//input[@id='user-name']"));
		username1.sendKeys("locked_out_user");
		WebElement password1 = driver.findElement(By.xpath("//input[@id='password']"));
		password1.sendKeys("secret_sauce");
		WebElement btn_login1 = driver.findElement(By.xpath("//input[@id='login-button']"));
		btn_login1.click();
		
		String error_msg = "Epic sadface: Sorry, this user has been locked out.";
		WebElement error = driver.findElement(By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']"));
		System.out.println("Error is :" +error.getText());
		/*
		if(error.isDisplayed() && error.equals(error_msg))
		{
			System.out.println("Test case passed, user is locked out");
		}
		else
		{
			System.out.println("Test case failed!");
		}
		*/
		username1.clear();
		password1.clear();
		
		username1.sendKeys("problem_user");
		// password1.sendKeys("secret_sauce");
		Thread.sleep(2000);
		btn_login1.click();
		menu.click();
		logout.click();
		
		username1.sendKeys("performance_glitch_user");
		password1.sendKeys("secret_sauce");
		btn_login1.click();
		
		
		
	}

}
