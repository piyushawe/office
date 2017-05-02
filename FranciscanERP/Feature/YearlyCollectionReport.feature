Feature: Franciscan ERP

  @scenario1
  Scenario: Yearly Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens yearly collection report page
    Then user select session"2016-2017" on yearly collection report
    Then user select class"1" on yearly collection report
    Then user select section "A" on yearly collection report
    Then user click on show on yearly collection report

  @scenario2
  Scenario: Yearly Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens yearly collection report page
    Then user select entry mode "School" on yearly collection report
    Then user select session"2016-2017" on yearly collection report
    Then user select class"1" on yearly collection report
    Then user select section "A" on yearly collection report
    Then user select fee type"SCHOOL FEE" on yearly collection report
    Then user select school"Inspiration public school" on yearly collection report
    Then user select pay mode as "Cash" and "Cheque" on yearly collection report
    Then user select bank name "Axsis Bank For Juniors" on yearly collection report
    Then user checks on filter with clearing date
    Then user click on show on yearly collection report
