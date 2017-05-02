package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EstimatedTransportDetails {
  WebDriver dr;
   By school= By.id("ContentPlaceHolder1_ddlSchool");
   By route= By.id("ContentPlaceHolder1_DdlRoute");
   By vehicle= By.id("ContentPlaceHolder1_ddlvehicle");
   //By cls= By.id("ContentPlaceHolder1_lstClass");
   //By installment= By.id("ContentPlaceHolder1_lstInstallment");
   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
	
   public EstimatedTransportDetails(WebDriver d)
   {
	   this.dr=d;
   }
   public void openEstimatedTransportDetails() throws InterruptedException
	 {   
	   /*JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("document.body.style.zoom='90%'");	    */
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
		 builder.moveToElement(menu).build().perform();
		 Actions builder1= new Actions(dr);
		 //WebElement submenu= dr.findElement(By.linkText("Transport Report"));	
		 builder1.moveToElement(dr.findElement(By.xpath(".//*[@id='form2']/div[4]/div/ul/li[8]/ul/li[18]/a"))).build().perform();
		 //builder1.moveToElement(dr.findElement(By.linkText("Transport Report"))).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 builder1.moveToElement(dr.findElement(By.xpath(".//*[@id='form2']/div[4]/div/ul/li[8]/ul/li[18]/ul/li[6]/a"))).click().perform();
		 //Thread.sleep(1000);
		 //dr.findElement(By.xpath(".//*[@id='form2']/div[4]/div/ul/li[8]/ul/li[18]/ul/li[6]/a")).click();
			 //dr.findElement(By.linkText("Estimated Transport Details")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Estimated Transport Details")));
	 }
 public void selectSchool(String sch)
 {
	 new Select(dr.findElement(school)).selectByVisibleText(sch);
 }
 public void selectRoute(String r)
 {
	 new Select(dr.findElement(route)).selectByVisibleText(r);
 }
 public void selectVehicle(String v)
 {
	 new Select(dr.findElement(vehicle)).selectByVisibleText(v);
 }
 public void selectClass(String c)
 {
	 //new Select(dr.findElement(cls)).selectByVisibleText(c);
	    dr.findElement(By.xpath("//button[@type='button']")).click();
		dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
		WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
       dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
 }
 public void selectInstallment(String inst) throws InterruptedException
 {
	 //new Select(dr.findElement(installment)).selectByVisibleText(inst);
   	    dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[5]/div/button")).click();
   	    dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/a")).click();
   	    Thread.sleep(200);
   	    WebElement select= dr.findElement(By.cssSelector("body > div:nth-child(7) > ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
        dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[3]")).click();
 }
 public void clickShow() throws InterruptedException
 {
	 String exp= "ESTIMATED TRANSPORT DETAIL ";
   	 Utility u= new Utility(); 
    	 dr.findElement(show).click();
    	 Thread.sleep(2000);
    	 u.verifyPage(dr,exp);
 }
}
