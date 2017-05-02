package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentWiseCollectionReport {
WebDriver dr;
  By cls= By.id("ContentPlaceHolder1_ddlClass");
  By section= By.id("ContentPlaceHolder1_ddlSection");
  By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
  By school= By.id("ContentPlaceHolder1_ddlAccount");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
		  
  public StudentWiseCollectionReport(WebDriver d)
  {
	  this.dr=d;
  }
  public void openStudentWiseCollectionReport() throws InterruptedException
  {
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Collection"));
		 builder.moveToElement(submenu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Student Wise Collection Report")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Student Wise Collection Report")));
  }
  public void selectClass(String s) throws InterruptedException
  {
	  Select c=new Select(dr.findElement(cls));
	  c.selectByVisibleText(s);
	  Thread.sleep(1000);
  }
  public void selectSection(String s) throws InterruptedException
  {
	  Select sec=new Select(dr.findElement(section));
	  sec.selectByVisibleText(s);
	  Thread.sleep(1000);
  }
  public void selectFeeType(String s) throws InterruptedException
  {
	  Select ftype= new Select(dr.findElement(feetype));
	  ftype.selectByVisibleText(s);
	  Thread.sleep(1000);
  }
  public void selectSchool(String s)
  {
	  Select sch= new Select(dr.findElement(school));
	  sch.selectByVisibleText(s);
  }
  public void clickShow() throws InterruptedException
  {
	     String exp= "STUDENT WISE COLLECTION REPORT";
	   	 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
	     u.verifyPage(dr,exp);
  }
}
