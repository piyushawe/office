Feature: Active Inactive Students Detail Report
   As a user 
   I would like to open active inactive students detail report
   So that I don't have to open myself

  @scenario1
  Scenario: To test active inactive students detail report based on the filters
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then active inactive students detail report is opened
    Then user select class "test1" on active inactive students detail report page
    Then user select section "A" on active inactive students detail report page
    Then user select from date as month "April" year "2016" and day"1" on active inactive students detail report page
    Then user select till date as month "May" year "2016" and day"30" on active inactive students detail report page
    Then user click active on active inactive students detail report page
    Then user click show on active inactive students detail report page

  @scenario2
  Scenario: To test active inactive students detail report based on the filters
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then active inactive students detail report is opened
    Then user select user "eCare Admin" on active inactive students detail report is opened
    Then user select from date as month "October" year "2016" and day"1" on active inactive students detail report page
    Then user select till date as month "November" year "2016" and day"30" on active inactive students detail report page
    Then user click inactive on active inactive students detail report page
    Then user click show on active inactive students detail report page
