package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelfTransportReport {
WebDriver dr;
    By transport= By.id("ContentPlaceHolder1_ddltransport");
    By cls= By.id("ContentPlaceHolder1_ddlClass");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    By all= By.id("ContentPlaceHolder1_rdbOption_0");
    By active= By.id("ContentPlaceHolder1_rdbOption_1");
    By inactive= By.id("ContentPlaceHolder1_rdbOption_2");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
    
    public SelfTransportReport(WebDriver d)
    {
	   this.dr=d;
    }
    public void openSelfTransportReport() throws InterruptedException
      {
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	     //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     Thread.sleep(6000);
	     Actions builder= new Actions(dr);
    	 builder.moveToElement(menu).build().perform();
	     WebElement submenu= dr.findElement(By.linkText("Transport Report"));
	     builder.moveToElement(submenu).build().perform();
	     //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     dr.findElement(By.linkText("Self Transport Report")).click();
	     dr.switchTo().frame(dr.findElement(By.id("Self Transport Report")));
      }
    public void selectTransport(String t)
    {
    	Select tr= new Select(dr.findElement(transport));
    	tr.selectByVisibleText(t);
    }
    public void selectClass(String c) throws InterruptedException
    {
    	Select cs= new Select(dr.findElement(cls));
    	cs.selectByVisibleText(c);
    	Thread.sleep(3000);
    }
    public void selectSection(String s)
    {
    	Select sec= new Select(dr.findElement(section));
    	sec.selectByVisibleText(s);
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
    public void clickShow() throws InterruptedException
    {
    	String exp= "TRANSPORT REPORT";
		 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
		 u.verifyPage(dr,exp);
    }
}
