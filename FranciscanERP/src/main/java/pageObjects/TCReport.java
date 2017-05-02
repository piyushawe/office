package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TCReport {
  WebDriver dr;
    By fromdate= By.id("ContentPlaceHolder1_txtfromDate_TextBox");
    By todate= By.id("ContentPlaceHolder1_txttoDate_TextBox");
    By tctype= By.id("ContentPlaceHolder1_ddltc");
    By orderby= By.id("ContentPlaceHolder1_ddlorderby");
    By show= By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
    
    public TCReport(WebDriver d)
    {
    	this.dr=d;
    }
    public void openTCReport()
    {
    	WebElement menu;
	    Actions builder= new Actions(dr);
	    menu=dr.findElement(By.xpath("//img[@src='/Images/layout/Certificate.png']"));
		builder.moveToElement(menu).build().perform();
		WebElement menuop1= dr.findElement(By.linkText("TC Report"));
		menuop1.click();
		dr.switchTo().frame(dr.findElement(By.id("TC Report")));
    }
    public void selectfromDate(String mm, String yy, String dd)throws Exception
    {
    	dr.findElement(fromdate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(200);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(200);
	  	  WebElement myw=dr.findElement(By.className("datepick"));      
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  	  			
	  			cell.click();
	  			break; 
	  		 }    	
	    }Thread.sleep(200); 
    }
    public void selectToDate(String mm, String yy, String dd)throws Exception
    {
    	dr.findElement(todate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(200);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(200);
	  	  WebElement myw=dr.findElement(By.className("datepick"));      
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  	  			
	  			cell.click();
	  			break; 
	  		 }    	
	    }Thread.sleep(200); 
    }
    public void selectTcType(String type)
    {
    	new Select(dr.findElement(tctype)).selectByVisibleText(type);
    }
    public void selectOrderBy(String order)
    {
    	new Select(dr.findElement(orderby)).selectByVisibleText(order);
    }
    public void clickShow() throws InterruptedException
    {
    	String exp= "STUDENT TC REPORT";
    	Utility u= new Utility(); 
    	dr.findElement(show).click();
    	Thread.sleep(2000);
   	    u.verifyPage(dr,exp);
    }
}
