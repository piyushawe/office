package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReceiptCertificateSetting {
   WebDriver dr;
       By receiptsettings= By.id("ContentPlaceHolder1_ddlrecsetting");
       By admissionreceiptsettings= By.id("ContentPlaceHolder1_ddlAdmssn");
       By prospectusreceiptsettings= By.id("ContentPlaceHolder1_ddlPros");
       By admissionentrysettings= By.id("ContentPlaceHolder1_ddladmentry");
       By feecertificatesettings= By.id("ContentPlaceHolder1_ddlcertisettings");
       By tcsettings= By.id("ContentPlaceHolder1_ddltcsettings");
       By bonafidesettings= By.id("ContentPlaceHolder1_ddlbonafiedsetting");
       By charactercertificatesettings= By.id("ContentPlaceHolder1_ddlCC");
       By billformatsettings= By.id("ContentPlaceHolder1_ddlbillfrmat");
       By provisionaltcsettings= By.id("ContentPlaceHolder1_ddlprovisional");
       By labelformatsetting= By.id("ContentPlaceHolder1_ddllabel");
       By birthcertificate= By.id("ContentPlaceHolder1_ddlBirthcer");
       By affiliationcertificate= By.id("ContentPlaceHolder1_ddlAffcer");
       By loccertificate= By.id("ContentPlaceHolder1_ddllocCertificate");
       By passportapply= By.id("ContentPlaceHolder1_ddlpassportApply");
       By passportissue= By.id("ContentPlaceHolder1_ddlpassportIssue");
       By ruralareacertificate= By.id("ContentPlaceHolder1_ddlruralarea");
       By migrationcertificatesetting= By.id("ContentPlaceHolder1_ddlmigration");
       By examname= By.id("ContentPlaceHolder1_txtMigrationExam_TextBox");
       By save= By.id("ctl00$ContentPlaceHolder1$btnsave$ctl00");
       
       public ReceiptCertificateSetting(WebDriver d)
       {
    	   this.dr=d;
       }
       public void openReceiptCertificateSetting()
       {
    	   WebElement menu;
    	   Actions builder= new Actions(dr);
    	   menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
    	   builder.moveToElement(menu).build().perform();
    	   dr.findElement(By.linkText("Receipt Certificate Setting")).click();
    	   dr.switchTo().frame(dr.findElement(By.id("Receipt Certificate Setting")));
       }
       public void verifyReceiptSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(receiptsettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(receiptsettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewreceipt$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyAdmissionReceiptSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(admissionreceiptsettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(admissionreceiptsettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewAdmRcpt$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyProspectusReceiptSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(prospectusreceiptsettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(prospectusreceiptsettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$ViewPros$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyAdmissionEntrySettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(admissionentrysettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(admissionentrysettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$Viewadmentry$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyFeeCertificateSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(feecertificatesettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(feecertificatesettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewcerti$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyTCSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(tcsettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(tcsettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewtc$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyBonafideSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(bonafidesettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(bonafidesettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewbonfid$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyCharacterCertificateSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(charactercertificatesettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(charactercertificatesettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewCC$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyBillFormatSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(billformatsettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(billformatsettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewbill$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyProvisionalTCSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(provisionaltcsettings)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(provisionaltcsettings)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$viewprovisional$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyLabelFormatSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(labelformatsetting)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(labelformatsetting)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnlabel$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyBirthCertificateSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(birthcertificate)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(birthcertificate)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnbirthcer$ctl00")).click();
    		   Thread.sleep(1000);
    		   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();;
    	   }
       }
       public void verifyAffiliationCertificateSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(affiliationcertificate)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(affiliationcertificate)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnAffcer$ctl00")).click();
    		   Thread.sleep(1000);
    		   if(dr.getPageSource().contains("Server Error"))
    		   {
    		       System.out.println("Server Error");
    		   }else
    			   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();
    	   }
       }
       public void verifyLOCCertificateSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(loccertificate)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(loccertificate)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnLocCerti$ctl00")).click();
    		   Thread.sleep(1000);
    		   if(dr.getPageSource().contains("Server Error"))
    		   {
    		       System.out.println("Server Error");
    		   }else
    			   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();
    	   }
       }
       public void verifyPassportApplySettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(passportapply)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(passportapply)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnPassApply$ctl00")).click();
    		   Thread.sleep(1000);
    		   if(dr.getPageSource().contains("Server Error"))
    		   {
    		       System.out.println("Server Error");
    		   }else
    			   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();
    	   }
       }
       public void verifyPassportIssueSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(passportissue)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(passportissue)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnPassIssue$ctl00")).click();
    		   Thread.sleep(1000);
    		   if(dr.getPageSource().contains("Server Error"))
    		   {
    		       System.out.println("Server Error");
    		   }else
    			   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();
    	   }
       }
       public void verifyRuralAreaCertificateSettings() throws InterruptedException
       {
    	   List<WebElement>options= new Select(dr.findElement(ruralareacertificate)).getOptions();
    	   int size= options.size();
    	   System.out.println("Total Settings: "+size);
    	   for(int i=0; i<size; i++)
    	   {
    		   new Select(dr.findElement(ruralareacertificate)).selectByIndex(i);
    		   Thread.sleep(200);
    		   dr.findElement(By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00")).click();
    		   Thread.sleep(1000);
    		   if(dr.getPageSource().contains("Server Error"))
    		   {
    		       System.out.println("Server Error");
    		   }else
    			   dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click();
    	   }
       }
       public void clickSave()
       {
    	   dr.findElement(save).click();
       }
}
