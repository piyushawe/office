Feature: Franciscan ERP

  @scenario1
  Scenario: Modify Fee Receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then modify fee receipt form is opened
    Then user search student by fee receipt no "9868" on modify fee receipt form
