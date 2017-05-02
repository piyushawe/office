package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


public class CancelFeeReceipt {
 WebDriver dr;
	 By feereceiptno= By.id("ContentPlaceHolder1_rdoSearch_0");
	 By studentdetails= By.id("ContentPlaceHolder1_rdoSearch_1");
	 By chequeno= By.id("ContentPlaceHolder1_rdoSearch_2");
	 By ddno= By.id("ContentPlaceHolder1_rdoSearch_3");
	 By cls= By.id("ContentPlaceHolder1_ddlClass");
	 By section= By.id("ContentPlaceHolder1_ddlSection");
	 By text=By.id("ContentPlaceHolder1_txtName");
	 By canceldate= By.id("ctl00$ContentPlaceHolder1$txtCancelDate$TextBox");
	 By go= By.name("ctl00$ContentPlaceHolder1$btngetdetails$ctl00");
	 By cancel= By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
	 By cancel_reason= By.id("ContentPlaceHolder1_txtReason_TextBox");
    
	 public CancelFeeReceipt(WebDriver drv)
	   {
		  this.dr=drv;
	   }
//open cancel fee receipt	 
	  public void openCancelFeeReceipt() throws InterruptedException
	   {
	     WebElement menu;
	     Actions builder= new Actions(dr);
	     menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
	     Thread.sleep(1000);
		 builder.moveToElement(menu).build().perform();
		 WebElement menuop1= dr.findElement(By.linkText("Cancel Fee Receipt"));
		 menuop1.click();
	     dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.switchTo().frame(dr.findElement(By.id("Cancel Fee Receipt")));
	    } 
//by receipt no	    
	   public void searchReceiptByReceiptNo(String str)
	   {
	      dr.findElement(feereceiptno).click();
	      dr.findElement(text).clear(); 
	      dr.findElement(text).sendKeys(str);
	      dr.findElement(go).click();
	   }
//by name	    
	    public void searchReceiptByName(String c, String s, String name )
	    {
	    	dr.findElement(studentdetails).click();
	    	Select clss=new Select(dr.findElement(cls));
			clss.selectByVisibleText(c);
		    Select sec= new Select(dr.findElement(section));
		    sec.selectByVisibleText(s);
		    dr.findElement(text).clear(); 
	    	dr.findElement(text).sendKeys(name);
	    	dr.findElement(go).click();
	    }
//by cheque no	    
	    public void searchReceiptByChequeNo(String str)
	    {
	    	dr.findElement(chequeno).click();
	    	dr.findElement(text).clear(); 
	    	dr.findElement(text).sendKeys(str);
	    	dr.findElement(go).click();
	    }
//cancel	    
	    public void pageRefresh()
	    {
	    	dr.findElement(cancel).click();
	    }
//reason	    
	    public void giveReasonToCancel(String s)
	    {
	    	dr.findElement(cancel_reason).sendKeys(s);	    		    	
	    }
//date	    
	    public void selectDate(String mm, String yy, String dd)throws Exception
	    {
	  	  dr.findElement(canceldate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(1000);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(1000);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			cell.click();
	  			break; 
	  		 }  
	    }Thread.sleep(1000);
        }
//cancel receipt	    
	    public void cancelReceipt(String receiptno)
	    {
	    	WebElement receiptrecords=dr.findElement(By.xpath("//table[@id='example']"));	
			   List<WebElement> allcols=receiptrecords.findElements(By.tagName("td"));
		       for(WebElement cell:allcols) {
	        	  if(cell.getText().equals(receiptno)){
	        	     System.out.println(cell.getText());   	
	             		dr.findElement(By.name("ctl00$ContentPlaceHolder1$rptReceipt$ctl00$btn")).click();
	             		 break;  
	         	  }
		        }
		     dr.findElement(By.id("popup_ok")).click();  
		     System.out.println("Receipt No."+receiptno+" is cancelled");
	    }
//cheque bounce	    
	    public void bounceCheque(String receiptno)
	    {
	    	WebElement receiptrecords=dr.findElement(By.xpath("//table[@id='example']"));	
			   List<WebElement> allcols=receiptrecords.findElements(By.tagName("td"));
		       for (WebElement cell:allcols) {
	        	  if(cell.getText().equals(receiptno)){
	        	     System.out.println(cell.getText());   	
	             		dr.findElement(By.name("ctl00$ContentPlaceHolder1$rptReceipt$ctl00$Button1")).click();
	             		 break;  
	         	  }
		       }
		     dr.findElement(By.id("popup_ok")).click();  
		     dr.findElement(By.name("ctl00$ContentPlaceHolder1$btncancel$ctl00")).click();
		     System.out.println("Cheque of Receipt No."+receiptno+" is bounced");
	    }
    }
