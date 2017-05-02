Feature: Franciscan ERP

  @scenario1
  Scenario: Fee Cheque Bounce Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then cheque bounce report is opened
    Then user select school"All Schools" on cheque bounce report
    Then user select class"1" on cheque bounce report
    Then user select section"A" on cheque bounce report
    Then user click on show on cheque bounce report

  @scenario2
  Scenario: Fee Cheque Bounce Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then cheque bounce report is opened
    Then user select date from as month"January" year "2016" and day"1" on cheque bounce report
    Then user select date to as month"February" year "2016" and day"1" on cheque bounce report
    Then user select class"1" on cheque bounce report
    Then user select section"A" on cheque bounce report
    Then user select bank name"Axsis Bank For Juniors" on cheque bounce report
    Then user select the user"eCare Admin" on cheque bounce report
    Then user click on show on cheque bounce report
