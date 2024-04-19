package PageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import automation.common.CommonBase;

public class Changeavata extends CommonBase {
	//Login object
    private By textemail = By.xpath("//input[@id='txtLoginUsername']");
    private By textpass = By.xpath("//input[@id='txtLoginPassword']");
    private By btnlogin = By.xpath("//button[@type='submit']");
  //avata
    private By avata = By.xpath("//div[@class='avatar2']");
    private By btneditprofile = By.xpath("//a[text()='Chỉnh sửa thông tin']");
    private By btnsave = By.xpath("//button[text()='Lưu thông tin']");
    
    public Changeavata (WebDriver _driver){
		this.driver=_driver;
	}
    
  //Login
    public void login(String email, String pass) {
    	type(textemail, email);
    	type(textpass, pass);
    	click(btnlogin);
    }
    
  //changeavata
    public void changeavata(String filePath) {
    	click(avata);
    	click(btneditprofile);
    	pause(3000);
    	WebElement uploadBtn = driver.findElement(By.xpath("//*[@id='uploadBtn']"));
    	uploadBtn.click();
    	pause(2000);
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//        // Sử dụng JavaScript để đặt giá trị cho input file
//        String script = "arguments[0].style.display='block';";
//        js.executeScript(script, driver.findElement(By.xpath("//*[@id='uploadBtn']")));
               
        // Gửi đường dẫn của tệp tin đến input file
        WebElement uploadInput = driver.findElement(By.xpath("//*[@id='thongtinchung']/div[1]/a/img"));
        uploadInput.sendKeys(filePath);
        AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[text()='1045.jpg tải lên hoàn tất']")));
        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Lưu thông tin']"));
        saveButton.click();
    }
    
}
