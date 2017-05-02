package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ManualFeeModification {

 WebDriver dr;
		
	 By cls= By.name("ctl00$ContentPlaceHolder1$ddlClass");
	 By section= By.name("ctl00$ContentPlaceHolder1$ddlSection");
	 By text= By.name("ctl00$ContentPlaceHolder1$txtName");
	 By go= By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
	 By installment= By.name("ctl00$ContentPlaceHolder1$ddlInstall");
	 By feetype= By.id("ContentPlaceHolder1_ddlFType");
	 By modifyreason= By.id("ContentPlaceHolder1_txtReason_TextBox");
	 By exclusivehead= By.id("ContentPlaceHolder1_lstHead");
	 By addhead= By.name("ctl00$ContentPlaceHolder1$BtnAddHead$ctl00");
	 By modify= By.name("ctl00$ContentPlaceHolder1$SingleButtonModify$ctl00");
	 By cancel= By.name("ctl00$ContentPlaceHolder1$Btncancel$ctl00");
	 By date= By.id("ContentPlaceHolder1_txtModifyDate_TextBox");
	
	public ManualFeeModification(WebDriver d) 
	{
		this.dr=d;
	}
	public void openManualFeeModification()
    {
	 WebElement menu;
	 Actions builder= new Actions(dr);
	  menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
	  builder.moveToElement(menu).build().perform();
	  WebElement menuop1= dr.findElement(By.linkText("Manual Fees Modification"));
	  menuop1.click();
	  dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  dr.switchTo().frame(dr.findElement(By.id("Manual Fees Modification")));
    } 
	public void searchStudent(String s1, String s2, String s3) throws InterruptedException
	{
		Select clss=new Select(dr.findElement(cls));
		clss.selectByVisibleText(s1);
	    Select sec= new Select(dr.findElement(section));
	    sec.selectByVisibleText(s2);
    	dr.findElement(text).sendKeys(s3);
    	Thread.sleep(500);
    	dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	dr.findElement(text).sendKeys(Keys.ENTER);
    	Thread.sleep(500);
    	//dr.findElement(go).click();
	}
	public void selectInstallment(String inst)
	{
		Select clss=new Select(dr.findElement(installment));
		if(inst.length()>2)
		  clss.selectByVisibleText(inst);
		else
		  clss.selectByIndex(Integer.parseInt(inst));
	}
	public void selectDate(String mm, String yy, String dd)throws Exception
    {
    	dr.findElement(date).click();
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
	public void selectFeeType(String ftype) throws InterruptedException
	{
		new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
		Thread.sleep(1000);
	}
	public void enterModifyReason()
	{
		dr.findElement(modifyreason).sendKeys("TEST");
	}
	public void enterAmountToHead(String amt, String h)
	{
		WebElement records= dr.findElement(By.id("example1"));
		List<WebElement>rows= records.findElements(By.tagName("tr"));
		int r=0;
		System.out.println(rows.size());
		for(WebElement row:rows) {
			r++;
			System.out.println(row.getText());
			List<WebElement>cells= row.findElements(By.tagName("td"));
			for(WebElement cell:cells)
			{
				if(h.equals(cell.getText()))
				{
					System.out.println(cell.getText());
					String amount="ctl00$ContentPlaceHolder1$RptHeadDetails$ctl0"+(r-3)+"$txtPaidAmt$TextBox";
					dr.findElement(By.name(amount)).clear();
					dr.findElement(By.name(amount)).sendKeys(amt);
					dr.findElement(By.name(amount)).sendKeys(Keys.ENTER);
					break;
				}
			}
		}
	}
	public void selectHead(String hd, String amt) throws InterruptedException
	{
	  dr.findElement(By.xpath("//button[@type='button']")).click();
	 // dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
	  WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
	  List<WebElement> options = select.findElements(By.tagName("span"));
	  Thread.sleep(1000);
	  System.out.println(options.size());
	  for(WebElement option:options)
		  if(option.getText().equals(hd))
			  option.click();
	  dr.findElement(By.xpath("//li[@class='ui-multiselect-close']")).click();
	  dr.findElement(addhead).click();
	  enterAmountToHead(amt,hd);
	}
	public void clickModify()
	{
		dr.findElement(modify).click();
	}
	public void clickCancel()
	{
		dr.findElement(cancel).click();
	}
}
