package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SetStudentStatus {
    WebDriver dr;
    By cls= By.id("ContentPlaceHolder1_ddlclass");
    By section= By.id("ContentPlaceHolder1_ddlsection");
    By save= By.name("ctl00$ContentPlaceHolder1$btnUpdate$ctl00");
    
    public SetStudentStatus(WebDriver d)
    {
    	this.dr=d;
    }
    public void openSetStudentStatus()
    {
    	WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Fee-Master.png']"));
    	Actions builder= new Actions(dr);
    	builder.moveToElement(menu).build().perform();
    	dr.findElement(By.linkText("Set Student Status")).click();
    	dr.switchTo().frame(dr.findElement(By.id("Set Student Status")));
    }
    public void selectClass(String c)
    {
    	new Select(dr.findElement(cls)).selectByVisibleText(c);
    }
    public void selectSection(String sec)
    {
    	new Select(dr.findElement(section)).selectByVisibleText(sec);
    }
    public void clickSave()
    {
    	dr.findElement(save).click();
    }
    public void setStudentStatus(String stu, String status)
    {
    	WebElement list= dr.findElement(By.id("example"));
    	List<WebElement>rows= list.findElements(By.tagName("tr"));
    	int r=1;
    	for(WebElement row:rows)
    	{
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		for(WebElement cell:cells)
    		{
    			if(cell.getText().equals(stu))
    			{
    				String id= "ContentPlaceHolder1_rptStudentList_chkadd_"+(r-2);
    				if(status.equals("old"))
    					if(dr.findElement(By.id(id)).isSelected())
    						dr.findElement(By.id(id)).click();
    				if(status.equals("new"))
    					if(dr.findElement(By.id(id)).isSelected()) {}
    					else
    						dr.findElement(By.id(id)).click();    
    			}
    		}r++;
    	}
    }
    public void verifyStudentAsNewOrOld(String stu)
    {
    	WebElement list= dr.findElement(By.id("example"));
    	List<WebElement>rows= list.findElements(By.tagName("tr"));
    	int r=0;
    	for(WebElement row:rows)
    	{
    		r++;
    		List<WebElement>cells= dr.findElements(By.tagName("td"));
    		for(WebElement cell:cells)
    		{
    			if(cell.getText().equals(stu))
    			{
    				String id= "ContentPlaceHolder1_rptStudentList_chkadd_"+(r-2);
    				if(dr.findElement(By.id(id)).isSelected())
    					System.out.println("Student is New");
    				else
    					System.out.println("Student is Old");
    			}
    		}
    	}
    }
}
