Feature: Franciscan ERP

  @scenario1
  Scenario: Gender Religion Wise Student Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then gender religion wise student report page is opened
    Then user select religion"Hindu" on gender religion wise student report page
    Then user select class "5" on gender religion wise student report page
    Then user select section "A" on gender religion wise student report page
    Then user select gender"Male" on gender religion wise student report page
    Then user click show on gender religion wise student report page
