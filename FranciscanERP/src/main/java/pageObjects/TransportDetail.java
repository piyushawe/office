package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TransportDetail {
WebDriver dr;
By route= By.id("ContentPlaceHolder1_ddlRoute");
By stop= By.id("ContentPlaceHolder1_ddlStop");
By vehicle= By.id("ContentPlaceHolder1_ddlVehicle");
By cls= By.id("ContentPlaceHolder1_ddlClass");
By section= By.id("ContentPlaceHolder1_ddlSection");
By vendor= By.id("ContentPlaceHolder1_ddlvender");
//By installment= By.id("ContentPlaceHolder1_lstInstallment");
By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");

public TransportDetail(WebDriver d)
{
	this.dr=d;
}
public void openTransportDetail() throws InterruptedException
  {
	WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
	 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Thread.sleep(6000);
	 Actions builder= new Actions(dr);
	 builder.moveToElement(menu).build().perform();
	 WebElement submenu= dr.findElement(By.linkText("Transport Report"));
	 builder.moveToElement(submenu).build().perform();
	 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 dr.findElement(By.linkText("Transport Detail")).click();
	 dr.switchTo().frame(dr.findElement(By.id("Transport Detail")));
  }
public void selectRoute(String r)
{
	Select rt= new Select(dr.findElement(route));
	rt.selectByVisibleText(r);
}
public void selectStop(String s)
{
	Select st= new Select(dr.findElement(stop));
	st.selectByVisibleText(s);
}
public void selectVehicle(String v)
{
	Select vh=new Select(dr.findElement(vehicle));
	vh.selectByVisibleText(v);
}
public void selectClass(String c)
{
	Select cs= new Select(dr.findElement(cls));
	cs.selectByVisibleText(c);
}
public void selectSection(String s)
{
	Select sec= new Select(dr.findElement(section));
	sec.selectByVisibleText(s);
}
public void selectVendor(String v)
{
	Select vn= new Select(dr.findElement(vendor));
	vn.selectByVisibleText(v);
}
public void selectInstallment(String ins)
{
   //new Select(dr.findElement(installment)).selectByVisibleText(s);
	dr.findElement(By.xpath("//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all']")).click();
	dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
    WebElement select = dr.findElement(By.cssSelector("body > div.ui-multiselect-menu.ui-widget.ui-widget-content.ui-corner-all > ul"));	
  	List<WebElement> options = select.findElements(By.tagName("span"));
  	for(WebElement option:options)
  		if(ins.equals(option.getText()))
  			option.click();
  	dr.findElement(By.xpath("//li[@class='ui-multiselect-close']")).click();
}
public void clickShow() throws InterruptedException
{
	String exp= "TRANSPORT DETAILS";
  	Utility u= new Utility(); 
    dr.findElement(show).click();
    Thread.sleep(2000);
    u.verifyPage(dr,exp);
}
}
