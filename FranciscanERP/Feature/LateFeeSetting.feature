Feature: Franciscan ERP

  @scenario1
  Scenario: Late Fee Setting
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then late fee setting page is opened