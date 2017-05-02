package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SetDueLimit {
  WebDriver dr;
    By cls= By.id("ContentPlaceHolder1_ddlClass");
    By feetype= By.id("ContentPlaceHolder1_ddlFeetype");
    By yes= By.id("ContentPlaceHolder1_rdoyes");
    By no= By.id("ContentPlaceHolder1_rdono");
    By duesamount= By.id("ContentPlaceHolder1_txtDueAmount_TextBox");
    By percent= By.id("ContentPlaceHolder1_chkisperc");
    By feehead= By.id("ContentPlaceHolder1_ddlheadid");
    By save= By.name("ctl00$ContentPlaceHolder1$btnDueLimit$btnSave");
    By cancel= By.name("ctl00$ContentPlaceHolder1$btnDueLimit$ctl01");
    By view= By.id("ContentPlaceHolder1_btnDueLimit_btnView");
    
    public SetDueLimit(WebDriver d)
    {
    	this.dr=d;
    }
    public void openSetDueLimit()
    {
    	WebElement menu;
    	Actions builder= new Actions(dr);
    	menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
    	builder.moveToElement(menu).build().perform();
    	dr.findElement(By.linkText("Set Due Limit")).click();
    	dr.switchTo().frame(dr.findElement(By.id("Set Due Limit")));
    }
    public void selectClass(String c)
    {
    	new Select(dr.findElement(cls)).selectByVisibleText(c);
    }
    public void selectFeeType(String ftype)
    {
    	new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
    }
    public void clickYes()
    {
    	dr.findElement(yes).click();
    }
    public void clickNo()
    {
    	dr.findElement(no).click();
    }
    public void enterDuesAmount(String amt) throws InterruptedException
    {
    	dr.findElement(duesamount).clear();
    	dr.findElement(duesamount).sendKeys(amt);
    	Thread.sleep(200);
    	dr.findElement(duesamount).sendKeys(Keys.ENTER);
    }
    public void clickPercent() throws InterruptedException
    {  
    	Thread.sleep(500);
    	dr.findElement(percent).click();
    }
    public void selectFeeHead(String fHead)
    {
    	new Select(dr.findElement(feehead)).selectByVisibleText(fHead);
    }
    public void clickView()
    {
    	dr.findElement(view).click();
    }
    public void clickSave()
    {
    	dr.findElement(save).click();
    }
    public void clickCancel()
    {
    	dr.findElement(cancel).click();
    }
    public void deleteAllRecords() throws InterruptedException
    {
    	WebElement records= dr.findElement(By.id("example"));
    	List<WebElement>cells= records.findElements(By.tagName("td"));
    	int size=cells.size();
    	if(size>1) {
    	for(WebElement cell:cells)
    	{   
    		size= cells.size();
    	    if(size>1) {
    		dr.findElement(By.name("ctl00$ContentPlaceHolder1$rptDuesLimit$ctl00$btn")).click();
    		Thread.sleep(500);
    		dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnDueLimit$btnDelete")).click();
    		dr.findElement(By.id("popup_ok")).click();
    		clickView();
    		records= dr.findElement(By.id("example"));
    		cells= records.findElements(By.tagName("td"));
    	}
    	}System.out.println("All settings deleted");
    	}
    	else
    		System.out.println("No data available");
      }
   	
}
