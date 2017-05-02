package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MonthWiseCollectionReport {
	WebDriver dr;
	   //By entrymode= By.id("ContentPlaceHolder1_lstentrymode");
	   By school= By.id("ContentPlaceHolder1_ddlSchool");
	   By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	   //By month= By.id("ContentPlaceHolder1_lstmonth");
	   By cls= By.id("ContentPlaceHolder1_ddlClass");
	   By installment= By.id("ContentPlaceHolder1_ddlInstallment");
	   By feehead= By.id("ContentPlaceHolder1_ddlFeeHeadToshown");
	   By bankname= By.id("ContentPlaceHolder1_DDlDepBank");
	   By user= By.id("ContentPlaceHolder1_ddlUser");
	   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	   String exp= "Month Wise Collection";
	   public MonthWiseCollectionReport(WebDriver d)
	   {
		   this.dr=d;
	   }
	   public void openMonthWiseCollectionReport() throws InterruptedException
	   {
		   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
			 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(6000);
			 Actions builder= new Actions(dr);
			 builder.moveToElement(menu).build().perform();
			 WebElement submenu= dr.findElement(By.linkText("Collection"));
			 builder.moveToElement(submenu).build().perform();
			 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
			 dr.findElement(By.linkText("Month Wise Collection Report")).click();
			 dr.switchTo().frame(dr.findElement(By.id("Month Wise Collection Report")));
	   }
	   public void selectEntryMode(String emode)
	   {
		  //new Select(dr.findElement(entrymode)).selectByVisibleText(emode);
		  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(1) > div > div > button")).click();
		  dr.findElement(By.cssSelector("body > div:nth-child(3) > div > ul > li:nth-child(2) > a")).click();
		  WebElement select= dr.findElement(By.xpath("/html/body/div[2]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(emode.equals(option.getText()))
		  			option.click();
		  dr.findElement(By.cssSelector("body > div:nth-child(3) > div > ul > li.ui-multiselect-close")).click();
	   }
	   public void selectSchool(String sch)
	   {
		   new Select(dr.findElement(school)).selectByVisibleText(sch);
	   }
	   public void selectFeeType(String ftype)
	   {
		   new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
	   }
	   public void selectMonth(String mth)
	   {
		  //new Select(dr.findElement(month)).selectByVisibleText(mth);
		  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(4) > div > button")).click();
		  dr.findElement(By.cssSelector("body > div:nth-child(9) > div > ul > li:nth-child(2) > a")).click();
		  WebElement select= dr.findElement(By.xpath("/html/body/div[6]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(mth.equals(option.getText()))
		  			option.click();
		  dr.findElement(By.cssSelector("body > div:nth-child(9) > div > ul > li.ui-multiselect-close")).click();
	   }
	   public void selectClass(String c)
	   {
		   new Select(dr.findElement(cls)).selectByVisibleText(c);
	   }
	   public void selectInstallment(String inst)
	   {
		   new Select(dr.findElement(installment)).selectByVisibleText(inst);
	   }
	   public void selectFeeHead(String f)
	   {
		   new Select(dr.findElement(feehead)).selectByVisibleText(f);
	   }
	   public void selectBankName(String b)
	   {
		  //new Select(dr.findElement(bankname)).selectByVisibleText(b);
		  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(8) > div > button")).click();
		  dr.findElement(By.cssSelector("body > div:nth-child(5) > div > ul > li:nth-child(2) > a")).click();
		  WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
			List<WebElement> options = select.findElements(By.tagName("span"));
		  	for(WebElement option:options)
		  		if(b.equals(option.getText()))
		  			option.click();
		  dr.findElement(By.cssSelector("body > div:nth-child(5) > div > ul > li.ui-multiselect-close")).click();
	   }
	   public void selectUser(String u)
	   {
		   new Select(dr.findElement(user)).selectByVisibleText(u);
	   }
	   public void clickShow() throws InterruptedException
	   {
		     String exp= "MONTH WISE COLLECTION ";
			 Utility u= new Utility(); 
		     dr.findElement(show).click();
		     Thread.sleep(2000);
			 u.verifyPage(dr,exp);
	   }
}
