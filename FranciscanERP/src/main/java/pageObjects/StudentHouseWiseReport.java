package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentHouseWiseReport {
WebDriver dr;
  By cls= By.id("ContentPlaceHolder1_ddlClass");
  By sectionwise= By.id("ContentPlaceHolder1_CheckBox1");
  By section= By.id("ContentPlaceHolder1_ddlSection");
  By house= By.id("ContentPlaceHolder1_ddlHouse");
  By all= By.id("ContentPlaceHolder1_rdbOption_0");
  By active= By.id("ContentPlaceHolder1_rdbOption_1");
  By inactive= By.id("ContentPlaceHolder1_rdbOption_2");
  By range= By.id("ContentPlaceHolder1_ddlRange");
  By age= By.id("ContentPlaceHolder1_ddlFromAge");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton2\"]/input");

public StudentHouseWiseReport(WebDriver drv)
{
	  this.dr=drv;
}
 public void openStudentHouseWiseReport()
 {
      WebElement menu;
	  Actions builder= new Actions(dr);
	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  builder.moveToElement(menu).build().perform();
	  WebElement menuop1= dr.findElement(By.linkText("Student House Wise Report"));
	  menuop1.click();
	  dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  dr.switchTo().frame(dr.findElement(By.id("Student House Wise Report")));
 } 
 public void selectClass(String c)
 {
	 Select cs= new Select(dr.findElement(cls));
	 cs.selectByVisibleText(c);
 }
 public void clickSectionWise() throws InterruptedException
 {
	 dr.findElement(sectionwise).click();
	 Thread.sleep(1000);
 }
 public void selectSection(String s)
 {
	 Select sec= new Select(dr.findElement(section));
	 sec.selectByVisibleText(s);
 }
 public void selectHouse(String h)
 {
	 Select hs= new Select(dr.findElement(house));
	 hs.selectByVisibleText(h);
 }
 public void clickAll()
 {
	 dr.findElement(all).click();
 }
 public void clickActive()
 {
	 dr.findElement(active).click();
 }
 public void clickInActive()
 {
	 dr.findElement(inactive).click();
 }
 public void rangeType(String r)
 {
	 Select rg= new Select(dr.findElement(range));
	 rg.selectByVisibleText(r);
 }
 public void selectAge(String a)
 {
	 Select ag= new Select(dr.findElement(age));
	 ag.selectByVisibleText(a);
 }
 public void clickShow() throws InterruptedException
 {
	 String exp= "STUDENT HOUSE WISE REPORT";
	 Utility u= new Utility(); 
     dr.findElement(show).click();
     Thread.sleep(2000);
	 u.verifyPage(dr,exp);
 }
}
