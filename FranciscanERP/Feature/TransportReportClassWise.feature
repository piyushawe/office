Feature: Franciscan ERP

  @scenario1
  Scenario: Transport Report Class Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then transport report class wise page is opened
    Then user click class wise on transport report class wise page
    Then user select installment "APRIL" on transport report class wise page
    Then user enter stop fare "1000" on transport report class wise page
    Then user select class "1-A" on transport report class wise page
    Then user click show on transport report class wise page

  @scenario2
  Scenario: Transport Report Class Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then transport report class wise page is opened
    Then user click bus stop wise on transport report class wise page
    Then user select installment "MAY - JUNE" on transport report class wise page
    Then user enter stop fare "1000" on transport report class wise page
    Then user select route "R01" on transport report class wise page
    Then user select bus stop "A1" on transport report class wise page
    Then user click show on transport report class wise page
