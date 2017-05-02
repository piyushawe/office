Feature: Advance Payment Report
     As a user I would like to open advance payment report
     So that I don't have to open myself

  @scenario1
  Scenario: To test advance payment report based on different filters
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then advance payment report is opened
    Then user select installment"SEPTEMBER - OCTOBER" on advance payment report
    Then user select class"1" on advance payment report
    Then user select section"A" on advance payment report
    Then user select fee type"SCHOOL FEE" on advance payment report
    Then user select school"Inspiration public school" on advance payment report
    Then user select month"May" year"2016" and day"9" on advance payment report
    Then user click on show on advance payment report

  @scenario2
  Scenario: To test advance payment report based on different filters
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then advance payment report is opened
    Then user select installment"JANUARY - MARCH" on advance payment report
    Then user select class"1" on advance payment report
    Then user select section"A" on advance payment report
    Then user select fee type"SCHOOL FEE" on advance payment report
    Then user click on show on advance payment report

  @scenario3
  Scenario: To test advance payment report based on different filters
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then advance payment report is opened
    Then user select installment"APRIL" on advance payment report
    Then user select class"1" on advance payment report
    Then user select section"A" on advance payment report
    Then user click on show on advance payment report
