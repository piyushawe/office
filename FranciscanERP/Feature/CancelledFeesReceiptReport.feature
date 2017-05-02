Feature: Cancelled Fees Receipt Report
   As a user I would like to open cancelled fee receipt report
   So that I don't have to open it myself

  Scenario: Cancelled Fees Receipt Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens cancelled fees receipt report page
    Then user selects from date as month"April" year"2017" and day"15"
    Then user selects to date as month"April" year"2017" and day"15"
    Then user clicks on show
    Then user enter name "sonia1" and click find on cancelled fees receipt report page
