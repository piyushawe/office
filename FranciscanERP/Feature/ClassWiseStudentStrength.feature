Feature: Franciscan ERP

  @scenario1
  Scenario: Class Wise Student Strength Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class wise student strength page is opened
    Then user click row wise on class wise student strength page
    Then user select class "2" on class wise student strength page
    Then user check on new students on class wise student strength page
    Then user click show on class wise student strength page

  @scenario2
  Scenario: Class Wise Student Strength Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class wise student strength page is opened
    Then user select date wise on class wise student strength page
    Then user select date as month "April" year "2016" and day "10" on class wise student strength page
    Then user click column wise on class wise student strength page
    Then user select class "2" on class wise student strength page
    Then user click section wise on class wise student strength page
    Then user select section "A" on class wise student strength page
    Then user click show on class wise student strength page
