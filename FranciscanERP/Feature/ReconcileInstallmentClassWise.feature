Feature: Franciscan ERP

  @scenario1
  Scenario: Reconcile Installment Class Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then reconcile installment class wise page is opened
    Then user select fee type "SCHOOL FEE" on reconcile installment class wise page
    Then user select class "test1" on reconcile installment class wise page
    Then user select installment "APRIL" on reconcile installment class wise page
    Then user click show on reconcile installment class wise page
    