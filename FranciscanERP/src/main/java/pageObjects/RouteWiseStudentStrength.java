package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RouteWiseStudentStrength {
	WebDriver dr;
	By school= By.id("ContentPlaceHolder1_ddlSchool");
	//By route= By.id("ContentPlaceHolder1_lstRoute");
	//By cls= By.id("ContentPlaceHolder1_lstClass");
	//By installment= By.id("ContentPlaceHolder1_lstInstallment");
	By show= By.xpath("//*[@id=\"ContentPlaceHolder1_SingleButton1\"]/input");
	
	public RouteWiseStudentStrength(WebDriver d)
    {
    	this.dr=d;
    }
	public void openRouteWiseStudentStrength() throws InterruptedException
	 {   
	     WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Reports.png']"));
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(6000);
		 Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 dr.findElement(By.linkText("Route Wise Student Strength")).click();
		 dr.switchTo().frame(dr.findElement(By.id("Route Wise Student Strength")));
	 }
	public void selectSchool(String sch)
	{
		new Select(dr.findElement(school)).selectByVisibleText(sch);
	}
	public void selectRoute(String r)
	{
		//new Select(dr.findElement(route)).selectByVisibleText(r);
		dr.findElement(By.xpath("//*[@id=\"DivRouteId\"]/div/button")).click();
		dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/a")).click();
		WebElement select= dr.findElement(By.cssSelector("body > div:nth-child(7) > ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
		for(WebElement option:options)
	  		if(r.equals(option.getText()))
	  			option.click();
		dr.findElement(By.xpath("/html/body/div[4]/div/ul/li[3]")).click();
	}
	public void selectClass(String c)
	{
		//new Select(dr.findElement(cls)).selectByVisibleText(c);
		dr.findElement(By.xpath("//*[@id=\"MainLeftPanel\"]/div/div/div[4]/div/button")).click();
		dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
		WebElement select= dr.findElement(By.cssSelector("body > div:nth-child(6) > ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
		for(WebElement option:options)
	  		if(c.equals(option.getText()))
	  			option.click();
		dr.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]")).click();
	}
	public void selectInstallment(String inst)
	{
		//new Select(dr.findElement(installment)).selectByVisibleText(inst);
		dr.findElement(By.cssSelector("#MainLeftPanel > div > div > div:nth-child(5) > div > button")).click();
		dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li:nth-child(2) > a")).click();
		WebElement select= dr.findElement(By.cssSelector("body > div:nth-child(8) > ul"));
		List<WebElement> options = select.findElements(By.tagName("span"));
		for(WebElement option:options)
	  		if(inst.equals(option.getText()))
	  			option.click();
		dr.findElement(By.cssSelector("body > div:nth-child(8) > div > ul > li.ui-multiselect-close")).click();
	}
	public void clickShow() throws InterruptedException
	{
		String exp= "ROUTE WISE STUDENT STRENGTH";
		 Utility u= new Utility(); 
	     dr.findElement(show).click();
	     Thread.sleep(2000);
		 u.verifyPage(dr,exp);
	}
}
