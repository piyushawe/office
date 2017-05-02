Feature: Franciscan ERP

  @scenario1
  Scenario: Fees Concession Install HeadWise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fees concession install headwise page is opened
    Then user select school "Inspiration public school" on fees concession install headWise page
    Then user select class "test1" on fees concession install headWise page
    Then user select section "A" on fees concession install headWise page
    Then user select fee type "SCHOOL FEE" on fees concession install headWise page
    Then user click fee head wise on fees concession install headWise page
    Then user click paid concession on fees concession install headWise page
    Then user click assigned on fees concession install headWise page
    Then user click show on fees concession install headWise page

  @scenario2
  Scenario: Fees Concession Install HeadWise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fees concession install headwise page is opened
    Then user select school "Inspiration public school" on fees concession install headWise page
    Then user select class "test1" on fees concession install headWise page
    Then user select section "A" on fees concession install headWise page
    Then user select fee type "SCHOOL FEE" on fees concession install headWise page
    Then user click installment wise on fees concession page
    Then user select installment "APRIL" on fees concession install headWise page
    Then user select till date as month "April" year "2016" and day"30" on fees concession install headWise page
    Then user click entry time on fees concession install headWise page
    Then user click assigned on fees concession install headWise page
    Then user click show on fees concession install headWise page
