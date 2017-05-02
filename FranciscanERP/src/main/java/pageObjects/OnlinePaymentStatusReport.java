package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OnlinePaymentStatusReport {
	WebDriver dr;
	By fromdate= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
	By tilldate= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
	By show= By.name("ctl00$ContentPlaceHolder1$btnShow$ctl00");
	
	public OnlinePaymentStatusReport(WebDriver d)
	   {
		   this.dr=d;
	   }
	public void openOnlinePaymentStatusReport() throws InterruptedException
	 {   
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Online Payment Status Report")).click();
		// dr.findElement(By.linkText("Online Payment Status Report"));
		 dr.switchTo().frame(dr.findElement(By.id("Online Payment Status Report")));
	 }
	public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
	   {
		   dr.findElement(fromdate).click();
		  	  Thread.sleep(1000);
		  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
		      Thread.sleep(1000);
		      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
		  	  Thread.sleep(1000);
		  	  WebElement myw=dr.findElement(By.className("datepick"));
		       // List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
		    	//for (WebElement row: rows){  
		  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
		  		  for(WebElement cell: cells) {
		  			if (cell.getText().equals(dd)){  
		  			cell.click();
		  			break; 
		  		 }  
		  	  //  }
		    }Thread.sleep(1000);
	   }
	   public void selectTillDate(String mm, String yy, String dd) throws InterruptedException
	   {
		   dr.findElement(tilldate).click();
		  	  Thread.sleep(1000);
		  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
		      Thread.sleep(1000);
		      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
		  	  Thread.sleep(1000);
		  	  WebElement myw=dr.findElement(By.className("datepick"));
		    //    List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
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
	   public void clickShow() throws InterruptedException
	   {
		   String exp= "ONLINE PAYMENT STATUS REPORT";
		   	 Utility u= new Utility(); 
		     dr.findElement(show).click();
		     Thread.sleep(2000);
		     u.verifyPage(dr,exp);
	   }
}
