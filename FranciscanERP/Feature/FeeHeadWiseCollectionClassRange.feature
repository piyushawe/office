Feature: Franciscan ERP

  @scenario1
  Scenario: Fee Head Wise Collection Class Range Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee head wise collection class range report is opened
    Then user select entry mode "School" on fee head wise collection class range report
    Then user select from date as month "July" year "2016" and day "1" on fee head wise collection class range report
    Then user select to date as month "December" year "2016" and day "31" on fee head wise collection class range report
    Then user select class "1-A" on fee head wise collection class range report
    Then user select fee type "SCHOOL FEE" on fee head wise collection class range report
    Then user select school "Inspiration public school" on fee head wise collection class range report
    Then user select pay mode "Cash" and "Cheque" on fee head wise collection class range report
    Then user select user "eCare Admin" on fee head wise collection class range report
    Then user click show on fee head wise collection class range report
