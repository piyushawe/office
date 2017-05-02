Feature: Franciscan ERP

  @scenario1
  Scenario: Student Register Date Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student register date wise report page is opened
    Then user select from date as month "April" year "2016" and day"5" on student register date wise report
    Then user select to date as month "May" year "2016" and day"15" on student register date wise report
    Then user select class "1" on student register date wise report
    Then user select section "A" on student register date wise report
    Then user click show on student register date wise report
