package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReconcileInstallmentClassWise {
	WebDriver dr;
	By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	//By cls= By.id("ContentPlaceHolder1_lstClass");
	//By installment= By.id("ContentPlaceHolder1_ddlInstallment");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	
	public ReconcileInstallmentClassWise(WebDriver d)
    {
	    this.dr=d;
    }
    public void openReconcileInstallmentClassWise() throws InterruptedException
    {
    	 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
         //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         Thread.sleep(5000);
         Actions builder= new Actions(dr);
      	 builder.moveToElement(menu).build().perform();
      	 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         dr.findElement(By.linkText("Reconcile Installment Class Wise")).click();
         dr.switchTo().frame(dr.findElement(By.id("Reconcile Installment Class Wise")));
    }
    public void selectFeeType(String ftype)
    {
    	new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
    }
    public void selectClass(String c)
    {
    	//new Select(dr.findElement(cls)).selectByVisibleText(c);
    	dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(2) > div > button")).click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
    	WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
    }
    public void selectInstallment(String inst)
    {
    	//new Select(dr.findElement(installment)).selectByVisibleText(inst);
    	dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(3) > div > button")).click();
    	dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
    	WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
    	dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li.ui-multiselect-close")).click();
    }
    public void clickShow() throws InterruptedException
    {
    	String exp= "RECONCILE INSTALLMENT CLASSWISE";
		 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
		 u.verifyPage(dr,exp);
    }
}
