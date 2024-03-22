package testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import PageLocator.viewproject;
public class Testproject extends CommonBase {
//	@BeforeTest
//	@Parameters ("browser")
//	public void initDriver(String browser) {
//		setupDriver(browser);
//		driver.get("https://rise.fairsketch.com/signin");
//	}
	@BeforeTest
	public void initDriverTest() {
		driver =initChromeDriver();
		driver.get("https://rise.fairsketch.com/signin");
	}
	
	@Test(priority=1)
	public void findfilter(){
		viewproject findfilter = new viewproject(driver);
		findfilter.login();
		findfilter.menuproject();
		findfilter.filterproject(8,"Completed");
	}
	
	@Test(priority=2)
	public void findfilter1(){
		viewproject findfilter1 = new viewproject(driver);
//		findfilter.login();
//		findfilter.menuproject();
		findfilter1.filterproject2(2,"High Priority");
	}
	
	@Test(priority=3)
	public void cleanfilter() {
		viewproject cleanfilter = new viewproject(driver);
		cleanfilter.cleanfilter();
	}
	@Test(priority=4)
	public void findmanagefilter() {
		viewproject findmanagefilter = new viewproject(driver);
		findmanagefilter.findmanagefilter(1,"Upcoming");
	}
	
	@Test(priority=5)
	public void Changefilter() {
		viewproject Changefilter = new viewproject(driver);
		Changefilter.Changefilter(2,"Upcoming");
	}
	@Test(priority=6)
	public void addfilter() {
		viewproject addfilter = new viewproject(driver);
		addfilter.addfilter(1,"50");
	}
	
	@Test(priority=7)
	public void Editnamefilter() {
		viewproject Editnamefilter = new viewproject(driver);
		Editnamefilter.Editnamefilter(1,"51");
	}
	@Test(priority=8)
	public void Editunbookmark() {
		viewproject Editunbookmark = new viewproject(driver);
		Editunbookmark.Editunbookmark();
	}
	@Test(priority=9)
	public void setupcolummanagefilter() {
		viewproject setupcolummanagefilter = new viewproject(driver);
		setupcolummanagefilter.setupcolummanagefilter();
	}
	@Test(priority=10)
	public void Deletemanagefilter() {
		viewproject Deletemanagefilter = new viewproject(driver);
		Deletemanagefilter.Deletemanagefilter(1,"51");
	}
	@Test(priority=11)
	public void bookmark() {
		viewproject bookmark = new viewproject(driver);
		bookmark.bookmark(2,"High Priority");
	}
//	
	@Test(priority=12)
	public void setupcolum() {
		viewproject setupcolum = new viewproject(driver);
		setupcolum.setupcolum();
	}
//	
	@Test(priority=13)
	public void label() {
		viewproject label = new viewproject(driver);
		label.label(2,"On track");
	}
	@Test(priority=14)
	public void startdate() {
		viewproject startdate = new viewproject(driver);
		startdate.startdate(4,"Last Month");
	}
	@Test(priority=15)
	public void startdatethismonth() {
		viewproject startdatethismonth = new viewproject(driver);
		startdatethismonth.startdatethismonth(4,"This Month");
	}
	@Test(priority=16)
	public void startdatefromto() {
		viewproject startdatefromto = new viewproject(driver);
		startdatefromto.startdatefromto(4,"10-08-2023","31-08-2023");
	}
	@Test(priority=17)
	public void deadlinein7day() {
		viewproject deadlinein7day = new viewproject(driver);
		deadlinein7day.deadlinein7day(5,"In 7 day");
	}
	@Test(priority=18)
	public void status(){
		viewproject status = new viewproject(driver);
		status.status(8,"Open");
	}
	
	@AfterTest
	public void alertclose() {
//		quitDriver(driver);
	}
	
}
