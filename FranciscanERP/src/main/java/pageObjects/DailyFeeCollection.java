package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DailyFeeCollection {
	 WebDriver dr;
	
	 //By entrymode= By.id("ContentPlaceHolder1_lstentrymode");
	 By fromdate=By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
	 By todate= By.id("ContentPlaceHolder1_txtdateTo_TextBox");
	 By cls= By.id("ContentPlaceHolder1_ddlStanard");
	 By school= By.id("ContentPlaceHolder1_ddlSchoolSubHead");
	 By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	 By paymode= By.id("ContentPlaceHolder1_ddlFeeType");
	 By head= By.id("ContentPlaceHolder1_ddlFeeHeadToshown");
	 By receiptrange= By.id("ContentPlaceHolder1_chkReceiptNoRange");
	 By headwise= By.id("ContentPlaceHolder1_rbtnShowCollection_0");
	 By withouthead= By.id("ContentPlaceHolder1_rbtnShowCollection_1");
	 By withheadonelinedata= By.id("ContentPlaceHolder1_rbtnShowCollection_2");
	 By withoutheadonelinedata= By.id("ContentPlaceHolder1_rbtnShowCollection_3");
	 By user= By.id("ContentPlaceHolder1_ddlUser");
	 By show= By.name("ctl00$ContentPlaceHolder1$btnShow$ctl00");
	 
	 public DailyFeeCollection(WebDriver d)
	 {
		 this.dr=d;
	 }
	 public void openDailyFeeCollectionReport() throws InterruptedException
	 {   
		 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Collection"));
		 builder.moveToElement(submenu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Daily Fee Collection")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Daily Fee Collection")));
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
	 public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
	  {
		  dr.findElement(fromdate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(1000);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(1000);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	      
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	 
	    }Thread.sleep(1000);
	  }
	  public void selectToDate(String mm, String yy, String dd) throws InterruptedException
	  {
		  dr.findElement(todate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(1000);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(1000);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	   
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  

	    }Thread.sleep(1000);
	  }
	 public void selectClass(String c) 
	 {	
		 dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[4]/div/div/button")).click();
		 dr.findElement(By.xpath("/html/body/div[7]/div/ul/li[2]/a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[7]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(c.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.xpath("/html/body/div[7]/div/ul/li[3]")).click();
	 }	
	 public void selectSchool(String s)
	 {
		 Select emode= new Select(dr.findElement(school));
		 emode.selectByVisibleText(s);	
	 }
	 public void selectFeeType(String s1, String s2)
	 {
		 dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[7]/div/button")).click();
		 dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[2]/a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(s1.equals(option.getText())||s2.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[3]")).click();
	 }
	 public void selectFeeType(String s1)
	 {
		 dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[7]/div/button")).click();
		 dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[2]/a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(s1.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.xpath("/html/body/div[6]/div/ul/li[3]")).click();
	 }
	 public void selectPayMode(String p1, String p2)
	 {
		 dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[8]/div/button")).click();
		 dr.findElement(By.xpath("/html/body/div[5]/div/ul/li[2]/a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[5]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(p1.equals(option.getText())||p2.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.xpath("/html/body/div[5]/div/ul/li[3]")).click();
	 }
	 public void selectHead(String s)
	 {
		 Select emode= new Select(dr.findElement(head));
		 emode.selectByVisibleText(s);
	 }
	 public void selectHeadWise()
	 {
		 dr.findElement(headwise).click();
	 }
	 public void selectWithoutHeadTotalAmount()
	 {
		 dr.findElement(withouthead).click();
	 }
	 public void selectWithHeadOneLineData()
	 {
		 dr.findElement(withheadonelinedata).click();
	 }
	 public void selectWithoutHeadOneLineData()
	 {
		 dr.findElement(withoutheadonelinedata).click();
	 }
	 public void selectUser(String usr)
	 {
		 new Select(dr.findElement(user)).selectByVisibleText(usr);
	 }
	 public void clickShow() throws InterruptedException
	 {
		 String exp="DAILY FEE COLLECTION ";
		   	Utility u= new Utility(); 
		   	dr.findElement(show).click();
		   	Thread.sleep(2000);
		   	u.verifyPage(dr,exp);
	 }
}

