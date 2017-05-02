package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentRegistration {
   WebDriver dr;
   By cls= By.id("ContentPlaceHolder1_ddlClass");
   By section= By.id("ContentPlaceHolder1_ddlSection");
   By text= By.id("ContentPlaceHolder1_txtNameSerch");
   By yes= By.id("ContentPlaceHolder1_ny");
   By no= By.id("ContentPlaceHolder1_nn");
   By modify= By.name("ctl00$ContentPlaceHolder1$BtnControls2$btnModify");
   
   public StudentRegistration(WebDriver d)
   {
	   this.dr=d;
   }
   public void openStudentRegistration()
   {
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Admission.png']"));
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Student Registration")).click();
	   dr.switchTo().frame(dr.findElement(By.id("mainiframe")));
   }
   public void selectClass(String c) throws InterruptedException
   {
	   new Select(dr.findElement(cls)).selectByVisibleText(c);
	   Thread.sleep(3000);
   }
   public void selectSection(String sec) throws InterruptedException
   {
	   new Select(dr.findElement(section)).selectByVisibleText(sec);
	   Thread.sleep(500);
   }
   public void enterSearchText(String txt) throws InterruptedException
   {
	   dr.findElement(text).sendKeys(txt); 
	   Thread.sleep(500);
	   dr.findElement(text).sendKeys(Keys.ARROW_DOWN);
	   Thread.sleep(500);
	   dr.findElement(text).sendKeys(Keys.ENTER);
	   Thread.sleep(500);
	   dr.findElement(text).sendKeys(Keys.ENTER);
	   Thread.sleep(500);
	   if(dr.getPageSource().contains("Select student from list"))
	   {
		   dr.findElement(By.xpath("//input[@placeholder='type here...']")).sendKeys(txt);
		   WebElement records= dr.findElement(By.id("example"));
		   List<WebElement>rows= records.findElements(By.tagName("tr"));
		   int r=0;
		   for(WebElement row:rows)
		   {   r++;
			   List<WebElement>cells= row.findElements(By.tagName("td"));
			   for(WebElement cell:cells)
			   {
				   if(cell.getText().equals(txt))
				   {
					   //String id="ContentPlaceHolder1_rptStudentList_btn_"+(r-2);
					   dr.findElement(By.xpath("//input[@type='submit']")).click();
				   }
			   }
		   }
	   }
   }
   public void verifyStudentStatus()
   {
	   if(dr.findElement(yes).isSelected())
		   System.out.println("Student is NEW");
   }
   public void setStudentStatus(String status) throws InterruptedException
   {
	   if(status.equals("old"))
		   { 
		     dr.findElement(no).click();
		     System.out.println("Status is now OLD");
		     Thread.sleep(500);
		   }
	   if(status.equals("new"))
	       {
			   dr.findElement(yes).click();
			   System.out.println("Status is now NEW");
			   Thread.sleep(500);
		   }
	   clickModify();
   }
   public void clickModify()
   {
	   dr.findElement(modify).click();
   }
}
