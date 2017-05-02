package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActiveInactiveStudentsDetailReport {
WebDriver dr;
    By cls= By.id("ContentPlaceHolder1_ddlClass");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    By user= By.id("ContentPlaceHolder1_ddlUser");
    By fromdate= By.id("ContentPlaceHolder1_txtfromDate_TextBox");
    By tilldate= By.id("ContentPlaceHolder1_txttoDate_TextBox");
    By active= By.id("ContentPlaceHolder1_rdbOption_0");
    By inactive= By.id("ContentPlaceHolder1_rdbOption_1");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
    
     public ActiveInactiveStudentsDetailReport(WebDriver d)
      {
	    this.dr=d;
      }
//open ActiveInactiveStudentsDetailReport     
     public void openActiveInactiveStudentsDetailReport()
      {
    	  WebElement menu;
    	  Actions builder= new Actions(dr);
 	      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	      builder.moveToElement(menu).build().perform();
	      WebElement menuop1= dr.findElement(By.linkText("Active/Inactive Students Detail Report"));
    	  menuop1.click();
	      dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      dr.switchTo().frame(dr.findElement(By.id("Active/Inactive Students Detail Report")));
      }
//select class     
     public void selectClass(String c)
     {
    	 Select cs= new Select(dr.findElement(cls));
    	 cs.selectByVisibleText(c);
     }
//select section     
     public void selectSection(String s)
     {
    	 Select sec= new Select(dr.findElement(section));
    	 sec.selectByVisibleText(s);
     }
//select user     
     public void selectUser(String u)
     {
    	 new Select(dr.findElement(user)).selectByVisibleText(u);
     }
//select from date     
     public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
     {
    	 dr.findElement(fromdate).click();
  	     Thread.sleep(1000);
   	     new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
         Thread.sleep(1000);
         new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
   	     Thread.sleep(1000);
   	     WebElement myw=dr.findElement(By.className("datepick"));
			 List<WebElement> cells=myw.findElements(By.tagName("td"));
			  for(WebElement cell: cells) {
				if (cell.getText().equals(dd)){  
					System.out.println("cell value"+cell.getText());
					cell.click();
				break; 
			 }  
     }Thread.sleep(1000);
     }
//select till date     
     public void selectTillDate(String mm, String yy, String dd) throws InterruptedException
     {
    	 dr.findElement(tilldate).click();
  	     Thread.sleep(1000);
   	     new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
         Thread.sleep(1000);
         new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
   	     Thread.sleep(1000);
   	     WebElement myw=dr.findElement(By.className("datepick"));
			 List<WebElement> cells=myw.findElements(By.tagName("td"));
			  for(WebElement cell: cells) {
				if (cell.getText().equals(dd)){  
					System.out.println("cell value"+cell.getText());
					cell.click();		
				break; 
			 }  
     }Thread.sleep(1000);
     }
//click active     
     public void clickActive()
     {
    	 dr.findElement(active).click();
     }
//click inactive     
     public void clickInActive()
     {
    	 dr.findElement(inactive).click();
     }
//click show     
     public void clickShow() throws InterruptedException
     {   String exp= "STUDENT STATUS REPORT";
    	 Utility u= new Utility(); 
    	 dr.findElement(show).click();
    	 Thread.sleep(5000);
    	 u.verifyPage(dr,exp);
     }
}
