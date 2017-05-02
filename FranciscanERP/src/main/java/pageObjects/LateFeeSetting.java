package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LateFeeSetting {
   WebDriver dr;
     By feegroup= By.id("ContentPlaceHolder1_ddlFeeGroup");
     By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
     By installment= By.id("ContentPlaceHolder1_ddlInstallment");
     By duedate= By.id("ContentPlaceHolder1_dtduedate_TextBox");
     By latefeetype= By.id("ContentPlaceHolder1_txtctype");
     By amount= By.id("ContentPlaceHolder1_txtAmount_TextBox");
     By save= By.name("ctl00$ContentPlaceHolder1$BtnControls1$btnSave");
     By view= By.id("ContentPlaceHolder1_BtnControls1_btnView");
     By print= By.name("ctl00$ContentPlaceHolder1$BtnControls1$ctl00");
     By cancel= By.name("ctl00$ContentPlaceHolder1$BtnControls1$ctl01");
     
	public LateFeeSetting(WebDriver d)
	{
		this.dr=d;
	}
	public void openLateFeeSetting()
	{
		WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Fee-Master.png']"));
		Actions builder= new Actions(dr);
		builder.moveToElement(menu).build().perform();
		dr.findElement(By.linkText("Late Fee Setting")).click();
		dr.switchTo().frame(dr.findElement(By.id("Late Fee Setting")));
	}
	public void selectFeeGroup(String fgroup)
	{
		new Select(dr.findElement(feegroup)).selectByVisibleText(fgroup);
	}
	public void selectFeeType(String ftype)
	{
		new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
	}
	public void selectInstallment(String inst)
	{
		new Select(dr.findElement(installment)).selectByVisibleText(inst);
	}
	public void selectDueDate(String mm, String yy, String dd)throws Exception
    {
    	dr.findElement(duedate).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(200);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(200);
	  	  WebElement myw=dr.findElement(By.className("datepick"));     
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  	  			
	  			cell.click();
	  			break; 
	    	 }  	  
	    }Thread.sleep(200); 
    }
	public void enterAmount(String amt)
	{
		dr.findElement(amount).sendKeys(amt);
	}
	public void clickSave()
	{
		dr.findElement(save).click();
	}
	public void clickView()
	{
		dr.findElement(view).click();
	}
	public void clickPrint()
	{
		dr.findElement(print).click();
	}
	public void clickCancel()
	{
		dr.findElement(cancel).click();
	}
}
