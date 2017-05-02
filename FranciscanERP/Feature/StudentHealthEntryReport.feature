Feature: Franciscan ERP

  @scenario1
  Scenario: Student Health Entry Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student health entry report page is opened
    Then user select class "test1-A" on student health entry report page
    Then user click show on student health entry report page
    