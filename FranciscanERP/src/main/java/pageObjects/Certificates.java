package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Certificates {
  WebDriver dr;
    By cls= By.id("ContentPlaceHolder1_ddlClass");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    By text= By.id("ContentPlaceHolder1_txtSearchBox");
    By search= By.id("ContentPlaceHolder1_btnSearch");
    By show= By.name("ctl00$ContentPlaceHolder1$rptStudentList$ctl00$btnSelect");
    By print= By.id("ContentPlaceHolder1_ddlCertitype");
    
    public Certificates(WebDriver d)
    {
    	this.dr=d;
    }
    public void openCertificates()
    {
    	WebElement menu;
	    Actions builder= new Actions(dr);
	    menu=dr.findElement(By.xpath("//img[@src='/Images/layout/Certificate.png']"));
		builder.moveToElement(menu).build().perform();
		WebElement menuop1= dr.findElement(By.linkText("Certificates"));
		menuop1.click();
		dr.switchTo().frame(dr.findElement(By.id("Certificates")));
    }
    public void selectClass(String c) throws InterruptedException
    {
    	new Select(dr.findElement(cls)).selectByVisibleText(c);
    	Thread.sleep(2000);
    }
    public void selectSection(String sec)
    {
    	new Select(dr.findElement(section)).selectByVisibleText(sec);
    }
    public void searchStudent(String stu) throws InterruptedException
    {
    	dr.findElement(text).sendKeys(stu);
    	dr.findElement(search).click();
    	Thread.sleep(2000);
    }
    public void selectPrintCertificate(String prt)
    {
    	new Select(dr.findElement(print)).selectByVisibleText(prt);
    }
    public void verifyPrintCertificates() throws InterruptedException
    {
      List<WebElement>options= new Select(dr.findElement(print)).getOptions();
      int size= options.size();
      System.out.println("Total No. of options:"+size);
      for(int i=0; i<size;i++)
      {
    	  new Select(dr.findElement(print)).selectByIndex(i);
    	  clickShow();
    	  System.out.println(i);
    	  Thread.sleep(4000);	 
    	  if(i==6)
    		dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();    	
    	  else
    	    dr.findElement(By.xpath("//img[@src='../Images/cross_circle.png']")).click();
      }
    }
    public void clickShow()
    {
     	dr.findElement(show).click();
    }
}

