Feature: Franciscan ERP

  @scenario1
  Scenario: Fees Student Ledger
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fees student ledger page is opened
    Then user select class"1" on fees student ledger page
    Then user enter student "aditya ranjan" to search on fees student ledger page
    Then user select fee type"SCHOOL FEE" on fees student ledger page
    Then user select till date as month"February" year "2016" and day "1" on fees student ledger page
    Then user click without head on fees student ledger page
    Then user click show on fees student ledger page

  @scenario2
  Scenario: Fees Student Ledger
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fees student ledger page is opened
    Then user select class"1" on fees student ledger page
    Then user enter student "aditya ranjan" to search on fees student ledger page
    Then user select fee type"SCHOOL FEE" on fees student ledger page
    Then user click with head on fees student ledger page
    Then user click show on fees student ledger page
