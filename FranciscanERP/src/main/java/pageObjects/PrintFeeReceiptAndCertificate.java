package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PrintFeeReceiptAndCertificate {
 WebDriver dr;
	 By feereceiptno= By.id("ContentPlaceHolder1_rdoSearch_0");
     By studentdetails= By.id("ContentPlaceHolder1_rdoSearch_1");
	 By chequeno= By.id("ContentPlaceHolder1_rdoSearch_2");
	 By ddno= By.id("ContentPlaceHolder1_rdoSearch_3");
	 By cls= By.id("ContentPlaceHolder1_ddlClass");
	 By section= By.id("ContentPlaceHolder1_ddlSection");
	 By text=By.id("ContentPlaceHolder1_txtName");
	 By go= By.name("ctl00$ContentPlaceHolder1$btngetdetails$ctl00");
		   
	    public PrintFeeReceiptAndCertificate(WebDriver d)
	    {
	    	this.dr=d;
	    }
	    public void openPrintFeeReceiptAndCertificate()
	    {
	      WebElement menu;
		  Actions builder= new Actions(dr);
	      menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Print Fee Receipt & Certificate"));
		  menuop1.click();
		  dr.switchTo().frame(dr.findElement(By.id("Print Fee Receipt & Certificate")));
	    } 
	    public void searchReceiptByReceiptNo(String s) throws InterruptedException
	    {
	    	dr.findElement(feereceiptno).click();
	    	dr.findElement(text).sendKeys(s);
	    	dr.findElement(go).click();
	    	Thread.sleep(1000);
	    }
	    public void searchReceiptByName(String s1, String s2, String s3) throws InterruptedException
	    {
	    	dr.findElement(studentdetails).click();
	    	Select clss=new Select(dr.findElement(cls));
			clss.selectByVisibleText(s1);
		    Select sec= new Select(dr.findElement(section));
		    sec.selectByVisibleText(s2);
		    dr.findElement(text).sendKeys(s3);
	    	dr.findElement(go).click();
	    	dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(200);
	    	dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(200);
	    	dr.findElement(text).sendKeys(Keys.ENTER);
	    	Thread.sleep(200);
	    }
	    public void searchReceiptByChequeNo(String s)
	    {
	    	dr.findElement(chequeno).click();
	    	dr.findElement(text).sendKeys(s);
	    	dr.findElement(go).click();
	    }
	    public void printFeeCertificate(String receiptno)
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
	    }
	    public void printFeeReceipt(String receiptno)
	    {
	    	WebElement receiptrecords=dr.findElement(By.xpath("//table[@id='example']"));	
			   List<WebElement> allcols=receiptrecords.findElements(By.tagName("td"));
		       for (WebElement cell:allcols) {
	        	  if(cell.getText().equals(receiptno)){
	        	     System.out.println(cell.getText());   	
	             		dr.findElement(By.name("ctl00$ContentPlaceHolder1$rptReceipt$ctl00$btn")).click();
	             		 break;  
	         	  }
		        }
	    }
}
