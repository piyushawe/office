Feature: Franciscan ERP

  @scenario1
  Scenario: Student Strength Ratio Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student strength ratio wise report is opened
    Then user select class "test1" on student strength ratio wise report
    Then user select section "A" on student strength ratio wise report
    Then user click show on student strength ratio wise report

  @scenario2
  Scenario: Student Strength Ratio Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student strength ratio wise report is opened
    Then user select class "test1" on student strength ratio wise report
    Then user select date to as month "July" year "2016" and day "31"on student strength ratio wise report
    Then user click details with new old student status on student strength ratio wise report
    Then user click show on student strength ratio wise report
