package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FeesConcessionInstallHeadWise {
	WebDriver dr;
	By school= By.id("ContentPlaceHolder1_ddlSchool");
	By cls= By.id("ContentPlaceHolder1_ddlStandard");
	By section= By.id("ContentPlaceHolder1_ddlSection");
	By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	By feeheadwise= By.id("ContentPlaceHolder1_rbnsearch_0");
	By installmentwise= By.id("ContentPlaceHolder1_rbnsearch_1");
	//By installment= By.id("ContentPlaceHolder1_lstInstallment");
	By concession= By.id("ContentPlaceHolder1_lstCon");
	By head= By.name("ctl00$ContentPlaceHolder1$HdnHead");
	By tilldate= By.name("ctl00$ContentPlaceHolder1$txtDateTo$TextBox");
	By paidconcession= By.id("ContentPlaceHolder1_chkpaidconcessn");
	By entrytime= By.id("ContentPlaceHolder1_ChkEntry");
	By assigned= By.id("ContentPlaceHolder1_ChkAss");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	
	public FeesConcessionInstallHeadWise(WebDriver d)
    {
    	this.dr=d;
    }
    public void openFeesConcessionInstallHeadWise() throws InterruptedException
	 {   
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Fees Concession Install/Head Wise")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Fees Concession Install/Head Wise")));
	 }
   public void selectSchool(String s)
   {
	   new Select(dr.findElement(school)).selectByVisibleText(s);
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
   public void clickFeeHeadWise()
   {
	   dr.findElement(feeheadwise).click();
   }
   public void clickInstallmentWise()
   {
	   dr.findElement(installmentwise).click();
   }
   public void selectInstallment(String inst)
   {
	  //new Select(dr.findElement(installment)).selectByVisibleText(inst);
	   dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(5) > div > button")).click();
	   dr.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
	   WebElement select= dr.findElement(By.xpath("/html/body/div[3]/ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
	   dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]")).click();
   }
   public void selectConcession(String conc)
   {
	   new Select(dr.findElement(concession)).selectByVisibleText(conc);
   }
   public void selectHead(String h)
   {
	   new Select(dr.findElement(head)).selectByVisibleText(h);
   }
   public void selectTillDate(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(tilldate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(500);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(500);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	       // List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	  		//for (WebElement row: rows){  
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  
	  			//System.out.println("cell value"+cell.getText());
	  			cell.click();
	  			break; 
	  		 }  
	  	 //   }
	    }Thread.sleep(1000);
   }
   public void clickPaidConcession()
   {
	   dr.findElement(paidconcession).click();
   }
   public void clickAssigned()
   {
	   dr.findElement(assigned).click();
   }
   public void clickEntryTime()
   {
	   dr.findElement(entrytime).click();
   }
   public void clickShow() throws InterruptedException
   {
	   String exp= "Month Wise Concession List of Concession Type";
 	   Utility u= new Utility(); 
       dr.findElement(show).click();
       Thread.sleep(2000);
 	   u.verifyPage(dr,exp);
   }
}
