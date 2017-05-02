Feature: Franciscan ERP

  @scenario1
  Scenario: Student Fee Details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student fee details page is opened
    Then user searches a student by class "1" section "A" and student details "sonia1" on student fee details page
    Then user assign concession "50% Concession on Tuition Fees  JULY - AUGUST" on student fee details page
    

  @scenario2
  Scenario: Student Fee Details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student fee details page is opened
    Then user click on view button on student fee details page
    Then user search by entering text"aditya raj" on student fee details page
    Then user click on select on student fee details page

  @scenario3
  Scenario: Student Fee Details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student fee details page is opened
    Then user click on view button on student fee details page
    Then user click on close of view on student fee details page
