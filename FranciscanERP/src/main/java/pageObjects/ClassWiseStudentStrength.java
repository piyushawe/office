package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClassWiseStudentStrength {
WebDriver dr;
  By datewise= By.id("ContentPlaceHolder1_chkDate");
  By date= By.id("ContentPlaceHolder1_txttoDate_TextBox");
  By rowwise= By.id("ContentPlaceHolder1_rdorowwise");
  By columnwise= By.id("ContentPlaceHolder1_rdocolumnwise");
  By cls= By.id("ContentPlaceHolder1_ddlClass");
  By sectionwise= By.id("ContentPlaceHolder1_chkForSection");
  By section= By.id("ContentPlaceHolder1_ddlSection");
  By newstudents= By.id("ContentPlaceHolder1_chknew");
  By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");

   public ClassWiseStudentStrength(WebDriver d)
    {
	    this.dr=d;
    }
   public void openClassWiseStudentStrength() throws InterruptedException
    {   
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	   //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Thread.sleep(5000);
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   WebElement submenu= dr.findElement(By.linkText("Student Strength"));
	   builder.moveToElement(submenu).build().perform();
	   //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   dr.findElement(By.linkText("Class Wise Student Strength")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Class Wise Student Strength")));
     }
   public void checkDateWise()
   {
	   dr.findElement(datewise).click();
   }
   public void selectDate(String mm, String yy, String dd) throws InterruptedException
   {
	   dr.findElement(date).click();
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
	  			System.out.println("cell value"+cell.getText());
	  		cell.click();
	  		break; 
	  	 }  
	   // }
	   }Thread.sleep(2000);
   }
   public void clickRowWise()
   {
	   dr.findElement(rowwise).click();
   }
   public void clickColumnWise()
   {
	   dr.findElement(columnwise).click();
   }
   public void selectClass(String c)
   {
	   Select cs= new Select(dr.findElement(cls));
	   cs.selectByVisibleText(c);
   }
   public void clickSectionWise()
   {
	   dr.findElement(sectionwise).click();
   }
   public void clickNewStudents()
   {
	   dr.findElement(newstudents).click();
   }
   public void selectSection(String s)
   {
	   Select sec= new Select(dr.findElement(section));
	   sec.selectByVisibleText(s);
   }
   public void clickShow() throws InterruptedException
   {
	   String exp="CLASS WISE STUDENT STRENGTH REPORT";
	   	Utility u= new Utility(); 
	   	dr.findElement(show).click();
	   	Thread.sleep(2000);
	   	u.verifyPage(dr,exp);
   }
}
