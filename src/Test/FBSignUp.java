package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		
		//Create a new account
		WebElement signup = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signup.click();
		
		WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First name']"));
		firstname.sendKeys("Testing");
		
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("TestLname");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		email.sendKeys("9844477632");
		password.sendKeys("Test@123");
		
		//to get the default day selected
		WebElement selectedDay = driver.findElement(By.xpath("//select[@title='Day']/option[@selected='1']"));
		System.out.println("The Default day is : "+selectedDay.getText());
		
		//to check if all strings in month drop down are getting printed or not
		List<WebElement> allmonths = driver.findElements(By.xpath("//select[@title='Month']/option"));
		for(WebElement a:allmonths)
		{
			System.out.println(a.getText());
		}
		
		//To select a value from drop down, we need to call Select class constructor
		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddday = new Select(day);
		ddday.selectByVisibleText("9");
		// ddDay.selectByValue("9");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		
		Select ddmonth = new Select(month);
		Select ddyear = new Select(year);
		ddmonth.selectByValue("11");
		ddyear.selectByValue("1995");
		
		//In order to create multiple xpaths for gender, we will create one dummy gender xpath and then replace the value in xpath
		//in future we will be reading data from excel and not hardcode these thing
		String Gender = "Male";
		String dummyxpath = "//label[text()='placeholder']";
		String newxpath = dummyxpath.replace("placeholder", Gender);
		WebElement gender_elem = driver.findElement(By.xpath(newxpath));
		gender_elem.click();
		
		/*
		 * WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		Female.click();
		*/
	}

}
