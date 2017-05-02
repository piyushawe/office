Feature: Franciscan ERP

  @scenario1
  Scenario: Manual fee modification
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then manual fee modification page is opened
    Then user search student of class "1" section "A" and text "sonia1" on manual fee modification page
    Then user select installment "JULY - AUGUST" on manual fee modification page
    Then user select fee type "SCHOOL FEE" on manual fee modification page
    Then user enter reason to modify on manual fee modification page
    Then user select head "TERM FEE" with amount "1000"on manual fee modification page
    Then user click modify on manual fee modification page
