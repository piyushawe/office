Feature: Franciscan ERP

  @scenario1
  Scenario: Daily Fee Collection Date Fee Group Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection date fee group wise report is opened
    Then user select entry mode "School" on daily fee collection date fee group wise report
    Then user select school "Inspiration public school" on daily fee collection date fee group wise report
    Then user select class "test1" on daily fee collection date fee group wise report
    Then user select fee type "SCHOOL FEE" on daily fee collection date fee group wise report
    Then user select pay mode "Cash" and "Cheque" on daily fee collection date fee group wise report
    Then user select from date as month "April" year "2016" and day "1" on daily fee collection date fee group wise report
    Then user select to date as month "April" year "2016" and day "1" on daily fee collection date fee group wise report
    Then user click full details on daily fee collection date fee group wise report
    Then user click show on daily fee collection date fee group wise report

  @scenario2
  Scenario: Daily Fee Collection Date Fee Group Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection date fee group wise report is opened
    Then user select school "Inspiration public school" on daily fee collection date fee group wise report
    Then user select class "test1" on daily fee collection date fee group wise report
    Then user select fee type "SCHOOL FEE" on daily fee collection date fee group wise report
    Then user select from date as month "April" year "2016" and day "1" on daily fee collection date fee group wise report
    Then user select to date as month "April" year "2016" and day "1" on daily fee collection date fee group wise report
    Then user select user "eCare Admin" on daily fee collection date fee group wise report
    Then user click summary on daily fee collection date fee group wise report
    Then user click show on daily fee collection date fee group wise report

  @scenario3
  Scenario: Daily Fee Collection Date Fee Group Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection date fee group wise report is opened
    Then user select school "Inspiration public school" on daily fee collection date fee group wise report
    Then user select class "test1" on daily fee collection date fee group wise report
    Then user select fee type "SCHOOL FEE" on daily fee collection date fee group wise report
    Then user select from date as month "April" year "2016" and day "1" on daily fee collection date fee group wise report
    Then user select to date as month "April" year "2016" and day "1" on daily fee collection date fee group wise report
    Then user click separated on daily fee collection date fee group wise report
    Then user click show on daily fee collection date fee group wise report
