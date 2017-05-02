package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClassWiseMarkList {
  WebDriver dr;
     By cls= By.id("ContentPlaceHolder1_ddlclass");
     By section= By.id("ContentPlaceHolder1_ddlsection");
     By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
     
     public ClassWiseMarkList(WebDriver d)
     {
    	 this.dr=d;
     }
     public void openClassWiseMarkList() throws InterruptedException
     {
    	 WebElement menu;
         Actions builder= new Actions(dr);
         menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
         Thread.sleep(4000);
    	 builder.moveToElement(menu).build().perform();
    	 WebElement menuop1= dr.findElement(By.linkText("Class Wise Mark List"));
    	 menuop1.click();
    	 dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 dr.switchTo().frame(dr.findElement(By.id("Class Wise Mark List")));
     }
     public void selectClass(String c)
     {
    	 new Select(dr.findElement(cls)).selectByVisibleText(c);
     }
     public void selectSection(String sec)
     {
    	 new Select(dr.findElement(section)).selectByVisibleText(sec);
     }
     public void clickShow()
     {
    	 dr.findElement(show).click();
     }
}
