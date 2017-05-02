package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentLedgerClassWise {
	WebDriver dr;
	By school= By.id("ContentPlaceHolder1_ddlSchool");
	By cls= By.id("ContentPlaceHolder1_ddlStandard");
	By section= By.id("ContentPlaceHolder1_ddlSection");
	By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	//By installment= By.id("ContentPlaceHolder1_lstInstallment");
	By onlyfullyearpaidfees= By.id("ContentPlaceHolder1_chkFull");
	By withfine= By.id("ContentPlaceHolder1_ChkIsFine");
	By tilldate= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	
	public StudentLedgerClassWise(WebDriver d)
    {
	    this.dr=d;
    }
    public void openStudentLedgerClassWise() throws InterruptedException
    {
       WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
      //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Thread.sleep(5000);
      Actions builder= new Actions(dr);
   	  builder.moveToElement(menu).build().perform();
      WebElement submenu= dr.findElement(By.linkText("Ledger Reports"));
   	  builder.moveToElement(submenu).build().perform();
   	  //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      dr.findElement(By.linkText("Student Ledger Class Wise")).click();
      dr.switchTo().frame(dr.findElement(By.id("Student Ledger Class Wise")));
    }
    public void selectSchool(String sch)
    {
    	new Select(dr.findElement(school)).selectByVisibleText(sch);
    }
    public void selectClass(String c)
    {
    	new Select(dr.findElement(cls)).selectByVisibleText(c);
    }
    public void selectSection(String sec)
    {
    	new Select(dr.findElement(section)).selectByVisibleText(sec);
    }
    public void selectFeeType(String ftype)
    {
    	new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
    }
    public void selectInstallment(String inst)
    {
    	//new Select(dr.findElement(installment)).selectByVisibleText(inst);
    	dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(5) > div > button")).click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
    	WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
    }
    public void clickOnlyFullYearPaidFees()
    {
    	dr.findElement(onlyfullyearpaidfees).click();
    }
    public void clickWithFine()
    {
    	dr.findElement(withfine).click();
    }
    public void selectTilldate(String mm,String yy, String dd) throws InterruptedException
    {
    	dr.findElement(tilldate).click();
    	Thread.sleep(1000);
    	new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
        Thread.sleep(500);
        new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
    	  Thread.sleep(500);
    	  WebElement myw=dr.findElement(By.className("datepick"));
         // List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
    	  // for (WebElement row: rows){  
    	    List<WebElement> cells=myw.findElements(By.tagName("td"));
    		  for(WebElement cell: cells) {
    			if (cell.getText().equals(dd)){  
    			cell.click();
    			break; 
    		 }  
    	 //   }
      }Thread.sleep(500);
    }
    public void clickShow() throws InterruptedException
    {
       String exp= "STUDENT LEDGER CLASS WISE ";
   	   Utility u= new Utility(); 
       dr.findElement(show).click();
       Thread.sleep(2000);
       u.verifyPage(dr,exp);
    }
}
