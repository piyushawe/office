Feature: Franciscan ERP

  @scenario1
  Scenario: Annual Student Ledger3
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then annual student ledger three page is opened
    Then user select installment "MAY - JUNE" on annual student ledger three page
    Then user select class"1" on annual student ledger three page
    Then user select section"A" on annual student ledger three page
    Then user click show on annual student ledger three page
    