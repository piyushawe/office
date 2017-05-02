package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssignedTransportReport {
WebDriver dr;	
  By cls= By.id("ContentPlaceHolder1_ddlClass");
  By section= By.id("ContentPlaceHolder1_ddlSection");
  //By month= By.id("ContentPlaceHolder1_ddlmonth");
  By search= By.id("ContentPlaceHolder1_txtSearch");
  By user= By.id("ContentPlaceHolder1_ddlUser");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
  
	public AssignedTransportReport(WebDriver d)
	{
		this.dr=d;
	}
//open assigned transport report	
	public void openAssignedTransportReport() throws InterruptedException
	  {
		WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Transport Report"));
		 builder.moveToElement(submenu).build().perform();
		 dr.findElement(By.linkText("Assigned Transport Report")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Assigned Transport Report")));
	  }
//class	
	public void selectClass(String c)
	{
		Select cs= new Select(dr.findElement(cls));
		cs.selectByVisibleText(c);
	}
//section	
	public void selectSection(String s)
	{
		Select sec= new Select(dr.findElement(section));
		sec.selectByVisibleText(s);
	}
//month	
	public void selectMonth(String m)
	{
	   //new Select(dr.findElement(month)).selectByVisibleText(m);
		dr.findElement(By.xpath("//button[@type='button']")).click();
		dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
		WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(m.equals(option.getText()))
	  			option.click();
        dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
	}
//search	
	public void enterSearchText(String text)
	{
		dr.findElement(search).sendKeys(text);
	}
//user	
	public void selectUser(String u)
	{
		Select us= new Select(dr.findElement(user));
		us.selectByVisibleText(u);
	}
//show	
	public void clickShow() throws InterruptedException
	{
		String exp="TRANSPORT DETAILS";
    	Utility u= new Utility(); 
    	dr.findElement(show).click();
    	Thread.sleep(2000);
    	u.verifyPage(dr,exp);
	}
}
