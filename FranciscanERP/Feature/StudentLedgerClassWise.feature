Feature: Franciscan ERP

  @scenario1
  Scenario: Student Ledger Class Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student ledger class wise page is opened
    Then user select school "Inspiration public school" on student ledger class wise page
    Then user select class "test1" on student ledger class wise page
    Then user select section "A" on student ledger class wise page
    Then user select installment "JULY - AUGUST" on student ledger class wise page
    Then user select with fine on student ledger class wise page
    Then user select date as month "January" year "2016" and day "8" on student ledger class wise page
    Then user click show on student ledger class wise page

  @scenario2
  Scenario: Student Ledger Class Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student ledger class wise page is opened
    Then user select class "test1" on student ledger class wise page
    Then user select fee type "SCHOOL FEE" on student ledger class wise page
    Then user select only full fear paid fees on student ledger class wise page
    Then user click show on student ledger class wise page
