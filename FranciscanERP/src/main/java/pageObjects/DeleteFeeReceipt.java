package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DeleteFeeReceipt {
  WebDriver dr;
    By feereceiptno= By.id("ContentPlaceHolder1_rdoSearch_0");
	By studentdetails= By.id("ContentPlaceHolder1_rdoSearch_1");
	By chequeno= By.id("ContentPlaceHolder1_rdoSearch_2");
	By ddno= By.id("ContentPlaceHolder1_rdoSearch_3");
	By cls= By.id("ContentPlaceHolder1_ddlClass");
	By section= By.id("ContentPlaceHolder1_ddlSection");
	By text= By.id("ContentPlaceHolder1_txtName");
	By go= By.name("ctl00$ContentPlaceHolder1$btngetdetails$ctl00");
	By delete_reason= By.name("ctl00$ContentPlaceHolder1$txtReason$TextBox");
	By search_cancel= By.id("ContentPlaceHolder1_chkCancel");
	By cancel= By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
	
	public DeleteFeeReceipt(WebDriver d)
	{
		this.dr=d;
	}
	public void openDeleteFeeReceipt()
	{
		 WebElement menu;
		 menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
		 dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement menuop1= dr.findElement(By.linkText("Delete Fee Receipt"));
		 menuop1.click();
		 dr.switchTo().frame(dr.findElement(By.id("Delete Fee Receipt")));
	}
	public void searchReceiptByReceiptNo(String s)
	{
		dr.findElement(feereceiptno).click();
		dr.findElement(text).sendKeys(s);
		dr.findElement(go).click();
	}
	 public void searchReceiptByName(String s1,String s2,String s3) throws InterruptedException
	    {
	    	dr.findElement(studentdetails).click();
	    	Select clss=new Select(dr.findElement(cls));
			clss.selectByVisibleText(s1);
			//dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Thread.sleep(1000);		
			Select sec= new Select(dr.findElement(section));
		    sec.selectByVisibleText(s2);
		    dr.findElement(text).sendKeys(s3);
	    	dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(200);
	    	dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(200);
	    	dr.findElement(text).sendKeys(Keys.ENTER);
	    	Thread.sleep(500);    
	    	//dr.findElement(go).click();
	    }
	 public void searchReceiptByChequeNo(String s)
	    {
	    	dr.findElement(chequeno).click();
	    	dr.findElement(text).sendKeys(s);
	    	dr.findElement(go).click();
	    }
	 public void pageRefresh()
	    {
	    	dr.findElement(cancel).click();
	    }
	 public void reasonToDeleteCheque(String s)
	    {
	    	dr.findElement(delete_reason).sendKeys(s);  	
	    }
	 public void searchCancelFeeReceipt() throws InterruptedException
	 {
		 dr.findElement(search_cancel).click();
		 dr.findElement(go).click();
		 Thread.sleep(500);
	 }
	 public void deleteAllFeeReceipt() throws InterruptedException
	 {
		 WebElement receiptrecords=dr.findElement(By.xpath("//table[@id='example']"));	
		   List<WebElement>allcols=receiptrecords.findElements(By.tagName("td"));
		   String rsn="Test";
		   if(allcols.size()>1) {
	       for(WebElement cell:allcols) {
	    	   if(allcols.size()>1) {
	    	    reasonToDeleteCheque(rsn);   	
         		dr.findElement(By.name("ctl00$ContentPlaceHolder1$rptReceipt$ctl00$Button1")).click();
         		Thread.sleep(2000);
         		dr.findElement(By.id("popup_ok")).click();			
         		dr.findElement(go).click();
         		Thread.sleep(2000);
         		receiptrecords=dr.findElement(By.xpath("//table[@id='example']"));
         		allcols=receiptrecords.findElements(By.tagName("td"));
	    	  }
	     }System.out.println("ALL RECEIPTS DELETED");
	   }else
			System.out.println("No receipt available ");
	   }
	 public void deleteReceipt(String receiptno) throws InterruptedException
	 {   boolean flag=false;
		 WebElement receiptrecords=dr.findElement(By.xpath("//table[@id='example']"));	
		 List<WebElement>rows= receiptrecords.findElements(By.tagName("tr"));
		 int r=1;
		 for(WebElement row:rows)
		 {
		 // if(row.getText().equals(receiptno)) {
		   List<WebElement> allcols=row.findElements(By.tagName("td"));
	       for(WebElement cell:allcols) {
      	     if(cell.getText().equals(receiptno)){
      	     System.out.println(cell.getText());  
      	     System.out.println("r="+r);
      	       flag=true;
      	       String deleteid= "ContentPlaceHolder1_rptReceipt_Button1_"+(r-3);
           	   dr.findElement(By.id(deleteid)).click();
           	   Thread.sleep(2000);
           	   dr.findElement(By.id("popup_ok")).click();	
           	   Thread.sleep(100);	
           		//System.out.println(dr.findElement(By.xpath("//h3[@id='defaultSpeechbubbleHeader']")).getText());
           	   break;  
       	    }	
	      }//	}
	       r++;
	       }	  
		   if(flag==false)
	    	      System.out.println("RECEIPT NO DOES NOT EXIST");
	            else
	            	System.out.println("DELETED SUCCESSFULLY");
	 }
	
}
