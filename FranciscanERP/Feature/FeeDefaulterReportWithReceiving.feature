Feature: Franciscan ERP

  @scenario1
  Scenario: Fee Defaulter Report With Receiving
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee defaulter report with receiving page is opened
    Then user select class "test1" on fee defaulter report with receiving page
    Then user select section "A" on fee defaulter report with receiving page
    Then user select fee type "SCHOOL FEE" on fee defaulter report with receiving page
    Then user select installment "JULY - AUGUST" on fee defaulter report with receiving page
    Then user select till date as month "December" year"2016" and day "31" on fee defaulter report with receiving page
    Then user click with fine on fee defaulter report with receiving page
    Then user click show on fee defaulter report with receiving page

  @scenario2
  Scenario: Fee Defaulter Report With Receiving
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee defaulter report with receiving page is opened
    Then user select school "Inspiration public school" on fee defaulter report with receiving page
    Then user select class "1" on fee defaulter report with receiving page
    Then user select section "A" on fee defaulter report with receiving page
    Then user select installment "JULY - AUGUST" on fee defaulter report with receiving page
    Then user click date range on fee defaulter report with receiving page
    Then user select from date as month "November" year"2016" and day "1" on fee defaulter report with receiving page
    Then user select till date as month "December" year"2016" and day "31" on fee defaulter report with receiving page
    Then user click with fine on fee defaulter report with receiving page
    Then user click show on fee defaulter report with receiving page
