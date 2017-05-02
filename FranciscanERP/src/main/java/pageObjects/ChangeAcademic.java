package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ChangeAcademic {
  WebDriver dr;
  By academicyear= By.id("ContentPlaceHolder1_ddlYear");
  By financialyear= By.id("ContentPlaceHolder1_ddlfinance");
  By school= By.id("ContentPlaceHolder1_ddlSchool");
  By change= By.name("ctl00$ContentPlaceHolder1$btnSave$ctl00");
  
	public ChangeAcademic(WebDriver d)
	{
		this.dr=d;
	}
	public void openChangeAcademic()
	{
		WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Master-Settings.png']"));
		Actions builder= new Actions(dr);
		builder.moveToElement(menu).build().perform();
		dr.findElement(By.linkText("Change Academic")).click();
		dr.switchTo().frame(dr.findElement(By.id("Change Academic")));
	}
	public void selectAcademicYear(String ayear)
	{
		new Select(dr.findElement(academicyear)).selectByVisibleText(ayear);
	}
	public void selectFinancialYear(String fyear)
	{
		new Select(dr.findElement(financialyear)).selectByVisibleText(fyear);
	}
	public void selectSchool(String sch)
	{
		new Select(dr.findElement(school)).selectByVisibleText(sch);
	}
	public void clickChange()
	{
		dr.findElement(change).click();
	}
}
