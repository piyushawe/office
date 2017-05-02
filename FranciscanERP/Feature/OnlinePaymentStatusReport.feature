Feature: Franciscan ERP

  @scenario1
  Scenario: Online Payment Status Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then online payment status report is opened
    Then user select from date as month "July" year "2016" and day "1" on online payment status report
    Then user select to date as month "August" year "2016" and day "31" on online payment status report
    Then clicks show button on online payment status report
