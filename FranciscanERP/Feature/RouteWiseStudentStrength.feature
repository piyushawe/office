Feature: Franciscan ERP

  @scenario1
  Scenario: Route Wise Student Strength
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then route wise student strength page is opened
    Then user select school "Inspiration public school" on route wise student strength page
    Then user select route "R01" on route wise student strength page
    Then user select class "test1" on route wise student strength page
    Then user select installment "MAY - JUNE" on route wise student strength page
    Then user click show on route wise student strength page
