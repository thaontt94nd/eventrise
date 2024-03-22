package testsuite;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class windowspop_ExplicitWai extends CommonBase {
	@BeforeTest
	@Parameters ("browser")
	public void initDriver(String browser) {
		setupDriver(browser);
		driver.get("https://demo.guru99.com/popup.php");
	}
	
//	@BeforeTest
//	public void initDriverTest() {
//		driver =initEdgeDriver();
//		driver.get("https://demo.guru99.com/popup.php");
//	}
	@Test
	public void testalert() {
		click(By.xpath("//*[contains(@href,'popup.php')]"));
		//lưu lại window 1
		String mainwindow = driver.getWindowHandle();
		//Lấy các windows đang activer
		Set<String> windows= driver.getWindowHandles();
		//Duyệt từng cửa sổ
		for (String window : windows) {
			System.out.println(window);
			if (!mainwindow.equals(window)) {
				driver.switchTo().window(window);
				pause(2000);
				System.out.println("Đã chuyển đến lơp window con");
				//Một số hàm hỗ trợ
				System.out.println("Title: "+driver.switchTo().window(window).getTitle());
				System.out.println("CurentTitle: "+driver.switchTo().window(window).getCurrentUrl());
				type(By.name("emailid"),"testdemo@gmail.com");
				click(By.name("btnLogin"));
				//Get text trang sau khi Submit
				String text = driver.findElement(By.xpath("//table//td//h2")).getText();
				System.out.println(text);
				Assert.assertEquals(text, "Access details to demo site.");
				//close
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		System.out.println("Chuyển về của số chính" + driver.getCurrentUrl());
	}
	
	@AfterTest
	public void alertclose() {
		quitDriver(driver);
	}
	
}
