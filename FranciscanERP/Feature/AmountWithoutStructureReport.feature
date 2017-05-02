Feature: Franciscan ERP

  @scenario1
  Scenario: Amount Without Structure Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then amount without structure report is opened
    Then user select date from as month "April" year "2016" and day "1" on amount without structure report
    Then user select date to as month "April" year "2016" and day "30" on amount without structure report
    Then user select class "test1" on amount without structure report
    Then user select section "A" on amount without structure report
    Then user select school "Inspiration public school" on amount without structure report
    Then user select year "2016-2017" on amount without structure report
    Then user click cancel fee on amount without structure report
    Then user click show on amount without structure report
