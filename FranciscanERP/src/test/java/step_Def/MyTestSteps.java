package step_Def;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ActiveInactiveStudentsDetailReport;
import pageObjects.AdvancePaymentReport;
import pageObjects.AmountWithoutStructureReport;
import pageObjects.AnnualStudentLedger1;
import pageObjects.AnnualStudentLedger2;
import pageObjects.AnnualStudentLedger3;
import pageObjects.AnnualStudentLedgerReport;
import pageObjects.AssignConcession;
import pageObjects.AssignConcessionToStudent;
import pageObjects.AssignOpeningBalance;
import pageObjects.AssignTransportToStudents;
import pageObjects.AssignedTransportReport;
import pageObjects.BadDebtsReport;
import pageObjects.CancelFeeReceipt;
import pageObjects.CancelledFeesReceiptReport;
import pageObjects.CategoryGenderWiseStudentStrength;
import pageObjects.CategoryWiseStudentReport;
import pageObjects.Certificates;
import pageObjects.ChequeClearingStatusReport;
import pageObjects.ClassSectionTransferReport;
import pageObjects.ClassWiseMarkList;
import pageObjects.ClassWiseSiblingReport;
import pageObjects.ClassWiseStudentDetails;
import pageObjects.ClassWiseStudentStrength;
import pageObjects.DailyFeeCollection;
import pageObjects.DailyFeeCollectionAccountWise;
import pageObjects.DailyFeeCollectionDateClassWise;
import pageObjects.DailyFeeCollectionDateFeeGroupWise;
import pageObjects.DailyFeeCollectionDateWise;
import pageObjects.DateWiseAdmissionReport;
import pageObjects.DayWiseTotalCollection;
import pageObjects.DefaulterListFeeTypeWise;
import pageObjects.DeleteFeeReceipt;
import pageObjects.EstimatedCollectionReport;
import pageObjects.EstimatedTransportDetails;
import pageObjects.FeeChequeBounceReport;
import pageObjects.FeeChequeClearing;
import pageObjects.FeeCollectionWithEntryTimeConcession;
import pageObjects.FeeDefaulterInstallmentWise;
import pageObjects.FeeDefaulterList;
import pageObjects.FeeDefaulterReportConsolidated;
import pageObjects.FeeDefaulterReportWithReceiving;
import pageObjects.FeeEntry;
import pageObjects.FeeEntrySettingOthers;
import pageObjects.FeeHeadWiseCollectionClassRange;
import pageObjects.FeesConcession;
import pageObjects.FeesConcessionInstallHeadWise;
import pageObjects.FeesDefaulterSlip;
import pageObjects.FeesStudentLedger;
import pageObjects.GenderReligionWiseStudentReport;
import pageObjects.GenerateBillBookDetails;
import pageObjects.GenerateTC;
import pageObjects.GroupWiseStudentDetails;
import pageObjects.ManualFeeModification;
import pageObjects.ModifyFeeReceipt;
import pageObjects.MonthWiseCollectionReport;
import pageObjects.MonthlyConsolidatedReport;
import pageObjects.OnlinePaymentStatusReport;
import pageObjects.OpeningDuesReport;
import pageObjects.PaidTransport;
import pageObjects.PayAmountWithoutStructure;
import pageObjects.PrintFeeReceiptAndCertificate;
import pageObjects.PrintTransportIDCard;
import pageObjects.ReceiptCertificateSetting;
import pageObjects.ReceiptWiseDailyCollection;
import pageObjects.ReceiptWiseFeeTypeCollection;
import pageObjects.ReconcileInstallmentClassWise;
import pageObjects.ReconcileReport;
import pageObjects.RefundAmount;
import pageObjects.RefundHeadAmount;
import pageObjects.ReligionGenderWiseStudentStrength;
import pageObjects.RouteWiseStudentStrength;
import pageObjects.SMSReport;
import pageObjects.SelfTransportReport;
import pageObjects.SetDueLimit;
import pageObjects.SetStudentStatus;
import pageObjects.StaffWardListReport;
import pageObjects.StudentFeeDetails;
import pageObjects.StudentHealthEntryReport;
import pageObjects.StudentHouseWiseReport;
import pageObjects.StudentLedgerClassWise;
import pageObjects.StudentRegisterDateWiseReport;
import pageObjects.StudentRegistration;
import pageObjects.StudentStrengthRatioWiseReport;
import pageObjects.StudentWiseCollectionReport;
import pageObjects.StudentWiseReceiptReport;
import pageObjects.SurnameWiseStudentDetails;
import pageObjects.TCForm;
import pageObjects.TCReport;
import pageObjects.TotalCollectionReport;
import pageObjects.TransportDetail;
import pageObjects.TransportReportClassWise;
import pageObjects.TransportStudentStrengthReport;
import pageObjects.YearlyCollectionReport;

public class MyTestSteps {
public WebDriver dr;
//to store receipt no.
	String receiptno;
	String receiptno1;
	boolean flag=false;
	String chequeno;
	String installment;
	String paidamount;
   @Before
	public void launchBrowser()
	{//
        System.setProperty("webdriver.chrome.driver","D:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
	   //System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		dr= new ChromeDriver();
		dr.manage().window().maximize();
	}

	@After
	public void closeBrowser() throws InterruptedException
	{  
		//dr.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		//dr.quit();
	} 
   
   @Then("^go back to the default page$")
   public void go_back_to_the_default_page() throws Throwable {
      dr.switchTo().defaultContent();
      Thread.sleep(1000);
   }

//login	
   @Given("^user enters url\"([^\"]*)\"$")
   public void user_enters_url(String arg1) throws Throwable {	
		dr.get(arg1);
	}

	@When("^enter username\"([^\"]*)\" and password\"([^\"]*)\"$")
	public void enter_username_and_password(String arg1, String arg2) throws Throwable {
			dr.findElement(By.id("txtUserName")).sendKeys(arg1);
			dr.findElement(By.id("txtPassword")).sendKeys(arg2);
			}

	@Then("^signin$")
	public void signin() throws Throwable {
			dr.findElement(By.id("btnLogin")).click();  
			dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			}
	
//fee home page is opened
	@Then("^home page is opened$")
	public void home_page_is_opened() throws Throwable {
		    dr.findElement(By.xpath("//img[@src='images/big/Fee-Manager.png']")).click();
			dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Then("^open fee home page$")
	public void open_fee_home_page() throws Throwable {
	  WebElement menu= dr.findElement(By.xpath("//a[@class='line-ic']"));
	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform(); 
	  dr.findElement(By.linkText("Fee Manager")).click();
	  ArrayList<String>tabs= new ArrayList<String>(dr.getWindowHandles());
	  dr.switchTo().window(tabs.get(1));
	}
	
//admission home page is opened
	@Then("^admission home page is opened$")
	public void admission_home_page_is_opened() throws Throwable {
	    dr.findElement(By.xpath("//img[@src='images/big/Admission-Manager.png']")).click();
	}
	
//cancel fee receipt
	@Then("^cancel fee receipt page is opened$")
	public void cancel_fee_receipt_page_is_opened() throws Throwable {
		CancelFeeReceipt f1= new CancelFeeReceipt(dr);
		f1.openCancelFeeReceipt();
		}

	@Then("^user searches a student on cancel fee receipt form by receipt no\"([^\"]*)\"$")
	public void user_searches_a_student_on_cancel_fee_receipt_form_by_receipt_no(String arg1) throws Throwable {
		CancelFeeReceipt f1= new CancelFeeReceipt(dr);
			f1.searchReceiptByReceiptNo(arg1);
		}
	
	@Then("^user enters the reason\"([^\"]*)\" to cancel$")
	public void user_enters_the_reason_to_cancel(String arg1) throws Throwable {
		CancelFeeReceipt f1= new CancelFeeReceipt(dr);
		f1.giveReasonToCancel(arg1);
	}
   
	@Then("^user enters the reason\"([^\"]*)\" to bounce the cheque$")
	public void user_enters_the_reason_to_bounce_the_cheque(String arg1) throws Throwable {
		CancelFeeReceipt f1= new CancelFeeReceipt(dr);
		f1.giveReasonToCancel(arg1);
	}

	@Then("^user bounce the cheque with receipt no \"([^\"]*)\"$")
	public void user_bounce_the_cheque_with_receipt_no(String arg1) throws Throwable {
		CancelFeeReceipt f1= new CancelFeeReceipt(dr);
		f1.bounceCheque(arg1);
	}

	@Then("^user selects the date as month\"([^\"]*)\" year\"([^\"]*)\" and day\"([^\"]*)\" on cancel fee receipt page$")
	public void user_selects_the_date_as_month_year_and_day_on_cancel_fee_receipt_page(String arg1, String arg2, String arg3) throws Throwable {
		CancelFeeReceipt f1= new CancelFeeReceipt(dr);
		f1.selectDate(arg1, arg2, arg3);
	}

	@Then("^user cancels the receipt\"([^\"]*)\"$")
	public void user_cancels_the_receipt(String arg1) throws Throwable {
		CancelFeeReceipt f1= new CancelFeeReceipt(dr);
		f1.cancelReceipt(arg1);
	}

//pay amount without structure
	@Then("^pay amount without structure form is opened$")
	public void pay_amount_without_structure_form_is_opened() throws Throwable {
		PayAmountWithoutStructure f= new PayAmountWithoutStructure(dr);
		f.openPayAmountWithoutStructure();
	}

	@Then("^user search a student by year\"([^\"]*)\" class\"([^\"]*)\" section\"([^\"]*)\" and text\"([^\"]*)\"$")
	public void user_search_a_student_by_year_class_section_and_text(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		PayAmountWithoutStructure f= new PayAmountWithoutStructure(dr);
		f.searchStudent(arg1, arg2, arg3, arg4);
	}
	
	@Then("^user select exclusive head\"([^\"]*)\"$")
	public void user_select_exclusive_head(String arg1) throws Throwable {
		PayAmountWithoutStructure f= new PayAmountWithoutStructure(dr);
		f.selectExclusiveHead(arg1);
	}

	@Then("^give reason\"([^\"]*)\"$")
	public void give_reason(String arg1) throws Throwable {
		PayAmountWithoutStructure f= new PayAmountWithoutStructure(dr);
		f.addReason(arg1);
	}

	@Then("^click add head and enter amount \"([^\"]*)\"$")
	public void click_add_head_and_enter_amount(String arg1) throws Throwable {
		PayAmountWithoutStructure f= new PayAmountWithoutStructure(dr);
		f.clickAddHead(arg1);
	}

	@Then("^user click save on pay amount without structure form$")
	public void user_click_save_on_pay_amount_without_structure_form() throws Throwable {
		PayAmountWithoutStructure f= new PayAmountWithoutStructure(dr);
		f.clickSave();
	}
	
//Delete Fee Receipt
	@Then("^delete fee receipt page is opened$")
	public void delete_fee_receipt_page_is_opened() throws Throwable {
		DeleteFeeReceipt f1= new DeleteFeeReceipt(dr);
		f1.openDeleteFeeReceipt();
	}

	@Then("^user searches a student to delete by class\"([^\"]*)\" section\"([^\"]*)\" and student details\"([^\"]*)\"$")
	public void user_searches_a_student_to_delete_by_class_section_and_student_details1(String arg1, String arg2, String arg3) throws Throwable {
		DeleteFeeReceipt f1= new DeleteFeeReceipt(dr);
		f1.searchReceiptByName(arg1,arg2,arg3);
		Thread.sleep(5000);
	}
	
	@Then("^user searches a student to delete by receipt no\"([^\"]*)\"$")
	public void user_searches_a_student_to_delete_by_receipt_no(String arg1) throws Throwable {
		DeleteFeeReceipt f1= new DeleteFeeReceipt(dr);
		f1.searchReceiptByReceiptNo(arg1);
	}
	
	@Then("^user enters the reason\"([^\"]*)\" to delete$")
	public void user_enters_the_reason_to_delete(String arg1) throws Throwable {
		DeleteFeeReceipt f1= new DeleteFeeReceipt(dr); 
		f1.reasonToDeleteCheque(arg1);
	}

	@Then("^select search cancel fee receipt$")
	public void select_search_cancel_fee_receipt() throws Throwable {
		DeleteFeeReceipt f1= new DeleteFeeReceipt(dr);
		f1.searchCancelFeeReceipt();
	}

	@Then("^user deletes the receipt \"([^\"]*)\"$")
	public void user_deletes_the_receipt(String arg1) throws Throwable {
		DeleteFeeReceipt f= new DeleteFeeReceipt(dr);
		f.deleteReceipt(arg1);
	}

	@Then("^user deletes all the cancelled fee receipts$")
	public void user_deletes_all_the_cancelled_fee_receipts() throws Throwable {
		DeleteFeeReceipt f= new DeleteFeeReceipt(dr);
		f.deleteAllFeeReceipt();
	}
	
	@Then("^user delete all the fee receipts$")
	public void user_delete_all_the_fee_receipts() throws Throwable {
		DeleteFeeReceipt f= new DeleteFeeReceipt(dr);
		f.deleteAllFeeReceipt();
	}
	
//Fee Entry
	@Then("^fee entry form is opened$")
	public void fee_entry_form_is_opened() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.openFeeEntry();
	}

	@Then("^user searches a student on fee entry form by class\"([^\"]*)\" section\"([^\"]*)\" and student details\"([^\"]*)\"$")
	public void user_searches_a_student_on_fee_entry_form_by_class_section_and_student_details(String arg1, String arg2, String arg3) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.searchStudent(arg1, arg2, arg3);
		//System.out.println("Receipt No is:"+receiptno);
	}

	@Then("^user selects bank name\"([^\"]*)\" on fee entry$")
	public void user_selects_bank_name_on_fee_entry(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.selectBankName(arg1);
	}

	@Then("^user selects installment\"([^\"]*)\" on fee entry form$")
	public void user_selects_installment_on_fee_entry_form(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.selectInstallment(arg1);
	}

	@Then("^select entry mode\"([^\"]*)\" on fee entry form$")
	public void select_entry_mode_on_fee_entry_form(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.selectEntryMode(arg1);
	}
	
	@Then("^impose manual late fine\"([^\"]*)\"$")
	public void impose_manual_late_fine(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.manualLateFine(arg1);
	}

	@Then("^give discount of rs\"([^\"]*)\"$")
	public void give_discount_of_rs(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.enterDiscountAmount(arg1);
	}

	@Then("^click adjust advance on fee entry form$")
	public void click_adjust_advance_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.adjustAdvance();
	}

	@Then("^pay advance amount of rs\"([^\"]*)\"$")
	public void pay_advance_amount_of_rs(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
         f2.totalPaidAmount(arg1);
	}
	
	@Then("^user find total amount to be paid from fee entry page$")
	public void user_find_total_amount_to_be_paid_from_fee_entry_page() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		paidamount=f2.findTotalPaidAmount();
	}
    
	@Then("^selects pay mode\"([^\"]*)\" on fee entry form$")
	public void selects_pay_mode_on_fee_entry_form(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		chequeno=f2.selectPayMode(arg1);
	}
	
	@Then("^user select fee type \"([^\"]*)\" on fee entry page$")
	public void user_select_fee_type_on_fee_entry_page(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.selectFeeType(arg1);
	}
	
	@Then("^click on show of fee entry form$")
	public void click_on_show_of_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.showDetails();
	}
	
	@Then("^user verify late fine on fee entry form$")
	public void user_verify_late_fine_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.verifyLateFine();
	}
	
	@Then("^user selects the date as month\"([^\"]*)\" year\"([^\"]*)\" and day\"([^\"]*)\" on fee entry page$")
	public void user_selects_the_date_as_month_year_and_day_on_fee_entry_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.selectDate(arg1, arg2, arg3);
	}
	
	@Then("^user verify fee details on fee entry form$")
	public void user_verify_fee_details_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.verifyFeeDetails();
	}

	@Then("^cancel the receipt of the fee by class\"([^\"]*)\" section\"([^\"]*)\" and student details\"([^\"]*)\"$")
	public void cancel_the_receipt_of_the_fee_by_class_section_and_student_details(String arg1, String arg2, String arg3) throws Throwable {
		CancelFeeReceipt c= new CancelFeeReceipt(dr);
		c.openCancelFeeReceipt();
		c.searchReceiptByName(arg1, arg2, arg3);
		c.giveReasonToCancel("test");
		c.cancelReceipt(receiptno1);
	}
	
	@Then("^pay fee amount without any late fee or cheque bounce$")
	public void pay_fee_amount_without_any_late_fee_or_cheque_bounce() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.lateFeeNotPaid();
		f2.saveFee();
	}
	
	@Then("^make head \"([^\"]*)\" amount as zero$")
	public void make_head_amount_as_zero(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.headFeeNotPaid(arg1);
	}

	@Then("^user verify dues on fee entry page$")
	public void user_verify_dues_on_fee_entry_page() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.verifyDues();
	}

	@Then("^all late fee is paid without any head$")
	public void all_late_fee_is_paid_without_any_head() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.allHeadsNotPaid();
		f2.saveFee();
	}
	
	@Then("^pay partial late fee where amount left is greater \"([^\"]*)\" than due amount$")
	public void pay_partial_late_fee_where_amount_left_is_greater_than_due_amount(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.payPartialLateFee(arg1);
		f2.saveFee();
	}
	
	@Then("^pay partial late fee where amount left is less \"([^\"]*)\" than due amount$")
	public void pay_partial_late_fee_where_amount_left_is_less_than_due_amount(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.payPartialLateFee(arg1);
		f2.saveFee();
	}
	
	@Then("^pay partial fee where amount left is \"([^\"]*)\" than due amount$")
	public void pay_partial_fee_where_amount_left_is_than_due_amount(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.payPartialFee(arg1);
		f2.saveFee();
	}
	
	@Then("^apply runtime concession on \"([^\"]*)\" on fee entry form$")
	public void apply_runtime_concession_on_on_fee_entry_form(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.applyRunTimeConcession(arg1);
	}

	@Then("^click on save of fee entry form$")
	public void click_on_save_of_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		receiptno=f2.saveFee();
		if(flag==false)
		{
			receiptno1=receiptno;
			flag=true;
		}
	}
	
	@Then("^verify cheque bounce fine on fee entry form$")
	public void verify_cheque_bounce_fine_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyChequeBounceFine();
	}
	
	@Then("^verify advance amount \"([^\"]*)\" on fee entry page$")
	public void verify_advance_amount_on_fee_entry_page(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyAdvanceAmount(arg1);
	}
	
	@Then("^impose manual cheque bounce fine of rs \"([^\"]*)\"$")
	public void impose_manual_cheque_bounce_fine_of_rs(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.chequeBounceFineWaiveOff(arg1);
	}

	@Then("^verify advance on fee entry page$")
	public void verify_advance_on_fee_entry_page() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyAdvanceOnFeeEntry();
	}

	@Then("^partial late fee is paid on fee entry form$")
	public void partial_late_fee_is_paid_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.payPartialLateFee();
	}

	@Then("^verify advance on fee receipt$")
	public void verify_advance_on_fee_receipt() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyReceipt(receiptno);
		f2.verifyAdvanceOnReceipt();
	}
	
	@Then("^pay amount less than to be paid amount on fee entry page$")
	public void pay_amount_less_than_to_be_paid_amount_on_fee_entry_page() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.paidLessAmount();
	}
	
	@Then("^assign opening balance to student \"([^\"]*)\" of amount \"([^\"]*)\" paid amount on assign opening balance page$")
	public void assign_opening_balance_to_student_of_amount_paid_amount_on_assign_opening_balance_page(String arg1, String arg2) throws Throwable {
		AssignOpeningBalance op=new AssignOpeningBalance(dr);
		op.assignOpeningBalance(arg1, paidamount, arg2);
		op.clickSave();
	}
	
	@Then("^cancel the receipt of the fee$")
	public void cancel_the_receipt_of_the_fee() throws Throwable {
		CancelFeeReceipt c= new CancelFeeReceipt(dr);
		c.openCancelFeeReceipt();
		c.searchReceiptByReceiptNo(receiptno);
		c.giveReasonToCancel("test");
		c.cancelReceipt(receiptno);
	}
	
	@Then("^set student \"([^\"]*)\" status as \"([^\"]*)\"$")
	public void set_student_status_as(String arg1, String arg2) throws Throwable {
		SetStudentStatus s= new SetStudentStatus(dr);
	}

	@Then("^enter amount \"([^\"]*)\" to head \"([^\"]*)\" on manual fee modification page$")
	public void enter_amount_to_head_on_manual_fee_modification_page(String arg1, String arg2) throws Throwable {
		ManualFeeModification f = new ManualFeeModification(dr);
		f.enterAmountToHead(arg1, arg2);
	}

	@Then("^bounce the cheque of the fee$")
	public void bounce_the_cheque_of_the_fee() throws Throwable {
		CancelFeeReceipt c= new CancelFeeReceipt(dr);
		c.openCancelFeeReceipt();
		c.searchReceiptByReceiptNo(receiptno);
		c.giveReasonToCancel("test");
		c.bounceCheque(receiptno);
	}
	
	@Then("^bounce the cheque of the fee by class\"([^\"]*)\" section\"([^\"]*)\" and student details\"([^\"]*)\"$")
	public void bounce_the_cheque_of_the_fee_by_class_section_and_student_details(String arg1, String arg2, String arg3) throws Throwable {
		CancelFeeReceipt c= new CancelFeeReceipt(dr);
		c.openCancelFeeReceipt();
		c.searchReceiptByName(arg1, arg2, arg3);
		c.giveReasonToCancel("test");
		c.bounceCheque(receiptno1);
	}
	
	@Then("^delete the receipt of the fee$")
	public void delete_the_receipt_of_the_fee() throws Throwable {
		DeleteFeeReceipt del= new DeleteFeeReceipt(dr);
		del.openDeleteFeeReceipt();
		del.searchReceiptByReceiptNo(receiptno);
		del.reasonToDeleteCheque("test");
		del.deleteReceipt(receiptno);
	}

	@Then("^delete the receipt of the fee by class\"([^\"]*)\" section\"([^\"]*)\" and student details\"([^\"]*)\"$")
	public void delete_the_receipt_of_the_fee_by_class_section_and_student_details(String arg1, String arg2, String arg3) throws Throwable {
		DeleteFeeReceipt del= new DeleteFeeReceipt(dr);
		del.openDeleteFeeReceipt();
		del.searchReceiptByName(arg1, arg2, arg3);
		del.reasonToDeleteCheque("test");
		del.deleteReceipt(receiptno);
	}
	
	@Then("^clear the cheque on fee cheque clearing page$")
	public void clear_the_cheque_on_fee_cheque_clearing_page() throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.openFeeChequeClearingPage();
		f.byChequeNo(chequeno);
		f.clickGetDetails();
	}
	
	@Then("^user gets selected installment on fee entry form$")
	public void user_gets_selected_installment_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		installment= f2.getInstallment();
	}

	@Then("^user opens advance payment report$")
	public void user_opens_advance_payment_report() throws Throwable {
		AdvancePaymentReport p= new AdvancePaymentReport(dr);
		p.openAdvancePaymentReport();
		p.selectInstallment(installment);
	}

	@Then("^user select installment on fee entry form$")
	public void user_select_installment_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.selectInstallment(installment);
	}

	@Then("^user select installments \"([^\"]*)\" on fee entry form$")
	public void user_select_installments_on_fee_entry_form(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.selectMultipleInstallments(arg1);
	}
	
	@Then("^verify modify fee receipt$")
	public void verify_modify_fee_receipt() throws Throwable {
		ModifyFeeReceipt mf= new ModifyFeeReceipt(dr);
		mf.openModifyFeeReceipt();
		mf.searchReceiptByReceiptNo(receiptno);
	}

	@Then("^verify fine waive off on multiple installments$")
	public void verify_fine_waive_off_on_multiple_installments() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyFineWaiveOff();
	}
	
	@Then("^verify late fee on multiple installments$")
	public void verify_late_fee_on_multiple_installments() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyFineWaiveOff();
	}

	@Then("^waive off late fine on fee entry form$")
	public void waive_off_late_fine_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.waiveOffFine();
	}

	@Then("^verify cheque bounce fine on multiple installments$")
	public void verify_cheque_bounce_fine_on_multiple_installments() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyChequeBounceFineOnMultipleInstallments();
	}
	
	@Then("^user verify receipt on fee entry form$")
	public void user_verify_receipt_on_fee_entry_form() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.verifyReceipt(receiptno);
	}
	
	@Then("^user clicks on show installment button of fee entry$")
	public void user_clicks_on_show_installment_button_of_fee_entry() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.clickShowInstallment(receiptno);
		//f2.clickShowInstallment("9943");
	}
	
	@Then("^set student as a mid year from installment \"([^\"]*)\" on fee entry page$")
	public void set_student_as_a_mid_year_from_installment_on_fee_entry_page(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.setStudentAsMidYear(arg1);
	}
	
	@Then("^verify total installments on fee entry page$")
	public void verify_total_installments_on_fee_entry_page() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.findTotalInstallments();
	}

	@Then("^verify pay schedule \"([^\"]*)\" on fee entry page$")
	public void verify_pay_schedule_on_fee_entry_page(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.verifyPaySchedule(arg1);
	}

	@Then("^pay fee of multiple installments without any late fee or cheque bounce$")
	public void pay_fee_of_multiple_installments_without_any_late_fee_or_cheque_bounce() throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.lateFeeNotPaidForMultipleInstallments();
	}
	
	@Then("^pay fee by pay schedule \"([^\"]*)\" on fee entry page$")
	public void pay_fee_by_pay_schedule_on_fee_entry_page(String arg1) throws Throwable {
		FeeEntry f2= new FeeEntry(dr); 
		f2.payByPaySchedule(arg1);
	}
	

    @Then("^pay partial fee on head \"([^\"]*)\" on fee entry form$")
    public void pay_partial_fee_on_head_on_fee_entry_form(String arg1) throws Throwable {
    	FeeEntry f2= new FeeEntry(dr); 
    	f2.payPartialFee(arg1);
    }
	
	@Then("^search student by class\"([^\"]*)\" section\"([^\"]*)\" and student details\"([^\"]*)\" on manual fee modification$")
	public void search_student_by_class_section_and_student_details_on_manual_fee_modification(String arg1, String arg2, String arg3) throws Throwable {
		ManualFeeModification mod= new ManualFeeModification(dr);
		mod.openManualFeeModification();
		mod.searchStudent(arg1, arg2, arg3);
	}
	
	@Then("^verify fee certificate of \"([^\"]*)\" of class\"([^\"]*)\" section\"([^\"]*)\" on print fee receipt and cerificate$")
	public void verify_fee_certificate_of_of_class_section_on_print_fee_receipt_and_cerificate(String arg1, String arg2, String arg3) throws Throwable {
		PrintFeeReceiptAndCertificate p= new PrintFeeReceiptAndCertificate(dr);
		p.openPrintFeeReceiptAndCertificate();
		p.searchReceiptByName(arg2, arg3, arg1);
		p.printFeeCertificate(receiptno);
	}
	
	@Then("^user clicks on reuse receipt$")
	public void user_clicks_on_reuse_receipt() throws Throwable {
		FeeEntry f2= new FeeEntry(dr);
		f2.reuseReceipt(receiptno);
		//f2.reuseReceipt("10007");
	}
	
	@Then("^click enable waive off with cheque bounce$")
	public void click_enable_waive_off_with_cheque_bounce() throws Throwable {
		FeeEntrySettingOthers s= new FeeEntrySettingOthers(dr);
		s.openFeeEntrySettingOthers();
		s.clickEnableWaiveOffWithChequeBounce();
		s.clickSave();
	}
	
	@Then("^enable manual late fee for \"([^\"]*)\" installment on fee entry setting others page$")
	public void enable_manual_late_fee_for_installment_on_fee_entry_setting_others_page(String arg1) throws Throwable {
		FeeEntrySettingOthers s= new FeeEntrySettingOthers(dr);
		s.openFeeEntrySettingOthers();
		s.enableManualFee(arg1);
		s.clickSave();
	}
	
//daily fee collection
	@Then("^daily fee collection report is opened$")
	public void daily_fee_collection_report_is_opened() throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.openDailyFeeCollectionReport();
	}
	
	@Then("^user select entry mode \"([^\"]*)\" on daily fee collection$")
	public void user_select_entry_mode_on_daily_fee_collection(String arg1) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectEntryMode(arg1);
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on daily fee collection$")
	public void user_select_from_date_as_month_year_and_day_on_daily_fee_collection(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on daily fee collection$")
	public void user_select_to_date_as_month_year_and_day_on_daily_fee_collection(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select fee type \"([^\"]*)\" on daily fee collection$")
	public void user_select_fee_type_on_daily_fee_collection(String arg1) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectFeeType(arg1);
	}

	@Then("^user select paymode as \"([^\"]*)\" and \"([^\"]*)\" on daily fee collection$")
	public void user_select_paymode_as_and_on_daily_fee_collection(String arg1, String arg2) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectPayMode(arg1, arg2);
	}

	@Then("^user click head wise on daily fee collection$")
	public void user_click_head_wise_on_daily_fee_collection() throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectHeadWise();
	}

	@Then("^selects class\"([^\"]*)\" on daily fee collection$")
	public void selects_class_on_daily_fee_collection(String arg1) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectClass(arg1);
	}

	@Then("^clicks on show button of daily fee collection$")
	public void clicks_on_show_button_of_daily_fee_collection() throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.clickShow();
	}
	
	@Then("^select school\"([^\"]*)\" on daily fee collection$")
	public void select_school_on_daily_fee_collection(String arg1) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectSchool(arg1);
	}

	@Then("^select feetype\"([^\"]*)\" and\"([^\"]*)\" on daily fee collection$")
	public void select_feetype_and_on_daily_fee_collection(String arg1, String arg2) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectFeeType(arg1, arg2);
	}

	@Then("^click without head on daily fee collection$")
	public void click_without_head_on_daily_fee_collection() throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectWithoutHeadTotalAmount();
	}

	@Then("^user click with head one line on daily fee collection$")
	public void user_click_with_head_one_line_on_daily_fee_collection() throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectWithHeadOneLineData();
	}
	
	@Then("^click without head one line data on daily fee collection$")
	public void click_without_head_one_line_data_on_daily_fee_collection() throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectWithoutHeadOneLineData();
	}

	@Then("^user select user name \"([^\"]*)\" on daily fee collection$")
	public void user_select_user_name_on_daily_fee_collection(String arg1) throws Throwable {
		DailyFeeCollection f= new DailyFeeCollection(dr);
		f.selectUser(arg1);
	}

//fees cheque bounce report
	@Then("^cheque bounce report is opened$")
	public void cheque_bounce_report_is_opened() throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.openFeeChequeBounceReport();
	}
	@Then("^user select school\"([^\"]*)\" on cheque bounce report$")
	public void user_select_school_on_cheque_bounce_report(String arg1) throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.selectSchool(arg1);
	}
	
	@Then("^user select date from as month\"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on cheque bounce report$")
	public void user_select_date_from_as_month_year_and_day_on_cheque_bounce_report(String arg1, String arg2, String arg3) throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.selectDateFrom(arg1, arg2, arg3);
	}

	@Then("^user select date to as month\"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on cheque bounce report$")
	public void user_select_date_to_as_month_year_and_day_on_cheque_bounce_report(String arg1, String arg2, String arg3) throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.selectDateTo(arg1, arg2, arg3);
	}

	@Then("^user select class\"([^\"]*)\" on cheque bounce report$")
	public void user_select_class_on_cheque_bounce_report(String arg1) throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr); 
		f.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on cheque bounce report$")
	public void user_select_section_on_cheque_bounce_report(String arg1) throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.selectSection(arg1);
	}

	@Then("^user select bank name\"([^\"]*)\" on cheque bounce report$")
	public void user_select_bank_name_on_cheque_bounce_report(String arg1) throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.selectBankName(arg1);
	}
	@Then("^user select the user\"([^\"]*)\" on cheque bounce report$")
	public void user_select_the_user_on_cheque_bounce_report(String arg1) throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.selectUser(arg1);
	}

	@Then("^user click on show on cheque bounce report$")
	public void user_click_on_show_on_cheque_bounce_report() throws Throwable {
		FeeChequeBounceReport f=new FeeChequeBounceReport(dr);
		f.clickShow();
	}

//fee defaulter list
	@Then("^fee defaulter page is opened$")
	public void fee_defaulter_page_is_opened() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr); 
		list.openFeeDefaulterList();
	}

	@Then("^user selects class\"([^\"]*)\" on fee defaulter list$")
	public void user_selects_class_on_fee_defaulter_list(String arg1) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectClass(arg1);
	}

	@Then("^selects section\"([^\"]*)\" on fee defaulter list$")
	public void selects_section_on_fee_defaulter_list(String arg1) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectSection(arg1);
	}

	@Then("^selects installment\"([^\"]*)\" on fee defaulter list$")
	public void selects_installment_on_fee_defaulter_list(String arg1) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectInstallment(arg1);
	}

	@Then("^selects with fine on fee defaulter list$")
	public void selects_with_fine_on_fee_defaulter_list() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectWithFine();
	}

	@Then("^selects without head on fee defaulter list$")
	public void selects_without_head_on_fee_defaulter_list() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectWithoutHead();
	}

	@Then("^click on show on fee defaulter list$")
	public void click_on_show_on_fee_defaulter_list() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.clickShow();
	}

	@Then("^select school\"([^\"]*)\" on fee defaulter list$")
	public void select_school_on_fee_defaulter_list(String arg1) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectSchool(arg1);
	}

	@Then("^user click class range on fee defaulter list$")
	public void user_click_class_range_on_fee_defaulter_list() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.clickClassRange();
	}

	@Then("^user select class range \"([^\"]*)\" on fee defaulter list$")
	public void user_select_class_range_on_fee_defaulter_list(String arg1) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectClassRange(arg1);
	}

	@Then("^user click date range on fee defaulter list$")
	public void user_click_date_range_on_fee_defaulter_list() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectDateRange();
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter list$")
	public void user_select_from_date_as_month_year_and_day_on_fee_defaulter_list(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter list$")
	public void user_select_to_date_as_month_year_and_day_on_fee_defaulter_list(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^selects with head on fee defaulter list$")
	public void selects_with_head_on_fee_defaulter_list() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr); 
		list.selectWithHead();
	}
	@Then("^filter with cheque clearing date$")
	public void filter_with_cheque_clearing_date() throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.selectFilterWithChequeClearingDate();
	}
	@Then("^search text\"([^\"]*)\" on fee defaulter list$")
	public void search_text_on_fee_defaulter_list(String arg1) throws Throwable {
		FeeDefaulterList list= new FeeDefaulterList(dr);
		list.findtext(arg1);
	}
//total collection report
	@Then("^total collection report is opened$")
	public void total_collection_report_is_opened() throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.openTotalCollectionReport();
	}

	@Then("^user select school\"([^\"]*)\" on total collection report$")
	public void user_select_school_on_total_collection_report(String arg1) throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.selectSchool(arg1);
	}

	@Then("^user select class\"([^\"]*)\" on total collection report$")
	public void user_select_class_on_total_collection_report(String arg1) throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on total collection report$")
	public void user_select_section_on_total_collection_report(String arg1) throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.selectSection(arg1);
	}

	@Then("^user select fee type\"([^\"]*)\" on total collection report$")
	public void user_select_fee_type_on_total_collection_report(String arg1) throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.selectFeeType(arg1);
	}

	@Then("^user select installment\"([^\"]*)\" on total collection report$")
	public void user_select_installment_on_total_collection_report(String arg1) throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.selectInstallment(arg1);
	}

	@Then("^user select user\"([^\"]*)\" on total collection report$")
	public void user_select_user_on_total_collection_report(String arg1) throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.selectUser(arg1);
	}

	@Then("^user click on show on total collection report$")
	public void user_click_on_show_on_total_collection_report() throws Throwable {
		TotalCollectionReport r=new TotalCollectionReport(dr);
		r.clickShow();
	}
	
//advance payment report
	@Then("^advance payment report is opened$")
	public void advance_payment_report_is_opened() throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.openAdvancePaymentReport();
	}

	@Then("^user select installment\"([^\"]*)\" on advance payment report$")
	public void user_select_installment_on_advance_payment_report(String arg1) throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.selectInstallment(arg1);
	}

	@Then("^user select class\"([^\"]*)\" on advance payment report$")
	public void user_select_class_on_advance_payment_report(String arg1) throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on advance payment report$")
	public void user_select_section_on_advance_payment_report(String arg1) throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.selectSection(arg1);
	}

	@Then("^user select fee type\"([^\"]*)\" on advance payment report$")
	public void user_select_fee_type_on_advance_payment_report(String arg1) throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.selectFeeType(arg1);
	}

	@Then("^user select school\"([^\"]*)\" on advance payment report$")
	public void user_select_school_on_advance_payment_report(String arg1) throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.selectSchool(arg1);
	}

	@Then("^user select month\"([^\"]*)\" year\"([^\"]*)\" and day\"([^\"]*)\" on advance payment report$")
	public void user_select_month_year_and_day_on_advance_payment_report(String arg1, String arg2, String arg3) throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.selectPaymentTillDate(arg1, arg2, arg3);
	}

	@Then("^user click on show on advance payment report$")
	public void user_click_on_show_on_advance_payment_report() throws Throwable {
		AdvancePaymentReport ad=new AdvancePaymentReport(dr);
		ad.clickShow();
	}

//defaulter list fee type wise
	@Then("^defaulter list fee type wise report is opened$")
	public void defaulter_list_fee_type_wise_report_is_opened() throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr);
		lst.openDefaulterListFeeTypeWise();
	}

	@Then("^user select school\"([^\"]*)\" on defaulter list fee type wise report$")
	public void user_select_school_on_defaulter_list_fee_type_wise_report(String arg1) throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr);
		lst.selectSchool(arg1);
	}

	@Then("^user select class\"([^\"]*)\" on defaulter list fee type wise report$")
	public void user_select_class_on_defaulter_list_fee_type_wise_report(String arg1) throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr);
		lst.selectClass(arg1);
	}

	@Then("^user select installment\"([^\"]*)\" on defaulter list fee type wise report$")
	public void user_select_installment_on_defaulter_list_fee_type_wise_report(String arg1) throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr);
		lst.selectInstallment(arg1);
	}

	@Then("^user click on show on defaulter list fee type wise report$")
	public void user_click_on_show_on_defaulter_list_fee_type_wise_report() throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr);
		lst.clickShow();
	}
	@Then("^user select fee type\"([^\"]*)\" on defaulter list fee type wise report$")
	public void user_select_fee_type_on_defaulter_list_fee_type_wise_report(String arg1) throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr); 
		lst.selectFeeType(arg1);
	}

	@Then("^user select with fine on defaulter list fee type wise report$")
	public void user_select_with_fine_on_defaulter_list_fee_type_wise_report() throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr);
		lst.selectWithFine();
	}
	@Then("^user select with late fine bifurcated on defaulter list fee type wise report$")
	public void user_select_with_late_fine_bifurcated_on_defaulter_list_fee_type_wise_report() throws Throwable {
		DefaulterListFeeTypeWise lst= new DefaulterListFeeTypeWise(dr);
		lst.selectWithLateFineBifurcated();
	}

//student fee details
	@Then("^student fee details page is opened$")
	public void student_fee_details_page_is_opened() throws Throwable {
		StudentFeeDetails stu= new StudentFeeDetails(dr);
		stu.openStudentFeeDetails();
	}

	@Then("^user searches a student by class \"([^\"]*)\" section \"([^\"]*)\" and student details \"([^\"]*)\" on student fee details page$")
	public void user_searches_a_student_by_class_section_and_student_details_on_student_fee_details_page(String arg1, String arg2, String arg3) throws Throwable {
		StudentFeeDetails stu= new StudentFeeDetails(dr);
		stu.searchStudent(arg1, arg2, arg3);
	}
	
	@Then("^user select the class\"([^\"]*)\" on student fee details page$")
	public void user_select_the_class_on_student_fee_details_page(String arg1) throws Throwable {
		StudentFeeDetails stu= new StudentFeeDetails(dr);
		stu.selectClass(arg1);
	}

	@Then("^user select the section\"([^\"]*)\" on student fee details page$")
	public void user_select_the_section_on_student_fee_details_page(String arg1) throws Throwable {
		StudentFeeDetails stu= new StudentFeeDetails(dr);
		stu.selectSection(arg1);
	}

	@Then("^user enter the text\"([^\"]*)\" to search on student fee details page$")
	public void user_enter_the_text_to_search_on_student_fee_details_page(String arg1) throws Throwable {
		StudentFeeDetails stu= new StudentFeeDetails(dr);
		stu.enterText(arg1);
	}

	@Then("^user assign concession \"([^\"]*)\" on student fee details page$")
	public void user_assign_concession_on_student_fee_details_page(String arg1) throws Throwable {
		StudentFeeDetails stu= new StudentFeeDetails(dr);
		stu.assignConcession(arg1);
	}
	
	@Then("^user click on search on student fee details page$")
	public void user_click_on_search_on_student_fee_details_page() throws Throwable {
		StudentFeeDetails stu= new StudentFeeDetails(dr);
		stu.clickSearch();
	}

//fee cheque clearing
	@Then("^user opens fee cheque clearing page$")
	public void user_opens_fee_cheque_clearing_page() throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.openFeeChequeClearingPage();
	}

	@Then("^user get details by receipt date as month\"([^\"]*)\" year\"([^\"]*)\" and day\"([^\"]*)\"$")
	public void user_get_details_by_receipt_date_as_month_year_and_day(String arg1, String arg2, String arg3) throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.byReceiptdate(arg1, arg2, arg3);
	}
	
	@Then("^user get details by cheque date as month\"([^\"]*)\" year\"([^\"]*)\" and day\"([^\"]*)\"$")
	public void user_get_details_by_cheque_date_as_month_year_and_day(String arg1, String arg2, String arg3) throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.byChequeDate(arg1, arg2, arg3);
	}
	
	@Then("^user get details by cheque no\"([^\"]*)\"$")
	public void user_get_details_by_cheque_no(String arg1) throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.byChequeNo(arg1);
		f.clickGetDetails();
	}

	@Then("^user get details by deposit bank\"([^\"]*)\"$")
	public void user_get_details_by_deposit_bank(String arg1) throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.byDepositBank(arg1);
		f.clickGetDetails();
	}

	@Then("^user enter clearing date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fee cheque clearing page$")
	public void user_enter_clearing_date_as_month_year_and_day_on_fee_cheque_clearing_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.enterChequeClearingDetails(arg1, arg2, arg3);
	}

	@Then("^user click save on fee cheque clearing page$")
	public void user_click_save_on_fee_cheque_clearing_page() throws Throwable {
		FeeChequeClearing f= new FeeChequeClearing(dr);
		f.clicksave();
	}

//cheque clearing status report
	@Then("^cheque clearing status report is opened$")
	public void cheque_clearing_status_report_is_opened() throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.openChequeClearingStatusReport();
	}
	
	@Then("^user select from date as month\"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on cheque clearing status report$")
	public void user_select_from_date_as_month_year_and_day_on_cheque_clearing_status_report(String arg1, String arg2, String arg3) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month\"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on cheque clearing status report$")
	public void user_select_to_date_as_month_year_and_day_on_cheque_clearing_status_report(String arg1, String arg2, String arg3) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select class\"([^\"]*)\" on cheque clearing status report$")
	public void user_select_class_on_cheque_clearing_status_report(String arg1) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.selectClass(arg1);
	}
	
	@Then("^user select entry mode \"([^\"]*)\" on cheque clearing status report$")
	public void user_select_entry_mode_on_cheque_clearing_status_report(String arg1) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.selectEntryMode(arg1);
	}

	@Then("^user select bank name \"([^\"]*)\" on cheque clearing status report$")
	public void user_select_bank_name_on_cheque_clearing_status_report(String arg1) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.selectBankName(arg1);
	}
	
	@Then("^user select fee type \"([^\"]*)\" on cheque clearing status report$")
	public void user_select_fee_type_on_cheque_clearing_status_report(String arg1) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.selectFeeType(arg1);
	}

	@Then("^user click head wise on cheque clearing status report$")
	public void user_click_head_wise_on_cheque_clearing_status_report() throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.clickHeadWise();
	}
	
	@Then("^user select clearing status \"([^\"]*)\" on cheque clearing status report$")
	public void user_select_clearing_status_on_cheque_clearing_status_report(String arg1) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.selectClearingStatus(arg1);
	}

	@Then("^user click receipt number range on cheque clearing status report$")
	public void user_click_receipt_number_range_on_cheque_clearing_status_report() throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.clickReceiptNoRange();
	}

	@Then("^user enter receipt from \"([^\"]*)\" and receipt to \"([^\"]*)\" on cheque clearing status report$")
	public void user_enter_receipt_from_and_receipt_to_on_cheque_clearing_status_report(String arg1, String arg2) throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.enterReceiptRange(arg1, arg2);
	}

	@Then("^user click without head total amount on cheque clearing status report$")
	public void user_click_without_head_total_amount_on_cheque_clearing_status_report() throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.clickWithOutHeadTotalAmount();
	}
	
	@Then("^user click show on cheque clearing status report$")
	public void user_click_show_on_cheque_clearing_status_report() throws Throwable {
		ChequeClearingStatusReport ch= new ChequeClearingStatusReport(dr);
		ch.clickShow();
	}

//cancelled fees receipt report
	@Then("^user opens cancelled fees receipt report page$")
	public void user_opens_cancelled_fees_receipt_report_page() throws Throwable {
		CancelledFeesReceiptReport cf= new CancelledFeesReceiptReport(dr);
		cf.openCancelledFeesReceiptReport();
	}

	@Then("^user selects from date as month\"([^\"]*)\" year\"([^\"]*)\" and day\"([^\"]*)\"$")
	public void user_selects_from_date_as_month_year_and_day(String arg1, String arg2, String arg3) throws Throwable {
		CancelledFeesReceiptReport cf= new CancelledFeesReceiptReport(dr);
		cf.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user selects to date as month\"([^\"]*)\" year\"([^\"]*)\" and day\"([^\"]*)\"$")
	public void user_selects_to_date_as_month_year_and_day(String arg1, String arg2, String arg3) throws Throwable {
		CancelledFeesReceiptReport cf= new CancelledFeesReceiptReport(dr);
		cf.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user clicks on show$")
	public void user_clicks_on_show() throws Throwable {
		CancelledFeesReceiptReport cf= new CancelledFeesReceiptReport(dr);
		cf.clickShow();
	}
	
	@Then("^user enter name \"([^\"]*)\" and click find on cancelled fees receipt report page$")
	public void user_enter_name_and_click_find_on_cancelled_fees_receipt_report_page(String arg1) throws Throwable {
		CancelledFeesReceiptReport cf= new CancelledFeesReceiptReport(dr);
		cf.findStudent(arg1);
	}

//amount without structure report
	@Then("^amount without structure report is opened$")
	public void amount_without_structure_report_is_opened() throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.openAmountWithoutStructureReport();
	}
	
	@Then("^user select date from as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on amount without structure report$")
	public void user_select_date_from_as_month_year_and_day_on_amount_without_structure_report(String arg1, String arg2, String arg3) throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.selectDateFrom(arg1, arg2, arg3);
	}

	@Then("^user select date to as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on amount without structure report$")
	public void user_select_date_to_as_month_year_and_day_on_amount_without_structure_report(String arg1, String arg2, String arg3) throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.selectDateTo(arg1, arg2, arg3);
	}

	@Then("^user select class \"([^\"]*)\" on amount without structure report$")
	public void user_select_class_on_amount_without_structure_report(String arg1) throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on amount without structure report$")
	public void user_select_section_on_amount_without_structure_report(String arg1) throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.selectSection(arg1);
	}

	@Then("^user select school \"([^\"]*)\" on amount without structure report$")
	public void user_select_school_on_amount_without_structure_report(String arg1) throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.selectSchool(arg1);
	}

	@Then("^user select year \"([^\"]*)\" on amount without structure report$")
	public void user_select_year_on_amount_without_structure_report(String arg1) throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.selectYear(arg1);
	}

	@Then("^user click cancel fee on amount without structure report$")
	public void user_click_cancel_fee_on_amount_without_structure_report() throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.clickCancelFee();
	}

	@Then("^user click show on amount without structure report$")
	public void user_click_show_on_amount_without_structure_report() throws Throwable {
		AmountWithoutStructureReport r= new AmountWithoutStructureReport(dr);
		r.clickShow();
	}


//yearly collection report
	@Then("^user opens yearly collection report page$")
	public void user_opens_yearly_collection_report_page() throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.openYearlyCollectionReport();
	}
	
	@Then("^user select entry mode \"([^\"]*)\" on yearly collection report$")
	public void user_select_entry_mode_on_yearly_collection_report(String arg1) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.selectEntryMode(arg1);
	}

	@Then("^user select pay mode as \"([^\"]*)\" and \"([^\"]*)\" on yearly collection report$")
	public void user_select_pay_mode_as_and_on_yearly_collection_report(String arg1, String arg2) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.selectPayMode(arg1, arg2);
	}

	@Then("^user select bank name \"([^\"]*)\" on yearly collection report$")
	public void user_select_bank_name_on_yearly_collection_report(String arg1) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.selectBankName(arg1);
	}

	@Then("^user select session\"([^\"]*)\" on yearly collection report$")
	public void user_select_session_on_yearly_collection_report(String arg1) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.selectSession(arg1);
	}

	@Then("^user select class\"([^\"]*)\" on yearly collection report$")
	public void user_select_class_on_yearly_collection_report(String arg1) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on yearly collection report$")
	public void user_select_section_on_yearly_collection_report(String arg1) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.selectSection(arg1);
	}
	
	@Then("^user select fee type\"([^\"]*)\" on yearly collection report$")
	public void user_select_fee_type_on_yearly_collection_report(String arg1) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
        yr.selectFeeType(arg1);
	}

	@Then("^user select school\"([^\"]*)\" on yearly collection report$")
	public void user_select_school_on_yearly_collection_report(String arg1) throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
        yr.selectSchool(arg1);
	}

	@Then("^user checks on filter with clearing date$")
	public void user_checks_on_filter_with_clearing_date() throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.checkFilterWithChqClearingDate();
	}
	
	@Then("^user click on show on yearly collection report$")
	public void user_click_on_show_on_yearly_collection_report() throws Throwable {
		YearlyCollectionReport yr= new YearlyCollectionReport(dr);
		yr.clickShow();
	}
	
//daily fee collection date class wise
	@Then("^user opens daily fee collection date class wise report$")
	public void user_opens_daily_fee_collection_date_class_wise_report() throws Throwable {
		DailyFeeCollectionDateClassWise d= new DailyFeeCollectionDateClassWise(dr);
		d.openDailyFeeCollectionDateClassWise();
	}

	@Then("^user select class\"([^\"]*)\" on daily fee collection date class wise report$")
	public void user_select_class_on_daily_fee_collection_date_class_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateClassWise d= new DailyFeeCollectionDateClassWise(dr);
		d.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on daily fee collection date class wise report$")
	public void user_select_section_on_daily_fee_collection_date_class_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateClassWise d= new DailyFeeCollectionDateClassWise(dr);
		d.selectSection(arg1);
	}
	
	@Then("^user enter student\"([^\"]*)\" on daily fee collection date class wise report$")
	public void user_enter_student_on_daily_fee_collection_date_class_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateClassWise d= new DailyFeeCollectionDateClassWise(dr);
		d.searchStudent(arg1);
	}

	@Then("^user select order by\"([^\"]*)\" on daily fee collection date class wise report$")
	public void user_select_order_by_on_daily_fee_collection_date_class_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateClassWise d= new DailyFeeCollectionDateClassWise(dr);
		d.selectOrderBy(arg1);
	}

	@Then("^user select user\"([^\"]*)\" on daily fee collection date class wise report$")
	public void user_select_user_on_daily_fee_collection_date_class_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateClassWise d= new DailyFeeCollectionDateClassWise(dr);
		d.selectUser(arg1);
	}

	@Then("^user click on show on daily fee collection date class wise report$")
	public void user_click_on_show_on_daily_fee_collection_date_class_wise_report() throws Throwable {
		DailyFeeCollectionDateClassWise d= new DailyFeeCollectionDateClassWise(dr);
		d.clickShow();
	}

//student wise collection report
	@Then("^student wise collection report is opened$")
	public void student_wise_collection_report_is_opened() throws Throwable {
		StudentWiseCollectionReport s= new StudentWiseCollectionReport(dr);
		s.openStudentWiseCollectionReport();
	}
	
	@Then("^user select class\"([^\"]*)\" on student wise collection report$")
	public void user_select_class_on_student_wise_collection_report(String arg1) throws Throwable {
		StudentWiseCollectionReport s= new StudentWiseCollectionReport(dr);
		s.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on student wise collection report$")
	public void user_select_section_on_student_wise_collection_report(String arg1) throws Throwable {
		StudentWiseCollectionReport s= new StudentWiseCollectionReport(dr);
		s.selectSection(arg1);
	}

	@Then("^user fee type\"([^\"]*)\" on student wise collection report$")
	public void user_fee_type_on_student_wise_collection_report(String arg1) throws Throwable {
		StudentWiseCollectionReport s= new StudentWiseCollectionReport(dr);
		s.selectFeeType(arg1);
	}

	@Then("^user select school\"([^\"]*)\" on student wise collection report$")
	public void user_select_school_on_student_wise_collection_report(String arg1) throws Throwable {
		StudentWiseCollectionReport s= new StudentWiseCollectionReport(dr);
		s.selectSchool(arg1);
	}

	@Then("^user click on show on student wise collection report$")
	public void user_click_on_show_on_student_wise_collection_report() throws Throwable {
		StudentWiseCollectionReport s= new StudentWiseCollectionReport(dr);
		s.clickShow();
	}

//class wise student details
	@Then("^class wise student details report is opened$")
	public void class_wise_student_details_report_is_opened() throws Throwable {
		ClassWiseStudentDetails sd= new ClassWiseStudentDetails(dr);
		sd.openClassWiseStudentDetails();
	}

	@Then("^user select school \"([^\"]*)\" on class wise student details$")
	public void user_select_school_on_class_wise_student_details(String arg1) throws Throwable {
		ClassWiseStudentDetails sd= new ClassWiseStudentDetails(dr);
		sd.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on class wise student details$")
	public void user_select_class_on_class_wise_student_details(String arg1) throws Throwable {
		ClassWiseStudentDetails sd= new ClassWiseStudentDetails(dr);
		sd.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on class wise student details$")
	public void user_select_section_on_class_wise_student_details(String arg1) throws Throwable {
		ClassWiseStudentDetails sd= new ClassWiseStudentDetails(dr);
		sd.selectSection(arg1);
	}

	@Then("^user click is day scholar boarding show on report on class wise student details$")
	public void user_click_is_day_scholar_boarding_show_on_report_on_class_wise_student_details() throws Throwable {
		ClassWiseStudentDetails sd= new ClassWiseStudentDetails(dr);
		sd.clickIsDayScholarBoarding();
	}
	
	@Then("^user click on show on class wise student details$")
	public void user_click_on_show_on_class_wise_student_details() throws Throwable {
		ClassWiseStudentDetails sd= new ClassWiseStudentDetails(dr);
		sd.clickShow();
	}

//class section transfer report
	@Then("^class section transfer report is opened$")
	public void class_section_transfer_report_is_opened() throws Throwable {
		ClassSectionTransferReport cst= new ClassSectionTransferReport(dr);
		cst.openClassSectionTransferReport();
	}

	@Then("^user select class \"([^\"]*)\" on class section transfer report$")
	public void user_select_class_on_class_section_transfer_report(String arg1) throws Throwable {
		ClassSectionTransferReport cst= new ClassSectionTransferReport(dr);
		cst.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on class section transfer report$")
	public void user_select_section_on_class_section_transfer_report(String arg1) throws Throwable {
		ClassSectionTransferReport cst= new ClassSectionTransferReport(dr);
		cst.selectSection(arg1);
	}

	@Then("^user select old academic year \"([^\"]*)\" on class section transfer report$")
	public void user_select_old_academic_year_on_class_section_transfer_report(String arg1) throws Throwable {
		ClassSectionTransferReport cst= new ClassSectionTransferReport(dr);
		cst.selectOldAcademicYear(arg1);
	}

	@Then("^user select old financial year \"([^\"]*)\" on class section transfer report$")
	public void user_select_old_financial_year_on_class_section_transfer_report(String arg1) throws Throwable {
		ClassSectionTransferReport cst= new ClassSectionTransferReport(dr);
		cst.selectOldFinancialYear(arg1);
	}

	@Then("^user click on show on class section transfer report$")
	public void user_click_on_show_on_class_section_transfer_report() throws Throwable {
		ClassSectionTransferReport cst= new ClassSectionTransferReport(dr);
		cst.clickShow();
	}

//class wise sibling report
	@Then("^class wise sibling report is opened$")
	public void class_wise_sibling_report_is_opened() throws Throwable {
		ClassWiseSiblingReport sbr= new ClassWiseSiblingReport(dr); 
		sbr.openClassWiseSiblingReport();
	}

	@Then("^user select class \"([^\"]*)\" on class wise sibling report$")
	public void user_select_class_on_class_wise_sibling_report(String arg1) throws Throwable {
		ClassWiseSiblingReport sbr= new ClassWiseSiblingReport(dr); 
		sbr.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on class wise sibling report$")
	public void user_select_section_on_class_wise_sibling_report(String arg1) throws Throwable {
		ClassWiseSiblingReport sbr= new ClassWiseSiblingReport(dr); 
		sbr.selectSection(arg1);
	}

	@Then("^user click on show on class wise sibling report$")
	public void user_click_on_show_on_class_wise_sibling_report() throws Throwable {
		ClassWiseSiblingReport sbr= new ClassWiseSiblingReport(dr); 
		sbr.clickShow();
	}
	
//refund amount
	@Then("^refund amount page is opened$")
	public void refund_amount_page_is_opened() throws Throwable {
		RefundAmount r= new RefundAmount(dr);
		r.openRefundAmount();
	}

	@Then("^user select from date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on refund amount page$")
	public void user_select_from_date_as_month_year_and_day_on_refund_amount_page(String arg1, String arg2, String arg3) throws Throwable {
		RefundAmount r= new RefundAmount(dr);
		r.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\"on refund amount page$")
	public void user_select_to_date_as_month_year_and_day_on_refund_amount_page(String arg1, String arg2, String arg3) throws Throwable {
		RefundAmount r= new RefundAmount(dr);
		r.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select year as \"([^\"]*)\" on refund amount page$")
	public void user_select_year_as_on_refund_amount_page(String arg1) throws Throwable {
		RefundAmount r= new RefundAmount(dr);
		r.selectYear(arg1);
	}

	@Then("^user click on show on refund amount page$")
	public void user_click_on_show_on_refund_amount_page() throws Throwable {
		RefundAmount r= new RefundAmount(dr);
		r.clickShow();
	}

//sms report
	@Then("^sms report page is opened$")
	public void sms_report_page_is_opened() throws Throwable {
		SMSReport sr= new SMSReport(dr);
		sr.openSMSReport();
	}

	@Then("^user select from date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on sms report$")
	public void user_select_from_date_as_month_year_and_day_on_sms_report(String arg1, String arg2, String arg3) throws Throwable {
		SMSReport sr= new SMSReport(dr);
		sr.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on sms report$")
	public void user_select_to_date_as_month_year_and_day_on_sms_report(String arg1, String arg2, String arg3) throws Throwable {
		SMSReport sr= new SMSReport(dr);
		sr.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select sms type \"([^\"]*)\" on sms report$")
	public void user_select_sms_type_on_sms_report(String arg1) throws Throwable {
		SMSReport sr= new SMSReport(dr);
		sr.selectSMSType(arg1);
	}

	@Then("^user click on show on sms report$")
	public void user_click_on_show_on_sms_report() throws Throwable {
		SMSReport sr= new SMSReport(dr);
		sr.clickShow();
	}

//opening dues report
	@Then("^opening dues report page is opened$")
	public void opening_dues_report_page_is_opened() throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.openOpeningDuesReport();
	}

	@Then("^user select class\"([^\"]*)\" on opening dues report$")
	public void user_select_class_on_opening_dues_report(String arg1) throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on opening dues report$")
	public void user_select_section_on_opening_dues_report(String arg1) throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.selectSection(arg1);
	}

	@Then("^user select installment\"([^\"]*)\" on opening dues report$")
	public void user_select_installment_on_opening_dues_report(String arg1) throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.selectInstallment(arg1);
	}

	@Then("^user select school \"([^\"]*)\" on opening dues report$")
	public void user_select_school_on_opening_dues_report(String arg1) throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.selectSchool(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on opening dues report$")
	public void user_select_fee_type_on_opening_dues_report(String arg1) throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.selectFeeType(arg1);
	}

	@Then("^user select user \"([^\"]*)\" on opening dues report$")
	public void user_select_user_on_opening_dues_report(String arg1) throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.selectUser(arg1);
	}
	
	@Then("^user click on show on opening dues report$")
	public void user_click_on_show_on_opening_dues_report() throws Throwable {
		OpeningDuesReport od= new OpeningDuesReport(dr);
		od.clickShow();
	}
	
//category wise student report
	@Then("^category wise student report page is opened$")
	public void category_wise_student_report_page_is_opened() throws Throwable {
		CategoryWiseStudentReport r= new CategoryWiseStudentReport(dr);
		r.openCategoryWiseStudentReport();
	}

	@Then("^user select category\"([^\"]*)\" on category wise student report page$")
	public void user_select_category_on_category_wise_student_report_page(String arg1) throws Throwable {
		CategoryWiseStudentReport r= new CategoryWiseStudentReport(dr);
		r.selectCategory(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on category wise student report page$")
	public void user_select_class_on_category_wise_student_report_page(String arg1) throws Throwable {
		CategoryWiseStudentReport r= new CategoryWiseStudentReport(dr);
		r.selectClass(arg1);
	}

	@Then("^select section \"([^\"]*)\" on category wise student report page$")
	public void select_section_on_category_wise_student_report_page(String arg1) throws Throwable {
		CategoryWiseStudentReport r= new CategoryWiseStudentReport(dr); 
		r.selectSection(arg1);
	}

	@Then("^select father profession\"([^\"]*)\" on category wise student report page$")
	public void select_father_profession_on_category_wise_student_report_page(String arg1) throws Throwable {
		CategoryWiseStudentReport r= new CategoryWiseStudentReport(dr); 
		r.selectFatherProfession(arg1);
	}

	@Then("^user click on show on category wise student report page$")
	public void user_click_on_show_on_category_wise_student_report_page() throws Throwable {
		CategoryWiseStudentReport r= new CategoryWiseStudentReport(dr);
		r.clickShow();
	}

//gender religion wise student report
	@Then("^gender religion wise student report page is opened$")
	public void gender_religion_wise_student_report_page_is_opened() throws Throwable {
		GenderReligionWiseStudentReport gr= new GenderReligionWiseStudentReport(dr);
		gr.openGenderReligionWiseStudentReport();
	}

	@Then("^user select religion\"([^\"]*)\" on gender religion wise student report page$")
	public void user_select_religion_on_gender_religion_wise_student_report_page(String arg1) throws Throwable {
		GenderReligionWiseStudentReport gr= new GenderReligionWiseStudentReport(dr);
		gr.selectReligion(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on gender religion wise student report page$")
	public void user_select_class_on_gender_religion_wise_student_report_page(String arg1) throws Throwable {
		GenderReligionWiseStudentReport gr= new GenderReligionWiseStudentReport(dr);
		gr.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on gender religion wise student report page$")
	public void user_select_section_on_gender_religion_wise_student_report_page(String arg1) throws Throwable {
		GenderReligionWiseStudentReport gr= new GenderReligionWiseStudentReport(dr);
		gr.selectSection(arg1);
	}

	@Then("^user select gender\"([^\"]*)\" on gender religion wise student report page$")
	public void user_select_gender_on_gender_religion_wise_student_report_page(String arg1) throws Throwable {
		GenderReligionWiseStudentReport gr= new GenderReligionWiseStudentReport(dr);
		gr.selectGender(arg1);
	}

	@Then("^user click show on gender religion wise student report page$")
	public void user_click_show_on_gender_religion_wise_student_report_page() throws Throwable {
		GenderReligionWiseStudentReport gr= new GenderReligionWiseStudentReport(dr);
		gr.clickShow();
	}

//date wise admission report
	@Then("^date wise admission report page is opened$")
	public void date_wise_admission_report_page_is_opened() throws Throwable {
		DateWiseAdmissionReport d= new DateWiseAdmissionReport(dr);
		d.openDateWiseAdmissionReport();
	}

	@Then("^user select from date as month\"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on admission report page$")
	public void user_select_from_date_as_month_year_and_day_on_admission_report_page(String arg1, String arg2, String arg3) throws Throwable {
		DateWiseAdmissionReport d= new DateWiseAdmissionReport(dr);
		d.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month\"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on admission report page$")
	public void user_select_to_date_as_month_year_and_day_on_admission_report_page(String arg1, String arg2, String arg3) throws Throwable {
		DateWiseAdmissionReport d= new DateWiseAdmissionReport(dr);
		d.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select class\"([^\"]*)\" on admission report page$")
	public void user_select_class_on_admission_report_page(String arg1) throws Throwable {
		DateWiseAdmissionReport d= new DateWiseAdmissionReport(dr);
		d.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on admission report page$")
	public void user_select_section_on_admission_report_page(String arg1) throws Throwable {
		DateWiseAdmissionReport d= new DateWiseAdmissionReport(dr);
		d.selectSection(arg1);
	}

	@Then("^user click show on admission report page$")
	public void user_click_show_on_admission_report_page() throws Throwable {
		DateWiseAdmissionReport d= new DateWiseAdmissionReport(dr);
		d.clickShow();
	}

//staff ward list report
	@Then("^staff ward list report page is opened$")
	public void staff_ward_list_report_page_is_opened() throws Throwable {
		StaffWardListReport sw= new StaffWardListReport(dr);
		sw.openDateWiseAdmissionReport();
	}

	@Then("^user select class \"([^\"]*)\" on staff ward list report$")
	public void user_select_class_on_staff_ward_list_report(String arg1) throws Throwable {
		StaffWardListReport sw= new StaffWardListReport(dr);
		sw.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on staff ward list report$")
	public void user_select_section_on_staff_ward_list_report(String arg1) throws Throwable {
		StaffWardListReport sw= new StaffWardListReport(dr);
		sw.selectSection(arg1);
	}

	@Then("^user select staff ward \"([^\"]*)\" on staff ward list report$")
	public void user_select_staff_ward_on_staff_ward_list_report(String arg1) throws Throwable {
		StaffWardListReport sw= new StaffWardListReport(dr);
		sw.selectStaffWard(arg1);
	}

	@Then("^user click show on staff ward list report$")
	public void user_click_show_on_staff_ward_list_report() throws Throwable {
		StaffWardListReport sw= new StaffWardListReport(dr);
		sw.clickShow();
	}

//student register date wise report
	@Then("^student register date wise report page is opened$")
	public void student_register_date_wise_report_page_is_opened() throws Throwable {
		StudentRegisterDateWiseReport rd= new StudentRegisterDateWiseReport(dr);
		rd.openStudentRegisterDateWiseReport();
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on student register date wise report$")
	public void user_select_from_date_as_month_year_and_day_on_student_register_date_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		StudentRegisterDateWiseReport rd= new StudentRegisterDateWiseReport(dr);
		rd.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on student register date wise report$")
	public void user_select_to_date_as_month_year_and_day_on_student_register_date_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		StudentRegisterDateWiseReport rd= new StudentRegisterDateWiseReport(dr);
		rd.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select class \"([^\"]*)\" on student register date wise report$")
	public void user_select_class_on_student_register_date_wise_report(String arg1) throws Throwable {
		StudentRegisterDateWiseReport rd= new StudentRegisterDateWiseReport(dr);
		rd.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on student register date wise report$")
	public void user_select_section_on_student_register_date_wise_report(String arg1) throws Throwable {
		StudentRegisterDateWiseReport rd= new StudentRegisterDateWiseReport(dr);
		rd.selectSection(arg1);
	}

	@Then("^user click show on student register date wise report$")
	public void user_click_show_on_student_register_date_wise_report() throws Throwable {
		StudentRegisterDateWiseReport rd= new StudentRegisterDateWiseReport(dr);
		rd.clickShow();
	}

//assigned transport report
	@Then("^assigned transport report page is opened$")
	public void assigned_transport_report_page_is_opened() throws Throwable {
		AssignedTransportReport tr= new AssignedTransportReport(dr);
		tr.openAssignedTransportReport();
	}

	@Then("^user select class\"([^\"]*)\" on assigned transport report page$")
	public void user_select_class_on_assigned_transport_report_page(String arg1) throws Throwable {
		AssignedTransportReport tr= new AssignedTransportReport(dr);
		tr.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on assigned transport report page$")
	public void user_select_section_on_assigned_transport_report_page(String arg1) throws Throwable {
		AssignedTransportReport tr= new AssignedTransportReport(dr);
		tr.selectSection(arg1);
	}

	@Then("^user select user \"([^\"]*)\" on assigned transport report page$")
	public void user_select_user_on_assigned_transport_report_page(String arg1) throws Throwable {
		AssignedTransportReport tr= new AssignedTransportReport(dr);
		tr.selectUser(arg1);
	}

	@Then("^user select month\"([^\"]*)\" on assigned transport report page$")
	public void user_select_month_on_assigned_transport_report_page(String arg1) throws Throwable {
		AssignedTransportReport tr= new AssignedTransportReport(dr);
		tr.selectMonth(arg1);
	}

	@Then("^user enter \"([^\"]*)\" in search text box on assigned transport report page$")
	public void user_enter_in_search_text_box_on_assigned_transport_report_page(String arg1) throws Throwable {
		AssignedTransportReport tr= new AssignedTransportReport(dr);
		tr.enterSearchText(arg1);
	}

	@Then("^user click show on assigned transport report page$")
	public void user_click_show_on_assigned_transport_report_page() throws Throwable {
		AssignedTransportReport tr= new AssignedTransportReport(dr);
		tr.clickShow();
	}

//transport detail
	@Then("^assigned transport detail report page is opened$")
	public void assigned_transport_detail_report_page_is_opened() throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.openTransportDetail();
	}

	@Then("^user select route\"([^\"]*)\" on transport detail report page$")
	public void user_select_route_on_transport_detail_report_page(String arg1) throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.selectRoute(arg1);
	}

	@Then("^user select stop\"([^\"]*)\" on transport detail report page$")
	public void user_select_stop_on_transport_detail_report_page(String arg1) throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.selectStop(arg1);
	}

	@Then("^user select vehicle \"([^\"]*)\" on transport detail report page$")
	public void user_select_vehicle_on_transport_detail_report_page(String arg1) throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.selectVehicle(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on transport detail report page$")
	public void user_select_class_on_transport_detail_report_page(String arg1) throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on transport detail report page$")
	public void user_select_section_on_transport_detail_report_page(String arg1) throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.selectSection(arg1);
	}

	@Then("^user select vendor \"([^\"]*)\" on transport detail report page$")
	public void user_select_vendor_on_transport_detail_report_page(String arg1) throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.selectVendor(arg1);
	}

	@Then("^user select installment\"([^\"]*)\" on transport detail report page$")
	public void user_select_installment_on_transport_detail_report_page(String arg1) throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.selectInstallment(arg1);
	}

	@Then("^user click show on transport detail report page$")
	public void user_click_show_on_transport_detail_report_page() throws Throwable {
		TransportDetail t= new TransportDetail(dr);
		t.clickShow();
	}

//self transport report
	@Then("^self transport report page is opened$")
	public void self_transport_report_page_is_opened() throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.openSelfTransportReport();
	}

	@Then("^user select transport \"([^\"]*)\"	on self transport report$")
	public void user_select_transport_on_self_transport_report(String arg1) throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.selectTransport(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on self transport report$")
	public void user_select_class_on_self_transport_report(String arg1) throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on self transport report$")
	public void user_select_section_on_self_transport_report(String arg1) throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.selectSection(arg1);
	}

	@Then("^user click active on self transport report$")
	public void user_click_active_on_self_transport_report() throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.clickActive();
	}

	@Then("^user click show on self transport report$")
	public void user_click_show_on_self_transport_report() throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.clickShow();
	}

	@Then("^user click inactive on self transport report$")
	public void user_click_inactive_on_self_transport_report() throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.clickInActive();
	}
	
	@Then("^user click all on self transport report$")
	public void user_click_all_on_self_transport_report() throws Throwable {
		SelfTransportReport st= new SelfTransportReport(dr);
		st.clickAll();
	}

//student house wise report
	@Then("^student house wise report page is opened$")
	public void student_house_wise_report_page_is_opened() throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.openStudentHouseWiseReport();
	}

	@Then("^user select class\"([^\"]*)\" on student house wise report page$")
	public void user_select_class_on_student_house_wise_report_page(String arg1) throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.selectClass(arg1);
	}

	@Then("^user select house \"([^\"]*)\" on student house wise report page$")
	public void user_select_house_on_student_house_wise_report_page(String arg1) throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.selectHouse(arg1);
	}

	@Then("^user click active on student house wise report page$")
	public void user_click_active_on_student_house_wise_report_page() throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.clickActive();
	}

	@Then("^user click section wise on student house wise report page$")
	public void user_click_section_wise_on_student_house_wise_report_page() throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.clickSectionWise();
	}

	@Then("^user select section\"([^\"]*)\" on student house wise report page$")
	public void user_select_section_on_student_house_wise_report_page(String arg1) throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.selectSection(arg1);
	}

	@Then("^user click inactive on student house wise report page$")
	public void user_click_inactive_on_student_house_wise_report_page() throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.clickInActive();
	}

	@Then("^user click show on student house wise report page$")
	public void user_click_show_on_student_house_wise_report_page() throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.clickShow();
	}
	
	@Then("^user select range\"([^\"]*)\" on student house wise report page$")
	public void user_select_range_on_student_house_wise_report_page(String arg1) throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.rangeType(arg1);
	}

	@Then("^user select age \"([^\"]*)\" on student house wise report page$")
	public void user_select_age_on_student_house_wise_report_page(String arg1) throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.selectAge(arg1);
	}

	@Then("^user click all on student house wise report page$")
	public void user_click_all_on_student_house_wise_report_page() throws Throwable {
		StudentHouseWiseReport sh= new StudentHouseWiseReport(dr);
		sh.clickAll();
	}

//class wise student strength
	@Then("^class wise student strength page is opened$")
	public void class_wise_student_strength_page_is_opened() throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.openClassWiseStudentStrength();
	}

	@Then("^user click row wise on class wise student strength page$")
	public void user_click_row_wise_on_class_wise_student_strength_page() throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.clickRowWise();
	}

	@Then("^user select class \"([^\"]*)\" on class wise student strength page$")
	public void user_select_class_on_class_wise_student_strength_page(String arg1) throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.selectClass(arg1);
	}

	@Then("^user click show on class wise student strength page$")
	public void user_click_show_on_class_wise_student_strength_page() throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.clickShow();
	}
	
	@Then("^user select date wise on class wise student strength page$")
	public void user_select_date_wise_on_class_wise_student_strength_page() throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.checkDateWise();
	}

	@Then("^user select date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on class wise student strength page$")
	public void user_select_date_as_month_year_and_day_on_class_wise_student_strength_page(String arg1, String arg2, String arg3) throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.selectDate(arg1, arg2, arg3);
	}

	@Then("^user click column wise on class wise student strength page$")
	public void user_click_column_wise_on_class_wise_student_strength_page() throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.clickColumnWise();
	}

	@Then("^user click section wise on class wise student strength page$")
	public void user_click_section_wise_on_class_wise_student_strength_page() throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.clickSectionWise();
	}
	
	@Then("^user check on new students on class wise student strength page$")
	public void user_check_on_new_students_on_class_wise_student_strength_page() throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.clickNewStudents();
	}
	
	@Then("^user select section \"([^\"]*)\" on class wise student strength page$")
	public void user_select_section_on_class_wise_student_strength_page(String arg1) throws Throwable {
		ClassWiseStudentStrength str= new ClassWiseStudentStrength(dr);
		str.selectSection(arg1);
	}

//category gender wise student strength
	@Then("^category gender wise student strength report is opened$")
	public void category_gender_wise_student_strength_report_is_opened() throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.openCategoryGenderWiseStudentStrength();
	}

	@Then("^user select class \"([^\"]*)\" on category gender wise student strength report$")
	public void user_select_class_on_category_gender_wise_student_strength_report(String arg1) throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.selectClass(arg1);
	}

	@Then("^user click on category wise category gender wise student strength report$")
	public void user_click_on_category_wise_category_gender_wise_student_strength_report() throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.clickCategoryWise();
	}

	@Then("^user click show on category gender wise student strength report$")
	public void user_click_show_on_category_gender_wise_student_strength_report() throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.clickShow();
	}

	@Then("^user click gender wise on category gender wise student strength report$")
	public void user_click_gender_wise_on_category_gender_wise_student_strength_report() throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.clickGenderWise();
	}

	@Then("^user check click for section wise checkbox on category gender wise student strength report$")
	public void user_check_click_for_section_wise_checkbox_on_category_gender_wise_student_strength_report() throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.checkClickForSectionwise();
	}

	@Then("^user select section \"([^\"]*)\" on category gender wise student strength report$")
	public void user_select_section_on_category_gender_wise_student_strength_report(String arg1) throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.selectSection(arg1);
	}

	@Then("^user click on category and gender wise on category gender wise student strength report$")
	public void user_click_on_category_and_gender_wise_on_category_gender_wise_student_strength_report() throws Throwable {
		CategoryGenderWiseStudentStrength cgw= new CategoryGenderWiseStudentStrength(dr);
		cgw.clickCategoryAndGenderWise();
	}
	
//religion gender wise student strength
	@Then("^religion gender wise student strength report is opened$")
	public void religion_gender_wise_student_strength_report_is_opened() throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.openCategoryGenderWiseStudentStrength();
	}

	@Then("^user select class \"([^\"]*)\" on religion gender wise student strength report$")
	public void user_select_class_on_religion_gender_wise_student_strength_report(String arg1) throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.selectClass(arg1);
	}

	@Then("^user click religion wise on religion gender wise student strength report$")
	public void user_click_religion_wise_on_religion_gender_wise_student_strength_report() throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.clickReligionWise();
	}

	@Then("^user click show on religion gender wise student strength report$")
	public void user_click_show_on_religion_gender_wise_student_strength_report() throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.clickShow();
	}

	@Then("^user click gender wise on religion gender wise student strength report$")
	public void user_click_gender_wise_on_religion_gender_wise_student_strength_report() throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.clickGenderWise();
	}

	@Then("^user check click for section wise checkbox on religion gender wise student strength report$")
	public void user_check_click_for_section_wise_checkbox_on_religion_gender_wise_student_strength_report() throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.checkClickForSectionwise();
	}

	@Then("^user select section \"([^\"]*)\" on religion gender wise student strength report$")
	public void user_select_section_on_religion_gender_wise_student_strength_report(String arg1) throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.selectSection(arg1);
	}

	@Then("^user click religion and gender wise on religion gender wise student strength report$")
	public void user_click_religion_and_gender_wise_on_religion_gender_wise_student_strength_report() throws Throwable {
		ReligionGenderWiseStudentStrength rgw= new ReligionGenderWiseStudentStrength(dr);
		rgw.clickReligionAndGenderWise();
	}

//transport student strength report
	@Then("^transport student strength report is opened$")
	public void transport_student_strength_report_is_opened() throws Throwable {
		TransportStudentStrengthReport ts= new TransportStudentStrengthReport(dr);
		ts.openTransportStudentStrengthReport();
	}

	@Then("^user select class \"([^\"]*)\" on transport student strength report$")
	public void user_select_class_on_transport_student_strength_report(String arg1) throws Throwable {
		TransportStudentStrengthReport ts= new TransportStudentStrengthReport(dr);
		ts.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on transport student strength report$")
	public void user_select_section_on_transport_student_strength_report(String arg1) throws Throwable {
		TransportStudentStrengthReport ts= new TransportStudentStrengthReport(dr);
		ts.selectSection(arg1);
	}

	@Then("^user select route \"([^\"]*)\" on transport student strength report$")
	public void user_select_route_on_transport_student_strength_report(String arg1) throws Throwable {
		TransportStudentStrengthReport ts= new TransportStudentStrengthReport(dr);
		ts.selectRoute(arg1);
	}

	@Then("^user click show on transport student strength report$")
	public void user_click_show_on_transport_student_strength_report() throws Throwable {
		TransportStudentStrengthReport ts= new TransportStudentStrengthReport(dr);
		ts.clickShow();
	}

//active inactive student details report
	@Then("^active inactive students detail report is opened$")
	public void active_inactive_students_detail_report_is_opened() throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.openActiveInactiveStudentsDetailReport();
	}

	@Then("^user select class \"([^\"]*)\" on active inactive students detail report page$")
	public void user_select_class_on_active_inactive_students_detail_report_page(String arg1) throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on active inactive students detail report page$")
	public void user_select_section_on_active_inactive_students_detail_report_page(String arg1) throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.selectSection(arg1);
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on active inactive students detail report page$")
	public void user_select_from_date_as_month_year_and_day_on_active_inactive_students_detail_report_page(String arg1, String arg2, String arg3) throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select till date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on active inactive students detail report page$")
	public void user_select_till_date_as_month_year_and_day_on_active_inactive_students_detail_report_page(String arg1, String arg2, String arg3) throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click active on active inactive students detail report page$")
	public void user_click_active_on_active_inactive_students_detail_report_page() throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.clickActive();
	}

	@Then("^user select user \"([^\"]*)\" on active inactive students detail report is opened$")
	public void user_select_user_on_active_inactive_students_detail_report_is_opened(String arg1) throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.selectUser(arg1);
	}


	@Then("^user click inactive on active inactive students detail report page$")
	public void user_click_inactive_on_active_inactive_students_detail_report_page() throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.clickInActive();
	}

	@Then("^user click show on active inactive students detail report page$")
	public void user_click_show_on_active_inactive_students_detail_report_page() throws Throwable {
		ActiveInactiveStudentsDetailReport ai= new ActiveInactiveStudentsDetailReport(dr);
		ai.clickShow();
	}

//student strength wise ratio report
	@Then("^student strength ratio wise report is opened$")
	public void student_strength_ratio_wise_report_is_opened() throws Throwable {
		StudentStrengthRatioWiseReport sr= new StudentStrengthRatioWiseReport(dr);
		sr.openStudentStrengthRatioWiseReport();
	}

	@Then("^user select class \"([^\"]*)\" on student strength ratio wise report$")
	public void user_select_class_on_student_strength_ratio_wise_report(String arg1) throws Throwable {
		StudentStrengthRatioWiseReport sr= new StudentStrengthRatioWiseReport(dr);
		sr.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on student strength ratio wise report$")
	public void user_select_section_on_student_strength_ratio_wise_report(String arg1) throws Throwable {
		StudentStrengthRatioWiseReport sr= new StudentStrengthRatioWiseReport(dr);
		sr.selectSection(arg1);
	}

	@Then("^user select date to as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\"on student strength ratio wise report$")
	public void user_select_date_to_as_month_year_and_day_on_student_strength_ratio_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		StudentStrengthRatioWiseReport sr= new StudentStrengthRatioWiseReport(dr);
		sr.selectDate(arg1, arg2, arg3);
	}

	@Then("^user click details with new old student status on student strength ratio wise report$")
	public void user_click_details_with_new_old_student_status_on_student_strength_ratio_wise_report() throws Throwable {
		StudentStrengthRatioWiseReport sr= new StudentStrengthRatioWiseReport(dr);
		sr.clickDetailsWithNewOldStudentStatus();
	}

	@Then("^user click show on student strength ratio wise report$")
	public void user_click_show_on_student_strength_ratio_wise_report() throws Throwable {
		StudentStrengthRatioWiseReport sr= new StudentStrengthRatioWiseReport(dr);
		sr.clickShow();
	}

//print transport ID card
	@Then("^print transport ID card page is opened$")
	public void print_transport_ID_card_page_is_opened() throws Throwable {
		PrintTransportIDCard pt= new PrintTransportIDCard(dr);
		pt.openPrintTransportIDCard();
	}

	@Then("^user select school \"([^\"]*)\" on print transport ID card page$")
	public void user_select_school_on_print_transport_ID_card_page(String arg1) throws Throwable {
		PrintTransportIDCard pt= new PrintTransportIDCard(dr);
		pt.selectSchool(arg1);
	}
	
	@Then("^user select class \"([^\"]*)\" on print transport ID card page$")
	public void user_select_class_on_print_transport_ID_card_page(String arg1) throws Throwable {
		PrintTransportIDCard pt= new PrintTransportIDCard(dr);
		pt.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on print transport ID card page$")
	public void user_select_section_on_print_transport_ID_card_page(String arg1) throws Throwable {
		PrintTransportIDCard pt= new PrintTransportIDCard(dr);
		pt.selectSection(arg1);
	}

	@Then("^user enter student \"([^\"]*)\" on print transport ID card page$")
	public void user_enter_student_on_print_transport_ID_card_page(String arg1) throws Throwable {
		PrintTransportIDCard pt= new PrintTransportIDCard(dr);
		pt.enterStudent(arg1);
	}

	@Then("^user click show on print transport ID card page$")
	public void user_click_show_on_print_transport_ID_card_page() throws Throwable {
		PrintTransportIDCard pt= new PrintTransportIDCard(dr);
		pt.clickShow();
	}

//annual student ledger1
	@Then("^annual student ledger(\\d+) page is opened$")
	public void annual_student_ledger_page_is_opened(int arg1) throws Throwable {
		AnnualStudentLedger1 a= new AnnualStudentLedger1(dr);
		a.openAnnualStudentLedger1();
	}

	@Then("^user select class\"([^\"]*)\" on annual student ledger(\\d+) page$")
	public void user_select_class_on_annual_student_ledger_page(String arg1, int arg2) throws Throwable {
		AnnualStudentLedger1 a= new AnnualStudentLedger1(dr);
		a.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on annual student ledger(\\d+) page$")
	public void user_select_section_on_annual_student_ledger_page(String arg1, int arg2) throws Throwable {
		AnnualStudentLedger1 a= new AnnualStudentLedger1(dr);
		a.selectSection(arg1);
	}

	@Then("^user enter the student \"([^\"]*)\" to search on annual student ledger(\\d+) page$")
	public void user_enter_the_student_to_search_on_annual_student_ledger_page(String arg1, int arg2) throws Throwable {
		AnnualStudentLedger1 a= new AnnualStudentLedger1(dr);
		a.enterStudentDetails(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on annual student ledger(\\d+) page$")
	public void user_select_fee_type_on_annual_student_ledger_page(String arg1, int arg2) throws Throwable {
		AnnualStudentLedger1 a= new AnnualStudentLedger1(dr);
		a.selectFeeType(arg1);
	}

	@Then("^user click show on annual student ledger(\\d+) page$")
	public void user_click_show_on_annual_student_ledger_page(int arg1) throws Throwable {
		AnnualStudentLedger1 a= new AnnualStudentLedger1(dr);
		a.clickShow();
	}

//annual student ledger2
	@Then("^annual student ledger two page is opened$")
	public void annual_student_ledger_two_page_is_opened() throws Throwable {
		AnnualStudentLedger2 a= new AnnualStudentLedger2(dr);
		a.openAnnualStudentLedger2();
	}

	@Then("^user select class\"([^\"]*)\" on annual student ledger two page$")
	public void user_select_class_on_annual_student_ledger_two_page(String arg1) throws Throwable {
		AnnualStudentLedger2 a= new AnnualStudentLedger2(dr);
		a.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on annual student ledger two page$")
	public void user_select_section_on_annual_student_ledger_two_page(String arg1) throws Throwable {
		AnnualStudentLedger2 a= new AnnualStudentLedger2(dr);
		a.selectSection(arg1);
	}

	@Then("^user enter the student \"([^\"]*)\" to search on annual student ledger two page$")
	public void user_enter_the_student_to_search_on_annual_student_ledger_two_page(String arg1) throws Throwable {
		AnnualStudentLedger2 a= new AnnualStudentLedger2(dr);
		a.enterStudentDetails(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on annual student ledger two page$")
	public void user_select_fee_type_on_annual_student_ledger_two_page(String arg1) throws Throwable {
		AnnualStudentLedger2 a= new AnnualStudentLedger2(dr);
		a.selectFeeType(arg1);
	}

	@Then("^user click show on annual student ledger two page$")
	public void user_click_show_on_annual_student_ledger_two_page() throws Throwable {
		AnnualStudentLedger2 a= new AnnualStudentLedger2(dr);
		a.clickShow();
	}

//annual student ledger3
	@Then("^annual student ledger three page is opened$")
	public void annual_student_ledger_three_page_is_opened() throws Throwable {
		AnnualStudentLedger3 a= new AnnualStudentLedger3(dr);
		a.openAnnualStudentLedger3();
	}

	@Then("^user select installment \"([^\"]*)\" on annual student ledger three page$")
	public void user_select_installment_on_annual_student_ledger_three_page(String arg1) throws Throwable {
		AnnualStudentLedger3 a= new AnnualStudentLedger3(dr);
		a.selectInstallment(arg1);
	}

	@Then("^user select class\"([^\"]*)\" on annual student ledger three page$")
	public void user_select_class_on_annual_student_ledger_three_page(String arg1) throws Throwable {
		AnnualStudentLedger3 a= new AnnualStudentLedger3(dr);
		a.selectClass(arg1);
	}

	@Then("^user select section\"([^\"]*)\" on annual student ledger three page$")
	public void user_select_section_on_annual_student_ledger_three_page(String arg1) throws Throwable {
		AnnualStudentLedger3 a= new AnnualStudentLedger3(dr);
		a.selectSection(arg1);
	}

	@Then("^user click show on annual student ledger three page$")
	public void user_click_show_on_annual_student_ledger_three_page() throws Throwable {
		AnnualStudentLedger3 a= new AnnualStudentLedger3(dr);
		a.clickShow();
	}

//fees student ledger
	@Then("^fees student ledger page is opened$")
	public void fees_student_ledger_page_is_opened() throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.openAnnualStudentLedger3();
	}

	@Then("^user select class\"([^\"]*)\" on fees student ledger page$")
	public void user_select_class_on_fees_student_ledger_page(String arg1) throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.selectClass(arg1);
	}

	@Then("^user enter student \"([^\"]*)\" to search on fees student ledger page$")
	public void user_enter_student_to_search_on_fees_student_ledger_page(String arg1) throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.searchStudent(arg1);
	}

	@Then("^user select fee type\"([^\"]*)\" on fees student ledger page$")
	public void user_select_fee_type_on_fees_student_ledger_page(String arg1) throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.selectFeeType(arg1);
	}

	@Then("^user select till date as month\"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fees student ledger page$")
	public void user_select_till_date_as_month_year_and_day_on_fees_student_ledger_page(String arg1, String arg2, String arg3) throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click without head on fees student ledger page$")
	public void user_click_without_head_on_fees_student_ledger_page() throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.clickWithoutHead();
	}
	
	@Then("^user click with head on fees student ledger page$")
	public void user_click_with_head_on_fees_student_ledger_page() throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.clickWithHead();
	}

	@Then("^user click show on fees student ledger page$")
	public void user_click_show_on_fees_student_ledger_page() throws Throwable {
		FeesStudentLedger fs= new FeesStudentLedger(dr);
		fs.clickShow();
	}

//student ledger class wise
	@Then("^student ledger class wise page is opened$")
	public void student_ledger_class_wise_page_is_opened() throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.openStudentLedgerClassWise();
	}

	@Then("^user select school \"([^\"]*)\" on student ledger class wise page$")
	public void user_select_school_on_student_ledger_class_wise_page(String arg1) throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on student ledger class wise page$")
	public void user_select_class_on_student_ledger_class_wise_page(String arg1) throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on student ledger class wise page$")
	public void user_select_section_on_student_ledger_class_wise_page(String arg1) throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.selectSection(arg1);
	}

	@Then("^user select with fine on student ledger class wise page$")
	public void user_select_with_fine_on_student_ledger_class_wise_page() throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.clickWithFine();
	}
	
	@Then("^user select fee type \"([^\"]*)\" on student ledger class wise page$")
	public void user_select_fee_type_on_student_ledger_class_wise_page(String arg1) throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.selectFeeType(arg1);
	}

	@Then("^user select only full fear paid fees on student ledger class wise page$")
	public void user_select_only_full_fear_paid_fees_on_student_ledger_class_wise_page() throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.clickOnlyFullYearPaidFees();
	}

	@Then("^user click show on student ledger class wise page$")
	public void user_click_show_on_student_ledger_class_wise_page() throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.clickShow();
	}

	@Then("^user select installment \"([^\"]*)\" on student ledger class wise page$")
	public void user_select_installment_on_student_ledger_class_wise_page(String arg1) throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.selectInstallment(arg1);
	}

	@Then("^user select date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on student ledger class wise page$")
	public void user_select_date_as_month_year_and_day_on_student_ledger_class_wise_page(String arg1, String arg2, String arg3) throws Throwable {
		StudentLedgerClassWise sl= new StudentLedgerClassWise(dr);
		sl.selectTilldate(arg1, arg2, arg3);
	}

//annual student ledger report
	@Then("^annual student ledger report page is opened$")
	public void annual_student_ledger_report_page_is_opened() throws Throwable {
		AnnualStudentLedgerReport a= new AnnualStudentLedgerReport(dr);
		a.openAnnualStudentLedgerReport();
	}

	@Then("^user select installment \"([^\"]*)\" on annual student ledger report page$")
	public void user_select_installment_on_annual_student_ledger_report_page(String arg1) throws Throwable {
		AnnualStudentLedgerReport a= new AnnualStudentLedgerReport(dr);
		a.selectInstallment(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on annual student ledger report page$")
	public void user_select_class_on_annual_student_ledger_report_page(String arg1) throws Throwable {
		AnnualStudentLedgerReport a= new AnnualStudentLedgerReport(dr);
		a.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on annual student ledger report page$")
	public void user_select_section_on_annual_student_ledger_report_page(String arg1) throws Throwable {
		AnnualStudentLedgerReport a= new AnnualStudentLedgerReport(dr);
		a.selectSection(arg1);
	}

	@Then("^user click show on annual student ledger report page$")
	public void user_click_show_on_annual_student_ledger_report_page() throws Throwable {
		AnnualStudentLedgerReport a= new AnnualStudentLedgerReport(dr);
		a.clickShow();
	}

//fee defaulter report with receiving
	@Then("^fee defaulter report with receiving page is opened$")
	public void fee_defaulter_report_with_receiving_page_is_opened() throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.openFeeDefaulterReportWithReceiving();
	}

	@Then("^user select class \"([^\"]*)\" on fee defaulter report with receiving page$")
	public void user_select_class_on_fee_defaulter_report_with_receiving_page(String arg1) throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on fee defaulter report with receiving page$")
	public void user_select_section_on_fee_defaulter_report_with_receiving_page(String arg1) throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectSection(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on fee defaulter report with receiving page$")
	public void user_select_fee_type_on_fee_defaulter_report_with_receiving_page(String arg1) throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectFeeType(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on fee defaulter report with receiving page$")
	public void user_select_installment_on_fee_defaulter_report_with_receiving_page(String arg1) throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectInstallment(arg1);
	}

	@Then("^user select till date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter report with receiving page$")
	public void user_select_till_date_as_month_year_and_day_on_fee_defaulter_report_with_receiving_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click with fine on fee defaulter report with receiving page$")
	public void user_click_with_fine_on_fee_defaulter_report_with_receiving_page() throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.clickWithFine();
	}

	@Then("^user select school \"([^\"]*)\" on fee defaulter report with receiving page$")
	public void user_select_school_on_fee_defaulter_report_with_receiving_page(String arg1) throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectSchool(arg1);
	}

	@Then("^user click date range on fee defaulter report with receiving page$")
	public void user_click_date_range_on_fee_defaulter_report_with_receiving_page() throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectDateRange();
	}

	@Then("^user select from date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter report with receiving page$")
	public void user_select_from_date_as_month_year_and_day_on_fee_defaulter_report_with_receiving_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user click show on fee defaulter report with receiving page$")
	public void user_click_show_on_fee_defaulter_report_with_receiving_page() throws Throwable {
		FeeDefaulterReportWithReceiving fd= new FeeDefaulterReportWithReceiving(dr);
		fd.clickShow();
	}

//fee defaulter installment wise
	@Then("^fee defaulter installment wise page is opened$")
	public void fee_defaulter_installment_wise_page_is_opened() throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.openFeeDefaulterInstallmentWise();
	}

	@Then("^user select school \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_school_on_fee_defaulter_installment_wise_page(String arg1) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_class_on_fee_defaulter_installment_wise_page(String arg1) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_section_on_fee_defaulter_installment_wise_page(String arg1) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectSection(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_installment_on_fee_defaulter_installment_wise_page(String arg1) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectInstallment(arg1);
	}

	@Then("^user click date range on fee defaulter installment wise page$")
	public void user_click_date_range_on_fee_defaulter_installment_wise_page() throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectDateRange();
	}

	@Then("^user select from date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_from_date_as_month_year_and_day_on_fee_defaulter_installment_wise_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select till date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_till_date_as_month_year_and_day_on_fee_defaulter_installment_wise_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click with fine on fee defaulter installment wise page$")
	public void user_click_with_fine_on_fee_defaulter_installment_wise_page() throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.clickWithFine();
	}

	@Then("^user select fee type \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_fee_type_on_fee_defaulter_installment_wise_page(String arg1) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectFeeType(arg1);
	}

	@Then("^user select route \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_route_on_fee_defaulter_installment_wise_page(String arg1) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectRoute(arg1);
	}

	@Then("^user select vehicle \"([^\"]*)\" on fee defaulter installment wise page$")
	public void user_select_vehicle_on_fee_defaulter_installment_wise_page(String arg1) throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.selectVehicle(arg1);
	}

	@Then("^user click show on fee defaulter installment wise page$")
	public void user_click_show_on_fee_defaulter_installment_wise_page() throws Throwable {
		FeeDefaulterInstallmentWise fd= new FeeDefaulterInstallmentWise(dr);
		fd.clickShow();
	}

//fee defaulter report consolidated 
	@Then("^fee defaulter report consolidated page is opened$")
	public void fee_defaulter_report_consolidated_page_is_opened() throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.openFeeDefaulterReportConsolidated();
	}

	@Then("^user select school \"([^\"]*)\" on fee defaulter report consolidated page$")
	public void user_select_school_on_fee_defaulter_report_consolidated_page(String arg1) throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on fee defaulter report consolidated page$")
	public void user_select_class_on_fee_defaulter_report_consolidated_page(String arg1) throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on fee defaulter report consolidated page$")
	public void user_select_section_on_fee_defaulter_report_consolidated_page(String arg1) throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectSection(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on fee defaulter report consolidated page$")
	public void user_select_fee_type_on_fee_defaulter_report_consolidated_page(String arg1) throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectFeeType(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on fee defaulter report consolidated page$")
	public void user_select_installment_on_fee_defaulter_report_consolidated_page(String arg1) throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectInstallment(arg1);
	}

	@Then("^user click date range on fee defaulter report consolidated page$")
	public void user_click_date_range_on_fee_defaulter_report_consolidated_page() throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectDateRange();
	}

	@Then("^user select from date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter report consolidated page$")
	public void user_select_from_date_as_month_year_and_day_on_fee_defaulter_report_consolidated_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select till date as month \"([^\"]*)\" year\"([^\"]*)\" and day \"([^\"]*)\" on fee defaulter report consolidated page$")
	public void user_select_till_date_as_month_year_and_day_on_fee_defaulter_report_consolidated_page(String arg1, String arg2, String arg3) throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click with fine on fee defaulter report consolidated page$")
	public void user_click_with_fine_on_fee_defaulter_report_consolidated_page() throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.clickWithFine();
	}

	@Then("^user click show on fee defaulter report consolidated page$")
	public void user_click_show_on_fee_defaulter_report_consolidated_page() throws Throwable {
		FeeDefaulterReportConsolidated fd= new FeeDefaulterReportConsolidated(dr);
		fd.clickShow();
	}

//reconcile report
	@Then("^reconcile report page is opened$")
	public void reconcile_report_page_is_opened() throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.openReconcileReport();
	}

	@Then("^user select school \"([^\"]*)\" on reconcile report page$")
	public void user_select_school_on_reconcile_report_page(String arg1) throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on reconcile report page$")
	public void user_select_class_on_reconcile_report_page(String arg1) throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.selectClass(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on reconcile report page$")
	public void user_select_fee_type_on_reconcile_report_page(String arg1) throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.selectFeeType(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on reconcile report page$")
	public void user_select_installment_on_reconcile_report_page(String arg1) throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.selectInstallment(arg1);
	}

	@Then("^user select user \"([^\"]*)\" on reconcile report page$")
	public void user_select_user_on_reconcile_report_page(String arg1) throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.selectUser(arg1);
	}

	@Then("^user click summary on reconcile report page$")
	public void user_click_summary_on_reconcile_report_page() throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.clickSummary();
	}
	
	@Then("^user click consolidated on reconcile report page$")
	public void user_click_consolidated_on_reconcile_report_page() throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.clickConsolidated();
	}
	
	@Then("^user click show on reconcile report page$")
	public void user_click_show_on_reconcile_report_page() throws Throwable {
		ReconcileReport r= new ReconcileReport(dr);
		r.clickShow();
	}

//reconcile installment class wise
	@Then("^reconcile installment class wise page is opened$")
	public void reconcile_installment_class_wise_page_is_opened() throws Throwable {
		ReconcileInstallmentClassWise r= new ReconcileInstallmentClassWise(dr);
		r.openReconcileInstallmentClassWise();
	}

	@Then("^user select fee type \"([^\"]*)\" on reconcile installment class wise page$")
	public void user_select_fee_type_on_reconcile_installment_class_wise_page(String arg1) throws Throwable {
		ReconcileInstallmentClassWise r= new ReconcileInstallmentClassWise(dr);
		r.selectFeeType(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on reconcile installment class wise page$")
	public void user_select_class_on_reconcile_installment_class_wise_page(String arg1) throws Throwable {
		ReconcileInstallmentClassWise r= new ReconcileInstallmentClassWise(dr);
		r.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on reconcile installment class wise page$")
	public void user_select_installment_on_reconcile_installment_class_wise_page(String arg1) throws Throwable {
		ReconcileInstallmentClassWise r= new ReconcileInstallmentClassWise(dr);
		r.selectInstallment(arg1);
	}

	@Then("^user click show on reconcile installment class wise page$")
	public void user_click_show_on_reconcile_installment_class_wise_page() throws Throwable {
		ReconcileInstallmentClassWise r= new ReconcileInstallmentClassWise(dr);
		r.clickShow();
	}

//bad debts report
	@Then("^bad debts report page is opened$")
	public void bad_debts_report_page_is_opened() throws Throwable {
		BadDebtsReport bd= new BadDebtsReport(dr);
		bd.openBadDebtsReport();
	}

	@Then("^user select fee type \"([^\"]*)\" on bad debts report page$")
	public void user_select_fee_type_on_bad_debts_report_page(String arg1) throws Throwable {
		BadDebtsReport bd= new BadDebtsReport(dr);
		bd.selectFeeType(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on bad debts report page$")
	public void user_select_class_on_bad_debts_report_page(String arg1) throws Throwable {
		BadDebtsReport bd= new BadDebtsReport(dr);
		bd.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on bad debts report page$")
	public void user_select_installment_on_bad_debts_report_page(String arg1) throws Throwable {
		BadDebtsReport bd= new BadDebtsReport(dr);
		bd.selectInstallment(arg1);
	}

	@Then("^user click show on bad debts report page$")
	public void user_click_show_on_bad_debts_report_page() throws Throwable {
		BadDebtsReport bd= new BadDebtsReport(dr);
		bd.clickShow();
	}

//student health entry report
	@Then("^student health entry report page is opened$")
	public void student_health_entry_report_page_is_opened() throws Throwable {
		StudentHealthEntryReport h= new StudentHealthEntryReport(dr);
		h.openStudentHealthEntryReport();
	}

	@Then("^user select class \"([^\"]*)\" on student health entry report page$")
	public void user_select_class_on_student_health_entry_report_page(String arg1) throws Throwable {
		StudentHealthEntryReport h= new StudentHealthEntryReport(dr);
		h.selectClass(arg1);
	}

	@Then("^user click show on student health entry report page$")
	public void user_click_show_on_student_health_entry_report_page() throws Throwable {
		StudentHealthEntryReport h= new StudentHealthEntryReport(dr);
		h.clickShow();
	}

//Student Wise Receipt Report
	@Then("^student wise receipt report page is opened$")
	public void student_wise_receipt_report_page_is_opened() throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.openStudentWiseReceiptReport();
	}

	@Then("^user select class \"([^\"]*)\" on student wise receipt report page$")
	public void user_select_class_on_student_wise_receipt_report_page(String arg1) throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on student wise receipt report page$")
	public void user_select_section_on_student_wise_receipt_report_page(String arg1) throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.selectSection(arg1);
	}

	@Then("^user enter student \"([^\"]*)\" to search on student wise receipt report page$")
	public void user_enter_student_to_search_on_student_wise_receipt_report_page(String arg1) throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.enterStudent(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on student wise receipt report page$")
	public void user_select_fee_type_on_student_wise_receipt_report_page(String arg1) throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.selectFeeType(arg1);
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on student wise receipt report page$")
	public void user_select_from_date_as_month_year_and_day_on_student_wise_receipt_report_page(String arg1, String arg2, String arg3) throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.selectDateFrom(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on student wise receipt report page$")
	public void user_select_to_date_as_month_year_and_day_on_student_wise_receipt_report_page(String arg1, String arg2, String arg3) throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.selectDateTo(arg1, arg2, arg3);
	}

	@Then("^user click show on student wise receipt report page$")
	public void user_click_show_on_student_wise_receipt_report_page() throws Throwable {
		StudentWiseReceiptReport s= new StudentWiseReceiptReport(dr);
		s.clickShow();
	}

//transport report class wise
	@Then("^transport report class wise page is opened$")
	public void transport_report_class_wise_page_is_opened() throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.openTransportReportClassWise();
	}

	@Then("^user click class wise on transport report class wise page$")
	public void user_click_class_wise_on_transport_report_class_wise_page() throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.clickClassWise();
	}

	@Then("^user select installment \"([^\"]*)\" on transport report class wise page$")
	public void user_select_installment_on_transport_report_class_wise_page(String arg1) throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.selectInstallment(arg1);
	}

	@Then("^user enter stop fare \"([^\"]*)\" on transport report class wise page$")
	public void user_enter_stop_fare_on_transport_report_class_wise_page(String arg1) throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.enterStopFare(arg1);
	}
 
	@Then("^user click bus stop wise on transport report class wise page$")
	public void user_click_bus_stop_wise_on_transport_report_class_wise_page() throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.clickBusStopWise();
	}

	@Then("^user select route \"([^\"]*)\" on transport report class wise page$")
	public void user_select_route_on_transport_report_class_wise_page(String arg1) throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.selectRoute(arg1);
	}

	@Then("^user select bus stop \"([^\"]*)\" on transport report class wise page$")
	public void user_select_bus_stop_on_transport_report_class_wise_page(String arg1) throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.selectBusStop(arg1);
	}
	
	@Then("^user select class \"([^\"]*)\" on transport report class wise page$")
	public void user_select_class_on_transport_report_class_wise_page(String arg1) throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.selectClass(arg1);
	}

	@Then("^user click show on transport report class wise page$")
	public void user_click_show_on_transport_report_class_wise_page() throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.clickShow();
	}

	@Then("^transport report bus stop wise page is opened$")
	public void transport_report_bus_stop_wise_page_is_opened() throws Throwable {
		TransportReportClassWise r= new TransportReportClassWise(dr);
		r.clickBusStopWise();
	}

//estimated transport details
	@Then("^estimated transport details page is opened$")
	public void estimated_transport_details_page_is_opened() throws Throwable {
		EstimatedTransportDetails e= new EstimatedTransportDetails(dr);
		e.openEstimatedTransportDetails();
	}

	@Then("^user select school \"([^\"]*)\" on estimated transport details page$")
	public void user_select_school_on_estimated_transport_details_page(String arg1) throws Throwable {
		EstimatedTransportDetails e= new EstimatedTransportDetails(dr);
		e.selectSchool(arg1);
	}

	@Then("^user select route \"([^\"]*)\" on estimated transport details page$")
	public void user_select_route_on_estimated_transport_details_page(String arg1) throws Throwable {
		EstimatedTransportDetails e= new EstimatedTransportDetails(dr);
		e.selectRoute(arg1);
	}

	@Then("^user select vehicle \"([^\"]*)\" on estimated transport details page$")
	public void user_select_vehicle_on_estimated_transport_details_page(String arg1) throws Throwable {
		EstimatedTransportDetails e= new EstimatedTransportDetails(dr);
		e.selectVehicle(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on estimated transport details page$")
	public void user_select_class_on_estimated_transport_details_page(String arg1) throws Throwable {
		EstimatedTransportDetails e= new EstimatedTransportDetails(dr);
		e.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on estimated transport details page$")
	public void user_select_installment_on_estimated_transport_details_page(String arg1) throws Throwable {
		EstimatedTransportDetails e= new EstimatedTransportDetails(dr);
		e.selectInstallment(arg1);
	}
	
	@Then("^user click show on estimated transport details page$")
	public void user_click_show_on_estimated_transport_details_page() throws Throwable {
		EstimatedTransportDetails e= new EstimatedTransportDetails(dr);
		e.clickShow();
	}

//fees concession
	@Then("^fees concession page is opened$")
	public void fees_concession_page_is_opened() throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.openFeesConcession();
	}

	@Then("^user select school \"([^\"]*)\" on fees concession page$")
	public void user_select_school_on_fees_concession_page(String arg1) throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on fees concession page$")
	public void user_select_class_on_fees_concession_page(String arg1) throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on fees concession page$")
	public void user_select_section_on_fees_concession_page(String arg1) throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.selectSection(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on fees concession page$")
	public void user_select_fee_type_on_fees_concession_page(String arg1) throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.selectFeeType(arg1);
	}

	@Then("^user click consolidated on fees concession page$")
	public void user_click_consolidated_on_fees_concession_page() throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.clickConsolidated();
	}

	@Then("^user click paid concession on fees concession page$")
	public void user_click_paid_concession_on_fees_concession_page() throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.clickPaidConcession();
	}

	@Then("^user click assigned on fees concession page$")
	public void user_click_assigned_on_fees_concession_page() throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.clickAssigned();
	}
	
	@Then("^user click separated on fees concession page$")
	public void user_click_separated_on_fees_concession_page() throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.clickSeparated();
	}

	@Then("^user select installment \"([^\"]*)\" on fees concession page$")
	public void user_select_installment_on_fees_concession_page(String arg1) throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.selectInstallment(arg1);
	}

	@Then("^user select concession \"([^\"]*)\" on fees concession page$")
	public void user_select_concession_on_fees_concession_page(String arg1) throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.selectConcession(arg1);
	}

	@Then("^user select till date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on fees concession page$")
	public void user_select_till_date_as_month_year_and_day_on_fees_concession_page(String arg1, String arg2, String arg3) throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click entry time on fees concession page$")
	public void user_click_entry_time_on_fees_concession_page() throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.clickEntryTime();
	}

	@Then("^user click show on fees concession page$")
	public void user_click_show_on_fees_concession_page() throws Throwable {
		FeesConcession fc= new FeesConcession(dr);
		fc.clickShow();
	}

//route wise student strength
	@Then("^route wise student strength page is opened$")
	public void route_wise_student_strength_page_is_opened() throws Throwable {
		RouteWiseStudentStrength rs= new RouteWiseStudentStrength(dr);
		rs.openRouteWiseStudentStrength();
	}

	@Then("^user select school \"([^\"]*)\" on route wise student strength page$")
	public void user_select_school_on_route_wise_student_strength_page(String arg1) throws Throwable {
		RouteWiseStudentStrength rs= new RouteWiseStudentStrength(dr);
		rs.selectSchool(arg1);
	}

	@Then("^user select route \"([^\"]*)\" on route wise student strength page$")
	public void user_select_route_on_route_wise_student_strength_page(String arg1) throws Throwable {
		RouteWiseStudentStrength rs= new RouteWiseStudentStrength(dr);
		rs.selectRoute(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on route wise student strength page$")
	public void user_select_class_on_route_wise_student_strength_page(String arg1) throws Throwable {
		RouteWiseStudentStrength rs= new RouteWiseStudentStrength(dr);
		rs.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on route wise student strength page$")
	public void user_select_installment_on_route_wise_student_strength_page(String arg1) throws Throwable {
		RouteWiseStudentStrength rs= new RouteWiseStudentStrength(dr);
		rs.selectInstallment(arg1);
	}

	@Then("^user click show on route wise student strength page$")
	public void user_click_show_on_route_wise_student_strength_page() throws Throwable {
		RouteWiseStudentStrength rs= new RouteWiseStudentStrength(dr);
		rs.clickShow();
	}

//fees concession install headWise
	@Then("^fees concession install headwise page is opened$")
	public void fees_concession_install_headwise_page_is_opened() throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.openFeesConcessionInstallHeadWise();
	}

	@Then("^user select school \"([^\"]*)\" on fees concession install headWise page$")
	public void user_select_school_on_fees_concession_install_headWise_page(String arg1) throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on fees concession install headWise page$")
	public void user_select_class_on_fees_concession_install_headWise_page(String arg1) throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on fees concession install headWise page$")
	public void user_select_section_on_fees_concession_install_headWise_page(String arg1) throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.selectSection(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on fees concession install headWise page$")
	public void user_select_fee_type_on_fees_concession_install_headWise_page(String arg1) throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.selectFeeType(arg1);
	}

	@Then("^user click fee head wise on fees concession install headWise page$")
	public void user_click_fee_head_wise_on_fees_concession_install_headWise_page() throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.clickFeeHeadWise();
	}

	@Then("^user click paid concession on fees concession install headWise page$")
	public void user_click_paid_concession_on_fees_concession_install_headWise_page() throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.clickPaidConcession();
	}

	@Then("^user click assigned on fees concession install headWise page$")
	public void user_click_assigned_on_fees_concession_install_headWise_page() throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.clickAssigned();
	}

	@Then("^user click installment wise on fees concession page$")
	public void user_click_installment_wise_on_fees_concession_page() throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.clickInstallmentWise();
	}

	@Then("^user select installment \"([^\"]*)\" on fees concession install headWise page$")
	public void user_select_installment_on_fees_concession_install_headWise_page(String arg1) throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.selectInstallment(arg1);
	}

	@Then("^user select concession \"([^\"]*)\" on fees concession install headWise page$")
	public void user_select_concession_on_fees_concession_install_headWise_page(String arg1) throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.selectConcession(arg1);
	}

	@Then("^user select till date as month \"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on fees concession install headWise page$")
	public void user_select_till_date_as_month_year_and_day_on_fees_concession_install_headWise_page(String arg1, String arg2, String arg3) throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click entry time on fees concession install headWise page$")
	public void user_click_entry_time_on_fees_concession_install_headWise_page() throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.clickEntryTime();
	}

	@Then("^user click show on fees concession install headWise page$")
	public void user_click_show_on_fees_concession_install_headWise_page() throws Throwable {
		FeesConcessionInstallHeadWise fc= new FeesConcessionInstallHeadWise(dr);
		fc.clickShow();
	}

//fee collection with entry time concession
	@Then("^fee collection with entry time concession report is opened$")
	public void fee_collection_with_entry_time_concession_report_is_opened() throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.openFeeCollectionWithEntryTimeConcession();
	}

	@Then("^user select entry mode\"([^\"]*)\" on fee collection with entry time concession report$")
	public void user_select_entry_mode_on_fee_collection_with_entry_time_concession_report(String arg1) throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.selectEntryMode(arg1);
	}

	@Then("^user select collection date as month\"([^\"]*)\" year \"([^\"]*)\" and day\"([^\"]*)\" on fee collection with entry time concession report$")
	public void user_select_collection_date_as_month_year_and_day_on_fee_collection_with_entry_time_concession_report(String arg1, String arg2, String arg3) throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.selectCollectionDate(arg1, arg2, arg3);
	}

	@Then("^user select school \"([^\"]*)\" on fee collection with entry time concession report$")
	public void user_select_school_on_fee_collection_with_entry_time_concession_report(String arg1) throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.selectSchool(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on fee collection with entry time concession report$")
	public void user_select_fee_type_on_fee_collection_with_entry_time_concession_report(String arg1) throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.selectFeeType(arg1);
	}

	@Then("^user click without head on fee collection with entry time concession report$")
	public void user_click_without_head_on_fee_collection_with_entry_time_concession_report() throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.clickWithoutHead();
	}
	
	@Then("^user select pay mode \"([^\"]*)\" on fee collection with entry time concession report$")
	public void user_select_pay_mode_on_fee_collection_with_entry_time_concession_report(String arg1) throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.selectPayMode(arg1);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on fee collection with entry time concession report$")
	public void user_select_pay_mode_and_on_fee_collection_with_entry_time_concession_report(String arg1, String arg2) throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.selectPayMode(arg1, arg2);
	}
	
	@Then("^user click receipt no range on fee collection with entry time concession report$")
	public void user_click_receipt_no_range_on_fee_collection_with_entry_time_concession_report() throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.clickReceiptNorange();
	}

	@Then("^enter from receipt no \"([^\"]*)\" to receipt no \"([^\"]*)\" on fee collection with entry time concession report$")
	public void enter_from_receipt_no_to_receipt_no_on_fee_collection_with_entry_time_concession_report(String arg1, String arg2) throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.enterReceiptRange(arg1, arg2);
	}

	@Then("^user click with head on fee collection with entry time concession report$")
	public void user_click_with_head_on_fee_collection_with_entry_time_concession_report() throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.clickHeadWise();
	}

	@Then("^user click show on fee collection with entry time concession report$")
	public void user_click_show_on_fee_collection_with_entry_time_concession_report() throws Throwable {
		FeeCollectionWithEntryTimeConcession fc= new FeeCollectionWithEntryTimeConcession(dr);
		fc.clickShow();
	}

//month wise collection report
	@Then("^month wise collection report is opened$")
	public void month_wise_collection_report_is_opened() throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.openMonthWiseCollectionReport();
	}

	@Then("^select class \"([^\"]*)\" on month wise collection report$")
	public void select_class_on_month_wise_collection_report(String arg1) throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on month wise collection report$")
	public void user_select_installment_on_month_wise_collection_report(String arg1) throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.selectInstallment(arg1);
	}

	@Then("^user select entry mode \"([^\"]*)\" on month wise collection report$")
	public void user_select_entry_mode_on_month_wise_collection_report(String arg1) throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.selectEntryMode(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on month wise collection report$")
	public void user_select_fee_type_on_month_wise_collection_report(String arg1) throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.selectFeeType(arg1);
	}

	@Then("^user select month \"([^\"]*)\" on month wise collection report$")
	public void user_select_month_on_month_wise_collection_report(String arg1) throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.selectMonth(arg1);
	}

	@Then("^user select bank name \"([^\"]*)\" on month wise collection report$")
	public void user_select_bank_name_on_month_wise_collection_report(String arg1) throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.selectBankName(arg1);
	}
	
	@Then("^select user \"([^\"]*)\" on month wise collection report$")
	public void select_user_on_month_wise_collection_report(String arg1) throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.selectUser(arg1);
	}
	
	@Then("^user click show on month wise collection report$")
	public void user_click_show_on_month_wise_collection_report() throws Throwable {
		MonthWiseCollectionReport m= new MonthWiseCollectionReport(dr);
		m.clickShow();
	}

//daily fee collection account wise
	@Then("^daily fee collection account wise report is opened$")
	public void daily_fee_collection_account_wise_report_is_opened() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.openDailyFeeCollectionAccountWise();
	}

	@Then("^user select entry mode \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_entry_mode_on_daily_fee_collection_account_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectEntryMode(arg1);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_pay_mode_and_on_daily_fee_collection_account_wise_report(String arg1, String arg2) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectPayMode(arg1, arg2);
	}

	@Then("^user select bank name \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_bank_name_on_daily_fee_collection_account_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectBankName(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_class_on_daily_fee_collection_account_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectClass(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_fee_type_on_daily_fee_collection_account_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectFeeType(arg1);
	}

	@Then("^user click filter with cheque clearing date on daily fee collection account wise report$")
	public void user_click_filter_with_cheque_clearing_date_on_daily_fee_collection_account_wise_report() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.clickCheckClearingDate();
	}

	@Then("^user click head wise on daily fee collection account wise report$")
	public void user_click_head_wise_on_daily_fee_collection_account_wise_report() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.clickHeadWise();
	}
	
	@Then("^user click receipt no range on daily fee collection account wise report$")
	public void user_click_receipt_no_range_on_daily_fee_collection_account_wise_report() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.clickReceiptRange();
	}

	@Then("^user enter receipt no from \"([^\"]*)\" to \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_enter_receipt_no_from_to_on_daily_fee_collection_account_wise_report(String arg1, String arg2) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.enterReceiptRange(arg1, arg2);
	}
	
	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_from_date_as_month_year_and_day_on_daily_fee_collection_account_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_to_date_as_month_year_and_day_on_daily_fee_collection_account_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user click without head total amount on daily fee collection account wise report$")
	public void user_click_without_head_total_amount_on_daily_fee_collection_account_wise_report() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.clickWithoutHeadTotalAmount();
	}

	@Then("^user click with head one line data on daily fee collection account wise report$")
	public void user_click_with_head_one_line_data_on_daily_fee_collection_account_wise_report() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.clickWithHeadOneLineData();
	}

	@Then("^user select user \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_user_on_daily_fee_collection_account_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectUser(arg1);
	}

	@Then("^user select school \"([^\"]*)\" on daily fee collection account wise report$")
	public void user_select_school_on_daily_fee_collection_account_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.selectSchool(arg1);
	}

	@Then("^user click without head one line data on daily fee collection account wise report$")
	public void user_click_without_head_one_line_data_on_daily_fee_collection_account_wise_report() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.clickwithoutheadonelinedata();
	}

	@Then("^user click show on daily fee collection account wise report$")
	public void user_click_show_on_daily_fee_collection_account_wise_report() throws Throwable {
		DailyFeeCollectionAccountWise f= new DailyFeeCollectionAccountWise(dr);
		f.clickShow();
	}

//daily fee collection date wise
	@Then("^daily fee collection date wise report is opened$")
	public void daily_fee_collection_date_wise_report_is_opened() throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.openDailyFeeCollectionDateWise();
	}

	@Then("^user select entry mode \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_entry_mode_on_daily_fee_collection_date_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectEntryMode(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_class_on_daily_fee_collection_date_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectClass(arg1);
	}
	
	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_from_date_as_month_year_and_day_on_daily_fee_collection_date_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_pay_mode_and_on_daily_fee_collection_date_wise_report(String arg1, String arg2) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectPayMode(arg1, arg2);
	}

	@Then("^user select bank name \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_bank_name_on_daily_fee_collection_date_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectBankName(arg1);
	}
	
	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_to_date_as_month_year_and_day_on_daily_fee_collection_date_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select school \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_school_on_daily_fee_collection_date_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectSchool(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_fee_type_on_daily_fee_collection_date_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectFeeType(arg1);
	}
	
	@Then("^user select user \"([^\"]*)\" on daily fee collection date wise report$")
	public void user_select_user_on_daily_fee_collection_date_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.selectUser(arg1);
	}

	@Then("^user click show on daily fee collection date wise report$")
	public void user_click_show_on_daily_fee_collection_date_wise_report() throws Throwable {
		DailyFeeCollectionDateWise f= new DailyFeeCollectionDateWise(dr);
		f.clickShow();
	}

//daily fee collection date fee group wise
	@Then("^daily fee collection date fee group wise report is opened$")
	public void daily_fee_collection_date_fee_group_wise_report_is_opened() throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.openDailyFeeCollectionDateFeeGroupWise();
	}

	@Then("^user select school \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_school_on_daily_fee_collection_date_fee_group_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectSchool(arg1);
	}

	@Then("^user select entry mode \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_entry_mode_on_daily_fee_collection_date_fee_group_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectEntryMode(arg1);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_pay_mode_and_on_daily_fee_collection_date_fee_group_wise_report(String arg1, String arg2) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectPayMode(arg1,arg2);
	}

	@Then("^user select class \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_class_on_daily_fee_collection_date_fee_group_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectClass(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_fee_type_on_daily_fee_collection_date_fee_group_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectFeeType(arg1);
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_from_date_as_month_year_and_day_on_daily_fee_collection_date_fee_group_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_to_date_as_month_year_and_day_on_daily_fee_collection_date_fee_group_wise_report(String arg1, String arg2, String arg3) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user click full details on daily fee collection date fee group wise report$")
	public void user_click_full_details_on_daily_fee_collection_date_fee_group_wise_report() throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.clickFullDetails();
	}

	@Then("^user select user \"([^\"]*)\" on daily fee collection date fee group wise report$")
	public void user_select_user_on_daily_fee_collection_date_fee_group_wise_report(String arg1) throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.selectUser(arg1);
	}

	@Then("^user click summary on daily fee collection date fee group wise report$")
	public void user_click_summary_on_daily_fee_collection_date_fee_group_wise_report() throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.clickSummary();
	}

	@Then("^user click separated on daily fee collection date fee group wise report$")
	public void user_click_separated_on_daily_fee_collection_date_fee_group_wise_report() throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.clickSeparated();
	}
	
	@Then("^user click show on daily fee collection date fee group wise report$")
	public void user_click_show_on_daily_fee_collection_date_fee_group_wise_report() throws Throwable {
		DailyFeeCollectionDateFeeGroupWise f= new DailyFeeCollectionDateFeeGroupWise(dr);
		f.clickShow();
	}

//fee head wise collection class range
	@Then("^fee head wise collection class range report is opened$")
	public void fee_head_wise_collection_class_range_report_is_opened() throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.openFeeHeadWiseCollectionClassRange();
	}
	
	@Then("^user select entry mode \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_entry_mode_on_fee_head_wise_collection_class_range_report(String arg1) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.selectEntryMode(arg1);
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_from_date_as_month_year_and_day_on_fee_head_wise_collection_class_range_report(String arg1, String arg2, String arg3) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_to_date_as_month_year_and_day_on_fee_head_wise_collection_class_range_report(String arg1, String arg2, String arg3) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select class \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_class_on_fee_head_wise_collection_class_range_report(String arg1) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.selectClass(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_fee_type_on_fee_head_wise_collection_class_range_report(String arg1) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.selectFeeType(arg1);
	}

	@Then("^user select school \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_school_on_fee_head_wise_collection_class_range_report(String arg1) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
	    f.selectSchool(arg1);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_pay_mode_and_on_fee_head_wise_collection_class_range_report(String arg1, String arg2) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.selectPayMode(arg1, arg2);
	}
	
	@Then("^user select user \"([^\"]*)\" on fee head wise collection class range report$")
	public void user_select_user_on_fee_head_wise_collection_class_range_report(String arg1) throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.selectUser(arg1);
	}

	@Then("^user click show on fee head wise collection class range report$")
	public void user_click_show_on_fee_head_wise_collection_class_range_report() throws Throwable {
		FeeHeadWiseCollectionClassRange f= new FeeHeadWiseCollectionClassRange(dr);
		f.clickShow();
	}

//estimated collection report
	@Then("^estimated collection report is opened$")
	public void estimated_collection_report_is_opened() throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.openEstimatedCollectionReport();
	}

	@Then("^user select school \"([^\"]*)\" on estimated collection report$")
	public void user_select_school_on_estimated_collection_report(String arg1) throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on estimated collection report$")
	public void user_select_class_on_estimated_collection_report(String arg1) throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on estimated collection report$")
	public void user_select_installment_on_estimated_collection_report(String arg1) throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.selectInstallment(arg1);
	}

	@Then("^user select till date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on estimated collection report$")
	public void user_select_till_date_as_month_year_and_day_on_estimated_collection_report(String arg1, String arg2, String arg3) throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.selectTillDate(arg1, arg2, arg3);
	}
	
	@Then("^user select fee type \"([^\"]*)\" on estimated collection report$")
	public void user_select_fee_type_on_estimated_collection_report(String arg1) throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.selectFeeType(arg1);
	}

	@Then("^user select user \"([^\"]*)\" on estimated collection report$")
	public void user_select_user_on_estimated_collection_report(String arg1) throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.selectUser(arg1);
	}

	@Then("^user select report filter \"([^\"]*)\" on estimated collection report$")
	public void user_select_report_filter_on_estimated_collection_report(String arg1) throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.selectReportFilter(arg1);
	}

	@Then("^user click show on estimated collection report$")
	public void user_click_show_on_estimated_collection_report() throws Throwable {
		EstimatedCollectionReport ec= new EstimatedCollectionReport(dr);
		ec.clickShow();
	}

//receipt wise fee type collection
	@Then("^receipt wise fee type collection report is opened$")
	public void receipt_wise_fee_type_collection_report_is_opened() throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.openReceiptWiseFeeTypeCollection();
	}

	@Then("^user select school \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_school_on_receipt_wise_fee_type_collection_report(String arg1) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_class_on_receipt_wise_fee_type_collection_report(String arg1) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectClass(arg1);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_pay_mode_and_on_receipt_wise_fee_type_collection_report(String arg1, String arg2) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectPayMode(arg1, arg2);
	}

	@Then("^user select bank name \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_bank_name_on_receipt_wise_fee_type_collection_report(String arg1) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectBankName(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_fee_type_on_receipt_wise_fee_type_collection_report(String arg1) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectFeeType(arg1);
	}

	@Then("^user select date from as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_date_from_as_month_year_and_day_on_receipt_wise_fee_type_collection_report(String arg1, String arg2, String arg3) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select date to as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_date_to_as_month_year_and_day_on_receipt_wise_fee_type_collection_report(String arg1, String arg2, String arg3) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select user \"([^\"]*)\" on receipt wise fee type collection report$")
	public void user_select_user_on_receipt_wise_fee_type_collection_report(String arg1) throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.selectUser(arg1);
	}
	
	@Then("^user click student wise only on receipt wise fee type collection report$")
	public void user_click_student_wise_only_on_receipt_wise_fee_type_collection_report() throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.clickStudentWiseOnly();
	}

	@Then("^user click show on receipt wise fee type collection report$")
	public void user_click_show_on_receipt_wise_fee_type_collection_report() throws Throwable {
		ReceiptWiseFeeTypeCollection r= new ReceiptWiseFeeTypeCollection(dr);
		r.clickShow();
	}

//day wise total collection
	@Then("^day wise total collection report is opened$")
	public void day_wise_total_collection_report_is_opened() throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.openDayWiseTotalCollection();
	}

	@Then("^user select school \"([^\"]*)\" on day wise total collection report$")
	public void user_select_school_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectSchool(arg1);
	}

	@Then("^user select entry mode \"([^\"]*)\" on day wise total collection report$")
	public void user_select_entry_mode_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectEntryMode(arg1);
	}

	@Then("^user select month \"([^\"]*)\" on day wise total collection report$")
	public void user_select_month_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectMonth(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on day wise total collection report$")
	public void user_select_installment_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectInstallment(arg1);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on day wise total collection report$")
	public void user_select_pay_mode_and_on_day_wise_total_collection_report(String arg1, String arg2) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectPayMode(arg1, arg2);
	}

	@Then("^user select fee type \"([^\"]*)\" on day wise total collection report$")
	public void user_select_fee_type_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectFeeType(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on day wise total collection report$")
	public void user_select_class_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on day wise total collection report$")
	public void user_select_section_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectSection(arg1);
	}

	@Then("^user select till date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on day wise total collection report$")
	public void user_select_till_date_as_month_year_and_day_on_day_wise_total_collection_report(String arg1, String arg2, String arg3) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user select user \"([^\"]*)\" on day wise total collection report$")
	public void user_select_user_on_day_wise_total_collection_report(String arg1) throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.selectUser(arg1);
	}

	@Then("^user click show on day wise total collection report$")
	public void user_click_show_on_day_wise_total_collection_report() throws Throwable {
		DayWiseTotalCollection c= new DayWiseTotalCollection(dr);
		c.clickShow();
	}

//receipt wise daily collection
	@Then("^receipt wise daily collection report is opened$")
	public void receipt_wise_daily_collection_report_is_opened() throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.openReceiptWiseDailyCollection();
	}

	@Then("^user select school \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_school_on_receipt_wise_daily_collection_report(String arg1) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_class_on_receipt_wise_daily_collection_report(String arg1) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectClass(arg1);
	}

	@Then("^user select pay mode \"([^\"]*)\" and \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_pay_mode_and_on_receipt_wise_daily_collection_report(String arg1, String arg2) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectPayMode(arg1, arg2);
	}
	
	@Then("^user select pay mode \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_pay_mode_on_receipt_wise_daily_collection_report(String arg1) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectPayMode(arg1);
	}

	@Then("^user select bank name \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_bank_name_on_receipt_wise_daily_collection_report(String arg1) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectBankName(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_fee_type_on_receipt_wise_daily_collection_report(String arg1) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectFeeType(arg1);
	}

	@Then("^user select date from as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_date_from_as_month_year_and_day_on_receipt_wise_daily_collection_report(String arg1, String arg2, String arg3) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectDateFrom(arg1, arg2, arg3);
	}

	@Then("^user select date to as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_date_to_as_month_year_and_day_on_receipt_wise_daily_collection_report(String arg1, String arg2, String arg3) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectDateTo(arg1, arg2, arg3);
	}

	@Then("^user select order by \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_order_by_on_receipt_wise_daily_collection_report(String arg1) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectOrderBy(arg1);
	}

	@Then("^user click without head on receipt wise daily collection report$")
	public void user_click_without_head_on_receipt_wise_daily_collection_report() throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.clickWithOutHead();
	}

	@Then("^user select user \"([^\"]*)\" on receipt wise daily collection report$")
	public void user_select_user_on_receipt_wise_daily_collection_report(String arg1) throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.selectUser(arg1);
	}

	@Then("^user click with head on receipt wise daily collection report$")
	public void user_click_with_head_on_receipt_wise_daily_collection_report() throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.clickWithHead();
	}

	@Then("^user click amalgamated report on receipt wise daily collection report$")
	public void user_click_amalgamated_report_on_receipt_wise_daily_collection_report() throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.clickAmalgamatedReport();
	}

	@Then("^user click show on receipt wise daily collection report$")
	public void user_click_show_on_receipt_wise_daily_collection_report() throws Throwable {
		ReceiptWiseDailyCollection rc=new ReceiptWiseDailyCollection(dr);
		rc.clickShow();
	}

//monthly consolidated report
	@Then("^monthly consolidated report is opened$")
	public void monthly_consolidated_report_is_opened() throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.openMonthlyConsolidatedReport();
	}

	@Then("^user select school \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_school_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectSchool(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_fee_type_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectFeeType(arg1);
	}

	@Then("^user select entry mode \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_entry_mode_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectEntryMode(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_class_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_installment_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectInstallment(arg1);
	}

	@Then("^user select paymode \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_paymode_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectPayMode(arg1);
	}

	@Then("^select month \"([^\"]*)\" on monthly consolidated report$")
	public void select_month_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectMonth(arg1);
	}

	@Then("^user select paymode \"([^\"]*)\" and \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_paymode_and_on_monthly_consolidated_report(String arg1, String arg2) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectPayMode(arg1, arg2);
	}
	
	@Then("^user select bank name \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_bank_name_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectBankName(arg1);
	}

	@Then("^user select user \"([^\"]*)\" on monthly consolidated report$")
	public void user_select_user_on_monthly_consolidated_report(String arg1) throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.selectUser(arg1);
	}

	@Then("^user click head wise on monthly consolidated report$")
	public void user_click_head_wise_on_monthly_consolidated_report() throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.clickHeadWise();
	}
	@Then("^user click filter with cheque clearing date on monthly consolidated report$")
	public void user_click_filter_with_cheque_clearing_date_on_monthly_consolidated_report() throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.clickFilterWithChequeClearingDate();
	}

	@Then("^user click class wise on monthly consolidated report$")
	public void user_click_class_wise_on_monthly_consolidated_report() throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr); 
		m.clickClassWise();
	}

	@Then("^user click without head total amount on monthly consolidated report$")
	public void user_click_without_head_total_amount_on_monthly_consolidated_report() throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr); 
		m.clickWithOutHeadTotalAmount();
	}
	
	@Then("^user click show on monthly consolidated report$")
	public void user_click_show_on_monthly_consolidated_report() throws Throwable {
		MonthlyConsolidatedReport m= new MonthlyConsolidatedReport(dr);
		m.clickShow();
	}

//paid transport
	@Then("^paid transport report is opened$")
	public void paid_transport_report_is_opened() throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.openPaidTransport();
	}

	@Then("^user select route \"([^\"]*)\" on paid transport report$")
	public void user_select_route_on_paid_transport_report(String arg1) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectRoute(arg1);
	}

	@Then("^user select vehicle \"([^\"]*)\" on paid transport report$")
	public void user_select_vehicle_on_paid_transport_report(String arg1) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectVehicle(arg1);
	}

	@Then("^user select school \"([^\"]*)\" on paid transport report$")
	public void user_select_school_on_paid_transport_report(String arg1) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on paid transport report$")
	public void user_select_class_on_paid_transport_report(String arg1) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectClass(arg1);
	}

	@Then("^user select paymode \"([^\"]*)\" and \"([^\"]*)\" on paid transport report$")
	public void user_select_paymode_and_on_paid_transport_report(String arg1, String arg2) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectPayMode(arg1, arg2);
	}

	@Then("^user select installment \"([^\"]*)\" on paid transport report$")
	public void user_select_installment_on_paid_transport_report(String arg1) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectInstallment(arg1);
	}

	@Then("^user select date from as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on paid transport report$")
	public void user_select_date_from_as_month_year_and_day_on_paid_transport_report(String arg1, String arg2, String arg3) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectDateFrom(arg1, arg2, arg3);
	}

	@Then("^user select date to as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on paid transport report$")
	public void user_select_date_to_as_month_year_and_day_on_paid_transport_report(String arg1, String arg2, String arg3) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectDateTo(arg1, arg2, arg3);
	}

	@Then("^user select user \"([^\"]*)\" on paid transport report$")
	public void user_select_user_on_paid_transport_report(String arg1) throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.selectUser(arg1);
	}

	@Then("^user click show on paid transport report$")
	public void user_click_show_on_paid_transport_report() throws Throwable {
		PaidTransport p= new PaidTransport(dr);
		p.clickShow();
	}

//surname wise student details
	@Then("^surname wise student details report is opened$")
	public void surname_wise_student_details_report_is_opened() throws Throwable {
		SurnameWiseStudentDetails ss= new SurnameWiseStudentDetails(dr);
		ss.openSurnameWiseStudentDetails();
	}

	@Then("^user select class \"([^\"]*)\" on surname wise student details report$")
	public void user_select_class_on_surname_wise_student_details_report(String arg1) throws Throwable {
		SurnameWiseStudentDetails ss= new SurnameWiseStudentDetails(dr);
		ss.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on surname wise student details report$")
	public void user_select_section_on_surname_wise_student_details_report(String arg1) throws Throwable {
		SurnameWiseStudentDetails ss= new SurnameWiseStudentDetails(dr);
		ss.selectSection(arg1);
	}

	@Then("^user select admission no\"([^\"]*)\" and class\"([^\"]*)\" in student on surname wise student details report$")
	public void user_select_admission_no_and_class_in_student_on_surname_wise_student_details_report(String arg1, String arg2) throws Throwable {
		SurnameWiseStudentDetails ss= new SurnameWiseStudentDetails(dr);
		ss.selectStudentDetails(arg1, arg2);
	}
	
	@Then("^user click show on surname wise student details report$")
	public void user_click_show_on_surname_wise_student_details_report() throws Throwable {
		SurnameWiseStudentDetails ss= new SurnameWiseStudentDetails(dr);
		ss.clickShow();
	}

//class wise mark list
	@Then("^class wise mark list is opened$")
	public void class_wise_mark_list_is_opened() throws Throwable {
		ClassWiseMarkList m= new ClassWiseMarkList(dr);
		m.openClassWiseMarkList();
	}

	@Then("^user select class \"([^\"]*)\" on class wise mark list$")
	public void user_select_class_on_class_wise_mark_list(String arg1) throws Throwable {
		ClassWiseMarkList m= new ClassWiseMarkList(dr);
		m.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on class wise mark list$")
	public void user_select_section_on_class_wise_mark_list(String arg1) throws Throwable {
		ClassWiseMarkList m= new ClassWiseMarkList(dr);
		m.selectSection(arg1);
	}

	@Then("^user click show on class wise mark list$")
	public void user_click_show_on_class_wise_mark_list() throws Throwable {
		ClassWiseMarkList m= new ClassWiseMarkList(dr);
		m.clickShow();
	}

//group wise student details
	@Then("^group wise student details page is opened$")
	public void group_wise_student_details_page_is_opened() throws Throwable {
		GroupWiseStudentDetails gp= new GroupWiseStudentDetails(dr);
		gp.openGroupWiseStudentDetails();
	}

	@Then("^user select class \"([^\"]*)\" on group wise student details page$")
	public void user_select_class_on_group_wise_student_details_page(String arg1) throws Throwable {
		GroupWiseStudentDetails gp= new GroupWiseStudentDetails(dr);
		gp.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on group wise student details page$")
	public void user_select_section_on_group_wise_student_details_page(String arg1) throws Throwable {
		GroupWiseStudentDetails gp= new GroupWiseStudentDetails(dr);
		gp.selectSection(arg1);
	}

	@Then("^user select group \"([^\"]*)\" on group wise student details page$")
	public void user_select_group_on_group_wise_student_details_page(String arg1) throws Throwable {
		GroupWiseStudentDetails gp= new GroupWiseStudentDetails(dr);
		gp.selectGroup(arg1);
	}

	@Then("^user click show on group wise student details page$")
	public void user_click_show_on_group_wise_student_details_page() throws Throwable {
		GroupWiseStudentDetails gp= new GroupWiseStudentDetails(dr);
		gp.clickShow();
	}

//online payment status report
	@Then("^online payment status report is opened$")
	public void online_payment_status_report_is_opened() throws Throwable {
		OnlinePaymentStatusReport op= new OnlinePaymentStatusReport(dr);
		op.openOnlinePaymentStatusReport();
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on online payment status report$")
	public void user_select_from_date_as_month_year_and_day_on_online_payment_status_report(String arg1, String arg2, String arg3) throws Throwable {
		OnlinePaymentStatusReport op= new OnlinePaymentStatusReport(dr);
		op.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on online payment status report$")
	public void user_select_to_date_as_month_year_and_day_on_online_payment_status_report(String arg1, String arg2, String arg3) throws Throwable {
		OnlinePaymentStatusReport op= new OnlinePaymentStatusReport(dr);
		op.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^clicks show button on online payment status report$")
	public void clicks_show_button_on_online_payment_status_report() throws Throwable {
		OnlinePaymentStatusReport op= new OnlinePaymentStatusReport(dr);
		op.clickShow();
	}

//print fee receipt and certificate
	@Then("^print fee receipt and certificate page is opened$")
	public void print_fee_receipt_and_certificate_page_is_opened() throws Throwable {
		PrintFeeReceiptAndCertificate p= new PrintFeeReceiptAndCertificate(dr);
		p.openPrintFeeReceiptAndCertificate();
	}

	@Then("^user search by receipt no \"([^\"]*)\" on print fee receipt and certificate page$")
	public void user_search_by_receipt_no_on_print_fee_receipt_and_certificate_page(String arg1) throws Throwable {
		PrintFeeReceiptAndCertificate p= new PrintFeeReceiptAndCertificate(dr);
		p.searchReceiptByReceiptNo(arg1);
	}

	@Then("^user search by student details class \"([^\"]*)\" section \"([^\"]*)\" and name \"([^\"]*)\" on print fee receipt and certificate page$")
	public void user_search_by_student_details_class_section_and_name_on_print_fee_receipt_and_certificate_page(String arg1, String arg2, String arg3) throws Throwable {
		PrintFeeReceiptAndCertificate p= new PrintFeeReceiptAndCertificate(dr);
		p.searchReceiptByName(arg1, arg2, arg3);
	}
	
	@Then("^user click print receipt \"([^\"]*)\" on print fee receipt and certificate page$")
	public void user_click_print_receipt_on_print_fee_receipt_and_certificate_page(String arg1) throws Throwable {
		PrintFeeReceiptAndCertificate p= new PrintFeeReceiptAndCertificate(dr);
		p.printFeeReceipt(arg1);
	} 

	@Then("^user click print certificate \"([^\"]*)\" on print fee receipt and certificate page$")
	public void user_click_print_certificate_on_print_fee_receipt_and_certificate_page(String arg1) throws Throwable {
		PrintFeeReceiptAndCertificate p= new PrintFeeReceiptAndCertificate(dr);
		p.printFeeCertificate(arg1);
	}
	
//modify fee receipt
	@Then("^modify fee receipt form is opened$")
	public void modify_fee_receipt_form_is_opened() throws Throwable {
		ModifyFeeReceipt f= new ModifyFeeReceipt(dr);
		f.openModifyFeeReceipt();
	}

	@Then("^user search student by fee receipt no \"([^\"]*)\" on modify fee receipt form$")
	public void user_search_student_by_fee_receipt_no_on_modify_fee_receipt_form(String arg1) throws Throwable {
		ModifyFeeReceipt f= new ModifyFeeReceipt(dr);
		f.searchReceiptByReceiptNo(arg1);
	}

//tc report
	@Then("^tc report page is opened$")
	public void tc_report_page_is_opened() throws Throwable {
		TCReport tr= new TCReport(dr);
		tr.openTCReport();
	}

	@Then("^user enter from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on tc report page$")
	public void user_enter_from_date_as_month_year_and_day_on_tc_report_page(String arg1, String arg2, String arg3) throws Throwable {
		TCReport tr= new TCReport(dr);
		tr.selectfromDate(arg1, arg2, arg3);
	}

	@Then("^user enter to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on tc report page$")
	public void user_enter_to_date_as_month_year_and_day_on_tc_report_page(String arg1, String arg2, String arg3) throws Throwable {
		TCReport tr= new TCReport(dr);
		tr.selectToDate(arg1, arg2, arg3);
	}

	@Then("^user select tc type \"([^\"]*)\" on tc report page$")
	public void user_select_tc_type_on_tc_report_page(String arg1) throws Throwable {
		TCReport tr= new TCReport(dr);
		tr.selectTcType(arg1);
	}

	@Then("^user select order by \"([^\"]*)\" on tc report page$")
	public void user_select_order_by_on_tc_report_page(String arg1) throws Throwable {
		TCReport tr= new TCReport(dr);
		tr.selectOrderBy(arg1);
	}

	@Then("^user click show on tc report page$")
	public void user_click_show_on_tc_report_page() throws Throwable {
		TCReport tr= new TCReport(dr);
		tr.clickShow();
	}

//certificates
	@Then("^certificates page is opened$")
	public void certificates_page_is_opened() throws Throwable {
		Certificates c= new Certificates(dr);
		c.openCertificates();
	}

	@Then("^user select class \"([^\"]*)\" on cerfificates page$")
	public void user_select_class_on_cerfificates_page(String arg1) throws Throwable {
		Certificates c= new Certificates(dr);
		c.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on certificates page$")
	public void user_select_section_on_certificates_page(String arg1) throws Throwable {
		Certificates c= new Certificates(dr);
		c.selectSection(arg1);
	}

	@Then("^user search student by admission no \"([^\"]*)\" on certificates page$")
	public void user_search_student_by_admission_no_on_certificates_page(String arg1) throws Throwable {
		Certificates c= new Certificates(dr);
		c.searchStudent(arg1);
	}

	@Then("^user select the certificate \"([^\"]*)\" to print on certificates page$")
	public void user_select_the_certificate_to_print_on_certificates_page(String arg1) throws Throwable {
		Certificates c= new Certificates(dr);
		c.selectPrintCertificate(arg1);
	}

	@Then("^user click show on certificates page$")
	public void user_click_show_on_certificates_page() throws Throwable {
		Certificates c= new Certificates(dr);
		c.clickShow();
	}
	
	@Then("^user verify certificates to print on certificates page$")
	public void user_verify_certificates_to_print_on_certificates_page() throws Throwable {
		Certificates c= new Certificates(dr);
		c.verifyPrintCertificates();
	}

//generate bill book details
	@Then("^user opens generate bill book details page$")
	public void user_opens_generate_bill_book_details_page() throws Throwable {
		GenerateBillBookDetails bill= new GenerateBillBookDetails(dr);
		bill.openGenerateBillBookDetails();
	}

	@Then("^user select school \"([^\"]*)\" on generate bill book details page$")
	public void user_select_school_on_generate_bill_book_details_page(String arg1) throws Throwable {
		GenerateBillBookDetails bill= new GenerateBillBookDetails(dr);
		bill.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on generate bill book details page$")
	public void user_select_class_on_generate_bill_book_details_page(String arg1) throws Throwable {
		GenerateBillBookDetails bill= new GenerateBillBookDetails(dr);
		bill.selectClass(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on generate bill book details page$")
	public void user_select_installment_on_generate_bill_book_details_page(String arg1) throws Throwable {
		GenerateBillBookDetails bill= new GenerateBillBookDetails(dr);
		bill.selectInstallment(arg1);
	}

	@Then("^user search student \"([^\"]*)\" on generate bill book details page$")
	public void user_search_student_on_generate_bill_book_details_page(String arg1) throws Throwable {
		GenerateBillBookDetails bill= new GenerateBillBookDetails(dr);
		bill.enterSearchText(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on generate bill book details page$")
	public void user_select_fee_type_on_generate_bill_book_details_page(String arg1) throws Throwable {
		GenerateBillBookDetails bill= new GenerateBillBookDetails(dr);
		bill.selectFeeType(arg1);
	}

	@Then("^user click show on generate bill book details page$")
	public void user_click_show_on_generate_bill_book_details_page() throws Throwable {
		GenerateBillBookDetails bill= new GenerateBillBookDetails(dr);
		bill.clickShow();
	}

//fees defaulter slip
	@Then("^fees defaulter slip page is opened$")
	public void fees_defaulter_slip_page_is_opened() throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.openFeesDefaulterSlip();
	}

	@Then("^user select school \"([^\"]*)\" on fees defaulter slip page$")
	public void user_select_school_on_fees_defaulter_slip_page(String arg1) throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.selectSchool(arg1);
	}

	@Then("^user select class \"([^\"]*)\" on fees defaulter slip page$")
	public void user_select_class_on_fees_defaulter_slip_page(String arg1) throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on fees defaulter slip page$")
	public void user_select_section_on_fees_defaulter_slip_page(String arg1) throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.selectSection(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on fees defaulter slip page$")
	public void user_select_fee_type_on_fees_defaulter_slip_page(String arg1) throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.selectFeeType(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on fees defaulter slip page$")
	public void user_select_installment_on_fees_defaulter_slip_page(String arg1) throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.selectInstallment(arg1);
	}

	@Then("^user click date range on fees defaulter slip page$")
	public void user_click_date_range_on_fees_defaulter_slip_page() throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.clickDateRange();
	}

	@Then("^user select from date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fees defaulter slip page$")
	public void user_select_from_date_as_month_year_and_day_on_fees_defaulter_slip_page(String arg1, String arg2, String arg3) throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.selectFromDate(arg1, arg2, arg3);
	}

	@Then("^user select to date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on fees defaulter slip page$")
	public void user_select_to_date_as_month_year_and_day_on_fees_defaulter_slip_page(String arg1, String arg2, String arg3) throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.selectTillDate(arg1, arg2, arg3);
	}

	@Then("^user click with fine on fees defaulter slip page$")
	public void user_click_with_fine_on_fees_defaulter_slip_page() throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.clickWithFine();
	}

	@Then("^user click show on fees defaulter slip page$")
	public void user_click_show_on_fees_defaulter_slip_page() throws Throwable {
		FeesDefaulterSlip dslip= new FeesDefaulterSlip(dr);
		dslip.clickShow();
	}

//generate tc
	@Then("^generate tc page is opened$")
	public void generate_tc_page_is_opened() throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.openGenerateTC();
	}

	@Then("^user click draft tc on generate tc page$")
	public void user_click_draft_tc_on_generate_tc_page() throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.clickDraftTC();
	}

	@Then("^user click preview tc of \"([^\"]*)\" on generate tc page$")
	public void user_click_preview_tc_of_on_generate_tc_page(String arg1) throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.previewDraftTC(arg1);
	}

	@Then("^user click generate tc of \"([^\"]*)\" on generate tc page$")
	public void user_click_generate_tc_of_on_generate_tc_page(String arg1) throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.clickDraftTC();
		tc.generateTC(arg1);
	}
	
	@Then("^user click generated tc on generate tc page$")
	public void user_click_generated_tc_on_generate_tc_page() throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.clickGeneratedTC();
	}

	@Then("^user click generated preview tc of \"([^\"]*)\" on generate tc page$")
	public void user_click_generated_preview_tc_of_on_generate_tc_page(String arg1) throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.previewGeneratedTC(arg1);
	}

	@Then("^user click cancel tc of \"([^\"]*)\" on generate tc page$")
	public void user_click_cancel_tc_of_on_generate_tc_page(String arg1) throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.cancelTC(arg1);
	}

	@Then("^user click cancelled tc on generate tc page$")
	public void user_click_cancelled_tc_on_generate_tc_page() throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.clickCancelledTc();
	}

	@Then("^user click search cancelled tc of \"([^\"]*)\" on generate tc page$")
	public void user_click_search_cancelled_tc_of_on_generate_tc_page(String arg1) throws Throwable {
		GenerateTC tc=new GenerateTC(dr);
		tc.searchCancelledTc(arg1);
	}

//tc form
	@Then("^tc form is opened$")
	public void tc_form_is_opened() throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.openTCForm();
	}

	@Then("^user select session \"([^\"]*)\" on tc form$")
	public void user_select_session_on_tc_form(String arg1) throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.selectSession(arg1);
	}

	@Then("^user enter student to search \"([^\"]*)\" on tc form$")
	public void user_enter_student_to_search_on_tc_form(String arg1) throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.enterSearchStudent(arg1);
	}
	
	@Then("^user click get on tc form$")
	public void user_click_get_on_tc_form() throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.clickGet();
	}

	@Then("^user select school board \"([^\"]*)\" on tc form$")
	public void user_select_school_board_on_tc_form(String arg1) throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.selectSchoolBoard(arg1);
	}

	@Then("^user select category \"([^\"]*)\" on tc form$")
	public void user_select_category_on_tc_form(String arg1) throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.selectCategory(arg1);
	}

	@Then("^user select struck off date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on tc form$")
	public void user_select_struck_off_date_as_month_year_and_day_on_tc_form(String arg1, String arg2, String arg3) throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.selectStruckOffDate(arg1, arg2, arg3);
	}

	@Then("^user select character \"([^\"]*)\" on tc form$")
	public void user_select_character_on_tc_form(String arg1) throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.selectCharacter(arg1);
	}

	@Then("^user select tc applying date as month \"([^\"]*)\" year \"([^\"]*)\" and day \"([^\"]*)\" on tc form$")
	public void user_select_tc_applying_date_as_month_year_and_day_on_tc_form(String arg1, String arg2, String arg3) throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.selectTCApplyingDate(arg1, arg2, arg3);
	}

	@Then("^user click save on tc form$")
	public void user_click_save_on_tc_form() throws Throwable {
		TCForm tc= new TCForm(dr);
		tc.clickSave();
	}
	
//receipt certificate setting
	@Then("^receipt certificate setting page is opened$")
	public void receipt_certificate_setting_page_is_opened() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.openReceiptCertificateSetting();
	}
	
	@Then("^user verify all receipt settings$")
	public void user_verify_all_receipt_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyReceiptSettings();
	}
	
	@Then("^user verify all admission receipt settings$")
	public void user_verify_all_admission_receipt_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyAdmissionReceiptSettings();
	}
	
	@Then("^user verify all prospectus receipt settings$")
	public void user_verify_all_prospectus_receipt_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyProspectusReceiptSettings();
	}

	@Then("^user verify all admission entry settings$")
	public void user_verify_all_admission_entry_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyAdmissionEntrySettings();
	}
	
	@Then("^user verify all fee certificate settings$")
	public void user_verify_all_fee_certificate_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyFeeCertificateSettings();
	}
	
	@Then("^user verify all tc settings$")
	public void user_verify_all_tc_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyTCSettings();
	}
	
	@Then("^user verify all bonafide settings$")
	public void user_verify_all_bonafide_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyBonafideSettings();
	}
	
	@Then("^user verify all character certificate settings$")
	public void user_verify_all_character_certificate_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyCharacterCertificateSettings();
	}

	@Then("^user verify all bill format settings$")
	public void user_verify_all_bill_format_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyBillFormatSettings();
	}
	
	@Then("^user verify all provisional tc settings$")
	public void user_verify_all_provisional_tc_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyProvisionalTCSettings();
	}
	
	@Then("^user verify all label format settings$")
	public void user_verify_all_label_format_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyLabelFormatSettings();
	}
	
	@Then("^user verify all birth certificate settings$")
	public void user_verify_all_birth_certificate_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyBirthCertificateSettings();
	}

	@Then("^user verify all affiliation certificate settings$")
	public void user_verify_all_affiliation_certificate_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyAffiliationCertificateSettings();
	}
	
	@Then("^user verify all loc certificate settings$")
	public void user_verify_all_loc_certificate_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyLOCCertificateSettings();
	}

	@Then("^user verify all passport apply settings$")
	public void user_verify_all_passport_apply_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyPassportApplySettings();
	}
	
	@Then("^user verify all passport issue settings$")
	public void user_verify_all_passport_issue_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyPassportIssueSettings();
	}
	
	@Then("^user verify all rural area certificate settings$")
	public void user_verify_all_rural_area_certificate_settings() throws Throwable {
		ReceiptCertificateSetting rc= new ReceiptCertificateSetting(dr);
		rc.verifyRuralAreaCertificateSettings();
	}
	
//set due limit
	@Then("^set due limit page is opened$")
	public void set_due_limit_page_is_opened() throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.openSetDueLimit();
	}

	@Then("^user click view on set due limit page$")
	public void user_click_view_on_set_due_limit_page() throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.clickView();
	}
	
	@Then("^user delete all the records on set due limit page$")
	public void user_delete_all_the_records_on_set_due_limit_page() throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.deleteAllRecords();
	}
	
	@Then("^user click yes of late fee on due on set due limit page$")
	public void user_click_yes_of_late_fee_on_due_on_set_due_limit_page() throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.clickYes();
	}

	@Then("^user enter dues amount as \"([^\"]*)\" on set due limit page$")
	public void user_enter_dues_amount_as_on_set_due_limit_page(String arg1) throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.enterDuesAmount(arg1);
	}

	@Then("^user click save on set due limit page$")
	public void user_click_save_on_set_due_limit_page() throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.clickSave();
	}

	@Then("^user enter dues percent as \"([^\"]*)\" on set due limit page$")
	public void user_enter_dues_percent_as_on_set_due_limit_page(String arg1) throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
	    due.enterDuesAmount(arg1);
	}

	@Then("^user click percent on set due limit page$")
	public void user_click_percent_on_set_due_limit_page() throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.clickPercent();
	}

	@Then("^user select class \"([^\"]*)\" on set due limit page$")
	public void user_select_class_on_set_due_limit_page(String arg1) throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.selectClass(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on set due limit page$")
	public void user_select_fee_type_on_set_due_limit_page(String arg1) throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.selectFeeType(arg1);
	}

	@Then("^user select head \"([^\"]*)\" on set due limit page$")
	public void user_select_head_on_set_due_limit_page(String arg1) throws Throwable {
		SetDueLimit due= new SetDueLimit(dr);
		due.selectFeeHead(arg1);
	}
	
//fee entry setting others
	@Then("^fee entry setting others page is opened$")
	public void fee_entry_setting_others_page_is_opened() throws Throwable {
		FeeEntrySettingOthers f= new FeeEntrySettingOthers(dr);
		f.openFeeEntrySettingOthers();
	}

//assign concession
	@Then("^assign concession page is opened$")
	public void assign_concession_page_is_opened() throws Throwable {
		AssignConcession conc= new AssignConcession(dr);
		conc.openAssignConcession();
	}
	
	@Then("^user searches a student of class \"([^\"]*)\" section \"([^\"]*)\" and text \"([^\"]*)\" on assign concession page$")
	public void user_searches_a_student_of_class_section_and_text_on_assign_concession_page(String arg1, String arg2, String arg3) throws Throwable {
		AssignConcession conc= new AssignConcession(dr);
		conc.selectClass(arg1);
		conc.selectSection(arg2);
		conc.enterText(arg3);
	}

	@Then("^user select fee type \"([^\"]*)\" on assign concession page$")
	public void user_select_fee_type_on_assign_concession_page(String arg1) throws Throwable {
		AssignConcession conc= new AssignConcession(dr);
		conc.selectFeeType(arg1);
	}

	@Then("^user select concession type \"([^\"]*)\" on assign concession page$")
	public void user_select_concession_type_on_assign_concession_page(String arg1) throws Throwable {
		AssignConcession conc= new AssignConcession(dr);
		conc.selectConcessionType(arg1);
	}

	@Then("^user select installment \"([^\"]*)\" on assign concession page$")
	public void user_select_installment_on_assign_concession_page(String arg1) throws Throwable {
		AssignConcession conc= new AssignConcession(dr);
		conc.selectInstallment(arg1);
	}

	@Then("^user assign concession on \"([^\"]*)\" as \"([^\"]*)\" to student on assign concession page$")
	public void user_assign_concession_on_as_to_student_on_assign_concession_page(String arg1, String arg2) throws Throwable {
		AssignConcession conc= new AssignConcession(dr);
		conc.assignConcessionAmount(arg1, arg2);
	}

	@Then("^user click save on assign concession page$")
	public void user_click_save_on_assign_concession_page() throws Throwable {
		AssignConcession conc= new AssignConcession(dr);
		conc.clickSave();
	}

//manual fee modification
	@Then("^manual fee modification page is opened$")
	public void manual_fee_modification_page_is_opened() throws Throwable {
		ManualFeeModification fmod=new ManualFeeModification(dr);
		fmod.openManualFeeModification();
	}

	@Then("^user search student of class \"([^\"]*)\" section \"([^\"]*)\" and text \"([^\"]*)\" on manual fee modification page$")
	public void user_search_student_of_class_section_and_text_on_manual_fee_modification_page(String arg1, String arg2, String arg3) throws Throwable {
		ManualFeeModification fmod=new ManualFeeModification(dr);
		fmod.searchStudent(arg1, arg2, arg3);
	}

	@Then("^user select installment \"([^\"]*)\" on manual fee modification page$")
	public void user_select_installment_on_manual_fee_modification_page(String arg1) throws Throwable {
		ManualFeeModification fmod=new ManualFeeModification(dr);
		fmod.selectInstallment(arg1);
	}

	@Then("^user select fee type \"([^\"]*)\" on manual fee modification page$")
	public void user_select_fee_type_on_manual_fee_modification_page(String arg1) throws Throwable {
		ManualFeeModification fmod=new ManualFeeModification(dr);
		fmod.selectFeeType(arg1);
	}

	@Then("^user enter reason to modify on manual fee modification page$")
	public void user_enter_reason_to_modify_on_manual_fee_modification_page() throws Throwable {
		ManualFeeModification fmod=new ManualFeeModification(dr);
		fmod.enterModifyReason();
	}

	@Then("^user select head \"([^\"]*)\" with amount \"([^\"]*)\"on manual fee modification page$")
	public void user_select_head_with_amount_on_manual_fee_modification_page(String arg1, String arg2) throws Throwable {
		ManualFeeModification fmod=new ManualFeeModification(dr);
		fmod.selectHead(arg1, arg2);
	}
	
	@Then("^user click modify on manual fee modification page$")
	public void user_click_modify_on_manual_fee_modification_page() throws Throwable {
		ManualFeeModification fmod=new ManualFeeModification(dr);
		fmod.clickModify();
	}

//refund head amount
	@Then("^refund head amount page is opened$")
	public void refund_head_amount_page_is_opened() throws Throwable {
		RefundHeadAmount r= new RefundHeadAmount(dr);
		r.openRefundHeadAmount();
	}
	
	@Then("^user searches a student of class \"([^\"]*)\" section \"([^\"]*)\" and text \"([^\"]*)\" on refund head amount page$")
	public void user_searches_a_student_of_class_section_and_text_on_refund_head_amount_page(String arg1, String arg2, String arg3) throws Throwable {
		RefundHeadAmount r= new RefundHeadAmount(dr);
		r.selectClass(arg1);
		r.selectSection(arg2);
		r.enterText(arg3);
	}
	
	@Then("^user select session \"([^\"]*)\" on refund head amount page$")
	public void user_select_session_on_refund_head_amount_page(String arg1) throws Throwable {
		RefundHeadAmount r= new RefundHeadAmount(dr);
		r.selectSession(arg1);
	}
	
	@Then("^user select installment \"([^\"]*)\" on refund head amount page$")
	public void user_select_installment_on_refund_head_amount_page(String arg1) throws Throwable {
		RefundHeadAmount r= new RefundHeadAmount(dr);
		r.selectInstallment(arg1);
	}

	@Then("^user enter remarks on refund head amount page$")
	public void user_enter_remarks_on_refund_head_amount_page() throws Throwable {
		RefundHeadAmount r= new RefundHeadAmount(dr);
		r.enterRemarks();
	}
	
	@Then("^user refund amount on fee head \"([^\"]*)\" on refund head amount page$")
	public void user_refund_amount_on_fee_head_on_refund_head_amount_page(String arg1) throws Throwable {
		RefundHeadAmount r= new RefundHeadAmount(dr);
		r.refundAmount(arg1);
	}

//set student status
	@Then("^set student status page is opened$")
	public void set_student_status_page_is_opened() throws Throwable {
		SetStudentStatus s= new SetStudentStatus(dr);
		s.openSetStudentStatus();
	}

	@Then("^select class \"([^\"]*)\" on set student status page$")
	public void select_class_on_set_student_status_page(String arg1) throws Throwable {
		SetStudentStatus s= new SetStudentStatus(dr);
		s.selectClass(arg1);
	}

	@Then("^select section \"([^\"]*)\" on set student status page$")
	public void select_section_on_set_student_status_page(String arg1) throws Throwable {
		SetStudentStatus s= new SetStudentStatus(dr);
		s.selectSection(arg1);
	}
	
	@Then("^set student \"([^\"]*)\" status as \"([^\"]*)\" on set student status page$")
	public void set_student_status_as_on_set_student_status_page(String arg1, String arg2) throws Throwable {
		SetStudentStatus s= new SetStudentStatus(dr);
		s.setStudentStatus(arg1, arg2);
		s.clickSave();
	}
	
//student registration on admission module
	@Then("^search student of class \"([^\"]*)\" section \"([^\"]*)\" and name \"([^\"]*)\" on student registration page$")
	public void search_student_of_class_section_and_name_on_student_registration_page(String arg1, String arg2, String arg3) throws Throwable {
		StudentRegistration reg= new StudentRegistration(dr);
		reg.openStudentRegistration();
		reg.selectClass(arg1);
		reg.selectSection(arg2);
		reg.enterSearchText(arg3);
	}

	@Then("^set student status as \"([^\"]*)\" on student registration page$")
	public void set_student_status_as_on_student_registration_page(String arg1) throws Throwable {
		StudentRegistration reg= new StudentRegistration(dr);
		reg.setStudentStatus(arg1);
	}
	
//assign concession to student
	@Then("^assign concession to student page is opened$")
	public void assign_concession_to_student_page_is_opened() throws Throwable {
		AssignConcessionToStudent c= new AssignConcessionToStudent(dr);
		c.openAssignConcessionToStudent();
	}

	@Then("^select class \"([^\"]*)\" on assign concession to student page$")
	public void select_class_on_assign_concession_to_student_page(String arg1) throws Throwable {
		AssignConcessionToStudent c= new AssignConcessionToStudent(dr);
		c.selectClass(arg1);
	}

	@Then("^select section \"([^\"]*)\" on assign concession to student page$")
	public void select_section_on_assign_concession_to_student_page(String arg1) throws Throwable {
		AssignConcessionToStudent c= new AssignConcessionToStudent(dr);
		c.selectSection(arg1);
	}

	@Then("^assign concession \"([^\"]*)\" to student \"([^\"]*)\" on assign concession to student page$")
	public void assign_concession_to_student_on_assign_concession_to_student_page(String arg1, String arg2) throws Throwable {
		AssignConcessionToStudent c= new AssignConcessionToStudent(dr);
		c.assignConcessionToStudent(arg1, arg2);
	}

	@Then("^click update on assign concession to student page$")
	public void click_update_on_assign_concession_to_student_page() throws Throwable {
		AssignConcessionToStudent c= new AssignConcessionToStudent(dr);
		c.clickUpdate();
	}

//assign transport to students
	@Then("^assign transport to students page is opened$")
	public void assign_transport_to_students_page_is_opened() throws Throwable {
		AssignTransportToStudents tr= new AssignTransportToStudents(dr);
		tr.openAssignTransportToStudents();
	}

	@Then("^user select class \"([^\"]*)\" on assign transport to students page$")
	public void user_select_class_on_assign_transport_to_students_page(String arg1) throws Throwable {
		AssignTransportToStudents tr= new AssignTransportToStudents(dr);
		tr.selectClass(arg1);
	}

	@Then("^user select section \"([^\"]*)\" on assign transport to students page$")
	public void user_select_section_on_assign_transport_to_students_page(String arg1) throws Throwable {
		AssignTransportToStudents tr= new AssignTransportToStudents(dr);
		tr.selectSection(arg1);
	}

	@Then("^assign transport to \"([^\"]*)\" route \"([^\"]*)\" stop \"([^\"]*)\" vehicle \"([^\"]*)\" and months \"([^\"]*)\" on assign transport to students page$")
	public void assign_transport_to_route_stop_vehicle_and_months_on_assign_transport_to_students_page(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		AssignTransportToStudents tr= new AssignTransportToStudents(dr);
		tr.assignTransport(arg1, arg2, arg3, arg4, arg5);
	}

//assign opening balance
	@Then("^assign opening balance page is opened$")
	public void assign_opening_balance_page_is_opened() throws Throwable {
		AssignOpeningBalance op= new AssignOpeningBalance(dr);
		op.openAssignOpeningBalance();
	}

	@Then("^select class \"([^\"]*)\" on assign opening balance page$")
	public void select_class_on_assign_opening_balance_page(String arg1) throws Throwable {
		AssignOpeningBalance op= new AssignOpeningBalance(dr);
		op.selectClass(arg1);
	}

	@Then("^select section \"([^\"]*)\" on assign opening balance page$")
	public void select_section_on_assign_opening_balance_page(String arg1) throws Throwable {
		AssignOpeningBalance op= new AssignOpeningBalance(dr);
		op.selectSection(arg1);
	}

	@Then("^select fee type \"([^\"]*)\" on assign opening balance page$")
	public void select_fee_type_on_assign_opening_balance_page(String arg1) throws Throwable {
		AssignOpeningBalance op= new AssignOpeningBalance(dr);
		op.selectFeeType(arg1);
	}

	@Then("^assign opening balance to student \"([^\"]*)\" of amount \"([^\"]*)\" on assign opening balance page$")
	public void assign_opening_balance_to_student_of_amount_on_assign_opening_balance_page(String arg1, String arg2) throws Throwable {
		AssignOpeningBalance op= new AssignOpeningBalance(dr);
		op.assignOpeningBalance(arg1, arg2);
	}

	@Then("^click save on assign opening balance page$")
	public void click_save_on_assign_opening_balance_page() throws Throwable {
		AssignOpeningBalance op= new AssignOpeningBalance(dr);
		op.clickSave();
	}


}