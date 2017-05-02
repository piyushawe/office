package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentHealthEntryReport {
WebDriver dr;
   //By cls= By.id("ContentPlaceHolder1_lstClass");
   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
    
   public StudentHealthEntryReport(WebDriver d)
   {
	   this.dr=d;
   }
   public void openStudentHealthEntryReport() throws InterruptedException
	 {   
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Student Health Entry Report")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Student Health Entry Report")));
	 }
   public void selectClass(String c)
   {
	  //new Select(dr.findElement(cls)).selectByVisibleText(c);
	   dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(1) > div > button")).click();
	   dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
	   WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
	   List<WebElement> options= dr.findElements(By.tagName("span"));
	   for(WebElement option:options)
	   {
		   if(c.equals(option.getText())){
			 option.click();   
		   }
	   }dr.findElement(By.className("ui-multiselect-close")).click();
   }
   public void clickShow() throws InterruptedException
   {
	      String exp= "STUDENT HEALTH ENTRY REPORT";
		  Utility u= new Utility(); 
	      dr.findElement(show).click();
	      Thread.sleep(2000);
		  u.verifyPage(dr,exp);
   }
}
