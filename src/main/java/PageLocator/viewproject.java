package PageLocator;

import static org.testng.Assert.assertTrue;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.FluentWait;

import automation.common.CommonBase;
//import io.netty.handler.timeout.TimeoutException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class viewproject extends CommonBase {
	//Login object
    private By buttonSignin = By.xpath("//button[normalize-space()='Sign in']");
  //Dashboard object
    private By dashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    //filter
    private By filter = By.xpath("//div[@class='dropdown smart-filter-dropdown-container']//button");
    private By txtsearch = By.xpath("//input[@class='form-control search-filter']");
    private By dropdownfilter = By.xpath("//a[normalize-space()='Completed']");
    private By dropdownfilter1 = By.xpath("//a[normalize-space()='High Priority']");
    private By btncleanfilter = By.xpath("//a[normalize-space()='Clear']");
    private By btnmanagefilter = By.xpath("//a[normalize-space()='Manage Filters']");
    //managefilter
    private By search_managefilter = By.xpath("//div[@id='filters-table_filter']//input[@class='form-control form-control-sm']");
    private By Change_filters_managefilter = By.xpath("//a[@title='Change filters']");
    private By Edit_managefilter1 = By.xpath("//a[@title='Edit']");
    private By Edit_managefilter = By.xpath("(//a[@title='Edit'])[4]");
    private By Delete_managefilter = By.xpath("//a[@title='Delete']");
    private By close_managefilter = By.xpath("//button[@class='btn btn-default close-manage-modal']");
    //icon +
    private By btnextendedfilter = By.xpath("//button[@class='btn btn-default show-filter-form-button']");
   //bookmark
    private By bookmarkallproject = By.xpath("//button[@data-id='ecmkusuchl']");
    private By bookmarkHighPriority = By.xpath("//button[@data-id='nkuyhedude']");
    private By bookmark51 = By.xpath("//button[normalize-space()='51']");
    private By bookmarkopen = By.xpath("//button[@type='button' and @data-id='ohenbtrdgc']");
    //Setup colum
    private By setupcolum = By.xpath("//ul[@data-table='project-table']//li[4]");
    //label
    private By label = By.xpath("//div[@id='s2id_autogen3']//a");
    private By searchlabel = By.xpath("//input[@id='s2id_autogen4_search']");
    private By dropdownlabel = By.xpath("//li[normalize-space()='On track']");
    //Startdate
    private By startdate = By.xpath("//div[normalize-space()='Start date']");
    private By drpstartdate2 = By.xpath("//li[normalize-space()='Last Month']");
    private By drpstartdate1 = By.xpath("//li[normalize-space()='This Month']");
    
    private By Startfrom = By.xpath("//button[@name='start_date_from']");
    private By datefrom = By.xpath("((//table[@class='table-condensed']//tbody//tr)[2]//td)[5]");
    private By Startto = By.xpath("//button[@name='start_date_to']");
    private By dateto = By.xpath("((//table[@class='table-condensed']//tbody//tr)[5]//td)[5]");
    private By btncleandate = By.xpath("//div[normalize-space()='Clear']");
    
    //deadline
    private By deadline = By.xpath("//button[@name='deadline']");
    private By drpdeadline_in7day = By.xpath("//div[normalize-space()='In 7 days']");
    private By drpdeadline_Custom = By.xpath("//div[normalize-space()='Custom']");
    //status
    private By status = By.xpath("//button[normalize-space()='Status']");
    private By drpstatus = By.xpath("//li[normalize-space()='Open']");
    //addnewfilter
    private By addnewfilter = By.xpath("//button[@data-post-instance_id='project-table']");
    private By txttitle = By.xpath("//input[@name='title']");
    private By checkboxbookmark = By.xpath("//input[@name='bookmark']");
    private By iconfilter = By.xpath("//span[@data-icon='anchor']");
    private By btnsave = By.xpath("//button[@type='submit']");
    private By btnclose = By.xpath("//button[@type='submit']//preceding-sibling::button");
    public viewproject (WebDriver _driver){
		this.driver=_driver;
	}
	//Login
    public void login() {
        click(buttonSignin);
    }
  //menuproject
    public void menuproject() {
        click(menuProject);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.stop();");
    }
    //filtersearcch
    public void filterproject(int column, String value) {
    	click(filter);
    	type(txtsearch, value);
    	click(dropdownfilter);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	String text= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
//        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", text);
        	System.out.print(value + " - ");
            System.out.println(text);
            Assert.assertTrue(text.toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }
    public void filterproject2(int column, String value) {
    	click(filter);
    	click(dropdownfilter1);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	WebElement text= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]/span"));
        	System.out.print(value + " - ");
            System.out.println(text.getText());
            Assert.assertTrue(text.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }
   //cleanfilter
    public void cleanfilter() {
    	click(filter);
    	click(btncleanfilter);
    	Assert.assertFalse(driver.findElement(btncleanfilter).isDisplayed());
    	}
  //findmanagefilter
    public void findmanagefilter(int column,String value) {
    	click(filter);
    	click(btnmanagefilter);
    	type(search_managefilter, value);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='filters-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	String text= driver.findElement(By.xpath("//table[@id='filters-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	System.out.print(value + " - ");
            System.out.println(text);
            Assert.assertTrue(text.toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        	}        
    	}
  //Changefilter
    public void Changefilter(int column, String value) {
    	click(Change_filters_managefilter);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	WebElement text= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]/span"));
//        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", text);
        	System.out.print(value + " - ");
            System.out.println(text.getText());
            Assert.assertTrue(text.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }    
    }
    //addfilter
    public void addfilter(int column, String value) {
    	click(By.xpath("//button[@class='btn btn-default cancel-filter-button']"));
    	click(btnextendedfilter);
    	click(addnewfilter);
    	pause(5000);
    	type(txttitle, value);
    	click(checkboxbookmark);
    	click(btnsave);
    	pause(5000);
    	click(filter);
    	click(btnmanagefilter);
    	type(search_managefilter, value);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='filters-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	String text= driver.findElement(By.xpath("//table[@id='filters-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	System.out.print(value + " - ");
            System.out.println(text);
            Assert.assertTrue(text.toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        	} 
    	
    	}
    //Editnamefilter
    public void Editnamefilter(int column, String value) {
    	click(Edit_managefilter1);
    	pause(5000);
    	driver.findElement(txttitle).clear();
    	type(txttitle, value);
    	click(btnsave);
    	pause(5000);
    	click(filter);
    	click(btnmanagefilter);
    	type(search_managefilter, value);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='filters-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	String text= driver.findElement(By.xpath("//table[@id='filters-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	System.out.print(value + " - ");
            System.out.println(text);
            Assert.assertTrue(text.toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        	}    
    }
  //Editunbookmark
    public void Editunbookmark() {
    	click(By.xpath("//a[@title='Edit']"));
    	pause(5000);
    	click(checkboxbookmark);
    	click(btnsave);
    	pause(8000);
    	Assert.assertTrue(isElementNotPresent(bookmark51));
    }
    //setupcolummanagefilter
    public void setupcolummanagefilter() {
    	click(filter);
    	click(btnmanagefilter);
    	click(By.xpath("(//button[@class='btn btn-default column-show-hide-popover'])[2]"));
    	click(By.xpath("//li[normalize-space()='Bookmark']"));
    	pause(8000);
    	Assert.assertTrue(isElementNotPresent(By.xpath("//li[normalize-space()='Bookmark']")));
    }
//  //closemanagefilter
//    public void closemanagefilter() {
//    	click(btnclose);
//    }
  //Delete_managefilter
    public void Deletemanagefilter(int column, String value) {
    	type(search_managefilter, value);
    	click(Delete_managefilter);
    	driver.findElement(search_managefilter).clear();
    	type(search_managefilter, value);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='filters-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        //Duyệt từng dòng
        if (rows_count == 0) {
            System.out.println("Xóa thành công: " + value + " không còn trong bảng.");
        } else {
            System.out.println("Xóa không thành công: " + value + " vẫn còn trong bảng.");
        }   
    }
  //bookmark
    public void bookmark(int column, String value) {
    	click(close_managefilter);
    	click(bookmarkHighPriority);
    	pause(5000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	WebElement text= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]/span"));
        	System.out.print(value + " - ");
            System.out.println(text.getText());
            Assert.assertTrue(text.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }   
    }
    //setupcolum
    public void setupcolum() {
    	click(By.xpath("//button[@class='btn btn-default column-show-hide-popover']"));
    	click(setupcolum);
    	pause(8000);
    	Assert.assertTrue(isElementNotPresent(setupcolum));   
    }
    //label
    public void label(int column, String value) {
    	click(btnextendedfilter);
    	click(label);
    	type (searchlabel,value);
    	click(dropdownlabel);
    	pause(8000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	WebElement text= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]/span"));
        	System.out.print(value + " - ");
            System.out.println(text.getText());
            Assert.assertTrue(text.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }  
    }
    public void startdate(int column, String value) {
    	click(startdate);
    	click(drpstartdate2);
    	pause(8000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
     // Tính toán ngày đầu tiên của tháng trước
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date lastMonthStartDate = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String lastMonthStartDateString = dateFormat.format(lastMonthStartDate);

        //Duyệt từng dòng
        boolean found = false;
        for (int i = 1; i <= rows_count; i++) {
        	String startDateValue= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	if (startDateValue.equals(lastMonthStartDateString)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Có giá trị thỏa mãn điều kiện tìm kiếm.");
        } else {
            System.out.println("Không có giá trị thỏa mãn điều kiện tìm kiếm.");
        }
    }
    public void startdatethismonth(int column, String value) {
    	click(startdate);
    	click(drpstartdate1);
    	pause(8000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
     // Tính toán ngày đầu tiên của tháng này
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisMonthStartDate = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String thisMonthStartDateString = dateFormat.format(thisMonthStartDate);

        //Duyệt từng dòng
        boolean found = false;
        for (int i = 1; i <= rows_count; i++) {
        	String startDateValue= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	if (startDateValue.equals(thisMonthStartDateString)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Có giá trị thỏa mãn điều kiện tìm kiếm.");
        } else {
            System.out.println("Không có giá trị thỏa mãn điều kiện tìm kiếm.");
        }
    }
    public void startdatefromto(int column, String value1, String value2) {
    	click(Startfrom);
    	click(btncleandate);
    	pause(5000);
    	click(Startfrom);
    	click(datefrom);
    	pause(5000);
    	click(Startto);
    	click(dateto);
    	pause(8000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
 
        //Duyệt từng dòng
        boolean found = false;
        for (int i = 1; i <= rows_count; i++) {
        	String startDateValue= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	value1 = driver.findElement(Startfrom).getText();
        	value2 = driver.findElement(Startto).getText();
        	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        	try {
                Date startDateFromRow = dateFormat.parse(startDateValue);
                Date startDateInput = dateFormat.parse(value1);
                Date endDateInput = dateFormat.parse(value2);

                if (startDateFromRow.compareTo(startDateInput) >= 0 && startDateFromRow.compareTo(endDateInput) <= 0) {
                    found = true;
                    break;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (found) {
            System.out.println("Có giá trị thỏa mãn điều kiện tìm kiếm.");
        } else {
            System.out.println("Không có giá trị thỏa mãn điều kiện tìm kiếm.");
        }
    }
    //deadlinein7day
    public void deadlinein7day(int column, String value) {
    	click(deadline);
    	click(drpdeadline_in7day);
    	pause(8000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
     // Tính toán ngày sau 7 ngày
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date sevenDaysLater  = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String lastMonthStartDateString = dateFormat.format(sevenDaysLater);

        //Duyệt từng dòng
        boolean found = false;
        for (int i = 1; i <= rows_count; i++) {
        	String startDateValue= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	
        	try {
                Date deadlineDate = dateFormat.parse(startDateValue);
                if (deadlineDate.compareTo(sevenDaysLater) <= 0) {
                    found = true;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (found) {
            System.out.println("Có giá trị thỏa mãn điều kiện tìm kiếm.");
        } else {
            System.out.println("Không có giá trị thỏa mãn điều kiện tìm kiếm.");
        }
    }
    
  //status
    public void status(int column, String value) {
    	click(label);
    	click(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable'][1]"));
    	click(Startfrom);
    	click(btncleandate);
    	pause(8000);
    	click(status);
    	click(drpstatus);
    	pause(8000);
    	List < WebElement > rows_table = driver.findElements(By.xpath("//table[@id='project-table']//tbody/tr"));
    	int rows_count = rows_table.size();
        System.out.println("Số dòng tìm thấy: " + rows_count);
        
        //Duyệt từng dòng
        for (int i = 1; i <= rows_count; i++) {
        	String text= driver.findElement(By.xpath("//table[@id='project-table']//tbody/tr["+i+"]//td["+column+"]")).getAttribute("innerHTML");
        	System.out.print(value + " - ");
            System.out.println(text);
            Assert.assertTrue(text.toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }
}

