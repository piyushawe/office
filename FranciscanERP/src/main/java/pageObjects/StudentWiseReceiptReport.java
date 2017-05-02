package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentWiseReceiptReport {
WebDriver dr;
   By cls= By.id("ContentPlaceHolder1_ddlClass");
   By section= By.id("ContentPlaceHolder1_ddlSection");
   By student= By.id("ContentPlaceHolder1_txtName");
   By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
   By datefrom= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
   By dateto= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
   
  public StudentWiseReceiptReport(WebDriver d)
   {
	   this.dr=d;
   }
   public void openStudentWiseReceiptReport() throws InterruptedException
	 {   
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Student Wise Receipt Report")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Student Wise Receipt Report")));
	 }
   public void selectClass(String c)
   {
	   new Select(dr.findElement(cls)).selectByVisibleText(c);
   }
   public void selectSection(String sec)
   {
	   new Select(dr.findElement(section)).selectByVisibleText(sec);
   }
   public void enterStudent(String s) throws InterruptedException
   {
	   dr.findElement(student).sendKeys(s);
	   Thread.sleep(1000);
       dr.findElement(student).sendKeys(Keys.ARROW_DOWN);
       Thread.sleep(1000);
       dr.findElement(student).sendKeys(Keys.ENTER);
   	   Thread.sleep(1000);
       dr.findElement(student).sendKeys(Keys.ENTER);
	   Thread.sleep(1000);
   }
   public void selectFeeType(String ftype)
   {
	   new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
   }
   public void selectDateFrom(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(datefrom).click();
	  	  Thread.sleep(500);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	        List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  		for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			cell.click();
	  			break; 
	  		 }  
	  	    }
	    }Thread.sleep(500);
   }
   public void selectDateTo(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(dateto).click();
	  	  Thread.sleep(500);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	        List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  		for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			cell.click();
	  			break; 
	  		 }  
	  	    }
	    }Thread.sleep(500);
   }
   public void clickShow() throws InterruptedException
   {
	   String exp= "STUDENT WISE RECEIPT REPORT";
	   	 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
	     u.verifyPage(dr,exp);
   }
}
