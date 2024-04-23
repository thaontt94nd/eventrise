package testsuite;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;
import java.text.Normalizer;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import PageLocator.Riseevent;
import automation.common.CommonBase;

public class Testevent extends CommonBase {
	@BeforeTest
	public void initDriverTest() {
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		driver =initChromeDriver();
		driver.get("https://rise.fairsketch.com/signin");
	}
//	@Test(priority=1)
//	public void addeventsuccess(){
//		Riseevent addeventsuce = new Riseevent(driver);
//		addeventsuce.login();
//		addeventsuce.menuevent();
//		addeventsuce.addeventsuccess("event5",getCurrentDateTime(),getCurrentDateTime());
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		AssertJUnit.assertTrue(isElementPresent(By.xpath("//span[text()=' event5']/ancestor::td[@data-date='"+getCurrentDateTime1()+"']" )));
//	}
	@Test(priority=1)
	public void addeventsuccessupload(){
		Riseevent addeventsuccessupload = new Riseevent(driver);
		addeventsuccessupload.login();
		addeventsuccessupload.menuevent();
//		addeventsuccessupload.addeventsuccessupload("event5",getCurrentDateTime(),getCurrentDateTime(),"C:\\Users\\ADMIN\\Desktop\\AED\\","1-2.jpg");
		addeventsuccessupload.addeventsuccessupload("event5",getCurrentDateTime(),getCurrentDateTime(),"C:\\Users\\ADMIN\\Desktop\\AED\\1-2.jpg");
		pause(5000);
		click(By.xpath("//td[@data-date='"+getCurrentDateTime1()+"']/div/div[2]/div/a/span/span[text()=' event5']"));
		AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@class='edit-image-file mb15']")));
		click(By.xpath("//*[@id='ajaxModal']/div/div/div[1]/button"));
	}
	@Test(priority=2)
	public void deleteeventsuccess(){
	    Riseevent deleteeventsuccess = new Riseevent(driver);
	    deleteeventsuccess.deleteeventsuccess();   
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isEventDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()=' event5']/ancestor::td[@data-date='" + getCurrentDateTime1() + "']")));
	    AssertJUnit.assertTrue(isEventDeleted);
	}
	@Test(priority=3)
	public void TextMonth(){
		Riseevent TextMonth = new Riseevent(driver);
//		TextMonth.login();
//		TextMonth.menuevent();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    // Chờ cho nút "month" xuất hiện và nhấp vào
	    WebElement monthButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='event-calendar']/div[1]/div[3]/div/button[1]")));
	    monthButton.click(); 
	    // Chờ cho phần tử có văn bản là "March 2024" xuất hiện
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fc-toolbar-chunk'][2]//h2[text()='"+ getCurrentMonth() +"']")));
	    // Lấy văn bản từ phần tử và so sánh với văn bản mong đợi
	    String expectedText = getCurrentMonth();
	    System.out.println("Chuỗi là tháng và năm hiện tại:"+ expectedText );
	    String actualText = element.getText();
	    AssertJUnit.assertEquals(actualText, expectedText);
	}
	
	@Test(priority=4)
	public void Textweek(){
		Riseevent Textweek = new Riseevent(driver);
//		Textweek.login();
//		Textweek.menuevent();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    WebElement weekButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='event-calendar']/div[1]/div[3]/div/button[2]")));
	    weekButton.click(); 
	    String expectedText = getWeekWithSpecialFormat1();
	    System.out.println(expectedText);
	    WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='event-calendar']/div[1]/div[2]/h2")));
//	    String actualText= element1.getText().replaceAll("[^a-zA-Z0-9]", "");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String actualText = js.executeScript("return arguments[0].innerText;",element1).toString().replaceAll("\\p{Pd}", "-");
	    System.out.println(actualText );
	    Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(priority=5)
	public void Textday(){
		Riseevent Textday = new Riseevent(driver);
//		Textweek.login();
//		Textweek.menuevent();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    WebElement weekButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='event-calendar']/div[1]/div[3]/div/button[3]")));
	    weekButton.click(); 
	    WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='event-calendar']/div[1]/div[2]/h2")));
	    String expectedText = getCurrentDateTime2();
	    String actualText= element2.getText();
	    System.out.println(actualText );
	    AssertJUnit.assertEquals(actualText, expectedText);
	}
		 private void assertList(String value) {
			 List < WebElement > list = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr/child::td[6]/a"));
			 for (WebElement item:list) {
				 String actual=item.getText();
				 assertEquals(actual,value);
			 }
		 }
		 @Test
		 public void filterTask() throws InterruptedException {
			 String value ="Data Analysis and Insights";
			 Riseevent Textday1 = new Riseevent(driver);
			 Textday1.login();
			 click(By.xpath("//span[text()='Tasks']"));
			 click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));

			 click(By.xpath("//div[@id='s2id_autogen5']"));
			 type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"), "Project");
			 typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));

			 click(By.xpath("//div[@id='s2id_autogen7']"));
			 type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"), value);
			 typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
			 pause(3000);
			 assertList(value);
		 }
	
	@AfterTest
	public void closechromeDriver() {
		quitDriver(driver);
	}
}
