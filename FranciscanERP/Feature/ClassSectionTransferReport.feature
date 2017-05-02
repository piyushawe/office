Feature: Franciscan ERP

  @scenario1
  Scenario: Class Section Transfer Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class section transfer report is opened
    Then user select class "4" on class section transfer report
    Then user select section "A" on class section transfer report
    Then user select old academic year "2016-2017" on class section transfer report
    Then user select old financial year "2016-2017" on class section transfer report
    Then user click on show on class section transfer report
