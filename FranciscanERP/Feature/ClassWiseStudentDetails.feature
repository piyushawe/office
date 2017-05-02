Feature: Franciscan ERP

  @scenario1
  Scenario: Class Wise Student Details Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class wise student details report is opened
    Then user select school "Inspiration public school" on class wise student details
    Then user select class "1" on class wise student details
    Then user select section "A" on class wise student details
    Then user click on show on class wise student details
    
  @scenario2
  Scenario: Class Wise Student Details Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then class wise student details report is opened
    Then user select school "Inspiration public school" on class wise student details
    Then user select class "1" on class wise student details
    Then user select section "A" on class wise student details 
    Then user click is day scholar boarding show on report on class wise student details
    Then user click on show on class wise student details
