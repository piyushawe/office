Feature: Franciscan ERP

  @scenario1
  Scenario: Fee Cheque Clearing
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens fee cheque clearing page
    Then user get details by receipt date as month"March" year"2016" and day"10"

  @scenario2
  Scenario: Fee Cheque Clearing
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens fee cheque clearing page
    Then user get details by cheque date as month"May" year"2016" and day"16"

  @scenario3
  Scenario: Fee Cheque Clearing
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens fee cheque clearing page
    Then user get details by cheque no"78965"
    Then user enter clearing date as month "March" year "2017" and day "21" on fee cheque clearing page
    Then user click save on fee cheque clearing page

  @scenario4
  Scenario: Fee Cheque Clearing
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens fee cheque clearing page
    Then user get details by deposit bank"Axsis Bank For Juniors"
