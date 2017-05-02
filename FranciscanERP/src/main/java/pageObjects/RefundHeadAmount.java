package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RefundHeadAmount {
   WebDriver dr;
   By session= By.id("ContentPlaceHolder1_ddlYear");
   By cls= By.id("ContentPlaceHolder1_ddlClass");
   By section= By.id("ContentPlaceHolder1_ddlSection");
   By text= By.id("ContentPlaceHolder1_txtName");
   By go= By.name("ctl00$ContentPlaceHolder1$btngetdetails$ctl00");
   By installment= By.id("ContentPlaceHolder1_ddlInstallment");
   By date= By.id("ContentPlaceHolder1_txtrecdte_TextBox");
   By remarks= By.id("ContentPlaceHolder1_txtRemarks_TextBox"); 
   By refund= By.name("ctl00$ContentPlaceHolder1$BtnModify$ctl00");
   By cancel= By.name("ctl00$ContentPlaceHolder1$btncancel$ctl00");
   
   public RefundHeadAmount(WebDriver d)
   {
	   this.dr=d;
   }
   public void openRefundHeadAmount()
   {
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Refund Head Amount")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Refund Head Amount")));
   }
   public void selectSession(String sess) throws InterruptedException
   {
	   new Select(dr.findElement(session)).selectByVisibleText(sess);
	   Thread.sleep(500);
   }
   public void selectClass(String c) throws InterruptedException
   {
	   new Select(dr.findElement(cls)).selectByVisibleText(c);
	   Thread.sleep(500);
   }
   public void selectSection(String sec)
   {
	   new Select(dr.findElement(section)).selectByVisibleText(sec);
   }
   public void enterText(String txt) throws InterruptedException
   {
	   dr.findElement(text).sendKeys(txt);
	   Thread.sleep(500);
	   dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
	   Thread.sleep(500);
	   dr.findElement(text).sendKeys(Keys.ENTER);
	   Thread.sleep(500);
	   dr.findElement(text).sendKeys(Keys.ENTER);
	   Thread.sleep(500);
   }
   public void selectInstallment(String inst) throws InterruptedException
   {
	   new Select(dr.findElement(installment)).selectByVisibleText(inst);
	   Thread.sleep(1000);
   }
   public void enterRemarks()
   {
	   dr.findElement(remarks).sendKeys("Test");
   }
   public void clickRefund()
   {
	   dr.findElement(refund).click();
   }
   public void selectDate(String mm, String yy, String dd)throws Exception
   {
   	      dr.findElement(date).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(200);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(200);
	  	  WebElement myw=dr.findElement(By.className("datepick"));     
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  	  			
	  			cell.click();
	  			break; 
	    	 }  	  
	    }Thread.sleep(200); 
   }
   public void refundAmount(String rhead) throws InterruptedException
   {
		WebElement records= dr.findElement(By.id("example1"));
		List<WebElement>rows= records.findElements(By.tagName("tr"));
		int r=0;
		System.out.println(rows.size());
		for(WebElement row:rows) {
			
			System.out.println(row.getText());
			if(!rhead.equals(row.getText())) {
			List<WebElement>cells= row.findElements(By.tagName("td"));
			for(WebElement cell:cells)
			{
				//if(!rhead.equals(cell.getText()))
				//{
					System.out.println(cell.getText());
					//String amount="ContentPlaceHolder1_RptHeadDetails_lblPaidAmt_"+(r-2);
					String name= "ctl00$ContentPlaceHolder1$RptHeadDetails$ctl0"+(r)+"$txtPaidAmt$TextBox";
					dr.findElement(By.name(name)).clear();
					dr.findElement(By.name(name)).sendKeys("0");
					Thread.sleep(1000);
					break;
				//}
			}
			}r++;
		}
   }
}
