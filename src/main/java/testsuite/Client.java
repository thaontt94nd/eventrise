package testsuite;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageLocator.Riseevent;
import automation.common.CommonBase;


public class Client extends CommonBase {
	@BeforeTest
	public void initDriverTest() {
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		driver =initChromeDriver();
		driver.get("https://rise.fairsketch.com/signin");
	}
	private void assertList(String value) {
		 List < WebElement > list = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr/child::td[6]/a"));
		 for (WebElement item:list) {
			 String actual=item.getText();
			 assertEquals(actual,value);
		 }
	 }
	@Test(priority=1)
	public void filterClientgroup() throws InterruptedException {
		 String value ="Gold";
		 Riseevent filter1 = new Riseevent(driver);
		 filter1.login();
		 click(By.xpath("//span[text()='Clients']"));
		 click(By.xpath("//ul[@id='client-tabs']//li[2]"));
		 click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));

		 click(By.xpath("//span[@id='select2-chosen-8']"));
		 click(By.xpath("//div[text()='Gold']"));

		 pause(3000);
		 assertList(value);
	 }

	@Test(priority=2)
	public void filterlabel() throws InterruptedException {
		 String value ="Gold";
//		 Riseevent filter2 = new Riseevent(driver);
//		 filter2.login();
//		 click(By.xpath("//span[text()='Clients']"));
//		 click(By.xpath("//ul[@id='client-tabs']//li[2]"));
//		 click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));

		 click(By.xpath("//span[@id='select2-chosen-10']"));
		 click(By.xpath("//div[text()='Inactive']"));

		 pause(3000);
		 assertList(value);
	 }
@AfterTest
public void closechromeDriver() {
	quitDriver(driver);
}

}
