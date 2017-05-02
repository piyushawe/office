package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReligionGenderWiseStudentStrength {
WebDriver dr;
   By cls= By.id("ContentPlaceHolder1_ddlClass");
   By sectionwise= By.id("ContentPlaceHolder1_chkForSection");
   By section= By.id("ContentPlaceHolder1_ddlSection");
   By religionwise= By.id("ContentPlaceHolder1_rdbOption_0");
   By genderwise= By.id("ContentPlaceHolder1_rdbOption_1");
   By religionandgenderwise= By.id("ContentPlaceHolder1_rdbOption_2");
   By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
   
    public ReligionGenderWiseStudentStrength(WebDriver d)
    {
       this.dr=d;
    }
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
     dr.findElement(By.linkText("Religion / Gender Wise Student Strength")).click();
     dr.switchTo().frame(dr.findElement(By.id("Religion / Gender Wise Student Strength")));
    }
    public void selectClass(String c)
    {
 	   Select cs= new Select(dr.findElement(cls));
 	   cs.selectByVisibleText(c);
    }
    public void checkClickForSectionwise()
    {
       if(dr.findElement(sectionwise).isSelected()){
    	   
       }else
 	   dr.findElement(sectionwise).click();
    }
    public void selectSection(String s) throws InterruptedException
    {  
       Thread.sleep(1000);	
 	   Select sec= new Select(dr.findElement(section));
 	   sec.selectByVisibleText(s);
    }
    public void clickReligionWise() throws InterruptedException
    {
    	Thread.sleep(1000);	
 	   dr.findElement(religionwise).click();
    }
    public void clickGenderWise() throws InterruptedException
    {
    	Thread.sleep(1000);	
 	   dr.findElement(genderwise).click();
    }
    public void clickReligionAndGenderWise() throws InterruptedException
    {
    	Thread.sleep(1000);	
 	   dr.findElement(religionandgenderwise).click();
    }
    public void clickShow() throws InterruptedException
    {
    	 String exp= "GENDER RELIGION STUDENT REPORT";
		 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
		 u.verifyPage(dr,exp);
    }
}
