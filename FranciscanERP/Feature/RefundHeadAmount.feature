Feature: Franciscan ERP

  @scenario1
  Scenario: Refund head amount
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then refund head amount page is opened
    Then user select session "2016-2017" on refund head amount page
    Then user searches a student of class "2" section "A" and text "aviral jain" on refund head amount page
    Then user select installment "APRIL" on refund head amount page
    Then user enter remarks on refund head amount page
    Then user refund amount on fee head "TUITION FEE" on refund head amount page