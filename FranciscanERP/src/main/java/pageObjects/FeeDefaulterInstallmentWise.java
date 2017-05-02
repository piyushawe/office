package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FeeDefaulterInstallmentWise {
	WebDriver dr;
	By school= By.id("ContentPlaceHolder1_ddlSchool");
	By cls= By.id("ContentPlaceHolder1_ddlStandard");
	By section= By.id("ContentPlaceHolder1_ddlSection");
	By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	//By installment= By.id("ContentPlaceHolder1_lstInstallment");
	By route= By.id("ContentPlaceHolder1_DdlRoute");
    By vehicle=	By.id("ContentPlaceHolder1_ddlvehicle");		
	By daterange= By.id("ContentPlaceHolder1_chkrange");
	By fromdate= By.id("ContentPlaceHolder1_txtDateFrom_TextBox");
	By tilldate= By.id("ContentPlaceHolder1_txtDateTo_TextBox");
	By withfine= By.id("ContentPlaceHolder1_ChkIsFine");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_btnShow\"]/input");
	
	public FeeDefaulterInstallmentWise(WebDriver d)
    {
	    this.dr=d;
    }
    public void openFeeDefaulterInstallmentWise() throws InterruptedException
    {
    	 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Transaction-Report.png']"));
         //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         Thread.sleep(5000);
         Actions builder= new Actions(dr);
      	  builder.moveToElement(menu).build().perform();
         WebElement submenu= dr.findElement(By.linkText("Fee Defaulter"));
      	  builder.moveToElement(submenu).build().perform();
      	  //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         dr.findElement(By.linkText("Fee Defaulter Installment Wise")).click();
         dr.switchTo().frame(dr.findElement(By.id("Fee Defaulter Installment Wise")));
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
    	dr.findElement(By.xpath("//button[@type='button']")).click();
		dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
		WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
        dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
    	
    }
    public void selectRoute(String r)
    {
    	new Select(dr.findElement(route)).selectByVisibleText(r);
    }
    public void selectVehicle(String v)
    {
    	new Select(dr.findElement(vehicle)).selectByVisibleText(v);
    }
    public void selectDateRange()
    {
    	dr.findElement(daterange).click();
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
    public void selectTillDate(String mm, String yy, String dd) throws InterruptedException
    {
    	dr.findElement(tilldate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(1000);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(1000);
	  	  WebElement myw=dr.findElement(By.className("datepick"));
	     //   List<WebElement> rows= myw.findElements(By.className("datepick-days-row"));
	     //	for (WebElement row: rows){  
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
    public void clickWithFine()
    {
    	dr.findElement(withfine).click();
    }
    public void clickShow() throws InterruptedException
    {
    	String exp= "FEE DEFAULTER REPORT INSTALLMENT WISE";
    	 Utility u= new Utility(); 
     	 dr.findElement(show).click();
     	 Thread.sleep(2000);
     	 u.verifyPage(dr,exp);
    }
}
