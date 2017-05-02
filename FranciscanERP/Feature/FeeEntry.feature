Feature: Fee Entry
    As a user
    I would like to do fee payment with different user stories
    using different fields at different times

  @scenario1
  Scenario: Normal Fee Entry and Receipt Generation(full payment of installment)
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    And user selects installment"APRIL" on fee entry form
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form

  @scenario2
  Scenario: Show Installment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user clicks on show installment button of fee entry

  @scenario3
  Scenario: To verify fee entry on daily fee collection report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then daily fee collection report is opened
    Then selects class"1-A" on daily fee collection
    Then clicks on show button of daily fee collection

  @scenario4
  Scenario: To test fee receipt with manual late fine, discount and advance amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then impose manual late fine"200"
    Then give discount of rs"100"
    Then click on show of fee entry form
    Then pay advance amount of rs"1000"
    Then click on save of fee entry form

  @scenario5
  Scenario: To cancel the fee receipt and verify on cancelled fees receipt report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then user opens cancelled fees receipt report page
    Then user clicks on show

  @scenario6
  Scenario: To bounce the fee cheque and verify on fees cheque bounce report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then cheque bounce report is opened
    Then user click on show on cheque bounce report

  @scenario7
  Scenario: To pay fee by cheque, clear the cheque and verify on cheque clearing status report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then clear the cheque on fee cheque clearing page
    Then user enter clearing date as month "March" year "2017" and day "21" on fee cheque clearing page
    Then user click save on fee cheque clearing page
    Then go back to the default page
    Then cheque clearing status report is opened
    Then user select class"1-A" on cheque clearing status report
    Then user click show on cheque clearing status report

  @scenario8
  Scenario: To pay fee by cheque, bounce the cheque and test cheque bounce fine
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then verify cheque bounce fine on fee entry form
    Then impose manual cheque bounce fine of rs "250"
    Then verify cheque bounce fine on fee entry form

  @scenario9
  Scenario: To pay advance amount and verify on advance payment report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user gets selected installment on fee entry form
    Then pay advance amount of rs"1000"
    Then click on save of fee entry form
    Then go back to the default page
    Then user opens advance payment report
    Then user select class"1" on advance payment report
    Then user select section"A" on advance payment report
    Then user click on show on advance payment report

  @scenario10
  Scenario: To test the impact of cancelling the fee receipt on fee entry form
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user gets selected installment on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form

  @scenario11
  Scenario: To test the impact of cancelling the fee receipt on modify fee receipt form
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user gets selected installment on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user select installment on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then verify modify fee receipt

  @scenario12
  Scenario: To test fine waive off on multiple installments on fee entry form
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments
    Then waive off late fine on fee entry form
    Then verify fine waive off on multiple installments

  @scenario13
  Scenario: To test the impact of cancelling on fee receipt and certificate
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user gets selected installment on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user clicks on show installment button of fee entry
    Then user verify receipt on fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user select installment on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user clicks on show installment button of fee entry
    Then user verify receipt on fee entry form
    Then go back to the default page
    Then verify fee certificate of "sonia5" of class"test1" section"A" on print fee receipt and cerificate

  @scenario14
  Scenario: To test receipt reuse when cheque is bounced
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"suryansh vinayak"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user clicks on reuse receipt

  @scenario15
  Scenario: To test receipt reuse when cheque is bounced
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"suryansh vinayak"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user clicks on reuse receipt

  @scenario16
  Scenario: To adjust the advance amount paid previously in next installment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then pay advance amount of rs"1000"
    Then click on save of fee entry form
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click adjust advance on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form

  @scenario17
  Scenario: To test the impact of receipt cancellation when late fine was waived off
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then waive off late fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form

  @scenario18
  Scenario: To impose cheque bounce and late fee manually, cancel the receipt and test the impact on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then impose manual late fine"200"
    Then impose manual cheque bounce fine of rs "250"
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form

  @scenario19
  Scenario: To impose cheque bounce and late fee manually, delete the receipt and test the impact on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then impose manual late fine"200"
    Then impose manual cheque bounce fine of rs "250"
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then delete the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form

  @scenario20
  Scenario: To test enable waive off with cheque bounce, cancel the receipt and impact on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then click enable waive off with cheque bounce
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then waive off late fine on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form

  @scenario21
  Scenario: To submit fee on fee entry form when all type of late fine and cheque bounce fine is not paid and then the receipt is cancelled
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then pay fee amount without any late fee or cheque bounce
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form

  #set due limit
  @scenario22
  Scenario: To test when all fee is paid without any late fee (payment of all head except late fee)
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form
    Then pay fee amount without any late fee or cheque bounce
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then click on show of fee entry form

  @scenario23
  Scenario: To test when all late fee is paid without any fee head
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form
    Then all late fee is paid without any head
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then click on show of fee entry form

  @scenario24
  Scenario: To test complete payment of all head except partial late fee where amount left is greater than due amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"July" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form
    Then pay partial late fee where amount left is greater "greater" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"August" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form

  @scenario25
  Scenario: To test complete payment of all head except partial late fee where amount left is less than due amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then pay partial late fee where amount left is less "less" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form

  @scenario26
  Scenario: To waive off late fee and partial fee is taken in such a way that amount left is greater than due amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then waive off late fine on fee entry form
    Then pay partial fee where amount left is "greater" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then click on show of fee entry form

  @scenario27
  Scenario: To test all head payment except partial late where amount left is less than due amount, apply manual late fee greater than due limit
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then pay partial late fee where amount left is less "less" than due amount
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then impose manual late fine"200"

  @scenario28
  Scenario: To test runtime Concession on head (not on late fee) in such a way partial amount left is greater than due limit
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then apply runtime concession on "TUITION FEE" on fee entry form
    Then pay partial fee where amount left is "greater" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form

  @scenario29
  Scenario: To test runtime Concession on head (not on late fee) in such a way partial amount left is less than due limit
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then apply runtime concession on "TUITION FEE" on fee entry form
    Then pay partial fee where amount left is "less" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form

  @scenario30
  Scenario: To test runtime Concession on late fee in such a way partial amount left is greater than due limit
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"July" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then apply runtime concession on "LATE FEE(SCHOOL FEE)" on fee entry form
    Then pay partial late fee where amount left is greater "greater" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"August" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form

  @scenario31
  Scenario: To test runtime Concession on late fee in such a way partial amount left is less than due limit
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"July" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then apply runtime concession on "LATE FEE(SCHOOL FEE)" on fee entry form
    Then pay partial late fee where amount left is less "less" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"August" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then click on show of fee entry form

  @scenario32
  Scenario: To test runtime Concession on head (not on late fee) in such a way partial amount left is equal to due limit
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"April" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then apply runtime concession on "TUITION FEE" on fee entry form
    Then pay partial fee where amount left is "equal to" than due amount
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    Then user selects the date as month"May" year"2016" and day"25" on fee entry page
    Then click on show of fee entry form

  #mid year
  @scenario33
  Scenario: To test mid year link without selecting a student
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then set student as a mid year from installment "2" on fee entry page

  @scenario34
  Scenario: To test mid year when student is old
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia1" on student registration page
    Then set student status as "old" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then set student as a mid year from installment "2" on fee entry page

  @scenario35
  Scenario: To test mid year of a new student after taking payment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then click on save of fee entry form
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "2" on fee entry page

  @scenario36
  Scenario: To test mid year of a new student after cancelling the fee receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "2" on fee entry page

  @scenario37
  Scenario: To test mid year of a new student after deleting the fee receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then click on save of fee entry form
    Then go back to the default page
    Then delete the receipt of the fee by class"1" section"A" and student details"sonia2"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "2" on fee entry page

  @scenario38
  Scenario: To set student as a mid year from second installment with all lifetime and annual heads
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then verify total installments on fee entry page
    Then set student as a mid year from installment "2" on fee entry page
    Then verify total installments on fee entry page

  @scenario39
  Scenario: To set student as a mid year from second installment with all lifetime and annual heads and then from third installment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "2" on fee entry page
    Then verify total installments on fee entry page
    Then verify pay schedule "Lifetime" on fee entry page
    Then verify pay schedule "Annual" on fee entry page
    Then set student as a mid year from installment "3" on fee entry page
    Then verify total installments on fee entry page
    Then verify pay schedule "Lifetime" on fee entry page
    Then verify pay schedule "Annual" on fee entry page

  @scenario40
  Scenario: To set student as a mid year from second installment with all lifetime and annual heads and then from first installment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "2" on fee entry page
    Then verify total installments on fee entry page
    Then verify pay schedule "Lifetime" on fee entry page
    Then verify pay schedule "Annual" on fee entry page
    Then set student as a mid year from installment "1" on fee entry page
    Then verify total installments on fee entry page
    Then verify pay schedule "Lifetime" on fee entry page
    Then verify pay schedule "Annual" on fee entry page

  @scenario41
  Scenario: To set student as a mid year from second installment with all lifetime and annual heads and save fee. Delete the receipt and restructure to first installment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "2" on fee entry page
    Then verify total installments on fee entry page
    Then verify pay schedule "Lifetime" on fee entry page
    Then verify pay schedule "Annual" on fee entry page
    Then click on save of fee entry form
    Then go back to the default page
    Then delete the receipt of the fee by class"1" section"A" and student details"sonia2"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "1" on fee entry page
    Then verify total installments on fee entry page
    Then verify pay schedule "Lifetime" on fee entry page
    Then verify pay schedule "Annual" on fee entry page

  @scenario42
  Scenario: To set student as a mid year from second installment with all lifetime and annual heads and save fee. Delete the receipt and restructure to first installment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then admission home page is opened
    Then search student of class "test1" section "A" and name "sonia2" on student registration page
    Then set student status as "new" on student registration page
    Then go back to the default page
    Then open fee home page
    Then assign concession to student page is opened
    Then select class "test1" on assign concession to student page
    Then select section "A" on assign concession to student page
    Then assign concession "20% Concession Adm APRIL" to student "sonia2" on assign concession to student page
    Then assign concession "30% Concession Tuition fee MAY - JUNE" to student "sonia2" on assign concession to student page
    Then click update on assign concession to student page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then set student as a mid year from installment "2" on fee entry page
    Then verify total installments on fee entry page

  @scenario43
  Scenario: To set student as a mid year, fee to be paid- current installment + admission fee + all annual charges.
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then set student as a mid year from installment "2" on fee entry page
    Then click on show of fee entry form
    Then click on save of fee entry form

  @scenario44
  Scenario: To test mid year student from same branch of school when only current installment fee is to be taken
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"school" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then set student as a mid year from installment "2" on fee entry page
    Then go back to the default page
    Then search student by class"1" section"A" and student details"sonia2" on manual fee modification
    Then user select installment "2" on manual fee modification page
    Then user select fee type "SCHOOL FEE" on manual fee modification page
    Then user enter reason to modify on manual fee modification page
    Then enter amount "0" to head "ADMISSION FEE" on manual fee modification page
    Then enter amount "0" to head "DEVELOPMENT FEE" on manual fee modification page
    Then enter amount "0" to head "ESTABLISHMENT FEE" on manual fee modification page
    Then enter amount "0" to head "BUILDING MAINT. FEE" on manual fee modification page
    Then user click modify on manual fee modification page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia2"
    Then waive off late fine on fee entry form

  #advance amount
  @scenario45
  Scenario: To test adjust advance amount when advance amount is greater than to be paid amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia8"
    Then user find total amount to be paid from fee entry page
    Then go back to the default page
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia8" of amount "greater than" paid amount on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia8"
    Then click adjust advance on fee entry form
    Then verify advance on fee entry page
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia8"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  @scenario46
  Scenario: To test adjust advance amount when advance amount is less than to be paid amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user find total amount to be paid from fee entry page
    Then go back to the default page
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia2" of amount "less than" paid amount on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then click adjust advance on fee entry form
    Then verify advance on fee entry page
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  @scenario47
  Scenario: To test adjust advance amount when advance amount is equal to- to be paid amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user find total amount to be paid from fee entry page
    Then go back to the default page
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia2" of amount "equal to" paid amount on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then click adjust advance on fee entry form
    Then verify advance on fee entry page
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  @scenario48
  Scenario: To test adjust advance amount and fee is taken in such a way that dues are left
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia2" of amount "1000" on assign opening balance page
    Then click save on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then click adjust advance on fee entry form
    Then pay amount less than to be paid amount on fee entry page
    Then user verify dues on fee entry page
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  @scenario49
  Scenario: To test adjust advance amount and fee is taken in such a way that again advance amount is left
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia2" of amount "1000" on assign opening balance page
    Then click save on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then click adjust advance on fee entry form
    Then pay advance amount of rs"500"
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  @scenario50
  Scenario: To test when a head amount is not paid and some advance amount is paid
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then make head "TUITION FEE" amount as zero
    Then user verify dues on fee entry page
    Then user find total amount to be paid from fee entry page
    Then pay advance amount of rs"1000"
    Then user find total amount to be paid from fee entry page
    Then user verify dues on fee entry page
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  @scenario51
  Scenario: To test when some advance amount is paid and head amount is not paid
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia9"
    Then pay advance amount of rs"1000"
    Then make head "TUITION FEE" amount as zero
    Then user verify dues on fee entry page
    Then user find total amount to be paid from fee entry page
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia9"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  @scenario52
  Scenario: To test when some dues are left and then advance amount is paid
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia9"
    Then pay amount less than to be paid amount on fee entry page
    Then user find total amount to be paid from fee entry page
    Then user verify dues on fee entry page
    Then pay advance amount of rs"2000"
    Then verify advance on fee entry page
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia9"
    Then user clicks on show installment button of fee entry
    Then verify advance on fee receipt

  #waive off late fine
  @scenario53
  Scenario: To test the fine waive off on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user verify late fine on fee entry form
    Then waive off late fine on fee entry form
    Then user verify late fine on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user clicks on show installment button of fee entry
    Then user verify receipt on fee entry form

  @scenario54
  Scenario: To test the fine waive off, cancel the receipt and verify on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user verify late fine on fee entry form
    Then waive off late fine on fee entry form
    Then user verify late fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user verify late fine on fee entry form

  @scenario55
  Scenario: To test the fine waive off, delete the receipt and verify on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects the date as month"August" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user verify late fine on fee entry form
    Then waive off late fine on fee entry form
    Then user verify late fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then delete the receipt of the fee by class"1" section"A" and student details"sonia1"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user verify late fine on fee entry form

  @scenario56
  Scenario: To test fine waive off when partial late fee is taken previously and remaining late fee is waived off
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    Then click on show of fee entry form
    Then partial late fee is paid on fee entry form
    Then user verify late fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    Then user verify late fine on fee entry form
    Then waive off late fine on fee entry form
    Then click on show of fee entry form
    Then user verify late fine on fee entry form
    Then click on save of fee entry form

  @scenario57
  Scenario: To test fine waive off on multiple installments, cancel the receipt and verify on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments
    Then waive off late fine on fee entry form
    Then verify fine waive off on multiple installments
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"aditya ranjan"
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments

  @scenario58
  Scenario: To test fine waive off on single installment when all heads payment is done
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user verify late fine on fee entry form
    Then pay fee amount without any late fee or cheque bounce
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user verify late fine on fee entry form
    Then waive off late fine on fee entry form
    Then user verify late fine on fee entry form
    Then click on save of fee entry form

  @scenario59
  Scenario: To test fine waive off on multiple installments when all heads payment is done
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments
    Then pay fee of multiple installments without any late fee or cheque bounce
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments
    Then waive off late fine on fee entry form
    Then verify fine waive off on multiple installments

  @scenario60
  Scenario: To test when one head fee is left with partial late fee payment, paid remaining head fee and waive off late fee and then the receipts are cancelled(R2,R1)
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then make head "TUITION FEE" amount as zero
    Then partial late fee is paid on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then waive off late fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee by class"1" section"A" and student details"sonia1"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form

  @scenario61
  Scenario: To test when one head fee is left with partial late fee payment, paid remaining head fee and waive off late fee and then the receipts are cancelled(R1,R2)
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then make head "TUITION FEE" amount as zero
    Then partial late fee is paid on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then waive off late fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee by class"1" section"A" and student details"sonia1"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form

  @scenario62
  Scenario: To test cheque bounce twice, waive off with cheque bounce, cancel the receipt and verify on fee entry page
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then verify cheque bounce fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then click enable waive off with cheque bounce
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then verify cheque bounce fine on fee entry form
    Then waive off late fine on fee entry form
    Then verify cheque bounce fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then verify cheque bounce fine on fee entry form
    Then user verify late fine on fee entry form

  @scenario63
  Scenario: To test when two fee heads are left with partial late fee payment, paid one fee head and partial late fee, remaining fee head is paid and late fee waived off and then the receipts are cancelled(R2,R1)
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then make head "TUITION FEE" amount as zero
    Then make head "LIBRARY, IT FEE" amount as zero
    Then partial late fee is paid on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then make head "LIBRARY, IT FEE" amount as zero
    Then partial late fee is paid on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then waive off late fine on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee by class"test1" section"A" and student details"sonia1"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form

  #manual late fee
  @scenario64
  Scenario: To test manual late fine when partial late fee is taken previously and remaining late fee is imposed manually
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    Then click on show of fee entry form
    Then partial late fee is paid on fee entry form
    Then user verify late fine on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    Then user verify late fine on fee entry form
    Then impose manual late fine"200"
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee by class"1" section"A" and student details"sonia1"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user verify late fine on fee entry form

  @scenario65
  Scenario: To test manual late fine on multiple installments when manual late fee setting is done for single installment
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then enable manual late fee for "single" installment on fee entry setting others page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments
    Then impose manual late fine"500"
    Then verify late fee on multiple installments
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments

  @scenario66
  Scenario: To test manual late fine on multiple installments when manual late fee setting is done for multiple installments
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then enable manual late fee for "multiple" installment on fee entry setting others page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments
    Then impose manual late fine"500"
    Then verify late fee on multiple installments
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"1" section"A" and student details"sonia1"
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify late fee on multiple installments

  #manual cheque bounce
  @scenario67
  Scenario: To test manual cheque bounce fine on multiple installments, cancel the receipt and verify on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then verify cheque bounce fine on fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee by class"test1" section"A" and student details"sonia1"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify cheque bounce fine on multiple installments
    Then impose manual cheque bounce fine of rs "500"
    Then verify cheque bounce fine on multiple installments
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then verify cheque bounce fine on multiple installments

  @scenario68
  Scenario: To test manual cheque bounce fine after cancelling the receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"School" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    And selects pay mode"Cash" on fee entry form
    Then verify cheque bounce fine on fee entry form
    Then impose manual cheque bounce fine of rs "200"
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then verify cheque bounce fine on fee entry form
    
  #runtime concession
  @scenario69
  Scenario: To test runtime concession on fee entry, bounce the cheque and verify concession on fee entry
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then impose manual late fine"500"
    Then apply runtime concession on "TUITION FEE" on fee entry form
    Then pay partial fee on head "TUITION FEE" on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    And selects pay mode"Cheque" on fee entry form
    Then verify cheque bounce fine on fee entry form
    Then impose manual late fine"200"
    Then verify cheque bounce fine on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user clicks on show installment button of fee entry
    Then user verify receipt on fee entry form

  #assigned concession
  @scenario70
  Scenario: To test assigned concession, partial payment is made, paid remaining amount and the second receipt is cancelled  
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign concession to student page is opened
    Then select class "test1" on assign concession to student page
    Then select section "A" on assign concession to student page
    Then assign concession "20% Concession Adm APRIL" to student "sonia1" on assign concession to student page
    Then assign concession "30% Concession Tuition fee MAY - JUNE" to student "sonia1" on assign concession to student page
    Then click update on assign concession to student page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then pay partial fee on head "TUITION FEE" on fee entry form
    Then click on save of fee entry form
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cash" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    
  @scenario71
  Scenario: To test when some installments are taken, assign concession, fee paid and last two receipts are cancelled
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then user select installments "2" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then assign concession to student page is opened
    Then select class "test1" on assign concession to student page
    Then select section "A" on assign concession to student page
    Then assign concession "30% Concession Tuition fee APRIL" to student "sonia1" on assign concession to student page
    Then assign concession "30% Concession Tuition fee MAY - JUNE" to student "sonia1" on assign concession to student page
    Then assign concession "30% Concession Tuition fee JULY - AUGUST" to student "sonia1" on assign concession to student page
    Then assign concession "30% Concession Tuition fee SEPTEMBER - OCTOBER" to student "sonia1" on assign concession to student page
    Then assign concession "30% Concession Tuition fee NOVEMBER - DECEMBER" to student "sonia1" on assign concession to student page
    Then assign concession "30% Concession Tuition fee JANUARY - MARCH" to student "sonia1" on assign concession to student page
    Then click update on assign concession to student page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia2"
    Then go back to the default page
    Then cancel the receipt of the fee by class"test1" section"A" and student details"sonia1"
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    
  @scenario72
  Scenario: To test when partial payment is done on a fee head, assign concession on that fee head
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    And user selects installment"MAY - JUNE" on fee entry form
    Then click on show of fee entry form
    Then pay partial fee on head "TUITION FEE" on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then assign concession to student page is opened
    Then select class "test1" on assign concession to student page
    Then select section "A" on assign concession to student page
    Then assign concession "30% Concession Tuition fee APRIL" to student "sonia1" on assign concession to student page
    Then assign concession "30% Concession Tuition fee MAY - JUNE" to student "sonia1" on assign concession to student page
    Then click update on assign concession to student page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    And user selects installment"MAY - JUNE" on fee entry form
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    Then click on show of fee entry form
    Then user verify fee details on fee entry form
    And user selects installment"APRIL" on fee entry form
    Then click on show of fee entry form
    Then user verify fee details on fee entry form
    
  @scenario73
  Scenario: To test partial late fee when manual late fee is imposed with discount, bounce the cheque, again manual late fee and cheque bounce fee is taken and receipt is cancelled, verify on fee entry 
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects the date as month"September" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cheque" on fee entry form
    And user selects installment"JULY - AUGUST" on fee entry form
    Then impose manual late fine"200"
    Then give discount of rs"100"
    Then click on show of fee entry form
    Then partial late fee is paid on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then bounce the cheque of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects the date as month"September" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cash" on fee entry form
    And user selects installment"JULY - AUGUST" on fee entry form
    Then impose manual late fine"200"
    Then impose manual cheque bounce fine of rs "250"
    Then click on show of fee entry form
    Then user verify fee details on fee entry form
    Then click on save of fee entry form
    Then go back to the default page
    Then cancel the receipt of the fee
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia1"
    Then user selects the date as month"September" year"2016" and day"25" on fee entry page
    Then user selects bank name"Axsis Bank For Juniors" on fee entry
    Then select entry mode"Bank" on fee entry form
    And selects pay mode"Cash" on fee entry form
    And user selects installment"JULY - AUGUST" on fee entry form
    Then click on show of fee entry form
    Then user verify fee details on fee entry form