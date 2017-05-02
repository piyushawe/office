package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClassSectionTransferReport {
WebDriver dr;
  By cls= By.id("ContentPlaceHolder1_ddlclass");
  By section= By.id("ContentPlaceHolder1_ddlsection");
  By oldacademicyear= By.id("ContentPlaceHolder1_ddlOldAcademicYear");
  By oldfinancialyear= By.id("ContentPlaceHolder1_ddlOldFinancialYear");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
  
  public ClassSectionTransferReport(WebDriver d)
  {
	  this.dr=d;
  }
  public void openClassSectionTransferReport()
  {
	  WebElement menu;
   	  Actions builder= new Actions(dr);
   	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  builder.moveToElement(menu).build().perform();
	  WebElement menuop1= dr.findElement(By.linkText("Class Section Transfer Report"));
	  menuop1.click();
	  dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  dr.switchTo().frame(dr.findElement(By.id("Class Section Transfer Report")));
  }
  public void selectClass(String s)
  {
	  Select c= new Select(dr.findElement(cls));
	  c.selectByVisibleText(s);
  }
  public void selectSection(String s)
  {
	  Select sec= new Select(dr.findElement(section));
	  sec.selectByVisibleText(s);
  }
  public void selectOldAcademicYear(String y)
  {
	  Select acyr= new Select(dr.findElement(oldacademicyear));
	  acyr.selectByVisibleText(y);
  }
  public void selectOldFinancialYear(String y)
  {
	  Select fyr= new Select(dr.findElement(oldfinancialyear));
	  fyr.selectByVisibleText(y);
  }
  public void clickShow() throws InterruptedException
  {
	    String exp="PROMOTION LIST";
	   	Utility u= new Utility(); 
	   	dr.findElement(show).click();
	   	Thread.sleep(2000);
	   	u.verifyPage(dr,exp);
  }
}
