Feature: Franciscan ERP

  @scenario1
  Scenario: Day Wise Total Collection
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then day wise total collection report is opened
    Then user select school "Inspiration public school" on day wise total collection report
    Then user select fee type "SCHOOL FEE" on day wise total collection report
    Then user select class "test1" on day wise total collection report
    Then user select section "A" on day wise total collection report
    Then user select till date as month "April" year "2016" and day "1" on day wise total collection report
    Then user click show on day wise total collection report

  @scenario2
  Scenario: Day Wise Total Collection
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then day wise total collection report is opened
    Then user select school "Inspiration public school" on day wise total collection report
    Then user select fee type "SCHOOL FEE" on day wise total collection report
    Then user select class "test1" on day wise total collection report
    Then user select section "A" on day wise total collection report
    Then user select user "eCare Admin" on day wise total collection report
    Then user select till date as month "April" year "2016" and day "30" on day wise total collection report
    Then user click show on day wise total collection report

  @scenario3
  Scenario: Day Wise Total Collection
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then day wise total collection report is opened
    Then user select entry mode "School" on day wise total collection report
    Then user select fee type "SCHOOL FEE" on day wise total collection report
    Then user select month "Apr" on day wise total collection report
    Then user select class "1" on day wise total collection report
    Then user select section "A" on day wise total collection report
    Then user select installment "MAY - JUNE" on day wise total collection report
    Then user select pay mode "Cash" and "Cheque" on day wise total collection report
    Then user select till date as month "June" year "2016" and day "30" on day wise total collection report
    Then user click show on day wise total collection report
