package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TCForm {
   WebDriver dr;
   By session= By.id("ContentPlaceHolder1_ddlsession");
   By searchstudent= By.id("ContentPlaceHolder1_txtName");
   By go= By.id("ContentPlaceHolder1_btngetstfortc");
   By get= By.id("ContentPlaceHolder1_btngetbook");
   By category= By.id("ContentPlaceHolder1_ddlcategroy");
   By board= By.id("ContentPlaceHolder1_ddlboard");
   By struckoffdate= By.id("ContentPlaceHolder1_txtstruckdate_TextBox");
   By character= By.id("ContentPlaceHolder1_ddlcharecter");
   By tcapplyingdate= By.id("ContentPlaceHolder1_txtapplydate_TextBox");
   By save= By.name("ctl00$ContentPlaceHolder1$btnsave$ctl00");
   
   public TCForm(WebDriver d)
   {
	   this.dr=d;
   }
   public void openTCForm()
   {
	   WebElement menu;
	   Actions builder= new Actions(dr);
	   menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Certificate.png']"));
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("TC Form")).click();
	   dr.switchTo().frame(dr.findElement(By.id("TC Form")));
   }
   public void selectSession(String sess)
   {
	   new Select(dr.findElement(session)).selectByVisibleText(sess);
   }
   public void enterSearchStudent(String student) throws InterruptedException
   {
	   dr.findElement(searchstudent).sendKeys(student);
	   Thread.sleep(500);
	   dr.findElement(searchstudent).sendKeys(Keys.ARROW_DOWN);
	   Thread.sleep(500);
	   dr.findElement(searchstudent).sendKeys(Keys.ENTER);
	   Thread.sleep(500);
	   dr.findElement(go).click();
   }
   public void clickGet()
   {
	   dr.findElement(get).click();
   }
   public void selectCategory(String ctry)
   {
	   new Select(dr.findElement(category)).selectByVisibleText(ctry);
   }
   public void selectSchoolBoard(String brd)
   {
	   new Select(dr.findElement(board)).selectByVisibleText(brd);
   }
   public void selectStruckOffDate(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(struckoffdate).click();
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
   public void selectCharacter(String chr)
   {
	   new Select(dr.findElement(character)).selectByVisibleText(chr);
   }
   public void selectTCApplyingDate(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(tcapplyingdate).click();
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
   public void clickSave()
   {
	   dr.findElement(save).click();
   }
}
