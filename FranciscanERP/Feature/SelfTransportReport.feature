Feature: Franciscan ERP

  @scenario1
  Scenario: Self Transport Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then self transport report page is opened
    Then user select transport "School"	on self transport report
    Then user select class "T1" on self transport report
    Then user select section "A" on self transport report
    Then user click active on self transport report
    Then user click show on self transport report

  @scenario2
  Scenario: Self Transport Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then self transport report page is opened
    Then user select class "T1" on self transport report
    Then user select section "A" on self transport report
    Then user click inactive on self transport report
    Then user click show on self transport report

  @scenario3
  Scenario: Self Transport Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then self transport report page is opened
    Then user select class "T1" on self transport report
    Then user select section "A" on self transport report
    Then user click all on self transport report
    Then user click show on self transport report
