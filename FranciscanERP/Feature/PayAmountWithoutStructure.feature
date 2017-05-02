Feature: Franciscan ERP

  Scenario: Pay Amount without Structure
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then pay amount without structure form is opened
    Then user search a student by year"2016-2017" class"1" section"A" and text"aditya ranjan"
    Then user select exclusive head"Annual Function Fee"
    And give reason"test"
    And click add head and enter amount "1000"
    Then user click save on pay amount without structure form
    Then go back to the default page
    Then amount without structure report is opened
    Then user select class "1" on amount without structure report
    Then user select section "A" on amount without structure report
    Then user click show on amount without structure report
