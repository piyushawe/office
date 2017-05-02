package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FeeChequeClearing {
WebDriver dr;
  By receiptdate=By.id("ContentPlaceHolder1_rdoredeiptdate");
  By chequedate=By.id("ContentPlaceHolder1_rdochqdate");
  By chequeno=By.id("ContentPlaceHolder1_rdochqno");
  By depositbank=By.id("ContentPlaceHolder1_rdoDepBank");
  By rdate=By.id("ctl00$ContentPlaceHolder1$txtRecDate$TextBox");
  By chqdate=By.id("ContentPlaceHolder1_txtchqdate_TextBox");
  By chqno= By.id("ContentPlaceHolder1_txtchqno_TextBox");
  By dbank= By.id("ContentPlaceHolder1_ddlDepBank");
  By getdetails= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
  By clearingdate= By.name("ctl00$ContentPlaceHolder1$RPTClearCheque$ctl00$txtdate$TextBox");
  By chqclearstatus= By.id("ContentPlaceHolder1_RPTClearCheque_chkstatus_0");
  By save= By.xpath("//*[@id=\"ContentPlaceHolder1_Btnsave\"]/input");
  
  public FeeChequeClearing(WebDriver d)
  {
	  this.dr=d;
  }
  public void openFeeChequeClearingPage()
  {
	  WebElement menu;
   	  Actions builder= new Actions(dr);
      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
	  builder.moveToElement(menu).build().perform();
	  WebElement menuop1= dr.findElement(By.linkText("Fee Cheque Clearing"));
	  menuop1.click();
	  dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  dr.switchTo().frame(dr.findElement(By.id("Fee Cheque Clearing")));
  }
  public void byReceiptdate(String mm, String yy, String dd) throws InterruptedException
  {
	  dr.findElement(receiptdate).click();
	  dr.findElement(rdate).click();
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

  public void byChequeDate(String mm, String yy, String dd) throws InterruptedException
  {
	  dr.findElement(chequedate).click();
	  dr.findElement(chqdate).click();
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
  public void byChequeNo(String s)
  {
	  dr.findElement(chequeno).click();
	  dr.findElement(chqno).sendKeys(s);
  }
  public void byDepositBank(String s)
  {
	  dr.findElement(depositbank).click();
	  Select b= new Select(dr.findElement(dbank));
	  b.selectByVisibleText(s);
  }
  public void clickGetDetails()
  {
	  dr.findElement(getdetails).click();
  }
  public void enterChequeClearingDetails(String mm, String yy, String dd) throws InterruptedException
  {
	  dr.findElement(clearingdate).click();
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
    dr.findElement(chqclearstatus).click();
  }
  public void clicksave()
  {
	  dr.findElement(save).click();
  }
}
