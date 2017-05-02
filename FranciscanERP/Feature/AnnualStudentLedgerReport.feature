Feature: Franciscan ERP

  @scenario1
  Scenario: Annual Student Ledger Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then annual student ledger report page is opened
    Then user select installment "JULY - AUGUST" on annual student ledger report page
    Then user select class "test1" on annual student ledger report page
    Then user select section "A" on annual student ledger report page
    Then user click show on annual student ledger report page
