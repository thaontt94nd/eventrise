package PageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import automation.common.CommonBase;

public class Riseevent extends CommonBase {
	//Login object
    private By buttonSignin = By.xpath("//button[normalize-space()='Sign in']");
    //menu Event
    private By menuevent = By.xpath("//span[normalize-space()='Events']");
    //addevent
    private By addevent = By.xpath("(//a[@title='Add event'])[2]");
    private By txttitle = By.xpath("//input[@id='title']");
    private By startdate = By.xpath("//input[@id='start_date']");
    private By enddate = By.xpath("//input[@id='end_date']");
    private By uploadfile = By.xpath("//*[@id='events-dropzone']/div[2]/div/button[1]");
//    WebElement uploadElement = driver.findElement(By.xpath("//*[@id="events-dropzone"]/div[2]/div/button[1]"));
    private By btnsave = By.xpath("//button[@type='submit']");
    //deleteeventsuccess
    private By btndelete = By.xpath("//a[@id='delete_event']");
    private By btnY = By.xpath("//button[text()=' Yes']");
    //month
    private By btnmonth = By.xpath("//button[text()='month']");
    
    public Riseevent (WebDriver _driver){
		this.driver=_driver;
	}
	//Login
    public void login() {
//    	click(By.xpath("//div[@class='box-content demo-email'][1]"));
        click(buttonSignin);
    }
  //menuevent
    public void menuevent() {
        click(menuevent);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.stop();");
    }
    //addeventsuccess
    public void addeventsuccess(String title, String startdate1,String enddate1) {
    	click(addevent);
    	type(txttitle, title);
    	type(startdate, getCurrentDateTime());
    	type(enddate, getCurrentDateTime());
    	click(btnsave);
    }
    public void addeventsuccessupload(String title, String startdate1,String enddate1, String filePath, String tenfile) {
    	click(addevent);
    	type(txttitle, title);
        type(startdate, getCurrentDateTime());
        type(enddate, getCurrentDateTime());
     // Tạo một đối tượng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Sử dụng JavaScript để đặt giá trị cho input file
        String script = "arguments[0].style.display='block';";
        js.executeScript(script, driver.findElement(By.xpath("//input[@type='file']")));
        
        // Gửi đường dẫn của tệp tin đến input file
        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
        uploadInput.sendKeys(filePath+tenfile);
        Assert.assertTrue(isElementPresent(By.xpath("//img[@alt='" + tenfile + "']")));
//        String xpath = "//img[@alt='1-2.jpg']";
//        
//        // Kiểm tra sự xuất hiện của phần tử
//        WebElement element4 = null;
//        try {
//            element4 = driver.findElement(By.xpath(xpath));
//            System.out.println("Phần tử được tìm thấy trên trang web.");
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            System.out.println("Phần tử không được tìm thấy trên trang web.");
//        }
        pause(3000);
        click(btnsave); 
    }
    
  //deleteeventsuccess
    public void deleteeventsuccess() {
    	
    	click(By.xpath("//td[@data-date='"+getCurrentDateTime1()+"']/div/div[2]/div/a/span/span[text()=' event5']"));
    	click(btndelete); 
    	click(btnY);
    }
//  //Month
//    public void month() {
//       	click(btnmonth);
//       	
//    }
}
