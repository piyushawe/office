package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentRegisterDateWiseReport {
WebDriver dr;
   By fromdate= By.id("ContentPlaceHolder1_txtfromDate_TextBox");
   By todate= By.id("ContentPlaceHolder1_txttoDate_TextBox");
   By cls= By.id("ContentPlaceHolder1_ddlClass");
   By section= By.id("ContentPlaceHolder1_ddlSection");
   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
	
	public StudentRegisterDateWiseReport(WebDriver d)
	{
		this.dr=d;
	}
	public void openStudentRegisterDateWiseReport()
	  {
		  WebElement menu;
	  	  Actions builder= new Actions(dr);
	  	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  	  dr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Student Register Date Wise Report"));
		  menuop1.click();
		  dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  dr.switchTo().frame(dr.findElement(By.id("Student Register Date Wise Report")));
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
	      //  List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
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
	public void selectToDate(String mm, String yy, String dd) throws InterruptedException
	{
		dr.findElement(todate).click();
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
	public void selectClass(String c) throws InterruptedException
	{
		Select cs= new Select(dr.findElement(cls));
		cs.selectByVisibleText(c);
		Thread.sleep(4000);
	}
	public void selectSection(String s)
	{
		Select sec= new Select(dr.findElement(section));
		sec.selectByVisibleText(s);
	}
	public void clickShow() throws InterruptedException
	{
		   String exp= "STUDENT REGISTER DATE WISE REPORT";
	   	   Utility u= new Utility(); 
	       dr.findElement(show).click();
	       Thread.sleep(2000);
	       u.verifyPage(dr,exp);
	}
}
