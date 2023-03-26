package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) throws InterruptedException {
	
		//step 1 : Open Chrome browser and launch simplilearn website
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		//step 2 : Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MICROSECONDS);
		
		//step 3 : Click on login link in the top right corner
		System.out.println("The title of the page is : " +driver.getTitle());
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		String location = loginlink.getAttribute("href");
		System.out.println("The link will take you to " +location);
		loginlink.click();
		
		//step 4 : Enter the Username
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("abc@gmail.com");
		
		//step 5 : Enter the password
		WebElement password = driver.findElement(By.name("user_pwd"));
		password.sendKeys("abc.BNvs@111");
		
		//Click on Remember me checkbox
		WebElement rem_me = driver.findElement(By.className("rememberMe"));
		rem_me.click();
		
		//Step 6 : Click on login button
		WebElement loginbtn = driver.findElement(By.name("btn_login"));
		loginbtn.click();
		
		//Step 7 : Check if login was unsuccessful
		Thread.sleep(3000);
		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		System.out.println("The error message is : " +errorMsg);
		
		String experrorMsg = "The email or password you have entered is invalid.";
		if(error.isDisplayed() && errorMsg.equals(experrorMsg))
		{
			System.out.println("Test case Pass");
		}
		else
		{
			System.out.println("Test case Failed");
		}
		
		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links= " +AllLinks.size());
		
		for(WebElement x : AllLinks)
		{
			String i = x.getAttribute("href");
			System.out.println("Link: " +i);
		}
		
		//Step 8 : close the browser
		driver.close();
	}

}
