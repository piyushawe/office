package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssignConcession {
  WebDriver dr;
     By cls= By.id("ContentPlaceHolder1_ddlClass");
     By section= By.id("ContentPlaceHolder1_ddlSection");
     By text= By.id("ContentPlaceHolder1_txtName");
     By search= By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
     By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
     By concessiontype= By.id("ContentPlaceHolder1_ddlConsType");
     By installment= By.id("ContentPlaceHolder1_ddlInstall");
     By copytootherinstallments= By.id("ContentPlaceHolder1_ChkAllInstall");
     By show= By.name("ctl00$ContentPlaceHolder1$btnShow$ctl00");
     By save= By.name("ctl00$ContentPlaceHolder1$BtnSave$ctl00");
     By cancel= By.className("ctl00$ContentPlaceHolder1$BtnCancel$ctl00");
     
     public AssignConcession(WebDriver d)
     {
    	 this.dr=d;
     }
     public void openAssignConcession()
     {
    	 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Fee-Master.png']"));
    	 Actions builder= new Actions(dr);
    	 builder.moveToElement(menu).build().perform();
    	 dr.findElement(By.linkText("Assign Concession")).click();
    	 dr.switchTo().frame(dr.findElement(By.id("Assign Concession")));
     }
     public void selectClass(String c) throws InterruptedException
     {
    	 new Select(dr.findElement(cls)).selectByVisibleText(c);
    	 Thread.sleep(500);
     }
     public void selectSection(String sec)
     {
    	 new Select(dr.findElement(section)).selectByVisibleText(sec);
     }
     public void enterText(String txt) throws InterruptedException
     {
    	 dr.findElement(text).sendKeys(txt);
    	 Thread.sleep(500);
    	 dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
    	 Thread.sleep(500);
    	 dr.findElement(text).sendKeys(Keys.ENTER);
    	 Thread.sleep(500);
    	 dr.findElement(text).sendKeys(Keys.ENTER);
    	 //dr.findElement(search).click();
     }
     public void selectFeeType(String ftype)
     {
    	 new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
     }
     public void selectConcessionType(String ctype)
     {
    	 new Select(dr.findElement(concessiontype)).selectByVisibleText(ctype);
     }
     public void selectInstallment(String inst)
     {
    	 new Select(dr.findElement(installment)).selectByVisibleText(inst);
     }
     public void clickCopyToOtherInstallments()
     {
    	 dr.findElement(copytootherinstallments).click();
     }
     public void clickShow()
     {
    	 dr.findElement(show).click();
     }
     public void assignConcessionAmount(String str1, String str2)
     {
    	 WebElement records= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	 List<WebElement>rows= records.findElements(By.tagName("tr")); 
    	 System.out.println(rows.size());
    	 int r=0;
         for(WebElement row:rows)
         {   r++; 
             System.out.println("r="+r);
             System.out.println(row.getText());
    	     List<WebElement>cells= row.findElements(By.tagName("td"));
    	     for(WebElement cell:cells)
    	     {   
    	    	 if(cell.getText().equals(str1)) {
    	         System.out.println(cell.getText());		 
    	    	 String actualamt= "ContentPlaceHolder1_GVFeesHead_txtActAmt_"+(r-2);	 
    	    	 String percent= "ContentPlaceHolder1_GVFeesHead_ChkPercent_"+(r-2);
    	    	 double actualamount= Double.parseDouble(dr.findElement(By.id(actualamt)).getText());
    	    	 String concessionamt= "ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+r+"$txtConAmt$TextBox";
    	    	 dr.findElement(By.name(concessionamt)).clear();
    	    	 if(str2.equals("amount")) {
    	    		 actualamount/=2; 	    	 
        	    	 dr.findElement(By.name(concessionamt)).sendKeys(Double.toString(actualamount));
        	    	 dr.findElement(By.name(concessionamt)).sendKeys(Keys.ENTER);
        	    	 break;
    	    	 }
    	    	 if(str2.equals("percent")) {
    	    		 actualamount=50;
    	    	 dr.findElement(By.name(concessionamt)).sendKeys(Double.toString(actualamount));
    	    	 dr.findElement(By.name(concessionamt)).sendKeys(Keys.ENTER);
    	    	 dr.findElement(By.id(percent)).click();
    	    	 break;
    	         }
    	       }
        	 }
         }
     }
     public void clickSave()
     {
    	 dr.findElement(save).click();
     }
     public void clickCancel()
     {
    	 dr.findElement(cancel).click();
     }
}
