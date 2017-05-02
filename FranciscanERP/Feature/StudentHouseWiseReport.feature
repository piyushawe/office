Feature: Franciscan ERP

  @scenario1
  Scenario: Student House Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student house wise report page is opened
    Then user select class"4" on student house wise report page
    Then user select house "Green" on student house wise report page
    Then user click active on student house wise report page
    Then user click show on student house wise report page

  @scenario2
  Scenario: Student House Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student house wise report page is opened
    Then user select class"1" on student house wise report page
    Then user click section wise on student house wise report page
    Then user select section"A" on student house wise report page
    Then user select house "red" on student house wise report page
    Then user click inactive on student house wise report page
    Then user click show on student house wise report page

  @scenario3
  Scenario: Student House Wise Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then student house wise report page is opened
    Then user select class"1" on student house wise report page
    Then user select house "red" on student house wise report page
    Then user select range"Less Than or Equal To <=" on student house wise report page
    Then user select age "9" on student house wise report page
    Then user click all on student house wise report page
    Then user click show on student house wise report page
