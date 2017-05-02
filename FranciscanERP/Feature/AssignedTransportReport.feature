Feature: Franciscan ERP

  @scenario1
  Scenario: Student Register Date Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assigned transport report page is opened
    Then user select class"1" on assigned transport report page
    Then user select section"A" on assigned transport report page
    Then user select user "eCare Admin" on assigned transport report page
    Then user click show on assigned transport report page

  @scenario2
  Scenario: Student Register Date Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assigned transport report page is opened
    Then user select class"test1" on assigned transport report page
    Then user select section"A" on assigned transport report page
    Then user select month"May" on assigned transport report page
    Then user enter "sonia1" in search text box on assigned transport report page
    Then user click show on assigned transport report page
