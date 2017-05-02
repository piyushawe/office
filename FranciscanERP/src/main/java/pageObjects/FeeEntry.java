package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class FeeEntry {
 WebDriver dr;
 String receiptno;
	 By cls= By.id("ContentPlaceHolder1_ddlClass");
	 By section= By.id("ContentPlaceHolder1_ddlSection");
	 By text = By.id("ContentPlaceHolder1_txtName");
	 By search= By.name("ctl00$ContentPlaceHolder1$SingleButton1$ctl00");
	 By feetype= By.id("ContentPlaceHolder1_ddlFeeType");
	 By bank= By.id("ContentPlaceHolder1_ddlBankName");
	 By installment= By.id("ContentPlaceHolder1_lstInstall");
	 By show= By.name("ctl00$ContentPlaceHolder1$btnShow$ctl00");
	 By show_install= By.name("ctl00$ContentPlaceHolder1$txtdetail$ctl00");
	 By save= By.name("ctl00$ContentPlaceHolder1$BtnSave$ctl00");
	 By cancel= By.id("ContentPlaceHolder1_rptReceipt_btn_0");
     By adjustadvance= By.id("ContentPlaceHolder1_ChkIsAdj");
     By waiveofffine=By.id("ContentPlaceHolder1_ChqWaive");
     By manuallatefine=By.id("ContentPlaceHolder1_chkmanuallatefne");
     By manuallatefinetext= By.id("ContentPlaceHolder1_txt_manualfine_TextBox");
     By chequebounce= By.id("ContentPlaceHolder1_chkmaulchkbounce");
     By chequebouncetext= By.id("ContentPlaceHolder1_txt_mnlchkbounce_TextBox");
     By discount= By.id("ContentPlaceHolder1_chkdiscount");
     By discounttext= By.id("ContentPlaceHolder1_txt_mnldicount_TextBox");
     By paymode= By.id("ContentPlaceHolder1_ddlPayMode");
     By school= By.id("ContentPlaceHolder1_rbtnSchool");
     By bankmode= By.id("ContentPlaceHolder1_rbtnBank");
     By online= By.id("ContentPlaceHolder1_rdoonline");
     By sms= By.id("ContentPlaceHolder1_chksms");
     By receiptclosebtn= By.xpath("//*[@id=\"form1\"]/div[4]/div[1]/a/span");
     By totalpaidamount= By.id("ContentPlaceHolder1_txtTotalPaidAmt_TextBox");
     By receiptno1= By.id("ContentPlaceHolder1_txtRid_TextBox");
 	 By admissionno1= By.id("ContentPlaceHolder1_lblAdm");
 	 By name1= By.id("ContentPlaceHolder1_lblName");
 	 By date1= By.id("ContentPlaceHolder1_txtRecDate_TextBox");
     By reusereceipt= By.id("ContentPlaceHolder1_chkReuse");
     By midyear= By.linkText("Mid Year");
     
    public FeeEntry(WebDriver d)
    {
    	this.dr=d;
    }
//discount
    public void enterDiscountAmount(String amt)
    {
    	dr.findElement(discounttext).clear();
    	dr.findElement(discounttext).sendKeys(amt);
    	dr.findElement(discount).click();
    }
//open fee entry
	public void openFeeEntry() throws InterruptedException
	{   WebElement menu;
	     menu=dr.findElement(By.xpath("//img[@src='/Images/layout/Manage-Fee.png']"));
	     Actions builder= new Actions(dr);
		 builder.moveToElement(menu).build().perform();
		 dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement menuop1= dr.findElement(By.linkText("Fee Entry"));
		 menuop1.click();
		 dr.switchTo().frame(dr.findElement(By.id("Fee Entry")));
	}
//search student
    public void searchStudent(String s1, String s2, String s3) throws InterruptedException
    {
    	Select clss=new Select(dr.findElement(cls));
		clss.selectByVisibleText(s1);
		Thread.sleep(500);
	    Select sec= new Select(dr.findElement(section));
	    sec.selectByVisibleText(s2);
	    Thread.sleep(500);
	    dr.findElement(text).clear();
	    WebElement name= dr.findElement(text);
    	name.sendKeys(s3);
    	name.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	name.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(500);
    	name.sendKeys(Keys.ENTER);
    	Thread.sleep(500);
    	//dr.findElement(search).click(); 	
    }
//select fee type
    public void selectFeeType(String s1)
    {
    	Select ftype=new Select(dr.findElement(feetype));
		ftype.selectByVisibleText(s1);
    }
//select bank name 
    public void selectBankName(String s1)
    {
		new Select(dr.findElement(bank)).selectByVisibleText(s1);
    	
    }
    public String getInstallment()
    {
    	 return dr.findElement(By.xpath("//button[@type='button']")).getText();
    }
//select installment
    public void selectInstallment(String s1) 
    {
    	dr.findElement(By.xpath("//button[@type='button']")).click();
    	dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
    	WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
		List<WebElement> options = select.findElements(By.tagName("span"));
	  	for(WebElement option:options)
	  		if(s1.equals(option.getText()))
	  			{
	  			   option.click();
	  			   System.out.println(option.getText());
	  			}
        dr.findElement(By.xpath("//a[@class='ui-multiselect-close']")).click();
    }
    public void selectMultipleInstallments(String ins)
    {
    	int inst=Integer.parseInt(ins); 
    	dr.findElement(By.xpath("//button[@type='button']")).click();
    	dr.findElement(By.xpath("//a[@class='ui-multiselect-none']")).click();
    	WebElement select= dr.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']"));
		List<WebElement> options = select.findElements(By.tagName("span"));
		for(int i=0; i<=inst-1; i++)
			options.get(i).click();
    }
//adjust advance
    public void adjustAdvance()
    {
    	dr.findElement(adjustadvance).click();
    }
//waive off fine
    public void waiveOffFine() throws InterruptedException
    {
    	dr.findElement(waiveofffine).click();
    	System.out.println("Fine waived off");
    	Thread.sleep(1000);
    }
//manual late fine
    public void manualLateFine(String fineamt)
    {   
    	dr.findElement(manuallatefinetext).clear();
    	dr.findElement(manuallatefinetext).sendKeys(fineamt);
    	dr.findElement(manuallatefine).click();
    	System.out.println("Manual Late Fine imposed: Rs."+fineamt);
    }
//cheque bounce fine waive off 
    public void chequeBounceFineWaiveOff(String bouncefine)
    {   
    	dr.findElement(chequebouncetext).clear();
        dr.findElement(chequebouncetext).sendKeys(bouncefine);
        dr.findElement(chequebounce).click();
        System.out.println("Manual Cheque Bounce Fine imposed: Rs."+bouncefine);
    }
//entry mode
    public void selectEntryMode(String mode)
    {   
    	if(mode.equals("School"))
    	   dr.findElement(school).click();
    	if(mode.equals("Bank"))
    		dr.findElement(bankmode).click();
    	if(mode.equals("Online"))
    		dr.findElement(online).click();
    }
//show details
     public void showDetails()
    {
    	dr.findElement(show).click();
    	//if(dr.getPageSource().contains("Please select student from list"))
    		 //dr.findElement(By.id("popup_ok")).click();
    }
//show installment
    public void showInstallment()
    {
    	dr.findElement(show_install).click();
    }
//pay mode
    public String selectPayMode(String s)
    {
    	String chqno="98765";
    	Select pmode=new Select(dr.findElement(paymode));
		pmode.selectByVisibleText(s);
		if(s.equalsIgnoreCase("Cheque"))
		{
		   dr.findElement(By.id("ContentPlaceHolder1_txtChqNo_TextBox")).sendKeys(chqno);
		   Select chqbank=new Select(dr.findElement(By.id("ContentPlaceHolder1_ddlChqBank")));
	       chqbank.selectByVisibleText("AXIS BANK");
		   dr.findElement(By.id("ContentPlaceHolder1_txtBranch_TextBox")).sendKeys("Noida");
		   Select depositbank= new Select(dr.findElement(By.id("ContentPlaceHolder1_ddlDepBank")));
		   depositbank.selectByVisibleText("Axsis Bank For Juniors");
		}
		return chqno;
    }
//total amount with advance
    public void totalPaidAmount(String totalamt) throws InterruptedException
    {
    	double ad= Double.parseDouble(totalamt);
    	System.out.println("advance:"+ad);
    	//System.out.println(dr.findElement(totalpaidamount).getText());
    	double amt= Double.parseDouble((dr.findElement(totalpaidamount).getAttribute("value")));
    	ad=ad+amt;
    	//System.out.println("advance:"+ad);
    	dr.findElement(totalpaidamount).clear();
    	dr.findElement(totalpaidamount).sendKeys(Double.toString(ad));
    	Thread.sleep(500);
    	dr.findElement(totalpaidamount).sendKeys(Keys.ENTER);
    	Thread.sleep(500);
    	System.out.println("Advance on Fee Entry:"+dr.findElement(By.id("ContentPlaceHolder1_txtAdvCF_TextBox")).getAttribute("value"));
    	System.out.println("Total Paid Amount: Rs"+ad);
    }
//pay amount with dues left
    public void paidLessAmount() throws InterruptedException
    {
    	double amt= Double.parseDouble((dr.findElement(totalpaidamount).getAttribute("value")));
    	amt=amt-1000;
    	dr.findElement(totalpaidamount).clear();
    	dr.findElement(totalpaidamount).sendKeys(Double.toString(amt));
    	Thread.sleep(500);
    	dr.findElement(totalpaidamount).sendKeys(Keys.ENTER);
    	Thread.sleep(500);
    	System.out.println("Total Paid Amount: Rs"+amt);
    	//verifyDues();
    }
    
    public void verifyDues()
    {
       System.out.println("Dues Left: "+dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).getAttribute("value"));
    }
    
    public String findTotalPaidAmount()
    {
    	System.out.println("Total Paid Amount: "+dr.findElement(totalpaidamount).getAttribute("value"));
    	return dr.findElement(totalpaidamount).getAttribute("value");
    }
//save  
	public String saveFee() throws InterruptedException
    {
		receiptno= dr.findElement(By.id("ContentPlaceHolder1_txtRid_TextBox")).getAttribute("value");
    	dr.findElement(save).click();
    	Thread.sleep(1000);
    	if(dr.getPageSource().contains("Please enter concession reason"))
    	{
    		dr.findElement(By.id("ContentPlaceHolder1_txtConReason_TextBox")).sendKeys("TEST");
    		dr.findElement(By.name("ctl00$ContentPlaceHolder1$BtnSaveCon$ctl00")).click();
    	}
    	dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
    	dr.findElement(receiptclosebtn).click();
    	try {
    	if(dr.findElement(By.id("popup_message")).isEnabled())
         {
    		System.out.println(dr.findElement(By.id("popup_message")).getText());
    		dr.findElement(By.id("popup_ok")).click();
    	 }
    	}catch(Exception e)
    	{
    		System.out.println("No Message Displayed");
    	}
    	return receiptno;
    }
//refresh page 
    public void pageRefesh()
    {
    	dr.findElement(cancel).click();
    }
//send sms    
    public void sendSMS()
    {
    	dr.findElement(sms);
    }
    public void verifyChequeBounceFine()
    {   
    	String cbounce="ChqBounce";
    	WebElement feedetails=dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>fdetails= feedetails.findElements(By.tagName("span"));
    	boolean flag=false;
    	for(WebElement cell: fdetails)
    	{
    		if(cbounce.equals(cell.getText()))
    			{
    			  System.out.println(cell.getText()+" Fine On Fee Entry");
    			  flag=true;
    			}
    	}
    		if(flag==false)
    			System.out.println("NO Cheque Bounce On Fee Entry");
    }   
    public void verifyChequeBounceFineOnMultipleInstallments()
    {   
    	String cbounce="ChqBounce";
    	WebElement feedetails=dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	feedetails.findElement(By.tagName("a")).click();
    	WebElement feeheads= dr.findElement(By.id("ContentPlaceHolder1_RptHeadDetails"));
    	List<WebElement>cells= feeheads.findElements(By.tagName("td"));
    	boolean flag=false;
    	for(WebElement cell:cells)
    	{
    		if(cbounce.equals(cell.getText()))
    			{
    			  System.out.println(cell.getText()+" Fine On Multiple Installments");
    			  flag=true;
    			}
    	}
    		if(flag==false)
    			System.out.println("NO Cheque Bounce On Multiple Installments");
    	dr.findElement(By.xpath("//a[@class='ui-dialog-titlebar-close ui-corner-all']")).click(); 
    }  
    public void verifyLateFine()
    {   
    	String latefine="LATE FEE";
    	WebElement feedetails=dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>fdetails= feedetails.findElements(By.tagName("span"));
    	boolean flag=false;
    	for(WebElement cell:fdetails)
    	{
    		if(cell.getText().startsWith(latefine)) {
    			System.out.println(cell.getText()+" On Fee Entry");
    		flag=true;   }
    	}
    	if(flag==false)
    		System.out.println("No Late Fee On Fee Entry");
    }  
    public void verifyAdvanceAmount(String amt)
    {
    	double amount= Double.parseDouble(dr.findElement(By.id("ContentPlaceHolder1_txtAdvBF_TextBox")).getAttribute("value"));
    	if(Double.parseDouble(amt)==amount)
    		System.out.println("Advance amount: "+amount+" is same as opening balance");
    	else
          {
    		System.out.println("Advance amount is not same.");
    	    System.out.println("Opening Balance is: "+amt);
    	    System.out.println("Advance amount on fee entry:"+amount);
          }
    }
    public void verifyAdvanceOnFeeEntry()
    {
    	String adv=dr.findElement(By.id("ContentPlaceHolder1_txtAdvCF_TextBox")).getAttribute("value"); 
    	System.out.println("Advance: "+adv);
    }
    public void verifyAdvanceOnReceipt()
    {
    	/*WebElement table= dr.findElement(By.xpath("\r\n" + 
    			"//*[@id=\"P8f6a8253c38d466fad03cbb8e4f11739_2_oReportCell\"]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[13]/td[3]/table"));
    	String adv;
    	//adv=table.findElement(By.xpath("//span[@class='Ad982c40153b0487ab9f6ce3350b6eab757']")).getText();
    	adv=table.findElement(By.tagName("td")).getText();
    	System.out.println("Advance on Fee Receipt: ");
    	System.out.print(adv);*/
    }
//verify Fine Waive Off on multiple installments
    public void verifyFineWaiveOff() throws InterruptedException
    {   
    	WebElement fee=dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	fee.findElement(By.tagName("a")).click();
    	Thread.sleep(500);
    	if(dr.getPageSource().contains("LATE FEE"))
    		System.out.println("Late Fee Not Waived Off");
    	else
    		System.out.println("Late Fee Waived Off");
    	Thread.sleep(1000);	
    	dr.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click(); 	
    }
    public void verifyStudent()throws InterruptedException
    {   
    	try {
    	if(dr.getPageSource().contains("You can not set mid year as student is old."))
	    { if(dr.getPageSource().contains("Transaction has been already done."))		
	        {  
		       dr.findElement(By.xpath("//div[@id='popup_message']")).getText();
		       System.out.println(dr.findElement(By.xpath("//div[@id='popup_message']")).getText());
		       Thread.sleep(200);
		       dr.findElement(By.id("popup_ok")).click();
	     }   }
    	}
    	catch(Exception e)
    	{
    		System.out.println("");
    	}
    }
    public void setStudentAsMidYear(String inst) throws InterruptedException
    {
    	dr.findElement(midyear).click();
    	verifyStudent();
    	int ist= Integer.parseInt(inst);
    	new Select(dr.findElement(By.id("ContentPlaceHolder1_ddlmidinstall"))).selectByIndex(ist-1);
        dr.findElement(By.id("ContentPlaceHolder1_txtmremarks_TextBox")).sendKeys("Student Admitted in Mid year");
        dr.findElement(By.name("ctl00$ContentPlaceHolder1$btnmidyear$ctl00")).click();
        dr.findElement(By.id("popup_ok")).click();
        System.out.println("STUDENT IS SET AS MID YEAR");       
    }
    public void findTotalInstallments()
    {
    	Select options= new Select(dr.findElement(installment));
    	List<WebElement>opt= options.getOptions();
    	System.out.println("Total installments: "+opt.size());
    }
    public void verifyPaySchedule(String sch)
    {
    	WebElement feedetails=dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>fdetails= feedetails.findElements(By.tagName("span"));
    	for(WebElement cell: fdetails)
    	{
    		if(sch.equals(cell.getText()))
    			System.out.println("PAY SCHEDULE: "+cell.getText());
    	}
    }
//show installment    
    public void clickShowInstallment(String r) throws InterruptedException
    {
    	System.out.println("receipt no. on show installment"+r );
    	dr.findElement(show_install).click();
    	/*try
    	{
        	if(dr.findElement(By.xpath("//div[@id='popup_message']")).isDisplayed())
          	{
    	    	dr.findElement(By.xpath("//div[@id='popup_message']")).getText();
    		    Thread.sleep(500);
    		    dr.findElement(By.id("popup_ok")).click();
    	    }
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}*/
    }
    
    public void verifyReceipt(String receiptno) throws InterruptedException
    {
    	WebElement w1=dr.findElement(By.xpath("//table[@id='Table1']"));
    	//System.out.println("3");
    	List<WebElement> allcols=w1.findElements(By.tagName("a"));
    	//System.out.println("4");
	     for (WebElement cell:allcols)
       	  {  	
		      if (cell.getText().equals(receiptno)){  
		       cell.click();  
		       break; 
          }  
    }Thread.sleep(4000);
    //dr.findElement(By.xpath("//*[@id=\'form1\']/div[4]/div[1]/a/span")).click();
    }
//select date
    public void selectDate(String mm, String yy, String dd)throws Exception
    {
    	dr.findElement(date1).click();
	  	  Thread.sleep(1000);
	  	  new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	      Thread.sleep(200);
	      new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	  Thread.sleep(200);
	  	  WebElement myw=dr.findElement(By.className("datepick"));     
	  		 List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		  for(WebElement cell: cells) {
	  			if (cell.getText().equals(dd)){  	  			
	  			cell.click();
	  			break; 
	    	 }  	  
	    }Thread.sleep(200); 
    }
//reuse receipt
    public void reuseReceipt(String reuse) throws InterruptedException
    {
    	dr.findElement(reusereceipt).click();
    	dr.findElement(By.id("ContentPlaceHolder1_txt_searchresue")).sendKeys(reuse);
    	Thread.sleep(2000);
    	dr.findElement(By.id("ContentPlaceHolder1_txt_searchresue")).sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(1000);	
    	//dr.findElement(By.id("ContentPlaceHolder1_txt_searchresue")).sendKeys(Keys.ARROW_DOWN);
    	//Thread.sleep(500);
    	dr.findElement(By.id("ContentPlaceHolder1_txt_searchresue")).sendKeys(Keys.ENTER);
    	Thread.sleep(1000);
    	dr.findElement(By.name("ctl00$ContentPlaceHolder1$btn_searchreuse$ctl00")).click();
    	Thread.sleep(2000);
    	WebElement receiptrecords= dr.findElement(By.id("tbl_reuse"));
    	List<WebElement>records= receiptrecords.findElements(By.tagName("td"));
    	for(WebElement cell: records)
    	{
    		  if(cell.getText().equals(reuse))
                 dr.findElement(By.name("ctl00$ContentPlaceHolder1$rpt_reusereceipt$ctl00$btn")).click();	
    		     break;
    	}
    }
//pay all fee except late fee
    public void lateFeeNotPaid() throws InterruptedException
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{ 
    		  i++;
    	      if(cell.getText().startsWith("LATE FEE")||cell.getText().startsWith("ChqBounce")) {
    		  System.out.println(cell.getText());  
    		  String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		  dr.findElement(By.name(name)).clear();
    		  dr.findElement(By.name(name)).sendKeys("0");
    		  Thread.sleep(500);
    		  dr.findElement(By.name(name)).sendKeys(Keys.ENTER);
    		  Thread.sleep(500);
      		}  		
    	   } r++;
      } dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
   	}
//late Fee Not Paid For Multiple Installments
    public void lateFeeNotPaidForMultipleInstallments() throws InterruptedException
    {
    	WebElement fee=dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	fee.findElement(By.tagName("a")).click();
    	WebElement feeheads= dr.findElement(By.id("ContentPlaceHolder1_RptHeadDetails"));
    	List<WebElement>rows= feeheads.findElements(By.tagName("tr"));
    	int r=1;
    	for(WebElement row:rows) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		for(WebElement cell:cells)
    		{ 
    	      if(cell.getText().startsWith("LATE FEE")||cell.getText().startsWith("ChqBounce")) {
    		  System.out.println(cell.getText());  
    		  String id="ContentPlaceHolder1_RptHeadDetails_txtmultiPaidAmt_"+(r-2)+"_TextBox_"+(r-2);
    		  //String name="ctl00$ContentPlaceHolder1$RptHeadDetails$ctl0"+r+"$txtmultiPaidAmt$TextBox";
    		  dr.findElement(By.id(id)).clear();
    		  dr.findElement(By.id(id)).sendKeys("0");
    		  Thread.sleep(500);
    		  dr.findElement(By.id(id)).sendKeys(Keys.ENTER);
    		  Thread.sleep(500);
      		}  		
    	   } r++;
    	   Thread.sleep(2000);
      } dr.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click(); 	
    }
//some head fee not paid 
    public void headFeeNotPaid(String hd) throws InterruptedException
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{ 
    		  i++;
    	      if(cell.getText().startsWith(hd)){
    		  System.out.println(cell.getText());  
    		  String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		  dr.findElement(By.name(name)).clear();
    		  dr.findElement(By.name(name)).sendKeys("0");
    		  Thread.sleep(500);
    		  dr.findElement(By.name(name)).sendKeys(Keys.ENTER);
    		  Thread.sleep(500);
      		}  		
    	   } r++;
      } dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
   	}
//pay partial late fee
    public void payPartialLateFee(String str) throws InterruptedException
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{ 
    		  i++;
    	      if(cell.getText().startsWith("LATE FEE")) {
    		  System.out.println(cell.getText());  
    		  String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		  double amt= Double.parseDouble(dr.findElement(By.name(name)).getAttribute("value"));
    		  if(str.equals("greater"))
    		           amt-=150;
    		  else
    			       amt-=50;
    		  dr.findElement(By.name(name)).clear();  
    		  dr.findElement(By.name(name)).sendKeys(Double.toString(amt));
    		  Thread.sleep(500);
    		  dr.findElement(By.name(name)).sendKeys(Keys.ENTER);
    		  Thread.sleep(500);
    		  dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
      		}  		
    	   } r++;	
      } //dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
    }
//pay partial late fee
    public void payPartialLateFee() throws InterruptedException
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{ 
    		  i++;
    	      if(cell.getText().startsWith("LATE FEE")) {
    		  System.out.println(cell.getText());  
    		  String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		  double amt= Double.parseDouble(dr.findElement(By.name(name)).getAttribute("value"));
    		  amt/=2;
    		  dr.findElement(By.name(name)).clear();  
    		  dr.findElement(By.name(name)).sendKeys(Double.toString(amt));
    		  Thread.sleep(500);
    		  dr.findElement(By.name(name)).sendKeys(Keys.ENTER);
    		  Thread.sleep(500);
    		  dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
      		}  		
    	   } r++;	
      } //dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
    }
//pay partial fee
    public void payPartialFee(String str) throws InterruptedException
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	//int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{ 
    		  //i++;
    	      if(cell.getText().equals("TUITION FEE")||cell.getText().equals(str)) {
    		  System.out.println(cell.getText());  
    		  String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		  double amt= Double.parseDouble(dr.findElement(By.name(name)).getAttribute("value"));
    		  if(str.equals("greater"))
    		           amt-=150;
    		  if(str.equals("less"))
    			       amt-=50;
    		  if(str.equals("equal to"))
    			       amt-=100;
    		  else
    			  amt/=2;
    		  dr.findElement(By.name(name)).clear();  
    		  dr.findElement(By.name(name)).sendKeys(Double.toString(amt));
    		  Thread.sleep(100);
    		  dr.findElement(By.name(name)).sendKeys(Keys.ENTER);
    		  Thread.sleep(100);
      		}  		
    	   } r++;	
      }  dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
    }
//pay only late fee leave all heads    
    public void allHeadsNotPaid() throws InterruptedException
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		if(!(row.getText().startsWith("LATE FEE")||row.getText().startsWith("Total"))) {			
    			System.out.println(row.getText()); 
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{    
    		     String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		     dr.findElement(By.name(name)).clear();
    		     dr.findElement(By.name(name)).sendKeys("0");  
    		     Thread.sleep(1000);
    		     dr.findElement(By.name(name)).sendKeys(Keys.ENTER); 
    		     Thread.sleep(500);
    		     break;  		  		
             }
            }r++;
             dr.findElement(By.id("ContentPlaceHolder1_txtleftdues_TextBox")).click();
           }
      }
//apply runtime concession
    public void applyRunTimeConcession(String hd)
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{ 
    			i++;
    			if(cell.getText().equals(hd)) {
    				System.out.println(cell.getText());
    		     String actualamt= "ContentPlaceHolder1_GVFeesHead_txtActAmt_"+(r-2); 
    		     double act_amt= Double.parseDouble(dr.findElement(By.id(actualamt)).getText());
    		     System.out.println("Actual amount: "+act_amt);
    		     String concessionamount= "ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtConAmt$TextBox";
    		     double conc_amt;
    		     conc_amt= (act_amt*50)/100;
    		     dr.findElement(By.name(concessionamount)).clear();
    		     dr.findElement(By.name(concessionamount)).sendKeys(Double.toString(conc_amt));
    		     String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		     dr.findElement(By.name(name)).click();
    		     break;  		  		
             }}
    		r++;
           }
        }
    public void verifyFeeDetails()
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    		System.out.println(row.getText());
    	}
    }
    
    public void payByPaySchedule(String sch)
    {
    	WebElement feeamount= dr.findElement(By.id("ContentPlaceHolder1_GVFeesHead"));
    	List<WebElement>rows= feeamount.findElements(By.tagName("tr"));
    	int i=0;
    	int r=1;
    	for(WebElement row:rows) {
    	//	if(!row.getText().equals(sch)) {
    		List<WebElement>cells= row.findElements(By.tagName("td"));
    		//System.out.println(cells.size());
    		for(WebElement cell:cells)
    		{ 
    			i++;
    			if(!cell.getText().equals(sch)) {
    			 System.out.println(cell.getText());
    			 String name="ctl00$ContentPlaceHolder1$GVFeesHead$ctl0"+(r)+"$txtPaidAmt$TextBox";
    		     dr.findElement(By.name(name)).clear();
    		     dr.findElement(By.name(name)).sendKeys("0");   
    		     break;  		  		
            //}
    			}	} r++;
    	  }
    }
   }
