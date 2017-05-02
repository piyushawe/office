Feature: Franciscan ERP

  @scenario1
  Scenario: Student Wise Receipt Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student wise receipt report page is opened
    Then user select class "test1" on student wise receipt report page
    Then user select section "A" on student wise receipt report page
    Then user enter student "sonia1" to search on student wise receipt report page
    Then user select fee type "SCHOOL FEE" on student wise receipt report page
    Then user select from date as month "January" year "2017" and day "1" on student wise receipt report page
    Then user select to date as month "March" year "2017" and day "30" on student wise receipt report page
    Then user click show on student wise receipt report page
