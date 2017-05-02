package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FeeEntrySettingOthers {
  WebDriver dr;
    
     public FeeEntrySettingOthers(WebDriver d)
     {
    	 this.dr=d;
     }
     public void openFeeEntrySettingOthers()
     {
    	 WebElement menu;
 	     Actions builder= new Actions(dr);
 	     menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
 	     builder.moveToElement(menu).build().perform();
 	     dr.findElement(By.linkText("Fee Entry Setting Others")).click();
 	     dr.switchTo().frame(dr.findElement(By.id("Fee Entry Setting Others")));
     }
     public void clickAllowUserToSelectBankInFeeEntry()
     {
    	 
     }
     public void clickEnableWaiveOffWithChequeBounce()
     {
    	 if(dr.findElement(By.id("ContentPlaceHolder1_chkchequewave")).isSelected()) {
    		 
    	}else
    		dr.findElement(By.id("ContentPlaceHolder1_chkchequewave")).click();
     }
     public void enableManualFee(String inst)
     {
    	 if(dr.findElement(By.id("ContentPlaceHolder1_manual_late_fee")).isSelected()) {
    		 
    	 }else
    		 dr.findElement(By.id("ContentPlaceHolder1_manual_late_fee")).click();
    	 if(inst.equals("single"))
    		 dr.findElement(By.id("ContentPlaceHolder1_manual_late_fee_type_0")).click();
    	 if(inst.equals("multiple"))
    		 dr.findElement(By.id("ContentPlaceHolder1_manual_late_fee_type_1")).click();
     }
     public void clickSave()
     {
    	 dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnSave$ctl00")).click();
     }
}    

