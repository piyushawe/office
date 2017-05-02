package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StaffWardListReport {
WebDriver dr;	
    By cls= By.id("ContentPlaceHolder1_ddlClass");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    By staffward= By.id("ContentPlaceHolder1_ddlStaffWard");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
    
	public StaffWardListReport(WebDriver d)
	{
		this.dr=d;
	}
	public void openDateWiseAdmissionReport()
	  {
		  WebElement menu;
	  	  Actions builder= new Actions(dr);
	  	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  	  dr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Staff Ward List Report"));
		  menuop1.click();
		  dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  dr.switchTo().frame(dr.findElement(By.id("Staff Ward List Report")));
	  }
	public void selectClass(String c)
	{
		Select cl= new Select(dr.findElement(cls));
		cl.selectByVisibleText(c);
	}
	public void selectSection(String s)
	{
		Select sec= new Select(dr.findElement(section));
		sec.selectByVisibleText(s);
	}
	public void selectStaffWard(String w)
	{
		Select ward= new Select(dr.findElement(staffward));
		ward.selectByVisibleText(w);
	}
	public void clickShow() throws InterruptedException
	{
		  String exp= "STAFF WARD LIST REPORT";
		  Utility u= new Utility(); 
	      dr.findElement(show).click();
	      Thread.sleep(2000);
		  u.verifyPage(dr,exp);
	}
}
