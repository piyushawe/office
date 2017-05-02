Feature: Franciscan ERP

  @scenario1
  Scenario: Assign transport to students
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign transport to students page is opened
    Then user select class "test1" on assign transport to students page
    Then user select section "A" on assign transport to students page
    Then assign transport to "sonia1" route "R01" stop "A1" vehicle "Bus" and months "All" on assign transport to students page
