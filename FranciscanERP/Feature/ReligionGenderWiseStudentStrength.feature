Feature: Franciscan ERP

  @scenario1
  Scenario: Religion Gender Wise Student Strength report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then religion gender wise student strength report is opened
    Then user select class "1" on religion gender wise student strength report
    Then user check click for section wise checkbox on religion gender wise student strength report
    Then user select section "A" on religion gender wise student strength report
    Then user click religion wise on religion gender wise student strength report
    Then user click show on religion gender wise student strength report
    
  @scenario2
  Scenario: Religion Gender Wise Student Strength report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then religion gender wise student strength report is opened
    Then user select class "4" on religion gender wise student strength report
    Then user click gender wise on religion gender wise student strength report
    Then user click show on religion gender wise student strength report

  @scenario3
  Scenario: Religion Gender Wise Student Strength report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then religion gender wise student strength report is opened
    Then user select class "7" on religion gender wise student strength report  
    Then user click religion and gender wise on religion gender wise student strength report
    Then user click show on religion gender wise student strength report

    