package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReceiptWiseFeeTypeCollection {
  WebDriver dr;
    By school= By.id("ContentPlaceHolder1_ddlSchool");
    //By cls= By.id("ContentPlaceHolder1_lstClass");
    By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
    //By paymode= By.id("ContentPlaceHolder1_lstPayMode");
    By datefrom= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
    By dateto= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
    By user= By.id("ContentPlaceHolder1_ddlUser");
    //By bankname= By.id("ContentPlaceHolder1_DDlDepBank");
    By studentwiseonly= By.id("ContentPlaceHolder1_ChkStuWise");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
  
  public ReceiptWiseFeeTypeCollection(WebDriver d)
  {
	  this.dr=d;
  }
  public void openReceiptWiseFeeTypeCollection() throws InterruptedException
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Collection"));
		 builder.moveToElement(submenu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		 dr.findElement(By.linkText("Receipt wise Fee Type Collection")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Receipt wise Fee Type Collection")));
  }
  public void selectSchool(String sch)
  {
  	new Select(dr.findElement(school)).selectByVisibleText(sch);
  }
  public void selectClass(String c)
  {
  	 //new Select(dr.findElement(cls)).selectByVisibleText(c);
	 dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(2) > div > button")).click(); 
	 dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li:nth-child(2) > a")).click();
	 WebElement select= dr.findElement(By.xpath("/html/body/div[5]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
	 dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li.ui-multiselect-close")).click();
  }
  public void selectFeeType(String ftype)
  {
  	new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
  }
  public void selectPayMode(String pmode1, String pmode2)
  {
 	 //new Select(dr.findElement(paymode)).selectByVisibleText(pmode);
	 dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(4) > div > button")).click();
	 dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
	 WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(pmode1.equals(option.getText())||pmode2.equals(option.getText()))
	  			option.click();
	 dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
  }
  public void selectFromDate(String mm, String yy, String dd) throws InterruptedException
  {
	  dr.findElement(datefrom).click();
  	  Thread.sleep(1000);
  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
      Thread.sleep(200);
      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
  	  Thread.sleep(200);
  	  WebElement myw=dr.findElement(By.className("datepick"));
       //List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
  		//for (WebElement row: rows){  
  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
  		  for(WebElement cell: cells) {
  			if (cell.getText().equals(dd)){  
  			cell.click();
  			break; 
  		 }  
  	    //}
    }Thread.sleep(200);
  }
  public void selectToDate(String mm, String yy, String dd) throws InterruptedException
  {
	  dr.findElement(dateto).click();
  	  Thread.sleep(1000);
  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
      Thread.sleep(200);
      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
  	  Thread.sleep(200);
  	  WebElement myw=dr.findElement(By.className("datepick"));
       //List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
  		//for (WebElement row: rows){  
  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
  		  for(WebElement cell: cells) {
  			if (cell.getText().equals(dd)){  
  			cell.click();
  			break; 
  		 }  
  	  // }
    }Thread.sleep(200);
  }
  public void selectUser(String u)
  {
 	new Select(dr.findElement(user)).selectByVisibleText(u);
  }
  public void selectBankName(String bname)
  {
	  //new Select(dr.findElement(bankname)).selectByVisibleText(bname);
	  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(8) > div > button")).click();
	  dr.findElement(By.cssSelector("body > div:nth-child(9) > div > ul > li:nth-child(2) > a")).click();
	  WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(bname.equals(option.getText()))
	  			option.click();
	  dr.findElement(By.cssSelector("body > div:nth-child(9) > div > ul > li.ui-multiselect-close")).click();
  }
  public void clickStudentWiseOnly()
  {
	  dr.findElement(studentwiseonly).click();
  }
  public void clickShow() throws InterruptedException
  {
	     String exp= "RECEIPT WISE COLLECTION REPORT ";
		 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
		 u.verifyPage(dr,exp); 
  }
}
