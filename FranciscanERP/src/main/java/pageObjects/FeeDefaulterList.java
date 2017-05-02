package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeeDefaulterList {
  WebDriver dr;
  By school= By.id("ContentPlaceHolder1_ddlSchool");
  By classwise=By.id("ContentPlaceHolder1_RbtnClass_0");
  By classrange=By.id("ContentPlaceHolder1_RbtnClass_1");
  By cls=By.id("ContentPlaceHolder1_ddlStandard");
  By section=By.id("ContentPlaceHolder1_ddlSection");
  By feetype=By.id("ContentPlaceHolder1_ddlFeeType");
  //By installment=By.id("ContentPlaceHolder1_lstInstallment");
  By chqclearingdate=By.id("ContentPlaceHolder1_chkclearingdate");
  By withfine= By.id("ContentPlaceHolder1_ChkIsFine");
  By withouthead=By.id("ContentPlaceHolder1_RbtmHead_0");
  By withhead=By.id("ContentPlaceHolder1_RbtmHead_1");
  By proceedtosms=By.name("ctl00$ContentPlaceHolder1$Btnpreview$ctl00");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
  By daterange=By.id("ContentPlaceHolder1_chkrange");
  By fromdate= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
  By tilldate= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
  By selectrange=By.id("ContentPlaceHolder1_ddlRange");
  By rangevalue= By.id("ContentPlaceHolder1_txtRangeAmt_TextBox");
  By betweenvalue= By.id("ContentPlaceHolder1_txtBetAmt_TextBox");
  By findtext=By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ReportViewer1_ctl05_ctl03_ctl00\"]");
  By find= By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ReportViewer1_ctl05_ctl03_ctl01\"]");
  
  public FeeDefaulterList(WebDriver d)
  {
	  this.dr=d;
  }
  
  public void openFeeDefaulterList() throws InterruptedException
	 {
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(2000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Fee Defaulter"));
		 builder.moveToElement(submenu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Fees DefaulterList")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Fees DefaulterList")));
	 }
   
    public void selectSchool(String s)
    {
    	Select sch= new Select(dr.findElement(school));
    	sch.selectByVisibleText(s);
    }
    public void selectClasswise()
    {
    	dr.findElement(classwise).click();
    }
    public void selectClass(String s)
    {
    	Select c= new Select(dr.findElement(cls));
    	c.selectByVisibleText(s);
    }
    public void selectSection(String s)
    {
    	Select sec=new Select(dr.findElement(section));
    	sec.selectByVisibleText(s);
    }
    public void clickClassRange()
    {
    	dr.findElement(classrange).click(); 
    }
    public void selectClassRange(String c)
    {
    	dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div.rowElem.noborder.pb0.ClsRange > div > button")).click();
    	dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2) > a")).click();
    	WebElement select= dr.findElement(By.xpath("/html/body/div[4]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
    	dr.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li.ui-multiselect-close")).click();
    }
    public void selectfeeType(String s)
    {
    	Select ftype= new Select(dr.findElement(feetype));
    	ftype.selectByVisibleText(s);
    }
    public void selectInstallment(String inst) 
    {
    	//new Select(dr.findElement(installment)).selectByVisibleText(s);
    	dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(7) > div > button")).click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
    	WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
    	dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li.ui-multiselect-close")).click();
    }
    public void selectFilterWithChequeClearingDate() 
    {
    	dr.findElement(chqclearingdate).click();
    }
    public void selectWithFine() 
    {
    	dr.findElement(withfine).click();
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
	  			cell.click();
	  			break; 
	  		 }  
	  	  
	    }Thread.sleep(1000);
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
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	    }Thread.sleep(1000);
    }
    public void selectWithHead() 
    {
    	dr.findElement(withhead).click();
    }
    public void selectWithoutHead() 
    {
    	dr.findElement(withouthead).click();
    }
    public void selectRange(String s1, String s2)
    {
    	Select range= new Select(dr.findElement(selectrange));
    	range.selectByVisibleText(s1);
    	dr.findElement(rangevalue).sendKeys(s2);
    }
    public void selectRange(String s1, String s2, String s3)
    {
    	Select range= new Select(dr.findElement(selectrange));
    	range.selectByVisibleText(s1);
    	dr.findElement(rangevalue).sendKeys(s2);
    	dr.findElement(betweenvalue).sendKeys(s3);
    }
    public void findtext(String s)
    {
    	dr.findElement(findtext).sendKeys(s);
    	dr.findElement(find).click();
    }
    public void selectDateRange()
    {
    	dr.findElement(daterange).click();
    }
    public void clickShow() throws InterruptedException 
    {
    	String exp= "FEES DEFAULTER LIST";
    	 Utility u= new Utility(); 
    	 dr.findElement(show).click();
    	 Thread.sleep(5000);
    	//dr.findElement(By.id("ctl00_ContentPlaceHolder1_ReportViewer1_ctl09")).isDisplayed();
    	 u.verifyPage(dr,exp);
    }
}
