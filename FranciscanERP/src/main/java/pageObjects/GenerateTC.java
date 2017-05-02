package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenerateTC {
   WebDriver dr;
   By drafttc= By.id("ContentPlaceHolder1_rdodtc");
   By generatedtc= By.id("ContentPlaceHolder1_rdogtc");
   By cancelledtc= By.id("ContentPlaceHolder1_rdo");
   public GenerateTC(WebDriver d)
   {
	   this.dr=d;
   }
   public void openGenerateTC()
   {
	   WebElement menu;
	   Actions builder= new Actions(dr);
	   menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Certificate.png']"));
	   builder.moveToElement(menu).build().perform();
	   dr.findElement(By.linkText("Generate TC")).click();
	   dr.switchTo().frame(dr.findElement(By.id("Generate TC")));
   }
   public void clickDraftTC()
   {
	   if(dr.findElement(drafttc).isSelected()) {
		   
	   }else
		   dr.findElement(drafttc).click();
   }
   public void previewDraftTC(String name) throws InterruptedException
   {
	   dr.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
	   Thread.sleep(400);
	   WebElement records= dr.findElement(By.cssSelector(".body3 > div:nth-child(1) > div:nth-child(2) > table:nth-child(2)"));
	   List<WebElement>cells= records.findElements(By.tagName("td"));
	   if(cells.size()>1) {
	   dr.findElement(By.xpath("//input[@value='Preview TC']")).click();
	   Thread.sleep(1000);
	   dr.findElement(By.id("CloseButton")).click();
	   }
	   else
		   System.out.println("No data is available"); 
   }
   public void generateTC(String name) throws InterruptedException
   {
	   dr.findElement(By.xpath("//input[@placeholder='type here...']")).sendKeys(name);
	   Thread.sleep(400);
	   WebElement records= dr.findElement(By.cssSelector(".body3 > div:nth-child(1) > div:nth-child(2) > table:nth-child(2)"));
	   List<WebElement>cells= records.findElements(By.tagName("td"));
	   if(cells.size()>1) {
	   dr.findElement(By.xpath("//input[@value='Generate TC']")).click();
	   Thread.sleep(4000);
	   dr.findElement(By.id("popup_ok")).click();;
	   Thread.sleep(500);
	   dr.findElement(By.id("popup_ok")).click();
	   }
	   else
		   System.out.println("No data is available"); 
   }
   public void clickGeneratedTC()
   {
	   if(dr.findElement(generatedtc).isSelected()) {
		   
	   }else
		   dr.findElement(generatedtc).click();
   }
   public void previewGeneratedTC(String name) throws InterruptedException
   {
	   dr.findElement(By.xpath("html/body/form/div[3]/div/div/div[4]/div[2]/div/div[2]/div[1]/div/label/input")).sendKeys(name);
	   Thread.sleep(400);
	   WebElement records= dr.findElement(By.cssSelector(".body1 > div:nth-child(1) > div:nth-child(2) > table:nth-child(2)"));
	   List<WebElement>cells= records.findElements(By.tagName("td"));
	   System.out.println(cells.size());
	   if(cells.size()>1) {
	   dr.findElement(By.xpath("//input[@value='Preview TC']")).click();
	   Thread.sleep(4000);
	   dr.findElement(By.id("CloseButton")).click();
	   }
	   else
		 System.out.println("No data is available");
   }
   public void cancelTC(String name) throws InterruptedException
   {
	   dr.findElement(By.xpath("html/body/form/div[3]/div/div/div[4]/div[2]/div/div[2]/div[1]/div/label/input")).clear();
	   dr.findElement(By.xpath("html/body/form/div[3]/div/div/div[4]/div[2]/div/div[2]/div[1]/div/label/input")).sendKeys(name);
	   Thread.sleep(400);
	   WebElement records= dr.findElement(By.cssSelector(".body1 > div:nth-child(1) > div:nth-child(2) > table:nth-child(2)"));
	   List<WebElement>cells= records.findElements(By.tagName("td"));
	   if(cells.size()>1) {
	   dr.findElement(By.xpath("//input[@value='CANCEL TC']")).click();
	   Thread.sleep(500);
	   dr.findElement(By.id("popup_ok")).click();
	   Thread.sleep(500);
	   dr.findElement(By.id("popup_ok")).click();
	   dr.findElement(By.id("ContentPlaceHolder1_txtresion")).sendKeys("TEST");
	   dr.findElement(By.name("ctl00$ContentPlaceHolder1$btncanceltc$ctl00")).click();
	   } 
	   else
		   System.out.println("No data is available");
   }
   public void clickCancelledTc()
   {
	   if(dr.findElement(cancelledtc).isSelected()) {
		   
	   }else
		   dr.findElement(cancelledtc).click();
   }
   public void searchCancelledTc(String name)
   {
	   dr.findElement(By.xpath("html/body/form/div[3]/div/div/div[4]/div[3]/div/div[2]/div[1]/div/label/input")).sendKeys(name);
   }
}
