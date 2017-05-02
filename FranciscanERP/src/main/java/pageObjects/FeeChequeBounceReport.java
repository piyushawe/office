package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FeeChequeBounceReport {
	 WebDriver dr;
	
	 By selectschool= By.id("ContentPlaceHolder1_ddlSchool");
	 By datefrom= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
	 By dateto= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
	 By cls= By.id("ContentPlaceHolder1_ddlStanard");
	 By section= By.id("ContentPlaceHolder1_ddlSection");
	 By bankname= By.id("ContentPlaceHolder1_DDlDepBank");
	 By selectuser= By.id("ContentPlaceHolder1_ddlUser");
	 By selectreportfilter= By.id("ContentPlaceHolder1_ddl_reportsrch");
	 By show= By.name("ctl00$ContentPlaceHolder1$btnShow$ctl00");
	 String exp= "FEES CHEQUE/DD BOUNCE REPORT";
	 public FeeChequeBounceReport(WebDriver d)
	 {
		 this.dr=d;
	 }
	 
	 public void openFeeChequeBounceReport()
	 {
		  WebElement menu;
	      Actions builder= new Actions(dr);
	      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Fees Cheque Bounce Report"));
		  menuop1.click();
		  dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  dr.switchTo().frame(dr.findElement(By.id("Fees Cheque Bounce Report")));
	 }
	 public void selectSchool(String s)
	 {
		 Select sch= new Select(dr.findElement(selectschool));
		 sch.selectByVisibleText(s);
	 }
     public void selectClass(String s)
     {
    	 Select c= new Select(dr.findElement(cls));
		 c.selectByVisibleText(s);
     }
     public void selectSection(String s)
     {
    	 Select sec= new Select(dr.findElement(section));
		 sec.selectByVisibleText(s);
     }
     public void selectBankName(String s)
     {
    	 Select bank= new Select(dr.findElement(bankname));
		 bank.selectByVisibleText(s);
     }
     public void selectUser(String s)
     {
    	 Select u= new Select(dr.findElement(selectuser));
    	 u.selectByVisibleText(s);
     }
     public void selectDateFrom(String mm, String yy, String dd) throws InterruptedException
     {
    	 dr.findElement(datefrom).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	     //   List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  		//for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	  	 //   }
	    }Thread.sleep(500);
     }
     public void selectDateTo(String mm, String yy, String dd) throws InterruptedException
     {
    	 dr.findElement(dateto).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	      //  List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  	//	for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	  //	    }
	    }Thread.sleep(1000);
     }
     public void clickShow() throws InterruptedException
     {
    	 String exp= "FEES CHEQUE/DD BOUNCE REPORT";
       	 Utility u= new Utility(); 
        	 dr.findElement(show).click();
        	 Thread.sleep(2000);
        	 u.verifyPage(dr,exp);
     }
}
