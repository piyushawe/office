package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssignConcessionToStudent {
     WebDriver dr;
     By cls= By.id("ContentPlaceHolder1_ddlclass");
     By section= By.id("ContentPlaceHolder1_ddlsection");
     By update= By.name("ctl00$ContentPlaceHolder1$btnUpdate$ctl00");
     
     public AssignConcessionToStudent(WebDriver d)
     {
    	 this.dr=d;
     }
     public void openAssignConcessionToStudent()
     {
    	 WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Fee-Master.png']"));
    	 Actions builder= new Actions(dr);
    	 builder.moveToElement(menu).build().perform();
    	 dr.findElement(By.linkText("Assign Concession To Student")).click();
    	 dr.switchTo().frame(dr.findElement(By.id("Assign Concession To Student")));
     }
     public void selectClass(String c)
     {
    	 new Select(dr.findElement(cls)).selectByVisibleText(c);
     }
     public void selectSection(String sec)
     {
    	 new Select(dr.findElement(section)).selectByVisibleText(sec);
     }
     public void clickUpdate()
     {
    	 dr.findElement(update).click();
     }
     public void assignConcessionToStudent(String conc,String str) throws InterruptedException
     {
    	 WebElement list= dr.findElement(By.id("example"));
    	 List<WebElement>rows= list.findElements(By.tagName("tr"));
    	 System.out.println(rows.size());
    	 int r=1;
    	 for(WebElement row:rows)
    	 {      
    		 //System.out.println(row.getText());
    		 List<WebElement>cells= row.findElements(By.tagName("td"));
    		 for(WebElement cell:cells)
    		 {
    			 if(str.equals(cell.getText()))
    			 {   
    				 System.out.println(cell.getText());
    				 System.out.println("r= "+r);
    				 System.out.println(row.getText());
    				 row.findElement(By.cssSelector("td:nth-child(7)")).click();
    				 //String path1= "/html/body/div["+r+"]/div/ul/li[2]/a";
    				 //dr.findElement(By.xpath(path1)).click();
    				 Thread.sleep(1000);
    				 String path2="/html/body/div["+r+"]/ul";
    				 WebElement select= dr.findElement(By.xpath(path2));
    				 List<WebElement>options=select.findElements(By.tagName("span"));
    				 System.out.println(options.size());
    				 for(WebElement option:options)
    					 if(conc.equals(option.getText()))
    					 {
    						 System.out.println(option.getText());
    						 if(option.isSelected()) {
    							 
    						 }else
    						    option.click(); 
    						 String path3="/html/body/div["+r+"]/div/ul/li[3]";
    						 dr.findElement(By.xpath(path3)).click();
    					 }
    				 break;
    			 }
    		 } r++;
    	 }
     }
}
