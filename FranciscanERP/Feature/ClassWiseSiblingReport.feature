Feature: Franciscan ERP

  @scenario1
  Scenario: Class Wise Sibling Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class wise sibling report is opened
    Then user select class "2" on class wise sibling report
    Then user click on show on class wise sibling report

  @scenario2
  Scenario: Class Wise Sibling Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class wise sibling report is opened
    Then user select class "5" on class wise sibling report
    Then user select section"A" on class wise sibling report
    Then user click on show on class wise sibling report
