Feature: Franciscan ERP

  @scenario1
  Scenario: Daily Fee Collection Date Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection date wise report is opened
    Then user select entry mode "School" on daily fee collection date wise report
    Then user select from date as month "April" year "2016" and day "1" on daily fee collection date wise report
    Then user select to date as month "May" year "2016" and day "31" on daily fee collection date wise report
    Then user select class "1-A" on daily fee collection date wise report
    Then user select school "Inspiration public school" on daily fee collection date wise report
    Then user select fee type "SCHOOL FEE" on daily fee collection date wise report
    Then user select pay mode "Cash" and "Cheque" on daily fee collection date wise report
    Then user select bank name "Axsis Bank For Juniors" on daily fee collection date wise report
    Then user click show on daily fee collection date wise report

  @scenario2
  Scenario: Daily Fee Collection Date Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection date wise report is opened
    Then user select from date as month "December" year "2016" and day "1" on daily fee collection date wise report
    Then user select to date as month "December" year "2016" and day "31" on daily fee collection date wise report
    Then user select user "eCare Admin" on daily fee collection date wise report
    Then user click show on daily fee collection date wise report
