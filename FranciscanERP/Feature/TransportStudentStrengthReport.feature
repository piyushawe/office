Feature: Franciscan ERP

  @scenario1
  Scenario: Transport Student Strength Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then transport student strength report is opened
    Then user select class "T1" on transport student strength report
    Then user select section "A" on transport student strength report
    Then user select route "R01" on transport student strength report
    Then user click show on transport student strength report
