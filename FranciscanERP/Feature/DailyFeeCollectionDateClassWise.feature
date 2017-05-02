Feature: Franciscan ERP

  @scenario1
  Scenario: Daily Fee Collection Date Class Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens daily fee collection date class wise report
    Then user select class"1" on daily fee collection date class wise report
    Then user select section"A" on daily fee collection date class wise report
    Then user click on show on daily fee collection date class wise report

  @scenario2
  Scenario: Daily Fee Collection Date Class Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens daily fee collection date class wise report
    Then user select class"1" on daily fee collection date class wise report
    Then user select section"A" on daily fee collection date class wise report
    Then user enter student"SURYANSH VINAYAK" on daily fee collection date class wise report
    Then user select order by"Slip No." on daily fee collection date class wise report
    Then user select user"eCare Admin" on daily fee collection date class wise report
    Then user click on show on daily fee collection date class wise report
