package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpeningDuesReport {
WebDriver dr;
  By school= By.id("ContentPlaceHolder1_ddlSchool");
  By cls= By.id("ContentPlaceHolder1_ddlStandard");
  By section=By.id("ContentPlaceHolder1_ddlSection");
  By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
  By installment= By.id("ContentPlaceHolder1_ddlInstallment");
  By user= By.id("ContentPlaceHolder1_ddlUser");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
  
  public OpeningDuesReport(WebDriver d)
  {
	  this.dr=d;
  }
	public void openOpeningDuesReport()
	{
		 WebElement menu;
	  	  Actions builder= new Actions(dr);
	  	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	  	  dr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Opening Dues Report"));
		  menuop1.click();
		  dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  dr.switchTo().frame(dr.findElement(By.id("Opening Dues Report")));
	}
	public void selectSchool(String s)
	{
		Select sch= new Select(dr.findElement(school));
		sch.selectByVisibleText(s);
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
	public void selectFeeType(String s)
	{
		Select ftype= new Select(dr.findElement(feetype));
		ftype.selectByVisibleText(s);
	}
	public void selectInstallment(String s)
	{
		Select inst= new Select(dr.findElement(installment));
		inst.selectByVisibleText(s);
	}
	public void selectUser(String s)
	{
		Select u= new Select(dr.findElement(user));
		u.selectByVisibleText(s);
	}
	public void clickShow() throws InterruptedException
	{
		String exp= "OPENING DUES REPORT";
		 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
		 u.verifyPage(dr,exp);
	}
}
