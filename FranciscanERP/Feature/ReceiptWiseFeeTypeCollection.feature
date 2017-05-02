Feature: Franciscan ERP

  @scenario1
  Scenario: Receipt Wise Fee Type Collection
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then receipt wise fee type collection report is opened
    Then user select school "Inspiration public school" on receipt wise fee type collection report
    Then user select fee type "SCHOOL FEE" on receipt wise fee type collection report
    Then user select date from as month "April" year "2016" and day "1" on receipt wise fee type collection report
    Then user select date to as month "April" year "2016" and day "30" on receipt wise fee type collection report
    Then user select user "eCare Admin" on receipt wise fee type collection report
    Then user click show on receipt wise fee type collection report

  @scenario2
  Scenario: Receipt Wise Fee Type Collection
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then receipt wise fee type collection report is opened
    Then user select school "Inspiration public school" on receipt wise fee type collection report
    Then user select class "1-A" on receipt wise fee type collection report
    Then user select fee type "SCHOOL FEE" on receipt wise fee type collection report
    Then user select pay mode "Cash" and "Cheque" on receipt wise fee type collection report
    Then user select date from as month "April" year "2016" and day "1" on receipt wise fee type collection report
    Then user select date to as month "April" year "2016" and day "30" on receipt wise fee type collection report
    Then user select user "eCare Admin" on receipt wise fee type collection report
    Then user select bank name "Axsis Bank For Juniors" on receipt wise fee type collection report
    Then user click student wise only on receipt wise fee type collection report
    Then user click show on receipt wise fee type collection report
