package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Checkbox extends CommonBase{
//	@BeforeTest
//	@Parameters ("browser")
//	public void initDriver(String browser) {
//		setupDriver(browser);
//		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
//	}
	
	@BeforeTest
	public void initDriverTest() {
		driver =initChromeDriver();
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}
	
	@Test
	public void isSingleCheckboxSelected() {
//		driver=initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
		driver.findElement(By.id("isAgeSelected")).isSelected();
		boolean isSelected = false;
		if(isSelected==false) {
			driver.findElement(By.id("isAgeSelected")).click();
			System.out.println("Checkbox đang được select");
		}
		driver.close();

	}
	
	@Test
	public void isRadioSelected() {
//		driver=initChromeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		WebElement CheckboxMale= driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
		driver.findElement(By.xpath("//input[@value='Male' and @name='optradio' ]")).isEnabled();
		CheckboxMale.click();
		boolean isSelected = CheckboxMale.isSelected();
		if(isSelected==false) {
			CheckboxMale.click();
			System.out.println("Radiobutton đang được select");
		}else {
			driver.findElement(By.xpath("//input[@value='Female' and @name='optradio' ]")).click();
			System.out.println("Radiobutton đang được select");
		}
		driver.close();

	}
	
	@Test
	public void isdropdownlistSelected() {
		//Vào trang
		driver=initChromeDriver("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		//Tìm đến thẻ select là dropdownlist
		Select dropdownlist= new Select(driver.findElement(By.xpath("//select[@id='select-demo']")));
		//Tìm size của dropdownlist
		Assert.assertEquals(8, dropdownlist.getOptions().size());
		System.out.println("Có 8 giá trị "+dropdownlist.getOptions().size());
		//Chọn monday bằng 3 cách
		driver.findElement(By.xpath("//select[@id='select-demo']")).click();
//		dropdownlist.selectByVisibleText("Monday");
//		dropdownlist.selectByValue("Monday");
		dropdownlist.selectByIndex(2);
		driver.findElement(By.xpath("//select[@id='select-demo']")).click();
		//Kiểm tra giá trị đã chọn
		Assert.assertEquals("Monday",dropdownlist.getFirstSelectedOption().getText());
		System.out.println("giá trị là "+dropdownlist.getFirstSelectedOption().getText());
		driver.close();

	}
}
