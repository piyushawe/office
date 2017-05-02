package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AdvancePaymentReport {
WebDriver dr;
  By installment=By.id("ContentPlaceHolder1_ddlinstallment");
  By cls=By.id("ContentPlaceHolder1_ddlStanard");
  By section=By.id("ContentPlaceHolder1_ddlSection");
  By feetype=By.id("ContentPlaceHolder1_ddlFeeType");
  By school=By.id("ContentPlaceHolder1_ddlschoolhead");
  By paymenttilldate=By.id("ContentPlaceHolder1_dtjoinfromto_TextBox");
  By show=By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
  	  
  public AdvancePaymentReport(WebDriver d)
  {
	  this.dr=d;
  }
//open advance payment report  
  public void openAdvancePaymentReport() throws InterruptedException
  {
	  WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(4000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 WebElement submenu= dr.findElement(By.linkText("Collection"));
		 builder.moveToElement(submenu).build().perform();
		 dr.findElement(By.linkText("Advance Payment Report")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Advance Payment Report")));		 
  }
//select installment
  public void selectInstallment(String s)
  {
	  Select inst=new Select(dr.findElement(installment));
	  inst.selectByVisibleText(s);
  }
//select class  
  public void selectClass(String s)
  {
	  Select c= new Select(dr.findElement(cls));
	  c.selectByVisibleText(s);
  }
//select section  
  public void selectSection(String s)
  {
	  Select sec=new Select(dr.findElement(section));
	  sec.selectByVisibleText(s);
  }
//select fee type  
  public void selectFeeType(String s)
  {
	  Select ftype=new Select(dr.findElement(feetype));
	  ftype.selectByVisibleText(s);
  }
//select school  
  public void selectSchool(String s)
  {
	  Select sch=new Select(dr.findElement(school));
	  sch.selectByVisibleText(s);
  }
//payment till date  
  public void selectPaymentTillDate(String mm, String yy, String dd) throws InterruptedException
  {
	  dr.findElement(paymenttilldate).click();
	  Thread.sleep(1000);
	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
      Thread.sleep(500);
      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  Thread.sleep(500);
	  WebElement myw=dr.findElement(By.className("datepick"));
		 List<WebElement> cells=myw.findElements(By.tagName("td"));
		  for(WebElement cell: cells) {
			if (cell.getText().equals(dd)){  
			
			cell.click();
			break; 
		 }  
  }Thread.sleep(500);
  }
//click show  
  public void clickShow() throws InterruptedException
  {
	 String exp= "ADVANCE REPAYMENT REPORT";	
	 Utility u= new Utility(); 
 	 dr.findElement(show).click();
 	 Thread.sleep(2000);
 	 u.verifyPage(dr,exp);
  }
}
