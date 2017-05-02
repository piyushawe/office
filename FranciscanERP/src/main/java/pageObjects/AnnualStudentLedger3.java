package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AnnualStudentLedger3 {
	WebDriver dr;
	//By installment= By.id("ContentPlaceHolder1_lstInstallment");
	By cls= By.id("ContentPlaceHolder1_ddlStanard");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
    
    public AnnualStudentLedger3(WebDriver d)
    {
	    this.dr=d;
    }
//open annual student ledger3    
    public void openAnnualStudentLedger3() throws InterruptedException
    {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
      //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Thread.sleep(5000);
      Actions builder= new Actions(dr);
   	  builder.moveToElement(menu).build().perform();
   	  WebElement submenu= dr.findElement(By.linkText("Ledger Reports"));
   	  builder.moveToElement(submenu).build().perform();
   	  //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      dr.findElement(By.linkText("Annual Student Ledger 3")).click();
      dr.switchTo().frame(dr.findElement(By.id("Annual Student Ledger 3")));
    }
//select installment    
    public void selectInstallment(String inst)
    {
    	//new Select(dr.findElement(installment)).selectByVisibleText(inst);
    	dr.findElement(By.xpath("//button[@type='button']")).click();
		dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
		WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
        dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
    }
//select class    
    public void selectClass(String c)
    {
       new Select(dr.findElement(cls)).selectByVisibleText(c);
    }
//select section
    public void selectSection(String sec)
    {
    	 new Select(dr.findElement(section)).selectByVisibleText(sec);
    }
//show    
    public void clickShow() throws InterruptedException
    {
    	String exp="STUDENT LEDGER YEARLY";
    	Utility u= new Utility(); 
    	dr.findElement(show).click();
    	Thread.sleep(2000);
    	u.verifyPage(dr,exp);
    }
}
	