package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PrintTransportIDCard {
	WebDriver dr;
	By school= By.id("ContentPlaceHolder1_ddlSchool");
	By cls= By.id("ContentPlaceHolder1_ddlStandard");
	By section= By.id("ContentPlaceHolder1_ddlSection");
	By student= By.id("ContentPlaceHolder1_txtName");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btn_print\"]/input");
	
	public PrintTransportIDCard(WebDriver d)
    {
	    this.dr=d;
    }
    public void openPrintTransportIDCard() throws InterruptedException
    {
       WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
      //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Thread.sleep(5000);
      Actions builder= new Actions(dr);
   	  builder.moveToElement(menu).build().perform();
      WebElement submenu= dr.findElement(By.linkText("Transport Report"));
   	  builder.moveToElement(submenu).build().perform();
   	  //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      dr.findElement(By.linkText("Print TransportId Card")).click();
      dr.switchTo().frame(dr.findElement(By.id("Print TransportId Card")));
    }
    public void selectSchool(String s)
    {
    	new Select(dr.findElement(school)).selectByVisibleText(s);
    }
    public void selectClass(String c)
    {
    	new Select(dr.findElement(cls)).selectByVisibleText(c);
    }
    public void selectSection(String sec)
    {
    	 new Select(dr.findElement(section)).selectByVisibleText(sec);
    }
    public void enterStudent(String stu)
    {
    	dr.findElement(student).sendKeys(stu);
    }
    public void clickShow() throws InterruptedException
    {
        dr.findElement(show).click();
    }
}
