Feature: Franciscan ERP

  @scenario1
  Scenario: Staff Ward List Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then staff ward list report page is opened
    Then user select class "5" on staff ward list report
    Then user select section "A" on staff ward list report
    Then user select staff ward "ARVIND" on staff ward list report
    Then user click show on staff ward list report
