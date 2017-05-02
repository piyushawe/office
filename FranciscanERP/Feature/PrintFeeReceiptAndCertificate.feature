Feature: Franciscan ERP

  @scenario1
  Scenario: Print Fee Receipt and Certificate
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then print fee receipt and certificate page is opened
    Then user search by receipt no "9806" on print fee receipt and certificate page
    Then user click print receipt "9806" on print fee receipt and certificate page

  @scenario2
  Scenario: Print Fee Receipt and Certificate
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then print fee receipt and certificate page is opened
    Then user search by student details class "1" section "A" and name "aditya ranjan" on print fee receipt and certificate page
    Then user click print certificate "9940" on print fee receipt and certificate page

  @scenario3
  Scenario: Print Fee Receipt and Certificate
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then print fee receipt and certificate page is opened
    Then user search by student details class "1" section "A" and name "aditya ranjan" on print fee receipt and certificate page
    Then user click print receipt "9940" on print fee receipt and certificate page
