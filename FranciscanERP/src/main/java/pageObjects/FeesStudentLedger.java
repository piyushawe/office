package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sun.jna.platform.win32.Tlhelp32;

public class FeesStudentLedger {
	WebDriver dr;
	By cls= By.id("ContentPlaceHolder1_ddlClass");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    By searchstudent= By.id("ContentPlaceHolder1_txtName");
    By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
    By tilldate= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
    By withouthead= By.id("ContentPlaceHolder1_RbtmHead_0");
    By withhead= By.id("ContentPlaceHolder1_RbtmHead_1");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
    
    public FeesStudentLedger(WebDriver d)
    {
	    this.dr=d;
    }
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
      dr.findElement(By.linkText("Fees Student Ledger")).click();
      dr.switchTo().frame(dr.findElement(By.id("Fees Student Ledger")));
    }
    public void selectClass(String c)
    {
       new Select(dr.findElement(cls)).selectByVisibleText(c);
    }
    public void selectSection(String sec)
    {
    	 new Select(dr.findElement(section)).selectByVisibleText(sec);
    }
    public void searchStudent(String stu) throws InterruptedException
    {
    	dr.findElement(searchstudent).sendKeys(stu);
    	Thread.sleep(500);
    	dr.findElement(searchstudent).sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	dr.findElement(searchstudent).sendKeys(Keys.ENTER);
    	Thread.sleep(500);
    }
    public void selectFeeType(String ftype)
    {
    	new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
    }
    public void selectTillDate(String mm, String yy, String dd) throws InterruptedException
    {
    	dr.findElement(tilldate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(1000);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(1000);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	        List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  		for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	  	    }
	    }Thread.sleep(1000);
    }
    public void clickWithoutHead()
    {
    	dr.findElement(withouthead).click();
    }
    public void clickWithHead()
    {
    	dr.findElement(withhead).click();
    }
    public void clickShow() throws InterruptedException
    {
    	String exp= "FEES STUDENT LEDGER";
 	    Utility u= new Utility(); 
        dr.findElement(show).click();
        Thread.sleep(2000);
 	    u.verifyPage(dr,exp);
    }
}
