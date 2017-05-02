Feature: Franciscan ERP

  @scenario1
  Scenario: Fee Collection With Entry Time Concession
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee collection with entry time concession report is opened
    Then user select entry mode"School" on fee collection with entry time concession report
    Then user select collection date as month"April" year "2016" and day"15" on fee collection with entry time concession report
    Then user select school "Inspiration public school" on fee collection with entry time concession report
    Then user select fee type "SCHOOL FEE" on fee collection with entry time concession report
    Then user select pay mode "Cash" and "Cheque" on fee collection with entry time concession report
    Then user click without head on fee collection with entry time concession report
    Then user click show on fee collection with entry time concession report

  @scenario2
  Scenario: Fee Collection With Entry Time Concession
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee collection with entry time concession report is opened
    Then user select entry mode"School" on fee collection with entry time concession report
    Then user select collection date as month"April" year "2016" and day"15" on fee collection with entry time concession report
    Then user select school "Inspiration public school" on fee collection with entry time concession report
    Then user select fee type "SCHOOL FEE" on fee collection with entry time concession report
    Then user select pay mode "Cheque" on fee collection with entry time concession report
    Then user click receipt no range on fee collection with entry time concession report
    And enter from receipt no "9658" to receipt no "9700" on fee collection with entry time concession report
    Then user click with head on fee collection with entry time concession report
    Then user click show on fee collection with entry time concession report
