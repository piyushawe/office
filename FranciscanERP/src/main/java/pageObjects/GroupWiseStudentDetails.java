package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GroupWiseStudentDetails {
  WebDriver dr;
     By cls= By.id("ContentPlaceHolder1_ddlclass");
     By section= By.id("ContentPlaceHolder1_ddlsection");
     By group= By.id("ContentPlaceHolder1_ddlgroup");
     By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
     
     public GroupWiseStudentDetails(WebDriver d)
     {
    	 this.dr=d;
     }
     public void openGroupWiseStudentDetails() throws InterruptedException
     {
    	 WebElement menu;
         Actions builder= new Actions(dr);
         menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
         Thread.sleep(4000);
    	 builder.moveToElement(menu).build().perform();
    	 WebElement menuop1= dr.findElement(By.linkText("Group Wise Student Details"));
    	 menuop1.click();
    	 dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 dr.switchTo().frame(dr.findElement(By.id("Group Wise Student Details")));
     }
     public void selectClass(String c)
     {
    	 new Select(dr.findElement(cls)).selectByVisibleText(c);
     }
     public void selectSection(String sec)
     {
    	 new Select(dr.findElement(section)).selectByVisibleText(sec);
     }
     public void selectGroup(String gp)
     {
    	 new Select(dr.findElement(group)).selectByVisibleText(gp);
     }
     public void clickShow() throws InterruptedException
	 {
		String exp= "GROUP WISE STUDENT DETAILS";
	    Utility u= new Utility(); 
	 	dr.findElement(show).click();
	 	Thread.sleep(2000);
	    u.verifyPage(dr,exp);
	 }
}
