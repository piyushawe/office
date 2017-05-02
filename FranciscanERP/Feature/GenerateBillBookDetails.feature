Feature: Franciscan ERP

  @scenario1
  Scenario: Generate Bill Book Details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then user opens generate bill book details page
    Then user select school "Inspiration public school" on generate bill book details page
    Then user select class "1-A" on generate bill book details page
    Then user select installment "JULY - AUGUST" on generate bill book details page
    Then user search student "aditya ranjan" on generate bill book details page
    Then user select fee type "SCHOOL FEE" on generate bill book details page
    Then user click show on generate bill book details page
