package webservices;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebServicesHit {
	WebDriver dr;
    @Before
    public void launchBrowser()
    {
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
 		dr= new ChromeDriver();
 		dr.manage().window().maximize();
    }

    @Test
    public void hitWebServices() throws InterruptedException
    {
    	String s= new String("====");
    	int page=1;
    	 int j=0;
    	String url= "http://services.franciscanecare.info/service.asmx/PGPhotosOfAlbum?SchoolCode=MARYSS&Id=9&pg=";
    	for(int i=1; i<=1000; i++)
    	{ 
    		    dr.get(url+page);
    			Thread.sleep(50);
    			if(dr.getPageSource().contains("jpg")) {		
    				// s+="<br> OK "+i+ ",p="+page;
    			}
    			else
    			{
    			   s+=",On "+i+ ",p="+page;
    			   j++;
    			}
    			page++;
    			 if(page==11)
    		     	page=1;
    		
        	} 
       	System.out.println(s);
    		
    }
}
