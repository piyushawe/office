Feature: Franciscan ERP

  @scenario1
  Scenario: Fees Defaulter Slip
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fees defaulter slip page is opened
    Then user select school "Inspiration public school" on fees defaulter slip page
    Then user select class "1" on fees defaulter slip page
    Then user select section "A" on fees defaulter slip page
    Then user select fee type "SCHOOL FEE" on fees defaulter slip page
    Then user select installment "JANUARY - MARCH" on fees defaulter slip page
    Then user click date range on fees defaulter slip page
    Then user select from date as month "March" year "2017" and day "1" on fees defaulter slip page
    Then user select to date as month "March" year "2017" and day "27" on fees defaulter slip page
    Then user click with fine on fees defaulter slip page
    Then user click show on fees defaulter slip page

  @scenario2
  Scenario: Fees Defaulter Slip
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fees defaulter slip page is opened
    Then user select class "1" on fees defaulter slip page
    Then user select section "A" on fees defaulter slip page
    Then user click date range on fees defaulter slip page
    Then user select from date as month "March" year "2017" and day "1" on fees defaulter slip page
    Then user select to date as month "March" year "2017" and day "27" on fees defaulter slip page
    Then user click show on fees defaulter slip page
