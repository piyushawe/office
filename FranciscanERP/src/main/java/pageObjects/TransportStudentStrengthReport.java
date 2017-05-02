package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TransportStudentStrengthReport {
WebDriver dr;
  By cls= By.id("ContentPlaceHolder1_ddlClass");
  By section= By.id("ContentPlaceHolder1_ddlSection");
  By route= By.id("ContentPlaceHolder1_ddlRoute");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
  
   public TransportStudentStrengthReport(WebDriver d)
   {
       this.dr=d;
   }
   public void openTransportStudentStrengthReport() throws InterruptedException
   {   
       WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
      //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Thread.sleep(5000);
      Actions builder= new Actions(dr);
      builder.moveToElement(menu).build().perform();
      dr.findElement(By.linkText("Transport Student Strength Report")).click();
      dr.switchTo().frame(dr.findElement(By.id("Transport Student Strength Report")));
   }
   public void selectClass(String c)
   {
	   Select cs= new Select(dr.findElement(cls));
	   cs.selectByVisibleText(c);
   }
   public void selectSection(String s) throws InterruptedException
   {   
	   Thread.sleep(1000);
	   Select sec= new Select(dr.findElement(section));
	   sec.selectByVisibleText(s);
   }
   public void selectRoute(String r) throws InterruptedException
   {
	   Thread.sleep(1000);
	   Select rt= new Select(dr.findElement(route));
	   rt.selectByVisibleText(r);
   }
   public void clickShow() throws InterruptedException
   {
	   String exp= "STUDENT REPORT";
       Utility u= new Utility(); 
       dr.findElement(show).click();
       Thread.sleep(2000);
       u.verifyPage(dr,exp);
   }
}
