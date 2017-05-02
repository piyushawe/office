Feature: Franciscan ERP

  @scenario1
  Scenario: Surname Wise Student Details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then surname wise student details report is opened
    Then user select class "1" on surname wise student details report
    Then user select section "B" on surname wise student details report
    Then user select admission no"AdmissionNo" and class"Class" in student on surname wise student details report
    Then user click show on surname wise student details report

  