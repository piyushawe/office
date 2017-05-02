Feature: Franciscan ERP

  @scenario1
  Scenario: Annual Student Ledger2
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then annual student ledger two page is opened
    Then user select class"test1" on annual student ledger two page
    Then user select section"A" on annual student ledger two page
    Then user enter the student "sonia1" to search on annual student ledger two page
    Then user select fee type "SCHOOL FEE" on annual student ledger two page
    Then user click show on annual student ledger two page
    