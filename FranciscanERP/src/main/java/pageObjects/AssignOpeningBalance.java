package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AssignOpeningBalance {
   WebDriver dr;
   By cls= By.id("ContentPlaceHolder1_ddlclass");
   By section= By.id("ContentPlaceHolder1_ddlsection");
   By feetype= By.id("ContentPlaceHolder1_ddlFeetype");
   By save= By.name("ctl00$ContentPlaceHolder1$btnSave$ctl00");
   
   public AssignOpeningBalance(WebDriver d)
   {
	   this.dr=d;
   }
   public void openAssignOpeningBalance()
   {
	   WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Fee-Master.png']"));
	   Actions builder= new Actions(dr);
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Assign Opening Balance")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Assign Opening Balance")));
   }
   public void selectClass(String c)
   {
	   new Select(dr.findElement(cls)).selectByVisibleText(c);
   }
   public void selectSection(String sec)
   {
	   new Select(dr.findElement(section)).selectByVisibleText(sec);
   }
   public void selectFeeType(String ftype)
   {
	   new Select(dr.findElement(feetype)).selectByVisibleText(ftype);
   }
   public void clickSave()
   {
	   dr.findElement(save).click();
   }
   public void assignOpeningBalance(String name, String amt)
   {
	   WebElement list= dr.findElement(By.id("example"));
	   List<WebElement>rows= list.findElements(By.tagName("tr"));
	   int r=1;
	   for(WebElement row:rows)
	   {
		   List<WebElement>cells=row.findElements(By.tagName("td"));
		   for(WebElement cell:cells)
		   {
			   if(cell.getText().equals(name))
			   {
				   System.out.println("r= "+r);
				   String opbalance="ctl00$ContentPlaceHolder1$rptStudentList$ctl0"+(r-3)+"$TxtOBalance$TextBox";
				   dr.findElement(By.name(opbalance)).clear();
				   dr.findElement(By.name(opbalance)).sendKeys(amt);
				   String selectstu="ContentPlaceHolder1_rptStudentList_ChkActive_"+(r-3);
				   dr.findElement(By.id(selectstu)).click();
			   }
		   }r++;
	   }
   }
   public void assignOpeningBalance(String name, String amt, String comp)
   {
	   WebElement list= dr.findElement(By.id("example"));
	   List<WebElement>rows= list.findElements(By.tagName("tr"));
	   int r=1;
	   for(WebElement row:rows)
	   {
		   List<WebElement>cells=row.findElements(By.tagName("td"));
		   for(WebElement cell:cells)
		   {
			   if(cell.getText().equals(name))
			   {
				   System.out.println("r= "+r);
				   String opbalance="ctl00$ContentPlaceHolder1$rptStudentList$ctl0"+(r-3)+"$TxtOBalance$TextBox";
				   dr.findElement(By.name(opbalance)).clear();
				   double amount = 0;
				   if(comp.equals("greater than"))
					    amount=Double.parseDouble(amt)+1000;
				   if(comp.equals("less than"))
					    amount=Double.parseDouble(amt)-1000;
				   if(comp.equals("equal to"))
					   amount=Double.parseDouble(amt);
				   dr.findElement(By.name(opbalance)).sendKeys(Double.toString(amount));
				   String selectstu="ContentPlaceHolder1_rptStudentList_ChkActive_"+(r-3);
				   dr.findElement(By.id(selectstu)).click();
			   }
		   }r++;
	   }
   }
   public void assignOpeningDues(String name, String amt)
   {
	   WebElement list= dr.findElement(By.id("example"));
	   List<WebElement>rows= list.findElements(By.tagName("tr"));
	   int r=1;
	   for(WebElement row:rows)
	   {
		   List<WebElement>cells=row.findElements(By.tagName("td"));
		   for(WebElement cell:cells)
		   {
			   if(cell.getText().equals(name))
			   {
				   System.out.println("r= "+r);
				   String dbalance="ctl00$ContentPlaceHolder1$rptStudentList$ctl0"+(r-3)+"$TxtDBalance$TextBox";
				   dr.findElement(By.name(dbalance)).clear();
				   dr.findElement(By.name(dbalance)).sendKeys(amt);
				   String selectstu="ContentPlaceHolder1_rptStudentList_ChkActive_"+(r-3);
				   dr.findElement(By.id(selectstu)).click();
			   }
		   }r++;
	   }
   }
}
