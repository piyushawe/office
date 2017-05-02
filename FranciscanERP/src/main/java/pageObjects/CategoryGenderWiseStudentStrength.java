package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CategoryGenderWiseStudentStrength {
WebDriver dr;
	By cls= By.id("ContentPlaceHolder1_ddlClass");
	By sectionwise= By.id("ContentPlaceHolder1_chkForSection");
	By section= By.id("ContentPlaceHolder1_ddlSection");
	By categorywise= By.id("ContentPlaceHolder1_rdbOption_0");
	By genderwise= By.id("ContentPlaceHolder1_rdbOption_1");
	By categoryandgenderwise= By.id("ContentPlaceHolder1_rdbOption_2");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
	
	public CategoryGenderWiseStudentStrength(WebDriver d)
    {
	    this.dr=d;
    }
//open category gender wise student strength	
    public void openCategoryGenderWiseStudentStrength() throws InterruptedException
    {   
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	   //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Thread.sleep(5000);
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   WebElement submenu= dr.findElement(By.linkText("Student Strength"));
	   builder.moveToElement(submenu).build().perform();
	   //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   dr.findElement(By.linkText("Category / Gender Wise Student Strength")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Category / Gender Wise Student Strength")));
     }
//class    
   public void selectClass(String c)
   {
	   Select cs= new Select(dr.findElement(cls));
	   cs.selectByVisibleText(c);
   }
//section wise   
   public void checkClickForSectionwise() throws InterruptedException
   {
	   dr.findElement(sectionwise).click();
	   Thread.sleep(2000);
   }
//section   
   public void selectSection(String s)
   {
	  new Select(dr.findElement(section)).selectByVisibleText(s);
   }
//category wise   
   public void clickCategoryWise()
   {
	   dr.findElement(categorywise).click();
   }
//gender wise   
   public void clickGenderWise()
   {
	   dr.findElement(genderwise).click();
   }
//category and gender wise   
   public void clickCategoryAndGenderWise()
   {
	   dr.findElement(categoryandgenderwise).click();
   }
//show   
   public void clickShow() throws InterruptedException
   {
	   String exp="STUDENT STRENGTH REPORT";
	   	Utility u= new Utility(); 
	   	dr.findElement(show).click();
	   	Thread.sleep(2000);
	   	u.verifyPage(dr,exp);
   }
}
