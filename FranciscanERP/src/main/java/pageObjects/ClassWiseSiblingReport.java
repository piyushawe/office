package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClassWiseSiblingReport {
WebDriver dr;
  By cls= By.id("ContentPlaceHolder1_ddlClass");
  By section= By.id("ContentPlaceHolder1_ddlSection");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
  
  public ClassWiseSiblingReport(WebDriver d)
  {
	  this.dr=d;
  }
  public void openClassWiseSiblingReport()
  {
	  WebElement menu;
   	  Actions builder= new Actions(dr);
      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  builder.moveToElement(menu).build().perform();
	  WebElement menuop1= dr.findElement(By.linkText("Class Wise Sibling"));
	  menuop1.click();
	  dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  dr.switchTo().frame(dr.findElement(By.id("Class Wise Sibling")));
  }
  public void selectClass(String s) throws InterruptedException
  {
	  Select c= new Select(dr.findElement(cls));
	  c.selectByVisibleText(s);
	  Thread.sleep(2000);
  }
  public void selectSection(String s)
  {
	  Select sec= new Select(dr.findElement(section));
	  sec.selectByVisibleText(s);
  }
  public void clickShow() throws InterruptedException
  {
	  String exp="SIBLING REPORT CLASSWISE";
	   	Utility u= new Utility(); 
	   	dr.findElement(show).click();
	   	Thread.sleep(2000);
	   	u.verifyPage(dr,exp);
  }
}
