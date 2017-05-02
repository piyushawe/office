Feature: Franciscan ERP

  @scenario1
  Scenario: Student Wise Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student wise collection report is opened
    Then user select class"5" on student wise collection report
    Then user select section"A" on student wise collection report
    Then user click on show on student wise collection report

  @scenario2
  Scenario: Student Wise Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student wise collection report is opened
    Then user select class"1" on student wise collection report
    Then user select section"A" on student wise collection report
    Then user fee type"SCHOOL FEE" on student wise collection report
    Then user select school"Inspiration public school" on student wise collection report
    Then user click on show on student wise collection report
