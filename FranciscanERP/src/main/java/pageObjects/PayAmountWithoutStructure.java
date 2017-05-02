package pageObjects;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PayAmountWithoutStructure {

public WebDriver dr;
	 By year= By.name("ctl00$ContentPlaceHolder1$ddlyear");
	 By cls= By.name("ctl00$ContentPlaceHolder1$ddlClass");
	 By section= By.id("ContentPlaceHolder1_ddlSection");
	 By text=By.id("ContentPlaceHolder1_txtName");
	 By go=By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
	 By reason= By.id("ContentPlaceHolder1_txtReason_TextBox");
	 By exclusivehead= By.id("ContentPlaceHolder1_lstHead");
	 By addhead= By.name("ctl00$ContentPlaceHolder1$BtnAddHead$ctl00");
	 By save= By.id("ContentPlaceHolder1_btncontrol_btnSave");
	 By view= By.id("ContentPlaceHolder1_btncontrol_btnView");
     By print= By.name("ctl00$ContentPlaceHolder1$btncontrol$ctl00");
     By clear= By.className("ctl00$ContentPlaceHolder1$btncontrol$ctl01");
    
     public PayAmountWithoutStructure(WebDriver drv)
     {
    	 dr=drv;
     }
     
    public void openPayAmountWithoutStructure()
    {
      WebElement menu;
      Actions builder= new Actions(dr);
      menu = dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
	  builder.moveToElement(menu).build().perform();
	  WebElement menuop1= dr.findElement(By.linkText("Pay Amount Without Structure"));
	  menuop1.click();
	  dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  dr.switchTo().frame(dr.findElement(By.id("Pay Amount Without Structure")));
    } 
 
    public void searchStudent(String s1, String s2, String s3, String s4)
    {
    	Select yr = new Select(dr.findElement(year));
		yr.selectByVisibleText(s1);
		Select clss=new Select(dr.findElement(cls));
		clss.selectByVisibleText(s2);
	    Select sec= new Select(dr.findElement(section));
	    sec.selectByVisibleText(s3);
	    dr.findElement(text).sendKeys(s4);
	    dr.findElement(go).click();
	    WebElement select= dr.findElement(By.id("example"));
	    List<WebElement> options= select.findElements(By.tagName("td"));
	    System.out.println("1");
	  //  for(WebElement option: options) {
	    	//if(s4.equals(option.getText())) {
	    	//	System.out.println(option.getText());
	    		dr.findElement(By.name("ctl00$ContentPlaceHolder1$rptsearchStudent$ctl00$btn")).click();
	    	//}
	 //   }
    }
    public void selectExclusiveHead(String hd)
    {
    	dr.findElement(By.xpath("//button[@type='button']")).click();
		dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
		WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(hd.equals(option.getText()))
	  			option.click();
        dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
    }
    public void addReason(String s)
    {
    	dr.findElement(reason).sendKeys(s);
    }
    public void clickAddHead(String amt)
    {
    	dr.findElement(addhead).click();
    	WebElement select= dr.findElement(By.id("example1"));
    	List<WebElement> options = select.findElements(By.tagName("td"));
    	dr.findElement(By.name("ctl00$ContentPlaceHolder1$RptHeadDetails$ctl00$txtPaidAmt$TextBox")).clear();
    	dr.findElement(By.name("ctl00$ContentPlaceHolder1$RptHeadDetails$ctl00$txtPaidAmt$TextBox")).sendKeys(amt,Keys.ENTER);
    }
    public void clickSave()
    {
    	dr.findElement(save).click();
    }
    public void clickView()
    {
    	dr.findElement(view).click();
    }
    public void clickClear()
    {
    	dr.findElement(clear);
    }
}
