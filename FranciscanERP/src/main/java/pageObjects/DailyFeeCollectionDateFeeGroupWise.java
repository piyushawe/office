package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DailyFeeCollectionDateFeeGroupWise {
	WebDriver dr;
	By school= By.id("ContentPlaceHolder1_ddlSchoolSubHead");
	By cls= By.id("ContentPlaceHolder1_ddlStandard");
	By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	By feehead= By.id("ContentPlaceHolder1_ddlFeeHeadToshown");
	By feegroup= By.id("ContentPlaceHolder1_LstFeeGroup");
	By paymode= By.id("ContentPlaceHolder1_lstPayMode");
	By datefrom= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
	By dateto= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
	By fulldetails= By.id("ContentPlaceHolder1_RbtnReportType_0");
	By summary= By.id("ContentPlaceHolder1_RbtnReportType_1");
	By separated= By.id("ContentPlaceHolder1_RbtnReportType_2");
	By user= By.id("ContentPlaceHolder1_ddlUser");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	
	 public DailyFeeCollectionDateFeeGroupWise(WebDriver d)
     {
   	  this.dr=d;
     }
     public void openDailyFeeCollectionDateFeeGroupWise() throws InterruptedException
     {
   	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Collection"));
		 builder.moveToElement(submenu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		 dr.findElement(By.linkText("Daily Fee Collection Date/Fee Group Wise")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Daily Fee Collection Date/Fee Group Wise ")));
     }
     public void selectEntryMode(String emode)
     {
    	 dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[1]/div/div/button")).click();
 		 dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/a")).click();
 	     WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
 		 List<WebElement> options = select.findElements(By.tagName("span"));
 	  	 for(WebElement option:options)
 	  		if(emode.equals(option.getText()))
 	  			option.click();
         dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[3]")).click();
     }
     public void selectSchool(String sch)
     {
    	 new Select(dr.findElement(school)).selectByVisibleText(sch);
     }
     public void selectClass(String c)
     {
    	 new Select(dr.findElement(cls)).selectByVisibleText(c);
     }
     public void selectFeeType(String ftype)
     {
    	 new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
     }
     public void selectFeeHead(String fhead)
     {
    	 new Select(dr.findElement(feehead)).selectByVisibleText(fhead);
     }
     public void selectFeeGroup(String fgroup)
     {
    	 new Select(dr.findElement(feegroup)).selectByVisibleText(fgroup);
     }
     public void selectPayMode(String pmode1, String pmode2)
     {
    	 dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[7]/div/button")).click();
 		 dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[2]/a")).click();
 	     WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
 		 List<WebElement> options = select.findElements(By.tagName("span"));
 	  	 for(WebElement option:options)
 	  		if(pmode1.equals(option.getText())||pmode2.equals(option.getText()))
 	  			option.click();
         dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[3]")).click();
     }
     public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
     {
    	 dr.findElement(datefrom).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	       //List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  		//for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	  	  //}
	    }Thread.sleep(500);
     }
     public void selectToDate(String mm, String yy, String dd) throws InterruptedException
     {
    	 dr.findElement(dateto).click();
	  	  Thread.sleep(500);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	      //  List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  	  // for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	  	//}
	    }Thread.sleep(500);
     }
     public void clickFullDetails()
     {
    	 if(dr.findElement(fulldetails).isSelected()) {
    		 
    	 }else
    	 dr.findElement(fulldetails).click();
     }
     public void clickSummary()
     {
    	 if( dr.findElement(summary).isSelected()) {
    		 
    	 }else
    	 dr.findElement(summary).click();
     }
     public void clickSeparated()
     {
    	 if(dr.findElement(separated).isSelected()) {
    		 
    	 }else
    	 dr.findElement(separated).click();
     }
     public void selectUser(String u)
     {
    	new Select(dr.findElement(user)).selectByVisibleText(u);
     }
     public void clickShow() throws InterruptedException
     {
    	 String exp="DAILY FEE COLLECTION RANGE";
 	   	Utility u= new Utility(); 
 	   	dr.findElement(show).click();
 	   	Thread.sleep(2000);
 	   	u.verifyPage(dr,exp);
     }
}
