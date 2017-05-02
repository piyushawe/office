package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DayWiseTotalCollection {
  WebDriver dr;
    //By entrymode= By.id("ContentPlaceHolder1_lstentrymode");
    By school= By.id("ContentPlaceHolder1_ddlSchool");
    By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
    //By month= By.id("ContentPlaceHolder1_lstmonth");
    By cls= By.id("ContentPlaceHolder1_ddlClass");
    By section= By.id("ContentPlaceHolder1_ddlSection");
    //By installment= By.id("ContentPlaceHolder1_lstInstallment");
    By feehead= By.id("ContentPlaceHolder1_ddlFeeHeadToshown");
    By paymode= By.id("ContentPlaceHolder1_lstPayMode");
    By user= By.id("ContentPlaceHolder1_ddlUser");
    By tilldate= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
    By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
    
	public DayWiseTotalCollection(WebDriver d)
	  {
		  this.dr=d;
	  }
	  public void openDayWiseTotalCollection() throws InterruptedException
	  {
		  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
			 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(6000);
			 Actions builder= new Actions(dr);
			 builder.moveToElement(menu).build().perform();
			 WebElement submenu= dr.findElement(By.linkText("Collection"));
			 builder.moveToElement(submenu).build().perform();
			 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			 dr.findElement(By.linkText("Day Wise Total Collection")).click();
			 dr.switchTo().frame(dr.findElement(By.id("Day Wise Total Collection")));
	  }
	  public void selectEntryMode(String emode)
	  {
		 dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(1) > div > div > button")).click();
		 dr.findElement(By.cssSelector("body > div:nth-child(4) > div > ul > li:nth-child(2) > a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(emode.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.cssSelector("body > div:nth-child(4) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectSchool(String sch)
	  {
	  	new Select(dr.findElement(school)).selectByVisibleText(sch);
	  }
	  public void selectClass(String c)
	  {
	  	new Select(dr.findElement(cls)).selectByVisibleText(c);
	  }
	  public void selectSection(String sec)
	  {
	  	new Select(dr.findElement(section)).selectByVisibleText(sec);
	  }
	  public void selectFeeType(String ftype)
	  {
	  	new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
	  }
	  public void selectInstallment(String inst)
	  {
	 	 //new Select(dr.findElement(installment)).selectByVisibleText(inst);
		 dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(7) > div > button")).click();
		 dr.findElement(By.cssSelector("body > div:nth-child(5) > div > ul > li:nth-child(2) > a")).click();
		 WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(inst.equals(option.getText()))
		  			option.click();
		 dr.findElement(By.cssSelector("body > div:nth-child(5) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectFeeHead(String fhead)
	  {
	 	 new Select(dr.findElement(feehead)).selectByVisibleText(fhead);
	  }
	  public void selectMonth(String m)
	  {
		 //new Select(dr.findElement(month)).selectByVisibleText(m);
		  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(4) > div > button")).click();
		  dr.findElement(By.cssSelector("body > div:nth-child(10) > div > ul > li:nth-child(2) > a")).click();
		  WebElement select= dr.findElement(By.xpath("/html/body/div[7]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(m.equals(option.getText()))
		  			option.click();
		  dr.findElement(By.cssSelector("body > div:nth-child(10) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectPayMode(String pmode1, String pmode2)
	  {
	 	 dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(9) > div > button")).click();
	 	 dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
	 	 WebElement select= dr.findElement(By.xpath("/html/body/div[5]/ul"));
		 List<WebElement> options = select.findElements(By.tagName("span"));
	     for(WebElement option:options)
	  		if(pmode1.equals(option.getText())||pmode2.equals(option.getText()))
	  			option.click();
	 	 dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
	  }
	  public void selectUser(String u)
	  {
	 	new Select(dr.findElement(user)).selectByVisibleText(u);
	  }
	  public void selectTillDate(String mm, String yy, String dd) throws InterruptedException
	  {
		  dr.findElement(tilldate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(1000);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(1000);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	        List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  		for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			cell.click();
	  			break; 
	  		 }  
	  	    }
	    }Thread.sleep(1000);
	  }
	  public void clickShow() throws InterruptedException
	  {
		  String exp= "DAY WISE TOTAL COLLECTION";
		  Utility u= new Utility(); 
	 	 dr.findElement(show).click();
	 	 Thread.sleep(2000);
	 	 u.verifyPage(dr,exp);
	  }
}
