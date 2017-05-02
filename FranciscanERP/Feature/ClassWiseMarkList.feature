Feature: Franciscan ERP

  @scenario1
  Scenario: Class Wise Mark List
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class wise mark list is opened
    Then user select class "test1" on class wise mark list
    Then user select section "A" on class wise mark list
    Then user click show on class wise mark list
