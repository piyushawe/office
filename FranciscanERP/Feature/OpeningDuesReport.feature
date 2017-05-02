Feature: Franciscan ERP

  @scenario1
  Scenario: Opening Dues Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then opening dues report page is opened
    Then user select class"2" on opening dues report
    Then user select section "A" on opening dues report
    Then user select installment"APRIL" on opening dues report
    Then user click on show on opening dues report

  @scenario2
  Scenario: Opening Dues Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then opening dues report page is opened
    Then user select school "Inspiration public school" on opening dues report
    Then user select class"5" on opening dues report
    Then user select fee type "SCHOOL FEE" on opening dues report
    Then user select installment"MAY - JUNE" on opening dues report
    Then user select user "eCare Admin" on opening dues report
    Then user click on show on opening dues report
