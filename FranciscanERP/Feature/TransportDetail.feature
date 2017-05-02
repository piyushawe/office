Feature: Franciscan ERP

  @scenario1
  Scenario: Transport Detail Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assigned transport detail report page is opened
    Then user select route"R01" on transport detail report page
    Then user select stop"A2" on transport detail report page
    Then user select class "test1" on transport detail report page
    Then user select vendor "Mayoor Travels" on transport detail report page
    Then user click show on transport detail report page

  @scenario2
  Scenario: Transport Detail Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assigned transport detail report page is opened
    Then user select route"R01" on transport detail report page
    Then user select stop"A1" on transport detail report page
    Then user select vehicle "Bus" on transport detail report page
    Then user select class "test1" on transport detail report page
    Then user select section "A" on transport detail report page
    Then user select installment"APRIL" on transport detail report page
    Then user click show on transport detail report page
