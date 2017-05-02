package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class CancelledFeesReceiptReport {
WebDriver dr;
   By fromdate= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
   By todate= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
   
   public CancelledFeesReceiptReport(WebDriver d)
   {
	   this.dr=d;
   }
//open cancelled fees receipt report   
   public void openCancelledFeesReceiptReport()
   {
	   WebElement menu;
	   	  Actions builder= new Actions(dr);
	   	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
	     dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Cancelled Fees Receipt Report"));
		  menuop1.click();
		  
		  dr.switchTo().frame(dr.findElement(By.id("Cancelled Fees Receipt Report")));
   }
//from date   
   public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(fromdate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	    }Thread.sleep(500);
   }
//to date   
   public void selectToDate(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(todate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	    }Thread.sleep(500);
   }
//show   
   public void clickShow() throws InterruptedException
   {
	String exp="CANCELLED FEES RECEIPT(S) REPORT ";
   	Utility u= new Utility(); 
   	dr.findElement(show).click();
   	Thread.sleep(2000);
   	u.verifyPage(dr,exp);
   }
   public void findStudent(String name)
   {
	   Utility u= new Utility();
	   u.findStudentOnReport(dr, name);
   }
}
