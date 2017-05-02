Feature: Franciscan ERP

  @scenario1
  Scenario: SMS Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then sms report page is opened
    Then user select from date as month "October" year"2016" and day "1" on sms report
    Then user select to date as month "January" year"2017" and day "31" on sms report
    Then user click on show on sms report

  @scenario2
  Scenario: SMS Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then sms report page is opened
    Then user select from date as month "May" year"2016" and day "15" on sms report
    Then user select to date as month "November" year"2016" and day "21" on sms report
    Then user select sms type "Cheque Bounce" on sms report
    Then user click on show on sms report
