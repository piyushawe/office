package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentStrengthRatioWiseReport {
	WebDriver dr;
	By cls= By.id("ContentPlaceHolder1_ddlClass");
	By section= By.id("ContentPlaceHolder1_ddlSection");
	By date= By.id("ContentPlaceHolder1_dtjoinfromto_TextBox");
	By detailswithnewoldstudentstatus= By.id("ContentPlaceHolder1_chknewoldstatus");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");

    public StudentStrengthRatioWiseReport(WebDriver d)
     {
	    this.dr=d;
     }
    public void openStudentStrengthRatioWiseReport()
     {
   	    WebElement menu;
   	    Actions builder= new Actions(dr);
	      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	      builder.moveToElement(menu).build().perform();
	      WebElement menuop1= dr.findElement(By.linkText("Student Strength Ratio Wise Report"));
   	      menuop1.click();
	      dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	      dr.switchTo().frame(dr.findElement(By.id("Student Strength Ratio Wise Report")));
     }
    public void selectClass(String c)
    {
    	new Select(dr.findElement(cls)).selectByVisibleText(c);
    }
    public void selectSection(String sec) throws InterruptedException
    {   
    	Thread.sleep(1000);
    	new Select(dr.findElement(section)).selectByVisibleText(sec);
    }
    public void selectDate(String mm, String yy, String dd) throws InterruptedException
    {  Thread.sleep(1000);
    	dr.findElement(date).click();
    	  Thread.sleep(1000);
    	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
          Thread.sleep(1000);
          new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
    	  Thread.sleep(1000);
    	  WebElement myw=dr.findElement(By.className("datepick"));
        //List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
    	//	for (WebElement row: rows){  
    		 List<WebElement> cells=myw.findElements(By.tagName("td"));
    		  for(WebElement cell: cells) {
    			if (cell.getText().equals(dd)){  
    			cell.click();
    			break; 
    		 }  
    	//    }
      }Thread.sleep(1000);
    } 
    public void clickDetailsWithNewOldStudentStatus()
    {
    	dr.findElement(detailswithnewoldstudentstatus).click();
    }
    public void clickShow() throws InterruptedException
    {
    	 String exp= "STUDENT STRENGTH RATIO REPORT";
	   	 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
	     u.verifyPage(dr,exp);
    }
}
