Feature: Franciscan ERP

  @scenario1
  Scenario: ReconcileReport
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then reconcile report page is opened
    Then user select school "Inspiration public school" on reconcile report page
    Then user select class "5" on reconcile report page
    Then user select fee type "SCHOOL FEE" on reconcile report page
    Then user select installment "APRIL" on reconcile report page
    Then user select user "eCare Admin" on reconcile report page
    Then user click summary on reconcile report page
    Then user click show on reconcile report page

  @scenario2
  Scenario: ReconcileReport
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then reconcile report page is opened
    Then user select school "Inspiration public school" on reconcile report page
    Then user select class "1" on reconcile report page
    Then user select fee type "SCHOOL FEE" on reconcile report page
    Then user select installment "JULY - AUGUST" on reconcile report page
    Then user select user "eCare Admin" on reconcile report page
    Then user click consolidated on reconcile report page
    Then user click show on reconcile report page
