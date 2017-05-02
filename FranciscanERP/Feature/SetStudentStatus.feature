Feature: Franciscan ERP

  @scenario1
  Scenario: Set student status
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set student status page is opened
    Then select class "1" on set student status page
    Then select section "A" on set student status page
    Then set student "123654" status as "old" on set student status page
