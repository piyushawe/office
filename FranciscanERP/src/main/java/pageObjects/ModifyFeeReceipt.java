package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ModifyFeeReceipt {
 WebDriver dr;
			
	 By feereceiptno= By.id("ContentPlaceHolder1_rdoSearch_0");
	 By studentdetails= By.id("ContentPlaceHolder1_rdoSearch_1");
	 By chequeno= By.id("ContentPlaceHolder1_rdoSearch_2");
	 By ddno= By.id("ContentPlaceHolder1_rdoSearch_3");
	 By cls= By.id("ContentPlaceHolder1_ddlClass");
	 By section= By.id("ContentPlaceHolder1_ddlSection");
	 By text=By.id("ContentPlaceHolder1_txtName");
	 By go= By.name("ctl00$ContentPlaceHolder1$btngetdetails$ctl00");
	 By modify= By.name("ctl00$ContentPlaceHolder1$BtnModify$ctl00");
	 By cancel= By.name("ctl00$ContentPlaceHolder1$btncancel$ctl00");
	 By modifychequedetails= By.id("ContentPlaceHolder1_ChkModifyChqDetails");
   
	 public ModifyFeeReceipt(WebDriver d)
	   {
		 this.dr=d;
	   }
	    public void openModifyFeeReceipt() throws InterruptedException
	    {
	      WebElement menu;
	      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
	      Thread.sleep(3000);
		  Actions builder= new Actions(dr);
		  builder.moveToElement(menu).build().perform();
		  WebElement menuop1= dr.findElement(By.linkText("Modify Fees Receipt"));
		  menuop1.click();
		  dr.switchTo().frame(dr.findElement(By.id("Modify Fees Receipt")));
	    } 
	    public void searchReceiptByReceiptNo(String rcpt) throws InterruptedException
	    {
	    	dr.findElement(feereceiptno).click();
	    	dr.findElement(text).sendKeys(rcpt);
	    	dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(500);
	    	dr.findElement(text).sendKeys(Keys.ENTER);
	    	Thread.sleep(500);
	    	//dr.findElement(go).click();
	    	dr.findElement(By.name("ctl00$ContentPlaceHolder1$rptReceipt$ctl00$btn")).click();
	    }
	    public void searchReceiptByName()
	    {
	    	dr.findElement(studentdetails).click();
	    	Select clss=new Select(dr.findElement(cls));
			clss.selectByVisibleText("1");
		    Select sec= new Select(dr.findElement(section));
		    sec.selectByVisibleText("A");
	    	dr.findElement(text).sendKeys("aditya ranjan");
	    	dr.findElement(go).click();
	    }
	    public void searchReceiptByChequeNo()
	    {
	    	dr.findElement(chequeno).click();
	    	dr.findElement(text).sendKeys("12345");
	    	dr.findElement(go).click();
	    }
	    public void modify()
	    {
	    	dr.findElement(modify).click();
	    }
	    public void clickCancel()
	    {
	    	dr.findElement(cancel).click();
	    }
}
