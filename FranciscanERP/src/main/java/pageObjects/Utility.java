package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	 void verifyPage(WebDriver dr, String expected)
      { 
		try { 
			Assert.assertTrue(dr.getPageSource().contains(expected));
			System.out.println("TEST PASSED");
		}
		catch(Throwable e)
		{  
	       System.out.println(e);
		   System.out.println("TEST FAILED");
		   try {
				captureScreenshot(dr,expected);
			} catch (IOException io) {
				io.printStackTrace();
			    }
		}
	}
	void captureScreenshot(WebDriver dr, String str) throws IOException
	{
		File f= ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f,new File("D:/erpscreenshots/"+str+".png"));
	}
	public void findStudentOnReport(WebDriver dr,String name)
	   {
		   WebElement rec=dr.findElement(By.xpath("//*[@id=\'ctl00_ContentPlaceHolder1_ReportViewer1_ctl05\']/div/div[3]/table"));
		   List<WebElement>cells= rec.findElements(By.tagName("td"));
		   for(WebElement cell:cells)
		   {
			   dr.findElement(By.name("ctl00$ContentPlaceHolder1$ReportViewer1$ctl05$ctl03$ctl00")).sendKeys(name);
			   dr.findElement(By.linkText("Find")).click();
			   break;
		   }
		   WebElement scroll= dr.findElement(By.name("ctl00$ContentPlaceHolder1$ReportViewer1$ctl09$ScrollPosition"));
		   JavascriptExecutor js= (JavascriptExecutor)dr;
		   js.executeScript("window.scrollBy(0,250)",scroll);
	   }
}

