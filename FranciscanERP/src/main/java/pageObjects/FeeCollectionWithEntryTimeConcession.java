package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FeeCollectionWithEntryTimeConcession {
 WebDriver dr;
   //By entrymode= By.id("ContentPlaceHolder1_lstentrymode");
   By collectiondate= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
   By school= By.id("ContentPlaceHolder1_ddlSchoolSubHead");
   By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
   By paymode= By.id("ContentPlaceHolder1_lstPayMode");
   By receiptno_range= By.id("ContentPlaceHolder1_chkReceiptNoRange");
   By from= By.id("ContentPlaceHolder1_txtFrom_TextBox");
   By to= By.id("ContentPlaceHolder1_txtTo_TextBox");
   By headwise= By.id("ContentPlaceHolder1_rbtnShowCollection_0");
   By withouthead= By.id("ContentPlaceHolder1_rbtnShowCollection_1");
   By selecthead= By.id("ContentPlaceHolder1_ddlFeeHeadToshown");
   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	
   public FeeCollectionWithEntryTimeConcession(WebDriver d)
   {
	   this.dr=d;
   }
   public void openFeeCollectionWithEntryTimeConcession() throws InterruptedException
   {
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Collection"));
		 builder.moveToElement(submenu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Fee Collection with entry time concession")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Fee Collection with entry time concession")));
   }
   public void selectEntryMode(String emode)
   {
	   //new Select(dr.findElement(entrymode)).selectByVisibleText(emode);
	   dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(1) > div > div > button")).click();
	   dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
	   WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(emode.equals(option.getText()))
	  			option.click();
	   dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li.ui-multiselect-close")).click();
   }
   public void selectCollectionDate(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(collectiondate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(1000);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(1000);
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
	  	//  }
	    }Thread.sleep(1000);
   }
   public void selectSchool(String sch)
   {
	   new Select(dr.findElement(school)).selectByVisibleText(sch);
   }
   public void selectFeeType(String ftype)
   {
	   new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
   }
   public void selectPayMode(String pmode)
   {
	   dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(5) > div > button")).click();
	   dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li:nth-child(2) > a")).click();
	   WebElement select= dr.findElement(By.xpath("/html/body/div[5]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(pmode.equals(option.getText()))
	  			option.click();
	   dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li.ui-multiselect-close")).click();
   }
   public void selectPayMode(String pmode1, String pmode2)
   {
	   dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(5) > div > button")).click();
	   dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li:nth-child(2) > a")).click();
	   WebElement select= dr.findElement(By.xpath("/html/body/div[5]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(pmode1.equals(option.getText())||pmode2.equals(option.getText()))
	  			option.click();
	   dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li.ui-multiselect-close")).click();
   }
   public void clickReceiptNorange() throws InterruptedException
   {
	   dr.findElement(receiptno_range).click();
	   Thread.sleep(2000);
   }
   public void enterReceiptRange(String fr, String t)
   {
	   dr.findElement(from).sendKeys(fr);
	   dr.findElement(to).sendKeys(t);
   }
   public void clickHeadWise()
   {
	   dr.findElement(headwise).click();
   }
   public void selectHead(String hd)
   {
	   //new Select(dr.findElement(selecthead)).selectByVisibleText(hd);
   }
   public void clickWithoutHead()
   {
	   dr.findElement(withouthead).click();
   }
   public void clickShow() throws InterruptedException
   {
	   String exp= "DAILY FEE COLLECTION WITH CONCESSION";
     	 Utility u= new Utility(); 
      	 dr.findElement(show).click();
      	 Thread.sleep(2000);
      	 u.verifyPage(dr,exp);
   }
}
