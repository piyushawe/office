Feature: Franciscan ERP

  @scenario1
  Scenario: TC report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then tc report page is opened
    Then user enter from date as month "March" year "2017" and day "1" on tc report page
    Then user enter to date as month "March" year "2017" and day "31" on tc report page
    Then user select tc type "Generated TC" on tc report page
    Then user select order by "ISSUE DATE" on tc report page
    Then user click show on tc report page