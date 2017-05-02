Feature: Franciscan ERP

  @scenario1
  Scenario: TC Form
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then tc form is opened
    Then user select session "2016-2017" on tc form
    Then user enter student to search "alok kumar" on tc form
    Then user click get on tc form
    Then user select school board "ICSE" on tc form
    Then user select category "General" on tc form
    Then user select struck off date as month "March" year "2017" and day "29" on tc form
    Then user select character "Good" on tc form
    Then user select tc applying date as month "March" year "2017" and day "1" on tc form
    Then user click save on tc form
