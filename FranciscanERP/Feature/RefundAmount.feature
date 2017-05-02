Feature: Franciscan ERP

  @scenario1
  Scenario: Refund Amount Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then refund amount page is opened
    Then user select year as "2016-2017" on refund amount page
    Then user click on show on refund amount page

  @scenario2
  Scenario: Refund Amount Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then refund amount page is opened
    Then user select from date as month "April" year"2016" and day "20" on refund amount page
    Then user select to date as month "December" year"2016" and day "31"on refund amount page
    Then user select year as "2016-2017" on refund amount page
    Then user click on show on refund amount page
