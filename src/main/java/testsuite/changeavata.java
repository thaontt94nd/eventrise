package testsuite;

import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.text.Normalizer;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import PageLocator.Changeavata;
import automation.common.CommonBase;
public class changeavata extends CommonBase {
	@BeforeTest
	public void initDriverTest() {
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		driver =initChromeDriver();
		driver.get("https://alada.vn/tai-khoan/dang-nhap.html");
	}
	@Test(priority=1)
	public void changeavata(){
		Changeavata changeavata = new Changeavata(driver);
		changeavata.login("thaotrang94nd@gmail.com","123456aA");
		changeavata.changeavata("C:\\Users\\ADMIN\\Desktop\\1045.jpg");
		AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[text()='1045.jpg tải lên hoàn tất']")));
		pause(3000);
	}
//	@AfterTest
//	public void closechromeDriver() {
//		quitDriver(driver);
//	}
}
