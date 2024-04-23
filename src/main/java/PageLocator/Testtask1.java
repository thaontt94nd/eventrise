package PageLocator;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;

public class Testtask1<SimpleDateFormat> extends CommonBase {
	//Login object
    private By buttonSignin = By.xpath("//button[normalize-space()='Sign in']");
    //menu
    private By menu = By.xpath("//span[normalize-space()='Tasks']");
    //filter
    private By filter = By.xpath("//button[@class='btn btn-default show-filter-form-button']");
    //Related to
    private By Relatedto = By.xpath("//div[@id='s2id_autogen5']");
    private By valueRelatedto = By.xpath("(//input[@type='text' and @autocomplete='off'])[8]");
  //project
    private By project = By.xpath("//div[@id='s2id_autogen7']");
    private By valueproject = By.xpath("//input[@id='s2id_autogen8_search']");
    //Milestone
    private By Milestone = By.xpath("//span[@id='select2-chosen-10']");
    private By valeMilestone1 = By.xpath("//input[@id='s2id_autogen10_search']");
    private By valeMilestone = By.xpath("//div[text()='Release']");
    //Member
    private By Member = By.xpath("//span[@id='select2-chosen-12']");
    private By valeMember = By.xpath("//input[@id='s2id_autogen12_search']");
  //Priority
    private By Priority = By.xpath("//span[@id='select2-chosen-14']");
    private By valePriority = By.xpath("//input[@id='s2id_autogen14_search']");
  //label
    private By label = By.xpath("//span[@id='select2-chosen-16']");
    private By valelabel = By.xpath("//input[@id='s2id_autogen16_search']");
    //Deadline
    private By Deadline = By.xpath("//button[@name='deadline']");
    private By Expired = By.xpath("//div[text()='Expired']");
    private By Today = By.xpath("//div[text()='Today']");
    private By Tomorrow = By.xpath("//div[text()='Tomorrow']");
    private By day7 = By.xpath("//div[text()='In 7 days']");
    
    //status
    private By status = By.xpath("//button[text()='Status ']");
    private By Todo = By.xpath("//ul[@class='list-group']//li[1]");
    private By progress = By.xpath("//ul[@class='list-group']//li[2]");
    private By Review = By.xpath("//ul[@class='list-group']//li[3]");
    
    public Testtask1 (WebDriver _driver){
		this.driver=_driver;
	}
    
  //Login
    public void login() {
        click(buttonSignin);
    }
    //menu
    public void menu() {
        click(menu);
    }
    
  //filter
    public void filter() {
        click(filter);
    }
  //Related to
    public void Relatedto(String Relatedto1,String project1) {
        click(Relatedto);
        type(valueRelatedto,Relatedto1);
        typeKeyTabs(valueRelatedto);
        click(project);
        type(valueproject,project1);
        typeKeyTabs(valueproject);
    }
  //Milestone
    public void Milestone() {
        click(Milestone);
        click(valeMilestone);
    }
  //Member
    public void Member(String member1) {
        click(Member);
        type(valeMember,member1);
        typeKeyTabs(valeMember);
    }
  //Priority
    public void Priority(String Priority1) {
        click(Priority);
        type(valePriority,Priority1);
        typeKeyTabs(valePriority);
    }
  //Label
    public void Label(String Label) {
        click(label);
        type(valelabel,Label);
        typeKeyTabs(valelabel);
    }
	
  //Deadline Expired
    public void Expired() {
        click(Deadline);
        click(Expired);
    }
  //Deadline today
    public void Today() {
        click(Deadline);
        click(Today);
    }
  //Deletevalue
    public void Deletevalue(String Relatedto2,String project2,String Milestone2, String member2, String Priority2, String Labe2 ) {
        click(Relatedto);
        type(valueRelatedto,Relatedto2);
        typeKeyTabs(valueRelatedto);
        click(project);
        type(valueproject,project2);
        typeKeyTabs(valueproject);
        click(Milestone);
        type(valeMilestone1,Milestone2);
        typeKeyTabs(valeMilestone1);
        click(Member);
        type(valeMember,member2);
        typeKeyTabs(valeMember);
        click(Priority);
        type(valePriority,Priority2);
        typeKeyTabs(valePriority);
        click(label);
        type(valelabel,Labe2);
        typeKeyTabs(valelabel);
    }
  //Deadline Tomorrow
    public void Tomorrow() {
        click(Deadline);
        click(Tomorrow);
    }
  //Deadline day7
    public void day7() {
        click(Deadline);
        click(day7);
    }
  //Status
    public void status() {
        click(status);
        click(Review);       
    }
}
