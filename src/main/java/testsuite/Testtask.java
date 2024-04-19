package testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageLocator.Testtask1;
import automation.common.CommonBase;

public class Testtask extends CommonBase {
	@BeforeTest
	public void initDriverTest() {
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		driver =initChromeDriver();
		driver.get("https://rise.fairsketch.com/signin");
	}
    private void RelatedtoList(String value) {
		 List < WebElement > list = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr/child::td[6]/a"));
		 for (WebElement item:list) {
			 String actual=item.getText();
			 assertEquals(actual,value);
		 }
	 }
	@Test(priority=1)
	 public void Relatedto() throws InterruptedException{
		String value ="Social Media Influencer Collaboration";
		Testtask1 Relatedto = new Testtask1(driver);
		Relatedto.login();
		Relatedto.menu();
		Relatedto.filter();
		Relatedto.Relatedto("Project",value);
		pause(3000);
		RelatedtoList(value);	
	}
	private void MilestoneList(String value) {
		 List < WebElement > list = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr/child::td[5]"));
		 for (WebElement item:list) {
			 String actual=item.getText();
			 assertEquals(actual,value);
		 }
	 }
	@Test(priority=2)
	 public void Milestone() throws InterruptedException{
		String value ="Release";
		Testtask1 Milestone = new Testtask1(driver);
		Milestone.Milestone();
		pause(3000);
		MilestoneList(value);	
	}
	private void MemberList(String value) {
		 List < WebElement > list = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr/child::td[7]/a"));
		 for (WebElement item:list) {
			 String actual=item.getText();
			 assertEquals(actual,value);
		 }
	 }
	@Test(priority=3)
	 public void Member() throws InterruptedException{
		String value ="John Doe";
		Testtask1 Member = new Testtask1(driver);
		Member.Member(value);
		pause(3000);
		MemberList(value);	
	}
	private void PriorityList(String value) {
		 List < WebElement > list = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr/child::td[2]/span[@title='Priority: Major']"));
		 for (WebElement item:list) {
			 String title =item.getAttribute("title");
			 String[] actual1=title.split(":");
			 String actual = actual1[actual1.length - 1].trim();
			 assertEquals(actual,value);
		 }
	 }
	@Test(priority=4)
	 public void Priority() throws InterruptedException{
		String value ="Major";
		Testtask1 Priority = new Testtask1(driver);
		Priority.Priority(value);
		pause(3000);
		PriorityList(value);	
	}
	private void LabelList(String value) {
		 List < WebElement > list = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr/child::td[2]/span[@title='Label']"));
		 for (WebElement item:list) {
			 String actual =item.getText();
			 assertEquals(actual,value);
		 }
	 }
	@Test(priority=5)
	 public void Label() throws InterruptedException{
		String value ="Design";
		Testtask1 Label = new Testtask1(driver);
		Label.Label(value);
		pause(3000);
		LabelList(value);	
	}
	private boolean ExpiredList(String value) {
		boolean result=false; 
		List < WebElement > list = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr/child::td[4]/span"));
		 for (WebElement item:list) {
			 String actual =item.getText();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			 LocalDate dateOnElement = LocalDate.parse(actual, formatter);
			 LocalDate dateOnValue = LocalDate.parse(value, formatter);
			 if (dateOnElement.isBefore(dateOnValue)) {
				 result= true;	
			 }
			 result = false;
			}
		 return result;
	 }
	@Test(priority=6)
	 public void Expired() throws InterruptedException{
		String value = getCurrentDateTime3();
		Testtask1 Expired = new Testtask1(driver);
		Expired.Expired();
		pause(3000);
		ExpiredList(value);	
	}
	private void TodayList(String value) {
		List < WebElement > list = driver.findElements(By.xpath("//table[@id='task-table']//tbody/tr/child::td[4]/span"));
		 for (WebElement item:list) {
			 String actual =item.getText();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			 LocalDate dateOnElement = LocalDate.parse(actual, formatter);
			 LocalDate dateOnValue = LocalDate.parse(value, formatter);
			 assertEquals(dateOnElement,dateOnValue);
			 }
	 }
		 
	@Test(priority=7)
	 public void Today() throws InterruptedException{
		String value = getCurrentDateTime3();
		Testtask1 Today = new Testtask1(driver);
		Today.Deletevalue("- Related to -","- Project -","- Milestone -","- Team member -","- Priority -","- Label -");
		Today.Today();
		pause(3000);
		TodayList(value);	
	}
	
	@Test(priority=8)
	 public void Tomorrow() throws InterruptedException{
		String value = getNext1DaysOfCurrentDateTime();
		Testtask1 Tomorrow = new Testtask1(driver);
		Tomorrow.Tomorrow();
		pause(5000);
		TodayList(value);	
	}
	@Test(priority=9)
	 public void day7() throws InterruptedException{
		String value = getNext7DaysOfCurrentDateTime();
		Testtask1 day7 = new Testtask1(driver);
		day7.day7();
		pause(5000);
		ExpiredList(value);	
	}
	
	private boolean checkFilterStatus(String filter1, String filter2) {

		boolean result=false;

		List<WebElement> listRelatedTo = driver

		.findElements(By.xpath("//table[@id='task-table']//tbody//tr/child::td[9]/a"));// Element chứa cột status

		for (WebElement item : listRelatedTo) {

		String actual = item.getText(); // Nếu text của Status là filter1 và filter2

		if(actual.equalsIgnoreCase(filter1)||actual.equalsIgnoreCase(filter2))

		{

		result = true;// thì kqua là True

		}

		else result = false; // Ngược lại thì kqua là False

		}

		return result;// Trả về kqua

		}
	@Test(priority=10)
	 public void Staus() throws InterruptedException{
		Testtask1 status = new Testtask1(driver);
		status.status();
		pause(5000);
		checkFilterStatus("To do","In progress");	
	}
	
	@AfterTest
	public void closechromeDriver() {
		quitDriver(driver);
	}
}
