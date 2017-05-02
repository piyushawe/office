Feature: Franciscan ERP

  @scenario1
  Scenario: Date Wise Admission Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then date wise admission report page is opened
    Then user select from date as month"April" year"2016" and day "1" on admission report page
    Then user select to date as month"May" year"2016" and day "31" on admission report page
    Then user select class"2" on admission report page
    Then user select section"A" on admission report page
    Then user click show on admission report page