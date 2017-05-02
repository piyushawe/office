Feature: Cheque Clearing Status Report
    As a user I would like to open cheque clearing status report
    So that I don't have to do it myself 

  @scenario1
  Scenario: To verify cheque clearing status report based on different filters
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then cheque clearing status report is opened
    Then user select entry mode "School" on cheque clearing status report
    Then user select from date as month"April" year "2016" and day"1" on cheque clearing status report
    Then user select to date as month"April" year "2016" and day"30" on cheque clearing status report
    Then user select class"1-A" on cheque clearing status report
    Then user select fee type "SCHOOL FEE" on cheque clearing status report
    Then user select bank name "Axsis Bank For Juniors" on cheque clearing status report
    Then user click head wise on cheque clearing status report
    Then user select clearing status "Cleared" on cheque clearing status report
    Then user click show on cheque clearing status report

  @scenario2
  Scenario: To verify cheque clearing status report based on different filters
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then cheque clearing status report is opened
    Then user select from date as month"April" year "2016" and day"1" on cheque clearing status report
    Then user select to date as month"April" year "2016" and day"30" on cheque clearing status report
    Then user select fee type "SCHOOL FEE" on cheque clearing status report
    Then user click receipt number range on cheque clearing status report
    Then user enter receipt from "9880" and receipt to "9910" on cheque clearing status report
    Then user click without head total amount on cheque clearing status report
    Then user click show on cheque clearing status report
