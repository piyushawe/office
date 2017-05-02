Feature: Franciscan ERP

  @scenario1
  Scenario: Estimated Transport Details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then estimated transport details page is opened
    Then user select school "Inspiration public school" on estimated transport details page
    Then user select route "R01" on estimated transport details page
    Then user select vehicle "Bus" on estimated transport details page
    Then user select class "1" on estimated transport details page
    Then user select installment "APRIL" on estimated transport details page
    Then user click show on estimated transport details page
