Feature: Franciscan ERP

  @scenario1
  Scenario: Paid Transport
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then paid transport report is opened
    Then user select route "R01" on paid transport report
    Then user select vehicle "Bus" on paid transport report
    Then user select date from as month "April" year "2016" and day "1" on paid transport report
    Then user select date to as month "April" year "2016" and day "1" on paid transport report
    Then user select user "eCare Admin" on paid transport report
    Then user click show on paid transport report

  @scenario2
  Scenario: Paid Transport
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then paid transport report is opened
    Then user select school "Inspiration public school" on paid transport report
    Then user select class "1-A" on paid transport report
    Then user select route "R01" on paid transport report
    Then user select vehicle "Bus" on paid transport report
    Then user select paymode "Cash" and "Cheque" on paid transport report
    Then user select installment "MAY - JUNE" on paid transport report
    Then user select date from as month "April" year "2016" and day "1" on paid transport report
    Then user select date to as month "April" year "2016" and day "1" on paid transport report
    Then user select user "eCare Admin" on paid transport report
    Then user click show on paid transport report
