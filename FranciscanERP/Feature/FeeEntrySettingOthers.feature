Feature: Franciscan ERP

  @scenario1
  Scenario: Fee Entry Setting Others
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee entry setting others page is opened