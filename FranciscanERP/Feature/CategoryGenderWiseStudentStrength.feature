Feature: Franciscan ERP

  @scenario1
  Scenario: Category Gender Wise Student Strength report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then category gender wise student strength report is opened
    Then user select class "4" on category gender wise student strength report
    Then user click on category wise category gender wise student strength report
    Then user click show on category gender wise student strength report

  @scenario2
  Scenario: Category Gender Wise Student Strength report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then category gender wise student strength report is opened
    Then user select class "7" on category gender wise student strength report
    Then user click gender wise on category gender wise student strength report
    Then user click show on category gender wise student strength report

  @scenario3
  Scenario: Category Gender Wise Student Strength report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then category gender wise student strength report is opened
    Then user select class "7" on category gender wise student strength report
    Then user check click for section wise checkbox on category gender wise student strength report
    Then user select section "A" on category gender wise student strength report
    Then user click on category and gender wise on category gender wise student strength report
    Then user click show on category gender wise student strength report
