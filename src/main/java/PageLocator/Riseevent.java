package PageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    	click(By.xpath("//div[@class='box-content demo-email'][1]"));
        click(buttonSignin);
    }
  //menuevent
    public void menuevent() {
        click(menuevent);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.stop();");
    }
    //addeventsuccess
    public void addeventsuccess(String title, String startdate1,String enddate1 ) {
    	click(addevent);
    	type(txttitle, title);
    	type(startdate, getCurrentDateTime());
    	type(enddate, getCurrentDateTime());
    	click(btnsave);  	
    }
  //deleteeventsuccess
    public void deleteeventsuccess() {
    	
    	click(By.xpath("//span[text()=' event4']/ancestor::td[@data-date='"+getCurrentDateTime1()+"']"));
    	click(btndelete); 
    	click(btnY);
    }
//  //Month
//    public void month() {
//       	click(btnmonth);
//       	
//    }
}
