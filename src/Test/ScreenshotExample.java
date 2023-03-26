package Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MICROSECONDS);
		
		TakesScreenshot tsObj = (TakesScreenshot)driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File ScreenshotObj = new File("src/Test/screenshot.png");
		
		FileUtils.copyFile(fileObj, ScreenshotObj);
		driver.close();
		
	}

}
