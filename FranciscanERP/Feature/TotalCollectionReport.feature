Feature: Franciscan ERP
@scenario1
  Scenario: Total Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then total collection report is opened
    Then user select class"1" on total collection report
    Then user select section"A" on total collection report
    Then user select installment"NOVEMBER - DECEMBER" on total collection report
    Then user click on show on total collection report

@scenario2
 Scenario: Total Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then total collection report is opened
    Then user select school"Inspiration public school" on total collection report
    Then user select class"1" on total collection report
    Then user select section"A" on total collection report
    Then user select fee type"SCHOOL FEE" on total collection report
    Then user select installment"NOVEMBER - DECEMBER" on total collection report
    Then user click on show on total collection report
    
@scenario3
Scenario: Total Collection Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then total collection report is opened
    Then user select school"Inspiration public school" on total collection report
    Then user select class"1" on total collection report
    Then user select section"A" on total collection report
    Then user select fee type"SCHOOL FEE" on total collection report
    Then user select installment"NOVEMBER - DECEMBER" on total collection report
    Then user select user"eCare Admin" on total collection report
    Then user click on show on total collection report