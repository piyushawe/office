Feature: Franciscan ERP

  @scenario1
  Scenario: Group Wise Student Details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then group wise student details page is opened
    Then user select class "test1" on group wise student details page
    Then user select section "A" on group wise student details page
    Then user select group "I - II" on group wise student details page
    Then user click show on group wise student details page
