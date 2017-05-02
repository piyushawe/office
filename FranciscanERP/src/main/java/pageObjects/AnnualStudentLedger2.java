package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AnnualStudentLedger2 {
	WebDriver dr;
	By cls= By.id("ContentPlaceHolder1_ddlClass");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    By searchstudent= By.id("ContentPlaceHolder1_txtName");
    By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
    
	public AnnualStudentLedger2(WebDriver d)
    {
	    this.dr=d;
    }
//open annual student ledger2	
    public void openAnnualStudentLedger2() throws InterruptedException
    {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
      //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Thread.sleep(5000);
      Actions builder= new Actions(dr);
   	  builder.moveToElement(menu).build().perform();
   	  WebElement submenu= dr.findElement(By.linkText("Ledger Reports"));
   	  builder.moveToElement(submenu).build().perform();
   	  //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      dr.findElement(By.linkText("Annual Student Ledger 2")).click();
      dr.switchTo().frame(dr.findElement(By.id("Annual Student Ledger 2")));
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
//enter student details    
    public void enterStudentDetails(String s) throws InterruptedException
    {
    	dr.findElement(searchstudent).sendKeys(s);
    	Thread.sleep(500);
    	dr.findElement(searchstudent).sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	dr.findElement(searchstudent).sendKeys(Keys.ENTER);
    	Thread.sleep(500);
    }
//fee type    
    public void selectFeeType(String ftype)
    {
    	new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
    }
//show    
    public void clickShow() throws InterruptedException
    {
    	String exp="FEE LEDGER";
    	Utility u= new Utility(); 
    	dr.findElement(show).click();
    	Thread.sleep(2000);
    	u.verifyPage(dr,exp);
    }
}
