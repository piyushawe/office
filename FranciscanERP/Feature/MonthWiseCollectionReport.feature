Feature: Franciscan ERP

  @scenario1
  Scenario: Month Wise Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then month wise collection report is opened
    Then user select entry mode "School" on month wise collection report
    Then select class "1" on month wise collection report
    Then user select installment "APRIL" on month wise collection report
    Then user click show on month wise collection report

  @scenario2
  Scenario: Month Wise Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then month wise collection report is opened
    Then user select entry mode "School" on month wise collection report
    Then user select fee type "SCHOOL FEE" on month wise collection report
    Then user select month "Jul" on month wise collection report
    Then select class "1" on month wise collection report
    Then user select installment "JULY - AUGUST" on month wise collection report
    Then user select bank name "Axsis Bank For Juniors" on month wise collection report
    Then select user "eCare Admin" on month wise collection report
    Then user click show on month wise collection report
