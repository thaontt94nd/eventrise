package testsuite;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Uploadfile extends CommonBase {
	WebDriver driver;
	@BeforeTest
	public void openchromeDriver() {
		driver = initChromeDriver("https://demo.guru99.com/test/upload/");
	}
	@Test
	public void uploadfile() {
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("C:\\Users\\ADMIN\\Desktop\\AED\\1-2.jpg");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();
		pause(3000);
	}
	
	
	
}