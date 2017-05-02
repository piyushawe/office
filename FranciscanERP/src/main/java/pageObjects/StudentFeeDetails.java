package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentFeeDetails {
WebDriver dr;
By cls=By.id("ContentPlaceHolder1_ddlClass");
By section=By.id("ContentPlaceHolder1_ddlSection");
By text=By.id("ContentPlaceHolder1_txtSearch");
By search=By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton2\"]/input");
By save=By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]");
By view=By.id("ContentPlaceHolder1_BtnControls1_btnView");
By cancel=By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1\"]/input[4]");
By concession=By.id("ContentPlaceHolder1_lstconinst");
By classgroup=By.id("ContentPlaceHolder1_txtName_TextBox");
By specialgroup=By.id("ContentPlaceHolder1_ddlgroup");
//By viewsearch
//By viewselect
//By viewclose

    public StudentFeeDetails(WebDriver d)
    {
	   this.dr=d;
    }
    public void openStudentFeeDetails() throws InterruptedException
    {
    	WebElement menu;
	      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Fee-Master.png']"));
	      Thread.sleep(4000);
	      Actions builder= new Actions(dr);
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Student Fee Details"));
		  menuop1.click();
		  dr.switchTo().frame(dr.findElement(By.id("Student Fee Details")));
    }
    public void selectClass(String s) throws InterruptedException
    {
        Select c= new Select(dr.findElement(cls));
        c.selectByVisibleText(s);
        Thread.sleep(2000);
    }
    public void selectSection(String s)
    {
       Select sec= new Select(dr.findElement(section));
       sec.selectByVisibleText(s);
    }
    public void enterText(String str) throws InterruptedException
    {
    	WebElement name= dr.findElement(text);
    	name.sendKeys(str);
    	name.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	name.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	name.sendKeys(Keys.ENTER);
    	Thread.sleep(500);   
    }
    public void searchStudent(String c, String sec, String txt) throws InterruptedException
    {
    	new Select(dr.findElement(cls)).selectByVisibleText(c);
    	Thread.sleep(500);
    	new Select(dr.findElement(section)).selectByVisibleText(sec);
    	Thread.sleep(500);
    	WebElement name= dr.findElement(text);
    	name.sendKeys(txt);
    	name.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	name.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	name.sendKeys(Keys.ENTER);
    	Thread.sleep(500);
    	name.sendKeys(Keys.ENTER);
    	Thread.sleep(500); 
    }
    public void clickSearch()
    {
    	dr.findElement(search).click();
    }
    public void assignConcession(String conc) throws InterruptedException
    {
    	dr.findElement(By.xpath("//button[@type='button']")).click();
    	dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
    	Thread.sleep(1000);
    	WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
    	List<WebElement>options=select.findElements(By.tagName("span"));
    	for(WebElement option:options)
    	{
    		if(option.getText().equals(conc))
    			option.click();
    		dr.findElement(By.xpath("//li[@class='ui-multiselect-close']")).click();
    	}
    }
    public void clickSave()
    {
    	dr.findElement(save).click();
    }
    public void clickView()
    {
    	dr.findElement(view).click();
    }
    public void clickCancel()
    {
    	dr.findElement(cancel).click();
    }
    public void viewSearch(String s)
    {
    	
    }
    public void viewSelect()
    {
    	
    }
    public void viewClose()
    {
    	
    }
}    
