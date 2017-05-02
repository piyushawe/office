Feature: Franciscan ERP

  @scenario1
  Scenario: Bad Debts Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then bad debts report page is opened
    Then user select fee type "SCHOOL FEE" on bad debts report page
    Then user select class "test1" on bad debts report page
    Then user select installment "APRIL" on bad debts report page
    Then user click show on bad debts report page
