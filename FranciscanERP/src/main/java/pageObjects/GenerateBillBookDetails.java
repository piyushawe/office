package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenerateBillBookDetails {
   WebDriver dr;
     By school= By.id("ContentPlaceHolder1_ddlSchool");
     By installment= By.id("ContentPlaceHolder1_ddlInstallment");
     By search= By.id("ContentPlaceHolder1_txtSearch");
     By selectfeetype= By.id("ContentPlaceHolder1_ddlfeetype");
     By show= By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
     public GenerateBillBookDetails(WebDriver d)
     {
    	 this.dr=d;
     }
     public void openGenerateBillBookDetails() throws InterruptedException
     {
    	WebElement menu;
 	    Actions builder= new Actions(dr);
 	    Thread.sleep(1000);
 	    menu=dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
 	    builder.moveToElement(menu).build().perform();
 	    Thread.sleep(500);
 	    dr.findElement(By.linkText("Generate Bill Book Details")).click();
 	    dr.switchTo().frame(dr.findElement(By.id("Generate Bill Book Details")));
     }
     public void selectSchool(String sch) throws InterruptedException
     {
    	 new Select(dr.findElement(school)).selectByVisibleText(sch);
    	 Thread.sleep(2000);
     }
     public void selectClass(String c)
     {
    	 dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[2]/div/button")).click();
    	 dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
    	 WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
 	     List<WebElement> options = select.findElements(By.tagName("span"));
 	  	 for(WebElement option:options)
 	  		if(c.equals(option.getText()))
 	  			option.click();
         dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
     }
     public void selectInstallment(String inst)
     {
    	 new Select(dr.findElement(installment)).selectByVisibleText(inst);
     }
     public void enterSearchText(String txt) throws InterruptedException
     {
    	 dr.findElement(search).sendKeys(txt);
    	 Thread.sleep(500);
    	 dr.findElement(search).sendKeys(Keys.ARROW_DOWN);
    	 Thread.sleep(500);
    	 dr.findElement(search).sendKeys(Keys.ENTER);
     }
     public void selectFeeType(String ftype)
     {
    	 new Select(dr.findElement(selectfeetype)).selectByVisibleText(ftype);
     }
     public void clickShow()
     {
    	 dr.findElement(show).click();
     }
}
