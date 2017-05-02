Feature: Franciscan ERP

  @scenario1
  Scenario: Print Transport ID Card
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then print transport ID card page is opened
    Then user select school "Inspiration public school" on print transport ID card page
    Then user select class "test1" on print transport ID card page
    Then user select section "A" on print transport ID card page
    Then user enter student "sonia1" on print transport ID card page
    Then user click show on print transport ID card page