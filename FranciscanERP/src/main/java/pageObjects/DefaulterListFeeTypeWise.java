package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DefaulterListFeeTypeWise {
WebDriver dr;
  By school= By.id("ContentPlaceHolder1_ddlSchool");
  //By cls= By.id("ContentPlaceHolder1_lstClass");
  By feetype=By.id("ContentPlaceHolder1_ddlFeeType");
  //By installment=By.id("ContentPlaceHolder1_lstInstallment");
  By withfine=By.id("ContentPlaceHolder1_ChkIsFine");
  By withlatefinebifurcated=By.id("ContentPlaceHolder1_ChkLateFineBif");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");		  
  
  public DefaulterListFeeTypeWise(WebDriver d)
  {
	  this.dr=d;
  }
  public void openDefaulterListFeeTypeWise() throws InterruptedException
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(4000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Fee Defaulter"));
		 builder.moveToElement(submenu).build().perform();
		 dr.findElement(By.linkText("Defaulter List Fee type wise")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Defaulter List Fee type wise")));		 
  }
  public void selectSchool(String s)
  {
	  Select sch= new Select(dr.findElement(school));
	  sch.selectByVisibleText(s);
  }
  public void selectClass(String c)
  {
	 // new Select(dr.findElement(cls)).selectByVisibleText(s);
	  dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[2]/div/button")).click();
	  dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
	  WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
	  dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li.ui-multiselect-close")).click();
  }
  public void selectFeeType(String s)
  {
	  Select ftype= new Select(dr.findElement(feetype));
	  ftype.selectByVisibleText(s);
  }
  public void selectInstallment(String inst)
  {
	 //new Select(dr.findElement(installment)).selectByVisibleText(s);
	  dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(4) > div > button")).click();
	  dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
	  WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
	  dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
  }
  public void selectWithFine()
  {
	  dr.findElement(withfine).click();
  }
  public void selectWithLateFineBifurcated()
  {
	  dr.findElement(withlatefinebifurcated).click();
  }
  public void clickShow() throws InterruptedException
  {
	 String exp= "DEFAULTER lIST";
	 Utility u= new Utility(); 
 	 dr.findElement(show).click();
 	 Thread.sleep(5000);
 	 u.verifyPage(dr,exp);
  }
}
