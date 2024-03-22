package automation.common;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
 * Author: Tran Hoan, mobile/zalo: +84-979535822
 * Initiate some common methods to testing purpose using relative wait
 * This class can be use after Day16 of my course to make more effective and stable test script
 * To handle Flaky test appearing due to some other Selenium Exception types
 * feel free contact HoanTran to get more detail strategies.
 */
public class CommonBase {
	public WebDriver driver;
	public int initWaitTime = 10;

	public WebDriver initChromeDriver(String URL) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

	public void inputTextJavaScriptInnerHTML(By inputElement, String companyName) {
		WebElement element = driver.findElement(inputElement);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + companyName + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptInnerHTML(inputElement, companyName);
		}
	}

	public void inputTextJavaScriptValue(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptValue(locator, value);
		}
	}

	public void scrollToElement(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickJavaScript(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	public boolean isElementNotPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
	}

	public boolean isElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
		return getElementPresentDOM(locator).isDisplayed();
	}

	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}

	/**
	 * pause driver in timeInMillis
	 * 
	 * @param timeInMillis
	 */
	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get absolute path of file
	 * 
	 * @param relativeFilePath
	 * @return
	 */
	public String getAbsoluteFilePath(String relativeFilePath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativeFilePath;
		return absolutePath;
	}

	public void quitDriver(WebDriver dr) {
		if (dr.toString().contains("null")) {
			System.out.print("All Browser windows are closed ");
		} else {
			dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			dr.manage().deleteAllCookies();
			dr.close();
		}
	}

	public int findIframe() {
		int indexofIframe = 0;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("size: " + size);
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			int numberofIframe = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
			if (numberofIframe != 0) {
				indexofIframe = i;
			}
			driver.switchTo().defaultContent();
		}
		System.out.println("indexofIframe: " + indexofIframe);
		return indexofIframe;
	}
	public String getCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		// calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentdateTime = df.format(calendar.getTime());
		System.out.println("Current day - month - year: " + currentdateTime);
		return currentdateTime;
	}
	
	public String getCurrentDateTime2() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MMMM d, yyyy");
		String currentday = df.format(calendar.getTime());
		System.out.println("currentMonthAsString: " + currentday);
		 return currentday;
	}
	
	// 2. Lấy tháng hiện tại theo định dạng "September 2023"
	public String getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
		String currentMonth = df.format(calendar.getTime());
		System.out.println("currentMonthAsString: " + currentMonth);
		 return currentMonth;
	}
	
	// Lấy tuần hiện tại theo định dạng: Dec 24 - 30, 2023, dùng cho case chọn hiển thị theo Week
		public String getWeekWithSpecialFormat() {
			// Get calendar set to current date and time
			Calendar c = GregorianCalendar.getInstance();
			// Set the calendar to monday of the current week
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
			// Print dates of the current week starting on Monday
			SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
			String startDate = "", endDate = "";
			startDate = df.format(c.getTime());
			c.add(Calendar.DATE, 6);
			endDate = df.format(c.getTime());
			System.out.println("Start Date = " + startDate);
			// cắt chuỗi endDate để chỉ lấy ra ngày
			System.out.println("Day of end Date = " + endDate.subSequence(4, 6));
			String expected = new StringBuilder().append(startDate.substring(0, 6)).append(" - ")
					.append(endDate.subSequence(4, 6))
					.append(startDate.substring(6, 12)).toString();
			System.out.println("Expected weekWithSpecialFormat: " + expected);
			return expected;
		}
	
	public String getCurrentDateTime1() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentdateTime1 = df.format(calendar.getTime());
		System.out.println("Current day - month - year: " + currentdateTime1);
		return currentdateTime1;
	}

	public WebDriver initChromeDriver() {
		System.out.println("Lauching Chrome Brower");
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver initfirefoxDriver() {
		System.out.println("Lauching Firefox Brower");
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver initEdgeDriver() {
		System.out.println("Lauching edge Brower");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver setupDriver(String browserName) {
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initfirefoxDriver();
			break;
		case "edge":
			driver = initEdgeDriver();
			break;
		default:
			System.out.println("Browser" + browserName + "is invalid, Launching chrome as browser of choice...");
			driver = initChromeDriver();
		}
		return driver;
	}
}
