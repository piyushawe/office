Feature: Franciscan ERP

  @scenario1
  Scenario: Daily Fee Collection report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection report is opened
    Then user select entry mode "School" on daily fee collection
    Then user select from date as month "February" year "2017" and day"1" on daily fee collection
    Then user select to date as month "February" year "2017" and day"28" on daily fee collection
    Then selects class"1-A" on daily fee collection
    Then user select fee type "SCHOOL FEE" on daily fee collection
    Then user select paymode as "Cash" and "Cheque" on daily fee collection
    Then user click head wise on daily fee collection
    Then clicks on show button of daily fee collection

  @scenario2
  Scenario: Daily Fee Collection report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection report is opened
    Then selects class"1-A" on daily fee collection
    Then select school"Inspiration public school" on daily fee collection
    Then select feetype"SCHOOL FEE" and"TRANSPORT" on daily fee collection
    Then click without head on daily fee collection
    Then clicks on show button of daily fee collection

  @scenario3
  Scenario: Daily Fee Collection report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection report is opened
    Then user select entry mode "School" on daily fee collection
    Then user select from date as month "February" year "2017" and day"1" on daily fee collection
    Then user select to date as month "February" year "2017" and day"28" on daily fee collection
    Then selects class"1-A" on daily fee collection
    Then user select fee type "SCHOOL FEE" on daily fee collection
    Then user select paymode as "Cash" and "Cheque" on daily fee collection
    Then user click with head one line on daily fee collection
    Then clicks on show button of daily fee collection

  @scenario4
  Scenario: Daily Fee Collection report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then daily fee collection report is opened
    Then selects class"1-A" on daily fee collection
    Then select feetype"SCHOOL FEE" and"TRANSPORT" on daily fee collection
    Then click without head one line data on daily fee collection
    Then user select user name "eCare Admin" on daily fee collection
    Then clicks on show button of daily fee collection
