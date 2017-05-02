Feature: Franciscan ERP

  @scenario1
  Scenario: Defaulter List Fee Type Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then defaulter list fee type wise report is opened
    Then user select school"Inspiration public school" on defaulter list fee type wise report
    Then user select class"1-A" on defaulter list fee type wise report
    Then user select installment"JANUARY - MARCH" on defaulter list fee type wise report
    Then user click on show on defaulter list fee type wise report

  @scenario2
  Scenario: Defaulter List Fee Type Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then defaulter list fee type wise report is opened
    Then user select class"1-A" on defaulter list fee type wise report
    Then user select fee type"SCHOOL FEE" on defaulter list fee type wise report
    Then user select installment"JANUARY - MARCH" on defaulter list fee type wise report
    Then user select with fine on defaulter list fee type wise report
    Then user click on show on defaulter list fee type wise report

  @scenario3
  Scenario: Defaulter List Fee Type Wise
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then defaulter list fee type wise report is opened
    Then user select class"1-A" on defaulter list fee type wise report
    Then user select installment"JANUARY - MARCH" on defaulter list fee type wise report
    Then user select with fine on defaulter list fee type wise report
    Then user select with late fine bifurcated on defaulter list fee type wise report
    Then user click on show on defaulter list fee type wise report
