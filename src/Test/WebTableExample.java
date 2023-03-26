package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		
		List<WebElement> Rows = driver.findElements(By.cssSelector("table#customers>tbody>tr"));
		System.out.println("Total number of rows : " +Rows.size());
		
		List<WebElement> Columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("Total number of columns : " +Columns.size());
		
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		System.out.println("The data in 4th row, 1st column is : " +data.getText());

		for(int i=2;i<=Rows.size();i++) 
		{
			List<WebElement> ColumnsData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td"));
			
			System.out.println(ColumnsData.get(0).getText() + " " + ColumnsData.get(1).getText() + " " + ColumnsData.get(2).getText()) ;
		}
		
		WebElement scrollTo = driver.findElement(By.xpath("//h2[text()='HTML Exercises']"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		//scroll down
		obj.executeScript("arguments[0].scrollIntoView()",scrollTo);
		Thread.sleep(3000);
		//scroll up
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(3000);

	}

}
