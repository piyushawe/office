Feature: Franciscan ERP

  @scenario1
  Scenario: Estimated Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then estimated collection report is opened
    Then user select school "Inspiration public school" on estimated collection report
    Then user select fee type "SCHOOL FEE" on estimated collection report
    Then user select user "eCare Admin" on estimated collection report
    Then user select report filter "Consolidate" on estimated collection report
    Then user click show on estimated collection report

  @scenario2
  Scenario: Estimated Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then estimated collection report is opened
    Then user select class "1-A" on estimated collection report
    Then user select fee type "SCHOOL FEE" on estimated collection report
    Then user select installment "APRIL" on estimated collection report
    Then user select till date as month "April" year "2016" and day "30" on estimated collection report
    Then user select report filter "Class Wise" on estimated collection report
    Then user click show on estimated collection report
