Feature: Franciscan ERP

  @scenario1
  Scenario: Daily Fee Collection Account Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection account wise report is opened
    Then user select entry mode "School" on daily fee collection account wise report
    Then user select from date as month "April" year "2016" and day "1" on daily fee collection account wise report
    Then user select to date as month "April" year "2016" and day "30" on daily fee collection account wise report
    Then user select class "test1-A" on daily fee collection account wise report
    Then user select fee type "SCHOOL FEE" on daily fee collection account wise report
    Then user select pay mode "Cash" and "Cheque" on daily fee collection account wise report
    Then user select bank name "Axsis Bank For Juniors" on daily fee collection account wise report
    Then user click filter with cheque clearing date on daily fee collection account wise report
    Then user click head wise on daily fee collection account wise report
    Then user click show on daily fee collection account wise report

  @scenario2
  Scenario: Daily Fee Collection Account Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection account wise report is opened
    Then user select fee type "SCHOOL FEE" on daily fee collection account wise report
    Then user click filter with cheque clearing date on daily fee collection account wise report
    Then user click receipt no range on daily fee collection account wise report
    Then user enter receipt no from "9876" to "9987" on daily fee collection account wise report
    Then user click without head total amount on daily fee collection account wise report
    Then user click show on daily fee collection account wise report

  @scenario3
  Scenario: Daily Fee Collection Account Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection account wise report is opened
    Then user select fee type "SCHOOL FEE" on daily fee collection account wise report
    Then user click filter with cheque clearing date on daily fee collection account wise report
    Then user click with head one line data on daily fee collection account wise report
    Then user select user "eCare Admin" on daily fee collection account wise report
    Then user click show on daily fee collection account wise report

  @scenario4
  Scenario: Daily Fee Collection Account Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection account wise report is opened
    Then user select school "Inspiration public school" on daily fee collection account wise report
    Then user select fee type "SCHOOL FEE" on daily fee collection account wise report
    Then user click filter with cheque clearing date on daily fee collection account wise report
    Then user click without head one line data on daily fee collection account wise report
    Then user select user "eCare Admin" on daily fee collection account wise report
    Then user click show on daily fee collection account wise report
