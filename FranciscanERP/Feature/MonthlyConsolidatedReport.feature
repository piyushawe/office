Feature: Franciscan ERP

  @scenario1
  Scenario: Monthly Consolidated Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then monthly consolidated report is opened
    Then user select entry mode "School" on monthly consolidated report
    Then user select school "Inspiration public school" on monthly consolidated report
    Then user select fee type "SCHOOL FEE" on monthly consolidated report
    Then user select class "1-A" on monthly consolidated report
    Then user select installment "APRIL" on monthly consolidated report
    Then user select paymode "Cash" on monthly consolidated report
    Then user select bank name "Axsis Bank For Juniors" on monthly consolidated report
    Then user select user "eCare Admin" on monthly consolidated report
    Then user click head wise on monthly consolidated report
    Then user click show on monthly consolidated report

  @scenario2
  Scenario: Monthly Consolidated Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then monthly consolidated report is opened
    Then user select school "Inspiration public school" on monthly consolidated report
    Then user select fee type "SCHOOL FEE" on monthly consolidated report
    Then select month "Apr" on monthly consolidated report
    Then user select class "2-A" on monthly consolidated report
    Then user select installment "MAY - JUNE" on monthly consolidated report
    Then user select paymode "Cash" and "Cheque" on monthly consolidated report
    Then user click filter with cheque clearing date on monthly consolidated report
    Then user click class wise on monthly consolidated report
    Then user click show on monthly consolidated report

  @scenario3
  Scenario: Monthly Consolidated Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then monthly consolidated report is opened
    Then user select school "Inspiration public school" on monthly consolidated report
    Then user select fee type "SCHOOL FEE" on monthly consolidated report
    Then user click filter with cheque clearing date on monthly consolidated report
    Then user click without head total amount on monthly consolidated report
    Then user click show on monthly consolidated report
